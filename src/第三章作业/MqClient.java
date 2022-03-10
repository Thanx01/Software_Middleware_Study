package 第三章作业;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import static java.lang.System.out;

public class MqClient {

//    生产消息
    public static void produce(String message) throws Exception {
        Socket socket=new Socket(InetAddress.getLocalHost(),BrokerServer.SERVICE_PORT);
        try (PrintWriter out = new PrintWriter(socket.getOutputStream()))
        {
            out.println(message);
            out.flush();
        }

    }
//    消费消息
    public static String consume() throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());)
        {
            out.println("CONSUME");
            out.flush();
            return in.readLine();
        }
    }
}
