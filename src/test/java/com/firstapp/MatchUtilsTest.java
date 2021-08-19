package com.firstapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchUtilsTest extends Object {
          @Test
        void test(){
              MatchUtils mathutils= new MatchUtils();
              int expected=2;
              int actual= mathutils.add(1,1);
              assertEquals(expected,actual,"This method should add two numbers");
          }
          @Test
          void testDivide(){
              MatchUtils matchUtils=new MatchUtils();
              int expected=1;
              int actual= matchUtils.divide(2,2);
              assertEquals(expected,actual,"This should divide two numbers.");
          }
          @Test
        void testComputeCircleRadius()
          {
              MatchUtils matchUtils=new MatchUtils();
              assertEquals(314.1592653589793,matchUtils.computeCircleArea(10),"Should return area of a circle.");
          }
}