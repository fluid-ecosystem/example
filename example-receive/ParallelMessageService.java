public class ParallelMessageService {
    @KafkaListener(topic = "test-topic3", groupId = "test-group", bootstrapServers = "kafka:9092")
    public void handleMessage1(String message) {
        // print time
        System.out.println("3-Received message at " + System.currentTimeMillis());
        System.out.println("3-Received: " + message);
    }
}
