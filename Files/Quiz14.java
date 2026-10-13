package Files;

class Matrix14 {
  public Matrix14() {}

  public int[][] diagonal(int size) {
    int[][] mat = new int[size][size];
    for (int i = 0; i < size; i++) {
      mat[i][i] = i + 1;
    }
    return mat;
  }

  public void show(int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      System.out.print("[");
      for (int j = 0; j < mat[i].length; j++) {
        System.out.print(mat[i][j] + (j < mat[i].length - 1 ? "," : ""));
      }
      System.out.println("]" + (i < mat.length - 1 ? "," : ""));
    }
  }
}

public class Quiz14 {
  public static void main(String[] args) {
    int size = 4;
    Matrix14 test = new Matrix14();
    int[][] into_matrix = test.diagonal(size);
    test.show(into_matrix);
  }
}