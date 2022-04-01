package search;

public class Main {
    public static void main(String[] args) {
        var fileName = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("--")) {
                fileName = args[++i];
            }
        }
        var ss = new SearchSystem(fileName);
        ss.getMenu();
    }
}
