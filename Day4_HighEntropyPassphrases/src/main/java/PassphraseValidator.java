import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class PassphraseValidator {

    /**
     * --- Day 4: High-Entropy Passphrases ---
     * A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. A passphrase consists
     * of a series of words (lowercase letters) separated by spaces.
     * <p/>
     * To ensure security, a valid passphrase must contain no duplicate words.
     * <p/>
     * For example:<br/>
     * aa bb cc dd ee is valid.<br/>
     * aa bb cc dd aa is not valid - the word aa appears more than once.<br/>
     * aa bb cc dd aaa is valid - aa and aaa count as different words.<br/>
     */
    public long getNumberOfValidPassphrases(String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        try {
            var bufferedReader = new BufferedReader((new FileReader(file)));
            return bufferedReader.lines().filter(s -> !hasDuplicates(s.split(" "))).count();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Could not find file: " + fileName, exception);
        }
    }

    private boolean hasDuplicates(String[] words) {
        return new HashSet<>(Arrays.asList(words)).size() < words.length;
    }
}
