import java.util.ArrayList;

public class TaskTwo {
    //    2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи.
//    С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
//    несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.

    public static void main(String[] args) {
        ArrayList<Integer> ivanovPhone = new ArrayList<>();
        ivanovPhone.add(4131215);
        ivanovPhone.add(2358659);
        PhoneBook phoneBook = new PhoneBook("Иванов", ivanovPhone);

        ArrayList<Integer> petrovPhone = new ArrayList<>();
        petrovPhone.add(5248625);
        petrovPhone.add(4235627);
        phoneBook.add("Петров", petrovPhone);

        phoneBook.Print();

        phoneBook.Find("Иванов");
    }
}
