import java.util.function.Function;

public abstract class FTree<A> {

    public final int depth() {
        if (this.left() == null && this.right() == null) {
            return 0;
        }
        int lDepth = this.left().depth(), rDepth = this.right().depth();
        return ((lDepth > rDepth) ? lDepth + 1 : rDepth + 1);
    }

    public abstract A value();
    public abstract FTree<A> left();
    public abstract FTree<A> right();

    public final <B> FTree<B> map(Function<A,B> f) {
        return ((depth() == 0) ? new Leaf<B>(f.apply(this.value())): new Node<B>(f.apply(this.value()), this.left().map(f), this.right().map(f)));
    }
}
