package com.example.oopgenericscases.gen8;


//generic methods
//static bir seyi generic yapmamaya calis
class G8 {
    public static void main(String[] args) {
        Sample.foo("ankara"); //1("foo(String)");
        Sample.<String>foo("ankara"); //2("foo(String)");
        Sample.foo(10); //3 foo(int val)
        Sample.foo(3.4); //no Double goes to foo(T t)
        Sample.<Integer>foo(20); //5 foo(int val)

        System.out.println("--------");

        Mample.foo("ankara", true);
        Mample.foo(2.3, 's');
        Mample.foo(true, false);
        Mample<Integer> s = new Mample<>();

        s.bar(10, "london");
    }
}

class Sample {
    public static void foo(String s) {
        System.out.println("foo(String)");
    }

    public static void foo(int val) {
        System.out.println("foo(int)");
    }

    public static <T> void foo(T t) {
        System.out.println("foo(T)");
    }
}

class Mample<T> {
    private T m_t;

    // private static T ms_t; //error
    public void bar(T t) {
        System.out.println(t);
    }

//        public static void foo(T t) //error
//        {
//            System.out.println(t);
//        }

//    public static T bar() //error
//    {
//        return new T();
//    }
public static <T, K> void foo(T t, K k)
{
    System.out.println(t);
    System.out.println(k);
}

    public void foo(T t)
    {
        System.out.println(t);
    }

    public <K> void bar(T t, K k)
    {
        System.out.println("empty");
        System.out.println(k.getClass().getName());
    }
}

