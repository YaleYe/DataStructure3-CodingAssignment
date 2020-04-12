import java.util.Scanner;

public class TestTreap{
  public static void main(String[] args){
    Treap<String, Integer> tree = new Treap<String, Integer>();
    Scanner keyboard = new Scanner(System.in);
    
    String name = null;
    Integer score = null;
    while(keyboard.hasNext()) {
      String value = keyboard.next();
      
      if (value.equals("EOF")) break;
      
      if (name== null)
        name = value;
      else if (score == null)
        score = Integer.parseInt(value);
      
      if (name != null && score != null) {
        Integer oldscore = tree.get(name);
        if (oldscore != null)
          score = new Integer(Integer.parseInt(value) + oldscore.intValue());
        
        tree.put(name, score);
        name = null;
        score = null;
        //System.out.println(tree.toString());
      }
    }

    System.out.println(tree.toString());
    System.out.println(tree.removeMax().k1+" has be removed");
    System.out.println(tree.toString());  
    System.out.println(tree.removeMax().k1+" has be removed");
    System.out.println(tree.toString()); 
    System.out.println(tree.removeMax().k1+" has be removed");
    System.out.println(tree.toString()); 
  }
}