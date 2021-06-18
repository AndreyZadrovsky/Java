package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Team team =new Team ("Команда А", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Cat("Кузя"));
        Course[] course = {new Cross(200), new Wall(2), new Wall(1), new Cross(120), new Water(5)};
        team.Start(course);
        team.Info();
    }
}
