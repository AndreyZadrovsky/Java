public class Cat extends Animals{
    public static int countCat = 0;

    public Cat(String name, int lim) {
        super(name, lim);
        countCat +=1;
    }

    public void Swim(int loSwim){
                    System.out.println("Кот не мог проплыть " + loSwim + "м. Он не умеет плавать.");
    }
}
