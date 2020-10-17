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
  val M = 3

  var root = {
    RootNode[Node[A]](ArrayBuffer[Entry[Node[A]]](null),None)
  }

  var leaf= {
    LeafNode[A](ArrayBuffer[Entry[A]](null),None)
  }



  def addData(data: A): Unit ={
    if (leaf.array.length == 1){
      leaf.array.addOne(Entry[A](index,data))
      index += 1
    }else if(leaf.array.length >= M/2+1 && leaf.array.length <= M+1 ){
      //TODO 有序插入
    }else{
     //TODO 分裂
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
    val a = new BPlusTree[String]
    a.addData("hello")
    //println(a)
  }
}
