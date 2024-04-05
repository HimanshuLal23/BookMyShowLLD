package Factory;

import Model.Booking;
import Model.Payment;
import Model.PaymentType;
import Model.Seat;

import java.util.List;
import java.util.UUID;

public class PaymentFactory {

    private PaymentFactory() {

    }
    public static Payment getPaymentObject(double totalPrice, double netTotalPrice, double discount, boolean status, UUID bookingId, PaymentType paymentType) {
        return new Payment(totalPrice, netTotalPrice, discount,status,bookingId,paymentType);
    }
}
