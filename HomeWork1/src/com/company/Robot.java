package com.company;

public class Robot implements Participants {
    private String name;
    private int maxJump;
    private int maxRun;
    private boolean obstaclePassed;

    public Robot (String name, int maxJump, int maxRun){
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.obstaclePassed = false;
    }

    // бегать
    public void Run(int distance){
        if(distance <= maxRun) {
            System.out.println("Робот " + name + " успешно пробежал " + distance + " м");
            obstaclePassed = true;
        } else{
            System.out.println(name + " не может пробежать такое расстояния");
            obstaclePassed = false;
        }
    }

    // прыгать
    public void Jump(int height){
        if(height <= maxJump) {
            System.out.println("Робот " + name + " успешно прыгнул на " + height + " м");
            obstaclePassed = true;
        } else{
            System.out.println(name + " не может пругнуть на таукую высоту");
            obstaclePassed = false;
        }
    }

    public void showInfo() {
        if(obstaclePassed){
            System.out.println(name + " - препятсвия пройдены");
        } else{
            System.out.println(name + " - препятсвия не пройдены");
        }
    }

    public boolean getObstaclePassed(){
        return obstaclePassed;
    }

    @Override
    public String toString() {
        return "Robot: " + name;
    }

}
