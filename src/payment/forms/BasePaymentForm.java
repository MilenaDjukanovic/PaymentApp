/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.forms;

import javax.swing.JButton;
import javax.swing.JFrame;
import payment.information.PaymentInformation;

/**
 *
 * @author mdjukanovic
 */
public abstract class BasePaymentForm extends JFrame {

    
    public void showPaymentForm() {
        setVisible(true);
    }

    public abstract void fillData(double price);
    
    public abstract PaymentInformation paymentInformation();
    
    public abstract JButton getTransactionButton();
    
    public abstract JButton getBackButton();
}
