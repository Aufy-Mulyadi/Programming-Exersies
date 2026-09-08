package Files;

class IPv4Gen {
  private RanNum random = new RanNum();

  public String generate() {
    int part1 = Integer.getInteger(random.getNumber());
    int part2 = Integer.getInteger(random.getNumber());
    int part3 = Integer.getInteger(random.getNumber());
    int part4 = Integer.getInteger(random.getNumber());

    return part1 + "." + part2 + "." + part3 + "." + part4;
  }
}

public class Quiz2 {
  public static void main(String[] args) {
    IPv4Gen addr = new IPv4Gen();
    System.out.println(addr.generate());
  }
}
