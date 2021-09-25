package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elements <E>{
    private E[] arr;

    public E[] getArr() {
        return arr;
    }

    public Elements(E... arr) {
        this.arr = arr;
    }
    public void Swap(int index1, int index2){
        if (index1 < arr.length && index2 < arr.length && index1 != index2){
            E temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            System.out.println("Результат: " + Arrays.toString(arr));
        }else{
            System.out.println("Неверные индексы");
        }
    }
    public void arrayToArrayList(){
        List arrList = new ArrayList(Arrays.asList(arr));
        System.out.println("ArrayList: " + arrList);
    }
}