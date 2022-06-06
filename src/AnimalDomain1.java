
import java.util.Scanner;



public class AnimalDomain1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // Your Code
        int count = 0;
        Animal[] animals = new Animal[N];
        for (int i = 0; i < N; ++i) {
            int type = sc.nextInt();
            if (type == 1) {
                String name = sc.next();
                int lifeExpect = sc.nextInt();
                // Your Code
                animals[count] = new Animal(name, lifeExpect);
                count++;
            } else if (type == 2) {
                int id = sc.nextInt();
                int year = sc.nextInt();
                // Your Code
                animals[id - 1].live(year);
            } else if (type == 3) {
                int id = sc.nextInt();
                // Your Code\
                animals[id - 1].isAlive();
            }
        }
    }
}
/*
17
1 Toto 15
1 Pika 50
2 1 3
1 Momo 8
3 2
2 3 6
2 2 10
2 3 7
1 Mana 4
3 3
2 1 1
3 1
2 1 11
3 1
2 1 1
1 Luna 1
2 5 1
 */
