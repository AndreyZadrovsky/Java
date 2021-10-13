import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        // Task2
        try {
            System.out.println("1, 2, 4, 0, 0, 5, 2, 2");
            System.out.println(Arrays.toString(arrAfterFour(1, 2, 4, 0, 0, 5, 2, 2)));

            System.out.println("1, 2, 4, 4, 2, 3, 4, 1, 7");
            System.out.println(Arrays.toString(arrAfterFour(1, 2, 4, 4, 2, 3, 4, 1, 7)));

            System.out.println("1, 2, 4");
            System.out.println(Arrays.toString(arrAfterFour(1, 2, 4)));

            System.out.println("1, 2, 3, 5");
            System.out.println(Arrays.toString(arrAfterFour(1, 2, 3, 5)));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println("\n");
// Task 3
        System.out.println(oneAndFour(1, 4, 4, 4, 1, 1));
        System.out.println(oneAndFour(1, 1, 1, 1));
        System.out.println(oneAndFour(1, 4, 4, 1, 3));
    }

    static int[] arrAfterFour(int... arr) throws RuntimeException {
        int j;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                j = i + 1;
                int[] arrAfter = new int[arr.length - j];
                System.arraycopy(arr, j, arrAfter, 0, (arr.length - j));
                return arrAfter;
            }
        }
        throw new RuntimeException("Нет ни одной четверки");
    }

    static boolean oneAndFour(int... arr) {
        boolean one = false;
        boolean four = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                one = true;
            } else if (arr[i] == 4) {
                four = true;
            } else return false;
        }
        return one && four;
    }
}
