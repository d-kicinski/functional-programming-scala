package week3.rationals

class Rational(x: Int, y: Int) {
    def numer: Int = x
    def denom: Int = y

    def add(other: Rational): Rational =
        new Rational(
            numer * other.denom + other.numer * denom,
            denom * other.denom
        )

    def neg: Rational =
        new Rational(-numer, denom)

    def sub(other: Rational): Rational =
        add(other.neg)

    override def toString: String =
        s"$numer/$denom"
}

