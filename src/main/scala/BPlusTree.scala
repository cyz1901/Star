import scala.collection.mutable.ArrayBuffer

class BPlusTree[A](

                       ) {
  var root: RootNode[A] = RootNode[A](null,None)
  var h: Int = 0
  var tree_index = 0

  def add_data(data: A): Unit ={
    if (h == 0 && root.m == 0){
      root = RootNode[A](
        ArrayBuffer(Entry[Int](1,tree_index)),
        Some(
          LeafNode[A](
            ArrayBuffer(Entry[A](tree_index,data)),
            None
          )
        )
      )

    }
    else {
      val test = root.next.get.asInstanceOf[LeafNode[A]]
      test.array.addOne(Entry[A](2,data))
    }
  }


}




object test{
  def main(args: Array[String]): Unit = {
    val a = new BPlusTree[String]
    val data = "aa"
    a.add_data(data)
    a.add_data("hello")
    println(a.root)
  }
}
