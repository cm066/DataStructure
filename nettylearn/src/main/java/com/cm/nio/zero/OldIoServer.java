package com.cm.nio.zero;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author cm
 * @create 2021/11/1-11:43 下午
 */
public class OldIoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true){
                Socket socket = serverSocket.accept();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                byte[] bytes = new byte[1024];
                while (true){
                    int read = dataInputStream.read(bytes,0, bytes.length);
                    if (read == -1){
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
