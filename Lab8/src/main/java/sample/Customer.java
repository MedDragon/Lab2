package sample;

public class Customer {
    private String name;
    private String surname;
    private String email;
    private CustomerType customerType;
    private Account account;
    private double companyOverdraftDiscount = 1;

    public Customer(String name, String surname, String email, CustomerType customerType, Account account) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.customerType = customerType;
        this.account = account;
    }

    public Customer(String name, String email, Account account, double companyOverdraftDiscount) {
        this.name = name;
        this.email = email;
        this.customerType = CustomerType.COMPANY;
        this.account = account;
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    public void withdraw(double sum, String currency) {
        checkCurrency(currency);

        double currentAmount = account.getMoneyAmount();
        if (currentAmount < 0) {
            double discount = customerType.getOverdraftDiscount(account.getType().isPremium(), companyOverdraftDiscount);
            account.setMoneyAmount((currentAmount - sum) - sum * account.overdraftFee() * discount);
        } else {
            account.setMoneyAmount(currentAmount - sum);
        }
    }

    private void checkCurrency(String currency) {
        if (!account.getCurrency().equals(currency)) {
            throw new RuntimeException("Can't extract withdraw " + currency);
        }
    }

    public String getFullName() {
        return name + " " + (surname != null ? surname : "") + " ";
    }

    public String printCustomerDaysOverdrawn() {
        return getFullName() + "Account: IBAN: " + account.getIban() + ", Days Overdrawn: " + account.getDaysOverdrawn();
    }

    public String printCustomerMoney() {
        return getFullName() + "Account: IBAN: " + account.getIban() + ", Money: " + account.getMoneyAmount();
    }

    public String printCustomerAccount() {
        return account.getAccountDetails();
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}