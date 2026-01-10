/**
 * Test class for FunList operations.
 * @author Artem
 * @since 1.0
 */
public class SortTest {
    /**
     * Main entry point
     * @param args command line arguments
     */
    public static void main(String[] args) {
        FunList unsorted = new Cons(5, new Cons(1, new Cons(3)));
        System.out.println("Unsorted list: " + unsorted);

        FunList sorted = unsorted.sort();
        System.out.println("Sorted list:   " + sorted);

        FunList withFour = sorted.insertInOrder(4);
        System.out.println("After adding 4: " + withFour);

        FunList listA = new Cons(10, new Cons(20));
        FunList combined = withFour.append(listA);
        System.out.println("Combined list: " + combined);
    }
}