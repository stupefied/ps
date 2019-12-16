package com.company;

class Solution {

    public int trap(int[] height) {

        if (height == null || height.length < 3) {
            return 0;
        }

        int submax = 0;
        int submaxj = -1;

        int sum = 0;

        for( int i = 0, j = 0; i < height.length && j < height.length ; j++ ) {

            //System.out.println("Start: [i:" + i + "][j:" + j + "] [Sum:" + sum + "][SubmaxJ:" + submaxj + "]");

            // if j'th is bigger or equal to i'th bar we can easily find out the sum between them
            if (height[j] >= height[i] && j > i) {
                sum += sumInclusive(height, i, j);
                i = j;

                submax = 0;
                submaxj = -1;
                continue;
            }

            if ( height[j] >= submax ) {
                submax = height[j];
                submaxj = j;
            }

            //when j val is the last value, we sum from i val to local maxima or upto j
            if (j == height.length - 1) {
                if (submaxj > 1) {
                    sum += sumInclusive(height, i, submaxj);
                }
                i = submaxj;
                j = submaxj;
                submax = 0;
                submaxj = -1;
            }
            //System.out.println("End: [i:" + i + "][j:" + j + "] [Sum:" + sum + "][SubmaxJ:" + submaxj + "]");
        }
        return sum;
    }

    public int sumInclusive(int[] height, int i, int j) {
        int min = Math.min(height[i],height[j]);
        int sum = 0;
        for (int k = i ; k <= j; k++) {
            sum += Math.max(min - height[k], 0);
        }
        //System.out.println("Sum inclusive called: [i:" + i + "][j:" + j + "] [Sum:" + sum + "]");
        return sum > 0 ? sum : 0;
    }
}
