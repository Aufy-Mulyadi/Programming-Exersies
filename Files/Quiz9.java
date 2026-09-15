package Files;

import java.util.Arrays;

class Average {
  private final int[][] matrix;

  public Average(int[][] matrix) {
    this.matrix = matrix;
  }

  public double[] rowAverage() {
    double[] answer = new double[matrix.length];
    double sum = 0;
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) sum += matrix[i][j];
      answer[i] = sum / matrix[i].length;
    }

    return answer;
  }

  public double[] columnAverage() {
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    double[] answer = new double[numCols];

    for (int j = 0; j < numCols; j++) {
      double sum = 0;
      
      for (int i = 0; i < numRows; i++) sum += matrix[i][j];
      answer[j] = sum / numRows;
    }

    return answer;
  }
}

public class Quiz9 {
  public static void main(String[] args) {
    int[][] numbers = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    Average averager = new Average(numbers);
    double[] rowAvg = averager.rowAverage();
    double[] colAvg = averager.columnAverage();

    System.out.println("Matrix         : " + Arrays.deepToString(numbers));
    System.out.println("Row Averages   : " + Arrays.toString(rowAvg));
    System.out.println("Column Averages: " + Arrays.toString(colAvg));
  }
}
