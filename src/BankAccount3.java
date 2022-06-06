
import java.util.Scanner;

public class BankAccount3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Saving saving = null;
        FixedDeposit fAcc = null;
        CurrentAccount cAcc = null;
        for (int t = 1; t <= 3; t++) {
            String name = scan.nextLine();
            String code = scan.nextLine();
            double money1 = scan.nextDouble();
            if (t == 1) {
                scan.nextLine();
                saving = new Saving(name, code, money1);
            } else if (t == 2) {
                double money2 = scan.nextDouble();
                scan.nextLine(); //Skip the remainder of the double line.
                fAcc = new FixedDeposit(name, code, money1, money2);

            } else if (t == 3) {
                double money2 = scan.nextDouble();
                scan.nextLine(); // Skip the remainder of the double line.
                cAcc = new CurrentAccount(name, code, money1, money2);
            }
        }
        int N = scan.nextInt();
        for (int i = 0; i < N; ++i) {
            int M = scan.nextInt();
            switch (M) {
                case 1: {
                    int num = scan.nextInt();
                    // your code to scan input
                    switch (num) {
                        case 1:
                            saving.printInfo();
                            break;
                        case 2:
                            System.out.println(saving.checkBalance());
                            break;
                        case 3:
                            saving.closeAccount();
                            break;
                        case 4:
                            double money = scan.nextDouble();
                            boolean deposit = saving.deposit(money);
                            System.out.println(deposit);
                            break;
                        case 5:
                            double money1 = scan.nextDouble();
                            boolean with = saving.withdrawn(money1);
                            System.out.println(with);
                            break;
                        case 6:
                            int k = scan.nextInt();
                            String number = scan.next();
                            boolean check = saving.openPromptPay(k, number);
                            System.out.println(check);
                            break;
                    }
                    break;
                }
                case 2: {
                    int num = scan.nextInt();
                    // your code to scan input
                    switch (num) {
                        case 1:
                            fAcc.printInfo();
                            break;
                        case 2:
                            System.out.println(fAcc.checkBalance());
                            break;
                        case 3:
                            fAcc.closeAccount();
                            break;
                        case 4:
                            double money = scan.nextDouble();
                            boolean deposit = fAcc.deposit(money);
                            System.out.println(deposit);
                            break;
                        case 5:
                            double money1 = scan.nextDouble();
                            boolean with = fAcc.withdrawn(money1);
                            System.out.println(with);
                            break;
                        case 6:
                            int k = scan.nextInt();
                            String number = scan.next();
                            boolean check = saving.openPromptPay(k, number);
                            System.out.println(check);
                            break;
                    }
                    break;
                }
                case 3: {
                    int num = scan.nextInt();
                    // your code to scan input
                    switch (num) {
                        case 1:
                            cAcc.printInfo();
                            break;
                        case 2:
                            System.out.println(cAcc.checkBalance());
                            break;
                        case 3:
                            cAcc.closeAccount();
                            break;
                        case 4:
                            double money = scan.nextDouble();
                            boolean deposit = cAcc.deposit(money);
                            System.out.println(deposit);
                            break;
                        case 5:
                            double money1 = scan.nextDouble();
                            boolean with = cAcc.withdrawn(money1);
                            System.out.println(with);
                            break;
                        case 6:
                            int k = scan.nextInt();
                            String number = scan.next();
                            boolean check = saving.openPromptPay(k, number);
                            System.out.println(check);
                            break;
                    }
                    break;
                }
                default:
                    break;
            }

        }
    }
}

class FixedDeposit extends Account {

    double fixedAmount;

    public FixedDeposit(String name, String code, double balance, double fixedAmount) {
        super(name, code, balance);
        this.fixedAmount = fixedAmount;
        System.out.println("FixedDeposit account with " + fixedAmount);
    }

    @Override
    boolean deposit(double money) {
        if (money >= fixedAmount && active) {
            super.deposit(money);
            return true;
        } else if (money < fixedAmount && active) {
            System.out.print("deposit less than " + fixedAmount + " ");
            return false;
        }
        return false;
    }

}

class CurrentAccount extends Account {

    double overDraft;

    public CurrentAccount(String name, String code, double balance, double overDraft) {
        super(name, code, balance);
        this.overDraft = overDraft;
        System.out.println("Current account with overdraft " + overDraft);
    }

    @Override
    boolean withdrawn(double money) {
        if (balance >= money && active) {
            super.withdrawn(money);
            return true;
        } else {
            if (balance + overDraft >= money && active) {
                balance -= money;
                System.out.print(balance);
                if (balance <= 0) {
                    System.out.print(" overdraft ");
                }
                return true;
            }
            return false;

        }

    }
}

class Saving extends Account {

    String id;
    String phoneNumber;
    boolean promptPay;

    public Saving(String name, String code, double balance) {
        super(name, code, balance);
        promptPay = false;
        System.out.println("Saving account");
    }

    @Override
    void printInfo() {
        super.printInfo();
        if (promptPay) {
            System.out.print("PromptPay");
            if (id != null) {
                System.out.print(", " + id);
            }
            if (phoneNumber != null) {
                System.out.print(", " + phoneNumber);
            }
        } else {
            System.out.print("no PromptPay");
        }
        System.out.println("");
    }

    boolean openPromptPay(int n, String number) {
        if (n == 1) {
            if (number.length() == 13) {
                id = number;
                promptPay = true;
            } else {
                return false;
            }
        } else if (n == 2) {
            if (number.length() == 10) {
                phoneNumber = number;
                promptPay = true;
            } else {
                return false;
            }
        }
        return promptPay;
    }
}

class Account {

    String name;
    String code;
    double balance;
    boolean active;

    public Account(String name, String code, double balance) {
        this.name = name;
        this.code = code;
        this.balance = balance;
        this.active = true;
        System.out.println("Open account");
    }

    void printInfo() {
        System.out.print(name + ", " + code + ", " + balance);
        if (active) {
            System.out.println(", active");
        } else {
            System.out.println(", inactive");
        }
    }

    double checkBalance() {
        return balance;
    }

    void closeAccount() {
        active = false;
        printInfo();
    }

    boolean deposit(double money) {
        if (active) {
            balance += money;
            System.out.print(balance + " ");
            return true;
        } else {
            return false;
        }
    }

    boolean withdrawn(double money) {
        if (active && balance - money >= 0) {
            balance -= money;
            System.out.print(balance + " ");
            return true;
        } else {
            return false;
        }
    }
}
