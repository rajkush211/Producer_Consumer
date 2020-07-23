import java.util.List;

public class Consumer extends Thread {

    List<Integer> numList;

    public Consumer(List<Integer> numList) {
        this.numList = numList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (numList) {
                    if (numList.size() == 0) {
                        numList.wait();
                    } else consumeList();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    private void consumeList() throws InterruptedException {
        while (!numList.isEmpty()){
            Thread.sleep(1000);
            System.out.println("Consumed : " + numList.remove(0));
        }
        numList.notifyAll();
    }
}
