/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.controllers;

import mock.funds.PaymentInformationServiceImpl;
import payment.MasterCardPayment;
import payment.information.MasterCardPaymentInformation;
import payment.Payment;
import payment.information.PaymentInformation;
import payment.forms.FrmMasterCard;

/**
 *
 * @author mdjukanovic
 */
public class MasterCardController extends SharedController{

    public MasterCardController(FrmMasterCard frmMasterCard) {
        super(frmMasterCard);
    }

    @Override
    public Payment getPaymentMethod(PaymentInformation paymentInformation) {
            return new MasterCardPayment((MasterCardPaymentInformation) paymentInformation);
    }

    @Override
    public String showFunds(PaymentInformation paymentInformation) {
        MasterCardPaymentInformation masterCardPayment = (MasterCardPaymentInformation) paymentInformation;
        double funds = PaymentInformationServiceImpl.getInstance().getMasterCardFunds(masterCardPayment.getCardNumber(), masterCardPayment.getPin(), masterCardPayment.getOwner());
        return String.valueOf(funds);
    }

}
