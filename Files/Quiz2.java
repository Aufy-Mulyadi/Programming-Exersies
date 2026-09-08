package Files;

class IPv4Gen {
  private RanNum random = new RanNum();

  public String generate() {
    int part1 = random.getNumber();
    int part2 = random.getNumber();
    int part3 = random.getNumber();
    int part4 = random.getNumber();

    return part1 + "." + part2 + "." + part3 + "." + part4;
  }
}

public class Quiz2 {
  public static void main(String[] args) {
    IPv4Gen addr = new IPv4Gen();
    System.out.println(addr.generate());
  }
}
