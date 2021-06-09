public class Plate {
    private int food;
    public Plate(int food){
        this.food = food;
    }
    public void decreaseFood(int n){
        food -= n;
    }

    public void info(){
        System.out.println("В тарелке : " + food + " ед. еды");
    }
    public int getFood(){
        return food;
    }
    public void setFood(int n){
        food = food + n;
    }
}
