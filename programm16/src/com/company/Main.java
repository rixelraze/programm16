package com.company;

public class Main {

    public static void main(String[] args) {
        Calculation calculation = new Calculation(100, 5, 3);

        Converter<Calculation, Calculation2> converter11 = x -> new Calculation2(Calculation.a, Calculation.b, Calculation.c);

        Calculation2 calculation2 = converter11.convert(calculation);
        System.out.println("Результат через переконвертированный объект: " + Calculation2.display2());

    }
}


class Calculation {

    static double a;
    static double b;
    static double c;

    public Calculation(double a, double b, double c) {
        Calculation.a = a;
        Calculation.b = b;
        Calculation.c = c;

    }

    public static void display() {
        double result;
        result = a * Math.pow(b, c);
        System.out.println("Результат: " + result);
    }

}


class Calculation2 {
    static double a;
    static double b;
    static double c;

    Calculation2(double a, double b, double c) {
        Calculation2.a = a;
        Calculation2.b = b;
        Calculation2.c = c;
    }

    public static double display2() {
        double result;
        result = a * Math.pow(b, c);
        System.out.println("Результат: " + result);
        return result;
    }


}

@FunctionalInterface
interface Converter<T, N> {

    N convert(T t);

    static <T> boolean isNotNull(T t) {
        return t != null;
    }
}
