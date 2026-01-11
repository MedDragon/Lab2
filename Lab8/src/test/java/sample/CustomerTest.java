package sample;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CustomerTest {

    @Test
    public void testWithdrawPersonWithNormalAccount() throws Exception {
        Account account = getAccountByTypeAndMoney(false, 34.0);
        Customer customer = getPersonCustomer(account);
        customer.withdraw(10, "EUR");
        assertThat(account.getMoneyAmount(), is(24.0));
    }

    @Test
    public void testWithdrawPersonWithPremiumAccountAndOverdraft() throws Exception {
        Account account = getAccountByTypeAndMoney(true, -10.0);
        Customer customer = getPersonCustomer(account);
        customer.withdraw(10, "EUR");
        assertThat(account.getMoneyAmount(), is(-21.0));
    }

    @Test
    public void testPrintCustomerAccountNormal() throws Exception {
        Customer customer = getPersonWithAccount(false);
        assertThat(customer.printCustomerAccount(), is("Account: IBAN: RO023INGB434321431241, Money: 34.0 EUR, Account type: normal"));
    }

    private Customer getPersonWithAccount(boolean premium) {
        AccountType accountType = new AccountType(premium);
        Account account = new Account(accountType, 9);
        Customer customer = getPersonCustomer(account);
        account.setIban("RO023INGB434321431241");
        account.setMoney(34.0, "EUR"); // Використовуємо setMoney для ініціалізації
        return customer;
    }

    private Account getAccountByTypeAndMoney(boolean premium, double money) {
        AccountType accountType = new AccountType(premium);
        Account account = new Account(accountType, 9);
        account.setIban("RO023INGB434321431241");
        account.setMoney(money, "EUR"); // Використовуємо setMoney
        return account;
    }

    private Customer getPersonCustomer(Account account) {
        Customer customer = new Customer("danix", "dan", "dan@mail.com", CustomerType.PERSON, account);
        account.setCustomer(customer);
        return customer;
    }

    private Customer getCompanyCustomer(Account account) {
        Customer customer = new Customer("company", "company@mail.com", account, 0.50);
        account.setCustomer(customer);
        return customer;
    }
}