package Service;

import Dao.BookingDao;
import Dao.PaymentDao;
import Factory.PaymentFactory;
import Model.Booking;
import Model.Payment;
import Model.PaymentType;
import Model.Ticket;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaymentService implements ICancelService{
    private PaymentDao paymentDao;

    public PaymentService() {
        paymentDao = PaymentDao.getInstance();
    }

    public Ticket makePayment(double totalPrice, double discount, UUID bookingId, PaymentType paymentType) {
        double netTotalPrice = totalPrice - (totalPrice*discount)/100.0;
        Payment payment = PaymentFactory.getPaymentObject(totalPrice,netTotalPrice,discount,true,bookingId,paymentType);
        paymentDao.addPayment(payment);
        return new Ticket(bookingId,netTotalPrice);
    }
    @Override
    public double cancel(UUID bookingId) {
        Optional<Payment> payment = paymentDao.getPaymentList().stream().filter(payment1 -> payment1.getBookingId().equals(bookingId)).findAny();
        payment.get().cancelPayment();
        return payment.get().getNetTotalPrice();
    }
}
