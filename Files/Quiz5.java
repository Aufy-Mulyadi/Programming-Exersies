package Files;

class dns {
  private final String query;

  private static String[] hostnames = {"localhost", "google.com", "example.com"};
  private static String[] ips = {"127.0.0.1", "142.250.72.14", "7.7.7.7"};

  public dns(String query) {
    this.query = query;
  }

  public String lookup() {
    for (int i = 0; i < hostnames.length; i++) {
      if (hostnames[i].equalsIgnoreCase(query)) {
        return ips[i];
      }
    }
    return "hostname not on record table. Use register() to add a new hostname:IP pair";
  }

  public static void register(String hostname, String ip) {
    String[] newHostnames = new String[hostnames.length + 1];
    String[] newIps = new String[ips.length + 1];

    for (int i = 0; i < hostnames.length; i++) {
      newHostnames[i] = hostnames[i];
      newIps[i] = ips[i];
    }
    
    newHostnames[hostnames.length] = hostname;
    newIps[ips.length] = ip;
    hostnames = newHostnames;
    ips = newIps;
  }
}

public class Quiz5 {
  public static void main(String[] args) {
    dns test1 = new dns("google.com");
    System.out.println(test1.lookup());

    dns test2 = new dns("jisedu.or.id");
    System.out.println(test2.lookup());
  }
}