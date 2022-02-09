import java.io.File;
import java.util.Objects;

public class Printers {
    static void printMenu() {
        System.out.println("Welcome to flashcards app.");
        System.out.println("1. Practise");
        System.out.println("2. Add new words to existent category");
        System.out.println("3. Create new category");
        System.out.println("4. Instruction");
        System.out.println("5. Leave");
        System.out.println("-------------------------");
    }

    public static void printNewCategory() {
        System.out.println("Enter the name of the new category");
        System.out.println("the name must be up to 16 characters long");
        System.out.println("-------------------------");
    }

    public static void errorScan() {
        System.out.println("the name must be up to 16 characters long");
    }

    public static void questionAfterCreatedCategory() {
        System.out.println("Do you want to add some elements?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("-------------------------");
    }

    public static void englishWordMenu() {
        System.out.println("Enter the english version of word or expression");
        System.out.println("It must be up to 30 characters long");
        System.out.println("-------------------------");
    }

    public static void polishWordMenu() {
        System.out.println("Enter the polish version of word or expression");
        System.out.println("It must be up to 30 characters long");
        System.out.println("-------------------------");
    }

    public static void descriptionMenu() {
        System.out.println("Enter the description of word or expression");
        System.out.println("It must be up to 100 characters long");
        System.out.println("-------------------------");
    }

    public static void ifAddAnotherElement() {
        System.out.println("Do you want to add another word?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("-------------------------");
    }


    public static void helper() {
        System.out.println("If you want hint type 1");
        System.out.println("If you want to end practise type 2");
    }
}

