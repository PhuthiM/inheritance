
import java.util.Scanner;

public class ProductStore2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Product[] pro = new Product[n];
        Shoe[] shoe = new Shoe[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine(); // ชื่อสินค้า
            String sku = sc.nextLine(); // รหัสสินค้า
            double price = sc.nextDouble(); // ราคา
            int weight = sc.nextInt(); //น้ำหนัก
            int gender = sc.nextInt();
            int size = sc.nextInt();
            int type = sc.nextInt();
            String brand = sc.next();
            shoe[i] = new Shoe(name, sku, price, weight, gender, size, type, brand);
        }
        for (int i = 0; i < n; i++) {
            boolean valid = shoe[i].checkValidity();
            System.out.println(valid);
        }
        for (int i = 0; i < n; i++) {
            shoe[i].printInfo();
        }
    }
}

class Shoe extends Product {

    String genderS;
    int size;
    String typeS;
    String brand;

    public Shoe(String name, String sku, double price, int weight,
            int gender, int size, int type, String brand) {
        super(name, sku, price, weight);
        if (gender == 1) {
            genderS = "female";
        } else {
            genderS = "male";
        }
        this.size = size;
        if (type == 1) {
            typeS = "sport";
        } else if (type == 2) {
            typeS = "formal";
        } else if (type == 3) {
            typeS = "casual";
        }
        this.brand = brand;
    }

    @Override
    void printInfo() {
        super.printInfo(); //To change body of generated methods, choose Tools | Templates.
        System.out.println(genderS + ", " + size + ", " + typeS + ", " + brand);
    }

}
/*
3
Toon BSlam
AERAS
720
0
2 12 1 Niko
Working
1SFJURF
0
-100
1 8 2 Munchen
RongTuaTae

65.75
100
1 6 3 Satellite


 */
