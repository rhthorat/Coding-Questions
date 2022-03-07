class Main {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    int left = 0, right = matrix[0].length - 1,
      top = 0, bottom = matrix.length - 1;
    
    while (top<=bottom && left <= right) {
      for (int j = left; j <=right; j++) {
        System.out.println(matrix[top][j]);
      }
      top++;
      for (int i = top; i <= bottom; i++) {
        System.out.println(matrix[i][right]);
      }
      right--;
      for (int j = right; j >= left; j--) {
        System.out.println(matrix[bottom][j]);
      }
      bottom--;
      for (int i = bottom; i >= top; i--) {
        System.out.println(matrix[i][left]);
      }
      left++;
    }
  }
}