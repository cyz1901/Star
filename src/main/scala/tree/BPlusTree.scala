package tree

import java.io.{File, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

class BPlusTree[A,T<:Node](

                       ) {
  //var root: RootNode[T] = RootNode[T](null,None)
  var h: Int = 0 //树的深度
  var tree_index = 0
  var index = 0
  val M = 3
  var root: RootNode[T] = {
      val child_r :Node =  LeafNode[A](
        ArrayBuffer(null),
        None
      )
      val child_l :Node =  LeafNode[A](
        ArrayBuffer(null),
        Some(child_r)
      )
      root = RootNode[T](
        ArrayBuffer(Entry[Node](tree_index,child_l),Entry[Node](tree_index,child_r)),
        Some(child_l)
      )
      tree_index += 1
      root
  }



  def add_data(data: A): Unit ={
    root.array.addOne(Entry[A](index,data))
  }
  def serializable(): Unit ={
    val f = new File("hello.txt")
    val out = new ObjectOutputStream(new FileOutputStream(f))
    out.writeObject(root)
    out.close()
  }

}

object BPlusTree{

}




object test{
  def main(args: Array[String]): Unit = {
    val a = new BPlusTree[String,Node]
    println(a)
  }
}
