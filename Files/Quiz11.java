package Files;

class Matrix2 {
  private int size;

  public Matrix2(int size) {
    this.size = size;
  }

  public int[][] eye() {
    int[][] answer = new int[size][size];
    for (int i = 0; i < size; i++) answer[i][i] = 1;
    return answer;
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

public class Quiz11 {
  public static void main(String[] args) {
    Matrix2 test = new Matrix2(3);
    int[][] scaled_matrix = test.eye();
    System.out.println("Scaled Matrix:");
    test.show(scaled_matrix);
  }
}