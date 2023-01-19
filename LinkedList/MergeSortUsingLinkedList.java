import java.util.*;
public class MergeLL{
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
	public static int size=0;
	
	public static Node getMid(Node head){
		Node slow = head;
		Node fast = head.next;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static Node merge(Node head1 , Node head2){
		Node mergedLL = new Node(-1);
		Node temp = mergedLL;
		while(head1!=null && head2!=null){
			if(head1.data<=head2.data){
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}else{
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		while(head1!=null){
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}
		while(head2!=null){
			temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
		}
		return mergedLL.next;
	}
	
	public static Node mergeSort(Node head){
		if(head == null || head.next==null)
			return head;
		// find mid..
		Node mid = getMid(head);
		// left & right half ->ms
	   Node rightHead = mid.next;
	   mid.next = null;
	   
	   Node newLeft = mergeSort(head);
	   Node newRight = mergeSort(rightHead);
		
		// merge
		return merge(newLeft,newRight);
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
		MergeLL ll = new MergeLL();
		ll.addLast(5);
		ll.addLast(6);
		ll.addLast(4);
		ll.addFirst(10);
		ll.print();
		ll.head = ll.mergeSort(head);
		ll.print();
	}
}
