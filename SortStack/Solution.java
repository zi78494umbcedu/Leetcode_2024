import java.util.* ;
import java.io.*; 
public class Solution {
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		 sStack(s);
		 return s;
	}

	static void sStack(Stack<Integer> s){
		if(s.isEmpty()){
			return;
		}
		int element = s.pop();
		sStack(s);
		sort(element, s);
	}

	static void sort(int element, Stack<Integer> s){
		if(s.isEmpty()){
			s.push(element);
			return;
		}
		int pop = s.pop();
		if(element<=pop){
			sort(element,s);
		}
		s.push(pop);
		if(element>pop){
			s.push(element);
		}
	}
}
