package com.cm.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cm
 * @create 2021/10/29-11:31 下午
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket  serverSocket = new ServerSocket(6666);
        ExecutorService service = Executors.newFixedThreadPool(3);
        System.out.println("服务器启动了");
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println("有一个客户端连接了");
            service.execute(new Runnable() {
                @Override
                public void run() {
                    handle(accept);
                }
            });
        }
    }

    public static final  void handle(Socket socket){
        byte[] bytes = new byte[1024];
        try {
            InputStream inputStream = socket.getInputStream();
            while (true){
                int read = inputStream.read(bytes);
                if (read != -1){
                    System.out.println(new String(bytes,0,read));
                }else {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("socket关闭");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
