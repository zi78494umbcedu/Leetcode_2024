class MyQueue {
    Stack<Integer> input, output;
    public MyQueue() {
        input = new Stack<Integer>();
        output= new Stack<Integer>();
    }
    
    public void push(int x) {
        this.input.add(x);
    }
    
    public int pop() {
        if(!output.empty()){
            return output.pop();
        }else{
            while(!input.empty()){
                output.push(input.pop());
            }
            return output.pop();
        }
    }
    
    public int peek() {
      if(!output.empty()){
            return output.peek();
        }else{
            while(!input.empty()){
                output.push(input.pop());
            }
            return output.peek();
        }
    }
    
    public boolean empty() {
        return (input.empty() && output.empty());
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */