import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class Fluid {
    public static void main(String[] args)  throws InterruptedException {
        try {
            for (int i = 0; i < 1000; i++) {
                String key = "key-" + i;
                String message = "Message " + i;
                KafkaMessenger.sendMessage("test-topic1", message);
            }
        } finally {
            System.out.println("Shutting down Kafka producer...");
            KafkaMessenger.shutdown();
            System.out.println("Kafka producer shut down.");
        }
        Thread.sleep(50000);
    }
}