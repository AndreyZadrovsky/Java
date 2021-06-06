import java.util.Random;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        Random random = new Random();
        int rndRun = random.nextInt(700);
        int rndSwim = random.nextInt(20);
        Cat firstCat = new Cat("Кузя", rndRun, rndSwim);
        rndRun = random.nextInt(700);
        rndSwim = random.nextInt(20);
        Dog firstDog = new Dog("Бим", rndRun, rndSwim);
        rndRun = random.nextInt(700);
        rndSwim = random.nextInt(20);
        Dog secondDog = new Dog("Перси", rndRun, rndSwim);
        rndRun = random.nextInt(700);
        rndSwim = random.nextInt(20);
        Cat secondCat = new Cat("Вася", rndRun, rndSwim);

        firstCat.Run(firstCat.loRun);
        firstDog.Run(firstDog.loRun);
        firstCat.Swim(firstCat.loSwim);
        firstDog.Swim(firstDog.loSwim);
        System.out.println("Создано собак - " + firstDog.countDog + " создано котов - " + firstCat.countCat + " всего животных - " + (firstCat.countCat + firstDog.countDog));

    }
}
