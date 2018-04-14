import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwistyTrampolineTest {

    private TwistyTrampoline testObject = new TwistyTrampoline();

    @Test
    public void test1() {
        assertEquals(5, testObject.solve("testFile"));
    }
}
