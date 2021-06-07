public class Dog extends Animals {
    public static int countDog = 0;
    public Dog(String name, int loRun, int loSwim, int lim) {
        super(name, loRun, loSwim, lim);
        countDog +=1;
    }
    public void Swim (int loSwim){
        if (this.loSwim > 10){
            System.out.println("Собаки не могут проплыть " + this.loSwim + " м.");
        }
        else {
            System.out.println(this.name + " проплыл " + this.loSwim + " м.");
        }
    }
}
