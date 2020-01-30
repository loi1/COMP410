package A6_Dijkstra;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;


public class Node implements Comparable<Node>{

	private long _id; 
	private String _lable;
    private int dist; 
	int inEdgeNum; 
	boolean hasBeenVisited; 



	//
	ConcurrentHashMap<String, Edge> inEdgeMap; 
	ConcurrentHashMap<String, Edge> outEdgeMap; 

	//
	HashSet<String> connectedSourceNodes; 
	HashSet<String> connectedDestinationNodes;



	public Node(long id, String lable) {
		_id = id; 
		_lable = lable; 

		inEdgeNum = 0; 

		inEdgeMap = new ConcurrentHashMap<String, Edge>();
		outEdgeMap = new ConcurrentHashMap<String, Edge>(); 

		connectedSourceNodes = new HashSet<String>();
		connectedDestinationNodes = new HashSet<String>();
		hasBeenVisited = false;
		
		dist = Integer.MAX_VALUE;
	}

	public int getDist() {
		return dist; 
	}
	
	public void setDist(int d) {
		dist = d; 
	}

	public void addConnectedDestinationNode(String l) {
		connectedDestinationNodes.add(l);
	}

	public void addConnectedSourceNode(String l) {
		connectedSourceNodes.add(l);
	}


	public void setOutEdges(String d, Edge out) {
		outEdgeMap.put(d , out); 
	}

	public void setInEdges (String d, Edge in) {
		inEdgeMap.put(d, in); 
	}


	public void removeOutEdges(String d) {
		outEdgeMap.remove(d); 
	}

	public void removeInEdges(String d) {
		inEdgeMap.remove(d);
	}


	public long get_id() {
		return _id;
	}

	public String get_lable() {
		return _lable;
	}

	@Override
	public int compareTo(Node compareTo) {
		if(this.dist > compareTo.dist) {
			return 1; 
		}else if (this.dist < compareTo.dist){
			return -1;
		}
		return 0;
	}


}
