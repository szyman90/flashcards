import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NewElements {
    String englishWord;
    String description;
    String polishWord;
    Scanner scannerNewElements = new Scanner(System.in);

    NewElements(String categoryName) throws IOException {
        PrintWriter fileWithFlashCards = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(categoryName + "/unknownWords", true), StandardCharsets.UTF_8), true);
        addNewElements(fileWithFlashCards);
        fileWithFlashCards.close();
    }

    private void addNewElements(PrintWriter file) {
        boolean isContinue = true;
        while (isContinue) {
            addEnglishWord();
            addPolishWord();
            addDescription();
            file.write(englishWord + "|" + polishWord + "|" + description + "|" + 0 + "|\n");
            Printers.ifAddAnotherElement();
            if (Menu.isIntAndAvailable(2) == 2)
                isContinue = false;
        }
    }

    private void addDescription() {
        Printers.descriptionMenu();
        String buff;
        while (Menu.isIncorrectString(buff = scannerNewElements.nextLine(), 100))
            Printers.errorScan();
        this.description = buff;
    }

    private void addPolishWord() {
        Printers.polishWordMenu();
        String buff;
        while (Menu.isIncorrectString(buff = scannerNewElements.nextLine(), 30))
            Printers.errorScan();
        this.polishWord = buff;
    }

    private void addEnglishWord() {
        Printers.englishWordMenu();
        String buff;
        while (Menu.isIncorrectString(buff = scannerNewElements.nextLine(), 30))
            Printers.errorScan();
        this.englishWord = buff;
    }
}
