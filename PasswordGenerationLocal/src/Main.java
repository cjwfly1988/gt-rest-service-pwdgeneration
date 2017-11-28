public class Main {

    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
//        passwordGenerator.showPwd(3);

        for (int i = 0; i < 99; i++) {
            String randomStringWithLetters = passwordGenerator.generateRandomStringWithLetters(10);
            String specialAndDigit = passwordGenerator.generateSpecialAndDigit(3, 2);
            System.out.println(i + "shows : " + specialAndDigit + randomStringWithLetters);
        }


//        passwordGenerator.printLetterWithCorrespondantNum();
    }
}
