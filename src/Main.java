import java.util.Scanner;
import ru.mishaev.max.Company;
import ru.mishaev.max.Deal;
import ru.mishaev.max.Expenditure;
import ru.mishaev.max.Sale;
import taxes.USNIncome;
import taxes.USNIncomeMinusExpenses;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Netology", new USNIncome());
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
        
        System.out.println("\nПРОДАЖА И ПОКУПКА КУРСОВ");
        String[] products = {
            "Fullstack-разработчик на Python",
            "Python-разработчик с нуля",
            "Java-разработчик с нуля",
            "Go-разработчик с нуля",
            "Фронтенд-разработчик",
            "Разработчик на C++"
        };
        int[] prices = {153900, 125400, 131100, 140200, 118000, 133000};
        Deal[] deals = new Deal[6];

        for (int i = 0; i < 6; i++) {            
            if (i < 3) {
                deals[i] = new Sale(constructComment(products[i], prices[i], true), prices[i], 0);     
            } else {
                deals[i] = new Expenditure(constructComment(products[i], prices[i], false), 0, prices[i]);
            }                   
        } 
        company.setTaxSystem(new USNIncome()); // устанавливаем налоговую систему предприятия 
        int companyDebitMinusCredit = company.applyDeals(deals);   
        System.out.println("Разница между доходом и расходом на момент уплаты налогов: " + companyDebitMinusCredit);   
    } 
    
    public static String constructComment(String prodName, int prodPrice, boolean action) {
        // True - Продажа, False - Покупка
        StringBuilder sb = new StringBuilder();
        if (action) {
            sb.append("Продажа ");
        } else {
            sb.append("Покупка ");
        }
        sb.append(prodName);
        sb.append(" на ");
        sb.append(prodPrice);
        sb.append(" руб.");
        return sb.toString();
    }
}
