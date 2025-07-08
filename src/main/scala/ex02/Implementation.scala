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
        // 여기에 왜 mul은 없는지 ? 그리고 val 식 왜 이런지 ? 이건 init이랑 body인건지 인자가 ?
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
  // 얘도 왜 Mul은 없는지 ? val은 왜 이모양인지?

  def boundIds(expr: Expr): Set[String] = {
    expr match {
      case Num(_) => Set()
      case Id(_) => Set()
      case Add(e1, e2) =>
        boundIds(e1) ++ boundIds(e2)
      case Mul(e1, e2) =>
        boundIds(e1) ++ boundIds(e2)
      case Val(x, e1, e2) =>
        Set(x) ++ boundIds(e1) ++ boundIds(e2)
    }
  }
  // 왜 bindingIds랑 같은지?

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
