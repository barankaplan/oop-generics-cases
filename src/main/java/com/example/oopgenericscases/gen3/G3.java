package com.example.oopgenericscases.gen3;


public class G3 {
    public static void main(String [] args)
    {
        B<Integer, String> x = new B<>();
        A<String> y;

        y = x;
        x.bar(10, "london");
        x.foo("berlin");
        x.tar(5);
        y.foo("istanbul");

        D<Double> doubleD=new D<>();
        D<Integer>  integerD=new D<>();
    }
}

class  D < T extends Number>{

}

class A<T> {
    public void foo(T t)
    {
        System.out.println(t);
    }
}

    // class B can be opened with a type that supports the Integer class
class B<T extends Integer, K> extends A<K> implements C<T>{//Type parameter 'T' is not within its bound; should extend 'java.lang.Double'
    public void bar(T t, K k)
    {
        System.out.println(t);
        System.out.println(k);
    }

    @Override
    public void tar(T t) {
        System.out.println(t.compareTo(5));
    }
}

interface C <C extends Number> {
    void tar(C c);

}

