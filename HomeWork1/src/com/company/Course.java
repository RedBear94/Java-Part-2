package com.company;

public class Course {
    private Object[] massObstacles;

    public Course(Object[] massObstacles){
        this.massObstacles = massObstacles;
    }

    public void doIt(Team t){
        System.out.println("Прохождение препятсвий:");
        Participants[] massParticipants = t.getMassTeam();

        for (int i = 0; i < massParticipants.length; i++) {
            for (int j = 0; j < massObstacles.length; j++) {
                if (massObstacles[j] instanceof Treadmill) {
                    massParticipants[i].Run(((Treadmill)massObstacles[j]).getDistance());
                } else if (massObstacles[j] instanceof Wall) {
                    massParticipants[i].Jump(((Wall)massObstacles[j]).getHeight());
                }
                if (!massParticipants[i].getObstaclePassed()) {
                    break;
                }
            }
        }

        t.setMassTeam(massParticipants);
    }
}
