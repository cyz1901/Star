package tree

import java.io.{File, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer


/*1.根结点至少有两个子女。
2.每个中间节点都包含k-1个元素和k个孩子，其中 m/2 <= k <= m
3.每一个叶子节点都包含k-1个元素，其中 m/2 <= k <= m
4.所有的叶子结点都位于同一层。
5.每个节点中的元素从小到大排列，节点当中k-1个元素正好是k个孩子包含的元素的值域分划*/


class BPlusTree[A](

                       ) {
  //var root: RootNode[T] = RootNode[T](null,None)
  var h: Int = 0 //树的深度
  var tree_index = 0
  var index = 0
  val M = 5


  var root :Option[Node] = None




  def addData(data: A): Unit ={
    root match {
      case None =>
        root = Some(Node(array = ArrayBuffer(),None))
        root.get.array.addOne(Entry[A](1,data))
      case Some(x) =>
        x.array.length match {
          case n if n >= M/2+1 =>
            var left = root.get.array.slice(0,M/2+1)
            var right = root.get.array.slice(M/2+1,root.get.array.length)
            var right_node = Node(array = right,None)
            var left_node = Node(array = left,Some(right_node))
            root.get.array.clear()
            root.get.next = Some(left_node)
          case n if n < M/2+1 =>
            root.get.array.addOne(Entry[A](1,data))
        }
    }
    }

  }
/*

  def binarySearch(tree: RootNode[Node[A]], i: Int): Node[A] ={
    if(tree.array(tree.array.length/2).key > i) {
      tree.array.slice(tree.array.length / 2, tree.array.length)
      binarySearch(tree, i)
    }
    else if(tree.array(tree.array.length/2).key < i) {
      tree.array.slice(0, tree.array.length / 2)
      binarySearch(tree, i)
    }
    else {
      tree.array(0).value
    }
  }


  def serializable(): Unit ={
    val f = new File("hello.txt")
    val out = new ObjectOutputStream(new FileOutputStream(f))
    out.writeObject(root)
    out.close()
  }

}*/

object BPlusTree{

}




object test{
  def main(args: Array[String]): Unit = {
    val a = new BPlusTree[Int]
    a.addData(1)
    a.addData(2)
    a.addData(3)
    a.addData(4)
    println(a.root.get)
  }
}
