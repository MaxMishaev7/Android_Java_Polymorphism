package ru.mishaev.max;

import taxes.TaxSystem;
import taxes.USNIncome;
import taxes.USNIncomeMinusExpenses;

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

    public int applyDeals(Deal[] deals) {
        // компания применяет все сделки из массива сделок 
        // (увеличивает credit на creditChange, debit на debitChange) 
        System.out.println();       
        for (int i = 0; i < deals.length; i++) {
            if (deals[i].creditChange == 0) {
                debit += deals[i].debitChange;
                System.out.println(deals[i].comment);
            } else if (deals[i].debitChange == 0) {
                credit += deals[i].creditChange;
                System.out.println(deals[i].comment);
            }
        }
        
        // выплачивает все налоги
        setTaxSystem(new USNIncome());
        int taxUSNIncome = taxSystem.calcTaxFor(debit, credit);
        setTaxSystem(new USNIncomeMinusExpenses());
        int taxUSNIncomeMinusExpense = taxSystem.calcTaxFor(debit, credit);        
        System.out.println("\nДоход: " + debit);
        System.out.println("Расход: " + credit);
        System.out.println("\nНалог по схеме \"УСН-Доход\": " + taxUSNIncome);
        System.out.println("Налог по схеме \"УСН-ДоходМинусРасход\": " + taxUSNIncomeMinusExpense);
                
        int debitMinusCredit = debit - credit;
        if (taxUSNIncome < taxUSNIncomeMinusExpense) {
            System.out.println("\nПрименяем схему \"УСН-Доход\"");
            debit -= taxUSNIncome;
        } else if (taxUSNIncomeMinusExpense < taxUSNIncome) {
            System.out.println("\nПрименяем схему \"УСН-ДоходМинусРасход\"");
            debit -= taxUSNIncomeMinusExpense;
        }
        System.out.println("\nСумма после уплаты налогов: " + debit);

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