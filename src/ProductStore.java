
import java.util.Scanner;

public class ProductStore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Product[] pro = new Product[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine(); // ชื่อสินค้า
            String sku = sc.nextLine(); // รหัสสินค้า
            double price = sc.nextDouble(); // ราคา
            int weight = sc.nextInt(); //น้ำหนัก
            pro[i] = new Product(name, sku, price, weight);
        }
        for (int i = 0; i < n; i++) {
            boolean valid = pro[i].checkValidity();
            System.out.println(valid);
        }
        for (int i = 0; i < n; i++) {
            pro[i].printInfo();
        }
    }
}

class Product {

    String name; // ชื่อสินค้า
    String sku; // รหัสสินค้า
    double price; // ราคา
    int weight; //น้ำหนัก
    boolean valid;

    public Product(String name, String sku, double price, int weight) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.weight = weight;
    }

    boolean checkValidity() {
        valid = true;
        if (name == null || name.length() < 1) {
            System.out.println("name is invalid");
            valid = false;
        }
        if (sku == null || sku.length() < 1) {
            System.out.println("sku is invalid");
            valid = false;
        }
        if (price < 0) {
            System.out.println("price is invalid");
            valid = false;
        }
        if (weight < 0) {
            System.out.println("weight is invalid");
            valid = false;
        }
        return valid;
    }

    void printInfo() {
        System.out.print(name + ", " + sku + ", " + price + ", " + weight);
        if (!valid) {
            System.out.print(", Invalid");
        }
        System.out.println("");
    }

}

/*
10

EQZQ
1134.7879853807199
19516
1 13 3 FATSL
HK IffAwq gyoq
KBO
240.55029355038138
-24033
1 11 2 VZJXU
kTWf dLS dbIs HWemL
GO
786.2768035709753
33736
2 13 1 RFLYX
Fil
FTGOE
150.77918206982787
6562
2 7 1 TNRPY

VZCCVK
1308.4339553523296
31541
2 10 3 WTGUX
zqyjuA fu bJUKDSc
UGXMVEA
1095.597959428012
2115
2 5 3 HQZAZ

LYVN
-895.2084939404031
8012
2 7 3 EGQKY

ZCLD
450.5156504213563
23618
1 8 2 ZTZXJ

D
661.9915136791108
37496
1 8 2 FDCUY
uaE Dv WlvPnl
DNNKYHX
1837.6207162555784
-17889
2 9 1 OKSBU
 */
