package com.nolansio;

import com.nolansio.models.Cell;


public class Matrix {
    private final int rows;
    private final int cols;
    private final Cell[][] cells;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        this.cells = create(getRows(), getCols());
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int row, int col) {
        return getCells()[row][col];
    }

    public Cell[][] create(int rows, int cols) {
        Cell[][] cells = new Cell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col, this);
            }
        }

        cells[0][1].setAlive(true);
        cells[1][2].setAlive(true);
        cells[2][0].setAlive(true);
        cells[2][1].setAlive(true);
        cells[2][2].setAlive(true);

        return cells;
    }

    public void display() {
        IO.println("");

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = getCell(row, col);
                if (cell.isAlive()) {
                    IO.print("⬜");
                    continue;
                }

                IO.print("⬛");
            }

            IO.println();
        }

        IO.println("");
    }

    public void check() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = getCell(row, col);
                cell.checkNextAlives();
            }
        }
    }

    public void update() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = getCell(row, col);
                cell.update();
            }
        }
    }
}
