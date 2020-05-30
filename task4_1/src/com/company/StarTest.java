package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarTest {

    @Test
    void testEquals() {
        Star sun1 = new Star("sun", 100, 20);
        Star sun2 = null;
        Star sun3 = new Star("sun", 100, 20);

        boolean expexted1 = false;
        boolean actual1 = sun1.equals(sun2);

        boolean expected2 = true;
        boolean actual2 = sun1.equals(sun3);

        Assert.assertEquals(expexted1, actual1);
        Assert.assertEquals(expected2, actual2);
    }
}