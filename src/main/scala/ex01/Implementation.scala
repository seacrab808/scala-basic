package ex01

object Implementation extends Template {

  import Expr.*

  def interp(expr: Expr): Value = {
    expr match {
      case Expr.Num(n) => n
      case Expr.Add(l, r) => interp(l) + interp(r)
      case Expr.Mul(l, r) => interp(l) * interp(r)
    }
  }

  def countNums(expr: Expr): Int = {
    expr match {
      case Expr.Num(_) => 1
      case Expr.Add(l, r) => countNums(l) + countNums(r)
      case Expr.Mul(l, r) => countNums(l) + countNums(r)
    }
  }
}
