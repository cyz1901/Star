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
      val lf :Node=  LeafNode[A](
          ArrayBuffer(Entry[A](tree_index,data)),
          None
        )

      root = RootNode[T](
        ArrayBuffer(Entry[LeafNode[A]](1,lf.asInstanceOf[LeafNode[A]])),
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
    a.add_data("world")
    a.add_data("my")
    a.add_data("name")
    a.add_data("is")
    a.add_data("yizhou")
    println(a.root)
    a.serializable()
  }
}
