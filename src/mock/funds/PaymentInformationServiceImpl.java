/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock.funds;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdjukanovic
 */
public class PaymentInformationServiceImpl implements PaymentInformationService {

    private List<MockCardInformation> visa = new ArrayList<>();
    private List<MockCardInformation> masterCard = new ArrayList<>();
    private List<MockPaypalInformation> paypalCard = new ArrayList<>();
    
    private static PaymentInformationServiceImpl instance;

    public PaymentInformationServiceImpl() {
        mockData();
    }
    
    public static PaymentInformationServiceImpl getInstance(){
        if(instance == null){
            instance = new PaymentInformationServiceImpl();
        }
        return instance;
    }

    private void mockData() {
        visa.add(new MockCardInformation("1234-1234-1234-1234", "1111", "Pera Peric", 50000));
        visa.add(new MockCardInformation("1234-1234-1234-1235", "2222", "Zika Peric", 40000));
        visa.add(new MockCardInformation("1234-1234-1234-1236", "3333", "Mika Peric", 30000));
        visa.add(new MockCardInformation("1234-1234-1234-1237", "4444", "Mara Peric", 1000));

        masterCard.add(new MockCardInformation("2222-2222-2222-2222", "1111", "Ruza Ruzic", 40000));
        masterCard.add(new MockCardInformation("2222-2222-2222-2223", "2222", "Pera Ruzic", 50000));
        masterCard.add(new MockCardInformation("2222-2222-2222-2224", "3333", "Mika Ruzic", 60000));
        masterCard.add(new MockCardInformation("2222-2222-2222-2225", "4444", "Srna Ruzic", 1000));

        paypalCard.add(new MockPaypalInformation("admin@mock.com", "r1r1", 30000));
        paypalCard.add(new MockPaypalInformation("admin1@mock.com", "r2r2", 20000));
        paypalCard.add(new MockPaypalInformation("admin2@mock.com", "r3r3", 1000));
        paypalCard.add(new MockPaypalInformation("admin3@mock.com", "r4r4", 5000));
    }

    @Override
    public void validateVisaPin(String cardNumber, String pin, String owner) throws IllegalArgumentException {
        MockCardInformation card = getVisaCard(cardNumber);
        if (card == null) {
            throw new IllegalArgumentException("Invalid card");
        }
        if (!card.getPin().equals(pin) || !card.getOwner().equals(owner)) {
            throw new IllegalArgumentException("Invalid card");
        }
    }

    private MockCardInformation getVisaCard(String cardNumber) {
        for (MockCardInformation card : visa) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    @Override
    public void validateMasterCardPin(String cardNumber, String pin, String owner) throws IllegalArgumentException {
        MockCardInformation card = getMasterCard(cardNumber);
        if (card == null) {
            throw new IllegalArgumentException("Invalid card");
        }
        if (!card.getPin().equals(pin) || !card.getOwner().equals(owner)) {
            throw new IllegalArgumentException("Invalid card");
        }
    }

    private MockCardInformation getMasterCard(String cardNumber) {
        for (MockCardInformation card : masterCard) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    @Override
    public void validatePayPalToken(String email, String token) throws IllegalArgumentException {
        MockPaypalInformation payPal = getPayPal(email);
        if (payPal == null) {
            throw new IllegalArgumentException("Invalid paypal");
        }
        if(!payPal.getToken().equals(token)){
            throw new IllegalArgumentException("Invalid paypal");
        }
    }

    private MockPaypalInformation getPayPal(String email) {
        for (MockPaypalInformation payPal : paypalCard) {
            if (payPal.getEmail().equals(email)) {
                return payPal;
            }
        }
        return null;
    }

    @Override
    public double getVisaFunds(String cardNumber, String pin, String owner) throws IllegalArgumentException {
        validateVisaPin(cardNumber, pin, owner);
        MockCardInformation card = getVisaCard(cardNumber);
        return card.getFunds();
    }

    @Override
    public double getMasterCardFunds(String cardNumber, String pin, String owner) throws IllegalArgumentException {
        validateMasterCardPin(cardNumber, pin, owner);
        MockCardInformation card = getMasterCard(cardNumber);
        return card.getFunds();
    }

    @Override
    public double getPayPalFunds(String email, String token) throws IllegalArgumentException {
        validatePayPalToken(email, token);
        MockPaypalInformation payPal = getPayPal(email);
        return payPal.getFunds();
    }

    @Override
    public boolean updateVisaFunds(String cardNumber, String pin, String owner, double amount) throws IllegalArgumentException {
        validateVisaPin(cardNumber, pin, owner);
        MockCardInformation card = getVisaCard(cardNumber);
        return card.deductFunds(amount);
    }

    @Override
    public boolean updateMasterCardFunds(String cardNumber, String pin, String owner, double amount) throws IllegalArgumentException {
        validateMasterCardPin(cardNumber, pin, owner);
        MockCardInformation card = getMasterCard(cardNumber);
        return card.deductFunds(amount);
    }

    @Override
    public boolean updatePayPalFunds(String email, String token, double amount) throws IllegalArgumentException {
        validatePayPalToken(email, token);
        MockPaypalInformation payPal = getPayPal(email);
        return payPal.deductFunds(amount);
    }

}
