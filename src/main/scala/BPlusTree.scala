import scala.collection.mutable.ArrayBuffer

case class BPlusTree[A](
                         var root: RootNode[AnyVal]
                       ) {

  var h: Int = 0

  def add_data(data: A): Unit ={
    if (h == 0 && root.m == 0){
      root = RootNode[A](ArrayBuffer(Entry(1,1)),None)

      root.array.addOne(Entry(
        System.currentTimeMillis().toInt,
        data
      ))
    }
  }


}




object test{
  def main(args: Array[String]): Unit = {
   val a = BPlusTree[String]()
    println(a.creat())
  }
}
