import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiTest {

    private final String[] numbers = new String[]{"1, 2, 0", "4, 5"};

    public String[] getNumbers() {
        return numbers;
    }

    /* Завдання 1
    Метод приймає на вхід список імен. Необхідно вернути рядок вигляду
    1. Ivan, 3. Peter... лише з тими іменами, що стоять під непарним індексом (1, 3 і т.д.)
     */

    public String oddIndexNames(List<String> names) {
        String oddIndexName = IntStream
                .range(0, names.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> String.format("%d. %s", index, names.get(index)))
                .collect(Collectors.joining(", ", "", "."));
        return oddIndexName;
    }

    /*Завдання 2 Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
    Повертає список цих рядків у верхньому регістрі, і відсортованих по спадання (від Z до A).*/

    public List<String> getReverseList(List<String> names) {
        List<String> result = names.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return result;
    }

    /*Завдання 3 Є масив:
    ["1, 2, 0", "4, 5"]
    Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,, наприклад:
    "0, 1, 2, 4, 5"*/

    public String getDigit(String[] numbers) {
        List<String> digit = Arrays.asList(numbers);
        String[] allDigit = digit.stream()
                .flatMap(p -> Arrays.asList(p.replaceAll("\s+", "").split(",")).stream())
                .sorted()
                .toArray(String[]::new);
        return Arrays.toString(allDigit);
    }

    /*Завдання 5 Напишіть метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
    який "перемішує" елементи зі стрімів first та second, зупиняючись тоді,
    коли у одного зі стрімів закінчаться елементи.*/

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());

        int minSize;
        if (firstList.size() >= secondList.size()) {
            minSize = secondList.size();
            ;
        } else {
            minSize = firstList.size();
        }

        List<T> result = new ArrayList<>();

        for (int i = 0; i < minSize; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }

        return result.stream();
    }


}