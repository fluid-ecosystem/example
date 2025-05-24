public class MessageService {
    @KafkaListener(topic = "test-topic1", groupId = "test-group", bootstrapServers = "kafka:9092")
    public void handleMessage1(String message) {
        // print time
        System.out.println("1-Received message at " + System.currentTimeMillis());
        System.out.println("1-Received: " + message);
    }
    @KafkaListener(topic = "test-topic2", groupId = "test-group", bootstrapServers = "kafka:9092")
    public void handleMessage2(String message) {
        // print time
        System.out.println("2-Received message at " + System.currentTimeMillis());
        System.out.println("2-Received: " + message);
    }
}
