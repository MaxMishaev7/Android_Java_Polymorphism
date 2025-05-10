package ru.mishaev.max;

public class Sale extends Deal {
    // продажа    
    public Sale(String comment, int debitChange, int creditChange) {
        super(comment, debitChange, creditChange);
        if (this.creditChange != 0) {this.creditChange = 0;}
    }    
}
