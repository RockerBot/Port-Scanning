// import java.io.*;
// import java.net.*;
// public class MyPortScanner{
//     public static void main(String args[]){
//         System.out.println("Hello");
//     }
//     public void runPortScan(String ip, int nbrPortMaxToScan) throws IOException {
//         ConcurrentLinkedQueue openPorts = new ConcurrentLinkedQueue<>();
//         ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
//         AtomicInteger port = new AtomicInteger(0);
//         while (port.get() < nbrPortMaxToScan) {
//                 final int currentPort = port.getAndIncrement();
//                 executorService.submit(() -> {
//                         try {
//                                 Socket socket = new Socket();
//                                 socket.connect(new InetSocketAddress(ip, currentPort), timeOut);
//                                 socket.close();
//                                 openPorts.add(currentPort);
//                                 System.out.println(ip + " ,port open: " + currentPort);
//                         } catch (IOException e) {
//                                 System.err.println(e);
//                         }
//                 });
//         }
//         executorService.shutdown();
//         try {
//                 executorService.awaitTermination(10, TimeUnit.MINUTES);
//         } catch (InterruptedException e) {
//                 throw new RuntimeException(e);
//         }
//         List openPortList = new ArrayList<>();
//         System.out.println("openPortsQueue: " + openPorts.size());
//         while (!openPorts.isEmpty()) {
//                 openPortList.add(openPorts.poll());
//         }
//         openPortList.forEach(p -> System.out.println("port " + p + " is open"));
// }
// }


import java.net.*;
import java.util.Scanner;
 
class MyPortScanner {
    public static void main(String []args) {
        // Scanner sc = new Scanner(System.in);
        String hostname = "localhost";
        // System.out.println("Enter hostname pls");
        // hostname = sc.next();
        // sc.close();
        for (int port = 1; port <= 65535; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(hostname, port), 1000);
                socket.close();
                System.out.println("Port " + port + " is open");
            } catch (SocketException e){
                // System.out.println("Port " + port + " is closed");
            } catch (Exception e) {
                // e.printStackTrace();
                // break;
            }
        }
    }
}
 