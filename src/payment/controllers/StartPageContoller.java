/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import payment.information.MasterCardPaymentInformation;
import payment.information.PayPalPaymentInformation;
import payment.information.PaymentInformation;
import payment.information.VisaPaymentInformation;
import payment.forms.BasePaymentForm;
import payment.forms.FrmMasterCard;
import payment.forms.FrmPayPal;
import payment.forms.FrmStart;
import payment.forms.FrmVisaCard;
import mock.product.Product;
import mock.product.ProductService;
import mock.product.ProductServiceImpl;

/**
 *
 * @author mdjukanovic
 */
public class StartPageContoller {
    
    private final FrmStart frmStart;
    private ProductService productService = ProductServiceImpl.getInstance();
    
    public StartPageContoller(FrmStart frmStart) {
        this.frmStart = frmStart;
        openForm();
        addActionListener();
    }
    
    public void openForm() {
        prepareView();
        frmStart.setVisible(true);
    }
    
    private void addActionListener() {
        JButton btnBuy = frmStart.getPanelStart().getBtnBuy();
        
        btnBuy.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaymentForm();
            }
            
            private void showPaymentForm() {
                Product product = (Product) frmStart.getPanelStart().getjComboBox1().getSelectedItem();
                double price = product.getPrice();
                PaymentInformation paymentInformation = (PaymentInformation) frmStart.getPanelStart().getComboBoxPaymentMethod().getSelectedItem();
                
                BasePaymentForm basePaymentForm = PaymentObjectResolver.resolvePaymentForm(paymentInformation);
                SharedController sharedController = PaymentObjectResolver.resolveSharedController(paymentInformation, basePaymentForm);

                basePaymentForm.fillData(price);
                sharedController.openForm();
            }
        });
        
    }
    
    private void prepareView() {
        
        fillComboBoxPaymentMethods();
        fillComboBoxProduct();
    }
    
    private void fillComboBoxPaymentMethods() {
        List<PaymentInformation> paymentsInformations = new ArrayList<>();
        
        paymentsInformations.add(new VisaPaymentInformation());
        paymentsInformations.add(new MasterCardPaymentInformation());
        paymentsInformations.add(new PayPalPaymentInformation());
        
        frmStart.getPanelStart().getComboBoxPaymentMethod().setModel(new DefaultComboBoxModel<>(paymentsInformations.toArray()));
    }
    
    private void fillComboBoxProduct() {
        List<Product> products = productService.getAllProducts();
        frmStart.getPanelStart().getjComboBox1().setModel(new DefaultComboBoxModel<>(products.toArray()));
    }
    
}
