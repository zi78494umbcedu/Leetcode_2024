class MyStack {
    public Queue q1, q2;

    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    public void push(int x) {
        this.q2.add(x);
        while(this.q1.size()>0){
            q2.add(q1.peek());
            q1.poll();
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        if(q1.size()==0)return -1;
        int pop = (Integer) q1.peek();
        q1.poll();
        return pop;
    }
    
    public int top() {
        if(q1.size()==0)return -1;
        int pop = (Integer) q1.peek();
        return pop;
    }
    
    public boolean empty() {
        return this.q1.size()==0;
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