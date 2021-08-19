package com.firstapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchUtilsTest extends Object {
    MatchUtils mathutils;
    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This runs before all..");
    }
    @BeforeEach
    void init(){
        mathutils = new MatchUtils();    //this runs before each test case, hence reduces code redundancy
    }
    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up....");
    }
          @Test
        void test(){
             // MatchUtils mathutils= new MatchUtils(); //Repeated: could be avoided
              int expected=2;
              int actual= mathutils.add(1,1);
              assertEquals(expected,actual,"This method should add two numbers");
          }
          @Test
          void testDivide(){
             // MatchUtils matchUtils=new MatchUtils();
              int expected=1;
              int actual= mathutils.divide(2,2);
              assertEquals(expected,actual,"This should divide two numbers.");
              //assertThrows(NullPointerException.class, () -> mathutils.divide(1,0),"Divide by zero should throw exception.");
          }
          @Test
        void testComputeCircleRadius()
          {
              //MatchUtils matchUtils=new MatchUtils();
              assertEquals(314.1592653589793,mathutils.computeCircleArea(10),"Should return area of a circle.");
          }
}