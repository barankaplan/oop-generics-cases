package com.example.oopgenericscases.gen9;

class G9 {
    public static void main(String [] args)
    {
        Sample<Integer, Float> s;

        s = new Sample<>();
        s.foo(10, 3.4F);
        s.bar("london", true);
    }
}

class Sample<T, K> {
    //...
    public void foo(T t, K k)
    {
        System.out.println("foo");
        System.out.println(t);
        System.out.println(k);
    }

    public <T, K> void bar(T t, K k)//differetn T and K !
    {
        System.out.println("bar");
        System.out.println(t);
        System.out.println(k);
    }
}
