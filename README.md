# Sudoku Solver
This Sudoku Solver was implemented using the backtracking algortihm, which outputs the solved puzzle onto the computer when done.

# Instructions
Input your puzzle as a 2D array in the main method under 'board', represent blank spaces with a '0'. Run the program to get a solved output of your sudoku.

# Explanation 
The essence of the program is the solve() method. Implemented recursively, it makes use of the backtracking algorithm. 
The base case is if there are no empty spaces left, the function returns true. This inturn allows the function to return true within the for loop when called recursively. 
This results in the algortihm running until either there are no empty spaces OR until the for loop is over and there are no more valid spaces to put the numbers meaning one of the previous choices was incorrect. This exits and sets the current tile to 0, backtracking to the previous tile to try another combination that works.
