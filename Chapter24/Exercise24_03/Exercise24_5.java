
public class Exercise24_5 {

	public static void main(String[] args) {
		GenericQueue<Integer> queue = new GenericQueue<Integer>();
		
		queue.enqueue(1);
		queue.enqueue(56);
		queue.enqueue(6);
		System.out.println(queue);
		
		queue.dequeue();
		queue.dequeue();
		
		System.out.println(queue);

	}

}

class GenericQueue<E> extends java.util.LinkedList<E> {
	private static final long serialVersionUID = 1L;
	
	public void enqueue(E e) {
		addLast(e);
	}
	
	public E dequeue() {
		return this.removeFirst();
	}
}
