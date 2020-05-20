package cse2010.homework4;

/*
 * CSE2010 Homework #4
 * Problem 2: Fibonacci (Tail-Recursion)
 *
 * Complete the code below.
 *
 */

public class Fibonacci {

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return fib(n - 2) + fib(n - 1);
    }

    public static int fibIter(int n) {
        if (n <= 1)
            return n;

        int acc = 1;
        int prev = 0;

        while (n-- > 1) {
            int temp = acc;
            acc += prev;
            prev = temp;
        }

        return acc;
    }

    public static int fibTailRec(int n) {

        int fib0= 0, fib1=1, before, after, ans;

        if (n == 0 || n == 1){
            return n;
        }
        else {
            before = fib0;
            after =fib1;
            ans = fib0 + fib1;
            for (int i = 2; i < n+1; i++){
                    ans= before + after;
                    before = after;
                    after = ans;
            }
            return ans;
        }

        // Your code goes here ...

        // You may need to define a private, tail-recursive
        // helper method to call here ...

        /* private static int factTailRec(int acc, int n ){
        if (n <= 0)
            return acc;
        else
            return factRailRec(n* acc, n -1);
         */

    }


}
