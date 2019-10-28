package com.parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car;
    String TEST_COLOR = "test-color";
    String TEST_REGNUM = "test-regnum";
    int TEST_SLOTNUM = 123;

    @Before
    public void init() {
        car = new Car(TEST_REGNUM, TEST_COLOR);
    }

    @Test
    public void testGetRegNum() {
        assertEquals(TEST_REGNUM, car.getRegNum());
    }

    @Test
    public void testGetColor() {
        assertEquals(TEST_COLOR, car.getColor());
    }

    @Test
    public void testDefaultAllocatedSlot() {
        assertEquals(-1, car.getAllocatedSlotNumber());
    }

    @Test
    public void testSetAllocatedSlotNumber() {
        car.setSlotNumber(TEST_SLOTNUM);

        assertEquals(TEST_SLOTNUM, car.getAllocatedSlotNumber());
    }
}