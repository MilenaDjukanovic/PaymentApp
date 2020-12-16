/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import mock.funds.PaymentInformationService;
import mock.funds.PaymentInformationServiceImpl;
import payment.Payment;
import payment.information.PaymentInformation;
import payment.forms.BasePaymentForm;

/**
 *
 * @author mdjukanovic
 */
public abstract class SharedController {

    private final BasePaymentForm frmBaseForm;

    public SharedController(BasePaymentForm frmBaseForm) {
        this.frmBaseForm = frmBaseForm;
        addActionListener();
    }

    public void openForm() {
        frmBaseForm.showPaymentForm();
    }

    private void addActionListener() {
        JButton commitTransaction = frmBaseForm.getTransactionButton();
        JButton backButton = frmBaseForm.getBackButton();

        commitTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeTransaction();
            }

            private void executeTransaction() {
                try{
                    PaymentInformation paymentInformation = frmBaseForm.paymentInformation();
                    Payment payment = getPaymentMethod(paymentInformation);
                    String message = payment.execute();
                    JOptionPane.showMessageDialog(frmBaseForm, message + "\n Current funds: " + showFunds(paymentInformation), "Transaction state", JOptionPane.INFORMATION_MESSAGE);
                    frmBaseForm.dispose();
                }catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(frmBaseForm, e.getMessage());
                }
            }

        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmBaseForm.dispose();
            }
        });
    }

    public abstract Payment getPaymentMethod(PaymentInformation paymentInformation);
    
    public abstract String showFunds(PaymentInformation paymentInformation);
}
