import java.util.Scanner;
import ru.mishaev.max.Company;
import taxes.USNIncome;
import taxes.USNIncomeMinusExpenses;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Рога и копыта", new USNIncome());
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите доходы предприятия (руб.): ");
        int new_debit = scan.nextInt();
        System.out.print("Введите расходы предприятия (отрицательное число в руб.): ");
        int new_credit = scan.nextInt();        
        scan.close();
        
        company.shiftMoney(new_debit);
        company.shiftMoney(new_credit);

        // получаем налоги по первой системе налогообложения    
        int taxUSNIncome = company.getTax();

         // изменяем систему налогообложения  
        company.setTaxSystem(new USNIncomeMinusExpenses());

        // получаем налоги по второй системе налогообложения
        int taxUSNIncomeMinusExpense = company.getTax();

        // выводим на экран расчёт налогов по обеим системам
        System.out.println("\nНалоги предприятия " + "\"" + company.getCompanyName() + "\"");
        System.out.println("Расчёт по \"УСН-Доходы\": " + taxUSNIncome);
        System.out.println("Расчёт по \"УСН-Доходы минус Расходы\": " + taxUSNIncomeMinusExpense);

        if (taxUSNIncome < taxUSNIncomeMinusExpense) {
            System.out.println("Предлагаем выбрать оплату по системе УСН-Доходы");
        } else if (taxUSNIncomeMinusExpense < taxUSNIncome) {
            System.out.println("Предлагаем выбрать оплату по системе УСН-Доходы Минус Расходы");    
        } else {
            System.out.println("Можете выбрать любую систему налогообложения. Разницы не будет");
        }
    }    
}
