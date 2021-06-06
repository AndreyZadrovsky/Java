public class Cat extends Animals{
    public static int countCat = 0;

    public Cat(String name, int loRun, int loSwim) {
        super(name, loRun, loSwim);
        countCat +=1;
    }
    public void Run(int loRun){
        if (this.loRun > 200){
            System.out.println("Коты не могут пробежать " + this.loRun + " м.");
        }
        else {
            System.out.println(this.name + " пробежал " + this.loRun + " м.");
        }
    }
    public void Swim(int loSwim){
                    System.out.println("Кот не мог проплыть " + this.loSwim + "м. Он не умеет плавать.");
    }
}
