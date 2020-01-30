/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
 */
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	Node sentinel; // this will be the entry point to your linked list (the
	// head)

	public LinkedListImpl() {// this constructor is needed for testing purposes.
		// Please don't modify!
		sentinel = new Node(0);// Note that the root's data is not a true part
		// of your data set!
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to
		// grab your linkedList easily.
		return sentinel;
	}

	private int _size = 0; 
	@Override
	public boolean insert(double elt, int index) {

		Node insert = new Node(elt); 

		if(index > this.size() || index < 0){
			return false; 
		}else{
			if(isEmpty()){
				insert.next = sentinel; 
				insert.prev = sentinel; 
				sentinel.next = insert; 
				sentinel.prev = insert; 
				_size++;
				return true; 
			}else if(index == this.size()){
				Node Last = insert; 
				Node pLast = sentinel.getPrev();
				sentinel.prev = insert; 
				pLast.next = Last; 
				Last.prev = pLast; 
				Last.next = sentinel;
				_size++; 
				return true; 
			}else{
				Node current = this.trasverse(index); 
				Node next = current.getPrev();
				next.next = insert; 
				insert.next = current; 
				insert.prev = next; 
				current.prev = insert;
				_size++; 
				return true; 
			}
		}


	}

	@Override
	public boolean remove(int index) {
		
		if(index < 0 || this.size() == 0 || index >= this.size()){
			return false; 
		}
		
		Node holder = sentinel.next; 
		for (int i = 0; i < index; i++){
			holder = holder.next; 
		}
		
		Node c1 = holder.prev;
		Node c2 = holder.next; 
		
		
		
		holder.next.prev = c1; 
		holder.prev.next = c2;
		
		_size--; 
		
		return true; 
	}


	@Override
	public double get(int index) {
		
		if (index < 0 || index >= this.size() || this.size() == 0){
			return Double.NaN; 
		}else{
			Node holder = this.trasverse(index); 
			return(holder.data);
		}
		
	}

	@Override
	public int size() {
		return _size;
	}

	@Override
	public boolean isEmpty() {
		if(_size == 0){
			return true; 
		}else{
			return false; 
		}
	}

	@Override
	public void clear() {
 		sentinel.next = sentinel; 
		sentinel.prev = sentinel;
		_size = 0;  
	}
	
	public Node trasverse(int index){
		Node holder = sentinel.next; 
		for(int i = 0; i <= index-1 && holder != null;i++){ 
			holder = holder.next; 
		}
		return holder; 
	}
	

}