import scala.collection.immutable.HashMap
class RootNode[A](
                   override val m: Int,
                   override val entry: HashMap[Int, AnyVal],
                   override val next: TreeNode[A]
                 ) extends TreeNode[A] {

}
