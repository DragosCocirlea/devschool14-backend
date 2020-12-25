package com.ing.tech.pure_functions;

import java.util.function.Function;

public class PureFunction {

    // TODO Implement functions
    public static Function<Integer, Integer> square = x -> x*x;
    public static Function<Integer, Integer> multiplyBy10 = x->x*10;
    public static Function<Integer, Integer> squareAndMultiplyBy10 = multiplyBy10.compose(square);

}
