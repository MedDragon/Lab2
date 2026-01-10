/**
 * Mimics functional lists.
 * @author Artem
 * @since 1.0
 */
public abstract class FunList {
    /** @return the first int in the list object */
    public abstract int car();
    /** @return the tail of the list object */
    public abstract FunList cdr();

    /**
     * NOTE: toString() method is NOT abstract. It calls toStringHelp().
     * This is an example of the "Template Method Pattern".
     * @return string representation
     */
    public String toString() {
        return "(" + toStringHelp() + " ) ";
    }

    /** @return a String description of the list object */
    abstract String toStringHelp();

    /** * @param other list to append to this one
     * @return a new list with elements of this and other
     */
    public abstract FunList append(FunList other);

    /** * @param i element to insert
     * @return a new list with i inserted in non-descending order
     */
    public abstract FunList insertInOrder(int i);

    /** @return a new sorted list */
    public abstract FunList sort();
}