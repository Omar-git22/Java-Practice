import java.text.NumberFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String curr = NumberFormat.getCurrencyInstance().format(123456.9823);
        System.out.println(curr);

        String curr1 = NumberFormat.getPercentInstance().format(0.478);
        System.out.println(curr1);

        String[] fruits = {"Apple", "Mango"};

        for (String fruit :
                fruits) {
            System.out.println(fruit );
        }
    }
}