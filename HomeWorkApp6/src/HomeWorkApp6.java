import java.util.Scanner;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        int limCat = 200;
        int limDog = 500;

        Cat firstCat = new Cat("Кузя", limCat);
        Dog firstDog = new Dog("Бим",limDog);
        Dog secondDog = new Dog("Перси",limDog);
        Cat secondCat = new Cat("Вася",limCat);

        firstCat.Run(180);
        firstDog.Run(500);
        firstCat.Swim(10);
        firstDog.Swim(10);
        System.out.println("Создано собак - " + firstDog.countDog + " создано котов - " + firstCat.countCat + " всего животных - " + (firstCat.countCat + firstDog.countDog));

    }
}
