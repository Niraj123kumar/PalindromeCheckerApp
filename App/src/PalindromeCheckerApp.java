import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
System.out.println("Enter a string:");
String input = scanner.nextLine();

PerformanceComparison.compare(input);

PalindromeChecker checker = new PalindromeChecker();
boolean result = checker.checkPalindrome(userInput);


public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        if (result) {
            System.out.println("It is a Palindrome!");
        } else {
            System.out.println("Not a Palindrome!");
        }

        scanner.close();
    }
}



/**
 * Palindrome Checker App
 * A console-based Java application that validates whether a given string
 * is a palindrome under different conditions.
 *
 * @author Development Team
 * @version 1.0.0
 * @since 2024
 */
private static boolean checkPalindromeCaseInsensitive(String input) {

    if (input == null || input.isEmpty()) {
        return false;
    }

    // Normalize string
    String normalized = input
            .replaceAll("\\s+", "")       // remove spaces
            .toLowerCase();               // convert to lowercase

    // Two-pointer comparison
    int left = 0;
    int right = normalized.length() - 1;

    while (left < right) {
        if (normalized.charAt(left) != normalized.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}

private static boolean checkPalindromeRecursiveUC9(String input) {

    if (input == null || input.isEmpty()) {
        return false;
    }

    String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    return recursiveHelper(cleaned, 0, cleaned.length() - 1);
}
private static boolean recursiveHelper(String str, int start, int end) {

    // Base condition
    if (start >= end) {
        return true;
    }

    // If mismatch
    if (str.charAt(start) != str.charAt(end)) {
        return false;
    }

    // Recursive call
    return recursiveHelper(str, start + 1, end - 1);
}


// Node class for Singly Linked List
static class ListNode {
    char data;
    ListNode next;

    ListNode(char data) {
        this.data = data;
        this.next = null;
    }
}
private static boolean checkPalindromeUsingLinkedList(String input) {

    if (input == null || input.isEmpty()) {
        return false;
    }

    // Clean input
    String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    // Step 1: Convert string to linked list
    ListNode head = null, tail = null;

    for (char ch : cleaned.toCharArray()) {
        ListNode newNode = new ListNode(ch);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Step 2: Find middle using slow & fast pointer
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 3: Reverse second half
    ListNode prev = null;
    ListNode current = slow;

    while (current != null) {
        ListNode nextTemp = current.next;
        current.next = prev;
        prev = current;
        current = nextTemp;
    }

    // Step 4: Compare halves
    ListNode firstHalf = head;
    ListNode secondHalf = prev;

    while (secondHalf != null) {
        if (firstHalf.data != secondHalf.data) {
            return false;
        }
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }

    return true;
}


private static boolean checkPalindromeUsingDeque(String input) {

    if (input == null || input.isEmpty()) {
        return false;
    }

    // Clean input
    String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    Deque<Character> deque = new ArrayDeque<>();

    // Insert characters into deque
    for (char ch : cleaned.toCharArray()) {
        deque.addLast(ch);
    }

    // Compare front and rear
    while (deque.size() > 1) {
        if (!deque.removeFirst().equals(deque.removeLast())) {
            return false;
        }
    }

    return true;
}

private static boolean checkPalindromeUsingQueueAndStack(String input) {

    if (input == null || input.isEmpty()) {
        return false;
    }

    // Clean input
    String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    Queue<Character> queue = new LinkedList<>();
    Stack<Character> stack = new Stack<>();

    // Insert characters into both structures
    for (char ch : cleaned.toCharArray()) {
        queue.offer(ch);   // Enqueue (FIFO)
        stack.push(ch);    // Push (LIFO)
    }

    // Compare dequeue and pop
    while (!queue.isEmpty()) {
        if (!queue.poll().equals(stack.pop())) {
            return false;
        }
    }

    return true;
}

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
    private static boolean checkPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return checkPalindromeRecursive(str, start + 1, end - 1);
    }


    private static void startApplication() {

        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("=== INTERACTIVE MODE ===");

        while (true) {

            System.out.println("\nSelect Palindrome Checking Method:");
            System.out.println("1. Recursive Method (UC4)");
            System.out.println("2. Stack-Based Method (UC5)");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            if (choice.equals("3")) {
                break;
            }

            System.out.print("Enter a string to check: ");
            userInput = scanner.nextLine();

            boolean result = false;

            switch (choice) {
                case "1":
                    result = checkPalindrome(userInput);
                    break;

                case "2":
                    result = checkPalindromeUsingStack(userInput);
                    break;

                case "3":
                    result = checkPalindromeUsingQueueAndStack(userInput);
                    break;

                case "4":
                    result = checkPalindromeUsingDeque(userInput);
                    break;
                case "5":
                    result = checkPalindromeUsingLinkedList(userInput);
                    break;
                case "6":
                    result = checkPalindromeRecursiveUC9(userInput);
                    break;
                case "7":
                    result = checkPalindromeCaseInsensitive(userInput);
                    break;





                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

        }

            System.out.println("Result: " +
                    (result ? "✓ PALINDROME" : "✗ NOT PALINDROME"));

            // Update statistics
            totalChecks++;
            if (result) {
                palindromesFound++;
            }
        }


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

        // Clean the input
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        return checkPalindromeRecursive(cleaned, 0, cleaned.length() - 1);
    }


    /**
     * Displays application statistics before exit
     * Shows usage metrics and performance data
     */
    private static boolean checkPalindromeUsingStack(String input) {

        if (input == null || input.isEmpty()) {
            return false;
        }

        // Clean input
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        // Pop and compare
        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

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
