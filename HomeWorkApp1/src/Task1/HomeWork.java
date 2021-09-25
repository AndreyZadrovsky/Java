package Task1;

public class HomeWork {
    public static void main(String[] args) {

        Elements  elementsI = new Elements(1, 2, 3, 4, 5);
        Elements  elementsC = new Elements("a","b","c","d","e");

        elementsC.Swap(1,3);
        elementsI.Swap(1,5);
        elementsI.Swap(1,2);

        System.out.println();

        elementsI.arrayToArrayList();
        elementsC.arrayToArrayList();

    }
}
