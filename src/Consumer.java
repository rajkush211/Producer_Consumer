import java.util.List;

public class Consumer extends Thread {

    List<Integer> numList;

    public Consumer(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    public void run() {
        System.out.println("Consumer...");
        try {
            while (true) {
//                synchronized (numList) {
                consumeNumber();
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    private void consumeNumber() throws InterruptedException {
        if (numList.size() != 0) {
            System.out.println("Consumed : " + numList.remove(0));
//            this.sleep(1000);
        }
    }
}
