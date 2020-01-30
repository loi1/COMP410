package DiGraph_A5;

public class Edge {
	
	private Node _destination; 
	private Node _source; 
	
	private long _idNum; 
	private long _weight; 
	
	private String _current; 
	
	
	public Edge(long idNum, Node destination, Node source, long weight, String current) {
		
		_destination = destination; 
		_source = source; 
		_idNum = idNum; 
		_weight = weight; 	
		_current = current; 
		
	}


	public Node get_destination() {
		return _destination;
	}


	public void set_destination(Node _destination) {
		this._destination = _destination;
	}


	public Node get_source() {
		return _source;
	}


	public void set_source(Node _source) {
		this._source = _source;
	}


	public long get_idNum() {
		return _idNum;
	}


	public void set_idNum(long _idNum) {
		this._idNum = _idNum;
	}


	public long get_weight() {
		return _weight;
	}


	public void set_weight(long _weight) {
		this._weight = _weight;
	}


	public String get_current() {
		return _current;
	}


	public void set_current(String _current) {
		this._current = _current;
	}

}
