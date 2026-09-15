package com.nolansio.models;


public class BaseCell {
    private final int row;
    private final int col;

    public BaseCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
