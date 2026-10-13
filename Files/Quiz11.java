package Files;

class Matrix11 {
  private final int size;

  public Matrix11(int size) {
    this.size = size;
  }

  public int[][] identity() {
    int[][] i_matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      i_matrix[i][i] = 1;
    }
    return i_matrix;
  }

  public void show(int[][] mat) {
    for (int[] row : mat) {
      System.out.print("[");
      for (int j = 0; j < row.length; j++) {
        System.out.print(row[j] + (j < row.length - 1 ? "," : ""));
      }
      System.out.println("]");
    }
  }
}

public class Quiz11 {
  public static void main(String[] args) {
    int size = 3;
    Matrix11 test = new Matrix11(size);
    int[][] i_matrix = test.identity();
    test.show(i_matrix);
  }
}