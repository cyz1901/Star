import scala.collection.mutable.ArrayBuffer

trait Node[A] {
  var m: Int
  //var array: ArrayBuffer[Entry[A]]
  var next: Option[Node[A]]



}

case class RootNode[A](
                        var array: ArrayBuffer[Entry[Int]],
                        override var next: Option[Node[A]]
                      )extends Node[A]{
  override var m: Int = if (array==null) 0 else array.length

/*  def this(array: Array[Entry[A]],next: Option[Node[A]]){
    this(array,next)
  }*/

}

case class LeafNode[A](
                        var array: ArrayBuffer[Entry[A]],
                        override var next: Option[Node[A]]
                      )extends Node[A]{
  override var m: Int = if (array==null) 0 else array.length


}

case class Entry[A](key: Int,value: A)

