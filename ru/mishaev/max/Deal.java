package ru.mishaev.max;

public class Deal {
    protected String comment;
    protected int debitChange;
    protected int creditChange;

    public Deal(String comment, int debitChange, int creditChange) {
        this.comment = comment;
        this.debitChange = debitChange;
        this.creditChange = creditChange;
    }
}
