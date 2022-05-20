package com.example.oopgenericscases.gen7;

import java.util.ArrayList;

public class G7 {
   /*
   class A<T> { // T generic parametre
    //...
    private T m_t;
}


abstract class B<T, K, L> { //T, K ve L generic parametreler
    //...
    public abstract T foo(K k, L l);
}

    */

    //abstraction and generics

    //

    public static void main(String[] args) {
        A<String, Integer> a = new A<String, Integer>("66",55) {
            @Override
            public void converted() {
                super.converted();
            }
        };

        System.out.println("type name of the class is");
        System.out.println(a.getClass().getName());

        a.converted();

        System.out.println("another idea");

        ArrayList<String> cars = new ArrayList<>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);

        cars.add(new Cars().nameOfTheCar("Kaplan"));

        System.out.println(cars);

        //todo generic ve abstraction neden gerekli!

        Kaplan<String, Integer> kp = String::length;
        int val = kp.get("baran kaplan");
        System.out.println(val);


    }
}

class Cars {
    String nameOfTheCar(String car) {
        return car;
    }

}




abstract class  A<T, E> {
    private int a;
    private T m_t;// T generic parametre
    private E m_e;

    public  A(T m_t, E m_e) {
        this.m_t = m_t;
        this.m_e = m_e;

    }

    public A(int a) {
        this.a = a;
        System.out.println("as you can see a generic class also can be used with the help of a ctor!    " + a);
    }

    IStringToIntConverter<Integer> cter = Integer::parseInt;//functional

    public void converted() {
        System.out.println(m_t);
        int a = cter.convert((String) m_t);
        int b = cter.convert((String) m_e);
        System.out.println("this time it is an int variable");
        int val = (a + b);
        System.out.printf("total: %d%n ", val);


    }
}

interface IStringToIntConverter<I extends Number> {
    I convert(String s);
}


