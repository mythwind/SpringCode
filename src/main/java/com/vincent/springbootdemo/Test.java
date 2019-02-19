package com.vincent.springbootdemo;

import java.util.Scanner;

/**
 * @Auther: mythwind
 * @Date: 2019/02/18 15:36
 * @Description:
 */
public class Test {
    public static void main(String... asvg) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                double a = sc.nextDouble();
                System.out.println(a);
            }
        }
    }
}
