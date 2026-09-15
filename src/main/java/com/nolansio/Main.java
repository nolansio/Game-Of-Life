package com.nolansio;


public class Main {
    static void main() {
        Matrix matrix = new Matrix(4, 4);

        matrix.display();

        matrix.check();
        matrix.update();
        matrix.display();
    }
}
