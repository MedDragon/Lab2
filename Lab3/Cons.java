/**
 * Mimics fundamental function cons.
 * @author Artem
 * @since 1.0
 */
public class Cons extends FunList {
    /** Data stored in the head of the list */
    private int _dat;
    /** Pointer to the tail of the list */
    private FunList _cdr;

    /**
     * Standard constructor
     * @param carDat head value
     * @param cdr tail list
     */
    public Cons(int carDat, FunList cdr) {
        _dat = carDat;
        _cdr = cdr;
    }

    /**
     * Constructor for a list with one element
     * @param i the element value
     */
    public Cons(int i) {
        _dat = i;
        _cdr = Empty.UniqueInstance();
    }

    public int car() { return _dat; }
    public FunList cdr() { return _cdr; }

    String toStringHelp() {
        return " " + _dat + _cdr.toStringHelp();
    }

    @Override
    public FunList append(FunList other) {
        return new Cons(this.car(), this.cdr().append(other));
    }

    @Override
    public FunList insertInOrder(int i) {
        if (i <= this.car()) {
            return new Cons(i, this);
        } else {
            return new Cons(this.car(), this.cdr().insertInOrder(i));
        }
    }

    @Override
    public FunList sort() {
        return this.cdr().sort().insertInOrder(this.car());
    }
}