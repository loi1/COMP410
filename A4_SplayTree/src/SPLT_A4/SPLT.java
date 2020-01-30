package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;
  
  public SPLT() {
    this.size = 0;
  } 
  
  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }

@Override
public void insert(String s) {
	if(root == null){
		root = new BST_Node(s);
		size++;
		root.justMade=false;
	}else{
		if(s.compareTo(root.data) != 0){
			BST_Node temp = root.insertNode(s);
			Splay(temp); 
			root = temp;
			if(root.justMade){
				size++; 
				root.justMade=false;
			}
		}else{
			return;
		}
	}
}

@Override
public void remove(String s) {
	
	boolean contains = this.contains(s); 
	
	if(size == 0){
		return; 
	}
	if(contains){
		BST_Node L = root.left;
		BST_Node R = root.right; 
		
		if(size == 1){
			root = null; 
			size--; 
		}else if(L != null && R != null){
			
			root = null; 
			L.parent = null; 
			R.parent = null; 
			size--; 
			root=L;
			findMax(); 
			
			root.right = R; 
			R.parent = root; 
			
		}else{
			if(R == null){
				root = root.left; 
				root.parent = null;
				size--; 
			}else{
				root = root.right; 
				root.parent = null; 
				size--; 
			}
		}
	}else{
		return; 
	}
	
}

@Override
public String findMin() {
	if(root == null || size == 0){
		return null; 
	}else if(root != null && root.right == null && root.left == null){
		return root.data; 
	}else{
		BST_Node toSplay = root.findMin(); 
		Splay(toSplay); 
		root = toSplay; 
		return root.data; 
	}
}

@Override
public String findMax() {
	if(root == null || size == 0){
		return null; 
	}else if(root != null && root.right == null && root.left == null){
		return root.data; 
	}else{
		BST_Node toSplay = root.findMax(); 
		Splay(toSplay); 
		root = toSplay; 
		return root.data;
	}
}

@Override
public boolean empty() {
	if(size == 0){
		return true;
	}else{
		return false;
	}
}

@Override
public boolean contains(String s) {
	if(size == 0 || root == null){
		return false; 
	}else{
		BST_Node toSplay = root.containsNode(s); 
		Splay(toSplay); 
		root = toSplay;
		
		if(s.compareTo(toSplay.data) == 0){
			return true; 
		}else{
			return false; 
		}
	} 
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public int height() {
	if(size == 0 && root == null || root == null){ 
		return -1; 
	}else{
		return root.getHeight(); 
	}
}  

private static void Splay(BST_Node SNode){
	if(SNode.parent == null){
		return;  //basecase
	}else{
		//R & L case (if no grandparent exists) 
		if(SNode.parent.parent == null && SNode.parent != null){

			    BST_Node RParent = SNode.parent; 
//			
//			
			if(SNode.data.compareTo(RParent.data) < 0){
				RParent.left = SNode.right; 
				if(SNode.right != null){
					SNode.right.parent = RParent; 
				}
				RParent.parent = SNode; 
				SNode.right = RParent; 
				SNode.parent = null;
				return; 
			}else{
				RParent.right = SNode.left; 
				if(SNode.left != null){
					SNode.left.parent = RParent; 
				}
				RParent.parent = SNode; 
				SNode.left = RParent; 
				SNode.parent = null;
				return; 
			}
			 
			

		// LL RR LR RL case	(If Grand parent exists)
		}else if(SNode.parent.parent != null && SNode.parent != null){
			BST_Node RParent = SNode.parent; 
			BST_Node grandparent = SNode.parent.parent; 

			//RR CASE (Left Left Rotation)
			if(SNode.data.compareTo(RParent.data) > 0 && RParent.data.compareTo(grandparent.data) > 0){
				if(SNode.left != null){
					SNode.left.parent = RParent; 
				}

				if(RParent.left != null){
					RParent.left.parent = grandparent; 
				}

				if(SNode.parent.parent == null){
					SNode.parent = null; 
				}else{
					SNode.parent = grandparent.parent; 
				}

				grandparent.parent = RParent; 
				RParent.parent = SNode; 
				grandparent.right = RParent.left; 
				RParent.left = grandparent; 
				RParent.right = SNode.left; 
				SNode.left = RParent; 
				Splay(SNode); 


				//LL CASE (Right Right Rotation) 	
			}else if (SNode.data.compareTo(RParent.data) < 0 && RParent.data.compareTo(grandparent.data) < 0){
				if(SNode.right != null){
					SNode.right.parent = RParent; 
				}

				if(RParent.right != null){
					RParent.right.parent = grandparent; 
				}


				if(SNode.parent.parent == null){
					SNode.parent = null; 
				}else{
					SNode.parent = grandparent.parent; 
				}
				grandparent.parent = RParent; 
				RParent.parent = SNode; 
				grandparent.left = RParent.right; 
				RParent.right = grandparent; 
				RParent.left = SNode.right; 
				SNode.right = RParent; 

				Splay(SNode); 



				//RL CASE (Left Right Rotation)
			}else if(SNode.data.compareTo(RParent.data) < 0 && RParent.data.compareTo(grandparent.data) > 0){
				if(SNode.left != null){ 
					SNode.left.parent = grandparent; 
				}

				if(SNode.right != null){
					SNode.right.parent = RParent; 
				}

				if(SNode.parent.parent == null){
					SNode.parent = null; 
				}else{
					SNode.parent = grandparent.parent; 
				}

				grandparent.parent = SNode; 
				RParent.parent = SNode; 
				grandparent.right = SNode.left; 
				RParent.left = SNode.right; 
				SNode.right = RParent; 
				SNode.left = grandparent; 

				Splay(SNode); 

				//LR CASE (Right Left Rotation	
			}else{
				if(SNode.left != null){ 
					SNode.left.parent = RParent; 
				}

				if(SNode.right != null){
					SNode.right.parent = grandparent; 
				}

				if(SNode.parent.parent == null){
					SNode.parent = null; 
				}else{
					SNode.parent = grandparent.parent; 
				}

				grandparent.parent = SNode; 
				RParent.parent = SNode; 
				grandparent.left = SNode.right; 
				RParent.right = SNode.left; 
				SNode.left = RParent; 
				SNode.right = grandparent; 

				Splay(SNode); 
			}
		}else{
			System.out.println("You failed at life");
		}
	}
}
}