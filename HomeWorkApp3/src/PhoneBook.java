import java.util.HashMap;
import java.util.List;


public class PhoneBook {


    HashMap<String, List<Integer>> phoneBook = new HashMap<>();
    PhoneBook(String name, List<Integer> phone){
        phoneBook.put(name, phone);
    }

    public void add (String name, List<Integer> phone){
        phoneBook.put(name, phone);

    }
    public void Print(){
        System.out.println(phoneBook);

    }
    public void Find(String name){
        System.out.println(name + " - " + phoneBook.get(name));
    }
}
