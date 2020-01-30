package DiGraph_A5;


import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;


public class Node {

	private long _id; 
	private String _lable;

	int inEdgeNum; 



	//
	ConcurrentHashMap<Edge, Edge> inEdgeMap; 
	ConcurrentHashMap<Edge, Edge> outEdgeMap; 

	//
	HashSet<String> connectedSourceNodes; 
	HashSet<String> connectedDestinationNodes;



	public Node(long id, String lable) {
		_id = id; 
		_lable = lable; 

		inEdgeNum = 0; 

		inEdgeMap = new ConcurrentHashMap<Edge, Edge>();
		outEdgeMap = new ConcurrentHashMap<Edge, Edge>(); 

		connectedSourceNodes = new HashSet<String>();
		connectedDestinationNodes = new HashSet<String>();
	}



	public void addConnectedDestinationNode(String l) {
		connectedDestinationNodes.add(l);
	}

	public void addConnectedSourceNode(String l) {
		connectedSourceNodes.add(l);
	}


	public void setOutEdges(Edge out) {
		outEdgeMap.put(out , out); 
	}

	public void setInEdges (Edge in) {
		inEdgeMap.put(in, in); 
	}


	public void removeOutEdges(Edge out) {
		outEdgeMap.remove(out); 
	}

	public void removeInEdges(Edge in) {
		inEdgeMap.remove(in);
	}


	public long get_id() {
		return _id;
	}

	public String get_lable() {
		return _lable;
	}


}
