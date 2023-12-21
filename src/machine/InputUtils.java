package machine;

import java.util.Arrays;
import java.util.Scanner;

public class InputUtils {
    static Scanner scanner = new Scanner(System.in);

     public static int getInt() {
         return scanner.nextInt();
    }

    public static String getString(String... args) {
         String input = scanner.nextLine();
        if (Arrays.stream(args).toList().contains(input)) {
            return input;
        } else {
            return "Oh no batman";
        }
    }

    public static int getClampedInt(int min,int max) {
         int input = scanner.nextInt();
        if (input < min || input > max) {
            System.out.println("Try again sunshine");
        }
        return input;
    }
}
