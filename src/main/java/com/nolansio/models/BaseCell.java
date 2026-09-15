package com.nolansio.models;


public class BaseCell {
    private final int row;
    private final int col;
    private boolean alive;

    public BaseCell(int row, int col, boolean alive) {
        this.row = row;
        this.col = col;
        this.alive = alive;
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
}
