def sumVerbose(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
        @scala.annotation.tailrec
        def loop(a: Int, acc: Int): Int =
            if (a > b) acc else loop(a + 1, acc + f(a))

        loop(a, 0)
    }

    sumF
}

def sum(f: Int => Int)(a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int =
        if (a > b) acc else loop(a + 1, acc + f(a))

    loop(a, 0)
}

assert(3 == sum(x => x)(0, 2))
assert(3 == sumVerbose(x => x)(0, 2))

def product(f: Int => Int)(a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int =
        if (a > b) acc else loop(a + 1, acc * f(a))

    loop(a, 1)
}

assert(24 == product(x => x)(1, 4))


def transformReduce(transform: Int => Int, reduce: (Int, Int) => Int, initialAcc: Int)(a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int =
        if (a > b) acc else loop(a + 1, reduce(acc, transform(a)))

    loop(a, initialAcc)
}


def factorial(n: Int): Int =
    transformReduce(x => x, (y, z) => y * z, 1)(1, n)
assert(24 == factorial(4))

