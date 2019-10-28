# Parking Lot Application

A simple parking lot application built in Java.
The parking lot problem is a popular OODP design problem asked by many companies like Gojek, Amazon, Salesforce, Thoughtworks.

* The parking lot have a capacity of n slots.
* Each slot can only hold a car with a registration number and color.
* Cars is always allocated the nearest slot to the entrance (lowest slot number)
* Available commands:
    1. create_parking_lot `<Size>`
    2. park `<Registration-Num>` `<Color>`
    3. leave `<Slot-Num>`
    4. status
    5. registration\_numbers\_for\_cars\_with\_colour `<Color>`
    6. slot\_numbers\_for\_cars\_with\_colour `<Color>`
    7. slot\_number\_for\_registration\_number `<Registration-Num>`

## Requirements

1. Latest JDK
2. Maven

## Installing the application (required before other steps)
`mvn clean install`

## Running unit tests
`mvn test`
- unit tests will also be executed during installation

## Running functional tests
`./bin/run_functional_tests`

## Running the application
   1. Interactive mode: `java -jar target/parkinglot-1.0.jar`
   2. File mode: `java -jar target/parkinglot-1.0.jar <filename>`