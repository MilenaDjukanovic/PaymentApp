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
public class MockCardInformation {
    
    String cardNumber;
    String pin;
    String owner;
    double funds;

    public MockCardInformation(String cardNumber, String pin, String owner, double funds) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.owner = owner;
        this.funds = funds;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public String getOwner() {
        return owner;
    }

    public double getFunds() {
        return funds;
    }
    
   public boolean deductFunds(double amount){
        if(funds - amount >= 0){
            funds -= amount;
            return  true;
        }
        return false;
   }
    
}
