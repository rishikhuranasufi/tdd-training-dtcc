package com.infosys.training.tdd.basics;

public class Square {
    double v;
    public Square(double v) {
        this.v=v;
    }

    public double area() {
        return v*v;
    }
}
