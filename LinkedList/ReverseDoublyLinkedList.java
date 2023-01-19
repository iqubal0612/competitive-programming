import java.util.*;
public class ReverseDoublyLinkedList{
	public static class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	public static Node head;
	public static Node tail;
	public static int size=0;
	
	//add first
	public void addFirst(int data){
		Node newNode = new Node(data);
			size++;
		if(head==null){
			head = tail = newNode;
			return ;
		}
	
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}
	//add Last
	public void addLast(int data){
		Node newNode = new Node(data);
		size++;
		if(head==null){
			head = tail = newNode;
			return ;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	// remove first....
	public int removeFirst(){
		if(head==null){
            System.out.println("DLL is Empty");
			return Integer.MIN_VALUE;
		}
		if(size==1){
		int val = head.data;
		head = head.next;
		size--;
		return val;
		}
		int val = head.data;
		head = head.next;
		head.prev = null;
		size--;
		return val;
	}
	// remove last...
	public int removeLast(){
		if(head==null){
            System.out.println("DLL is Empty");
			return Integer.MIN_VALUE;
		}
		if(size==1){
			int val = tail.data;
			tail.prev = null;
			size--;
			return val;
		}
		int val = tail.data;
		tail = tail.prev;
		tail.next = null;
		size--;
		return val;
	}
	//print..
	public void print(){
		Node temp = head;
		if(head == null){
			System.out.println("DLL is Empty");
			return ;
		}
		while(temp!=null){
			System.out.print(temp.data+"<->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	public void reverse(){
		Node curr =head;
		Node next ;
		Node prev = null;
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			curr.prev = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
	}
	public static void main(String[] args){
		ReverseDoublyLinkedList dll = new ReverseDoublyLinkedList();
			dll.addFirst(3);
		dll.addFirst(2);
		dll.addFirst(1);
		dll.addLast(4);	
		dll.print();
		
		dll.reverse();
		dll.print();
	}
}
