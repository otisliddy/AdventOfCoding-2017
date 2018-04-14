import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TwistyTrampoline {

    /**
     * @see <a href="http://adventofcode.com/2017/day/5">Advent of Code Day 5</a>
     */
    public int solve(String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        final File file = new File(classLoader.getResource(fileName).getFile());
        try {
            var bufferedReader = new BufferedReader((new FileReader(file)));
            int[] jumpOffsets = bufferedReader.lines().mapToInt(s -> Integer.parseInt(s)).toArray();
            int currentIndex = 0, countJumps = 0;
            while (currentIndex < jumpOffsets.length) {
                jumpOffsets[currentIndex] += 1;
                currentIndex = currentIndex + jumpOffsets[currentIndex] - 1;
                countJumps++;
            }
            return countJumps;

        } catch (FileNotFoundException exception) {
            throw new RuntimeException("Could not find file: " + fileName, exception);
        }
    }
}
