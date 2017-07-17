public class Main {

    public static void main(String[] args) {
        System.out.println("Beginning...................!");

        /**
         * 仓库初始化
         */
        Store store = new Store(30);

        /**
         * 消费者初始化
         */
        Consumer consumer0 = new Consumer(30, store);
        Consumer consumer1 = new Consumer(20, store);
        Consumer consumer2 = new Consumer(40, store);

        /**
         * 生产者初始化
         */
        Producer producer0 = new Producer(10, store);
        Producer producer1 = new Producer(10, store);
        Producer producer2 = new Producer(10, store);
        Producer producer3 = new Producer(10, store);
        Producer producer4 = new Producer(10, store);
        Producer producer5 = new Producer(10, store);
        Producer producer6 = new Producer(10, store);
        Producer producer7 = new Producer(10, store);

        /**
         * 标记每个生产者/消费者
         */
        consumer0.setName("consumer0");
        consumer1.setName("consumer1");
        consumer2.setName("consumer2");
        producer0.setName("producer0");
        producer1.setName("producer1");
        producer2.setName("producer2");
        producer3.setName("producer3");
        producer4.setName("producer4");
        producer5.setName("producer5");
        producer6.setName("producer6");
        producer7.setName("producer7");

        /**
         * 开始进行生产－消费
         */
        consumer0.start();
        consumer1.start();
        consumer2.start();
        producer0.start();
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();
        producer7.start();
    }
}
