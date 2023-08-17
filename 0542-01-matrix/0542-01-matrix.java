class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int [][] distances= new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                distances[i][j]=Integer.MAX_VALUE-10000;
            }
        }

        Queue<int[]> queue= new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    distances[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int [][] directions={{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] curr= queue.poll();
            int currRow= curr[0];
            int currCol= curr[1];

            for(int[] dir : directions){
                int newRow= currRow+dir[0];
                int newCol= currCol+dir[1];

                if(newRow>=0 && newRow<matrix.length && newCol>=0&& newCol<matrix[0].length){
                    if(distances[newRow][newCol]>distances[currRow][currCol]+1){
                        distances[newRow][newCol]=distances[currRow][currCol]+1;
                        queue.offer(new int[] {newRow, newCol});
                    }

                    }
                }
            }
        return distances;
    }
}