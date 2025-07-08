package hw01

object Implementation extends Template {

  // ---------------------------------------------------------------------------
  // Basic Data Types
  // ---------------------------------------------------------------------------
  def isEvenPair(x: Int, y: Int): Boolean = {
    (x + y) % 2 == 0
  }

  def validString(str: String, lower: Int, upper: Int): Boolean = {
    val len = str.length
    len >= lower && len <= upper
  }

  // ---------------------------------------------------------------------------
  // Functions
  // ---------------------------------------------------------------------------
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

  // 이해 X
  def magic(x: Int): Int => Int = {
    y => {
      if(y % x == 0) y / x
      else (x + 1) * y + (x - y % x)
    }
  }

  def applyK(f: Int => Int, k: Int): Int => Int = {
    if (k == 0) (x: Int) => x
    else (x: Int) => applyK(f, k - 1)(f(x))
  }

  // ---------------------------------------------------------------------------
  // Collections
  // ---------------------------------------------------------------------------
  def productPos(l: List[Int]): Int = {
    val positives = l.filter(_ > 0)
    if(positives.isEmpty) 1
    else positives.foldLeft(1)(_ * _)
  }

  def merge(l: List[Int]): List[Int] = {
    l match {
      case Nil => Nil // 없으면 빈 리스트 반환
      case x :: Nil => List(x) // x 다음 Nil이면 x 반환
      case x :: y :: rest => (x + y) :: merge(rest)
      // x 다음 y 다음 값이 남으면 x + y 하고 남은 값을 재귀함수에 집어넣음
    }
  }

  def generate(init: Int, f: Int => Int, n: Int): List[Int] = {
    if (n == 0) Nil
    else init :: generate(f(init), f, n - 1)
  }

  def incKey(map: Map[String, Int], key: String): Map[String, Int] = {
    map.get(key) match {
      case Some(v) => map.updated(key, v + 1)
      case None => map
    }
  }

  def validSums(
    l: List[Int],
    r: List[Int],
    f: (Int, Int) => Boolean,
  ): Set[Int] =  {
    (for {
      x <- l
      y <- r
      if f(x, y)
    } yield x + y).toSet
  }

  // ---------------------------------------------------------------------------
  // Trees
  // ---------------------------------------------------------------------------
  import Tree.*

  def count(t: Tree, x: Int): Int = {
    t match {
      case Leaf(v) => if(v == x) 1 else 0
      case Branch(left, v, right) =>
        (if (v == x) 1 else 0) + count(left, x) + count(right, x)
    }
  }

  def heightOf(t: Tree): Int = {
    t match {
      case Leaf(_) => 0
      case Branch(left, _, right) =>
        1 + (heightOf(left) max heightOf(right))
    }
  }

  def min(t: Tree): Int = {
    t match {
      case Leaf(v) => v
      case Branch(left, v, right) =>
        v min min(left) min min(right)
    }
  }

  def sumLeaves(t: Tree): Int = {
    t match {
      case Leaf(v) => v
      case Branch(left, _, right) =>
        sumLeaves(left) + sumLeaves(right)
    }
  }

  def inorder(t: Tree): List[Int] = {
    t match {
      case Leaf(v) => List(v)
      case Branch(left, v, right) =>
        inorder(left) ++ List(v) ++ inorder(right)
    }
  }

  // ---------------------------------------------------------------------------
  // Boolean Expressions
  // ---------------------------------------------------------------------------
  import BE.*

  def isLiteral(expr: BE): Boolean = {
    expr match {
      case Literal(_) => true
      case _ => false
    }
  }

  def countImply(expr: BE): Int = {
    expr match {
      case Literal(_) => 0
      case Not(e) => countImply(e)
      case And(l, r) => countImply(l) + countImply(r)
      case Or(l, r) => countImply(l) + countImply(r)
      case Imply(l, r) => 1 + countImply(l) + countImply(r)
    }
  }

  def literals(expr: BE): List[Boolean] = {
    expr match {
      case Literal(b) => List(b)
      case Not(e) => literals(e)
      case And(l, r) => literals(l) ++ literals(r)
      case Or(l, r) => literals(l) ++ literals(r)
      case Imply(l, r) => literals(l) ++ literals(r)
    }
  }

  def getString(expr: BE): String = {
    expr match {
      case Literal(true) => "#t"
      case Literal(false) => "#f"
      case Not(e) => s"!${getString(e)}"
      case And(l, r) => s"(${getString(l)} & ${getString(r)})"
      case Or(l, r) => s"(${getString(l)} | ${getString(r)})"
      case Imply(l, r) => s"(${getString(l)} => ${getString(r)})"
    }
  }

  def eval(expr: BE): Boolean = {
    expr match {
      case Literal(b) => b
      case Not(e) => !eval(e)
      case And(l, r) => eval(l) && eval(r)
      case Or(l, r) => eval(l) || eval(r)
      case Imply(l, r) => !eval(l) || eval(r)
    }
  }
}
