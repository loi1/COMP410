package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; //load this array
	private int size;
	private static final int arraySize = 10000; //Everything in the array will initially 
	//be null. This is ok! Just build out 
	//from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
		//of child/parent computations...
		//the book/animation page both do this.
		size = 0; 
	}

	//Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() { 
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		
		if(size == 0){
			array[1] = entry; 
			size++; 
		}else{
			array[size+1] = entry; 
			this.bubbleup(size+1);
			size++; 
		}
	}
	
	public void bubbleup(int index){
		if(index == 1 && size != 0){
			return; 
		}else{
			if( array[index/2] != null && array[index].getPriority() < array[index/2].getPriority()){
				EntryPair temp = array[index/2]; 
				array[index/2] = array[index]; 
				array[index] = temp; 
				this.bubbleup(index/2);
			}
		}
	}
	
	@Override
	public void delMin() {
		if(size == 0 || size < 0){
			return; 
		}else{ 
			array[ 1 ] = array[size--];
			bubbleDown(1);
			
		}	
		
	}
	
	public void bubbleDown(int index){	
		if(index*2 <= size && index != 0){
			if(array[index*2] != null && array[index*2+1] != null){
				if(array[index*2].getPriority() < array[index*2+1].getPriority()){
					if(array[index*2].getPriority() < array[index].getPriority()){
						EntryPair temp = array[index*2]; 
						array[index*2] = array[index]; 
						array[index] = temp; 
						bubbleDown(index*2);
					}
				}else{
					if(array[index*2+1].getPriority() < array[index].getPriority()){
						EntryPair temp = array[index*2+1]; 
						array[index*2+1] = array[index]; 
						array[index] = temp; 
						bubbleDown(index*2+1); 
					}
				}
			}else if(array[index*2] != null && array[index*2+1] == null){
				if(array[index*2].getPriority() < array[index].getPriority()){
					EntryPair temp = array[index*2]; 
					array[index*2] = array[index]; 
					array[index] = temp; 
					bubbleDown(index*2);
				}
			}else{
				return;
			}
		}
	}		
		
	@Override
	public EntryPair getMin(){
		if(size == 0){
			return null; 
		}else{
			return array[1];
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		for(int i = 0; i < entries.length; i++){
			array[i+1] = entries[i]; 
		}
		
		size = entries.length; 
		for(int i = size/2; i > 0; i--){
			bubbleDown(i);
		}
	}

}	