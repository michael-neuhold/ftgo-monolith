package net.chrisrichardson.ftgo.consumerservice.external;


import net.chrisrichardson.ftgo.consumerservice.external.client.ConsumerServiceClient;
import net.chrisrichardson.ftgo.consumerservice.external.model.ConsumerExternal;
import org.junit.Test;

import java.util.Optional;

public class ConsumerServiceInternalClientTest {

    @Test
    public void test1() {

        ConsumerServiceClient consumerServiceClient = new ConsumerServiceClient();

        Optional<ConsumerExternal> consumerExternal =
                consumerServiceClient.create(new ConsumerExternal(null, "Michael", "Neuhold", "michael@neuhold.dev"));

        System.out.println("test: " + consumerExternal);

    }

}
