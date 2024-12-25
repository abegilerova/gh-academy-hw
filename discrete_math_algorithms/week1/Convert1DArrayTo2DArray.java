public class Convert1DArrayTo2DArray {
    public static int[][] construct2DArray(int[] original, int mRow, int nCol) throws IllegalAccessException {

        if (mRow * nCol != original.length){
            throw new IllegalAccessException("Invalid dimensions: Cannot reshape array.");
        }

        int [][] result = new int[mRow][nCol];

        for (int i = 0; i < mRow; i++){
            for (int j = 0; j < nCol; j++){
                result[i][j] = original[i * nCol + j];
            }
        }

        return result;

    }

    public static void main(String[] args) throws IllegalAccessException {
        int [] original = {1,2,3,4};
        int m = 2;
        int n = 2;

        construct2DArray(original, m, n);
    }
}
