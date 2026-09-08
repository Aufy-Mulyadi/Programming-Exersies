# programming excises

## quiz 1

```java
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
```

## quiz 2

```java
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
```

## quiz 3

```java
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
```

## quiz 4

```java
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
```

## quiz 5

```java
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
```

## quiz 6

```java
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
```

## quiz 7

```java
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
```

## quiz 8

```java
class NATTable {
  private String[] sourceIpPorts;
  private String[] transIpPorts;
  private int count;

  public NATTable() {
    sourceIpPorts = new String[10];
    transIpPorts = new String[10];
    
    sourceIpPorts[0] = "192.168.1.10:4500";
    transIpPorts[0] = "203.0.113.55:10001";
    
    sourceIpPorts[1] = "192.168.1.11:5100";
    transIpPorts[1] = "203.0.113.55:10002";
    
    sourceIpPorts[2] = "192.168.1.12:5100";
    transIpPorts[2] = "203.0.113.55:10003";
    
    count = 3;
  }

  public String get_new_trans(String ip, int port) {
    String key = ip + ":" + port;
    for (int i = 0; i < count; i++) {
      if (sourceIpPorts[i].equals(key)) {
        return transIpPorts[i];
      }
    }

    if (count >= sourceIpPorts.length) {
      String[] newSource = new String[sourceIpPorts.length * 2];
      String[] newTrans = new String[transIpPorts.length * 2];

      for (int i = 0; i < sourceIpPorts.length; i++) {
        newSource[i] = sourceIpPorts[i];
        newTrans[i] = transIpPorts[i];
      }

      sourceIpPorts = newSource;
      transIpPorts = newTrans;
    }

    String newTransPort = "203.0.113.55:" + (10000 + count);
    sourceIpPorts[count] = key;
    transIpPorts[count] = newTransPort;
    count++;

    return newTransPort;
  }
}
```

