package com.nolansio;


public class Main {
    static void main() {
        Matrix matrix = new Matrix(10, 10);

        matrix.display();

        while (true) {
            IO.readln();

            matrix.check();
            matrix.update();
            matrix.display();
        }
    }
}
