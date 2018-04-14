import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InverseCaptchaTest {

    private InverseCaptcha inverseCaptcha = new InverseCaptcha();

    @Test
    public void test1(){
        assertEquals(3, inverseCaptcha.solve
                   ("1122"));
    }

    @Test
    public void test2(){
        assertEquals(4, inverseCaptcha.solve("1111"));
    }

    @Test
    public void test3(){
        assertEquals(0,inverseCaptcha.solve("1234"));
    }

    @Test
    public void test4(){
        assertEquals(9, inverseCaptcha.solve("91212129"));
    }
}
