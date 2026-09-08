package Files;

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

public class Quiz8 {
  public static void main(String[] args) {
    NATTable nat = new NATTable();
    System.out.println(nat.get_new_trans("192.168.1.10", 4500));
    System.out.println(nat.get_new_trans("192.168.1.13", 6000));
  }
}