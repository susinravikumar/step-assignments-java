class Payment {
    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends Payment {
    void payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);
        System.out.println("Charged (card, incl. fee): Rs " + total);
    }
}

class PaymentProcessor {
    double totalCollected = 0;

    void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cp = (CardPayment) payment;
            double total = amount + (amount * 0.02);
            cp.payWithProcessingFee(amount);
            totalCollected += total;
        } else {
            payment.pay(amount);
            totalCollected += amount;
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };
        double[] amounts = {100, 50, 200, 75, 120};

        PaymentProcessor processor = new PaymentProcessor();
        for (int i = 0; i < payments.length; i++) {
            processor.processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + processor.totalCollected);
    }
}
