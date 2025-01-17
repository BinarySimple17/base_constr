package primitive;

public class Primitives {

    public static void main(String[] args) {

        new Primitives().primitiveTypes();
    }

    public void primitiveTypes() {

        final boolean IS_ACTIVE = false;    //константа

        System.out.println(IS_ACTIVE);

        byte a = 3; //-128 до 127 и занимает 1 байт
        System.out.println(a);

        short aShort = 3;       //-32768 до 32767 и занимает 2 байта
        System.out.println(aShort);

        int aInt = 4;           //-2147483648 до 2147483647 и занимает 4 байта
        System.out.println(aInt);

        int aIntZero;
//        System.out.println(aIntZero);

        long aLong = 5;         //от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807 и занимает 8 байт
        System.out.println(aLong);

        double xDouble = 8.5;   //от ±4.9*10^-324 до ±1.7976931348623157*10^308 и занимает 8 байт
        System.out.println(xDouble);

        float xFloat = 8.5F;    //-3.4*10^38 до 3.4*10^38 и занимает 4 байта
        System.out.println(xFloat);


        //Все целочисленные литералы, например, числа 10, 4, -5, воспринимаются как значения типа int
        //        long num = 2147483649; //очень большое число, которое выходит за пределы допустимых значений для типа int, то мы столкнемся с ошибкой во время компиляции:
        long num = 2147483649L;
        System.out.println(num);

        //другие системы счисления
        int num111 = 0x6F; // 16-я система, число 111
        int num8 = 010; // 8-я система, число 8
        int num13 = 0b1101; // 2-я система, число 13

        System.out.println(" " + num111 + " " + num8 + " " + num13);

        //целые числа поддерживают разделение разрядов числа с помощью знака подчеркивания
        int x = 123_456;
        System.out.println(x);

        //Числа с плавающей точкой
        //3.1, 4.5 и т.д., Java автоматически рассматривает как double. Чтобы указать на float, надо использовать суффикс f:
        float fl = 30.6f;
        double db = 30.6;
        System.out.println(fl);
        System.out.println(db);


//        Символы и строки
        char ch3 = '\u0066';            //UNICODE
        char ch = 102; // символ 'f'
        char ch2 = 'F'; // символ 'f'
        System.out.println(ch);
        System.out.println(ch2);
        System.out.println(ch3);

        //Строка = ОБЪЕКТ, ссылочный тип данных
        String hello = "Hello...";
        System.out.println(hello);
    }
}
