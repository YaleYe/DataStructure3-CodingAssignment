import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Family {
  
  public ArrayList<Vertex> vertices;
  HashMap<String,Vertex> st;
  int count;
  

  
  private class Vertex {
    String name;
    boolean visited;
    int dfs, low;
    ArrayList<Vertex> neighbors;
    
    public Vertex(String name) {
      vertices.add(this);
      this.name = name;
      dfs = low = -1;
      visited = false;
      neighbors = new ArrayList<Vertex>();
    }
    
    public String toString() { return name; }
    
    public void addNeighbor(Vertex v) {
      neighbors.add(v);
    }
  }
  public void findSP(Vertex s) {
    Family pq = new Family();
    //s.setPriority(0);
    visit(s, 0, pq);
    while(!pq.isEmpty()) {
      Vertex v = pq.delMin(); 
      int d = v.getPriority(); 
      v.markNotInFringe();
      visit(v, d, pq);
    }
  }
  
  private void visit(Vertex v, int d, IndexedMinPQ<Vertex> pq) {
    v.mark();
    for(Edge e : v.getNeighbors()) { // Edge is pair (v, w).
      Vertex x = e.v;
      if(x.isMarked())
        continue;
      if(!x.isInFringe()) {
        x.setPriority(d + e.w);
        pq.insert(x);
        x.parent = v;
        x.markInFringe();
      }
      else if(x.getPriority() > d + e.w) {
        x.setPriority(d + e.w);
        pq.change(x);
            x.parent = v;
          }
    }}
    
    
    public Family() {
      vertices = new ArrayList<Vertex>();
      st = new HashMap<>();
      count = 0;
    }
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Family graph = new Family();
      while(sc.hasNextLine()) {
        String[] fields = sc.nextLine().split(",");
        Vertex x = graph.findVertex(fields[0]);
        Vertex y = graph.findVertex(fields[1]);
        x.addNeighbor(y);
        y.addNeighbor(x);
      }
          for(Vertex v : graph.vertices)
            if(!v.visited)
            graph.visit(v, null);
          
        }
        
    Vertex findVertex(String name) {
      Vertex v = st.get(name);
      if(v == null)
        st.put(name, v=new Vertex(name));
      return v;
    }
    
    void visit(Vertex x, Vertex p) {
      x.visited = true;
      x.dfs = x.low = count++;
      for(Vertex v : x.neighbors) {
        if (!v.visited)
          visit(v, x);
        if(v != p && v.low < x.low)
          x.low = v.low;
      }
      if(p != null && x.low == x.dfs)
        System.out.println("(" + p + "," + x + ")");
    }
    
}