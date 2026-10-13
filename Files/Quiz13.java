package Files;

class Matrix13 {
  private final int[] numbers;

  public Matrix13(int[] numbers) {
    this.numbers = numbers;
  }

  public int[][] toMatrix() {
    int len = numbers.length;
    int size = (int) Math.ceil(Math.sqrt(len));
    int[][] mat = new int[size][size];
    for (int i = 0; i < len; i++) {
      int row = i / size;
      int col = i % size;
      mat[row][col] = numbers[i];
    }
    return mat;
  }

  public void show(int[][] mat) {
    for (int[] row : mat) {
      System.out.print("[");
      for (int j = 0; j < row.length; j++) {
        System.out.print(row[j] + (j < row.length - 1 ? ", " : ""));
      }
      System.out.println("]");
    }
  }
}

public class Quiz13 {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 3, 4, 5, 6, 6, 7, 8};
    Matrix13 test = new Matrix13(numbers);
    int[][] into_matrix = test.toMatrix();
    test.show(into_matrix);
  }
}