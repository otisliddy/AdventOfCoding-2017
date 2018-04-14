import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class PassphraseValidatorTest {

    final PassphraseValidator passphraseValidator = new PassphraseValidator();

    @Test
    public void testPassphraseValidator() {
        long actual = passphraseValidator.getNumberOfValidPassphrases("testFile");
        assertEquals(2L, actual);
    }

}
