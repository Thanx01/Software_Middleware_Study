package 第三章作业;


import java.io.IOException;

public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient client =new MqClient();
        client.produce("Hello World!");
    }
}
