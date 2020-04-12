import java.util.Iterator;
import java.util.NoSuchElementException;

public class LL<T> {
  
  private class Item {
    T val;
    Item next;
    public Item(T val, Item next) {
      this.val = val; this.next = next;
    }
  }
  
  private Item head;
  
  public LL() { head = null; }
  
  private String toString(Item head) {
    if(head == null) return "";
    if(head.next == null) return head.val + "";
    return head.val + "," + toString(head.next);
  }
  
  public String toString() {
    return "(" + toString(head) + ")";
  }
  
  public void add(T x) { head = new Item(x, head); }
  
  public int length(Item head) { // Add this method.
    if(head == null)
      return 0;
    return 1+ length(head.next);
    }
  
  public int length(){
    return length(head);
    }
  
  private class ListIterator implements Iterator<T> {
    
    private Item current;
    
    public ListIterator(Item head) { current = head; }
    
    public boolean hasNext() { return current != null; }
    
    public void remove() { throw new UnsupportedOperationException();  }
    
    public T next() {
      if(!hasNext()) throw new NoSuchElementException();
      T val = current.val;
      current = current.next;
      return val;
    } 
  }
  
  public Iterator<T> iterator() {
    return new ListIterator(head); 
  }
}
