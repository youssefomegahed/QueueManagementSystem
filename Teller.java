public class Teller implements Runnable{
    int id;
    boolean busy;

    Queue queue = new Queue();

    public Teller(int id, Queue queue) {
        this.id = id;
        this.queue = queue;
    }








    @Override
    public void run() {
        while (queue.size() > 0) {
         
            int currentNumber = queue.getHead().number;
            int currentTimeDuration = queue.getHead().timeDuration;

            try {
                queue.remove();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            System.out.println("Teller " + id + " is serving customer " + currentNumber);
            
            try {
                Thread.sleep(currentTimeDuration * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println("Teller " + id +  " is done serving customer " + currentNumber);
           

        }
    }





}


// try {
//     Thread thread = new Thread(new Runnable() {
//         @Override
//         public void run() {
//             while (queue.size() > 0) {
//                 // get current thread id
//                 int id = (int) Thread.currentThread().getId();
            
//                 System.out.println("Teller " + id + " is serving customer " + queue.queue.get(0).number);
//                 serveCustomer(queue);
//                 try {
//                     Thread.sleep(queue.queue.get(0).timeDuration * 1000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//                 System.out.println("Teller " + id +  " is done serving customer " + queue.queue.get(0).number);
//             }
//         }
//     });
//     thread.start();
    

// } catch (Exception e) {
//     System.out.println(e);
// }