import model.Creature;
import model.Human;
import model.Humanoid;

@SuppressWarnings({"ConstantValue", "DataFlowIssue", "lossy-conversions", "PointlessBooleanExpression", "unused", "UnusedAssignment",
        "ReassignedVariable", "SuspiciousNameCombination"})
public class StatementsExample {

    public void run() {

        simpleStatements();

        ifStatements();

        loops();

    }

    private void simpleStatements() {
        //У каждого оператора Java есть свой приоритет. Чем он выше, тем раньше оператор выполнится в выражении.
        // Бинарные и тернарный операторы (кроме присваивания) выполняются слева направо, а остальные (унарные и присваивания) — справа налево


        System.out.println("Оператор присваивания");
        int x = 1;    // Объявляем числовую переменную 'x' со значением 1
        boolean a, b; // Объявляем логические переменные 'a' и 'b'
        a = b = true;
        System.out.printf("%b, %b", a, b);

        System.out.println("Арифметические");
// Сложение чисел
        System.out.println(10 + 2);     // Вывод: 12
// Конкатенация строк
        System.out.println("A" + "B");  // Вывод: AB
// Сложение двух переменных типа 'char'
        System.out.println('a' + 'b');  // Вывод: 195

        // Деление без остатка
        System.out.println(10 / 2);     // Вывод: 5
        System.out.println(11 / 2);     // Вывод: 5

        // Деление на 'double'
        System.out.println(11 / 2d);    // Вывод: 5.5

        try {
            //noinspection NumericOverflow,divzero
            System.out.println(10 / 0);     // Ошибка Вывод:    Exception in thread "main" java.lang.ArithmeticException: / by zero
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //noinspection NumericOverflow,divzero
        System.out.println(10 / 0d);    // Вывод: Infinity


        System.out.println("Деление чисел по модулю (получение остатка от деления)");
        System.out.println(10 % 2);     // Вывод: 0
        System.out.println(11 % 2);     // Вывод: 1


        System.out.println("Унарные операторы меняют значение числа на положительное или отрицательное");
        int positive = 1;
        int negative = -2;

        System.out.println(-positive);    // Вывод: -1
        System.out.println(+negative);    // Вывод: 2


        int aInc = 0, bInc = 0, cInc = 0, dInc = 0;

        System.out.println("Префиксный инкремент/декремент");
        //Префиксные операторы (++x) сразу меняют значение переменной и подставляют его в выражение.
        //Постфиксные операторы (x++) делают наоборот — сначала используют старое значение переменной и только потом подставляют новое.
        // + есть еще ! — логическое отрицание, и ~ — побитовое отрицание
        System.out.println(++aInc);    // Вывод: 1
        System.out.println(--bInc);    // Вывод: -1

        System.out.println("Постфиксный (значение переменных изменится после вывода в консоль)");
        System.out.println(cInc++);    // Вывод: 0
        System.out.println(dInc--);    // Вывод: 0


        System.out.println("Оператор instanceof");
        Object object = new Human(null, 0, Creature.REPTILIAN);
        System.out.println(object instanceof Human); // 'true',
        System.out.println(object instanceof Object); // 'true', так как 'object' наследник 'Object'
        System.out.println(object instanceof Math); // 'false', так как 'object' не принадлежит классу 'Math'
        System.out.println(object instanceof Humanoid); // 'true'

        System.out.println("Составные операторы присваивания");
        // записываются короче и неявно приводят переменные к одному типу, если эти типы различаются
        int xSost = 1;
        double ySost = 3.1415d;

        //xSost = xSost + ySost;        // Эта строка не скомпилируется
        xSost += ySost;           // А здесь всё хорошо
        // Оператор += в развёрнутом виде
        xSost = (int) (xSost + ySost);

    }

    private void ifStatements() {

        System.out.println("Операторы сравнения");
/*              ==	Равно
                >	Больше, чем
                <	Меньше, чем
                >=	Больше или равно
                <=	Меньше или равно
                !=	Не равно*/
        if (1 != 0) {
            System.out.println("true");   // Вывод: true
        }

        System.out.println("Логические операторы");
// AND
        boolean aBool = (6 > 5) && (7 > 4);
        System.out.println(aBool); // Результат: true, так как оба выражения true

// OR
        Human mark = new Human("Mark", 0, Creature.REPTILIAN);
        Human mark2 = new Human("Mark 2", 0, Creature.HUMAN);
        boolean bBool = isReptilian(mark) || isReptilian(mark2);
        System.out.println(bBool); // Результат: true, так как одно из выражений true
        //бинарный ИЛИ
        bBool = isReptilian(mark) | isReptilian(mark2);
        System.out.println(bBool);

//        if (mark > mark2) {
//
//        }

// XOR
        boolean cBool = (6 > 8) ^ (6 > 7);
        System.out.println(cBool); // Результат: false, так как оба выражения — false

// NOT
        boolean dBool = (6 > 5);
        System.out.println(!dBool); // Результат: false, так как изначальное выражение — true

        System.out.println("Тернарный оператор");
        boolean cond = true;
        int aTern;
        if (cond) {
            aTern = 100;
        } else {
            aTern = 200;
        }

        aTern = cond ? 100 : 200;
    }

    private boolean isReptilian(Human human) {
        System.out.printf("isHuman returns %b%n", human.getType() == Creature.REPTILIAN);
        return human.getType() == Creature.REPTILIAN;
    }

    private void loops(){

    }

}
