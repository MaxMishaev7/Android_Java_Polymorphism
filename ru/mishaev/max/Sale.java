package ru.mishaev.max;

public class Sale extends Deal {
    // продажа    
    public Sale(String comment, int debitChange, int creditChange) {
        super(comment, debitChange, creditChange);
        if (creditChange != 0) {creditChange = 0;}
    }
    
}
