package com.example.oopgenericscases.gen5;

import java.util.ArrayList;
//a basic generic approach
public class G5 {
    public static void main(String [] args)
    {
        StringToLengthConverter stringToLengthConverter = new StringToLengthConverter();
        ArrayList<String> cities = new ArrayList<>();

        cities.add("berlin");
        cities.add("istanbul");
        cities.add("london");
        cities.add("rome");

        for (String city : cities)
            System.out.printf("%d ", stringToLengthConverter.convert(city));

        System.out.println();
    }
}

class StringToLengthConverter implements IConverter<String, Integer> {
    //...
    public Integer convert(String str)
    {
        return str.length();
    }
}

interface IConverter<T, R> {
    R convert(T t);
}
