public class MyMain {

    // Returns the number of odd numbers in mat
    public static int countOdds(int[][] mat) {
        int odds = 0;
        for (int[] arr: mat) {
            for (int num: arr){
                if (num % 2 != 0){
                    odds++;
                }
            }
        }
        return odds;
    }

    // Returns the largest value in mat
    public static int findLargest(int[][] mat) {
        int max = mat[0][0];
        for (int[] arr: mat) {
            for (int num: arr){
                if (num>max){
                    max = num;
                }
            }
        }
        return max;
    }

    // Write a method that "left-shifts" each row in a 2D array.
    // This means that for each row, all the numbers should be
    // shifted to the left by 1, with wraparound (the first value
    // should wrap around to the last entry in the row)
    public static int[][] leftShift(int[][] mat) {
        for (int[] arr: mat){
            int temp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = temp;
        }
        return mat;
    }

    // Creates a new array list of size arraySize x arraySize
    // where each value is each to the sum of its row and col indexes
    public static int[][] arrayBuilder(int arraySize) {
        int[][] mat = new int[arraySize][arraySize];
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                mat[row][col] = row+col;
            }
        }
        return mat;
    }










    // Methods for the homework:

    // Returns the mean of the 2D array mat
    public static double mean(double[][] mat) {
        double sum = 0;
        for (double[] arr: mat) {
            for (double num: arr){
                sum += num;
            }
        }
        return sum/Math.pow(mat.length,2);
    }

    // Returns the median of the 2D array mat
    // Remember that the array is sorted!
    public static double median(double[][] mat) {
        System.out.println(mat);
        double length = mat.length*mat[0].length;
        length/=2;
        System.out.println(length);
        double counter = 0;
        double firstNum = 0;
        boolean first = false;
        for (double[] arr: mat){
            for (double num: arr ){
                counter++;
                if (counter-length>0.0001){
                    if (!first) {
                    return num;
                    }
                    else{
                        return ((num+firstNum)/2);
                    }
                }
                else if (Math.abs(counter-length)<0.0001){
                    firstNum = num;
                    first = true;
                }
            }
        }
    return -1.0;
    }


    // Returns the mode of the 2D array mat
    // Remember that the array is sorted!
    public static double mode(double[][] mat) {
        double mode = mat[0][0];
        int highCount = 0;
        int count = 0;
        double lastNum = mat[0][0];
        for (double[] row:mat) {
            for (double num: row) {
                if (Math.abs(num-lastNum)<0.0001){
                    count++;
                }
                else{
                    if (count>highCount){
                        highCount=count;
                        mode=lastNum;
                    }
                    count = 0;
                    lastNum = num;
                }
            }
        }
        return mode;
    }


    public static void main(String[] args) {
        int[][] mat = {{1, 6, 12, 14},
                        {15, 18, 20, 25},
                        {32, 37, 45, 56},
                        {65, 69, 72, 75}
        };
        System.out.println(countOdds(mat));
        System.out.println(findLargest(mat));
        System.out.println(leftShift(mat));

        arrayBuilder(5);
    }
}
