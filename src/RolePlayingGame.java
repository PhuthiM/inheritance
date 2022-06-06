
import java.util.Scanner;

public class RolePlayingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Hero[] hero = new Hero[m];
        for (int i = 0; i < m; i++) {
            String nameHero = sc.next();
            hero[i] = new Hero(nameHero);
        }
        int n = sc.nextInt();
        Monster[] mon = new Monster[n];
        for (int i = 0; i < n; i++) {
            int level = sc.nextInt();
            int score = sc.nextInt();
            mon[i] = new Monster(i + "", level, score);
        }
        int k = sc.nextInt();
        boolean[] alive = new boolean[n];
        for (int i = 0; i < k; i++) {
            int H = sc.nextInt();
            int M = sc.nextInt();
            if (!alive[M-1]) {
                hero[H - 1].hit(mon[M - 1]);
                alive[M - 1] = !alive[M - 1];
            }

        }
        for (int i = 0; i < m; i++) {
            hero[i].stat();
        }
    }
}

class GameCharacter {

    String name;
    int attack;
    int defense;
    int level;

    void stat() {
        System.out.println(name + " " + level + " " + attack + " " + defense);
    }
}

class Hero extends GameCharacter {

    public Hero(String name) {
        this.name = name;
        this.attack = 10;
        this.defense = 5;
        this.level = 1;
    }

    void hit(Monster mon) {
        int s = mon.score / 100;
        level += s;
        attack += 3 * s;
        defense += 2 * s;
    }
}

class Monster extends GameCharacter {

    int score;

    public Monster(String name, int level, int score) {
        this.name = name;
        attack = (10 + (3 * level)) * 2;
        defense = (5 + (2 * level)) * 3;
        this.level = level;
        this.score = score;
    }
}
/*
3
Blossom Bubbles Buttercup
4
3 320
2 190
5 670
2 210
5
1 2
1 1
2 3
2 4
1 3
 */
