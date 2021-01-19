import java.util.function.Predicate;
import java.util.function.Function;

public class Cons<E> {
    // The item inside this list node
    public E v;
    // The next element, null if there is none
    public Cons<E> next;

    // Returns a new Cons by applying Function function on all elements
    public <R> Cons <R> map(Function <E,R> function) {
        return ((next == null) ? new Cons<>(function.apply(v), null) : new Cons<>(function.apply(v), next.map(function)));
    }
    // Returns a new Cons containing all elements that match Predicate predicate
    public Cons <E> filter(Predicate <E> predicate) {
        if (predicate.test(v)) {
            return ((next == null) ? new Cons<>(v, null) : new Cons<>(v, next.filter(predicate)));
        } else {
            return ((next == null) ? null : next.filter(predicate));
        }
    }

    // Constructor
    public Cons(E v, Cons<E> next) {
        this.v = v;
        this.next = next;
    }
}
