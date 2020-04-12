import java.lang.Math;
import java.util.HashMap;
import java.util.Map;

public class PF{
  HashMap<Integer, Integer> map;
  
  public PF(){
    map = new HashMap<Integer, Integer>();
    map.put(1,1);}
  
  public PF(HashMap<Integer, Integer> map){
    this.map = map;}
  
  
  public PF(int n){
    map = new HashMap<Integer, Integer>();
    int twos = 0;
    while (n % 2 == 0){
      twos++;
      n = n / 2;}
    
    //below code is modified from https://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
    if (twos > 0){
      map.put(2, twos);}
    
    for (int i = 3; i <= Math.sqrt(n); i += 2){
      while (n % i == 0) {
        if (map.get(i) == null) {
          map.put(i, 1);}
        else {
          int x = map.get(i) + 1;
          map.put(i, x);}
        n = n / i;}
    }
    if (n > 2) map.put(n, 1);
  }
  
  public HashMap<Integer, Integer> getHashMap(){
    return map;}
  
  public double toDouble(){
    double value = 1.0;
    for (Map.Entry<Integer, Integer> pair : map.entrySet()){
      value = value * Math.pow(pair.getKey(), pair.getValue());}
    return value;}
  
  public PF multiply(PF other){
    HashMap<Integer, Integer> copy = (HashMap<Integer, Integer>)map.clone();
    
    for (Map.Entry<Integer, Integer> pair : other.getHashMap().entrySet()){
      int key = pair.getKey();
      int val = pair.getValue();
      
      if (copy.get(key) != null) {
        //if same key exist, key's exp will be( exp + current) 5^3*5^2 = 5^(3+2)
        copy.put(key, copy.get(key) + val);}
      else
        copy.put(key, val);}
    return new PF(copy);}
  
  public PF divide(PF other){
    HashMap<Integer, Integer> copy = (HashMap<Integer, Integer>)map.clone();
    for (Map.Entry<Integer, Integer> pair : other.getHashMap().entrySet())
    {
      int key = pair.getKey();
      int val = pair.getValue();
      
      if (copy.get(key) != null) {
        //if same key exist, key's exp will be ( exp - current) 5^3/5^2 = 5^(3-2)
        copy.put(key, copy.get(key) - val);}
      else
        copy.put(key, -1 *  val);}
    return new PF(copy);}
  
  public PF exp(int x){
    HashMap<Integer, Integer> copy = (HashMap<Integer, Integer>)map.clone();
    
    for (int i = 1; i < x; i++){
      for (Map.Entry<Integer, Integer> pair : map.entrySet()){
        int key = pair.getKey();
        int val = pair.getValue();
        
        if (copy.get(key) != null) {
          copy.put(key, copy.get(key) + val);}
        else
          copy.put(key, val);
      }}
    
    return new PF(copy);}
  

}

