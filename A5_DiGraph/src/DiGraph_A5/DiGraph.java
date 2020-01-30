package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;



import java.util.LinkedList;



public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
  // and the topo sort operation
	
	
  //For Nodes
  HashSet<Long> idSet;
  HashMap<String, Node> nodeMap;
  
  
  //for Edges
  HashMap<Long, Edge> edgeMap; 
  HashSet<Long> edgeIds;
  HashMap<String, Edge>totalEdgeMap; 
  
  
  //Counters for edges and nodes
  long numberNodes; 
  long numberEdges; 


 public DiGraph ( ) { // default constructor
	  
	 //ids for edges and vertiecs
	 idSet = new HashSet<Long>(); 
	 edgeIds = new HashSet<Long>();
	 
	 // Where edges and Nodes are stored
	 nodeMap = new HashMap<String, Node>();
	 edgeMap = new HashMap<Long, Edge>();
	 
	 //to see if an edge exists between two nodes
	 totalEdgeMap = new HashMap<String, Edge>(); 
	 
	 //counter for edges
	 numberNodes = 0; 
	 numberEdges = 0; 
	 
  }

@Override
public boolean addNode(long idNum, String label) {
	if(idNum < 0 || idSet.contains(idNum)) { // if id is less than 0 or is not unique; return: false
		return false; 
	}else if(label == null || nodeMap.containsKey(label)) { //if Label is null or key is not unique; return false; 
		return false;
	}else{
		Node newNode = new Node(idNum, label); // new Node 
		nodeMap.put(label, newNode); //puts Node in Map (Label as Key) 
		idSet.add(idNum); //add id to set; 
		numberNodes++; // increment node number 
		return true;
	}
}
		

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	
	Node sourceNode = nodeMap.get(sLabel);  //sourceNode
	Node destinationNode = nodeMap.get(dLabel); //destination Node
	
	
	
	if(idNum < 0 || edgeIds.contains(idNum)) { //if id is less than 0 is not unique; Return False; 
		return false; 
	}else if(nodeMap.get(sLabel) == null){ //if sourceNode DNE; return false
		return false; 
	}else if(nodeMap.get(dLabel) == null){ //if destinationNode DNE; return false; 
		return false; 
	}else if(totalEdgeMap.containsKey(sLabel + dLabel) ) { // if the two nodes are already connected   // add inverted lables with || to break 2 node interconnection
		return false; 
	}else {
		Edge newEdge = new Edge(idNum, destinationNode, sourceNode, weight, eLabel); //  new edge
		
		edgeMap.put(idNum, newEdge);  // put edge in map
		totalEdgeMap.put(sLabel + dLabel, newEdge); //put edge in checker map
		edgeIds.add(idNum);
		
		sourceNode.setOutEdges(newEdge); //add outedge in source
		destinationNode.setInEdges(newEdge);
		
		sourceNode.addConnectedDestinationNode(dLabel);
		destinationNode.addConnectedSourceNode(sLabel);
		
		
		// add inedge in destination
		destinationNode.inEdgeNum++; 
		numberEdges++; 
		
		return true; 
	}
	
}
@Override
public boolean delNode(String label) {
	
	if(nodeMap.get(label) != null) {
		Node removeNode = nodeMap.get(label); 
		
		if(removeNode.inEdgeMap.size() > 0) {
			for(Edge edges: removeNode.inEdgeMap.keySet()) {
				Node source = nodeMap.get(edges.get_source().get_lable());
				delEdge(source.get_lable(), label); 
			}
			
		}
		
		if(removeNode.outEdgeMap.size() > 0) {
			for (Edge edges: removeNode.outEdgeMap.keySet()) {
				Node destination = nodeMap.get(edges.get_destination().get_lable());
				delEdge(label, destination.get_lable());
			}
		}
		
		removeNode.inEdgeNum = 0; 
		removeNode.outEdgeMap.clear(); 
		removeNode.inEdgeMap.clear();
		nodeMap.remove(label); 
	    idSet.remove(removeNode.get_id()); 
	    numberNodes--; 
		return true; 
	}else {
		return false; 
	}


}
@Override
public boolean delEdge(String sLabel, String dLabel) {
	
	if(totalEdgeMap.containsKey(sLabel + dLabel)) {  //check if edge is in checker map
		Edge newEdge = totalEdgeMap.get(sLabel + dLabel); //get edge
		
		long id = newEdge.get_idNum(); //get edge id
	
		nodeMap.get(sLabel).outEdgeMap.remove(newEdge); //remove edge from outedge set of source
		nodeMap.get(dLabel).inEdgeMap.remove(newEdge); 
		
		nodeMap.get(sLabel).connectedDestinationNodes.remove(dLabel);
		nodeMap.get(dLabel).connectedSourceNodes.remove(sLabel);
		
		nodeMap.get(dLabel).inEdgeNum--;
		
		edgeMap.remove(id); 
		totalEdgeMap.remove(sLabel + dLabel); 
		edgeIds.remove(id); 
		numberEdges--;
		return true; 
	}else {
		return false; 
	}
}

@Override
public long numNodes() {
	return numberNodes;
}

@Override
public long numEdges() {
	// TODO Auto-generated method stub
	return numberEdges;
}

@Override
public String[] topoSort() {
	Queue<String> q = new LinkedList<String>();
	String[] topo = new String[nodeMap.size()];

	for(String k: nodeMap.keySet()) {
		if(nodeMap.get(k).inEdgeNum == 0) {
			q.add(k); 
		}
	}
	
	int counter = 0; 
	
	while(!q.isEmpty()){
		topo[counter] = q.poll(); 
		
		for(String n: nodeMap.get(topo[counter]).connectedDestinationNodes) {
			nodeMap.get(n).inEdgeNum--;
			
			if(nodeMap.get(n).inEdgeNum == 0) {
				q.add(n);
				//delNode(n);
			}
			
			
		}
		counter++; 
	}
	
	if( counter != nodeMap.size()) {
		return null; 
	}else {
		return topo; 
	}

}

}