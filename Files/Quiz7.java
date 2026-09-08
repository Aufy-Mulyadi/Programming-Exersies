package Files;

import java.util.Random;

class MACGen {
  public String generateMAC() {
    Random random = new Random();
    String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    String mac = "";

    for (int i = 0; i < 6; i++) {
      int number = random.nextInt(256);
      int first = number / 16;
      int second = number % 16;
      mac += hex[first] + hex[second];
      if (i < 5) {
        mac += ":";
      }
    }
    return mac;
  }
}

public class Quiz7 {
  public static void main(String[] args) {
    MACGen gen = new MACGen();
    System.out.println(gen.generateMAC());
  }
}