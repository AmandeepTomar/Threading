package producerconsumerpoblem;

import java.util.ArrayList;
import java.util.List;

public class BaseMessageQueue {
    protected int limit;
    protected List<String> messages;

    BaseMessageQueue(int limit) {
        this.limit = limit;
        messages = new ArrayList<>();
    }


    public boolean isFull(){
        return messages.size()==limit;
    }

    public boolean isEmpty(){
        return messages.size()==0;
    }
}
