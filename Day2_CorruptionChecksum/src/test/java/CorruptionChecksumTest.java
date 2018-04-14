import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class CorruptionChecksumTest {

    private CorruptionChecksum corruptionChecksum = new CorruptionChecksum();

    @Test
    public void test1() throws IOException {
        assertEquals(18, corruptionChecksum.solve(new File("src/test/resources/input.csv")));
    }
}