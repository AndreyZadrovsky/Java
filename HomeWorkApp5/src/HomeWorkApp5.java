import javax.naming.PartialResultException;

public class HomeWorkApp5 {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        OneThread();

        TwoTread();
    }



    static void OneThread(){
        float[] arr = new float[size];
        for (int i = 0; i<size; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for(int i = 0; i<size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время однопоточного метода: " + (System.currentTimeMillis() - a));
    }

    static void TwoTread(){
        float[] arr = new float[size];
        for (int i = 0; i<size; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr,0,arr1,0,h);
        System.arraycopy(arr,h,arr2,0,h);
        Thread thread1 = new Thread(()->{
            for(int i = 0; i<h; i++){
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(()->{
            for(int i = 0; i<h; i++){
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1,0,arr,0,h);
        System.arraycopy(arr2,0,arr,h,h);

        System.out.println("Время двупоточного метода: " + (System.currentTimeMillis() - a));

    }

}
