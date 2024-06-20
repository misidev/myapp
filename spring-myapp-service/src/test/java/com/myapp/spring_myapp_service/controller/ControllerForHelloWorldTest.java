//package com.example.demo.controller;
//
//import com.example.demo.advice.controller.ControllerForHelloWorld;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
//
//class ControllerForHelloWorldTest {
//    private static final Logger LOGGER = LogManager.getLogger(ControllerForHelloWorldTest.class);
//
//    @BeforeEach
//    void setUp() {
//
//        LOGGER.info("Test started");
//        long startTime = System.currentTimeMillis();
//        startTime = System.currentTimeMillis();
//        System.out.println("start time is: " + startTime + "ms");
//    }
//
//    @Test
//    void testControllerForHelloWorldExists() {
//        //tests whether class exists
//        try {
//            Class a = Class.forName("com.example.demo.advice.controller.ControllerForHelloWorld");
//            Assert.assertNotEquals("Test passed - class exists", a, null);
//        } catch (AssertionError | ClassNotFoundException e) {
//            assert false : "Test failed - class does not exist";
//            e.printStackTrace();
//        }
//
//    }
//
//    @Test
//    void hello() {
//        //tests whether returns correct String
//        ControllerForHelloWorld hw = new ControllerForHelloWorld();
//        String expected = "Hello World";
//        try {
//            assertEquals("Test passed", hw.getHello(), expected);
//        } catch (AssertionError e) {
//            assert false : "Test failed";
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test
//    void helloEmpty() {
//        //tests whether returns empty string
//        ControllerForHelloWorld hw = new ControllerForHelloWorld();
//        String expected = null;
//        try {
//            assertNotEquals("Test passed - Returning Hello World, not null", hw.getHello(), expected);
//        } catch (AssertionError e) {
//            assert false : "Test failed - returning null";
//            e.printStackTrace();
//        }
//
//    }
//
//    @AfterEach
//    void tearDown() {
//
//        LOGGER.info("Test ended");
//        long startTime = System.currentTimeMillis();
//        startTime = System.currentTimeMillis();
//        System.out.println("end time is: " + startTime + "ms");
//    }
//
//}