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
public class PayPalPaymentInformation extends PaymentInformation{
    
    String email;
    String token;

    public PayPalPaymentInformation() {
        super(0);
    }

    
    public PayPalPaymentInformation(String email, String token, double price) {
        super(price);
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "PayPal";
    }
    
    
    
}
