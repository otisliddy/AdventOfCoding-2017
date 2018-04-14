import java.io.*;
import java.util.Arrays;

public class CorruptionChecksum {

    /**
     * Determine the checksum of the input file. For each row, determine the difference between the largest value and the smallest value; the checksum
     * is the sum of all of these
     * differences.
     *
     * @param inputFile
     *            a file of CSV formst containing digits.
     * @return the result.
     */
    public int solve(final File inputFile) throws IOException {
        final var reader = new BufferedReader(new FileReader(inputFile));
        return reader.lines().mapToInt(s -> calculateChecksum(s)).sum();
    }

    private int calculateChecksum(final String line){
        final String[] parts = line.replace("\t"," ").split(" ");
        final int[] array = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        return array[array.length-1] - array[0];
    }

}
