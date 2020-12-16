/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.information;

/**
 *
 * @author mdjukanovic
 */
public abstract class PaymentInformation {
    
    protected double price;

    public PaymentInformation(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    
}
