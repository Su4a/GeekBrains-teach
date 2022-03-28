package com.company.Course;

public class Road extends Course {
    private final int widh;

    public Road(int widh) {
        this.widh = widh;
    }

    public int getValue() {
        return widh;
    }
}
