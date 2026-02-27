import java.util.Stack;

public class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        if (input == null || input.isEmpty()) {
            return false;
        }

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
