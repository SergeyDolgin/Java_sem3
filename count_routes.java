// Дана прямоугольная карта размера MxN (N, M меньше 20)
// На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
// Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку
// * * На карте могут быть стены
// * ** M и N могут быть до 1000
// Задачу разбить на методы


import java.util.Scanner;
// import java.io.IOException;
// import java.io.*;

public class count_routes {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // System.out.println("Введите натуральное число N:");
        System.out.println("Введите количество столбцов M");
        Integer M = getInt();
        System.out.println("Введите количество строк N");
        Integer N = getInt();
        System.out.printf("M = %d \n", M);
        System.out.printf("N = %d \n", N);

        System.out.println("Введите координату X меньшую количества столбцов M");
        Integer X = getInt();
        System.out.println("Введите координату Y меньшую количества строк N");
        Integer Y = getInt();
        System.out.printf("M = %d \n", X);
        System.out.printf("N = %d \n", Y);
        try {
            System.out.printf("Общее количество маршрутов от верхнего до нижнего угла для карты размерностью (M=%d, N=%d) = %d \n", M, N, routes (M, N));
            System.out.printf("Количество маршрутов от точки (X=%d, Y=%d) до нижнего угла карты размерностью (M=%d, N=%d)= %d \n", X, Y, M, N, routes (M-X+1, N-Y+1));
         
        } catch(Exception e) {
            System.out.println("Числа Х и Y  должны быть меньше M и N соответственно");
        }
    }
    public static int getInt() {
        while (true) {
            System.out.println("Вводить необходимо целое положительное число");
            while (!scanner.hasNextInt()) {
                System.out.println("Вводить необходимо целое положительное число");
                scanner.next();
            }
            int temp = scanner.nextInt();
            if (temp > 0)
                return temp;
        }
    }

    public static int routes (Integer M, Integer N) {
        int[] arr[] = new int[M][N];
        // arr[1][1] =5;
        for (int i=0; i < M; i ++) {
            arr[i][0] = 1;
        }
               
        for (int j=0; j < N; j ++) {
            arr[0][j] = 1;
        }
        for (int i=1; i < M; i ++){
            for (int j = 1; j < N; j ++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
 
    
//   вывод на экран полученного массива для карты размерностью M и N
        // for (int[] line : arr) {
        //     for (int item : line) {
        //         System.out.printf("%d    ", item);
        //     }
        //     System.out.println();
        // }
        return arr[M-1][N-1];
    }



}