class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();        
    }
    
    public void push(int x) {
        queue1.add(x);
        top=x;
    }
    
    public int pop() {
        while(queue1.size()>1){
            top=queue1.remove();
            queue2.add(top);
        }
        int poppedValue=queue1.remove();

        Queue<Integer> temp= queue1;
        queue1=queue2;
        queue2=temp;

        return poppedValue;
    }
    
    public int top() {
        return top;
        
    }
    
    public boolean empty() {
        return queue1.isEmpty();
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */