
public class Sudoku {
  
  public static void main(String[] args) {
    int[][] board = {
                      {5,3,0,0,7,0,0,0,0},
                      {6,0,0,1,9,5,0,0,0},
                      {0,9,8,0,0,0,0,6,0},
                      {8,0,0,0,6,0,0,0,3},
                      {4,0,0,8,0,3,0,0,1},
                      {7,0,0,0,2,0,0,0,6},
                      {0,6,0,0,0,0,2,8,0},
                      {0,0,0,4,1,9,0,0,5},
                      {0,0,0,0,8,0,0,7,9}                      
                     }; 
     
    /*int[][] board = {
         {8,0,0,0,0,0,0,0,0},
         {0,0,3,6,0,0,0,0,0},
         {0,7,0,0,9,0,2,0,0},
         {0,5,0,0,0,7,0,0,0},
         {0,0,0,0,4,5,7,0,0},
         {0,0,0,1,0,0,0,3,0},
         {0,0,1,0,0,0,0,6,8},
         {0,0,8,5,0,0,0,1,0},
         {0,9,0,0,0,0,4,0,0}                      
        }; */

    printBoard(board);
    solve(board);
    System.out.println();
    printBoard(board);


  }
  
  public static void printBoard(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      if (i % 3 == 0) {
        System.out.println("-------------------------");
      }
      for (int j = 0; j < board[i].length; j++) {
        if (j % 3 == 0) {
          System.out.print("| ");
        }
        System.out.print(board[i][j] + " ");
        if (j == 8) {
          System.out.print("|");
        }
      }
      System.out.println();
    }
    System.out.println("-------------------------");
  }
  
  public static int[] find(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) {
          return new int[] {i, j}; // position (row, col)
        }
      }
    }
    return null;
  }
  
  public static boolean valid(int[][] board, int[] pos, int num) {

    // Row checking
    for (int i = 0; i < 9; i++) {
      if (num == board[pos[0]][i] && (pos[1] != i)) {
        return false;
      }
    }

    // Column checking
    for (int j = 0; j < 9; j++) {
      if (num == board[j][pos[1]] && (pos[0] != j)) {
        return false;
      }
    }

    // 3x3 grid check - split into 9 grids w/ x & y indices 0, 1, 2

    int boxRow = pos[1] / 3;
    int boxCol = pos[0] / 3;
    for (int k = boxCol * 3; k < boxCol * 3 + 3; k++) {
      for (int l = boxRow * 3; l < boxRow * 3 + 3; l++) {
        if (num == board[k][l] && new int[] {k, l} != pos) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static boolean solve(int[][] board) {
    int[] emptSq = find(board);
    if (emptSq == null) { // base case - no more empty squares with 0's
      return true; // board is solved
    }

    for (int i = 1; i < 10; i++) {
      if (valid(board, emptSq, i)) {
        board[emptSq[0]][emptSq[1]] = i;

        if (solve(board)) {
          return true;
        }
        board[emptSq[0]][emptSq[1]] = 0;  /*
                                          * backtracking - if above stmnt false means for loop has 
                                          * finished and there was no number which fit in correctly 
                                          * which means the previous choice was wrong and needs
                                          * to be set to 0 again
                                          */
      }
    }
    return false;
  }


}
