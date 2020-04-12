class TreapNode<K1 extends Comparable<K1>,K2 extends Comparable<K2>> {
  //K1 for the BST, K2 for the Heap
  TreapNode<K1,K2> left,right;
  K1 k1;
  K2 k2;
  int value;
  
  public TreapNode(K1 k1,K2 k2){
    this.k1 = k1;
    this.k2 = k2;}
  
  public TreapNode(K1 k1,K2 k2,TreapNode left,TreapNode right){
    this.k1 = k1;
    this.k2 = k2;
    this.left = left;
    this.right = right;}

  public String toString(){
    return "K1:" +k1+", "+"K2:"+k2 ;}}
  

public class Treap<K1 extends Comparable<K1>,K2 extends Comparable<K2>>{
  TreapNode<K1,K2> root;
  

  
  public class Pair<K1 extends Comparable<K1>,K2 extends Comparable<K2>>{
   K1 k1;
   K2 k2;
   public Pair(){
    k1 = null;
    k2 = null;}
   public Pair(K1 k1,K2 k2){
     this.k1 = k1;
     this.k2 = k2;
   }
  }
  
 /* private String toString(TreapNode<K1, K2> node) {
    if (node == null) return "";
    else if (node.k1.compareTo(root.k1) == 0) return toString(node.left) + " (ROOT " + node.k1.toString() + "," + node.k2.toString() + " ROOT)" + toString(node.right);
    else return toString(node.left) + " (" + node.k1.toString() + "," + node.k2.toString() + ")" + toString(node.right);
  }
 public String toString(){
   if (root == null) return "null root";
   return toString(root);
 }*/
   private String toString(TreapNode<K1, K2> node, int indent) {
    if(node == null) return "";
    return toString(node.right, indent+2) + String.format("%" + (indent+1) + "s%s\n", " ",  node) + toString(node.left, indent+2);
    }

     public String toString(){
         return toString(root,0);
     }
 
  public void put(K1 key1,K2 key2){
    root = put(root,key1,key2);}
  
  private TreapNode put(TreapNode<K1,K2> node, K1 key1,K2 key2){
  //if the node not exist
    if ( node == null){
      node = new TreapNode(key1,key2);}
    else{
      int cmp = node.k1.compareTo(key1);
      if (cmp < 0){
        
        node.left = put(node.left, key1, key2);
        if (node.left.k2.compareTo(node.k2) > 0)
          node = leftRotate(node);
      }
      else if (cmp > 0){
        
        node.right = put(node.right, key1, key2);
        if (node.right.k2.compareTo(node.k2) > 0)
          node = rightRotate(node);
      }
      else{
        node.k1 = key1;
        node.k2 = key2;
      }
    }
    return node;
}
  public K2 get(K1 k1){
    K2 key2 = get(root,k1);
    return key2;}
    
  private K2 get(TreapNode<K1,K2> node,K1 key1){
    if (node == null) return null;

    //find k1 and return k2
    int cmp = node.k1.compareTo(key1);
    if (cmp < 0)
      return get(node.left,key1);
    else if (cmp > 0)
      return get(node.right,key1);
    else{
      return node.k2;
    }
  }
  
  private TreapNode<K1,K2> rightRotate(TreapNode node){
    TreapNode right = node.right;
    node.right = right.left;
    right.left = node;
    return right;}
  
  private TreapNode<K1,K2> leftRotate(TreapNode node){
    TreapNode left = node.left;
    node.left = left.right;
    left.right = node;
    return left;}
  
  private void sink(TreapNode parent){
    TreapNode<K1,K2> temp= parent;
    K1 k1 = temp.k1;
    K2 k2 = get(temp,k1);
    TreapNode<K1,K2> tempSon = parent.left;
    while(tempSon != null && k2.compareTo(tempSon.k2)<0){
      leftRotate(parent.left);
      TreapNode<K1,K2> children = parent.left;
      sink(parent.left);}}

    
      
        
      
      
  public Pair<K1, K2> removeMax() {
    Pair <K1,K2> maxPair = new Pair<K1,K2>();
    if(root == null){
      maxPair.k1 = null;
      maxPair.k2 = null;
      return maxPair;
    }       else {
      maxPair.k1 = root.k1;
      maxPair.k2 = root.k2;
    }
    
    if(root.right != null){
      root = root.right;}
    root = removeMax(root);
    
    return maxPair;
  }
                    
  private TreapNode<K1, K2> removeMax(TreapNode<K1,K2> node){
    //find and remove the record with the maximum value of key2. Return the pair key1, key2
    //  Pair <K1,K2> maxPair = new Pair<K1,K2>();
    //if root is null
    if(node == null){
      return null;
    }
    //if left is null 
    else if(node.left == null){
     return node.right;
    }
      
    //if right is null
    else if(node.right == null){
      return node.left;
    }
    //if left or right has more nodes
    else{
      TreapNode<K1,K2> parent = null;
      TreapNode<K1,K2> successor = node.right;
      while(successor.left != null){
        if(successor.left.left == null)
          parent = successor.left;
        successor = successor.left;}
      successor.left = put(successor.left, node.k1,node.k2);
      return successor;
    }}
}
  

