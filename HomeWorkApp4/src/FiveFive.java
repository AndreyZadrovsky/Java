import java.util.Random;
import java.util.Scanner;

 public class FiveFive {

        //    массив поля
        public static char[][] map;

        //    объявление постоянных переменных
        public static final int SIZE = 5;
        public static final int DOTS_TO_WIN = 4;
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static final char DOT_EMPTY = '.';

        public static void main(String[] args) {
            initMap();
            printMap();
            while(true){
                humanTurn();
                printMap();
                if(Win(DOT_X)){
                    System.out.println("Вы победили");
                    break;
                }
                if (isMapFull()){
                    System.out.println("Ничья");
                    break;
                }
                compTurn();
                printMap();
                if(Win(DOT_O)){
                    System.out.println("Компьютер победил");
                    break;
                }
                if (isMapFull()){
                    System.out.println("Ничья");
                    break;
                }

            }
        }

//    инициализация поля

        public static void initMap(){
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

//    печать игрового поля

        public static void printMap() {
            for (int i = 0; i <= SIZE; i++){
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++){
                System.out.print((i+1) + " ");
                for (int j = 0; j < SIZE; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
        //    ход игрока
        public static Scanner scanner = new Scanner(System.in);
        public static void humanTurn(){
            int x;
            int y;
            do {
                System.out.println("Введите координаты вашего хода в формате X Y");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            }while(!isCellValid( x, y));
            map[x][y] = DOT_X;
        }
        //    ход компьютера
        public static Random random = new Random();
        public static void compTurn(){
            int x;
            int y;
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }while(!isCellValid( x, y));
            System.out.println("Компьютер сделал ход в точку X - " + x + " Y - " + y);
            map[x][y] = DOT_O;
        }

        //    проверка правильности хода
        public static boolean isCellValid (int x, int y){
            if ((x >= 0) && (x <= SIZE) && (y >= 0) &&(y <= SIZE) && (map[x][y] == DOT_EMPTY)) return true;
            return false;
        }
        //    проверка победы
        public static boolean Win(char symb){
            for (int i = 0;i < SIZE; i++){
                int countStr = 0;
                int countSto = 0;
                int countDia1 = 0;
                int countDia2 = 0;
                int countDia3 = 0;
                int countDia4 = 0;
                for (int j = 0;j < SIZE; j++){
                    if (map[i][j] == symb){
                        countStr += 1;
                    }
                    else if(countStr<DOTS_TO_WIN) countStr = 0;
                    if(map[j][i] == symb){
                        countSto += 1;
                    }
                    else if(countSto<DOTS_TO_WIN) countSto = 0;
                    if(map[j][j] == symb){
                        countDia1 +=1;
                    }
                    else if(countDia1<DOTS_TO_WIN) countDia1 = 0;
                    if (map[SIZE-j-1][j] == symb){
                        countDia2 +=1;
                    }
                    else if(countDia2<DOTS_TO_WIN) countDia2 = 0;

                    if (j < (SIZE-1)){
                        if (map[j][j + 1] == symb) countDia3 += 1;
                        else if (countDia3 < DOTS_TO_WIN) countDia3 = 0;
                    }
                    if (j > 0) {
                        if (map[j][j - 1] == symb) countDia4 += 1;
                        else if (countDia3 < DOTS_TO_WIN) countDia4 = 0;
                    }
                }
                if ((countStr == DOTS_TO_WIN) || (countSto == DOTS_TO_WIN) || (countDia1 == DOTS_TO_WIN) || (countDia2 == DOTS_TO_WIN) || (countDia3 == DOTS_TO_WIN) || (countDia4 == DOTS_TO_WIN)){
                    return true;
                }
            }
            return false;
        }
        //    проверка ничьи
        public static boolean isMapFull(){
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }

    }


