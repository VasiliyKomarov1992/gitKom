package matrix;

public class MultiArray
{
	private static final int SIZE = 4;

	public static void main(String[] args) {
        // Объявим коснтанту для размера массива
        // Создаем двумерный массив 
        int[][] graph = new int[SIZE][SIZE];
 
        // Цикл по первой размерности (первые квадратные скобки)
        for (int i = 0; i < SIZE; i++) {
            // Цикл по второй размерности (вторые квадратные скобки)
            for (int j = 0; j < SIZE; j++) {
//                graph[i][j] = '1';
            }
        }
 
        // Теперь выводим массив на экран
        // Цикл по первой размерности выводит строки
        for (int i = 0; i < SIZE; i++) {
            // Цикл по второй размерности выводит колонки - вывод одной строки
            for (int j = 0; j < SIZE; j++) {
                // Используем оператор print - без перехода на следующую строку
                System.out.print(graph[i][j]);
            }
            // Переход на следующую строку
            System.out.println();
        }
    }
}