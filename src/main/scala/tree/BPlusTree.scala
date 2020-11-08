package tree

import java.io.{File, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer


/*1.根结点至少有两个子女。
2.每个中间节点都包含k-1个元素和k个孩子，其中 m/2 <= k <= m
3.每一个叶子节点都包含k-1个元素，其中 m/2 <= k <= m
4.所有的叶子结点都位于同一层。
5.每个节点中的元素从小到大排列，节点当中k-1个元素正好是k个孩子包含的元素的值域分划*/


class BPlusTree[A]() {
  var h: Int = 0 //树的深度
  var tree_index = 0
  var index = 0
  val M = 5


  var root :Option[Node] = None


  {
    root = Some(Node(array = ArrayBuffer(),None)) /* 初始化根节点 */
  }




  def add(data: A): Unit ={
    root.get.next match {
      case None =>
        root.get.array.length match {
          case n if n >= M/2+1 =>
            root.get.array.addOne(Entry[A](index,data))
            var left = root.get.array.slice(0,M/2+1)
            var right = root.get.array.slice(M/2+1,root.get.array.length)
            var right_node = Node(array = right,None)
            var left_node = Node(array = left,Some(right_node))
            root.get.array = ArrayBuffer(Entry(left_node.array(0).key,left_node),Entry(right_node.array(0).key,right_node))
            root.get.next = Some(left_node)
          case n if n < M/2+1 =>
            root.get.array.addOne(Entry[A](index,data))
            index += 1
        }
      case Some(x) =>
        var leaf = binarySearch(root,index).array.addOne(Entry[A](index,data))
        println(leaf)
    }
//    root match {
//      case None =>
//        root = Some(Node(array = ArrayBuffer(),None))
//        root.get.array.addOne(Entry[A](index,data))
//        index += 1
//      case Some(x) =>
//        root.get.next match {
//          case None =>
//
//          case Some(x) =>
//            var leaf = binarySearch(root,index)
//            leaf.array.length match {
//              case n if n >= M/2+1 =>
//                root.get.array.addOne(Entry[A](index,data))
//                var left = root.get.array.slice(0,M/2+1)
//                var right = root.get.array.slice(M/2+1,root.get.array.length)
//                var right_node = Node(array = right,None)
//                var left_node = Node(array = left,Some(right_node))
//                root.get.array = ArrayBuffer(Entry(left_node.array(0).key,left_node),Entry(right_node.array(0).key,right_node))
//                root.get.next = Some(left_node)
//              case n if n < M/2+1 =>
//                root.get.array.addOne(Entry[A](index,data))
//                index += 1
//            }
//        }
//    }
    }

  def delete()= {

  }

  def update()   ={

  }



  def binarySearch(root: Option[Node], i: Int): Node ={
    if(root.get.array(root.get.array.length/2).key > i) {
      root.get.array.slice(root.get.array.length / 2, root.get.array.length)
      binarySearch(root, i)
    }
    else if(root.get.array(root.get.array.length/2).key < i) {
      root.get.array.slice(0, root.get.array.length / 2)
      binarySearch(root, i)
    }
    else {
      root.get.array(1).value.asInstanceOf[Node]
    }
  }

//  def check_root(node: Node) = {
//    node.array.length match {
//      case n if n >= M/2+1 =>
//        root.get.array.addOne(Entry[A](index,data))
//        var left = root.get.array.slice(0,M/2+1)
//        var right = root.get.array.slice(M/2+1,root.get.array.length)
//        var right_node = Node(array = right,None)
//        var left_node = Node(array = left,Some(right_node))
//        /*            root = Option(Node())*/
//        root.get.array = ArrayBuffer(Entry(left_node.array(0).key,left_node),Entry(right_node.array(0).key,right_node))
//        root.get.next = Some(left_node)
//      case n if n < M/2+1 =>
//        root.get.array.addOne(Entry[A](index,data))
//        index += 1
//    }
//  }


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
    a.add(1)
    a.add(2)
    a.add(3)
    a.add(4)
    a.add(5)
    println(a.root)
  }
}
