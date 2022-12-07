import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueManager {



    public static void main(String[] args) {

        
        Queue queue = new Queue();


        int N = 3;
        int M = 10;

        // customer numbers range between 1 and M
        // makes more sense than the 0 to M mentioned in the assignment
        for (int i = 1; i <= M; i++) {
            int rand = (int) (Math.random() * 10) + 1; // random number between 1 and 10
            String type = (rand <= 3) ? "vip" : "regular"; // 30% of customers are vip, 70% are regular
            int timeDuration = (int) (Math.random() * 10) + 1; // random number between 1 and 10 seconds
            Customer customer = new Customer(type, i, timeDuration);
            queue.add(customer);
        }


        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= N; i++) {
            executorService.execute(new Teller(i, queue));
        }


        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // wait for all threads to finish
        }

        System.out.println("All tellers finished");

    }

}

