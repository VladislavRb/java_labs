package com.company;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CosmicObjectTest {

    @org.junit.jupiter.api.Test
    void getName() {
        CosmicObject co = new CosmicObject("falseMoon", 10);
        String expected = "falseMoon";
        String actual = co.getName();
        Assert.assertEquals(expected, actual);
    }
}