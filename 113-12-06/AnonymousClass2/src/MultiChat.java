public class MultiChat {
    public static void main(String[] args) {
        var c1 = new Client("127.0.0.1", "Caterpillar");
        var c2 = new Client("192.168.0.2", "Justin");
        var c3 = new Client("112.88.99.5", "Dolly");

        var queue = new ClientQueue();

        
        queue.enqueue(c1);
        queue.enqueue(c2);
        queue.enqueue(c3);

        queue.pay(c1);
        queue.pay(c3);

        queue.dequeue(c1);
        queue.dequeue(c2);

        for (Client client : queue.getClients()) {
            System.out.println("店內顧客：" + client.name);
        }
    }
}