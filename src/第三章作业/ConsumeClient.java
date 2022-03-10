package 第三章作业;

import java.io.IOException;

public class ConsumeClient {
    public static void main(String[] args) throws IOException {
        MqClient client=new MqClient();
        String message=client.consume();
        System.out.println("获取的消息为:"+message);
    }
}
