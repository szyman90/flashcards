import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Practice {
    ArrayList<String> englishWord = new ArrayList<>();
    ArrayList<String> polishWord = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    Practice() throws IOException {
        String categoryName = practiceCategoryMenu();
        BufferedReader fileCards = new BufferedReader(new FileReader(categoryName + "/unknownWords",StandardCharsets.UTF_8));
        String nextLine;
        while((nextLine = fileCards.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(nextLine, "|");
            if (tokenizer.hasMoreElements()) {
                this.englishWord.add(tokenizer.nextToken());
                this.polishWord.add(tokenizer.nextToken());
                this.description.add(tokenizer.nextToken());
            }
        }
        startEnglishToPolish();
        fileCards.close();

    }

    private void startEnglishToPolish() {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean ifEndPractice = false;
        int score = 0;
        do {
            int randomNumber = rand.nextInt(this.englishWord.size());
            Printers.helper();
            System.out.println("Write in polish: " + this.englishWord.get(randomNumber));
            String userLine = scanner.nextLine();
            if (userLine.contains("1")) {
                System.out.println(this.description.get(randomNumber));
                userLine = scanner.nextLine();
            }
            if (userLine.contains(this.polishWord.get(randomNumber))) {
                System.out.println("good");
                score++;
            } else if(userLine.contains("2"))
                ifEndPractice = true;
            else
                System.out.println("Bad. Correct answer is: "+ this.polishWord.get(randomNumber));
        }while(!ifEndPractice);
        System.out.println("Your score is: " + score);
        System.out.println("-------------------------");
    }

    String practiceCategoryMenu() {
        System.out.println("Choose category");
        File file = new File(System.getProperty("user.dir"));
        String[] directoriesAndFiles = file.list();
        int number = 1;
        assert directoriesAndFiles != null;
        int [] numberInString = new int[directoriesAndFiles.length];
        for (int i = 0; i < Objects.requireNonNull(directoriesAndFiles).length; i++) {
            if (!(directoriesAndFiles[i].contains(".") || directoriesAndFiles[i].contains("src") || directoriesAndFiles[i].contains("out"))) {
                System.out.println((number) + ". " + directoriesAndFiles[i]);
                numberInString[number++] = i;
            }
        }
        return directoriesAndFiles[numberInString[Menu.isIntAndAvailable(number)]];
    }
}
//Add description hint
//Add more practice
//Add from polish to english