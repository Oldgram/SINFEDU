import java.util.List;

public class VisitorList extends Visitor{
    public VisitorList(Class cls) {
        super(cls);
    }

    @Override
    List<Object> getFiltered() {
        return this.filtered;
    }

    @Override
    void visit(Visitable visitable) {
        visitable.accept(this);
    }

    @Override
    void visit(Object o) {
        if (this.toFilter.isInstance(o)) {
            this.filtered.add(o);
        }
    }
}
