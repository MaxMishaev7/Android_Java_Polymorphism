package ru.mishaev.max;

import taxes.TaxSystem;

public class Company {
    private String title;  // название компании
    private int debit = 0;  // доходы компании
    private int credit = 0; // расходы компании
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    // добавление расходов и доходов 
    public void shiftMoney(int amount) {
        if (amount >= 0) {
            debit += amount;
            // System.out.println(debit);
        }else if (amount < 0) {
            credit += Math.abs(amount);
            // System.out.println(credit);
        }
    }

    // сеттер для смены системы налогообложения
    public void setTaxSystem(TaxSystem taxSys) {
        taxSystem = taxSys;
    }

    public double getDebit() {
        return debit;
    }

    public double getCredit() {
        return credit;
    }

    public String getCompanyName() {
        return title;
    }

    public int getTax() {
        return taxSystem.calcTaxFor(debit, credit);
    }
}