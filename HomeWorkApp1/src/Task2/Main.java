package Task2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Boxes<Apple> box1 = new Boxes(new ArrayList());
        box1.getBox().addAll(Arrays.asList(new Apple(), new Apple(), new Apple()));

        Boxes<Orange> box2 = new Boxes(new ArrayList());
        box2.getBox().addAll(Arrays.asList(new Orange(), new Orange(), new Orange()));

        Boxes<Apple> box3 = new Boxes(new ArrayList());
        box3.getBox().addAll(Arrays.asList(new Apple(), new Apple()));

        Boxes<Orange> box4 = new Boxes(new ArrayList());
        box4.getBox().addAll(Arrays.asList(new Orange(), new Orange()));
        System.out.println("\nЗадание 3.4");
        System.out.println("Масса ящика " + box1.getWeight());
        System.out.println("Масса ящика " + box2.getWeight());

        System.out.println("\nЗадание 3.5");

        if (box1.compare(box4)) System.out.println("Ящики равны");
        else  {
            System.out.println("Ящики не равны");
        }

        System.out.println("\nЗадание 3.6");

        box1.transfer(box3);


    }

}
