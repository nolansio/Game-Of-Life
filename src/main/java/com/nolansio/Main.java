package com.nolansio;


public class Main {
    static void main(String[] args) {
        Matrix matrix = new Matrix(10, 10);

        matrix.display();

        boolean auto = args.length > 0 && args[0].equals("--auto");

        while (true) {
            if (!auto) {
                String stop = IO.readln();

                if (stop.equals("stop") || stop.equals("exit")) {
                    break;
                }
            }

            matrix.check();
            matrix.update();
            matrix.display();
        }
    }
}
