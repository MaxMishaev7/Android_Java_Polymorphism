package taxes;

public class USNIncomeMinusExpenses extends TaxSystem{    
    @Override
    public int calcTaxFor(int debit, int credit) {
        // System.out.println("Расчёт по системе УСН-Доходы Минус Расходы");
        int tax = ((debit - credit) / 100) * 15;
        if (tax < 0) {
            tax = 0;
        }            
        return tax;
    }
}
