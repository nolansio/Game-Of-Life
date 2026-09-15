package com.nolansio.models;


public class Cell {
    private final int row;
    private final int col;
    private boolean alive;
    private int nextAlives;
    private final Matrix matrix;

    public Cell(int row, int col, Matrix matrix) {
        this.row = row;
        this.col = col;

        this.alive = false;
        this.nextAlives = 0;

        this.matrix = matrix;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public int getNextAlives() {
        return nextAlives;
    }

    public void setNextAlives(int nextAlives) {
        this.nextAlives = nextAlives;
    }

    public void checkNextAlives() {
        int nextAlives = 0;

        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }

                int nextRow = getRow() + row;
                int nextCol = getCol() + col;

                if (nextRow >= 0 && nextRow < getMatrix().getRows() && nextCol >= 0 && nextCol < getMatrix().getCols()) {
                    Cell next = getMatrix().getCell(nextRow, nextCol);

                    if (next.isAlive()) {
                        nextAlives++;
                    }
                }
            }
        }

        setNextAlives(nextAlives);
    }

    public void update() {
        if (getNextAlives() < 2) {
            setAlive(false);
        } else if (getNextAlives() == 2) {
            // Nothing
        } else if (getNextAlives() == 3) {
            setAlive(true);
        } else {
            setAlive(false);
        }
    }
}
