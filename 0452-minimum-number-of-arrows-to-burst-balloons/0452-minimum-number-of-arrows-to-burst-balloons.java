class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }

        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrows=1;
        int prevend=points[0][1];

        for(int i=0;i<points.length;i++){
            if(points[i][0]>prevend){
                arrows++;
                prevend=points[i][1];
            }
        }

        return arrows;
    }
}