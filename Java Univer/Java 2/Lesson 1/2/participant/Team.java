package com.company.participant;

import com.company.Course.Course;

public abstract class Team {
    private int energy;
    private boolean endurance;
    private final String name;

    public Team(int energy, String name) {
        this.energy = energy;
        this.endurance = true;
        this.name = name;
    }

    public void doIt(Course course) {
        this.energy = this.energy - course.getValue();;
        if (this.energy <= 0) this.endurance = false;
    }

    public int getEnergy() {
        return energy;
    }

    public void info() {
        if (!endurance) System.out.println(name + " не преодолел дистанцию");
        if (endurance) System.out.println(name + " преодолел дистанцию");
    }
}
