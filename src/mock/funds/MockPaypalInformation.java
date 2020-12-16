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
public class MockPaypalInformation {

    String email;
    String token;
    double funds;

    public MockPaypalInformation(String email, String token, double funds) {
        this.email = email;
        this.token = token;
        this.funds = funds;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public double getFunds() {
        return funds;
    }

    public boolean deductFunds(double amount) {
        if (funds - amount >= 0) {
            funds -= amount;
            return true;
        }
        return false;
    }

}
