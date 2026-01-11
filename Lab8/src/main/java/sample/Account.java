package sample;

public class Account {

    private String iban;
    private AccountType type;
    private int daysOverdrawn;
    private Customer customer;
    private Money money;

    public Account(AccountType type, int daysOverdrawn) {
        super();
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }


    public double bankcharge() {
        double result = 4.5;
        result += overdraftCharge();
        return result;
    }

    private double overdraftCharge() {
        if (type.isPremium()) {
            double result = 10;
            if (getDaysOverdrawn() > 7)
                result += (getDaysOverdrawn() - 7) * 1.0;
            return result;
        } else
            return getDaysOverdrawn() * 1.75;
    }

    public double overdraftFee() {
        if (type.isPremium()) {
            return 0.10;
        } else {
            return 0.20;
        }
    }

    public int getDaysOverdrawn() {
        return daysOverdrawn;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setMoneyAmount(double amount) {
        this.money.setAmount(amount);
    }

    public double getMoneyAmount() {
        return money.getAmount();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public AccountType getType() {
        return type;
    }


    public String printCustomer() {
        // Замість ручного збору рядка викликаємо геттери клієнта
        return customer.getName() + " " + customer.getEmail();
    }

    public String getCurrency() {
        return money.getCurrency();
    }

    public String getAccountDetails() {
        return money.toString();
    }
}