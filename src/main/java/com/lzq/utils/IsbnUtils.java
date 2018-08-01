package com.lzq.utils;

import java.util.regex.Pattern;

public class IsbnUtils {
    public static boolean checkISBN(String str_ISBN) {
        //不满足978开头的13位数字这返回false
        if (!Pattern.matches("978[0-9]{10}", str_ISBN)) {
            return false;
        }
        int sumOdd = 0;//奇数位总和
        int sumEvn = 0;//偶数位总和
        for (int i = 0; i < str_ISBN.length() - 1; i++) {
            if (i % 2 == 0 == false) {
                sumOdd += str_ISBN.charAt(i) - 48;//奇数位
            } else {
                sumEvn += str_ISBN.charAt(i) - 48;//偶数位
            }
        }
        //奇数位总和自乘3
        sumOdd *= 3;
        int num13 = 10 - (sumOdd + sumEvn) % 10;
        num13 %= 10;
        if ((num13 + 48) == str_ISBN.charAt(str_ISBN.length() - 1)) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args){
        System.out.print(checkISBN("9787121320081"));
    }
}