import java.util.Arrays;

public class IntroductionExercices {
    public static int variable = 0;
    public static int[] squares;

    /**
     * Assign to the variable square, the square of the
     * parameters.
     *
     * Let assume that the program is invoked with the following
     * line:
     *  java IntroductionExercises 0 3 4 5
     *
     * The arguments of the program are 0, 3, 4 and 5.
     * After the execution of the main, the variable squares
     * should be:
     *  squares = [0, 9, 16, 25]
     *
     * If an exception occurs when converting an argument to
     * an integer, put 0 at the corresponding index. For example
     *
     *  java IntroductionExercise 0 3.1 4 5
     *
     * would yield
     *
     *  square = [0, 0, 16, 25]
     *
     * because 3.1 can not be converted to an integer
     * */
    public static void main(String... args) {
        squares = new int[args.length];
        int i = 0;
        for (String j : args) {
            try {
                int x = Integer.parseInt(j);
                squares[i] = x * x;
            }
            catch (Throwable ignored) {
                squares[i] = 0;
            }
            i++;
        }
    }

    public static void attribute(int value) {
        variable = value;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean equalsIntegrers(int a, int b) {
        return a == b;
    }

    public static int middleValue(int a, int b, int c) {
        if (a == b || a == c || b == c) {
            return -1;
        } else {
            if (a > b) {
                if (b > c) {
                    return b;
                } else if (a > c) {
                    return c;
                } else {
                    return a;
                }
            } else {
                if (a > c) {
                    return a;
                } else if (b > c) {
                    return c;
                } else {
                    return b;
                }
            }
        }
    }

    /*
     * Function that returns the max between a and b
     * You must use a ternary operation
     */
    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static String greetings(String str) {
        switch (str) {
            case ("Morning"): {
                return "Good morning, sir!";
            }
            case ("Evening"): {
                return "Good evening, sir!";
            }
            default: {
                return "Hello, sir!";
            }
        }
    }

    public static int[] lastFirstMiddle(int[] a) {
        return new int[] {a[a.length - 1], a[0], a[a.length / 2]};
    }

    public static int sum(int[] array) {
        int a = 0;
        for (int j : array) {
            a += j;
        }
        return a;
    }

    public static int maxArray(int[] array) {
        int a = array[0];
        int i = 0;
        while (i < array.length) {
            if (array[i] > a) {
                a = array[i];
            }
            i++;
        }
        return a;
    }
}
