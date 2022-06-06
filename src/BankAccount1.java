
import java.util.Scanner;

/*class Account {

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

public class BankAccount1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nameAc = sc.nextLine();
        String codeAc = sc.nextLine();
        double balance = sc.nextDouble();
        Account ac = new Account(nameAc, codeAc, balance);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    ac.printInfo();
                    break;
                case 2:

                    System.out.println(ac.checkBalance());
                    break;
                case 3:
                    ac.closeAccount();
                    break;
                case 4:
                    double money = sc.nextDouble();
                    boolean deposit = ac.deposit(money);
                    System.out.println(deposit);
                    break;
                case 5:
                    double money1 = sc.nextDouble();
                    boolean with = ac.withdrawn(money1);
                    System.out.println(with);
                    break;
            }
        }
    }
}
