package Task2;

import java.util.List;

public class Boxes<N extends Fruit> {
    private List<N> box;

    public Boxes(List<N> box) {
        this.box = box;
    }

    public List<N> getBox() {
        return box;
    }

    public float getWeight() {
        float summ = 0;
        for (N box : box) {
            summ += box.weight;
        }
        return summ;
    }


    public boolean compare(Boxes anotherBox) {
        if (this.getWeight() == anotherBox.getWeight()) return true;
        else return false;
    }

    public void transfer(Boxes<N> anotherBox){
            this.box.addAll(anotherBox.getBox());
            anotherBox.getBox().clear();
            System.out.println("вес полного ящика " + this.getWeight() );
            System.out.println("вес пустого ящика " + anotherBox.getWeight() );
    }


}

