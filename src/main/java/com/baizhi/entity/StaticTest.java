package com.baizhi.entity;

public class StaticTest {
   public static int a=5;
   public String name="xiaohong";
   static {
       Dog d=new Dog();
       System.out.println(d);
   }

    public StaticTest(){
    }
    public StaticTest(String name, int a) {
        this.name = name;
        this.a=a;
    }
    public void increase(){
        a++;
    }
}
