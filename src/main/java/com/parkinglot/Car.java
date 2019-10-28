package com.parkinglot;

public class Car {
    private String regNum;
    private String color;
    private int allocatedSlotNumber;

    public Car(String regNum, String color) {
        this.regNum = regNum;
        this.color = color;
        allocatedSlotNumber = -1;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getColor() {
        return color;
    }

    public void setSlotNumber(int slotNum) {
        this.allocatedSlotNumber = slotNum;
    }

    public int getAllocatedSlotNumber() {
        return this.allocatedSlotNumber;
    }
}
