package com.parkinglot;

import java.util.*;

public class ParkingLot {
    private int capacity;
    private Map<String, Car> regNumToCar;
    private Map<Integer, Car> slotNumToCar;
    private Map<String, Set<Car>> colorToCars;
    private TreeSet<Integer> freeSlots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        regNumToCar = new HashMap<String, Car>();
        slotNumToCar = new HashMap<Integer, Car>();
        colorToCars = new HashMap<String, Set<Car>>();
        freeSlots = new TreeSet<Integer>();
        for (int i = 1; i <= capacity; i++) {
            freeSlots.add(i);
        }
    }

    public int parkCar(String regNum, String color) {
        if (regNumToCar.containsKey(regNum)) {
            System.out.println("Car with same RegNum already parked!");
            return -1;
        } else if (freeSlots.isEmpty()) {
            System.out.println("Sorry, parking lot is full");
            return -1;
        }
        Car newCar = new Car(regNum, color);
        colorToCars.putIfAbsent(color, new HashSet<Car>());
        colorToCars.get(color).add(newCar);
        regNumToCar.put(regNum, newCar);

        int allocatedSlot = freeSlots.pollFirst();
        newCar.setSlotNumber(allocatedSlot);
        slotNumToCar.put(allocatedSlot, newCar);

        System.out.println("Allocated slot number: " + allocatedSlot);
        return allocatedSlot;
    }

    public Car leaveCar(int slotNum) {
        if (!slotNumToCar.containsKey(slotNum)) {
            System.out.println("Slot number " + slotNum + " is invalid, leave car aborted");
            return null;
        }
        Car evictCar = slotNumToCar.get(slotNum);
        regNumToCar.remove(evictCar.getRegNum());
        slotNumToCar.remove(slotNum);
        colorToCars.get(evictCar.getColor()).remove(evictCar);
        freeSlots.add(slotNum);
        System.out.println("Slot number " + slotNum + " is free");
        return evictCar;
    }

    public void printStatus() {
        System.out.println("Slot No.    Registration No    Colour");
        for (int i = 1; i <= capacity; i++) {
            Car car = slotNumToCar.get(i);
            if (car != null) {
                System.out.println(String.format("%-12s%-19s%s", i, car.getRegNum(), car.getColor()));
            }
        }
    }

    public boolean printRegNumsWithColor(String color) {
        Set<Car> matchingCars = colorToCars.getOrDefault(color, new HashSet<Car>());
        if (matchingCars.isEmpty()) {
            System.out.println("No cars with such color");
            return false;
        }
        TreeSet<String> sortedResult = new TreeSet<String>();
        for (Car matchingCar : matchingCars) {
            sortedResult.add(matchingCar.getRegNum());
        }
        Iterator<String> iter = sortedResult.iterator();
        System.out.print(iter.next());
        while (iter.hasNext()) {
            System.out.print(", " + iter.next());
        }
        System.out.println();
        return true;
    }

    public boolean printSlotNumsWithColor(String color) {
        Set<Car> matchingCars = colorToCars.getOrDefault(color, new HashSet<Car>());
        if (matchingCars.isEmpty()) {
            System.out.println("No cars with such color");
            return false;
        }
        TreeSet<Integer> sortedResult = new TreeSet<Integer>();
        for (Car matchingCar : matchingCars) {
            sortedResult.add(matchingCar.getAllocatedSlotNumber());
        }
        Iterator<Integer> iter = sortedResult.iterator();
        System.out.print(iter.next());
        while (iter.hasNext()) {
            System.out.print(", " + iter.next());
        }
        System.out.println();
        return true;
    }

    public boolean printSlotNumWithRegNum(String regNum) {
        Car matchingCar = regNumToCar.get(regNum);
        if (matchingCar == null) {
            System.out.println("Not found");
            return false;
        } else {
            System.out.println(matchingCar.getAllocatedSlotNumber());
            return true;
        }
    }
}
