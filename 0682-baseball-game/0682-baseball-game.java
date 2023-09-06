class Solution {
    public int calPoints(String[] operations) {
        Stack<String> points= new Stack<>();
        int score=0;

        for(String op:operations){
            if(op.equals("+")){
                int a=Integer.parseInt(points.pop());
                int newScore=a+Integer.parseInt(points.peek());
                points.push(Integer.toString(a));
                points.push(Integer.toString(newScore));
            }
            else if(op.equals("D")){
                int newScore=2*Integer.parseInt(points.peek());
                points.push(Integer.toString(newScore));
            }
            else if(op.equals("C")){
                points.pop();
            }
            else{
                points.push(op);
            }
        }

        while(!points.isEmpty()){
            score+=Integer.parseInt(points.pop());
        }

        return score;
    }

}