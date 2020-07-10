package com.shashi.dsalgo.lambda;

public class LambdaDemo {

    public static void main(String[] args) {

        //Anonymous class
        helpPrint(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // using Lambda
        // (argument-list,a1,a1) -> {body}
        helpPrint(message -> {
            System.out.println(message);
        });

    }

    public static void helpPrint(Printer printer) {
        printer.print("Hello World");
    }

}


