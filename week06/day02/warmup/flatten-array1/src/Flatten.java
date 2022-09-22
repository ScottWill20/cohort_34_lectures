import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flatten
{
    public static void main(String[] args)
    {
            List<ArrayList<String>> nestedList = new ArrayList<>();

            nestedList.add(0, new ArrayList<>(List.of("one")));
            nestedList.add(1, new ArrayList<>(List.of("two","three")));
            nestedList.add(2, null);
            nestedList.add(3, new ArrayList<>(List.of("four")));
            nestedList.add(4, new ArrayList<>(List.of("five")));

            System.out.println(flattenedList(nestedList));
            System.out.println(flattenArray(nestedList));
    }

    // KRISTOPHER
    public static List<String> flattenedList(List<ArrayList<String>> nestedList) {
        List<String> flattenedList = new ArrayList<>();
        nestedList.stream().filter(Objects::nonNull).forEach(flattenedList::addAll);
        return flattenedList;
    }

    // ESIN
    // accounts for arbitrarily deep nested list-like structures

    public static List<?> flattenArray(List<?> list) {
        if (list == null) return null;
        return list.stream().filter(Objects::nonNull).flatMap(x -> {
            if (x instanceof List) {
                return flattenArray((List<?>) x).stream();
            } else {
                return Stream.of(x);
            }
        }).collect(Collectors.toList());
    }

}
