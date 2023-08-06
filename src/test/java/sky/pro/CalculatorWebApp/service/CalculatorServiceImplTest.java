package sky.pro.CalculatorWebApp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sky.pro.CalculatorWebApp.exception.ZeroDivideException;

import static org.junit.jupiter.api.Assertions.*;
import static sky.pro.CalculatorWebApp.CalculatorTestConstants.*;

class CalculatorServiceImplTest {

    private final CalculatorService service = new CalculatorServiceImpl();

    @Test
    void plus() {
        Assertions.assertEquals(ONE + TWO, service.plus(ONE, TWO));
        Assertions.assertEquals(THREE + TWO, service.plus(THREE, TWO));
    }

    @Test
    void minus() {
        Assertions.assertEquals(THREE - TWO, service.minus(THREE, TWO));
        Assertions.assertEquals(THREE - THREE, service.minus(THREE, THREE));
    }

    @Test
    void multiply() {
        Assertions.assertEquals(TWO * TWO, service.multiply(TWO, TWO));
        Assertions.assertEquals(ONE * ZERO, service.multiply(ONE, ZERO));
    }

    @Test
    void divide() {
        Assertions.assertEquals(THREE / ONE, service.divide(THREE, ONE));
        Assertions.assertEquals(THREE / THREE, service.divide(THREE, THREE));
    }

    @Test
    void shouldThrowZeroDivideException() {
        Assertions.assertThrows(ZeroDivideException.class, () -> service.divide(THREE, ZERO));
    }
}