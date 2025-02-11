package references;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        new OptionalExample().run();
    }

    public void run() {

//                какую проблему он решает

        var examples = new HashMap<Long, Example>();

        examples.put(1L, new Example("example1", 7));
        examples.put(2L, new Example("another example", 8));
        examples.put(3L, new Example(null, 8));

        ExampleRep exampleRep = new ExampleRep(examples);

/*        final Example ex01 = exampleRep.findById(4L);
        final String title = ex01.getTitle();
        System.out.println("Длина заголовка:" + title.length());*/

        final Example ex011 = exampleRep.findById(4L);
        if (ex011 != null) {
            final String title1 = ex011.getTitle();
            System.out.println("Длина заголовка:" + title1.length());
        }

//        а если 3?
        final Example ex012 = exampleRep.findById(3L);
        if (ex012 != null) {
            final String title11 = ex012.getTitle();
            if (title11 != null) {
                System.out.println("Длина заголовка:" + title11.length());
            }
        }

//        сделаем то же самое с Optional
        useOptional(examples);
//        упрощаем/усложняем
        useOptionalWithMap(examples);

//      !orElse!
        orElseExample(examples);
    }

    private void useOptional(HashMap<Long, Example> examples) {

        ExampleRepOptional exampleRep = new ExampleRepOptional(examples);

        final Optional<Example> optExample = exampleRep.findById(1L);

        /*
            здесь произошло концептуальное изменение:
            теперь точно известно, что метод findById() возвращает контейнер, в котором объект может отсутствовать.
         */

        if (optExample.isPresent()) {
            final Example example = optExample.get();
            final String title = example.getTitle();
            if (title != null) {
                System.out.println("Длина заголовка" + title.length());
            }
        }

    }

    private void useOptionalWithMap(HashMap<Long, Example> examples) {

        /*
         map(Function<T, U> mapper) — преобразует значение, если оно присутствует и заворачивает в Optional
         ifPresent(Consumer<T> consumer) — выполняет действие, если значение присутствует
         */

        ExampleRepOptional exampleRep = new ExampleRepOptional(examples);

//      Мы преобразовали объект типа Optional<Example> в Optional<String> и затем, используя метод ifPresent(),
//      вывели на консоль длину
        final Optional<Example> optExample = exampleRep.findById(1L);

//      Мы воспользовались методом map(), который позволяет преобразовать Optional<Example> в Optional<String>
        final Optional<String> optTitle = optExample.map(example -> example.getTitle());

        optTitle.ifPresent(
                title -> System.out.println("Длина заголовка: " + title.length())
        );

//        Код можно сократить
        final Optional<Example> optExample2 = exampleRep.findById(1L);
        optExample2.map(example -> example.getTitle())
                .ifPresent(
                        title -> System.out.println("Длина заголовка: " + title.length())
                );

//        и еще
        exampleRep.findById(1L)
                .map(Example::getTitle)
                .ifPresent(
                        firstName -> System.out.println("Длина заголовка: " + firstName.length())
                );
    }

    private void orElseExample(HashMap<Long, Example> examples) {

//Метод orElse() возвращает значение из контейнера, если оно есть, или значение по умолчанию, если объект отсутствует.
// Этот метод полезен, когда необходимо иметь заранее определённое значение для случая отсутствия данных.

// параметр orElse() будет выполнен, даже если у нас не пустой Optional
// т.е. он выполнится в любом случае!
        ExampleRepOptional exampleRep = new ExampleRepOptional(examples);

        System.out.println(
                exampleRep.findById(1L).orElse(doSomething()).getTitle()
        );

//	orElseGet(Supplier<T> supplier) — возвращает значение, если оно есть, или результат выполнения функции.
//        Метод orElseGet в Optional используется для предоставления значения по умолчанию,
//        если значение в Optional отсутствует. В отличие от orElse, который принимает готовое значение,
//        orElseGet принимает Supplier — функциональный интерфейс, который предоставляет значение только в случае,
//        если оно действительно нужно (ленивая инициализация).

        System.out.println(
                exampleRep.findById(1L).orElseGet(() -> doSomething()).getTitle()
        );
    }

    private Example doSomething() {
        System.out.println("DO SOMETHING");
        return new Example("42", 17);
    }

    class Example {
        private final String title;
        private final Integer size;

        public Example(String title, Integer size) {
            this.title = title;
            this.size = size;
        }

        public String getTitle() {
            return title;
        }

        public Integer getSize() {
            return size;
        }
    }

    class ExampleRep {

        private final Map<Long, Example> examples;

        public ExampleRep(Map<Long, Example> examples) {
            this.examples = examples;
        }

        public Example findById(Long id) {
            return examples.get(id);
        }

    }

    class ExampleRepOptional {

        private final Map<Long, Example> examples;

        public ExampleRepOptional(Map<Long, Example> examples) {
            this.examples = examples;
        }

        public Optional<Example> findById(Long id) {
            return Optional.ofNullable(examples.get(id));
        }

    }
}
