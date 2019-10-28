package com.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser;

    @Before
    public void init() {
        parser = new Parser();
    }

    @Test
    public void testCreateParkingLotSucceed() {
        assertTrue(parser.createParkingLot(1));
    }

    @Test
    public void testCreateParkingLotFail() {
        parser.createParkingLot(1);

        assertFalse(parser.createParkingLot(1));
    }
}