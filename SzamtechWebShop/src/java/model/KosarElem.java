/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Krisztian
 */
public class KosarElem {
    int Amount;
    String name;
    
    public KosarElem (String name ,int Amount) {
        this.Amount = Amount;
        this.name = name;
    }

    public int getAmount() {
        return Amount;
    }

    public String getName() {
        return name;
    }
}
