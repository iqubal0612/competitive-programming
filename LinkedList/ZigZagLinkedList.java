import java.util.*;
public class ZigzagLL{
public static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
			this.next = null;
		}
	}
	public static Node head;
	public static int size = 0;
	public static Node tail;
    // find mid
	public static Node getMid(Node head){
		Node slow = head;
		Node fast = head.next;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public static void zigzagList(Node head){
		// find mid
		Node mid = getMid(head);
		
		//reverse 2nd part
		Node prev = null;
		Node curr = mid.next;
		mid.next = null;
		Node next;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev=curr;
			curr = next;
		}
		Node left = head;
		Node right = prev;
		
		// 3rd Alternate Merging...
		Node nextL,nextR;
		
		while(left !=null && right!=null){
			nextL = left.next;
			left.next = right;
			nextR = right.next;
			right.next = nextL;
			
			right= nextR;
			left = nextL;
		}
	}
		public  void addFirst(int data){
		// 1...create a newNode....
		Node newNode = new Node(data);
		size++;
		//bc
		if(head==null){
			head=tail=newNode;
			return;
		}
		// 2.... newNode.next=head;
		newNode.next = head;
		
		// create newNode as head..
		head = newNode;
	}
	public void addLast(int data){
		// step 1 -- create a new node..
		Node newNode = new Node(data);
		size++;
		if(head==null){
			head=tail=newNode;
			return;
		}
		
		//step 2---- tail.next=newNode
		tail.next = newNode;
		//step3---> tail=newNode
		tail = newNode;
	}
		public void print(){
		Node temp = head;
		if(head==null){
			System.out.println("Linked List is Empty");
			return ;
		}
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public static void main(String[] args){
		ZigzagLL ll = new ZigzagLL();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.print();
		ll.zigzag();
		ll.print();
		/*LinkedList<Integer> ll = new LinkedList<>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		System.out.println(ll);
		zigzagList(head);
		System.out.println(ll);*/
	}
}
