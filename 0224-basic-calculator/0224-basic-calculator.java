class Solution {
    public int calculate(String s) {
        int num=0;
        int result=0;
        int sign=1;

        Stack<Integer> stack= new Stack<>();

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if (c=='+'){
                result+=num*sign;
                num=0;
                sign=1;
            }
            else if(c=='-'){
                result+=num*sign;
                num=0;
                sign=-1;
            }
            else if(c=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
            }
            else if(c==')'){
                result+=num*sign;
                num=0;
                result*=stack.pop();
                result+=stack.pop();
            }
        }

        result+=sign*num;
        return result;
    }
}