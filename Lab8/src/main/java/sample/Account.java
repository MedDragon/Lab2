package sample;

public class Account {
    private String iban;
    private AccountType type;
    private int daysOverdrawn;
    private Money money;
    private Customer customer;

    public Account(AccountType type, int daysOverdrawn) {
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
        return type.isPremium() ? 0.10 : 0.20;
    }

    // Метод для встановлення ТІЛЬКИ суми (використовується у withdraw)
    public void setMoneyAmount(double amount) {
        if (this.money == null) {
            this.money = new Money(amount, "EUR");
        } else {
            this.money.setAmount(amount);
        }
    }

    // Метод для повної ініціалізації (використовується в тестах)
    public void setMoney(double amount, String currency) {
        this.money = new Money(amount, currency);
    }

    public double getMoneyAmount() {
        return money != null ? money.getAmount() : 0;
    }

    public String getCurrency() {
        return money != null ? money.getCurrency() : "EUR";
    }

    public void setIban(String iban) { this.iban = iban; }
    public String getIban() { return iban; }
    public int getDaysOverdrawn() { return daysOverdrawn; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public AccountType getType() { return type; }

    public String getAccountDetails() {
        return "Account: IBAN: " + iban + ", Money: " + (money != null ? money.toString() : "0 EUR") + ", Account type: " + type;
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }
}