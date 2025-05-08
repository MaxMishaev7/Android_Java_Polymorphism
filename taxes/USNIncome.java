package taxes;

public class USNIncome extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        // System.out.println("Расчёт по системе УСН-Доходы"); 
        return (debit / 100) * 6; // 6% от доходов       
    }
}