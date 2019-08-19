package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.Request2Impl;

import java.io.IOException;

public class Server2 {
    private static final int PORT = 2223;

    private final Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server2 server = new Server2();
        //block Server防止关闭
        server.blockUntilShutdown();
    }

    public Server2() throws IOException {
        //启动server
        this.server = ServerBuilder.forPort(PORT)
                .addService(new Request2Impl())
                .build()
                .start();
        System.out.println("Server2 Started ...");
    }
    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
