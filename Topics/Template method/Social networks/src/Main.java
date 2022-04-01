import java.util.Scanner;

abstract class SocialNetwork {
    public void connect() {
        login();
        post();
        logout();
    }

    public abstract void login();

    public abstract void post();

    public abstract void logout();
}

class Instagram extends SocialNetwork {
    private final String network = "Instagram";

    @Override
    public void login() {
        System.out.printf("Log into %s%n", network);
    }

    @Override
    public void post() {
        System.out.printf("Post: Hello, %s!%n", network);
    }

    @Override
    public void logout() {
        System.out.printf("Log out of %s%n", network);
    }
}


class Facebook extends SocialNetwork {
    private final String network = "Facebook";

    @Override
    public void login() {
        System.out.printf("Log into %s%n", network);
    }

    @Override
    public void post() {
        System.out.printf("Post: Hello, %s!%n", network);
    }

    @Override
    public void logout() {
        System.out.printf("Log out of %s%n", network);
    }
}

// Do not change the code below
class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        SocialNetwork network = null;
        if ("facebook".equalsIgnoreCase(type)) {
            network = new Facebook();
        } else if ("instagram".equalsIgnoreCase(type)) {
            network = new Instagram();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        network.connect();
    }
}