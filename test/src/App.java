import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static final Set<String> SERVERS = new HashSet<>(
            Arrays.asList("cloud-2", "cloud-2", "cloud-3", "vip-1", "vip-2"));

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.printf("\033[H\033[2J");
            startup(input);
        }
    }

    public static void login(String username, String server) {
        System.out.printf("\033[H\033[2J");
        System.out.println(
                "Welcome to the app!\nYour name: " + username + "\nCurrent server: " + server);
    }

    public static void getCredentials(Scanner input) {
        System.out.println("Enter your name! [ANY]");
        String username = input.next();
        String reqServer = "";

        reqServer = checkServer(input, reqServer);
        login(username, reqServer);
    }

    public static String checkServer(Scanner input, String reqServer) {
        while (true) {
            System.out.println("Enter your server!");
            reqServer = input.next();

            if (SERVERS.contains(reqServer)) {
                return reqServer;
            }
            System.out.println("\nInvalid server!");
        }
    }

    public static void startup(Scanner input) {
        String status = "";

        while (!status.equalsIgnoreCase("yes") || status.equalsIgnoreCase("no")) {
            System.out.println("Would you like to go online? [YES/NO]");
            status = input.nextLine();
            if (status.toLowerCase().equals("no")) {
                System.exit(0);
            }
            if (!status.toLowerCase().equals("yes")) {
                System.out.println("\nInvalid option!");
            }
        }
        getCredentials(input);
    }
}