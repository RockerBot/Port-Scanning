import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
 
class MyPortScanner {
    public static void main(String []args) {
        ArrayList<Integer> ports = new ArrayList<Integer>();
        boolean A[][] = new boolean[256][256];
        for(int i=0;i<256;i++)for(int j=0;j<256;j++)A[i][j]=false;
        // Scanner sc = new Scanner(System.in);
        String hostname = "localhost";
        // System.out.println("Enter hostname pls");
        // hostname = sc.next();
        // sc.close();
        for (int port = 1; port <= 65535; port++) {
            // System.out.println(" "+(port>>8)+" "+(port&255));
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(hostname, port), 1000);
                socket.close();
                System.out.println("Port " + port + " is open");
                A[port>>8][port&255] = true;
                ports.add(port);
            } catch (SocketException e){
                if ((port&4095) == 0) System.out.println("Port " + port + " is closed");
            } catch (Exception e) {
                e.printStackTrace();
                // break;
            }
        }
        System.out.println(" "+ports.size()+" "+ports);
        // System.out.println(""+A);
        // for (boolean[] row: A){
        //     for (boolean i: row)
        //         System.out.print(""+(i?1:0));
        //     System.out.println();
        // }
    }
}
 