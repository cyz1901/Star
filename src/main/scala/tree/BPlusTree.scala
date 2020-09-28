package tree

import java.io.{File, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

class BPlusTree[A,T<:Node](

                       ) {
  var root: RootNode[T] = RootNode[T](null,None)
  var h: Int = 0
  var tree_index = 0

  def add_data(data: A): Unit ={
    if (h == 0 && root.m == 0){
      val lf :Node =  LeafNode[A](
          ArrayBuffer(Entry[A](tree_index,data)),
          None
        )
      println(System.identityHashCode(lf))
      root = RootNode[T](
        ArrayBuffer(Entry[Node](1,lf)),
        Some(lf)
      )
      tree_index += 1
    }
    else {
      val test = root.next.get.asInstanceOf[LeafNode[A]]
      test.array.addOne(Entry[A](tree_index,data))
      tree_index += 1
    }
  }
  def serializable(): Unit ={
    val f = new File("hello.txt")
    val out = new ObjectOutputStream(new FileOutputStream(f))
    out.writeObject(root)
    out.close()
  }

}





object test{
  def main(args: Array[String]): Unit = {
    val a = new BPlusTree[String,Node]

    a.add_data("hello")


    println(a.root)
    println(System.identityHashCode(a.root.next.get))
    println(System.identityHashCode(a.root.array(0).value))

    a.serializable()
  }
}
