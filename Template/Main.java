package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String s = "ADOBECODEBANC";
        String t = "ABC";

        new Solution().minWindow(s, t);

        s = "a";
        t = "aa";

        new Solution().minWindow(s, t);
    }
}
