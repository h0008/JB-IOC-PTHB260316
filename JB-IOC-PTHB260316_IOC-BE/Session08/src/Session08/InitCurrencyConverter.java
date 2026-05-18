package Session08;

public class InitCurrencyConverter {
    public static void main(String[] args) {
        CurrencyConverter.setRate(25400.0);
        System.out.println("Current Rate: " + CurrencyConverter.getRate());
        int vndAmount = 1000000;
        double usdAmount = CurrencyConverter.toUSD(vndAmount);

        System.out.println("VND Amount: " + vndAmount);
        System.out.println("Converted to USD: " + CurrencyConverter.formatUSD(usdAmount));
    }
}

