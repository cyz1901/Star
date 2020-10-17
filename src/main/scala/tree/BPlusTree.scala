package tree

import java.io.{File, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

class BPlusTree[A<:Node[T],T](

                       ) {
  //var root: RootNode[T] = RootNode[T](null,None)
  var h: Int = 0 //树的深度
  var tree_index = 0
  var index = 0
  val M = 3

  var root = {
    RootNode[A,T](ArrayBuffer[Entry[A]](null),None)
  }

  var leaf= {
    LeafNode[T](ArrayBuffer[Entry[T]](null),None).asInstanceOf[A]
  }


  def addData(data: T): Unit ={
    if (root.array.length == 1){
      leaf.array.addOne(Entry[T](index,data))
      root.array.addOne(Entry[A](index,leaf))
      index += 1

    }else{

    }

  }


  def binarySearch(tree: Node[A], index: Int): Unit ={
    //tree.array.
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
    val a = new BPlusTree[Node[String],String]
    a.addData("hello")
    //println(a)
  }
}
