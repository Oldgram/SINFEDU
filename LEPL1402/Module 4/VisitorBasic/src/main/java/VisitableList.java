public class VisitableList extends Visitable{
    VisitableList(Object[] objs) {
        this.elements = objs;
    }

    @Override
    void accept(Visitor visitor) {
        for (Object o : this.elements) {
            visitor.visit(o);
        }
    }
}
