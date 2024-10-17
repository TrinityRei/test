import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("\033[H\033[2J");
        startup(input);
        input.close();
    }

    public static void login(String username, String server) {
        System.out.printf("\033[H\033[2J");
        System.out.println(
            "Welcome to the app!\nYour name: " + username + "\nCurrent server: " + server
        );
    }

    public static void getCredentials(Scanner input) {
        System.out.println("Enter your name! [ANY]");
        String username = input.next();
        boolean serverChecker = false;
        String server = "";
        
        while(!serverChecker == true) {
            System.out.println("Enter your server!");
            server = input.next();

            if(!server.equals("cloud-1")){
                System.out.println("\nInvalid server!");
            } else {
                serverChecker = true;
            }
        }

        login(username, server);
    }

    public static void startup(Scanner input) {
        String status = "";

        while(!status.toLowerCase().equals("yes") || status.toLowerCase().equals("no")){
            System.out.println("Would you like to go online? [YES/NO]");
            status = input.nextLine();
            if(status.toLowerCase().equals("no")){
                System.exit(0);
            }
            if(!status.toLowerCase().equals("yes")) {
                System.out.println("\nInvalid option!");
            }
        }
        getCredentials(input);
    }
}