import java.util.Scanner;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean full;

    public Cat (String name, int appetite, Boolean full){
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }
    public void eat (Plate p){
        while (!this.full) {
            if (p.getFood() >= this.appetite) {
                    p.decreaseFood(appetite);
                    this.full = true;
                    System.out.println(this.name + " съел " + this.appetite + " ед. еды и наелся");
                    System.out.println(" еды в тарелки осталось " + p.getFood() + " ед.");
                    System.out.println();
                } else {
                    System.out.println(this.name + " остался голоден. Ему не хватило " + (this.appetite - p.getFood()) + " ед. еды.");
                    System.out.println("Сколько ещё доложим еды?");
                    Scanner scanner = new Scanner(System.in);
                    p.setFood(scanner.nextInt());

                }

            }
        }
}
