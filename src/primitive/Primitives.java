package primitive;

public class Primitives {

    int i, a, b, c;

    public static void main(String[] args) {

        new Primitives().run();
    }

    public void run() {

        final boolean IS_ACTIVE = false;    //константа

        int j;

//        System.out.println(i);
//        System.out.println(j);


        System.out.println(IS_ACTIVE);

        byte a = 3; //-128 до 127 и занимает 1 байт

        short aShort = 3;       //-32768 до 32767 и занимает 2 байта

        int aInt = 4;           //-2147483648 до 2147483647 и занимает 4 байта

        int aIntZero;
//        System.out.println(aIntZero);

        long aLong = 5;         //от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807 и занимает 8 байт
//        Все целочисленные литералы, например, числа 10, 4, -5, воспринимаются как значения типа int
//                long num = 2147483649; //очень большое число, которое выходит за пределы допустимых значений для типа int, то мы столкнемся с ошибкой во время компиляции:
        long num = 2147483649L;

//        другие системы счисления
        int num111 = 0x6F; // 16-я система, число 111
        int num8 = 010; // 8-я система, число 8
        int num13 = 0b1101; // 2-я система, число 13

        System.out.println(" " + num111 + " " + num8 + " " + num13);

//        целые числа поддерживают разделение разрядов числа с помощью знака подчеркивания
        int x = 123_456;
        System.out.println(x);

//        Числа с плавающей точкой
        float xFloat = 8.5F;    //-3.4*10^38 до 3.4*10^38 и занимает 4 байта
        double xDouble = 8.5;   //от ±4.9*10^-324 до ±1.7976931348623157*10^308 и занимает 8 байт
//        3.1, 4.5 и т.д., Java автоматически рассматривает как double. Чтобы указать на float, надо использовать суффикс f:
        float fl = 30.6f;
        double db = 30.6;

//        Символы и строки
        char ch3 = '\u0066';            //hex utf-16
        char ch = 102;                  // utf-16 символ 'f'
        char ch2 = 'F';                 // символ 'f'
        String str2 = "F";              //Объект строка
        System.out.println(ch);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println('a' + 'b');
        System.out.println(str2 + ch2);

//        Строка = ОБЪЕКТ, ссылочный тип данных
        String hello = "Hello...";
        System.out.println(hello);
    }
}
