class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows= null;
        HashSet<Character> cols= null;

        for(int i=0;i<9;i++){
            rows= new HashSet<>();
            cols= new HashSet<>();

            for(int j=0;j<9;j++){
                char r= board[i][j];
                char c= board[j][i];
                if(r!='.'){
                    if(rows.contains(r)){
                        return false;
                    }
                    rows.add(r);
                }
                if(c!='.'){
                    if(cols.contains(c)){
                        return false;
                    }
                    cols.add(c);
                }

            }
        }

        for(int i=0;i<9;i=i+3){
            for(int j=0;j<9;j=j+3){
                if(!validGrid(board,i,j)){
                    return false;
                }

            }
        }
        return true;
    }

    static boolean validGrid(char[][] board, int row, int col){
        HashSet<Character> grid= new HashSet<>();
        int r=row+3;
        int c=col+3;

        for(int i=row;i<r;i++){
            for(int j=col;j<c;j++){
                char val= board[i][j];
                if(val!='.'){
                    if(grid.contains(val)){
                        return false;
                    }
                }
                grid.add(val);
            }
        }
        return true;
    }


}