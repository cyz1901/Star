package tree

import scala.collection.mutable.ArrayBuffer

trait Node[A] {
  var array:ArrayBuffer[Entry[A]]
  var m: Int
  val next: Option[Node[A]]



}

case class RootNode[A<:Node[T],T](
                        var array: ArrayBuffer[Entry[A]],
                        override val next: Option[Node[A]]
                      )extends Node[A]{
  override var m: Int = if (array==null) 0 else array.length

/*  def this(array: Array[tree.Entry[A]],next: Option[tree.Node[A]]){
    this(array,next)
  }*/

}

case class LeafNode[A](
                        var array: ArrayBuffer[Entry[A]],
                        override val next: Option[Node[A]]
                      )extends Node[A]{
  override var m: Int = if (array==null) 0 else array.length


}

case class Entry[+A](key: Int,value: A)

