package com.company;

public class Main {

    public static void main(String[] args) {
		// № 1 - 2
		Cat catB = new Cat("Барсик", 3, 500);
		Human humanA = new Human("Алексей", 1, 200);
		Robot robotR = new Robot("R-4132", 10, 1000);

		Treadmill treadmill = new Treadmill(300);
		Wall wall = new Wall(1);
		Wall wall2 = new Wall(8);

		/*
		catB.jump(wall.getHeight());
		catB.run(treadmill.getDistance());
		System.out.println("");*/

		// № 3 - 4
		Participants[] massParticipants = {catB, humanA, robotR};
		Obstacles[] massObstacles = {treadmill, wall, wall2};

		Course c = new Course(massObstacles); // Создаем полосу препятствий
		Team team = new Team("team1",massParticipants); // Создаем команду
		team.printTeamInfo();
		c.doIt(team); // Просим команду пройти полосу
		System.out.println();
		team.showResults(); // Показываем результаты
	}
}
