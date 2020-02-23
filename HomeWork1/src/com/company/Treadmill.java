package com.company;

public class Treadmill implements Obstacles{
    private int distance;
    public Treadmill (int distance){
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void passObstacle(Participants p) {
        p.run(distance);
    }
}
