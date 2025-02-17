package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node parent;
	boolean justMade;
	
	BST_Node(String data){
		this.data=data;
		this.justMade=true;
	}
	
	public String getData(){
		return data;
	}
	public BST_Node getLeft(){
		return left;
	}
	public BST_Node getRight(){
		return right;
	}
	
	public BST_Node containsNode(String s){ //it was me
		if(data.equals(s))return this;
		if(data.compareTo(s)>0){//s lexiconically less than data
			if(left==null)return this;
			return left.containsNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null)return this;
			return right.containsNode(s);
		}
		return this; //shouldn't hit
	}
	public BST_Node insertNode(String s){
		if(data.compareTo(s)>0){
			if(left==null){
				left=new BST_Node(s);
				left.parent = this; 
				return left;
			}
			return left.insertNode(s);
		}
		if(data.compareTo(s)<0){
			if(right==null){
				right=new BST_Node(s);
				right.parent = this; 
				return right;
			}
			return right.insertNode(s);
		}
		return this;//ie we have a duplicate
	}
	public boolean removeNode(String s){ //DIO
		if(data==null)return false;
		if(data.equals(s)){
			if(left!=null){
				data=left.findMax().data;
				left.removeNode(data);
				if(left.data==null)left=null;
			}
			else if(right!=null){
				data=right.findMin().data;
				right.removeNode(data);
				if(right.data==null)right=null;
			}
			else data=null;
			return true;
		}
		else if(data.compareTo(s)>0){
			if(left==null)return false;
			if(!left.removeNode(s))return false;
			if(left.data==null)left=null;
			return true;
		}
		else if(data.compareTo(s)<0){
			if(right==null)return false;
			if(!right.removeNode(s))return false;
			if(right.data==null)right=null;
			return true;
		}
		return false;
	}
	public BST_Node findMin(){
		if(left!=null)return left.findMin();
		return this;
	}
	public BST_Node findMax(){
		if(right!=null)return right.findMax();
		return this;
	}
	public int getHeight(){
		int l=0;
		int r=0;
		if(left!=null)l+=left.getHeight()+1;
		if(right!=null)r+=right.getHeight()+1;
		return Integer.max(l, r);
	}
	public String toString(){
		return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")+",Right: "+((this.right!=null)?right.data:"null");
	}
	
}
