package com.example.utilsmoudle.arithmetic;

/**
 * Created by huixing on 2017/10/24.
 */

public class pingfanghe {

    public static void main(String ... args){

        boolean b = cheumOfSquareNumbers(62);
        System.out.println(b);

    }

    public static boolean cheumOfSquareNumbers(int num) {

        for (int i = 0; i < num / 2; i++) {
            int p1 = i * i;
            if (p1 > num) {
                return false;
            } else {
                int p2 = num - p1;
                double sqrt = Math.sqrt(p2);
                int l = (int) sqrt;
                double v = sqrt - l;
                if (v == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
