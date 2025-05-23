public class MessageService {
    @KafkaListener(topic = "test-topic1", groupId = "test-group")
    public void handleMessage(String message) {
        // print time
        System.out.println("Received message at " + System.currentTimeMillis());
        System.out.println("Received: " + message);
    }
}