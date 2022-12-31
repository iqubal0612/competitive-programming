import java.util.*;
public class ImplementQueueUsingdeque{
	static class Queue{
		static Deque<Integer> deque = new LinkedList<>();
		public static void add(int data){
			deque.addLast(data);
		}
		public static int remove(){
			return deque.removeFirst();
		}
		public static int peek()
		{
			return deque.getFirst();
		}
	}
	public static void main(String[] args){
	Queue q = new Queue();
		q.add(1);q.add(2);q.add(3);
		System.out.println("peek="+q.peek());
		System.out.println(q.remove());
				System.out.println(q.remove());
					System.out.println(q.remove());
	}
}
