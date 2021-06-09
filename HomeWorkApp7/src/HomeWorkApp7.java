import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Cat[] cat = new Cat[5];
            cat[0] = new Cat("Барсик", (random.nextInt(19) + 1), false);
            cat[1] = new Cat("Мурзик", (random.nextInt(19) + 1), false);
            cat[2] = new Cat("Кеша", (random.nextInt(19) + 1), false);
            cat[3] = new Cat("Степа", (random.nextInt(19) + 1), false);
            cat[4] = new Cat("Рыжик", (random.nextInt(19) + 1), false);

        System.out.println("Сколько положим еды в тарелку?");

        Plate plate = new Plate(scanner.nextInt());
        plate.info();

        for (int i = 0; i< cat.length; i++){
            if (plate.getFood() >= cat[i].getAppetite()) {
                cat[i].eat(plate);
                cat[i].setFull();
                cat[i].conFull(0);
                plate.info();
            }
            else {
                cat[i].conFull(cat[i].getAppetite() - plate.getFood());
                System.out.println("Сколько ещё доложим еды?");
                plate.setFood(scanner.nextInt());
                i--;

            }
        }
    }
}
