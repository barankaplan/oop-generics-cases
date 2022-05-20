package com.example.oopgenericscases.gen1;
/*----------------------------------------------------------------------------------------------------------------------
    15.01.2022
	Generic kavramı derleme zamanında türden bağımsız kod yazabilmek için tasarlanmıştır. Programcı generic bir tür
	ya da metodu türden bağımsız olarak yazar. Generic tür ya da metotları kullanan programcı da hangi türde
	kullanacağına karar vererek aşağıda anlatılan özelliklere göre daha güvenli ve okunabilir kodlar yazabilir.
	Generic'ler kullanılarak derleme zamanında çok biçimli (compile time polymorphism) kodlar yazılabilmektedir.
	Generic olabilecek türler şunlardır: Sınıflar, arayüzler
----------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------
	Generic sınıf bildiriminde generic parametreler denilen isimler kullanılır. Bu isimler açısal parantezler arasında
	virgülle ayrılacak şekilde sınıf isminden sonra yazılır. Generic parametreler değişken isimlendirme kurallarına
	uygun isimlerdir. Bu isimler bildirildikleri sınıf boyunca geçerlidir (class scope, sınıf faaliyet alanı). Generic
	parametre ismi bir tür ismi anlamına gelir. Generic parametreler tür isimlerinin şablon biçimidir
----------------------------------------------------------------------------------------------------------------------*/
 class G1 {
    public static void main(String[] args) {
        B<Boolean> booleanB = new B<>();
        B<String> stringB = new B<>();
        A x = new A();

        // bb.UpperCase(true); lang.ClassCastException
        stringB.UpperCase("abc");

        System.out.println(x.getClass().getName());

        // upcasting
        x = booleanB;
        System.out.println(x.getClass().getName());
        x.toUpperCase("upcasting");

/*
        //down-casting
        B<Boolean> booleanB = (B) x;
        if (booleanB instanceof B){//B<Boolean> is not allowed
            booleanB.UpperCase(true);// lang.ClassCastException but bec of compile time polymorphism!
        }
 */


        //upcasting
        C<String> stringC = new D();
        stringC.foo("baran kaplan");

        C<Integer> integerC = new F();
        integerC.foo(5);

        //var val = (F) stringC; //this where the magic happens How do we preserve inter-types polymorphism? Use generics!


        //watch the example below it is not possible to make restriction
        Cv2 cv2= new Fv2();
        Dv2 dv2= (Dv2) cv2;
        dv2.bar();

    }
}


class Fv2 extends Cv2 {
    void foo(Integer integer) {
        super.foo(String.valueOf(integer * 2));
    }
}


class Dv2 extends Cv2 {
    @Override
    void foo(String s) {
        super.foo(s);
        System.out.println("we override a method which is a part of a specific type of a generic class ");
    }

    void bar() {
        System.out.println("bar");
    }
}


class Cv2 {
    void foo(String s) {
        System.out.println(s);
    }
}

class B<T> extends A {

    void UpperCase(T t) {
        super.toUpperCase((String) t);
    }
}


class A {
    void toUpperCase(String s) {
        System.out.println(s.toUpperCase());
    }
}

class F extends C<Integer> {
    @Override
    void foo(Integer integer) {
        super.foo(integer * 2);
    }
}


class D extends C<String> {
    @Override
    void foo(String s) {
        super.foo(s);
        System.out.println("we override a method which is a part of a specific type of a generic class ");
    }

    void bar() {
        System.out.println("bar");
    }
}


class C<T> {
    void foo(T t) {
        System.out.println(t);
    }
}
