class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;

        int[] dx= {-1,-1,-1,0,0,1,1,1};
        int[] dy= {-1,0,1,-1,1,-1,0,1};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveneighbours=0;
                for(int k=0;k<8;k++){
                    int ni=i+dx[k];
                    int nj=j+dy[k];

                    if(ni>=0&&ni<m&&nj>=0&&nj<n&&(board[ni][nj]==1 || board[ni][nj]==-1)){
                        liveneighbours++;
                    }
                }

                if(board[i][j]==1 && (liveneighbours<2 || liveneighbours>3)){
                    board[i][j]=-1;
                }

                else if(board[i][j]==0 && liveneighbours==3){
                    board[i][j]=2;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                }
                else if(board[i][j]==2){
                    board[i][j]=1;
                }
            }
        }
    }
}