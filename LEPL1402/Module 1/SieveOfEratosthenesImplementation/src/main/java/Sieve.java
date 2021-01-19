import java.util.BitSet;

public class Sieve{
    /*
    algorithm Sieve of Eratosthenes is
        input: an integer n > 1.
        output: all prime numbers from 2 through n.

        let A be an array of Boolean values, indexed by integers 2 to n,
        initially all set to true.

        for i = 2, 3, 4, ..., not exceeding √n do
            if A[i] is true
                for j = i², i²+i, i²+2i, i²+3i, ..., not exceeding n do
                    A[j] := false

        return all i such that A[i] is true.
     */
    public static BitSet bits; //You should work on this BitSet

    public static int numberOfPrime(int n) {
        BitSet A = new BitSet(n + 1);
        A.flip(2, n);

        for (int i = 2; i <= java.lang.Math.sqrt(n); i++) {
            if (A.get(i)) {
                for (int j = i * i; j < n; j += i) {
                    A.set(j, false);
                }
            }
        }

        return A.cardinality();
    }
    
}