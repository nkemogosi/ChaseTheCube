package game;

public class LinkedList<Value> {
	private Node firstNode = null;
	private Node lastNode = null;
	public int counter;
	public int size;

	public LinkedList() {

	}

	public void add(Value value) {
		if (!isEmpty()) {
			addLast(value);
		} else {
			addFirst(value);
		}
		counter++;

	}

	public boolean isEmpty() {
		return (firstNode == null);
	}

	public void addFirst(Value value) {
		Node node = new Node(value);
		node.next = firstNode;
		firstNode = node;
		size++;

	}

	public void addLast(Value value) {
		Node tempNode = firstNode;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		Node newNode = new Node(value);
		newNode.prev = tempNode;
		tempNode.next = newNode;

		lastNode = tempNode.next;
		size++;
	}

	public Node removeFirst() {
		Node nodeRef = firstNode;
		if (!isEmpty()) {
			firstNode = nodeRef.next;
			size--;
		} else {

		}

		return nodeRef;
	}

	public Node removeLast() {
		Node nodeRef = lastNode;
		if (nodeRef != null) {
			lastNode = nodeRef.prev;
			size--;
		}
		return nodeRef;

	}

	private int length(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + length(node.next);
		}
	}

	public int length() {
		return length(firstNode);
	}

	public Node get(int index) {
		Node tempNode = firstNode;
		if (index != 0) {
			if (index > counter || index < 0) {

			} else {
				for (int x = 0; x < index; x++) {
					if (tempNode != null) {
						tempNode = tempNode.next;
					}
				}
			}
		}

		return tempNode;

	}

	public void remove(int index) {

		Node node;
		if (index != 0) {
			node = get(index);

			if (node.next != null) {
				node.next.prev = node.prev;
				node.prev.next = node.next;
			} else {
				removeLast();
			}
			size--;
		} else {
			removeFirst();
		}
		counter--;

	}

	public class Node {
		private Node next;
		private Node prev;
		public Value value;

		public Node(Value value) {
			this.value = value;
		}

		public String toString() {
			return String.valueOf(value);
		}

	}

	public void print() {
		Node temp = firstNode;
		String list = "";
		while (temp.next != null) {
			list += temp.value.toString() + ",";
			temp = temp.next;
		}
		list += temp.value.toString();
		System.out.println(list);
	}

	public int size() {
		int size = 0;
		Node temp = firstNode;
		while (temp.next != null) {
			temp = temp.next;
			size++;
		}
		this.size = size + 1;
		return size;
	}
}
