package ru.mishaev.max;

public class Expenditure extends Deal {
    // трата
    public Expenditure(String comment, int debitChange, int creditChange) {
        super(comment, debitChange, creditChange);
        if (debitChange != 0) {debitChange = 0;}
    }
    
}
