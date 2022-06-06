
/*import java.util.Scanner;

public class BankAccount2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nameAc = sc.nextLine();
        String codeAc = sc.nextLine();
        double balance = sc.nextDouble();
        Saving saving = new Saving(nameAc, codeAc, balance);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
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
                    double money = sc.nextDouble();
                    boolean deposit = saving.deposit(money);
                    System.out.println(deposit);
                    break;
                case 5:
                    double money1 = sc.nextDouble();
                    boolean with = saving.withdrawn(money1);
                    System.out.println(with);
                    break;
                case 6:
                    int k = sc.nextInt();
                    String number = sc.next();
                    boolean check = saving.openPromptPay(k, number);
                    System.out.println(check);
                    break;
            }
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
