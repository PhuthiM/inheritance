
import java.util.Scanner;

public class AnimalDomain2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // Your Code
        int count = 0;
        Animal[] animals = new Animal[N];
        for (int i = 0; i < N; ++i) {
            int type = sc.nextInt();
            if (type == 1) {
                int animalType = sc.nextInt();
                String name = sc.next();
                // Your Code
                if (animalType == 1) {
                    animals[count] = new Dog(name);
                } else if (animalType == 2) {
                    animals[count] = new Turtle(name);
                } else if (animalType == 3) {
                    animals[count] = new Salmon(name);
                }
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
            } else if (type == 4) {
                int id = sc.nextInt();
                // Your Code\
                animals[id - 1].vaccine();
            }
        }
    }
}

class Dog extends Animal {

    boolean firstVaccine = true;

    public Dog(String name) {
        super(name, 8);
    }

    @Override
    void vaccine() {
        if (firstVaccine&&check) {
            lifeExpect += lifeExpect - age;
            firstVaccine = false;
        }
        super.vaccine(); //To change body of generated methods, choose Tools | Templates.

    }

}

class Turtle extends Animal {

    public Turtle(String name) {
        super(name, 50);
    }

}

class Salmon extends Animal {

    public Salmon(String name) {
        super(name, 4);
    }

}

class Animal {

    String name;
    int lifeExpect;
    int age;
    boolean check = true;

    public Animal(String name, int lifeExpect) {
        this.name = name;
        this.lifeExpect = lifeExpect;
        age = 0;
        System.out.println(name + " was born with life expectancy " + lifeExpect + " year(s)");
    }

    void live(int survey) {
        int co = age + survey;
        if (!check) {
            System.out.println(name + " died earlier");
        } else if (co < lifeExpect) {
            System.out.print(name + " lived " + survey);
            if (survey == 1) {
                System.out.print(" more year");
            } else {
                System.out.print(" more years");
            }
            System.out.println();
            age += survey;
        } else if (co >= lifeExpect) {
            int re = lifeExpect - age;
            if (re == 1) {
                System.out.println(name + " lived 1 more year and died");
            } else {
                System.out.println(name + " lived " + re + " more years and died");
            }
            check = false;
        }

    }

    boolean isAlive() {
        if (check) {
            System.out.println(name + " is alive");
            return true;
        } else {
            System.out.println(name + " is dead");
            return false;
        }
    }

    void vaccine() {
        System.out.println(name + "'s life expectancy is now " + lifeExpect + " year(s)");
    }
}
