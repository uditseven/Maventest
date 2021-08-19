package com.firstapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //is stated this static keyword is no more required
class MatchUtilsTest extends Object {
    MatchUtils mathutils;
    TestInfo testInfo;
    TestReporter testReporter;
   /* @BeforeAll
    void beforeAllInit(){    //static  keyword before void is removed
        System.out.println("This runs before all..");
    } */
    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathutils = new MatchUtils();    //this runs before each test case, hence reduces code redundancy
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }
    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up....");
    }
          @Test
          @DisplayName("Testing add method")
          @RepeatedTest(3)   //repeated test of a specific test; if one of them fails whole method fails
          @Tag("Math")
        void test(){
             // MatchUtils mathutils= new MatchUtils(); //Repeated: could be avoided
              int expected=2;
              int actual= mathutils.add(1,1);
              assertEquals(expected,actual,"This method should add two numbers");
          }
          @Test
          @DisplayName("Testing divide method")
          @Tag("Math")
          void testDivide(){
             // MatchUtils matchUtils=new MatchUtils();
              int expected=1;
              int actual= mathutils.divide(2,2);
              assertEquals(expected,actual,"This should divide two numbers.");
              //assertThrows(NullPointerException.class, () -> mathutils.divide(1,0),"Divide by zero should throw exception.");
          }
          @Nested    //used for grouping similar test cases; if any test fails whole class will fail

          class areaCalculate {
              @Test
              @DisplayName("Testing area of circle method")
              @Tag("Circle")
              void testComputeCircleRadius() {
                  //MatchUtils matchUtils=new MatchUtils();
                  assertEquals(314.1592653589793, mathutils.computeCircleArea(10), "Should return area of a circle.");
              }

          }
          @Test
          @Disabled
          @DisplayName("TDD.. This should not run")
          void testDisabled(){
        fail("This test is disabled");
          }
         /* @Test
          @DisplayName("Testing working method")
           void testDivide_1(){
                  boolean isServerUp = true;
                  assumeTrue(isServerUp);
                  assertThrows(NullPointerException.class, () -> mathutils.divide(1,0),"Divide by zero should throw exception.");
          }  */
          @Test
          @DisplayName("Multiply method")  //testing multiple assumptions simultaneously; used when all conditions needs to be passed
          @Tag("Math")
          void testMultiply(){
              testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
          assertAll(
                  () -> assertEquals(4,mathutils.multiply(2,2)),
                  () -> assertEquals(0,mathutils.multiply(2,0)),
                  () -> assertEquals(-2,mathutils.multiply(2,-1))
          );
          }
         }