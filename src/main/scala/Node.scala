import scala.collection.mutable.ArrayBuffer

trait Node[A] {
  var m: Int
  var array: ArrayBuffer[Entry]
  var next: Option[Node[A]]

  def add()

}

case class RootNode[A](
                        override var array: ArrayBuffer[Entry[A]],
                        override var next: Option[Node[A]]
                      )extends Node[A]{
  override var m: Int = array.length

/*  def this(array: Array[Entry[A]],next: Option[Node[A]]){
    this(array,next)
  }*/
  override def add(): Unit = ???
}

case class LeafNode[A](
                        override var array: ArrayBuffer[Entry],
                        override val next: Option[Node[A]]
                      )extends Node[A]{
  override val m: Int = array.length

  override def add(): Unit = ???
}

case class Entry[A](key: Int,value: A)

