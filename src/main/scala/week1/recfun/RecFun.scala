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
            var newCP = -1
            if (c == '(') {
                newCP = numCP + 1
            } else if (c == ')') {
                newCP = numCP - 1
            } else {
                newCP = numCP
            }
            if (newCP == -1) return false
            if (chars.isEmpty) {
                if (newCP == 0) true else false
            } else {
                check(newCP, chars.head, chars.tail)
            }
        }
        check(0, chars.head, chars.tail)
    }

    /**
     * Exercise 3
     */
    def countChange(money: Int, coins: List[Int]): Int = -1
}
