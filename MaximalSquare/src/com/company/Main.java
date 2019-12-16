package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        char[][] matrix1 = {
            {'0' , '1'},
            {'1' , '0'}
        };

        char[][] matrix2 = {
                {'1' , '1'},
                {'1' , '1'}
        };

        char[][] matrix3 = {
                {'0' , '0'},
                {'0' , '0'}
        };

        char[][] matrix4 = {
                {'1' , '0'},
                {'0' , '0'}
        };

        char[][] matrix5 = {
                {'0' , '0', '0'},
                {'0' , '0', '0'},
                {'0' , '0', '0'},
                {'0' , '0', '1'}
        };

        char[][] matrix6 = {
                {'1','1','1','1','1','1'},
                {'1','1','1','1','1','1'},
                {'1','1','1','1','1','1'},
                {'1','1','1','1','1','0'},
                {'0','1','1','1','1','1'}
        };

        char[][] matrix7 = {
                {'0','0','0','0','0'},
                {'1','0','0','0','0'},
                {'0','0','0','0','0'},
                {'0','0','0','0','0'}
        };

        //System.out.println("Max Square " + new Solution().maximalSquare(matrix1));
        //System.out.println("Max Square " + new Solution().maximalSquare(matrix2));
        //System.out.println("Max Square " + new Solution().maximalSquare(matrix3));
        //System.out.println("Max Square " + new Solution().maximalSquare(matrix4));
        //System.out.println("Max Square " + new Solution().maximalSquare(matrix5));
        //System.out.println("Max Square " + new Solution().maximalSquare(matrix6));
        System.out.println("Max Square " + new Solution().maximalSquare(matrix7));
    }
}
