package com.nolansio.models;

import java.util.List;


public class Matrix {
    private final int rows;
    private final int cols;
    private final Cell[][] cells;

    public Matrix(int rows, int cols, List<BaseCell> baseCells) {
        this.rows = rows;
        this.cols = cols;

        if (baseCells.isEmpty()) {
            this.cells = create(getRows(), getCols());
            return;
        }

        this.cells = create(baseCells);
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

        if (rows > 3) {
            rows = 3;
        }

        if (cols > 3) {
            cols = 3;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col, this);
            }
        }

        List<BaseCell> baseCells = List.of(
                new BaseCell(0, 1, true),
                new BaseCell(1, 2, true),
                new BaseCell(2, 0, true),
                new BaseCell(2, 1, true),
                new BaseCell(2, 2, true)
        );

        for (BaseCell baseCell : baseCells) {
            int row = baseCell.getRow();
            int col = baseCell.getCol();

            cells[row][col].setAlive(baseCell.isAlive());
        }

        return cells;
    }

    public Cell[][] create(List<BaseCell> baseCells) {
        Cell[][] cells = new Cell[rows][cols];

        int furthestRow = 3;
        int furthestCol = 3;

        for (BaseCell baseCell : baseCells) {
            int row = baseCell.getRow();
            int col = baseCell.getCol();

            if (row > furthestRow) {
                furthestRow = row;
            }

            if (col > furthestCol) {
                furthestCol = col;
            }
        }

        for (int row = 0; row < furthestRow; row++) {
            for (int col = 0; col < furthestCol; col++) {
                cells[row][col] = new Cell(row, col, this);
            }
        }

        for (BaseCell baseCell : baseCells) {
            int row = baseCell.getRow();
            int col = baseCell.getCol();

            cells[row][col].setAlive(baseCell.isAlive());
        }

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
