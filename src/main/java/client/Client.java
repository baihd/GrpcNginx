package client;

import com.proto.MyRPCGrpc;
import com.proto.MyThing;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Client {

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    private final ManagedChannelBuilder<?> managedChannelBuilder;

    private final MyRPCGrpc.MyRPCBlockingStub blockingStub;

    private final ManagedChannel channel;

    public static void main(String[] args) throws Exception {
        Client client = new Client("localhost", 8080);
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            //进行rpc调用的真正逻辑
            client.sayHi("client say" + i);
        }
        client.shutdown();
    }


    public Client(String name, int port) {
        managedChannelBuilder = ManagedChannelBuilder.forAddress(name, port);
        channel = managedChannelBuilder.usePlaintext().build();
        blockingStub = MyRPCGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void sayHi(String name) {
        MyThing.Request request = MyThing.Request.newBuilder().setName(name).build();
        MyThing.Response response = blockingStub.sayHi(request);
        logger.info(response.getName());
    }
}
