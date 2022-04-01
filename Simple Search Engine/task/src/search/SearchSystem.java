package search;

import java.io.File;
import java.util.*;

public class SearchSystem {
    private final List<String> strings;
    private final List<String> findList;

    public SearchSystem(String fileName) {
        findList = new ArrayList<>();
        strings = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                strings.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getString(String text) {
        Scanner scanner = new Scanner(System.in);
        println(text);
        return scanner.nextLine();
    }

    private void println(String text){
        System.out.println(text);
    }

    public void getMenu() {
        var doIt = true;
        while (doIt) {
            switch (getString("=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit")) {
                case "1": { find(); break; }
                case "2": { printAll(); break; }
                case "0": { doIt = false; break; }
                default: { println("Incorrect option! Try again."); break; }
            }
        }
        println("Bye!");
    }

    private void printAll() {
        println("=== List of people ===");
        for (var fl: strings)
            println(fl);
    }

    private void find() {
        var strategy = getString("Select a matching strategy: ALL, ANY, NONE");
        var find = getString("Enter a name or email to search all suitable people.");
        var findArr = find.split(" ");

        findList.clear();

        strings.forEach(str -> {
            switch (strategy) {
                case "ALL": {
                    String[] arr = str.split(" ");
                    for (String s: arr) {
                        if (s.toLowerCase(Locale.ROOT).equals(find.toLowerCase(Locale.ROOT))) {
                            findList.add(str);
                        }
                    }
                    break;
                }
                case "ANY": {
                    boolean cont = false;
                    for (String fa: findArr) {
                        if (str.toLowerCase(Locale.ROOT).contains(fa.toLowerCase(Locale.ROOT))) {
                            findList.add(str);
                            break;
                        }
                    }
                    break;
                }
                case "NONE": {
                    boolean cont = false;
                    for (String fa: findArr) {
                        if (str.toLowerCase(Locale.ROOT).contains(fa.toLowerCase(Locale.ROOT))) {
                            cont = true;
                            break;
                        }
                    }
                    if (!cont) findList.add(str);
                    break;
                }
            }

            String[] arr = str.split(" ");
            for (String s: arr) {
                if (s.toLowerCase(Locale.ROOT).equals(find.toLowerCase(Locale.ROOT))) {
                    findList.add(str);
                }
            }
        });
        if (findList.size() > 0) {
            System.out.println("People found:");
            for (var fl: findList)
                System.out.println(fl);
        } else
            System.out.println("No matching people found.");
    }
}
