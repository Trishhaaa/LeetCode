class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack= new Stack<>();
        int bal=0;
        for(int i=0;i<s.length();){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                i++;
            }
            else{
                if(stack.isEmpty()){

                    if(i+1<s.length() && s.charAt(i+1)==')'){
                        bal++;
                        i+=2;
                    }
                    else{
                        bal+=2;
                        i++;
                    }
                }
                else{
                    if(i+1<s.length() && s.charAt(i+1)==')'){
                        i+=2;
                    }
                    else{
                        bal++;
                        i++;
                    }
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            bal+=2;
        }
        return bal;

    }
}