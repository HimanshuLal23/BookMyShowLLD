package Dao;

import Model.Movie;
import Model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentDao {
    private static List<Payment> paymentList;
    private PaymentDao() {
        paymentList = new ArrayList<>();
    }

    private static class Holder{
        private static PaymentDao INSTANCE = new PaymentDao();
    }

    public static PaymentDao getInstance() {
        return Holder.INSTANCE;
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }
    public List<Payment> getPaymentList() {
        return paymentList;
    }

}
