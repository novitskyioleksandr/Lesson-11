import java.util.stream.Collectors;
import java.util.stream.Stream;

/*Завдання 4
Використовуючи Stream.iterate, створіть безкінечний стрім випадкових чисел,
але не використовуючи Stream.iterate.
Реалізуйте свій лінійний конгруэнтний генератор. Для цього почніть з x[0] = seed,
і далі кожний наступний елемент рахуйте по формулі на зразок x[n + 1] = 1 (a x[n] + c) % m
для коректних значень a, c, та m.
Необхідно імплементувати метод, що приймає на вхід параметри a, c, та m, і повертає Stream<Long>.
Для тесту використовуйте такі дані:
a = 25214903917
c = 11
m = 2^48 (2в степені48`)*/
public class StreamRandomNumber {
    private final long a = 25214903917l;
    private final long m = (long) Math.pow(2, 48);
    private final long c = 11l;
    private long seed;



    public Stream<Long> getRandomNumbers() {
        return Stream.iterate(0l, (seed) -> (a * seed + c) % m);
    }



    public static void main(String[] args) {
        StreamRandomNumber rm = new StreamRandomNumber();


        rm.getRandomNumbers()
                .limit(5)
                .forEach(System.out::println);

    }
}