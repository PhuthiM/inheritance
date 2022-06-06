
import java.util.Scanner;

public class TestStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] std = new Student[n];

        for (int i = 0; i < n; i++) {
            String firstName = sc.next();
            String lastName = sc.next();
            std[i] = new Student(firstName, lastName);
            for (int j = 0; j < 4; j++) {
                int score = sc.nextInt();
                std[i].setTestScore(j, score);
            }
            std[i].printInfo();
        }
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int rosterNum = sc.nextInt();
            int testNum = sc.nextInt();
            int total = std[rosterNum - 1].getTestScore(testNum);
            System.out.println(total);
        }
    }
}

class Student {

    String firstName;
    String lastName;

    int[] stepScore;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        stepScore = new int[4];
    }

    int getTestScore(int p) {
        if (p == 1) {
            return stepScore[0];
        } else if (p == 2) {
            return stepScore[1];
        } else if (p == 3) {
            return stepScore[2];
        } else {
            return stepScore[3];
        }
    }

    void setTestScore(int p, int score) {
        stepScore[p] = score;
    }

    int computeTotal() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            count += stepScore[i];
        }
        return count;
    }

    void printInfo() {
        System.out.println(firstName + " " + lastName + " " + computeTotal());
    }
}
