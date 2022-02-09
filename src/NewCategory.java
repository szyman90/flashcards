import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewCategory {
    void addNewCategory() throws IOException {
        Printers.printNewCategory();
        Scanner scanner = new Scanner(System.in);
        String categoryName;
        while (Menu.isIncorrectString(categoryName = scanner.nextLine(), 16)) {
            Printers.errorScan();
        }
        File newCategory = new File(categoryName);
        boolean isExist = newCategory.mkdir();
        if (isExist) {
            System.out.println("Category is created successfully");
        } else {
            System.out.println("Category is already exist!");
            return;
        }
        Printers.questionAfterCreatedCategory();
        int choose = Menu.isIntAndAvailable(2);
        if (choose == 1) {
            NewElements createNewElement = new NewElements(categoryName);
        }
    }

}
