package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node parent;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){
	  return data;
	  }
  
  public BST_Node getLeft(){ 
	  return left; 
	  }
  
  public BST_Node getRight(){ 
	  return right;
	  }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s, BST_Node root){ 
	  if(root == null){
		  return false;
	  }else{
		  int comparator = s.compareTo(root.data); 
		  if(comparator == 0){
			  return true; 
		  }else if(comparator > 0 ){
			  root = root.right; 
			  return containsNode(s,root); 
		  }else{
			  root = root.left; 
			  return containsNode(s,root);
		  }

	  }

  }

  public boolean insertNode(String s, BST_Node node){ 

	  BST_Node holder = new BST_Node(s); 

	  int comparator = s.compareTo(node.data);

	  if(comparator == 0){
		  return false;
	  }else if(comparator > 0){
		  if(node.right == null){
			  
			  node.right = holder;
			  holder.parent = node;
			  return true;
		  }else{
			  return this.insertNode(s, node.right); 
		  } 
	  }else{
		  if(node.left == null){
			   
			  node.left = holder;
			  holder.parent = node;
			  return true;
		  }else{
			  return this.insertNode(s, node.left); 
		  }
	  }
  }

  public boolean removeNode(String s){  

	  int comparator  = s.compareTo(data);

	  if(comparator > 0){
		  if(right == null){
			  return false; 
		  }else{
			  return right.removeNode(s);
		  }
	  }else if(comparator < 0){
		  if(left == null){
			  return false;
		  }else{	
			  return left.removeNode(s);
		  }
	  }else{
		  if(right == null && left == null){ // removes leaf 
			  int decider = data.compareTo(parent.data); 
			  if(decider < 0){
				  parent.left = null; 
				  return true;
			  }else{
				  parent.right = null;
				  return true;
			  }
		  }else if(right != null && left != null){ //removes if two children
			  data = findMin(right).data; 
			  return right.removeNode(data);
		  }else{ //remove one child
			  if(left == null){
				  data = findMin(right).data; 
				  return right.removeNode(data); 
			  }else{
				  int decider = data.compareTo(parent.data); 
				  if(decider < 0){
					  parent.left = left; 
					  return true; 
				  }else{
					  parent.right = left; 
					  return true; 
				  }
			  }
		  }
	  }
	  
  }
 

  public BST_Node findMin(BST_Node root){
	  
	  if(root != null){
		  while(root.left != null){
			  root = root.left; 
		  }
	  }
	  
	  return root;
  }
  
  public BST_Node findMax(BST_Node root){
	  if(root != null){
		  while(root.right != null){
			  root = root.right; 
		  }
	  }
	  return root;
  }


  public int getHeight(BST_Node root){
	  if(root == null){
		  return -1; 
	  }else{
		  return 1+ Math.max(getHeight(root.left), getHeight(root.right));
	  }




  }
  

  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
