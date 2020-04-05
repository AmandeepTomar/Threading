package thread.design;

/**
 * This one is preferred for creating thread coz it is not creating any thread now its
 * jut implements Runnable interface that ensure that this class must have unimplemented run()
 * this just a task */
public class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.print("T");
        }
    }
}
