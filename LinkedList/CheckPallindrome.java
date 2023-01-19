import java.util.*;
public class CheckPallindromeLL{
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
	public static Node findMid(Node head){
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static boolean checkPalindrome(){
		// step 1 --> find mid
		Node mid = findMid(head);
		//step2--> reverse 2nd part
		Node prev = null;
		Node curr = findMid(head);
		Node next;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node right = prev;
		Node left = head;
		
		//step 3-->check left and right part..
		while(right!=null){
			if(left.data!=right.data)
				return false;
			left=left.next;
			right = right.next;
		}
		return true;
	}
	public static void main(String[] args){
		CheckPallindromeLL ll = new CheckPallindromeLL();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(2);
		ll.addLast(1);
		ll.print();
		System.out.println(checkPalindrome());
	}
}
