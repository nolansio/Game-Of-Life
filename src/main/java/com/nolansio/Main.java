package com.nolansio;

import com.nolansio.models.Matrix;


public class Main {
    static void main(String[] args) {
        Matrix matrix = new Matrix(10, 10);

        boolean auto = false;
        int times = Integer.MAX_VALUE;

        boolean infinite = true;
        boolean validate = true;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.equals("--auto")) {
                auto = true;
            }

            if (arg.equals("--times")) {
                try {
                    times = Integer.parseInt(args[i+1]);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    IO.println("Argument '--times' must be followed by a positive integer");
                    validate = false;
                }

                if (times <= 0) {
                    IO.println("Argument '--times' must be followed by a positive integer");
                    validate = false;
                }

                infinite = false;
            }
        }

        if (validate) {
            matrix.display();
            times--;

            while (times >= 0 || infinite) {
                times--;

                if (!auto) {
                    String stop = IO.readln();

                    if (stop != null && (stop.equals("stop") || stop.equals("exit"))) {
                        break;
                    }
                }

                matrix.check();
                matrix.update();
                matrix.display();

                try {
                    Thread.sleep(50);
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
