package com.example.oopgenericscases.gen4;


import org.csystem.util.array.ArrayUtil;

import java.util.ArrayList;

public class G4 {
    //byte ->short -> int -> long -> float -> double
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 120; i < 130; ++i)
            list.add(i * 10); //auto-boxing

        for (int val : list) //auto-unboxing like double val : list  for (short val : list) //error
        {
            double a = val;
            byte b = (byte) val;
            System.out.printf("%f ", a);
            System.out.println(b);
        }


        System.out.println();

        //
        byte b1 = 120;//byte
        byte b = (byte) 128;//int to byte
        long c = 2147483647;//int value
        long l = 2147483648L;//not possible convert from int to long thats wyh we add L

            /*
            long number = 15000000000L;

            float mysecondnum = 5.75f;

            double mynumber = 19.99d;

            More info:

            The size of the long data type is 8 bytes.
            The size of the float data type is 4 bytes.
            It uses F or f as a suffix. It is mandatory to add a suffix if you are declaring a float variable.!!!
            The size of the double data type is 8 bytes.
             */


        ArrayList<int[]> arrayList = new ArrayList<>();

        arrayList.add(new int[]{1, 2, 3, 4});
        arrayList.add(new int[]{1, 3, 4});
        arrayList.add(new int[]{12, 32, 42});

        for (int[] a : arrayList) {
            for (int val : a)
                System.out.printf("%d ", val);

            System.out.println();
        }


    }
}
