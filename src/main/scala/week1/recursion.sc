// Greatest common division implemented with Euclid's algorithm
@scala.annotation.tailrec
def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def factorialIter(n: Int, currentResult: Int): Int =
        if (n == 0) currentResult else factorialIter(n - 1, n * currentResult)

    factorialIter(n, 1)
}
factorial(4)
