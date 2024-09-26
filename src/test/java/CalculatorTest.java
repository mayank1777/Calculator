import org.example.Main;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testForPower() {
        double base = 2.0;
        double exponent = 3.0;
        double expectedResult = 8.0;
        double actualResult = Main.powerFunction(base, exponent);
        Assert.assertEquals("Power result is incorrect", expectedResult, actualResult, 0.000001);
    }

    @Test
    public void testForPowerIncorrect() {
        double base = 2.0;
        double exponent = 3.0;
        double incorrectResult = 10.0;
        double actualResult = Main.powerFunction(base, exponent);
        Assert.assertNotEquals("Test failed: The power result should not match", incorrectResult, actualResult);
    }

    @Test
    public void testForSquareRoot() {
        double number = 9.0;
        double expectedResult = 3.0;
        double actualResult = Main.squareRoot(number);
        Assert.assertEquals("Square root result is incorrect", expectedResult, actualResult, 0.000001);
    }

    @Test
    public void testForSquareRootIncorrect() {
        double number = 9.0;
        double incorrectResult = 4.0;
        double actualResult = Main.squareRoot(number);
        Assert.assertNotEquals("Test failed: The square root result should not match", incorrectResult, actualResult);
    }

    @Test
    public void testForFactorial() {
        int number = 5;
        long expectedResult = 120;
        long actualResult = Main.factorial(number);
        Assert.assertEquals("Factorial result is incorrect", expectedResult, actualResult);
    }

    @Test
    public void testForFactorialIncorrect() {
        int number = 5;
        long incorrectResult = 150;
        long actualResult = Main.factorial(number);
        Assert.assertNotEquals("Test failed: The factorial result should not match", incorrectResult, actualResult);
    }

    @Test
    public void testForLog() {
        double number = Math.E;
        double expectedResult = 1.0;
        double actualResult = Main.naturalLogarithm(number);
        Assert.assertEquals("Natural logarithm result is incorrect", expectedResult, actualResult, 0.000001);
    }

    @Test
    public void testForLogIncorrect() {
        double number = Math.E;
        double incorrectResult = 2.0;
        double actualResult = Main.naturalLogarithm(number);
        Assert.assertNotEquals("Test failed: The natural logarithm result should not match", incorrectResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForNegativeSquareRoot() {
        double number = -9.0;
        Main.squareRoot(number); // This should throw IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForNonPositiveLogarithm() {
        double number = 0.0;
        Main.naturalLogarithm(number); // This should throw IllegalArgumentException
    }
}
