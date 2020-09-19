case class BPlusTree[A](

                       ) {

  def creat(): RootNode[String] ={
    RootNode(2,Array(Entry(1,"String"),Entry(2,"HELLO")),Some(LeafNode(2,Array(Entry(1,"WORLD")),None)))

  }
/*  def creat(): Unit ={
    println("ll")
  }*/
}




object test{
  def main(args: Array[String]): Unit = {
   val a = BPlusTree[String]()
    println(a.creat())
  }
}
