package com.test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestArg {


  public void test(String name,String age){

  }

  public static void main(String[] args) throws Exception{
    Method test = TestArg.class.getMethod("test", String.class, String.class);
    for (Parameter parameter : test.getParameters()) {
      System.out.println(parameter.getName());
    }
  }
}
