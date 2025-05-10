package ru.mishaev.max;

public class Expenditure extends Deal {
    // трата
    public Expenditure(String comment, int debitChange, int creditChange) {
        super(comment, debitChange, creditChange);
        if (this.debitChange != 0) {this.debitChange = 0;}
    }
    
}
