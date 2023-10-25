public class Main {
    public static void main(String[] args) {
        final int a = 2; // Константа "a"
        long[][] matrixB = {
                {1, 8, 4, 3},
                {9, 5, 6, 5},
                {4, 7, 1, 6},
                {7, 8, 6, 9}
        }; // Матриця B

        // Множення матиці C = a * B
        long[][] matrixC = multiplyMatrixByConstant(matrixB, a);

        // Обчислюємо суму найбільших та найменших елементів в рядках матриці
        long sumMaxEven = sumMaxElements(matrixC);
        long sumMinOdd = sumMinElements(matrixC);

        // Виведення вхідних даних
        System.out.println("Матриця В:");
        printMatrix(matrixB);

        System.out.println("Константа а = " + a);

        // Виводимо результати
        System.out.println("Результат множення матриці C = a * B:");
        printMatrix(matrixC);

        System.out.println("Сума найбільших елементів в рядках з непарними номерами: " + sumMaxEven);
        System.out.println("Сума найменших елементів в рядках з парними номерами: " + sumMinOdd);
    }
    // Метод для множення матриці на константу a
    public static long[][] multiplyMatrixByConstant(long[][] matrix, int a) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        long[][] result = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a * matrix[i][j];
            }
        }

        return result;
    }

    // Метод для обчислення суми найбільших елементів в рядках матриці з непарними номерами
    public static long sumMaxElements(long[][] matrix) {
        long sum = 0;

        for (int i = 0; i < matrix.length; i += 2) { // Перевірка на непарний номер рядка
            long max = matrix[i][0];

            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            sum += max;
        }
        return sum;
    }

    // Метод для обчислення суми найменших елементів в рядках матриці з парними номерами
    public static long sumMinElements(long[][] matrix) {
        long sum = 0;

        for (int i = 1; i < matrix.length; i += 2) { // Перевірка на парний номер рядка
            long min = matrix[i][0];

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sum += min;
        }
        return sum;
    }

    // Метод для виведення матриці на екран
    public static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            for (long num : row) {
                System.out.printf("%5d", num); // Виводимо кожен елемент, вирівнюючи їх по ширині
            }
            System.out.println();
        }
    }
}