import java.util.Iterator;
public class Person {
  String name;
  LL<Person> siblings;
  LL<Person> children;
  //LL<Person> niblings;
  
  public Person(String name) {
    this.name = name;
    siblings = new LL<Person>();
    children = new LL<Person>();
   // niblings = new LL<Person>();
  }
  
  
  public void addChild(Person b) {
    children.add(b);
    //if (b.siblings != null && b.children != null)
     // siblings.niblings.add(b);
  }
  
  
  public void addSibling(Person b) {
    siblings.add(b);
    b.siblings.add(this);
  }
  
  public int numChildren() {
    return children.length(); 
  }
  
  public int numDescendants(Iterator<Person> temp){
    //Iterator<Person> temp = children.iterator();
    if(temp.hasNext()){
      Person tempPerson = temp.next();
      return (1+tempPerson.numChildren() + numDescendants(temp));}
    return 0;
  }
  
  public int numDescendants(){
    Iterator<Person> temp = children.iterator();
    return numDescendants(temp)+1;}
    

  
  public int numSiblings() {
    return siblings.length();
  }
  
    public int numNiblings(Iterator<Person> temp){
    //Iterator<Person> temp = children.iterator();
    if(temp.hasNext()){
      Person tempPerson = temp.next();
      return (tempPerson.numChildren() + numNiblings(temp));}
    return 0;
  }
 
  public int numNiblings() { // Add this method.
    Iterator<Person> tempNiblings = siblings.iterator();
    if(siblings.length() == 0){
      return 0;}
    return numNiblings(tempNiblings);}
  

  public static void main(String[] args) {
    Person homer = new Person("Homer");
    Person marge = new Person("Marge");
    Person bart = new Person("Bart");
    Person lisa = new Person("Lisa");
    Person maggie = new Person("Maggie");
    Person selma = new Person("Selma");
    Person patty = new Person("Patty");
    Person bartjr = new Person("Bartjr");
    homer.addChild(bart);
    homer.addChild(lisa);
    homer.addChild(maggie);
    marge.addChild(bart);
    marge.addChild(lisa);
    marge.addChild(maggie);
    marge.addSibling(selma);
    marge.addSibling(patty);
    bart.addChild(bartjr);
    System.out.println("Homer has " + homer.numDescendants() + " descendants.");
    System.out.println("Marge has " + marge.numDescendants() + " descendants.");
    System.out.println("Homer has " + homer.numSiblings() + " siblings.");
    System.out.println("Marge has " + marge.numSiblings() + " siblings.");
    System.out.println("Marge has " + marge.numNiblings() + " niblings.");
    System.out.println("Patty has " + patty.numNiblings() + " niblings.");
  }
}
