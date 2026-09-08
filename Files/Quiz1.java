package Files;

import java.util.Random;

class RanNum {
  private final Random random;

  public RanNum() {
    this.random = new Random();
  }

  public String getNumber() {
    int number = this.random.nextInt(257); 
    return Integer.toString(number);
  }
}

public class Quiz1 {
  public static void main(String[] args) {
    RanNum random = new RanNum();
    System.out.println(random.getNumber());
  }
}