class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}


class BinarySearchTree{

   Node root;
   
   /*
    * inserts a node into the tree
    */
   public void insert(int value) {
	   // tree is empty
	   if (root == null) {
		   root = new Node(value);
		   return;
	   } else {
		   Node current = root;
		   Node parent = null;

		   while (true) {
			   parent = current;

			   if (value < current.value) {
				   current = current.left;
				   if (current == null) {
					   parent.left = new Node(value);
					   return;
				   }
			   } else {
				   current = current.right;
				   if (current == null) {
					   parent.right = new Node(value);
					   return;
				   }
			   }

		   } // closing while

	   } // closing main if-else
   }
   
  /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
    * A simple recursive method to print BST in pre-order.
    * @param root Starting node.
    */
   public void preOrderTraversal(Node root){
      if(root != null) {
    	  System.out.print(root.value + " ");
    	  preOrderTraversal(root.left);
    	  preOrderTraversal(root.right);
      }
   }

   
   
   /**
    * A simple recursive method to print BST in-order.
    * @param root Starting node.
    */
   public void inOrderTraversal(Node root){
	   if(root != null) {
	    	  preOrderTraversal(root.left);
	    	  System.out.print(root.value + " ");
	    	  preOrderTraversal(root.right);
	   }
   }
   
   
   
   /**
    * A simple recursive method to print BST in post-order.
    * @param root Starting node.
    */
   public void postOrderTraversal(Node root){
	   if(root != null) {
	    	  preOrderTraversal(root.left);
	    	  preOrderTraversal(root.right);
	    	  System.out.print(root.value + " ");
	   }
   }
   
   /**
    * A method to find the node in the tree
    * with a specific value.
    * @param root Starting node.
    * @param key Value to search for.
    * @return True if value is in tree. False if value is not found.
    */
   public boolean find(Node root, int key){
	   
	  if(root == null) return false;
	  if(root.value == key) return true;
	  
	  if(key < root.value) {
		  find(root.left, key);
	  }else {
		  find(root.right, key);
	  }
      return false;           
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
	   return 0;
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
	   return 0;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      //Displays preOrderTraversal function.
      System.out.print("pre-order :   ");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      //Displays inOrderTraversal function.
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
      
      //Displays postOrderTraversal function.
      System.out.print("post-order :   ");
      t1.postOrderTraversal(t1.root);
      System.out.println();
      
      //Displays find function.
      System.out.println("\n8 exists in tree :   "+t1.find(t1.root, 8));
      System.out.println("24 exists in tree :   "+t1.find(t1.root, 24));
      t1.find(null, 24);
      
   }


}