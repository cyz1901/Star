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

  var root = {
      LeafNode[A](ArrayBuffer[Entry[A]](null),None)
  }


  def AddData(data: A): Unit ={
    if (root.array == null){
      root.array.addOne(Entry[A](index,data))
    }else{

    }

  }


  def binarySearch(): Unit ={

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
