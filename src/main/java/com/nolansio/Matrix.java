package com.nolansio;

import java.util.Arrays;


public class Matrix {
    private final int rows;
    private final int cols;
    private final String[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        this.matrix = create(getRows(), getCols());
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public String getContent(int row, int col) {
        return matrix[row][col];
    }

    public void setContent(int row, int col, String content) {
        matrix[row][col] = content;
    }

    public boolean isAlive(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        return getContent(row, col).equalsIgnoreCase("⬜");
    }

    public void setAlive(int row, int col, boolean alive) {
        if (alive) {
            setContent(row, col, "⬜");
            return;
        }

        setContent(row, col, "⬛");
    }

    public String[][] create(int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (String[] cells : matrix) {
            Arrays.fill(cells, "⬛");
        }

        matrix[1][1] = "⬜";
        matrix[1][2] = "⬜";
        matrix[2][1] = "⬛";
        matrix[2][2] = "⬜";

        return matrix;
    }

    public void display() {
        IO.println("");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        IO.println("");
    }

    public void check() {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                Cell cell = new Cell(col, row, this);
                cell.checkNextAlives();
            }
        }
    }

    public void update() {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                Cell cell = new Cell(col, row, this);
                cell.update();
            }
        }
    }
}
