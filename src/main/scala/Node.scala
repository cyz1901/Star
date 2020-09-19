trait Node[A] {
  val m: Int
  val h: Int
  val array: Array[Entry[A]]
  val next: Option[Node[A]]


}

case class RootNode[A](
                        override val h: Int,
                        override val array: Array[Entry[A]],
                        override val next: Option[Node[A]]
                      )extends Node[A]{
  override val m: Int = array.length

}

case class LeafNode[A](
                        override val h: Int,
                        override val array: Array[Entry[A]],
                        override val next: Option[Node[A]]
                      )extends Node[A]{
  override val m: Int = array.length
}

case class Entry[A](key: Int,value: A)

