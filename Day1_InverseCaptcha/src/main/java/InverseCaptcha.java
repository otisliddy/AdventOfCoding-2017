import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InverseCaptcha {

    /**
     * Review a sequence of digits and find the sum of all digits that match the next digit in the list. The list is circular,
     * so the digit after the last digit is the first digit in the list.
     *
     * @param input
     *            a String consisting of digits.
     * @return the result.
     */
    public int solve(String input) {
        final char[] chars = input.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                if (chars[i] == chars[0]) {
                    result += Integer.valueOf(String.valueOf(chars[i]));
                }
            } else if (chars[i] == chars[i + 1]) {
                result += Integer.valueOf(String.valueOf(chars[i]));
            }
        }
        return result;
    }

}
