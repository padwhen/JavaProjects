import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    static String[] words = {"envelope", "github", "programming", "annyonghaseyo"
    ,"dajiahao", "moikka", "voitko puhua englantia?", "ahihi"};
    public static void main(String[] args) throws InterruptedException {
        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);

        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(words[random.nextInt(words.length)] + " ");
        }
        System.out.println();
        double start = LocalTime.now().toNanoOfDay();
        Scanner input = new Scanner(System.in);
        String typedWords = input.nextLine();
        double end = LocalTime.now().toNanoOfDay();
        double elapsedTime = end - start;
        double seconds = elapsedTime / 1000000000.0;
        int numChars = typedWords.length();
        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);
        System.out.println("Yours wpm is " + wpm);
    }
}