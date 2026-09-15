package Files;

class Matrix {
  private int[][] matrix;

  public Matrix(int[][] matrix) {
    this.matrix = matrix;
  }

  public int[][] scale(int scale) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] scaled = new int[rows][cols];

    for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) scaled[i][j] = matrix[i][j] * scale;
    
    return scaled;
  }

  public void show(int[][] targetMatrix) {
    System.out.println("[");

    for (int[] row : targetMatrix) {
      System.out.print("  [");
      for (int val : row) {
        System.out.printf("%3d", val);
      }
      System.out.println("]");
    }

    System.out.println("]");
  }
}

public class Quiz10 {
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    int scale = 3;

    Matrix test = new Matrix(matrix);
    int[][] scaled_matrix = test.scale(scale);

    System.out.println("Original Matrix:");
    prettyPrint(matrix);

    System.out.println("Scaled Matrix:");
    test.show(scaled_matrix);
  }

  public static void prettyPrint(int[][] matrix) {
    System.out.println("[");

    for (int[] row : matrix) {
      System.out.print("  [");
      for (int val : row) {
        System.out.printf("%3d", val);
      }
      System.out.println("]");
    }

    System.out.println("]");
  }
}