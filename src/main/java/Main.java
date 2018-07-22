import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lock lock = new Lock();

        lock.init();

        System.out.println("0 - Close");
        System.out.println("1 - Open");
        System.out.println("2 - Exit");
        Scanner console = new Scanner(System.in);
        while (true) {
            int key = console.nextInt();

            if (key == 2) {
                break;
            }

            if (key == 0) {
                lock.close();
            }

            if (key == 1) {
                lock.open();
            }
        }
    }
}
