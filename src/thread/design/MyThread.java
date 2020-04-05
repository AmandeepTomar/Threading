package thread.design;

/**
 * This one is not preferred coz we just extend the thread class and not adding any additional properties to the thread class    */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.print("MyThread");
        }
    }
}
