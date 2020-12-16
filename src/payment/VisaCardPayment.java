/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import payment.information.VisaPaymentInformation;

/**
 *
 * @author mdjukanovic
 */
public class VisaCardPayment extends Payment {

    public VisaCardPayment(VisaPaymentInformation visaPaymentInformation) {
       super(visaPaymentInformation);
    }

    
    @Override
    boolean isCardValid() {
        VisaPaymentInformation visaPaymentInformation = (VisaPaymentInformation) paymentInformation;
        
        String cardNumber = visaPaymentInformation.getCardNumber();
        String pin = visaPaymentInformation.getPin();
        String owner = visaPaymentInformation.getOwner();
        
        try {
             paymentService.validateVisaPin(cardNumber, pin, owner);
        } catch (IllegalArgumentException e) {
            return false;
        }
        
        return true;
    }

    @Override
    boolean sufficientFunds() {
        VisaPaymentInformation visaPaymentInformation = (VisaPaymentInformation) paymentInformation;
        
        String cardNumber = visaPaymentInformation.getCardNumber();
        String pin = visaPaymentInformation.getPin();
        String owner = visaPaymentInformation.getOwner();
        double price = visaPaymentInformation.getPrice();
        return paymentService.getVisaFunds(cardNumber, pin, owner) >= price;
    }

    @Override
    boolean commitTransaction() {
        VisaPaymentInformation visaPaymentInformation = (VisaPaymentInformation) paymentInformation;
        
        String cardNumber = visaPaymentInformation.getCardNumber();
        String pin = visaPaymentInformation.getPin();
        String owner = visaPaymentInformation.getOwner();
        double price = visaPaymentInformation.getPrice();
        
        return paymentService.updateVisaFunds(cardNumber, pin, owner, price);
    }

    @Override
    String showMessage(String message) {
        System.out.println(message);
        return message;
    }
    
}
