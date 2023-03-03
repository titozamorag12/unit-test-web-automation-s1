package com.corecodeqa;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestTestNgSetup {
    @Test
    public void testSetup() {
        String str = "TestNG is working";
        assertEquals("TestNG is working", str);
    }
}