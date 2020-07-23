import java.util.List;

public class Producer extends Thread {

    List<Integer> numList;

    public Producer(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (numList) {
                    if (numList.size() > 0) {
                        numList.wait();
                    } else produceList();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void produceList() throws InterruptedException {
        for (int counter = 1; counter <= 5; counter++) {
            Thread.sleep(1000);
            numList.add(counter);
            System.out.println("Produced : " + counter);
        }
        numList.notifyAll();
    }
}
