import java.util.Scanner;

public class HomeWorkApp5 {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Иванов Иван Сергеевич", "дворник", "ivanivan@mail.ru", 89121232548L , 20000, 59);
        empArray[1] = new Employee("Петров Василий Григорьевич", "инженер", "petrvas@gmail.com", 89815696455L , 70000, 35);
        empArray[2] = new Employee("Ватрушкин Иван Игоревич", "менеджер", "ivatr@yandex.ru", 89823686412L , 75000, 40);
        empArray[3] = new Employee("Жук Марина Романовна", "директор", "zhuk1967@mail.ru", 89816146378L , 120000, 45);
        empArray[4] = new Employee("Фирсова Светлана Андреевна", "бухгалтер", "firsovasvetlana@gmail.com", 89317357348L , 100000, 39);
        System.out.println("От какого возраста включительно вывести на экран");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for (int i = 0; i < 5; i++){
            if (empArray[i].age >= a){
                empArray[i].print();
            }
        }
    }
}

