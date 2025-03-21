package statements;

import model.Creature;
import model.Human;
import typing.Typing;

import java.util.Random;

@SuppressWarnings({"ConstantValue", "DataFlowIssue", "lossy-conversions", "PointlessBooleanExpression", "unused", "UnusedAssignment",
        "ReassignedVariable", "SuspiciousNameCombination"})
public class StatementsExample {

    public static void main(String[] args) {
        new StatementsExample().run();
    }

    public void run() {

        primitiveStatements();

//        Java.lang.Math, java.math.BigDecimal, java.math.BigInteger
        new Mathematics().run();

        ifStatements();

        loops();

        switches();

        lambdaSwitch();

//        проверка типов
        new Typing().run();

    }

    private void lambdaSwitch() {

        Expression expression;

        int a = 2;

        expression = switch (a) {
            case 1 -> (x) -> 1 * x;
            case 2 -> (x) -> 2 * x;
            case 3 -> (x) -> 3 * x;
            default -> (x) -> 4 * x;
        };

        System.out.println(expression.apply(5));

    }

    private void switches() {

//        System.out.println(hash("Aa".hashCode()));
//        System.out.println(hash("BB".hashCode()));

//        switch statement
//        сравнение строк, разрешение коллизий
        String collision01 = "Aa";
        String collision02 = "BB";
        System.out.println(collision01.hashCode());
        System.out.println(collision02.hashCode());

        int switchResult = 0;
        switch ("BB") {
            case "Aa":
            case "CC", "DD":
                switchResult = 1;
                break;
            case "BB":
                switchResult = 2;
                break;
            default:
                switchResult = 3;
                break;
        }
        System.out.println(switchResult);

/*
        switch expression
Если switch в качестве оператора, тогда не имеет значения,
охвачены все варианты или нет. можно пропустить case,
и код будет работать неправильно, но компилятору все равно
стрелка
*/

        switchResult = switch ("BB") {
            case "Aa", "CC", "DD" -> 1;
            case "BB" -> 2;
            default -> 3;
        };
        System.out.println(switchResult);

        //двоеточие
        //yield ключевое слово, которое возвращает значение со свитча, аналог return в методах
        switchResult = switch ("BB") {
            case "Aa", "CC", "DD":
                yield 1;

            case "BB":
                yield 2;
            default:
                yield 3;
        };

        System.out.println(switchResult);

        Human human2;
        switchResult = switch ("BB") {
            case "Aa" -> {
                var human = new Human(null, 1, Creature.HUMAN);
                human2 = new Human(null, 1, Creature.HUMAN);
                yield 1;
            }
            case "BB" -> {
                human2 = new Human(null, 2, Creature.HUMAN);
                yield 2;
            }
            default -> {
                human2 = new Human(null, 3, Creature.REPTILIAN);
                yield 3;
            }
        };
//        System.out.println(human);
        System.out.println(human2);
        System.out.println(switchResult);

    }

    private void primitiveStatements() {
/*
        Операторы с обертками работают похожим образом, потому что для оберток сначала выполняется распаковка.
        разница есть в присваивании и сравнении
 */

        System.out.println("Оператор присваивания");
        boolean a, b; // Объявляем логические переменные 'a' и 'b'
        a = b = true;
        System.out.printf("%b, %b", a, b);

        System.out.println("Арифметические");
// Сложение чисел
        System.out.println(10 + 2);     // Вывод: 12
// Сложение двух переменных типа 'char'
        System.out.println('a' + 'b');  // Вывод: 195
// Конкатенация строк
        System.out.println("A" + "B");  // Вывод: AB
        Character charA = 'a';
        Character charB = 'b';
        System.out.println(charA + charB);      // Вывод: 195

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
        /*
        Префиксные операторы (++x) сразу меняют значение переменной и подставляют его в выражение.
        Постфиксные операторы (x++) делают наоборот — сначала используют старое значение переменной и только потом подставляют новое.
         + есть еще ~ — побитовое отрицание
        */
        System.out.println(++aInc);    // Вывод: 1
        System.out.println(--bInc);    // Вывод: -1

        System.out.println("Постфиксный (значение переменных изменится после вывода в консоль)");
        System.out.println(cInc++);    // Вывод: 0
        System.out.println(dInc--);    // Вывод: 0

        byte bit8 = 0b00110011;
        bit8 = (byte) ~bit8;
        System.out.println(Integer.toBinaryString(bit8 & 0xFF));

        System.out.println("Операторы сравнения");
/*              ==	Равно
                >	Больше, чем
                <	Меньше, чем
                >=	Больше или равно
                <=	Меньше или равно
                !=	Не равно
                разница с абапом только в записи == и !=.
                эти операторы работают с примитивами и обертками примитивов.
                Объекты сравнивают немного иначе.
                */
        System.out.println(aInc <= bInc); //Вывод False


        System.out.println("Составные операторы присваивания");
        // записываются короче и неявно приводят переменные к одному типу, если эти типы различаются
        int xSost = 1;
        double ySost = 3.1415;

//        xSost = xSost + ySost;        // Эта строка не скомпилируется
        xSost += ySost;           // А здесь всё хорошо
        // Оператор += в развёрнутом виде
        xSost = (int) (xSost + ySost);

        /*
            У каждого оператора Java есть свой приоритет. Чем он выше, тем раньше оператор выполнится в выражении.

            Приоритет арифметических операций
            Одни операции имеют больший приоритет, чем другие, и поэтому выполняются вначале. Операции в порядке уменьшения приоритета:
            i++, i-- постфиксный
            ++i, i-- префиксный
            * (умножение), / (деление), % (остаток от деления)
            + (сложение), - (вычитание)
                            Приоритет операций следует учитывать при выполнении набора арифметических выражений:
            Вначале будет выполняться операция инкремента ++b, которая имеет больший приоритет - она увеличит
            значение переменной b и возвратит его в качестве результата. Затем выполняется умножение 5 * ++b,
            и только в последнюю очередь выполняется сложение a + 5 * ++b
         */
        int aPrior = 8;
        int bPrior = 7;
        int cPrior = aPrior + 5 * ++bPrior;
        System.out.println(cPrior);  // 48

/*      скобки переопределяют порядок
        Несмотря на то, что операция сложения имеет меньший приоритет, но вначале будет выполняться именно сложение,
        а не умножение, так как операция сложения заключена в скобки
*/
        cPrior = (aPrior + 5) * ++bPrior;
        System.out.println(cPrior);  // 104

    }

    private void ifStatements() {

        if (1 != 0) {
            System.out.println("true");   // Вывод: true
        } else {
            System.out.println("else");
        }

//        How To Compare Characters in Java?
        char char01 = 'D';
        char char02 = 'd';
        char char03 = ' ';

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
        //просто if выполняет соответствующий блок, а тернарный оператор возвращает какой-то результат
        boolean cond = true;

        int aTern;

        aTern = cond ? 100 : 200;

        if (cond) {
            aTern = 100;
        } else {
            aTern = 200;
        }

    }

    private boolean isReptilian(Human human) {
        System.out.printf("isHuman returns %b%n", human.getType() == Creature.REPTILIAN);
        return human.getType() == Creature.REPTILIAN;
    }

    private void loops() {

        System.out.println("Loops: FOR");

        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) { // остаток от деления на два равен нулю?
                System.out.println(i); //
                continue; // сразу переходим к следующей итерации
            }
            if (i == 9) {
                System.out.println("Finish now!");
                break; // финиш жизни цикла
            }
        }

        System.out.println("Loops: FOREACH");

        int[] testArray = new int[100];
// наполним массив случайными числами в пределах от 0 до 99
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = new Random().nextInt(100);
        }

// теперь применим foreach
        int numberOfIteration = 1; // просто для наглядности будем выводить номер итерации


        for (int oneElementInArray : testArray) {
            if (oneElementInArray >= 50) {
                System.out.printf("\nIteration number: %d __ Element: %d", numberOfIteration,
                        oneElementInArray); // печатаем в консоль на новой строке номер итерации и элемент
                numberOfIteration++;
                continue; // переходим к следующей итерации и упускаем следующие строки в теле цикла
            }
            if (oneElementInArray == 0) { // сработает не в каждом запуске программы
                System.out.println("\ndonut!");
                break; // цикл завершится как только попадется элемент 0
            }
        }


        System.out.println("Loops: WHILE");

        int someNumber = 1;
        numberOfIteration = 1;
        while ((someNumber != 0) || numberOfIteration < 10) {
            someNumber = new Random().nextInt(100);
            System.out.println("Current someNumber is: " + someNumber);
            numberOfIteration++;
        }

        System.out.println("Loops: DO-WHILE");
        numberOfIteration = 1;
        do {
            someNumber = new Random().nextInt(100);
            System.out.println("Current someNumber is: " + someNumber);
            numberOfIteration++;
        } while ((someNumber != 0) || numberOfIteration < 10);
    }

    interface Expression {
        int apply(int x);
    }

}
