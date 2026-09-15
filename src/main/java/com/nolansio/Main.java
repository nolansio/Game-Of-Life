package com.nolansio;

import com.nolansio.models.BaseCell;
import com.nolansio.models.Matrix;

import java.util.ArrayList;
import java.util.List;


public class Main {
    static void main(String[] args) {
        boolean auto = false;
        int times = Integer.MAX_VALUE;

        boolean infinite = true;
        boolean validate = true;

        List<BaseCell> baseCells = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.equals("--auto")) {
                auto = true;
            }

            if (arg.equals("--times")) {
                try {
                    times = Integer.parseInt(args[i + 1]);
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

            if (arg.equals("--file")) {
                // TODO: Fichier
            }
        }

        if (validate) {
            Matrix matrix = new Matrix(10, 10, baseCells);

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
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
