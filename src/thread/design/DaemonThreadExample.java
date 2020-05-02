package thread.design;

class MyDaemonTask implements Runnable {
    @Override
    public void run() {
        for (; ; ) {
            System.out.println("Task");
        }
    }
}

public class DaemonThreadExample {
    Thread myThread;

    public DaemonThreadExample() {
        myThread = new Thread(new MyDaemonTask());
    }

    public void startThreadWithDaemon(boolean isDaemon){
        myThread.setDaemon(isDaemon);
        myThread.start();
    }


}
