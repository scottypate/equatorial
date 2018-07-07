import scala.collection.mutable.ListMap

class Blender() {

  def execute(
    offspring: scala.collection.mutable.Map[Map[Char, String], Double], 
    parents: scala.collection.mutable.Map[Map[Char, String], Double]) = {

    val orderedParents = ListMap(parents.toSeq.sortWith(_._2 > _._2):_*)
    val orderedOffspring = ListMap(offspring.toSeq.sortWith(_._2 > _._2):_*)

    val parentSize = orderedParents.size

    var blendedGeneration = orderedParents.take(parentSize / 2) ++ orderedOffspring.take(parentSize / 2)
    blendedGeneration
  }
}