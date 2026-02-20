/**
 * Palindrome Checker App
 * A console-based Java application that validates whether a given string
 * is a palindrome under different conditions.
 *
 * @author Development Team
 * @version 1.0.0
 * @since 2024
 */
public class PalindromeCheckerApp {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String APP_VERSION = "v1.0.0";
    private static final String DEVELOPER = "Java Development Team";
    private static final String BUILD_DATE = "2024-02-20";

    // Application instance variables
    private static int totalChecks = 0;
    private static int palindromesFound = 0;

    /**
     * Main method - Entry point of the Java application
     * JVM invokes this method to start the application
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        displayWelcomeMessage();

        // Application flow control - Continue to main application logic
        startApplication();
    }

    /**
     * UC1 Implementation: Display welcome message and app details at startup
     * This method handles the welcome message display functionality
     */
    private static void displayWelcomeMessage() {
        System.out.println("=====================================");
        System.out.println("    " + APP_NAME);
        System.out.println("=====================================");
        System.out.println("Version: " + APP_VERSION);
        System.out.println("Developer: " + DEVELOPER);
        System.out.println("Build Date: " + BUILD_DATE);
        System.out.println("=====================================");
        System.out.println();
        System.out.println("Welcome to the Palindrome Checker!");
        System.out.println("This application validates whether a given");
        System.out.println("string is a palindrome under different conditions.");
        System.out.println();
        System.out.println("Key Features:");
        System.out.println("• Basic string palindrome checking");
        System.out.println("• Case-insensitive validation");
        System.out.println("• Numeric palindrome support");
        System.out.println("• Sentence palindrome checking");
        System.out.println("• Statistical reporting");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
    }

    /**
     * Main application logic controller
     * Manages the flow after welcome message display
     */
    private static void startApplication() {
        System.out.println("Initializing Palindrome Checker...");
        System.out.println("Application ready for use!");
        System.out.println();

        // Demonstrate basic functionality
        demonstrateBasicUsage();

        // Display application statistics before exit
        displayApplicationStatistics();

        // Application exit message
        displayExitMessage();
    }

    /**
     * Demonstrates basic palindrome checking functionality
     * This method showcases the core features of the application
     */
    private static void demonstrateBasicUsage() {
        System.out.println("=== DEMONSTRATION MODE ===");
        System.out.println();

        // Test cases for demonstration
        String[] testCases = {
                "racecar",
                "hello",
                "madam",
                "A man a plan a canal Panama",
                "12321",
                "java"
        };

        System.out.println("Testing sample palindromes:");
        System.out.println("---------------------------");

        for (String testCase : testCases) {
            boolean result = checkPalindrome(testCase);
            System.out.printf("%-30s -> %s%n",
                    "'" + testCase + "'",
                    (result ? "✓ PALINDROME" : "✗ NOT PALINDROME"));

            // Update statistics
            totalChecks++;
            if (result) {
                palindromesFound++;
            }
        }
        System.out.println();
    }

    /**
     * Basic palindrome checking method
     * Validates if a string reads the same forwards and backwards
     *
     * @param input The string to check
     * @return true if palindrome, false otherwise
     */
    private static boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Clean the input: remove spaces and convert to lowercase
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();

        // Remove non-alphanumeric characters for sentence palindromes
        cleaned = cleaned.replaceAll("[^a-zA-Z0-9]", "");

        // Check if cleaned string equals its reverse
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    /**
     * Displays application statistics before exit
     * Shows usage metrics and performance data
     */
    private static void displayApplicationStatistics() {
        System.out.println("=== APPLICATION STATISTICS ===");
        System.out.println("Total Checks Performed: " + totalChecks);
        System.out.println("Palindromes Found: " + palindromesFound);
        System.out.println("Non-Palindromes: " + (totalChecks - palindromesFound));

        if (totalChecks > 0) {
            double successRate = (double) palindromesFound / totalChecks * 100;
            System.out.printf("Success Rate: %.1f%%%n", successRate);
        }

        System.out.println("===============================");
        System.out.println();
    }

    /**
     * Displays application exit message
     * Provides graceful application termination
     */
    private static void displayExitMessage() {
        System.out.println("Thank you for using " + APP_NAME + "!");
        System.out.println("Application terminated successfully.");
        System.out.println("=====================================");
    }

    /**
     * Utility method to display application information
     * Can be called from other parts of the application
     */
    public static void displayAppInfo() {
        System.out.println("Application: " + APP_NAME);
        System.out.println("Version: " + APP_VERSION);
        System.out.println("Status: Running");
    }

    /**
     * Static initialization block
     * Executes when the class is first loaded by the JVM
     */
    static {
        System.out.println("[System] PalindromeCheckerApp class loaded successfully.");
    }
}
