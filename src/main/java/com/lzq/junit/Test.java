package com.lzq.junit;

//import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void callBack(List<Integer> nums,List<Integer> bools){

        for(int index = 0;index<10;index++){
            if(bools.get(index)==1){
                System.out.print(nums.get(index));
            }
        }
        System.out.println();
    }

    private static String[] inputBools(Scanner sc) {
        System.out.println("请输入布尔数组(0/1)：");

        String input=sc.nextLine();
        return input.split("\\s+");
    }

    public static void main(String[] args){
        List<Integer> nums =  new ArrayList(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        List<Integer> boolList = new ArrayList();
        Scanner sc = new Scanner(System.in);

        String[] chars = inputBools(sc);
           if(chars.length!=10){
               System.out.print("您输入的长度不匹配，请重新输入：");
               boolList.clear();
               chars = inputBools(sc);
           }
            for(int i=0;i<10;i++) {
               int bool = Integer.parseInt(chars[i]);

            while(bool!=1&&bool!=0) {
                System.out.print("您输入的不是布尔，长度不匹配，请重新输入：");
                boolList.clear();
                chars = inputBools(sc);
            }
                boolList.add(bool);
        }

        for(int i=0;i<10;i++){
            if(boolList.get(i)==0){
                callBack(nums,boolList);
                boolList.set(i,1);
                callBack(nums,boolList);
            }
        }
    }
}
