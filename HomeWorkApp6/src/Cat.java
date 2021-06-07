public class Cat extends Animals{
    public static int countCat = 0;

    public Cat(String name, int loRun, int loSwim, int lim) {
        super(name, loRun, loSwim, lim);
        countCat +=1;
    }

    public void Swim(int loSwim){
                    System.out.println("Кот не мог проплыть " + this.loSwim + "м. Он не умеет плавать.");
    }
}
