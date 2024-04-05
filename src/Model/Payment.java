package Model;

import java.util.UUID;

public class Payment {
    private UUID id;
    private double totalPrice;
    private double discount;
    private boolean status;
    private UUID bookingId;
    private PaymentType paymentType;
    private double netTotalPrice;
    private PaymentStatus paymentStatus;

    public Payment(double totalPrice, double netTotalPrice, double discount, boolean status, UUID bookingId, PaymentType paymentType) {
        this.id = UUID.randomUUID();
        this.totalPrice = totalPrice;
        this.netTotalPrice = netTotalPrice;
        this.discount = discount;
        this.status = status;
        this.bookingId = bookingId;
        this.paymentType = paymentType;
        this.paymentStatus = PaymentStatus.Success;
    }

    public double getNetTotalPrice() {
        return netTotalPrice;
    }

    public UUID getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }



    public double getDiscount() {
        return discount;
    }

    public boolean isStatus() {
        return status;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
    public void cancelPayment() {
        this.paymentStatus = PaymentStatus.Cancel;
    }
}
