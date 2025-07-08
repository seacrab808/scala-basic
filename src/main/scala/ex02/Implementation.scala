package ex02

object Implementation extends Template {

  import Expr.*

  def interp(expr: Expr, env: Env): Value = {
    expr match {
      case Num(n) => n
      case Add(e1, e2) =>
        interp(e1, env) + interp(e2, env)
      case Mul(e1, e2) =>
        interp(e1, env) * interp(e2, env)
      case Id(x) =>
        env.getOrElse(x, error("free identifier"))
      case Val(x, init, body) =>
        val v1 = interp(init, env)
        val newEnv = env + (x -> v1)
        interp(body, newEnv)
    }
  }

  def freeIds(expr: Expr): Set[String] = {
    expr match {
      case Num(_) => Set()
      case Id(x) => Set(x)
      case Add(e1, e2) =>
        freeIds(e1) ++ freeIds(e2)
      case Mul(e1, e2) =>
        freeIds(e1) ++ freeIds(e2)
      case Val(x, e1, e2) =>
        freeIds(e1) ++ (freeIds(e2) - x)
    }
  }

  def bindingIds(expr: Expr): Set[String] = {
    expr match {
      case Num(_) => Set()
      case Id(_) => Set()
      case Add(e1, e2) =>
        bindingIds(e1) ++ bindingIds(e2)
      case Mul(e1, e2) =>
        bindingIds(e1) ++ bindingIds(e2)
      case Val(x, e1, e2) =>
        Set(x) ++ bindingIds(e1) ++ bindingIds(e2)
    }
  }

  def boundIds(expr: Expr): Set[String] = expr match {
    case Num(_) => Set()
    case Id(_) => Set()
    case Add(e1, e2) =>
      boundIds(e1) ++ boundIds(e2)
    case Mul(e1, e2) =>
      boundIds(e1) ++ boundIds(e2)
    case Val(x, e1, e2) =>
      val initBound = boundIds(e1)
      val bodyBound = boundIds(e2)
      val bodyFree = freeIds(e2)
      val thisBound = if (bodyFree.contains(x)) Set(x) else Set()
      initBound ++ bodyBound ++ thisBound
  }

  def shadowedIds(expr: Expr): Set[String] = {
    def helper(expr: Expr, env: Set[String]): Set[String] = {
      expr match {
        case Num(_) => Set()
        case Id(_) => Set()
        case Add(e1, e2) =>
          helper(e1, env) ++ helper(e2, env)
        case Mul(e1, e2) =>
          helper(e1, env) ++ helper(e2, env)
        case Val(x, e1, e2) =>
          val shadowed = if(env.contains(x)) Set(x) else Set()
          val e1Shadowed = helper(e1, env)
          val e2Shadowed = helper(e2, env + x)
          shadowed ++ e1Shadowed ++ e2Shadowed
      }
    }
  helper(expr, Set())
  }
}
