public class ParallelMessageService {

    // Its own group, for the reason described in MessageService.

    @KafkaListener(topic = "test-topic3", groupId = "test-group-3", bootstrapServers = "kafka:9092")
    public void handleMessage1(String message) {
        System.out.println("3-Received message at " + System.currentTimeMillis());
        System.out.println("3-Received: " + message);
    }
}
