package Files;

import java.util.Arrays;

class ADCResolver {
  public static int calculateResolution(double minVoltage, double maxVoltage, double[] readings) {
    double[] sorted = readings.clone();
    Arrays.sort(sorted);
    
    double minDiff = Double.MAX_VALUE;
    for (int i = 1; i < sorted.length; i++) {
      double diff = sorted[i] - sorted[i - 1];
      if (diff > 0 && diff < minDiff) {
        minDiff = diff;
      }
    }
    
    double range = maxVoltage - minVoltage;
    double requiredLevels = range / minDiff;
    int bits = (int) Math.ceil(Math.log(requiredLevels) / Math.log(2));
    return bits;
  }
}

public class Quiz16 {
  public static void main(String[] args) {
    double[] readings = {2.0, 1.5, 0.0, 2.02, 4.0, 5.0};
    int result = ADCResolver.calculateResolution(0.0, 5.0, readings);
    System.out.println("Required ADC resolution: " + result + " bits");
  }
}