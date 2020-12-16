/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock.funds;

/**
 *
 * @author mdjukanovic
 */
public interface PaymentInformationService {
    
    public void validateVisaPin(String cardNumber, String pin, String owner) throws IllegalArgumentException;
    
    public void validateMasterCardPin(String cardNumber, String pin, String owner) throws IllegalArgumentException;
    
    public void validatePayPalToken(String email, String token) throws IllegalArgumentException;
    
    public double getVisaFunds(String cardNumber, String pin, String owner) throws IllegalArgumentException;
    
    public double getMasterCardFunds(String cardNumber, String pin, String owner) throws IllegalArgumentException;
    
    public double getPayPalFunds(String email, String token) throws IllegalArgumentException;
    
    public boolean updateVisaFunds(String cardNumber, String pin, String owner, double amount) throws IllegalArgumentException;
    
    public boolean updateMasterCardFunds(String cardNumber, String pin, String owner, double amount) throws IllegalArgumentException;
    
    public boolean updatePayPalFunds(String email, String token, double amount) throws IllegalArgumentException;
    
    
}
