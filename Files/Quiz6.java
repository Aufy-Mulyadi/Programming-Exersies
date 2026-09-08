package Files;

class filter {
  private final String input;

  private final String[] whitelist = {"127.0.0.1", "142.250.72.14", "example.com"};

  public filter(String input) {
    this.input = input;
  }

  public String check() {
    boolean isWhitelisted = false;
    
    for (String entry : whitelist) {
      if (entry.equalsIgnoreCase(input)) isWhitelisted = true;
    }
    
    if (!isWhitelisted) return "rejected";
    
    dns resolver = new dns(input);
    checker ipchacker = new checker(input);
    String resolvedIp = resolver.lookup();

    if (!ipchacker.test) {
      return "accepted with ip:" + resolvedIp + " hostname:" + input;
    } else {
      return "accepted ip:" + input + " hostname:localhost";
    }
  }
}

public class Quiz6 {
  public static void main(String[] args) {
    filter test1 = new filter("127.0.0.1");
    System.out.println("127.0.0.1");
    System.out.println(test1.check());
    
    filter test2 = new filter("time.com");
    System.out.println("time.com");
    System.out.println(test2.check());
    
    filter test3 = new filter("example.com");
    System.out.println("example.com");
    System.out.println(test3.check());
  }
}