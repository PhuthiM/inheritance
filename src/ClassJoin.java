
import java.util.Scanner;

class ClassJoin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String model = sc.nextLine();
        int speed = sc.nextInt();
        int typesocket = sc.nextInt();
        int typeram = sc.nextInt();
        sc.nextLine();
        String Mname = sc.nextLine();
        int Mtypesocket = sc.nextInt();
        int Mtyperam = sc.nextInt();
        if (model.length() == 0 && typesocket % 2 == 0) {
            model = null;
        }
        if (Mname.length() == 0 && typesocket % 2 == 0) {
            Mname = null;
        }
        MainBoard2 mainboard = new MainBoard2(Mname, Mtypesocket, Mtyperam);
        CPU2 cpu = new CPU2(model, speed, typesocket, typeram);
        cpu.printInfo();
        mainboard.printInfo();
    }
}

class Component {

    String model;
    int socket;
    int memtype;
    boolean valid;

    public Component(String model, int socket, int memtype) {
        this.model = model;
        this.socket = socket;
        this.memtype = memtype;
    }

    boolean isValidSpec(String model, int typesocket, int typeram) {
        if (model == null || model.length() == 0) {
            return false;
        } else if (model.length() == 0) {
            return false;
        } else if (typesocket <= 0) {
            return false;
        } else if (typeram <= 0 || typeram > 10) {
            return false;
        } else {
            return true;
        }
    }

    void printInfo() {
        System.out.println(valid + "\n" + model + "\n" + socket + "\n" + memtype);
    }
}

class CPU2 extends Component {

    int clock;
    public CPU2(String model, int clock, int socket, int memtype) {
        super(model, socket, memtype);
        this.clock = clock;
        this.valid = isValidSpec(model, clock, socket, memtype);
    }

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(clock);
    }

    boolean isValidSpec(String model, int clock, int socket, int memtype) {
        boolean check = super.isValidSpec(model, socket, memtype);
        if (!check) {
            return false;
        } else if (clock <= 0) {
            return false;
        } else {
            return true;
        }
    }
}

class MainBoard2 extends Component {

    public MainBoard2(String model, int typesocket, int typeramv) {
        super(model, typesocket, typeramv);
        valid = isValidSpec(model, typesocket, typeramv);
    }

}
