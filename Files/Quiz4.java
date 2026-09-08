package Files;

class porter {
  private final String service;
  private final String ip;

  private static String[] services = {"http", "https", "playstation", "ssh", "ftp", "mysql"};
  private static int[] ports = {80, 443, 3479, 22, 20, 3306};

  public porter(String service, String ip) {
    this.service = service;
    this.ip = ip;
  }

  public String build() {
    for (int i = 0; i < services.length; i++) {
      if (services[i].equalsIgnoreCase(service)) {
        return ip + ":" + ports[i];
      }
    }
    return "Does not exist";
  }

  public static void register(String newService, int newPort) {
    String[] newServices = new String[services.length + 1];
    int[] newPorts = new int[ports.length + 1];

    for (int i = 0; i < services.length; i++) {
      newServices[i] = services[i];
      newPorts[i] = ports[i];
    }
    
    newServices[services.length] = newService;
    newPorts[ports.length] = newPort;
    services = newServices;
    ports = newPorts;
  }
}

public class Quiz4 {
  public static void main(String[] args) {
    porter test1 = new porter("http", "192.45.7.201");
    System.out.println(test1.build());

    porter test2 = new porter("xbox", "192.45.7.201");
    System.out.println(test2.build());
  }
}