/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import payment.controllers.StartPageContoller;
import payment.forms.FrmStart;

/**
 *
 * @author mdjukanovic
 */
public class Main {

    public static void main(String[] args) {
        StartPageContoller startPageContoller = new StartPageContoller(new FrmStart());
    }
}
