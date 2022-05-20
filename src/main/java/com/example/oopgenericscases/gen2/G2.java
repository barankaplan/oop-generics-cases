package com.example.oopgenericscases.gen2;

public class G2 {
    public static void main(String[] args) {
        B b = new B();
        //upcasting
        A a = b;
        System.out.println(a.getClass().getName());


        a.foo("london");//foo in b
        a.bar("berlin");//bar in a
        //a.bar(); can't reach , not common

        B b2 = (B) a;//down-casting
        b2.bar();//can reach now

        a.foo(5); //error - calls foo(T t) Class B is constrained by the String type of A!
        a = new C();
        a.foo(5); //this one works!

        a.foo("error");//error calls foo(T t) Class C is constrained by the Integer type of A!
        //this is how we solve the errors above !
        A<Integer> integerA = new C();
        integerA.foo(5);
        // stringA.foo("error");//find the error at compile time ! thanks to the generics

    }
}

class A<T> {
    public void foo(T t) {
        System.out.println("foo in a");
        System.out.println(t);
    }

    public void bar(String s) {
        System.out.println("bar in a\n" + s );
    }

}

class B extends A<String> { // Class B is constrained by the String type of A!
    public void foo(String str) {
        System.out.println("foo in b");
        super.foo(str);//should be String
        System.out.println(str.toUpperCase());
    }

    public void bar() {
        System.out.println("bar in b");
    }

    @Override
    public void bar(String s) {
        super.bar(s);
    }
}

class C extends A<Integer> { // Class B is constrained by the Integer type of A!
    public void foo(Integer integer) {
        System.out.println("foo in c");
        super.foo(integer);//should be Integer
    }

    public void bar() {
        System.out.println("b bar");
    }
}
