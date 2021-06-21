public class HomeWorkApp2 {
    public static void main(String[] args) {
        String [][] arr1 = new String[][]{{"1", "1", "O", "1"}, {"1", "1", "1", "1"}, {"1", "1", "f", "1"}, {"1", "{", "1", "1"}};
        String[][] arr2 = new String[][]{{"1", "1", "1"}, {"1", "1", "1"}, {"1", "1", "1"}};
        String [][] arr3 = new String[][]{{"1", "1", "1", "1", "1"}, {"1", "153", "1", "1", "1"}, {"1", "1", "1", "1", "1"}, {"1", "1", "1", "1", "1"}};

        Print(arr1);
        try {
            Summ(arr1);
        }
         catch (IndexOutOfBoundsException e){
            e.printStackTrace();
         }
    }
   static void Summ (String[][] arr) {
       if ((arr.length == 4) && (arr[0].length == 4)) {
           int summ = 0;
           for (int i = 0; i < 4; i++) {
               for (int j = 0; j < 4; j++) {
                   try {
                       summ = summ + Integer.parseInt(arr[i][j]);
                   } catch (NumberFormatException e1) {
                       System.out.println("В " + (i + 1) + " строке " + (j + 1) + " столбце не число, а символ или строка символов - " + arr[i][j]);
                   }
               }
           }

           System.out.println("Сумма чисел  - " + summ);

       }
       else throw new IndexOutOfBoundsException(" Массив не 4 Х 4");
   }
    static void Print(String[][] arr){
        for (int i = 0; i< arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
