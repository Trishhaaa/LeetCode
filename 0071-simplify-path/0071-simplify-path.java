class Solution {
    public String simplifyPath(String path) {
        String[] p= path.split("/");
        Stack<String> stack = new Stack<>();

        for(String c:p){
            if(c.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }

            else if(!c.isEmpty() && !c.equals(".")){
                stack.push(c);
            }
        }

        String result="";
        while(!stack.isEmpty()){
            result="/"+stack.pop()+result;
        }

        if(result.length()==0){
            return "/";
        }

        return result;
    }
}