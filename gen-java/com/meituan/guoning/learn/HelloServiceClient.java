package com.meituan.guoning.learn;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.Scanner;

/**
 * Created by guoning on 16/2/14.
 */
public class HelloServiceClient {

    private static String EXIT_INPUT = "exit";

    /**
     * 调用 Hello 服务
     */
    public static void main(String[] args) {
        String serverIp = "localhost";
        int serverPort = 7911;

        try {
            // 设置调用服务的地址
            TTransport transport = new TSocket(serverIp, serverPort);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);

            // 调用 helloVoid 方法
            client.helloVoid();

            String input = "";
            Scanner scanner = new Scanner(System.in);

            while (!EXIT_INPUT.equalsIgnoreCase(input)) {
                input = scanner.nextLine();
                System.out.println(client.helloString(input));
            }
            transport.close();

        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
