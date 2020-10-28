package tree

import tree.TypeEnum.TypeEnum

import scala.collection.mutable.ArrayBuffer




case class Node(
                        var array: ArrayBuffer[Entry[Any]],
                        var next: Option[Node]
                      ){

}



case class Entry[+A](key: Int,value: A)




