package com.nolansio;

import com.nolansio.models.BaseCell;
import com.nolansio.models.Matrix;

import java.io.*;
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
                    IO.println("Argument after '--times' must be followed by a positive integer");

                    validate = false;
                    break;
                }

                if (times <= 0) {
                    IO.println("Argument after '--times' must be followed by a positive integer");

                    validate = false;
                    break;
                }

                infinite = false;
            }

            if (arg.equals("--file")) {
                String path;

                try {
                    path = args[i + 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    IO.println("Argument after '--file' must be a valid path");

                    validate = false;
                    break;
                }

                baseCells = getBaseCells(new File(path));

                if (baseCells == null) {
                    IO.println("Argument after '--file' must be a valid path");

                    validate = false;
                    break;
                }
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

    private static List<BaseCell> getBaseCells(File baseFile) {
        if (!baseFile.exists()) {
            return null;
        }

        List<BaseCell> baseCells = new ArrayList<>();

        try (BufferedReader file = new BufferedReader(new FileReader(baseFile.getAbsolutePath()))) {
            String line = file.readLine();
            int row = 0;

            while (line != null) {
                int col = 0;

                for (char character: line.toCharArray()) {
                    String cell = String.valueOf(character);

                    if (cell.equalsIgnoreCase("O") || cell.equalsIgnoreCase("⬜")) {
                        baseCells.add(new BaseCell(row, col, true));
                    }

                    if (cell.equalsIgnoreCase("X") || cell.equalsIgnoreCase("⬛")) {
                        baseCells.add(new BaseCell(row, col, false));
                    }

                    col++;
                }

                line = file.readLine();
                row++;
            }
        } catch (IOException e) {
            return null;
        }

        return baseCells;
    }
}
