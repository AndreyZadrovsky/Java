public class Task1 {
    private final Object mon = new Object();
    private char flag = 'A';

    public static void main(String[] args) {
        Task1 t = new Task1();
        Thread threadA = new Thread(()->t.printA());
        Thread threadB = new Thread(()->t.printB());
        Thread threadC = new Thread(()->t.printC());
        threadA.start();
        threadB.start();
        threadC.start();
    }
    public void printA(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (flag != 'A'){
                        mon.wait();
                    }
                    System.out.print("A");
                    flag = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (flag != 'B'){
                        mon.wait();
                    }
                    System.out.print("B");
                    flag = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (mon){
            try {
                for (int i = 0; i < 5; i++) {
                    while (flag != 'C'){
                        mon.wait();
                    }
                    System.out.print("C");
                    flag = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
