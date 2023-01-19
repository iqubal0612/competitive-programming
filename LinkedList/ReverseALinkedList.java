import java.util.*;
public class ReverseLL{
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
	public static void reverse(){
		Node prev = null;
		Node curr =tail = head;
				Node next;
		while(curr!=null){
	         next = curr.next;
			curr.next = prev;
		    prev = curr;
			 curr=next;
		}
		head = prev;
	}
	public static void main(String[] args){
		ReverseLL ll = new ReverseLL();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.print();
		ll.reverse();
		ll.print();
	}
}
