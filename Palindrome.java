package cse2010.homework4;

/*
 * CSE2010 Homework #4
 * Problem 1: Palindrome
 *
 * Complete the code below.
 *
 */

public class Palindrome {

    public static boolean isPalindrome(String target) {

        return isPalindrome(target, 0, target.length() - 1);
    }

    private static boolean isPalindrome(String as, int start, int end) {
        char[] array_word = new char[as.length()];
        int count = start;
        for(int i =0; i<array_word.length; i++) {
            if (isAlpha(array_word[i]) == true) {
                array_word[count] = as.charAt(i);
                count++;
            } // isAlpha == false -> It does not add 1 to count.
        }
        // input " Hel1o" -> array_word = [H, e, l, o]
        for (int i=0; i < array_word.length; i++){
            array_word[i] = (char)toLower(array_word[i]);
        }
        //input array_word = [H, e, l, o] -> array_word = [h, e, l, o]
        if (array_word.length%2 == 0) { // even
            int dif = 0;
            for (int i = 0; i < ((array_word.length / 2)); i++) {
                if (array_word[start + i] != (array_word[array_word.length - i])) {
                    dif++;
                }
            }

            if (dif == 0) {
                return true;
            } else {
                return false;
            }
        }
        else { // odd
            int dif = 0;
            for (int i = 0; i < ((array_word.length / 2) - 1); i++) {
                if (array_word[start + i] != (array_word[array_word.length - i])) {
                    dif++;
                }
            }

            if (dif == 0) {
                return true;
            } else {
                return false;
            }
        }
        //distinguish even or odd. first try

        // your code goes here ...
    }

    private static boolean isAlpha(final char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
            return true;
        else
            return false;
    }

    private static int toLower(char c) {
        if ((c >= 'A') && (c <= 'Z'))
            return c + ('a' - 'A');
        return c;
    }

}
