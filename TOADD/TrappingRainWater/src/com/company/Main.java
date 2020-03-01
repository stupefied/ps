package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array1 = { 2, 0, 2};
        System.out.println(new Solution().trap(array1));

        int[] array0 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(array0));

        int[] array2= { 1, 0, 0, 1};
        System.out.println(new Solution().trap(array2));
    }
}
