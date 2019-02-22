package com.baizhi.entity;


public class Dog  {
    public static void main(String[] args) {
       StaticTest staticTest=new StaticTest();
       staticTest.name="xiaohuahua";
       staticTest.a=10;
       int a=staticTest.a;
        System.out.println("&&&&"+a);
       StaticTest staticTest1=new StaticTest();
       staticTest.name="heigege";
       int b=staticTest.a;
        System.out.println("****"+b);

    }
 }
