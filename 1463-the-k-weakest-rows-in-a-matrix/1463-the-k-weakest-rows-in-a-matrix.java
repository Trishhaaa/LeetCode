class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] rows= new int[mat.length];
        int[] result= new int[k];

        for(int i=0;i<mat.length;i++){
            int currRow=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    currRow++;
                }
            }
            rows[i]=currRow;
        }

        for (int i=0;i<k;i++){
            int min=Integer.MAX_VALUE;
            int minIdx=0;

            for(int j=0;j<rows.length;j++){
                if(rows[j]<min){
                    min=rows[j];
                    minIdx=j;
                }
            }
            result[i]=minIdx;
            rows[minIdx]=Integer.MAX_VALUE;
        }

        return result;

    }
}