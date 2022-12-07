public class Customer {
    String type; // either vip or regular
    int number; // number assigned to this customer
    int timeDuration; // time needed to serve this customer

    public Customer(String type, int number, int timeDuration) {
        this.type = type;
        this.number = number;
        this.timeDuration = timeDuration;

    }
}
