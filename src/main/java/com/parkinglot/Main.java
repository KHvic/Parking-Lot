package com.parkinglot;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        if (args.length > 0) {
            parser.fileMode(args[0]);
        } else {
            parser.interactiveMode();
        }
        parser.run();
    }
}
