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
//                synchronized (numList) {
                    if (numList.size() < 10) {
                        produceNumber();
                    }
//                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void produceNumber() throws InterruptedException {
        numList.add(numList.size() + 1);
        System.out.println("Produced : " + numList.size());
//        this.sleep(800);
    }
}
