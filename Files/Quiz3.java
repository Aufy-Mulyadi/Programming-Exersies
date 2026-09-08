package Files;

class checker {
  public boolean test;

  public checker(String add) {
    this.test = validate(add);
  }

  private boolean validate(String add) {
    String[] parts = add.split("\\.", -1);

    if (parts.length != 4) return false;
    for (String part : parts) {
      int num = Integer.parseInt(part);
      if (num < 0 || num > 255) return false;
    }
    return true;
  }
}

public class Quiz3 {
  public static void main(String[] args) {
    checker test1 = new checker("hello");
    System.out.println(test1.test);

    checker test2 = new checker("192.45.7.201");
    System.out.println(test2.test);
  }
}