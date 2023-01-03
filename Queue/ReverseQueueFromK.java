import java.util.*;
public class ReverseQueueFromK{
	public static void reverse(Queue<Integer> q , int k){
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<k;i++){
			s.push(q.remove());
		}
		Deque<Integer> deque = new LinkedList<>();
		while(!s.isEmpty()){
			deque.addLast(s.pop());
		}
	    while(!q.isEmpty()){
			deque.addLast(q.remove());
		}
			System.out.println(deque);
	}
	public static void main(String[] args){
		Queue<Integer> q = new LinkedList<>();
		q.add(10);q.add(20);q.add(30);q.add(40);q.add(50);
		q.add(60);q.add(70);q.add(80);q.add(90);q.add(100);
		int k=5;
		reverse(q,k);
	}
}
