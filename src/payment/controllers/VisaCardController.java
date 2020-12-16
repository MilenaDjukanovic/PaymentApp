/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.controllers;

import mock.funds.PaymentInformationService;
import mock.funds.PaymentInformationServiceImpl;
import payment.Payment;
import payment.information.PaymentInformation;
import payment.VisaCardPayment;
import payment.information.VisaPaymentInformation;
import payment.forms.FrmVisaCard;

/**
 *
 * @author mdjukanovic
 */
public class VisaCardController extends SharedController {

    public VisaCardController(FrmVisaCard frmVisaCard) {
        super(frmVisaCard);
    }

    @Override
    public Payment getPaymentMethod(PaymentInformation paymentInformation) {
        return new VisaCardPayment((VisaPaymentInformation) paymentInformation);
    }

    @Override
    public String showFunds(PaymentInformation paymentInformation) {
        VisaPaymentInformation visaCardPayment = (VisaPaymentInformation) paymentInformation;
        double funds = PaymentInformationServiceImpl.getInstance().getVisaFunds(visaCardPayment.getCardNumber(), visaCardPayment.getPin(), visaCardPayment.getOwner());
        return String.valueOf(funds);
    }

}
