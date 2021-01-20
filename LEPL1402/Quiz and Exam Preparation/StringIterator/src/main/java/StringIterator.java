import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Question:
 *
 * You are asked to implement an IterableString allowing
 * to iterate on the successive chars of a given string
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class StringIterator {

    /**
     * Factory method
     * @param s the string on which to iterate
     * @return a new instance of your implementation of an IterableString allowing to iterate on s
     */
    public static IterableString makeIterableString(String s) {
        return new CustomIterableString(s);
    }

    /**
     * An IterableString permit to iterate on each character of a
     * string one by one from left to right
     */
    public interface IterableString extends Iterable<Character> {}

    public static class CustomIterableString implements IterableString {
        private int length;
        private String cargo;

        public CustomIterableString(String str) {
            this.length = str.length();
            this.cargo = str;
        }

        public int size() { return this.length; }

        public char getChar(int index) { return this.cargo.charAt(index); }

        @Override
        public Iterator<Character> iterator() {
            return new CustomStringIterator();
        }

        private class CustomStringIterator implements Iterator<Character> {
            private final int nChar = size();
            private Character current = getChar(0);
            private int cIndex = 0;

            private void failFastCheck() {
                if (size() > this.nChar) { throw new ConcurrentModificationException(); }
            }

            @Override
            public boolean hasNext() { return cIndex != nChar; }

            @Override
            public Character next() {
                failFastCheck();
                if (!hasNext()) { throw new NoSuchElementException(); }
                char c = current;
                cIndex++;
                if (hasNext()) {
                    current = getChar(cIndex);
                }
                return c;
            }
        }
    }


}
