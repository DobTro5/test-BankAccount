import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private BigDecimal balance;
    private String ownerName;
    private String contactPhone;
    private String bankName;

    public BankAccount(String accountNumber, BigDecimal initialBalance, String ownerName, String contactPhone, String bankName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance.setScale(2, RoundingMode.HALF_UP); // Округление до двух знаков
        this.ownerName = ownerName;
        this.contactPhone = contactPhone;
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance.setScale(2, RoundingMode.HALF_UP); // Округление при получении баланса
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Депозит: " + amount + " произведен. Новый баланс: " + getBalance());
        } else {
            System.out.println("Сумма депозита должна быть положительной.");
        }
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Снятие: " + amount + " произведено. Новый баланс: " + getBalance());
        } else {
            System.out.println("Сумма снятия должна быть положительной и не превышать баланс.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Баланс: " + getBalance());
        System.out.println("Владелец: " + ownerName);
        System.out.println("Контактный телефон: " + contactPhone);
        System.out.println("Название банка: " + bankName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пример создания аккаунта
        BankAccount account = new BankAccount("1234567890", new BigDecimal("1000.00"), "Иван Иванов", "+79001234567", "Россельхозбанк");

        account.displayAccountInfo();

        // Пример операций
        account.deposit(new BigDecimal("500.75"));
        account.withdraw(new BigDecimal("200.50"));
        account.displayAccountInfo();

        scanner.close();
    }
}