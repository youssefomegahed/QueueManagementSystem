import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class Queue {
    BlockingDeque<Customer> queue = new LinkedBlockingDeque<>();

    public void add(Customer customer) {
        queue.addLast(customer);
    }

    public void remove() throws InterruptedException {
        queue.take();
    }

    public int size() {
        return queue.size();
    }

    public Customer getHead() {
        return queue.getFirst();
    }


    
}
