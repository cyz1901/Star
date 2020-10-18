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
  val M = 4


  var root = RootNode[Node[A]](ArrayBuffer[Entry[Node[A]]](),None)
  private var leaf = LeafNode[A](ArrayBuffer[Entry[A]](),None).asInstanceOf[Node[A]]




  def addData(data: A): Unit ={
    if (leaf.array == ArrayBuffer()){
      leaf.array.addOne(Entry[A](index,data))
      index += 1
    }else if(leaf.array.length <= M ){
      //TODO 有序插入
      leaf.array.addOne(Entry[A](index,data))
      index += 1
    }else{
     //TODO 分裂
      val left = LeafNode[A](ArrayBuffer[Entry[A]](),None)
      val right = LeafNode[A](ArrayBuffer[Entry[A]](),None)
      for(i <- 0 until M / 2)
        left.array += leaf.array(i)
      for(i <- M/2 until  leaf.array.length)
        right.array += leaf.array(i)

      root.array.addOne(Entry(M/2-1,left))
      root.array.addOne(Entry(M/2,right))
      left.next = Some(right)
      root.next = Some(left)
    }

  }


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

}

object BPlusTree{

}




object test{
  def main(args: Array[String]): Unit = {
    val a = new BPlusTree[Int]
    a.addData(1)
    a.addData(2)
    a.addData(3)

    println(a.root)
  }
}
