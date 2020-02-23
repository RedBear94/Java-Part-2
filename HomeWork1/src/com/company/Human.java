package com.company;

public class Human implements Participants{
    private String name;
    private int maxJump;
    private int maxRun;
    private boolean obstaclePassed;

    public Human (String name, int maxJump, int maxRun){
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.obstaclePassed = false;
    }

    // бегать
    public void run(int distance){
        if(distance <= maxRun) {
            System.out.println("Человек по имени " + name + " успешно пробежал " + distance + " м");
            obstaclePassed = true;
        } else{
            System.out.println(name + " не может пробежать такое расстояния");
            obstaclePassed = false;
        }
    }

    // прыгать
    public void jump(int height){
        if(height <= maxJump) {
            System.out.println("Человек по имени " + name + " успешно прыгнул на " + height + " м");
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
        return "Humman: " + name;
    }

}
