package BST_A2;

public class BST implements BST_Interface {
	public BST_Node root;
	int size;

	public BST(){ 
		size=0; 
		root=null; 
	}

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){ return root; }

	@Override
	public boolean insert(String s) {

		if(root == null){
			root = new BST_Node(s);
			size++; 	
			return true;
		}else{
			if(root.insertNode(s, root)){
				size++; 
				return true;
			}else{
				return false;
			}
			
		}

	}

	@Override
	public boolean remove(String s) {
		if (root == null || size == 0)
            return false;
		
		
		if(root.data.compareTo(s) == 0){
			if(size==1){
				root = null;
				size--; 
				return true; 
			}
			if(root.right == null && root.left == null){
				root = null; 
				size--; 
				return true; 
			}else if(root.right != null && root.left != null){
				BST_Node temp = root.right; 
				BST_Node haha = root.left; 
				root = temp; 
				root.right = haha; 
				root.left = null;
				size--; 
				return true; 
			}else{
				if(root.left == null){
					root = root.right; 
					size--; 
					return true; 
				}else{
					root = root.left; 
					size--;
					return true; 
				}
			}
		}else{
			size--; 
			return root.removeNode(s);
		}
	}
	

	@Override
	public String findMin() {
		if(root == null || size == 0){
			return null; 
		}else if(root != null && root.right == null && root.left == null){
			return root.data; 
		}else{
			return root.findMin(root).data; 
		}
	}

	@Override
	public String findMax() {
		if(root == null || size == 0){
			return null; 
		}else if(root != null && root.right == null && root.left == null){
			return root.data; 
		}else{
			return root.findMax(root).data; 
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
			return root.containsNode(s,root);
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
			return root.getHeight(root); 
		}
	}

}