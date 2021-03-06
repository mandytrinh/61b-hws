import static org.junit.Assert.*;
import org.junit.Test;

public class TestOffByOne
{
    @Test
    public void positiveOneOffTest()
    {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
    }

    @Test
    public void positiveOneOffOtherWayTest()
    {
        OffByOne obo1 = new OffByOne();
        assertTrue(obo1.equalChars('u', 't'));
    }

    @Test
    public void negativeOneOffTest()
    {
        OffByOne obo2 = new OffByOne();
        assertFalse(obo2.equalChars('f','z'));
    }
}
