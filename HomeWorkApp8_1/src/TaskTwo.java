import java.util.Random;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordAI = words[random.nextInt(words.length-1)];
        System.out.println("Какое из перечисленных слов загадал комппьютер?");
        System.out.println();
        for (int i = 0; i < words.length; i++){
           if( ((i % 12) == 0) && (i != 0)) {
               System.out.println(words[i] + " ");
           }
           else {
               System.out.print(words[i] + " ");
           }
        }
        System.out.println();
        System.out.println();
        System.out.println(wordAI);
        String wordCipher = "###############";
        while (!Compare (wordCipher,wordAI)) {
            System.out.print("Введите ваш вариант: ");
            String wordPl = scanner.nextLine();
            for (int i = 0; i < wordPl.length(); i++) {
                if (wordAI.charAt(i) == wordPl.charAt(i)) {
                    char[] wordCipherChar = wordCipher.toCharArray();
                    wordCipherChar[i] = wordAI.charAt(i);
                    wordCipher = String.valueOf(wordCipherChar);
                }
            }
            System.out.println(wordCipher);
        }
        }

    private static boolean Compare (String wordCipher, String wordAI) {
        char[] wordCipherCompare = wordCipher.toCharArray();
        char[] wordAICompare = wordAI.toCharArray();
        int count = 0;
        for (int i = 0; i < wordAI.length(); i++){
            if (wordCipherCompare[i] == wordAICompare[i]){
                count ++;
            }
        }
        if (count == (wordAI.length())){
            System.out.println("Загаданное слово - " + wordAI + ". Вы выиграли!!!");
            return true;
        }
        return false;
    }
    }