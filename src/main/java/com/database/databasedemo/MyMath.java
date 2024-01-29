package com.database.databasedemo;

public class MyMath {

    public int sumArray(int[] array){
        int sum = 0;
        for(int number : array){
            sum+=number;
        }
        return sum;
    }
}
