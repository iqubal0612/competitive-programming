import java.util.*;
public class ReverseStack{
	public static void reverseStack(Stack<Integer> s){
		 if(s.isEmpty()){
			return;
		}
		int top = s.pop();
		reverseStack(s);
		bottomAt(s,top);
		 
		
	}
		public static void bottomAt(Stack<Integer> s, int data){
		if(s.isEmpty()){
			s.push(data);
			return;
		}
		int top = s.pop();
		bottomAt(s,data);
		s.push(top);
	}

	public static void main(String[] args){
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
	    reverseStack(s);
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
		
	}
}
