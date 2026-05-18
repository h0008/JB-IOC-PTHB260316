package Session08;
import java.text.DecimalFormat;
public class CurrencyConverter {

    private static double rate;
    private CurrencyConverter() {
    }

    public static void setRate(double r) {
        if (r > 0) {
            rate = r;
        } else {
            System.err.println("Error: Exchange rate must be greater than zero.");
        }
    }

    public static double getRate() {
        return rate;
    }

    public static double toUSD(int vnd) {
        if (rate <= 0) {
            System.err.println("Error: Exchange rate is not set properly.");
            return 0.0;
        }
        return vnd / rate;
    }

    public static String formatUSD(double usd) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "$" + df.format(usd);
    }
}
