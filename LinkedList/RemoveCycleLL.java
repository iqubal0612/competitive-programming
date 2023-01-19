import java.util.*;
public class RemoveCycleLL{
	public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next = null;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size;

	public static void removeCycle(){
		//step 1 -> Detect Cycle 
		Node slow=head;
		Node fast = head;
		Node prev = null;
		boolean cycle = false;
		while(fast!=null && fast.next!=null){
			slow=slow.next ;//+1
			fast = fast .next.next ; //+2
			if(slow==fast){
				cycle = true;
				break;
			}
			 
		}
		if(cycle==false)
			return ;
			// find meeting points
			slow = head;
			while(slow!=fast){
				slow=slow.next;//+1
				prev = fast;
				fast = fast.next;//+1
			}
			// step3 --> point last node to null
			prev.next = null;//last node...
		}
    public static boolean isCycle(){ //floyd cycle detect Algo
		Node slow=head;
		Node fast = head;
		while(fast!=null && fast.next!=null){
			slow=slow.next ;//+1
			fast = fast .next.next ; //+2
			if(slow==fast)
				return true;
		}
		return false;
	}
	public static void main(String[] args){
		head = new Node(1);
		Node temp = new Node(2);
		head.next = temp;
		head.next.next = new Node(3);
		head.next.next.next = temp;
		//1->2->3->1
		System.out.println(isCycle());
		removeCycle();
		System.out.println(isCycle());
	}
}
