sealed trait BNode[+A]


case class BFNode[A](cnode : BNode[A]) extends BNode[A]{

}

case class BCNode(cnode : BCNode) extends BNode[+A]{

}
