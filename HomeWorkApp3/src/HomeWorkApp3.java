import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeWorkApp3 {
    public static void main(String[] args) {
//        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//           Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//           Посчитать сколько раз встречается каждое слово.
        ArrayList<String> arr = new ArrayList<>();
        arr.add("стол");
        arr.add("стул");
        arr.add("кофе");
        arr.add("кот");
        arr.add("стол");
        arr.add("число");
        arr.add("стол");
        arr.add("кот");
        arr.add("стул");
        arr.add("стол");
        arr.add("Часы");
        arr.add("Часы");
        arr.add("Часы");
        System.out.println(arr);
        int count;
        System.out.println("\nСлова не имеющие дубликатов:");
        for (String a : arr) {
            count = 0;
            for (String b : arr) {
                if (a.equals(b)) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(a);
            }
        }
        System.out.println();
        HashMap <String, Integer> rep = new HashMap<>();

        for (String c : arr) {
                count = 0;
                for (String j : arr) {
                    if (c.equals(j)) {
                        count++;
                    }
                }
            rep.put(c,count);

            }
        System.out.println(rep);




    }
    }

