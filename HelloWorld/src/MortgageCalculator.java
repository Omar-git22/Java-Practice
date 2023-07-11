import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_PER_YEAR = 12;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1000000);
        float annualRate = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principal, annualRate, years);
        printPaymentSchedule(principal, annualRate, years);
    }

    private static void printPaymentSchedule(int principal, float annualRate, byte years) {
        System.out.println("PAYMENT SCHEDULE\n" + "----------------");
        calculateBalance(principal, annualRate, years);
    }

    private static void printMortgage(int principal, float annualRate, byte years) {
        double Mortgage = calculateMortgage(principal, annualRate, years);

        String result = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println("\nMORTGAGE\n" + "--------\n" + "Monthly Payments: " + result + "\n");
    }

    public static void calculateBalance(int principal, double annualRate, byte years){
        short p = 1;

        double monthlyRate = (annualRate / PERCENT) / MONTHS_PER_YEAR;
        short numberOfPayments = (short)(years * MONTHS_PER_YEAR);
        while (p <= numberOfPayments) {
            double loanBalance = principal * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, p)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
            String res = NumberFormat.getCurrencyInstance().format(loanBalance);
            System.out.println(res);
            p++;
        }
    }

    public static double readNumber(String prompt, int min, int max){
        Scanner input = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = input.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.print("Enter a value between " + min + " and " + max + ": ");
        }
        return  value;
    }

    public static double calculateMortgage(int principal, double annualRate, byte years){
        double monthlyRate = (annualRate / PERCENT) / MONTHS_PER_YEAR;
        short numberOfPayments = (short)(years * MONTHS_PER_YEAR);
        double Mortgage = principal * ((monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1));
        return Mortgage;
    }
}
