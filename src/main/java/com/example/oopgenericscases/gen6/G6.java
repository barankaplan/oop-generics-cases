package com.example.oopgenericscases.gen6;

import java.util.ArrayList;
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıfın türemiş sınıf açılımı aynı generic sınıfın taban sınıf açılımına doğrudan atanamaz (invariant)
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Generic bir sınıfın türemiş sınıf açılımı aynı generic sınıfın taban sınıf açılımına tür dönüştürme operatörü ile de
	dönüştürülemez (invariant)
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------------
	Yukarıdaki durum ? extends ile aşağıdaki gibi çözülebilir (covariant)
----------------------------------------------------------------------------------------------------------------------*/


//invariant - covariant - contravariant
public class G6 {
    public static void main(String[] args) {
        mthd1(new A());


        ArrayList<A> aArrayList = new ArrayList<>();


        Sample.display(new A());//upcasting


        //Sample.display(list); //error - invariant - more specific
        /*
        Required type:
        ArrayList
        <B>

        Provided:
        ArrayList
        <A>
         */


        Sample.displayV2(aArrayList);//this one works covariant
        ArrayList<B> list = new ArrayList<>();

        //Sample.displayV3(list);//try to use something more general error !
        Sample.displayV4(list);//try to use something more general -contravariant !
    }

    private static void mthd1(B b) {
        b.foo();
    }

}

class A extends B {
    void foo() {
        System.out.println("foo in a");
    }
}

class B {
    void foo() {
        System.out.println("foo in b");
    }

}

class Sample {
    public static void display(ArrayList<B> list) {
        for (B n : list)
            System.out.println(n);
    }

    public static void displayV2(ArrayList<? extends B> list) {
        for (B n : list)
            System.out.println(n);
    }

    public static void displayV3(ArrayList<A> list) {
        for (A n : list)
            System.out.println(n);
    }

    public static void displayV4(ArrayList<? super A> list) {
        for (Object n : list)
            System.out.println(n);
    }

    public static void display(B b) {
        System.out.println(b);
    }
}