package hello;


import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class User {

    private static final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String digitChars = "0123456789";
    private static final String specialChars = "$&@?<>~!%#";

    private Random random = new Random();

    private int numOfSpecial;
    private int numOfDigit;

    public String generateStringWithDigitAndSpecial(int numOfSpecial, int numOfDigit) {
        this.numOfSpecial = numOfSpecial;
        this.numOfDigit = numOfDigit;

        char[] specialCharsArray = generateRandomCharArray(random, numOfSpecial, specialChars);
        char[] digitCharsArray = generateRandomCharArray(random, numOfDigit, digitChars);


        char[] merged = new char[numOfDigit + numOfSpecial];

        System.arraycopy(specialCharsArray, 0, merged, 0, specialCharsArray.length);
        System.arraycopy(digitCharsArray, 0, merged, specialCharsArray.length, digitCharsArray.length);

        return new String(merged);
    }

    public String generateRandomLetterString(int passwordMinLength) {
        //java8 convert string to character array and then shuffle as a list
        Character[] lettersArray = symbols.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        List<Character> characterList = Arrays.asList(lettersArray);
        Collections.shuffle(characterList);

        int lengthOfRandomLetter = passwordMinLength - numOfDigit - numOfSpecial;
        List<Character> subCharacterList = characterList.subList(0, lengthOfRandomLetter);

        String randomLetterString = "";
        //convert vowel to number by using regx
        for (int i = 0; i < subCharacterList.size(); i++) {
            randomLetterString += subCharacterList.get(i).toString().replaceAll("(?i)[aeiou]", Integer.toString(i));
        }

        return randomLetterString;
    }

    private char[] generateRandomCharArray(Random random, int limitNumber, String inputResource) {
        char[] result = new char[limitNumber];

        for (int i = 0; i < limitNumber; i++) {
            char ch = inputResource.charAt(random.nextInt(inputResource.length()));
            result[i] = ch;
        }
        return result;
    }

}
