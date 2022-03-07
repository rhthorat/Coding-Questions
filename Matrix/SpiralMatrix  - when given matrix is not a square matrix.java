import java.util.*;
class Main {
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12}};
    ArrayList<Integer> arr = spirallyTraverse(matrix, 3, 4);
    for (int i = 0; i < arr.size(); i++) {
      System.out.print(arr.get(i) + " ");
    }
  }
  public static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                arr.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                arr.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                arr.add(matrix[bottom][j]);
            }
            bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                arr.add(matrix[i][left]);
            }
            left++;
            }
        }
        return arr;
    }
}