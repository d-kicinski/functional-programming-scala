
def sqrt(x: Double): Double = {
    def abs(x: Double) = if (x < 0) -x else x

    def isGoodEnough(guess: Double): Boolean =
        abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
        (guess + x / guess) / 2

    @scala.annotation.tailrec
    def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))

    sqrtIter(1.0)
}

sqrt(2)
sqrt(4)
sqrt(1e-60)
sqrt(1e60)

