/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import payment.information.PayPalPaymentInformation;

/**
 *
 * @author mdjukanovic
 */
public class PayPalPayment extends Payment{

    public PayPalPayment(PayPalPaymentInformation paymentInformation) {
        super(paymentInformation);
    }

    @Override
    boolean isCardValid() {
        PayPalPaymentInformation palPaymentInformation = (PayPalPaymentInformation) paymentInformation;
        
        String email = palPaymentInformation.getEmail();
        String token = palPaymentInformation.getToken();
        
        try {
            paymentService.validatePayPalToken(email, token);
        } catch (IllegalArgumentException e) {
            return false;
        }
        
        return true;
    }

    @Override
    boolean sufficientFunds() {
        PayPalPaymentInformation palPaymentInformation = (PayPalPaymentInformation) paymentInformation;
        
        String email = palPaymentInformation.getEmail();
        String token = palPaymentInformation.getToken();
        double price = palPaymentInformation.getPrice();
        
        return paymentService.getPayPalFunds(email, token) >= price;
    }

    @Override
    boolean commitTransaction() {
        PayPalPaymentInformation palPaymentInformation = (PayPalPaymentInformation) paymentInformation;
        
        String email = palPaymentInformation.getEmail();
        String token = palPaymentInformation.getToken();
        double price = palPaymentInformation.getPrice();
        
        return paymentService.updatePayPalFunds(email, token, price);
    }

    @Override
    String showMessage(String message) {
        System.out.println(message);
        return message;
    }
    
}
