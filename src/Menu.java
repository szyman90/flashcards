import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    Menu() throws IOException {
        boolean noExit;
        do {
            chooseMenu();
            noExit = ifExit();
        } while (noExit);
    }

    void chooseMenu() throws IOException {
        int choose;
        do {
            Printers.printMenu();
            choose = isIntAndAvailable(5);
            if (choose == 1) {
                Practice practice = new Practice();
            } else if (choose == 2) {
                addNewElementToExistentCategory();
            } else if (choose == 3) {
                NewCategory newCategory = new NewCategory();
                newCategory.addNewCategory();
            } else if (choose == 4) {
            }
        } while (choose != 5);
    }

    private void addNewElementToExistentCategory() throws IOException {
        System.out.println("Enter the name of category");
        Scanner scanner = new Scanner(System.in);
        String nameOfCategory;
        while(isIncorrectString(nameOfCategory = scanner.nextLine(), 16))
            Printers.errorScan();
        File category = new File(nameOfCategory);
        if(category.exists()) {
            NewElements newElements = new NewElements(nameOfCategory);
        } else System.out.println("Folder dose not exist");
    }

    boolean ifExit() {
        System.out.println("Do you really want to exit?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("-------------------------");
        return isIntAndAvailable(2) == 2;
    }

    static int isIntAndAvailable(int numberOfOptions) {
        Scanner intScanner = new Scanner(System.in);
        int option;
        while (true) {
            try {
                option = intScanner.nextInt();
                if (isInRange(numberOfOptions, option)) {
                    return option;
                } else System.out.println("Choose one of the given options");
            } catch (InputMismatchException ex) {
                System.out.println("please enter the appropriate value");
                intScanner.next();
            }
        }
    }

    static boolean isInRange(int numberOfOptions, int option) {
        return option <= numberOfOptions && option >= 0;
    }

    static boolean isIncorrectString(String nextLine, int length) {
        return nextLine.length() > length;
    }

}
