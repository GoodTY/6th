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
        int count = 0;
        for(int i =0; i<array_word.length; i++) {
            if (isAlpha(array_word[i]) == true) {
                array_word[count] = as.charAt(i);
                count++;
            } // isAlpha == false -> It does not add 1 to count.
        }
        // input " Hel1o" -> array_word = [H, e, l, o]


        // your code goes here ...

        return false;
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
