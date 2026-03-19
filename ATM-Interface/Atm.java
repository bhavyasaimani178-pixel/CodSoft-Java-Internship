import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Amount Deposited Successfully.");
        } else {
            System.out.println("❌ Invalid Deposit Amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("✅ Withdrawal Successful.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient Balance.");
        } else {
            System.out.println("❌ Invalid Withdrawal Amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(10000);

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;

                case 3:
                    System.out.println("💰 Current Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("🙏 Thank you for using ATM.");
                    break;

                default:
                    System.out.println("❌ Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
