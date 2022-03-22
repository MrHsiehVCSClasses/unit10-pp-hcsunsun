package u10pp;


public class SudokuSolver{
    
    public static int[][] solve(int[][] puzzle){

        //base case
        if(noEmpty(puzzle) && valid(puzzle)){
            return puzzle;
        }
        
        else{

            //
            int r = 0;
            int c = 0;
            boolean shouldBreak = false;
            //for loop to go through every empty space, put in a valid value, then check validity, if no valid number, switch to next valid value
            for(int row = 0; row < puzzle.length; row++){
                for(int col = 0; col < puzzle.length; col++){
                    if(puzzle[row][col] == 0){
                        r = row;
                        c = col;
                        shouldBreak = true;
                        break;
                    }
                }
                if(shouldBreak)
                break;
            }


            for(int i = 1; i <= puzzle.length; i++){
                puzzle[r][c] = i;
                if(valid(puzzle)){
                
                    if(noEmpty(solve(puzzle))){
                        return puzzle;
                    } 
                }
                
                puzzle[r][c] = 0;
                
            }
            return puzzle;
        }
    }
    

    //helper methods

    //returns true if the puzzle is fulfilled
    public static boolean noEmpty(int[][] puzzle){
        for(int[] currR : puzzle){
            for(int curr : currR){
                if(curr == 0){return false;}
            }
        }
        return true;
    }

    //check if row, copl, box is valid
    public static boolean valid(int[][] puzzle){
        return rowCheck(puzzle) && colCheck(puzzle) && boxCheck(puzzle);
    }

    //row check returns true if no repeated number in all rows
    //precondition: curr != 0
    public static boolean rowCheck(int[][] puzzle){
        for(int r = 0; r < puzzle.length; r++){
            for(int c = 0; c < puzzle[r].length; c++){
                for(int curr = 0; curr < puzzle[r].length; curr++){
                    if(puzzle[r][c] != 0 &&  curr != c && puzzle[r][c] == puzzle[r][curr]){
                        return false;
                    }
                }
            }   
        }
        return true;
    }

    //column check returns true if no repeated number in all column
    //precondition: curr != 0
    public static boolean colCheck(int[][] puzzle){
        for(int c = 0; c < puzzle.length; c++){
            for(int r = 0; r < puzzle.length; r++){
                for(int curr = 0; curr < puzzle.length; curr++){
                    if(puzzle[r][c] != 0 &&  curr != r && puzzle[r][c] == puzzle[curr][c]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //check if the box has same number filled.
    //precondition: curr != 0
    public static boolean boxCheck(int[][] puzzle){
        int box = (int) Math.sqrt(puzzle.length) ;

        for(int row = 0; row < puzzle.length - 1; row += box){
            for(int col = 0; col < puzzle[row].length - 1; col += box){


                int[] currPuzz = new int[box * box];
                
                for(int r = 0; r < box; r++){
                    for(int c = 0; c < box; c++){
                       currPuzz[r * box + c] = puzzle[row + r][col + c];
                      
                    }
                }


                // //print the currpuzz
                // String printed = "";
                // for(int i = 0; i < currPuzz.length; i++){
                //     printed += currPuzz[i] + ", ";
                // }

                // System.out.println(printed);

                for(int curr = 0; curr < currPuzz.length; curr++){
                    for(int testing = 0; testing < currPuzz.length; testing++){
                        if(currPuzz[curr] != 0 && curr != testing && currPuzz[curr] == currPuzz[testing]){
                            return false;
                        }
                    }
                }
                


            }
        }
        return true;
    }

    public static String toString(int[][] puzzle){
        String result = "";
        for(int[] currRow: puzzle){
            for(int curr : currRow){
                result += " " + curr;
            }
            result += "\n";
        }
        return result;
    }
}