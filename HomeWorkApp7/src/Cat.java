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
        p.decreaseFood(appetite);
    }
    public int getAppetite(){
        return appetite;
    }
    public void setFull(){
        this.full = true;
    }
    public void conFull(int n){
        if (this.full) System.out.println(this.name + " съел " + this.appetite + " ед. и наелся");
        else System.out.println(this.name + " остался голоден. Ему не хватило " + n + " ед. еды.");
    }
}
