//Assignment13 - N Queens
//Taha
//ICS4U1
//November 23, 2019

public class Main{

    public static int n = 4; //determines Length and Width of chessboard
    public static int[][] board = new int[n][n];
    public static int counter = 0; //counts recursive calls

    public static void main(String[]args){

        for (int i = 0; i < board.length; i++) { //fill 2d arrays with zeros
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 0;
            }
        }
    
        chess(0);

    }

    public static boolean chess(int row){ //fills chess board with max # of queens
        if(n > 0){ //chessboard can't be negative n x n

            print2dArray(board);
            if(row == n){ //a queen has been placed on every row 
                return true;
            }
            
            for (int i = 0; i < board.length; i++) {//trys all locations on that row 
                if(checkBoard(board, row, i)){ //checks if the queen can be placed on that index
                    counter++; 
                    board[row][i] = 1; //puts queen down 
                    if(chess(row + 1)){ //trys to place queen on the next row
                        return true; 
                    } 
                    board[row][i] = 0; //removes queen, only runs if queen can't be placed on rows below
                } 
            }
            
            return false; //queen can't be placed in that row
        } else {
            System.out.println("The value of N isn't possible.");
            return false;
        }

    }

    public static void print2dArray(int[][] array){ //prints chess board 
        System.out.println("Step #: " + counter);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    //checks if there is a 1 horizontally, vertically or diagonally across the element at row and index
    public static boolean checkBoard(int[][] array, int row, int index){ //returns true if queen can be placed

        for(int i = 0; i < array.length; i++) { //the array is n x n so only need to iterate through once
            if(array[row][i] == 1){ //checks horizontally
                return false;
            }
            if(array[i][index] == 1){//checks vertically
                return false;
            }
            
        }
        
        for (int i = 0; i < array.length; i++) { //checks diagonaly
            for (int j = 0; j < array[i].length; j++) {
                if(row+index == i+j || row-index == i-j){ //sum of row+index is the same as the sum of elements diagonal to it 
                    if(array[i][j] == 1){ //there is a queen in that spot
                        return false;
                    }
                }        
            }
        }
        return true;

    }

}