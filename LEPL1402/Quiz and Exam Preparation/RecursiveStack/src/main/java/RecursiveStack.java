/**
 * Question:
 *
 * You are asked to implement the abstract data type RecursiveStack below.
 *
 * Your implementation can be an inner static class or a class below.
 * The factory method "makeRecursiveStack" returns a new instance of your implementation
 *
 * Once it is done, copy-paste the complete file in Inginious also with the imports
 *
 *
 * Feel free to add classes, methods or fields in the class but do not modify
 * the signature of existing code
 *
 */
public interface RecursiveStack {

    /**
     * Factory method
     * @return a new instance of your implementation of RecursiveStack
     */
    public static RecursiveStack makeRecursiveStack() {
        return new CustomRecursiveStack();
    }


    int size();

    int top();

    RecursiveStack removeTop();

    RecursiveStack addTop(int v);

    // TODO implement an (inner) class that implements the interface
    public class CustomRecursiveStack implements RecursiveStack {
        private int size;
        private int top;
        private RecursiveStack next;

        public CustomRecursiveStack(RecursiveStack next) {
            this.next = next;
        }

        public CustomRecursiveStack() {
            this.next = null;
        }

        @Override
        public int size() { return this.size; }

        @Override
        public int top() { return this.top; }

        @Override
        public RecursiveStack removeTop() {
            return (this.next == null) ? new CustomRecursiveStack() : this.next;
        }

        @Override
        public RecursiveStack addTop(int v) {
            if (this.size == 0) {
                this.top = v;
                if (this.next != null) {
                    this.size = 1 + this.next.size();
                } else {
                    this.size++;
                }
                return this;
            } else {
                RecursiveStack stack = new CustomRecursiveStack(this);
                stack.addTop(v);
                return stack;
            }
        }
    }
}
