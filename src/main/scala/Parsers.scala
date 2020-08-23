import scala.util.parsing.combinator._
case class WordFreq(word: String, count: Int) {
  override def toString = "Word <" + word + "> " +
    "occurs with frequency " + count
}

class SimpleParser extends RegexParsers {
  def word: Parser[String]   = """[a-z]+""".r       ^^ { _.toString }
  def number: Parser[Int]    = """(0|[1-9]\d*)""".r ^^ { _.toInt }
  def freq: Parser[WordFreq] = word ~ number        ^^ { case wd ~ fr => WordFreq(wd,fr) }
  //
  def Sql_DML: Parser[String] = "(?i)(SELECT|UPDATE|DELETE|INSERT)".r ^^{_.toString}
  def Sql_DDL: Parser[String] = "(?i)(CREATE|ALTER|DROP)".r ^^{_.toString}

}

object TestSimpleParser extends SimpleParser {
  def main(args: Array[String]) = {
    parse(Sql_DML, "insert") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
  }
}
