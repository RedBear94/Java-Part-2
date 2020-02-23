package com.company;

public class Course {
    private Obstacles[] massObstacles;

    public Course(Obstacles[] massObstacles){
        this.massObstacles = massObstacles;
    }

    public void doIt(Team t){
        System.out.println("Прохождение препятсвий:");
        Participants[] massParticipants = t.getMassTeam();

        for (int i = 0; i < massParticipants.length; i++) {
            for (int j = 0; j < massObstacles.length; j++) {
                massObstacles[j].passObstacle(massParticipants[i]);
                if(!massParticipants[i].getObstaclePassed()){
                    break;
                }
            }
        }

        t.setMassTeam(massParticipants);
    }
}
