import java.util.*;

public class TypingSpeedTest {

    private static final String[] SENTENCES = {
        "The quick brown fox jumps over the lazy dog.",
        "Java is a versatile programming language.",
        "Practice makes perfect when coding.",
        "Typing speed tests are fun and useful.",
        "Consistent effort yields great results.",
        "Programming challenges help improve problem-solving skills.",
        "Debugging is an essential part of the development process.",
        "Learning Java opens doors to Android development.",
        "Efficient algorithms save both time and resources.",
        "Reading and writing code are critical developer skills.",
        "Developing small projects is a great way to learn programming.",
        "Keyboard shortcuts can significantly improve productivity.",
        "Version control systems like Git are invaluable for developers.",
        "Understanding data structures is fundamental for coding.",
        "Writing clean and readable code is a good habit."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String retry;

        do {
            // Display a random sentence
            String sentenceToType = SENTENCES[random.nextInt(SENTENCES.length)];
            System.out.println("\nType the following sentence as quickly and accurately as possible:");
            System.out.println(sentenceToType);

            // Start time
            long startTime = System.currentTimeMillis();

            // Get user input
            System.out.print("\nYour input: ");
            String userInput = scanner.nextLine();

            // End time
            long endTime = System.currentTimeMillis();

            // Calculate time taken in seconds
            double timeTaken = (endTime - startTime) / 1000.0;

            // Calculate words per minute (WPM)
            int wordCount = sentenceToType.split(" ").length;
            double wpm = (wordCount / timeTaken) * 60;

            // Calculate accuracy
            int errors = calculateErrors(sentenceToType, userInput);
            double accuracy = ((double) (sentenceToType.length() - errors) / sentenceToType.length()) * 100;

            // Display results
            System.out.printf("\nTime taken: %.2f seconds\n", timeTaken);
            System.out.printf("Words per minute (WPM): %.2f\n", wpm);
            System.out.printf("Accuracy: %.2f%%\n", accuracy);

            // Motivational feedback
            if (accuracy == 100) {
                System.out.println("Perfect typing! Great job!");
            } else if (accuracy >= 90) {
                System.out.println("Excellent work! Keep it up!");
            } else if (accuracy >= 75) {
                System.out.println("Nice effort! Practice will make you better.");
            } else {
                System.out.println("Don't give up! Keep practicing to improve.");
            }

            // Retry option
            System.out.print("\nWould you like to try again? (yes/no): ");
            retry = scanner.nextLine().trim().toLowerCase();

        } while (retry.equals("yes"));

        System.out.println("\nThank you for using the Typing Speed Test. Goodbye!");
        scanner.close();
    }

    private static int calculateErrors(String original, String input) {
        int errors = 0;
        int length = Math.min(original.length(), input.length());

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) != input.charAt(i)) {
                errors++;
            }
        }

        errors += Math.abs(original.length() - input.length());
        return errors;
    }
}
