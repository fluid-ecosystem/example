public class MessageService {

    // One consumer group per topic. Sharing a group across unrelated topics
    // puts members with different subscriptions in the same group, which
    // makes every join trigger a group-wide rebalance and leaves assignment
    // dependent on assignor behaviour across mixed subscriptions.
    // The broker here is 4.2.0 while the clients are 3.7.1, so that is not a
    // property to lean on.

    @KafkaListener(topic = "test-topic1", groupId = "test-group-1", bootstrapServers = "kafka:9092")
    public void handleMessage1(String message) {
        System.out.println("1-Received message at " + System.currentTimeMillis());
        System.out.println("1-Received: " + message);
    }

    @KafkaListener(topic = "test-topic2", groupId = "test-group-2", bootstrapServers = "kafka:9092")
    public void handleMessage2(String message) {
        System.out.println("2-Received message at " + System.currentTimeMillis());
        System.out.println("2-Received: " + message);
    }
}
