// take the sum of f(x) of integers between a and b (inclusive)
def sum(f: Int => Int, a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int =
        if (a > b) acc else loop(a + 1, acc + f(a))

    loop(a, 0)
}

assert(sum(x => x * x, 3, 5) == 50)

def sumInts(a: Int, b: Int) = sum(x => x, a, b)

def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

def sumFactorials(a: Int, b: Int): Int = {
    def factorial(x: Int): Int =
        if (x == 0) 1 else x + factorial(x - 1)

    sum(factorial, a, b)
}