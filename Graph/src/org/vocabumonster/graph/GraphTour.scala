package org.vocabumonster.graph
import org.vocabumonster._
object GraphTour {
   def main(args:Array[String]){
    var testGraph=new Graph[String]
    /*
     *  A:  F B E 
    B:  A 
    C:  F G H 
    D:  H 
    E:  F A 
    F:  C G E A 
    G:  F C 
    H:  D C 
     * 
     */
    testGraph.g=Map("A"->List("F","B","E"),"B"->List("A"),"C"->List("F","G","H"),"D"->List("H"),"E"->List("F","A"),"F"->List("C","G","E","A"),
        "G"->List("F","C"),"H"->List("D","C"))
    print(testGraph.depthFirst("A"))
    /*
     *   A:  F 
    B:  F C G 
    C:  B D H G 
    D:  H C 
    E:  F 
    F:  A B E 
    G:  H B C 
    H:  D G C 
     * 
     */
    var bfsGraph = new Graph[String]
    bfsGraph.g=Map("A"->List("F"),"B"->List("F","C","G"),"C"->List("B","D","H","G"),
        "D"->List("H","C"),"E"->List("F"),"F"->List("A","B","E"),"G"->List("H","B","C"),"H"->List("D","G","C"))
    print(bfsGraph.breadthFirst("A"))
    
  }
}