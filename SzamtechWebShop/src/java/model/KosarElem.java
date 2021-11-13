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
    int ID;
    
    public KosarElem (int ID ,int Amount) {
        this.Amount = Amount;
        this.ID = ID;
    }

    public int getAmount() {
        return Amount;
    }

    public int getID() {
        return ID;
    }
}
