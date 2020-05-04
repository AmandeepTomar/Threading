package producerconsumerpoblem;



public class MessageQueueWaitNotify extends BaseMessageQueue {


    MessageQueueWaitNotify(int limit) {
        super(limit);
    }


    public synchronized void enqueue(String message){
        if (isFull()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        messages.add(message);
        this.notify();
    }

    public synchronized String dequeue(){
        if (isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String msg=messages.remove(0);
        this.notify();
        return msg;
    }
}
