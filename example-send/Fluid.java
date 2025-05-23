import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class Fluid {
    public static void main(String[] args) {
        Properties props = new Properties();
        // props.put("bootstrap.servers", "localhost:9092");
        props.put("bootstrap.servers", "kafka-cluster:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        try {
            for (int i = 0; i < 1000; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>(
                        "test-topic1", 
                        "key-" + i, 
                        "Message " + i
                );
                
                producer.send(record, (metadata, exception) -> {
                    if (exception == null) {
                        System.out.printf("Sent message to partition %d, offset %d%n",
                                metadata.partition(), metadata.offset());
                    } else {
                        System.err.println("Error sending message: " + exception.getMessage());
                    }
                });
            }
        } finally {
            producer.close();
        }
    }
}