/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.controllers;

import mock.funds.PaymentInformationServiceImpl;
import payment.PayPalPayment;
import payment.information.PayPalPaymentInformation;
import payment.Payment;
import payment.information.PaymentInformation;
import payment.forms.FrmPayPal;

/**
 *
 * @author mdjukanovic
 */
public class PayPalController extends SharedController{
   
    
    public PayPalController(FrmPayPal frmPayPal){
      super(frmPayPal);
    }
    
    @Override
    public Payment getPaymentMethod(PaymentInformation paymentInformation) {
            return new PayPalPayment((PayPalPaymentInformation) paymentInformation);
    }

    @Override
    public String showFunds(PaymentInformation paymentInformation) {
        PayPalPaymentInformation payPalPayment = (PayPalPaymentInformation) paymentInformation;
        double funds = PaymentInformationServiceImpl.getInstance().getPayPalFunds(payPalPayment.getEmail(), payPalPayment.getToken());
        return String.valueOf(funds);
    }
}
