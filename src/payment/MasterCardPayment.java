/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import payment.information.MasterCardPaymentInformation;

/**
 *
 * @author mdjukanovic
 */
public class MasterCardPayment extends Payment {

    public MasterCardPayment(MasterCardPaymentInformation masterCardPaymentInformation) {
        super(masterCardPaymentInformation);
    }

    @Override
    boolean isCardValid() {
        MasterCardPaymentInformation masterCardPaymentInformation = (MasterCardPaymentInformation) paymentInformation;

        String cardNumber = masterCardPaymentInformation.getCardNumber();
        String pin = masterCardPaymentInformation.getPin();
        String owner = masterCardPaymentInformation.getOwner();

        try {
            paymentService.validateMasterCardPin(cardNumber, pin, owner);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    @Override
    boolean sufficientFunds() {
        MasterCardPaymentInformation masterCardPaymentInformation = (MasterCardPaymentInformation) paymentInformation;

        String cardNumber = masterCardPaymentInformation.getCardNumber();
        String pin = masterCardPaymentInformation.getPin();
        String owner = masterCardPaymentInformation.getOwner();
        double price = masterCardPaymentInformation.getPrice();

        return paymentService.getMasterCardFunds(cardNumber, pin, owner) >= price;
    }

    @Override
    boolean commitTransaction() {
        MasterCardPaymentInformation masterCardPaymentInformation = (MasterCardPaymentInformation) paymentInformation;

        String cardNumber = masterCardPaymentInformation.getCardNumber();
        String pin = masterCardPaymentInformation.getPin();
        String owner = masterCardPaymentInformation.getOwner();
        double price = masterCardPaymentInformation.getPrice();

        return paymentService.updateMasterCardFunds(cardNumber, pin, owner, price);
    }

    @Override
    String showMessage(String message) {
        System.out.println(message);
        return message;
    }

}
