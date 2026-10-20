public class p13_partA_2 {

    static <N extends Number> double average(N[] values) {
        double sum = 0;

        for (N value : values) {
            sum += value.doubleValue();
        }

        return sum / values.length;
    }

    public static void main(String[] args) {
        Integer[] integers = {10, 20, 30};
        Double[] doubles = {2.5, 5.5, 7.0};
        Long[] longs = {100L, 200L, 300L};

        System.out.println("Integer average: "
                           + average(integers));

        System.out.println("Double average: "
                           + average(doubles));

        System.out.println("Long average: "
                           + average(longs));
    }
}
