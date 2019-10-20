package set_And_HashSet.operationsOnSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetsOperations {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("\nUnion contains " + union.size() + " elements.");
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.\n");

        for (int i : intersection) {
            System.out.println(i + " is the square of: " + Math.sqrt(i) + " and the cube of: " + Math.cbrt(i));
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("\nNature - divine: ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("Divine - nature: ");
        Set<String> diff2 = new HashSet<>(divine);
        diff1.removeAll(nature);
        printSet(diff2);

        System.out.println("Union of Divine & nature: ");
        Set<String> unionNatureDivine = new HashSet<>(divine);
        unionNatureDivine.addAll(nature);
        printSet(unionNatureDivine);

        System.out.println("Intersection of Divine & nature: ");
        Set<String> inter = new HashSet<>(divine);
        inter.retainAll(nature);
        printSet(inter);

        System.out.println("\n\nSymmetric difference:");
        unionNatureDivine.removeAll(inter);
        printSet(unionNatureDivine);

        if (nature.containsAll(divine)){
            System.out.println("Divine set is a subset of Nature set");
        }
        if (nature.containsAll(inter)){
            System.out.println("Inter set is a subset of Nature set");
        }
        if (divine.containsAll(inter)){
            System.out.println("Inter set is a subset of Divine set");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(" " + s);
        }
        System.out.println();
    }
}
