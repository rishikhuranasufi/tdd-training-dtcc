package com.infosys.training.tdd.basics;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    // Show failing more ..
    // Slide creating .. for three modes ..
    //
    @Test
    public void testArea() throws Exception{
        Square square = new Square(3.0);
        assertEquals(9.0, square.area(),0.0);
    }

    @Test
    public void testAreaWithZero() throws Exception{
        Square square = new Square(0.0);
        assertEquals(0.0, square.area(),0.0);
    }

    @Test
    public void testAreaWithOne() throws Exception{
        Square square = new Square(1.0);
        assertEquals(1.0, square.area(),0.0);
    }

}