package org.shoper.springboot.lambda.anonymous_methods;

public class Test {
    public static int operateBinary(int a, int b, IntMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        IntMath addition = (n1, n2) -> n1 + n2;
        IntMath subtraction = (n1, n2) -> n1 - n2;
        System.out.println("40+20=" + operateBinary(40, 20, addition));
        System.out.println("40-20=" + operateBinary(40, 20, subtraction));
    }
}
