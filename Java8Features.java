import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Java8Features {
    public static void main(String args[]) {

        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5, 15, 23);

        test(new int[]{0, 1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{6, 4, 1});

        // demonstration of map method
        List<Integer> square = number.stream().map(x -> x*x).
                collect(Collectors.toList());
        System.out.println(square);

        // create a list of String
        List<String> names =
                Arrays.asList("Reflection","Collection","Stream");

        // demonstration of filter method
        List<String> result = names.stream().filter(s->s.startsWith("S")).
                collect(Collectors.toList());
        System.out.println(result);

        // demonstration of sorted method
        List<String> show =
                names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        // create a list of integers
        List<Integer> numbers = Arrays.asList(2,3,4,5,2);

        // collect method returns a set
        Set<Integer> squareSet =
                numbers.stream().map(x->x*x).collect(Collectors.toSet());
        System.out.println(squareSet);

        // demonstration of forEach method
        numbers.stream().map(x->x*x).forEach(y->System.out.println(y));

        // demonstration of reduce method
        //TODO
        int even =
                number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

        System.out.println(even);
        List<Integer> num = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(toList());
        System.out.println(sumStream(num));
    }

    private static int sumStream(List<Integer> list) {
        list.stream().map(y->y+1).forEach(z-> System.out.println(z));
        list.parallelStream().forEach(y -> System.out.println(y));
        return 0;
    }

    private static void test(int[] arr, int[] l, int[] v, int[] val) {
        int q = l.length;
        int[] result = new int[20];
        int counter = 0;
        for (int i = 0; i < q; i++) {
            for(int j = l[i]; j < v[i]; j++) {
                System.out.print(arr[j] +"&"+ val[i] +"=");
                result[counter] = arr[j]&val[i];
                System.out.println(result[counter]);
                counter++;
            }
        }
    }
}