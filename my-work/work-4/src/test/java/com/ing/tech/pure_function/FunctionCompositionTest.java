package com.ing.tech.pure_function;

import com.ing.tech.pure_functions.PureFunction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionCompositionTest {

    @Test
    public void squareOf_5_is_25() {
        assertEquals(PureFunction.square.apply(5), Integer.valueOf(25));
    }

    @Test
    public void multiplyByTenTest() {
        assertEquals(PureFunction.multiplyBy10.apply(5), Integer.valueOf(50));
    }

    @Test
    public void square_then_multiply() {
        // TODO write test for the composition function
        assertEquals(PureFunction.squareAndMultiplyBy10.apply(5), Integer.valueOf(250));
    }
}
