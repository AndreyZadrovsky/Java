public class Employee {
    String fullName;
    String post;
    String email;
    long phone;
    int salary;
    int age;
    Employee(String fullName, String post, String email, long phone, int salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this. email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    void print(){
        System.out.println("ФИО: " + this.fullName + " ,должность: " + this.post + " ,email: " + this.email + " ,телефон: " + this.phone + " ,ЗП: " + this.salary + " ,возраст: " + this.age);
    }
}

