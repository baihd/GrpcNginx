package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.Request1Impl;

import java.io.IOException;

public class Server1 {
    private static final int PORT = 2222;

    private final Server server;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server1 server = new Server1();
        //block Server防止关闭
        server.blockUntilShutdown();
    }

    public Server1() throws IOException {
        //启动server
        this.server = ServerBuilder.forPort(PORT)
                .addService(new Request1Impl())
                .build()
                .start();
        System.out.println("Server1 Started ...");
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
