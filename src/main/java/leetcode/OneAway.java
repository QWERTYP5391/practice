package leetcode;

public class OneAway {

    public static void main(String[] args) {
        Boolean testOne = check("pale", "ple");
        Boolean testTwo = check("pale", "bale");

        System.out.println("The first test is " + testOne);
        System.out.println("The second test is " + testTwo);
    }

    public static Boolean check(String str1, String str2) {
        int firstStringLength = str1.length();
        int secondStringLength = str2.length();

        boolean result;

        if (firstStringLength + 2 <= secondStringLength || secondStringLength + 2 <= firstStringLength) {
            return false;
        }
        if (firstStringLength == secondStringLength) {
            int differentCharacters = 0;
            for (int i = 0; i < firstStringLength; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    differentCharacters++;
                }
            }
            result = computeBasedOnAmountOfDifferentCharacters(differentCharacters);
        } else {
            if (firstStringLength > secondStringLength) {
                result = getResult(str2, str1, firstStringLength);

            } else {
                result = getResult(str1, str2, secondStringLength);
            }
        }
        return result;
    }

    private static boolean getResult(String str1, String str2, int secondStringLength) {
        boolean result;
        int differentCharacters = getDifferentCharacters(str1, str2, secondStringLength);
        result = computeBasedOnAmountOfDifferentCharacters(differentCharacters);
        return result;
    }

    private static int getDifferentCharacters(String str1, String str2, int length) {
        int differentCharacters = 0;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (counter < str1.length() && str2.charAt(i) != str1.charAt(counter)) {
                differentCharacters++;
            } else {
                counter++;
            }
        }
        return differentCharacters;
    }

    private static boolean computeBasedOnAmountOfDifferentCharacters(int differentCharacters) {
        if (differentCharacters > 1) {
            return false;
        }
        return true;
    }
}
