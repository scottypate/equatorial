import scala.collection.mutable.ListMap

class Blender() {

  def execute(
    offspring: scala.collection.mutable.Map[Map[Char, String], Double], 
    parents: scala.collection.mutable.Map[Map[Char, String], Double]) = {

    val orderedParents = parents.toSeq.sortWith(_._2 < _._2)
    val orderedOffspring = offspring.toSeq.sortWith(_._2 < _._2)

    val parentSize = orderedParents.size

    var blendedGeneration = ListMap((orderedParents.take(parentSize / 2) ++ orderedOffspring.take(parentSize / 2)):_*)
    
    blendedGeneration
  }
}