package ru.mishaev.max;

import taxes.TaxSystem;

public class Company {
    private String title; // название компании
    private int debit = 0; // доходы компании
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
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    // сеттер для смены системы налогообложения
    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public int applyDeals(Deal[] deals) {
        // компания применяет все сделки из массива сделок
        // (увеличивает credit на creditChange, debit на debitChange)
        System.out.println();
        for (int i = 0; i < deals.length; i++) {
            if (deals[i].creditChange == 0) {
                debit += deals[i].getDebitChange();
                System.out.println(deals[i].comment);
            } else if (deals[i].getDebitChange() == 0) {
                credit += deals[i].creditChange;
                System.out.println(deals[i].comment);
            } else {
                debit += deals[i].getDebitChange();
                credit += deals[i].getCreditChange();
            }
        }
        System.out.println("\nДоход компании: " + debit);
        System.out.println("Расход компании: " + credit);

        // выплачивает все налоги
        int debitMinusCredit = debit - credit; // разница между доходами и расходами на момент уплаты налогов
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("\nСумма после уплаты налогов: " + (debit - tax));

        // возвращает из метода разницу доходов и расходов,
        // которая была на момент старта уплаты налогов
        return debitMinusCredit;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public String getCompanyName() {
        return title;
    }

    public int getTax() {
        return taxSystem.calcTaxFor(debit, credit);
    }
}