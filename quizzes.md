# programming excises

## Quiz 1
### Create a class that generates a random number between 0 and 256, returns a string.

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

```java
RanNum random = new RanNum();
System.out.println(random.getNumber());
```

<img width="1103" height="140" alt="Screenshot 2026-09-08 at 9 55 42 PM" src="https://github.com/user-attachments/assets/c2734c3a-19a8-4fdd-a6c7-e14d3300f7e7" />

## Quiz 2
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

```java
IPv4Gen addr = new IPv4Gen();
System.out.println(addr.generate());
```

<img width="1107" height="158" alt="Screenshot 2026-09-08 at 9 59 29 PM" src="https://github.com/user-attachments/assets/3ce7ce88-7419-4088-9f59-15e3531cd735" />

## Quiz 3
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

```java
checker test1 = new checker("hello");
System.out.println("hello");
System.out.println(test1.test);

checker test2 = new checker("192.45.7.201");
System.out.println("192.45.7.201");
System.out.println(test2.test);
```

<img width="1109" height="133" alt="Screenshot 2026-09-08 at 10 01 14 PM" src="https://github.com/user-attachments/assets/e5180712-b2be-4a58-9d28-39ce39df1fa7" />

## Quiz 4
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

```java
porter test1 = new porter("http", "192.45.7.201");
System.out.println("http : 192.45.7.201");
System.out.println(test1.build());

porter test2 = new porter("xbox", "192.45.7.201");
System.out.println("xbox : 192.45.7.201");
System.out.println(test2.build());
```

<img width="1109" height="140" alt="Screenshot 2026-09-08 at 10 02 32 PM" src="https://github.com/user-attachments/assets/dd47a405-64a2-4f60-a426-cb30f71e2d3c" />

## Quiz 5
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

```java
dns test1 = new dns("google.com");
System.out.println("google.com");
System.out.println(test1.lookup());

dns test2 = new dns("jisedu.or.id");
System.out.println("jisedu.or.id");
System.out.println(test2.lookup());
```

<img width="1114" height="138" alt="Screenshot 2026-09-08 at 10 03 25 PM" src="https://github.com/user-attachments/assets/26a77568-6129-4b21-ab5e-b7d6f7983913" />

## Quiz 6
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

```java
filter test1 = new filter("127.0.0.1");
System.out.println("127.0.0.1");
System.out.println(test1.check());

filter test2 = new filter("time.com");
System.out.println("time.com");
System.out.println(test2.check());

filter test3 = new filter("example.com");
System.out.println("example.com");
System.out.println(test3.check());
```

<img width="1105" height="149" alt="Screenshot 2026-09-08 at 10 04 25 PM" src="https://github.com/user-attachments/assets/51b19ff3-3ac6-4f50-b1d4-8e2489755321" />

## Quiz 7
### Create the flow diagram for the method below.

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

```java
MACGen gen = new MACGen();
System.out.println(gen.generateMAC());
```

<img width="1200" height="800" alt="Photo on 08-09-26 at 10 17 PM" src="https://github.com/user-attachments/assets/60a92fe7-bb0f-447a-9711-8da68904fe2e" />

## Quiz 8
### Create a class that uses parallel arrays to store a NAT table (Network Address Translation).

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

```java
NATTable nat = new NATTable();
System.out.println(nat.get_new_trans("192.168.1.10", 4500));
System.out.println(nat.get_new_trans("192.168.1.13", 6000));
```

<img width="1111" height="150" alt="Screenshot 2026-09-08 at 10 04 51 PM" src="https://github.com/user-attachments/assets/b1b2460f-b31e-4c25-9042-7ba4e1757475" />

## Quiz 9
### Create a class that receives a 2D array and returns the average across columns and across rows.

```java
class Average {
  private final int[][] matrix;

  public Average(int[][] matrix) {
    this.matrix = matrix;
  }

  public double[] rowAverage() {
    double[] answer = new double[matrix.length];
    double sum = 0;
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) sum += matrix[i][j];
      answer[i] = sum / matrix[i].length;
    }

    return answer;
  }

  public double[] columnAverage() {
    int numRows = matrix.length;
    int numCols = matrix[0].length;
    double[] answer = new double[numCols];

    for (int j = 0; j < numCols; j++) {
      double sum = 0;
      
      for (int i = 0; i < numRows; i++) sum += matrix[i][j];
      answer[j] = sum / numRows;
    }

    return answer;
  }
}
```
#### Proof of work

```java
int[][] numbers = {
  {1, 2, 3},
  {4, 5, 6},
  {7, 8, 9}
};

Average averager = new Average(numbers);
double[] rowAvg = averager.rowAverage();
double[] colAvg = averager.columnAverage();

System.out.println("Matrix         : " + Arrays.deepToString(numbers));
System.out.println("Row Averages   : " + Arrays.toString(rowAvg));
System.out.println("Column Averages: " + Arrays.toString(colAvg));
```

<img width="833" height="92" alt="image" src="https://github.com/user-attachments/assets/0a6bb93e-7e2a-441a-af8f-417e4786e6b5" />

## Quiz 10
### Create a class that receives a 2D array and a integer, returns the array scaled by the constant.

```java
class Matrix {
  private int[][] matrix;

  public Matrix(int[][] matrix) {
    this.matrix = matrix;
  }

  public int[][] scale(int scale) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] scaled = new int[rows][cols];

    for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) scaled[i][j] = matrix[i][j] * scale;
    
    return scaled;
  }

  public void show(int[][] targetMatrix) {
    System.out.println("[");

    for (int[] row : targetMatrix) {
      System.out.print("  [");
      for (int val : row) {
        System.out.printf("%3d", val);
      }
      System.out.println("]");
    }

    System.out.println("]");
  }
}
```
#### Proof of work

```java
int[][] matrix = {
  {1, 2, 3},
  {4, 5, 6},
  {7, 8, 9}
};
int scale = 3;

Matrix test = new Matrix(matrix);
int[][] scaled_matrix = test.scale(scale);

System.out.println("Original Matrix:");
prettyPrint(matrix);

System.out.println("Scaled Matrix:");
test.show(scaled_matrix);
```

<img width="820" height="290" alt="image" src="https://github.com/user-attachments/assets/14e1d3b4-4190-4d9a-873a-cfa31c15ec12" />

## Quiz 11
### Create a class that receives a constant n and returns a identity matrix of size n x n.

```java
class Matrix11 {
  private final int size;

  public Matrix11(int size) {
    this.size = size;
  }

  public int[][] identity() {
    int[][] i_matrix = new int[size][size];
    for (int i = 0; i < size; i++) {
      i_matrix[i][i] = 1;
    }
    return i_matrix;
  }

  public void show(int[][] mat) {
    for (int[] row : mat) {
      System.out.print("[");
      for (int j = 0; j < row.length; j++) {
        System.out.print(row[j] + (j < row.length - 1 ? "," : ""));
      }
      System.out.println("]");
    }
  }
}
```
#### Proof of work

```java
int size = 3;
Matrix11 test = new Matrix11(size);
int[][] i_matrix = test.identity();
test.show(i_matrix);
```

<img width="1411" height="181" alt="image" src="https://github.com/user-attachments/assets/5bae006e-6406-4521-a81c-061cf83ee1a7" />

## Quiz 12
### Create a method that receives a matrix of size n x m: the output is a 1D “vectorized” version of the input.

```java
class Matrix12 {
  private final int[][] matrix;

  public Matrix12(int[][] matrix) {
    this.matrix = matrix;
  }

  public int[] vectorize() {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[] vec = new int[rows * cols];
    int idx = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        vec[idx++] = matrix[i][j];
      }
    }
    return vec;
  }

  public void show(int[] vec) {
    System.out.println(Arrays.toString(vec));
  }
}
```
#### Proof of work

```java
int[][] numbers = { 
  {1, 2, 3, 3}, 
  {4, 5, 6, 6}, 
  {7, 8, 9, 9}
};
Matrix12 test = new Matrix12(numbers);
int[] vectorized_matrix = test.vectorize();
test.show(vectorized_matrix);
```

<img width="1407" height="120" alt="image" src="https://github.com/user-attachments/assets/e9ae2b20-721c-4064-bd6a-79701f0e8539" />

## Quiz 13
### Create a method that receives a 1D array and builds a square matrix, use zero-padded.

```java
class Matrix13 {
  private final int[] numbers;

  public Matrix13(int[] numbers) {
    this.numbers = numbers;
  }

  public int[][] toMatrix() {
    int len = numbers.length;
    int size = (int) Math.ceil(Math.sqrt(len));
    int[][] mat = new int[size][size];
    for (int i = 0; i < len; i++) {
      int row = i / size;
      int col = i % size;
      mat[row][col] = numbers[i];
    }
    return mat;
  }

  public void show(int[][] mat) {
    for (int[] row : mat) {
      System.out.print("[");
      for (int j = 0; j < row.length; j++) {
        System.out.print(row[j] + (j < row.length - 1 ? ", " : ""));
      }
      System.out.println("]");
    }
  }
}
```
#### Proof of work

```java
int[] numbers = {1, 2, 3, 3, 4, 5, 6, 6, 7, 8};
Matrix13 test = new Matrix13(numbers);
int[][] into_matrix = test.toMatrix();
test.show(into_matrix);
```

<img width="1412" height="215" alt="image" src="https://github.com/user-attachments/assets/9e748b4e-1ca2-4690-829a-7e6fda6dc14d" />

## Quiz 14
### Create a method that creates a ascending diagonal matrix.

```java
class Matrix14 {
  public Matrix14() {}

  public int[][] diagonal(int size) {
    int[][] mat = new int[size][size];
    for (int i = 0; i < size; i++) {
      mat[i][i] = i + 1;
    }
    return mat;
  }

  public void show(int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      System.out.print("[");
      for (int j = 0; j < mat[i].length; j++) {
        System.out.print(mat[i][j] + (j < mat[i].length - 1 ? "," : ""));
      }
      System.out.println("]" + (i < mat.length - 1 ? "," : ""));
    }
  }
}
```
#### Proof of work

```java
int size = 4;
Matrix14 test = new Matrix14();
int[][] into_matrix = test.diagonal(size);
test.show(into_matrix);
```

<img width="1405" height="202" alt="image" src="https://github.com/user-attachments/assets/059171ca-7ba1-415d-862c-8c7dbb11b927" />

## Quiz 15
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 16
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 17
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 18
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 19
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 20
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 21
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 22
### DESCRIPTION

```java
class Matrix2 {
  private int size;

  public Matrix2(int size) {
    this.size = size;
  }

  public int[][] eye() {
    int[][] answer = new int[size][size];
    for (int i = 0; i < size; i++) answer[i][i] = 1;
    return answer;
  }

  public void show(int[][] targetMatrix) {
    System.out.println("[");

    for (int[] row : targetMatrix) {
      System.out.print("  [");
      for (int val : row) {
        System.out.printf("%3d", val);
      }
      System.out.println("]");
    }

    System.out.println("]");
  }
}
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 23
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 24
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 25
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 26
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

## Quiz 27
### DESCRIPTION

```java
CODE
```
#### Proof of work

```java
CODE
```

<IMAGE>

