package Files;

import java.util.Arrays;

class Matrix12 {
  private final int[][] matrix;

  public Matrix12(int[][] matrix) {
    this.matrix = matrix;
  }

  public int[] vectorize() {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[] vec = new int[rows * cols];
    int idx = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        vec[idx++] = matrix[i][j];
      }
    }
    return vec;
  }

  public void show(int[] vec) {
    System.out.println(Arrays.toString(vec));
  }
}

public class Quiz12 {
  public static void main(String[] args) {
    int[][] numbers = { {1, 2, 3, 3}, {4, 5, 6, 6}, {7, 8, 9, 9} };
    Matrix12 test = new Matrix12(numbers);
    int[] vectorized_matrix = test.vectorize();
    test.show(vectorized_matrix);
  }
}