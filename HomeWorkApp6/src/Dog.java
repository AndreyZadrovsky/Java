public class Dog extends Animals {
    public static int countDog = 0;
    public Dog(String name, int loRun, int loSwim) {
        super(name, loRun, loSwim);
        countDog +=1;
    }
    public void Run(int loRun){
        if (this.loRun > 500){
            System.out.println("Собаки не могут пробежать " + this.loRun + " м.");
        }
        else {
            System.out.println(this.name + " пробежал " + this.loRun + " м.");
        }
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
