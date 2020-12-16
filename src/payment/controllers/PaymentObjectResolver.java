/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.controllers;

import payment.information.MasterCardPaymentInformation;
import payment.information.PaymentInformation;
import payment.information.VisaPaymentInformation;
import payment.forms.BasePaymentForm;
import payment.forms.FrmMasterCard;
import payment.forms.FrmPayPal;
import payment.forms.FrmVisaCard;

/**
 *
 * @author mdjukanovic
 */
public class PaymentObjectResolver {

    private PaymentObjectResolver() {
    }

    public static BasePaymentForm resolvePaymentForm(PaymentInformation paymentInformation) {
        if (paymentInformation instanceof VisaPaymentInformation) {
            return new FrmVisaCard();
        } else if (paymentInformation instanceof MasterCardPaymentInformation) {
            return new FrmMasterCard();
        } else {
            return new FrmPayPal();
        }
    }

    public static SharedController resolveSharedController(PaymentInformation paymentInformation, BasePaymentForm basePaymentForm) {
        if (paymentInformation instanceof VisaPaymentInformation) {
            return new VisaCardController((FrmVisaCard) basePaymentForm);
        } else if (paymentInformation instanceof MasterCardPaymentInformation) {
            return new MasterCardController((FrmMasterCard) basePaymentForm);
        } else {
            return new PayPalController((FrmPayPal) basePaymentForm);
        }
    }

}
