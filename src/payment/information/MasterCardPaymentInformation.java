/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.information;

/**
 *
 * @author mdjukanovic
 */
public class MasterCardPaymentInformation extends PaymentInformation {

    String owner;
    String cardNumber;
    String pin;

    public MasterCardPaymentInformation() {
        super(0);
    }

    
    public MasterCardPaymentInformation(String owner, String cardNumber, String pin, double price) {
        super(price);
        this.owner = owner;
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "MasterCard";
    }
}
