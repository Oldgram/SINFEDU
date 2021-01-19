public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] rows = s.split("\n");
        int n_rows = rows.length, n_columns = rows[0].split("\\s").length;

        int[][] matrix = new int[n_rows][0];

        for (int row = 0; row < n_rows; row++){
            String[] str_column = rows[row].split("\\s");
            for (int column = 0; column < n_columns; column++){
                try{
                    matrix[row][column] = Integer.parseInt(str_column[column]);
                } catch(ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        return matrix;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        // TODO
        return 0;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        // TODO
        return null;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        // TODO
        return null;
    }
}
