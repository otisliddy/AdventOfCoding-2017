import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpiralMemoryTest {

    private SpiralMemory spiralMemory = new SpiralMemory();

    @Test
    public void test1() {
        assertEquals(3, spiralMemory.calculateDistanceToPort(12));
    }

    @Test
    public void test2() {
        assertEquals(31, spiralMemory.calculateDistanceToPort(1024));
    }

}
