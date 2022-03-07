class Main {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    int row = 0, col =1;
    while (row < matrix.length) {
      for(int j = 0, i = row; i >= 0; i--) {
        System.out.println(matrix[i][j]);
        j++;
      }
      row++;
    }
    row--;
    while (col < matrix[0].length) {
      for (int i = row, j = col; j < matrix[0].length; j++) {
        System.out.println(matrix[i][j]);
        i--;
      }
      col++;
    }
  }
}