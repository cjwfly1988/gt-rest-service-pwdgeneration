import java.util.*;
import java.util.stream.Collectors;

public class PasswordGenerator {
    boolean pwdGeneration = true;
    char[] password;
    private static final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String specialChar = "$&@?<>~!%#";
    private static final String digitChar = "0123456789";

    private Random random = new Random();
    private char[] specialCharacters;
    private char[] digitCharacters;

    private int numOfSpecial;
    private int numOfDigit;


    public String generateSpecialAndDigit(int numOfSpecial, int numOfDigit) {

        this.numOfSpecial = numOfSpecial;
        this.numOfDigit = numOfDigit;

        specialCharacters = new char[numOfSpecial];
        for (int i = 0; i < specialCharacters.length; i++) {
            char ch = specialChar.charAt(random.nextInt(specialChar.length()));
            specialCharacters[i] = ch;
        }

        digitCharacters = new char[numOfDigit];
        for (int i = 0; i < digitCharacters.length; i++) {
            char ch = digitChar.charAt(random.nextInt(digitChar.length()));
            digitCharacters[i] = ch;
        }

        char[] merged = new char[specialCharacters.length + digitCharacters.length];

        System.arraycopy(specialCharacters, 0, merged, 0, specialCharacters.length);
        System.arraycopy(digitCharacters, 0, merged, specialCharacters.length, digitCharacters.length);

        return new String(merged);
    }

    public String generateRandomStringWithLetters(int minimumPasswordLength) {


        Character[] lettersArray = symbols.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        List<Character> characterList = Arrays.asList(lettersArray);
        Collections.shuffle(characterList);

        int lengthOfRandomLetter = minimumPasswordLength - numOfDigit - numOfSpecial;
        List<Character> subCharacterList = characterList.subList(0, lengthOfRandomLetter);

        String randomLetterString = "";
        for (int i = 0; i < subCharacterList.size(); i++) {
            randomLetterString += subCharacterList.get(i).toString().replaceAll("(?i)[aeiou]", Integer.toString(i));
        }

        return randomLetterString;
    }

/*    public void checkVowel() {
        String samle = "Afbxc";

        samle = samle.replaceAll("(?i)[aeiou]", "3");
        System.out.println("after replace");
        System.out.println(samle);

    }*/

    public void printLetterWithCorrespondantNum() {
        char ch = 'h';
        System.out.println(ch - 'a' + 1);
        System.out.println('a' + 1);
    }
}
