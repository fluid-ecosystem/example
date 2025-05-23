public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Initialize listeners
        MessageService service = new MessageService();
        KafkaProcessor.processListeners(service);
        // Keep running to receive messages
        Thread.sleep(5000);
        KafkaProcessor.shutdown();
    }
}