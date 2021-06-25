import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class PhoneBook {


    HashMap<String, HashSet<Integer>> phoneBook ;

    public PhoneBook(){
       this.phoneBook = new HashMap<>();
    }

    public void add (String name, Integer phone){
        HashSet<Integer> nom = phoneBook.getOrDefault(name, new HashSet<>());
        nom.add(phone);
        phoneBook.put(name, nom);

    }
    public void Print(){
        System.out.println(phoneBook);

    }
    public void Find(String name){
        if (phoneBook.containsKey(name)) {
            System.out.println(name + " - " + phoneBook.get(name));
        }
        else System.out.println(" Такой фамилии нет в списке");
    }
}
