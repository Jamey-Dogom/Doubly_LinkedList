package com.jd.dll;

public class DLL {
	public Node head;
	public Node tail;

	public DLL() {
		this.head = null;
		this.tail = null;
	}

	// the push method will add a new node to the end of the list
	public void push(Node newNode) {
		// if there is no head in the list, aka, an empty list, we set the newNode to be
		// the head and tail of the list
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}

		// first find the lastNode in the list
		// then, set the lastNode's next to be the newNode;
		// then, we have to set the previous of the lastNode to the lastNode that we
		// found previously.
		// finally, set the list's tail to be the node that we have added
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}

	public void printValuesForward() {
		// find the first node, aka head.
		Node current = this.head;

		// while the current node exists...
		while (current != null) {
			// print it's value
			System.out.println(current.value);
			// and move on to it's next node.
			current = current.next;
		}
	}

	public void printValuesBackward() {
		Node current = this.tail;

		while (current != this.head) {
			System.out.println(current.value);
			current = current.previous;
		}
	}

	public int size() {
		// find the first node, aka head.
		int count = 0;
		Node current = this.head;

		// while the current node exists...
		while (current != null) {
			// increment count
			count++;
			// and move on to it's next node.
			current = current.next;

		}
		return count;
	}

	// check if a value is in the doubly linked list 
	public boolean contains(Integer value) {
		Node current = this.head;

		// while the current node exists...
		while (current != null) {
			// increment count
			if (current.value == value) {
				return true;
			}
			// and move on to it's next node.
			current = current.next;

		}
		return false;
	}
	
	// pop method for doubly linked list
	public Node pop() {
		// make a copy of of the tail
		Node copy = new Node(this.tail.value);
		// get the value of the second to last node
		Node secondToLast = this.tail.previous;
		// make the second to last node next null essentially deleting the tail
		secondToLast.next = null;
		// set the dll tail to the secondtolast which is now last
		this.tail = secondToLast;
		return copy;
	}

}
