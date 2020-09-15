import scala.collection.immutable.HashMap

trait TreeNode[+A] {
  val m: Int
  val entry: HashMap[Int,AnyVal]
  val next: TreeNode[A]
}
