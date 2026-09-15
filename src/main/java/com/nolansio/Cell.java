package com.nolansio;


public class Cell {
    private final int row;
    private final int col;
    private final Matrix matrix;
    private int nextAlives;

    public Cell(int row, int col, Matrix matrix) {
        this.row = row;
        this.col = col;

        this.matrix = matrix;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
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

    public boolean isAlive() {
        return getMatrix().isAlive(getRow(), getCol());
    }

    public void setAlive(boolean alive) {
        getMatrix().setAlive(getRow(), getCol(), alive);
    }

    public void checkNextAlives() {
        int nextAlives = 0;

        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }

                Cell next = new Cell(getRow() + row, getCol() + col, getMatrix());

                if (next.isAlive()) {
                    nextAlives++;
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

