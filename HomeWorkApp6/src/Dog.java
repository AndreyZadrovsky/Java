public class Dog extends Animals {
    public static int countDog = 0;
    public Dog(String name, int lim) {
        super(name, lim);
        countDog +=1;
    }
    public void Swim (int loSwim){
        if (loSwim > 10){
            System.out.println(this.name + " не может проплыть " + loSwim + " м.");
        }
        else {
            System.out.println(this.name + " проплыл " + loSwim + " м.");
        }
    }
}
