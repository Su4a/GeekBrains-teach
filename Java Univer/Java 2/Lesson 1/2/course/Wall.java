package com.company.Course;

public class Wall extends Course {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getValue() {
        return height;
    }
}
