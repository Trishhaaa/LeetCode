class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            if(stack.size()==0 || (stack.peek()<0 && asteroids[i]>0) || samesign(stack.peek(),asteroids[i])){
                stack.push(asteroids[i]);
            }
            else{
                while(stack.size()>0 && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i])){
                    stack.pop();
                }

                if(stack.size()==0 || stack.peek()<0){
                    stack.push(asteroids[i]);
                }
                else if(stack.peek()== Math.abs(asteroids[i])){
                    stack.pop();
                }
            }
        }

        int[] ans= new int[stack.size()];
        int i=stack.size()-1;
        while(!stack.isEmpty()){
            ans[i]=stack.pop();
            i--;
        }

        return ans;
    }

    public boolean samesign(int a, int b){
        if(a>0 && b>0){
            return true;
        }
        else if(a<b && b<0){
            return true;
        }
        return false;
    }
}