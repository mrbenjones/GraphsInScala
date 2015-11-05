package org.vocabumonster.graph

import scala.annotation.tailrec
/**
 * TODO constructor from file in format
 */
class Graph[T] {
  type Vertex = T
  type NeighborMap = Map[Vertex,List[Vertex]]
  var g:NeighborMap = Map()
  /**
   * Breadth first search - from the start node, create a list with each of the node's neighbors. 
   */
  def breadthFirst(start:Vertex):List[List[Vertex]] = {
    
    def breadthFirstInc(currList:List[Vertex],visited:List[List[Vertex]]):List[List[Vertex]]={
      // find unvisisted neighbors of currList
      val eligibleNeighbors= currList.flatMap(g(_)).filter(x=>(!visited.flatten.contains(x))).distinct
      if (eligibleNeighbors.isEmpty){
        visited
      }
      else{
        breadthFirstInc(eligibleNeighbors, eligibleNeighbors::visited)
      }
     
    }
    
    breadthFirstInc(List(start),List(List(start))).reverse
  }
  
  /**
   * Depth first search
   */
  def depthFirst(start:Vertex):List[Vertex] = {
    
    def depthFirstInc(v:Vertex,visited:List[Vertex]):List[Vertex] = {
      if (visited.contains(v))
        visited
      else {  // make a neighborlist of unvisited neighbors
        val adjacent:List[Vertex] = g(v) filter (x=>(!visited.contains(x)))
        // return the concatnation of visited and all of the DFS50 of the unvisisted neighbors
        adjacent.foldLeft(v::visited)((b,a)=>depthFirstInc(a,b))
      }
    }
    depthFirstInc(start,Nil).reverse
  }
}