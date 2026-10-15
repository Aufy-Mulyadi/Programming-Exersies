package Files;

class ADCCalculator {
  private final double minVoltage;
  private final double maxVoltage;
  private final int bits;

  public ADCCalculator(double minVoltage, double maxVoltage, int bits) {
    this.minVoltage = minVoltage;
    this.maxVoltage = maxVoltage;
    this.bits = bits;
  }

  public double calculateADCError(double analogSample) {
    double range = maxVoltage - minVoltage;
    double levels = Math.pow(2, bits);
    double step = range / levels;
    double quantized = Math.round(analogSample / step) * step;
    return Math.abs(analogSample - quantized);
  }
}

public class Quiz15 {
  public static void main(String[] args) {
    double analogSample = 2.35;
    ADCCalculator adc = new ADCCalculator(0.0, 5.0, 6);
    double error = adc.calculateADCError(analogSample);
    System.out.println("ADC Error: " + error + " V");
  }
}