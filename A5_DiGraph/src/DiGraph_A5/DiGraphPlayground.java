package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
    exTest();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
     

      
      d.addNode(1, "me");
      d.addNode(2, "wealth");
      d.addNode(3, "power");
//      d.addNode(4, "protection");
//      d.addNode(5, "altruism");
      
      
//      d.addNode(0, "fo");
////      d.addNode(4, "fi");
//      d.addNode(6, "si");
//      d.addEdge(0, "f", "s", 0, null);
//      d.addEdge(1, "me", "protection", 0, null);
//      d.addEdge(2, "me", "altruism", 0, null);
//      
//      d.addEdge(3, "protection", "power", 0, null);
//      d.addEdge(4, "power", "altruism", 0, null);
//      
//      d.addEdge(5, "altruism", "wealth", 0, null);
//      d.addEdge(6, "wealth", "protection", 0, null);
//      
//      d.addEdge(7, "me", "power", 0, null);
//      d.addEdge(8, "power", "me", 0, null);
//      d.delEdge("power", "me");
//      d.addEdge(8, "power", "wealth", 0, null);
      
      d.addEdge(6, "me", "wealth", 0, "Dd");
      d.addEdge(8, "me", "me", 0, "Dd");
      d.addEdge(9, "wealth", "wealth", 0, "Dd");
      d.addEdge(1, "wealth", "me", 0, "Dd");
      
      d.addEdge(2, "me", "power", 0, "Dd");
      d.addEdge(3, "power", "me", 0, "Dd");
      d.addEdge(4, "power", "wealth", 0, "Dd");
      d.addEdge(5, "wealth", "power", 0, "Dd");
      d.delEdge("me", "wealth");
      d.delNode("me");
      d.addNode(1, "me");
      
      
//      d.delEdge("power", "me");
//      d.delEdge("me", "power");
//      d.delEdge("power", "me");
//      d.delNode("me");
//      d.delNode("fi");
//      d.addEdge(3, "if", "fi", 0, "JK");
//      d.addEdge(8, "if", "fo", 0, "jk");
//      d.addEdge(4, "fi", "si", 0, null);
//      d.addNode(1, "p");
//      d.addNode(4, "a");
//      d.addNode(3, "g");
//      d.addNode(2, "e");
//      d.addEdge(0, "p", "a", 0, null);
//      d.addEdge(1, "a", "g", 0, null);
//      d.addEdge(2, "g", "e", 0, null);
//      d.addEdge(3, "e", "p", 0, null);
      //String[] jarajar = d.topoSort();
      
      
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
      for(int i = 0; i <= d.numEdges(); i++) {
    	  
      }
      printTOPO(d.topoSort());
      
    }
    public static void printTOPO(String[] toPrint){
      System.out.print("TOPO Sort: ");
      for (String string : toPrint) {
      System.out.print(string+" ");
    }
      System.out.println();
    }

}