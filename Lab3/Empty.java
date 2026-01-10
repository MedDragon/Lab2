/**
 * Mimics functional empty list using Singleton pattern.
 * @author Artem
 * @since 1.0
 */
public class Empty extends FunList {
    /** Singleton instance */
    private static Empty _instance = new Empty();

    /** Private constructor for Singleton */
    private Empty() {}

    /** @return the unique instance of Empty */
    public static Empty UniqueInstance() {
        return _instance;
    }

    public int car() {
        throw new java.util.NoSuchElementException("car requires a non Empty Funlist");
    }

    public FunList cdr() {
        throw new java.util.NoSuchElementException("cdr requires a non Empty Funlist");
    }

    String toStringHelp() {
        return "";
    }

    @Override
    public FunList append(FunList other) {
        return other;
    }

    @Override
    public FunList insertInOrder(int i) {
        return new Cons(i);
    }

    @Override
    public FunList sort() {
        return this;
    }
}