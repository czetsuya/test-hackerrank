package com.czetsuyatech.tests;

public class InterfaceTest implements Interface1, Interface2 {

  public static void main(String[] args) {
    Interface2 i2 = new InterfaceTest();
    i2.fly(10);
  }

  @Override
  public void fly(int x) {
    System.out.println(x);
  }
}