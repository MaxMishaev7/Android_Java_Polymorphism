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

    public String getComment(){
        return comment;
    }

    public int getDebitChange() {
        return debitChange;
    }

    public int getCreditChange() {
        return creditChange;
    }

    public void setDebitChange(int debitChange) {
        this.debitChange = Math.abs(debitChange);
    }

    public void setCreditChange(int creditChange) {
        this.creditChange = Math.abs(creditChange);
    }
}
