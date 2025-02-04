package statements;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Mathematics {
    /**
     * MATH.
     */
    public static void main(String[] args) {
        new Mathematics().run();
    }

    public void run() {
        var pi = Math.PI;

//        метод, которые позволяют вычислить значение по модулю
        System.out.println(Math.abs(-21.8d));

        //        Возведение в степень
        System.out.println(Math.pow(4, 2));  //4^2

//        Извлечение корней
        System.out.println(Math.sqrt(9));

//        Генерация случайных чисел
        System.out.println(Math.random());  //double
        System.out.println(getRandomInt(10, 50));

//      Округление
//        round - округляет так, как привычно. Если дробная часть числа больше либо равна 0.5, то число будет округлено в большую сторону, иначе в меньшую.
//        Метод floor всегда, независимо от значений дробной части, округляет число в меньшую сторону
//        Метод ceil, напротив, вне зависимости от значений дробной части, округляет числа в большую сторону
        System.out.println(Math.round(1.4));
        System.out.println(Math.floor(1.4));
        System.out.println(Math.ceil(1.4));


//       если числа превышают допустимый диапазон? В таком случае BigInteger и BigDecimal.
//        BigInteger must support values in the range -2Integer.MAX_VALUE (exclusive) to +2Integer.MAX_VALUE (exclusive) and may support values outside of that range.
        BigInteger bi1 = new BigInteger("7897846854684684846546846546846354346843843854");
        BigInteger bi2 = new BigInteger("789784633333333333346846546846354346843843854");
        var res = bi1.add(bi2);
        System.out.println(res);

//      Неизменяемые десятичные числа произвольной точности со знаком.
//      BigDecimal состоит из целочисленного немасштабированного значения произвольной точности и 32-битной целочисленной степени
//        unscaledValue × 10^-scale
        BigDecimal bd = new BigDecimal("7897846854684684846546846546846354346843843854.35135463584");
        System.out.println(bd.scale());


    }

    private int getRandomInt(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
