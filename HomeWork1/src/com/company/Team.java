package com.company;

public class Team {
    private String name;
    private Participants [] massTeam;

    public Team(String name, Participants [] massTeam){
        this.name = name;
        this.massTeam = massTeam;
    }

    public void printTeamInfo() {
        System.out.println("Участники: ");
        for (int i = 0; i < massTeam.length; i++) {
            System.out.println(massTeam[i]);
        }
        System.out.println("");
    }

    public void showResults(){
        System.out.println("Результаты:");
        for (int i = 0; i < massTeam.length; i++) {
            massTeam[i].showInfo();
        }
    }

    public Participants[] getMassTeam() {
        return massTeam;
    }

    public void setMassTeam(Participants[] massTeam) {
        this.massTeam = massTeam;
    }
}
