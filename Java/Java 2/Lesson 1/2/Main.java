package com.company;

import com.company.Course.Course;
import com.company.Course.Road;
import com.company.Course.Wall;
import com.company.participant.Team;
import com.company.participant.teams.AlibabaTeam;

public class Main {

    public static void main(String[] args) {
        Course[] courses = {
                new Road(55),
                new Road(20),
                new Wall(70)};
        Team[] teams = {
                new AlibabaTeam(150, "Аллегория"),
                new AlibabaTeam(200, "Вартеншав"),
                new AlibabaTeam(80, "Плавченко"),
                new AlibabaTeam(300, "Бесных")
        };

        for (Team team : teams) {
            for (Course cours : courses) {
                team.doIt(cours);
            }
        }

        for (Team team : teams) team.info();
    }
}
