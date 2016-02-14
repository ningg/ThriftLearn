package com.meituan.guoning.learn;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by guoning on 16/2/14.
 */
public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     * 
     * @param args
     */
    public static void main(String[] args) {

        int port = 7911;

        try {

            // 服务器地址为本地,端口号为 port.
            TServerTransport serverTransport = new TServerSocket(port);
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new Hello.Processor<>(new HelloServiceImpl());
            // 实例化服务器
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Start Server on port " + port + "....");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
