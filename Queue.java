import java.util.NoSuchElementException;

public class Queue<T> {
	private queueNode<T> first;
	private queueNode<T> last;
	private int size;

	private class queueNode<T>{
		private T value;
		private queueNode<T> next;
	}

	public Queue(){
		first = null;
		last = null;
		size = 0;
	}

	//Returns size of queue
	public int size(){
		return size;
	}

	//Returns if queue is empty
	public boolean isEmpty(){
		if(first==null){
			return true;
		}
		else{
			return false;
		}
	}

	//Adds item to top of the list
	public void enqueue(T element){
		queueNode<T> previousLast = last;
		last = new queueNode<T>();
		last.value = element;
		last.next = null;
		if(isEmpty()){
			first = last;
		}
		else{
			previousLast.next = last;
		}
		size++;
	}

	//Returns top item and removes it from the queue
	public T dequeue(){
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		T value = first.value;
		first = first.next;
		if(isEmpty()){
			first = null;
		}
		return value;
	}

	//Returns value of top node w/o removing it
	public T checkFirst(){
		return first.value;
	}
}
