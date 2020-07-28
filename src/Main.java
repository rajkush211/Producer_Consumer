import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        Producer producer = new Producer(numberList);
        Consumer consumer = new Consumer(numberList);
        producer.setPriority(Thread.MAX_PRIORITY);
        consumer.setPriority(Thread.MIN_PRIORITY);
        producer.start();
        consumer.start();
    }
}
