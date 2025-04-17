package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);
        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should clear the screen or last digit when pressed clear")
    void testClearScreen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressClearKey();
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("clears screen and shows the memory")
    void testClearScreenWithMemory() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressEqualsKey();
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressClearKey();
        calc.pressEqualsKey();


        String expected = "11";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should display error when applying an inversion on zero")
    void testDivideByZeroInversion() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("1/x");
        assertEquals("Error", calc.readScreen());
    }


}

