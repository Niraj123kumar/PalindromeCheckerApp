public class PerformanceComparison {

    public static void compare(String input) {

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        // Stack Strategy Timing
        long startStack = System.nanoTime();
        boolean stackResult = stackStrategy.check(input);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // Deque Strategy Timing
        long startDeque = System.nanoTime();
        boolean dequeResult = dequeStrategy.check(input);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;

        System.out.println("\n=== Performance Comparison ===");
        System.out.println("Stack Strategy Result: " + stackResult);
        System.out.println("Stack Execution Time: " + stackTime + " ns");

        System.out.println("\nDeque Strategy Result: " + dequeResult);
        System.out.println("Deque Execution Time: " + dequeTime + " ns");
    }
}
