package com.parkinglot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    private ParkingLot parkingLot;
    private Scanner sc;

    public Parser() {
    }

    public void interactiveMode() {
        sc = new Scanner(System.in);
    }

    public void fileMode(String filePath) {
        try {
            File file = new File(filePath);
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file path!");
        }
    }

    public boolean createParkingLot(int capacity) {
        if (parkingLot != null) {
            System.out.println("Parking Lot already created, ignoring command!");
            return false;
        }
        parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
        return true;
    }

    public void run() {
        String input;
        while (sc.hasNextLine()) {
            try {
                input = sc.nextLine();
                String[] separatedInput = input.split(" ");
                Command command = Command.getCommand(separatedInput[0]);
                if (command == Command.EXIT) {
                    System.out.println("Exiting program...");
                    break;
                }
                switch (command) {
                    case CREATE:
                        int capacity = Integer.valueOf(separatedInput[1]);
                        createParkingLot(capacity);
                        break;
                    case PARK:
                        String regNum = separatedInput[1];
                        String color = separatedInput[2];
                        parkingLot.parkCar(regNum, color);
                        break;
                    case LEAVE:
                        Integer slotNum = Integer.valueOf(separatedInput[1]);
                        parkingLot.leaveCar(slotNum);
                        break;
                    case STATUS:
                        parkingLot.printStatus();
                        break;
                    case REGNUMS_FROM_COLOR:
                        parkingLot.printRegNumsWithColor(separatedInput[1]);
                        break;
                    case SLOTNUMS_FROM_COLOR:
                        parkingLot.printSlotNumsWithColor(separatedInput[1]);
                        break;
                    case SLOTNUM_FROM_REGNUM:
                        parkingLot.printSlotNumWithRegNum(separatedInput[1]);
                        break;
                    default:
                        System.out.println("Invalid command, please try again!");
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("NullPointerException, please ensure parking lot is created first!");
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException, please ensure a valid number is provided!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException, please ensure proper commands parameters are provided!");
            } catch (Exception e) {
                System.out.println("Exception," + e + " , Please try again!");
            }
        }
    }
}
