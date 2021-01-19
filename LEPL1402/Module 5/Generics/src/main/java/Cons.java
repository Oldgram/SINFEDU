public class Cons {
    // The item inside this list node
    public int v;
    // The next element, null if there is none
    public Cons next;

    // Returns a new Cons by applying function f on all elements
    public Cons map(F f) {
        return ((next == null) ? new Cons(f.apply(v), null) : new Cons(f.apply(v), next.map(f)));
    }
    // Returns a new Cons containing all elements that match predicate p
    public Cons filter(P p) {
        if (p.filter(v)) {
            return ((next == null) ? new Cons(v, null) : new Cons(v, next.filter(p)));
        } else {
            return ((next == null) ? null : next.filter(p));
        }
    }

    // Constructor
    public Cons(int v, Cons next) {
        this.v = v;
        this.next = next;
    }
}