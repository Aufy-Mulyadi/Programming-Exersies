# programming excises

## quiz 1
### Create a class that generates a random number between 0 and 256, returns a string

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
#### Proof of work
<img width="1103" height="140" alt="Screenshot 2026-09-08 at 9 55 42 PM" src="https://github.com/user-attachments/assets/c2734c3a-19a8-4fdd-a6c7-e14d3300f7e7" />

## quiz 2
### Create a class that generates a valid IPv4 address. You may use the class RanNum()


```java
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
```
#### Proof of work
<img width="1107" height="158" alt="Screenshot 2026-09-08 at 9 59 29 PM" src="https://github.com/user-attachments/assets/3ce7ce88-7419-4088-9f59-15e3531cd735" />

## quiz 3
### Create a class that receives a input String add and it checks for valid IPv4 address.


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
#### Proof of work
<img width="1109" height="133" alt="Screenshot 2026-09-08 at 10 01 14 PM" src="https://github.com/user-attachments/assets/e5180712-b2be-4a58-9d28-39ce39df1fa7" />

## quiz 4
### Create a class receives a service name, ip address and build a ip:port address.

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
#### Proof of work
<img width="1109" height="140" alt="Screenshot 2026-09-08 at 10 02 32 PM" src="https://github.com/user-attachments/assets/dd47a405-64a2-4f60-a426-cb30f71e2d3c" />

## quiz 5
### Create a class that uses parallel arrays to store a table of hostnames and their IP addresses.

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
#### Proof of work
<img width="1114" height="138" alt="Screenshot 2026-09-08 at 10 03 25 PM" src="https://github.com/user-attachments/assets/26a77568-6129-4b21-ab5e-b7d6f7983913" />

## quiz 6
### Create a class that uses parallel arrays to filter traffic in network using ip/hostnames.

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
#### Proof of work
<img width="1105" height="149" alt="Screenshot 2026-09-08 at 10 04 25 PM" src="https://github.com/user-attachments/assets/51b19ff3-3ac6-4f50-b1d4-8e2489755321" />

## quiz 7
### Create the flow diagram for the method below

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
#### Proof of work
<img width="1200" height="800" alt="Photo on 08-09-26 at 10 17 PM" src="https://github.com/user-attachments/assets/60a92fe7-bb0f-447a-9711-8da68904fe2e" />

## quiz 8
### Create a class that uses parallel arrays to store a NAT table (Network Address Translation)

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
#### Proof of work
<img width="1111" height="150" alt="Screenshot 2026-09-08 at 10 04 51 PM" src="https://github.com/user-attachments/assets/b1b2460f-b31e-4c25-9042-7ba4e1757475" />


