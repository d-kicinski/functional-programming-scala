package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface {

    def main(args: Array[String]): Unit = {
        println("Pascal's Triangle")
        for (row <- 0 to 10) {
            for (col <- 0 to row)
                print(s"${pascal(col, row)} ")
            println()
        }
    }

    /**
     * Exercise 1
     */
    def pascal(c: Int, r: Int): Int = {
        if (c == 0 || r == c) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

    /**
     * Exercise 2
     */
    def balance(chars: List[Char]): Boolean = {
        @tailrec
        def check(numCP: Int, c: Char, chars: List[Char]): Boolean = {
            val closingParenthesisCount = c match {
                case '(' => numCP + 1
                case ')' => numCP - 1
                case _ => numCP
            }

            if (closingParenthesisCount == -1) {
                false
            } else if (chars.isEmpty && closingParenthesisCount == 0) {
                true
            } else {
                check(closingParenthesisCount, chars.head, chars.tail)
            }
        }
        check(0, chars.head, chars.tail)
    }

    /**
     * Exercise 3
     */
    def countChange(money: Int, coins: List[Int]): Int = {
        if (money == 0) {
            1
        } else if (money > 0 && !coins.isEmpty) {
            countChange(money - coins.head, coins) + countChange(money, coins.tail)
        } else {
            0
        }
    }
}
