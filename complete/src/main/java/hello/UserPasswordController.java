package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserPasswordController {

    private User user;

    @Autowired
    public UserPasswordController(User user) {
        this.user = user;
    }

    //default value requires at least 1 character for the password
    @RequestMapping(value = "/generatePwd", method = RequestMethod.GET)
    public String requestPassword(@RequestParam(name = "pwdlenth") int passwordLength,
                                  @RequestParam(name = "numOfSpecial", defaultValue = "1") int numberOfSpecialChar,
                                  @RequestParam(name = "numOfDigit", defaultValue = "1") int numberOfDigitChar) {

        if (passwordLength <= numberOfDigitChar || passwordLength <= numberOfSpecialChar) {
            throw new IllegalArgumentException();
        }

        return user.generateStringWithDigitAndSpecial(numberOfSpecialChar, numberOfDigitChar)
                + user.generateRandomLetterString(passwordLength);
    }

}
