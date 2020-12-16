/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment;

import payment.information.PaymentInformation;
import mock.funds.PaymentInformationService;
import mock.funds.PaymentInformationServiceImpl;

/**
 *
 * @author mdjukanovic
 */
public abstract class Payment {

    protected final String MESSAGE_TRANSACTION_SUCCESSFULL = "Transaction succesfully comiited!";
    protected final String MESSAGE_TRANSACTION_FAILURE = "Transaction failed!";
    protected final String MESSAGE_TRANNSACTIONS_INSUFFICIENT_FUNDS = "Insufficient funds!";
    protected final String MESSAGE_FAILED_VALIDATION = "Invalid card details!";

    protected PaymentInformation paymentInformation;
    protected PaymentInformationService paymentService = PaymentInformationServiceImpl.getInstance();

    public Payment(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    abstract boolean isCardValid();

    abstract boolean sufficientFunds();

    abstract boolean commitTransaction();

    abstract String showMessage(String message);

    public String execute() {
        if (isCardValid()) {
            if (sufficientFunds()) {
                if (commitTransaction()) {
                    return showMessage(MESSAGE_TRANSACTION_SUCCESSFULL);
                }
                return showMessage(MESSAGE_TRANSACTION_FAILURE);
            }
            return showMessage(MESSAGE_TRANNSACTIONS_INSUFFICIENT_FUNDS);
        }
        return showMessage(MESSAGE_FAILED_VALIDATION);
    }

}
