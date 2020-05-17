package week3.rationals

class RationalTest extends org.scalatest.FunSuite {
    test("Add rationals") {
        val r1 = new Rational(1, 3)
        val r2 = new Rational(5, 7)
        val result = r1.add(r2)
        assert(result.numer == 22 && result.denom == 21)
    }

    test("Negate rational") {
        val r = new Rational(1, 3)
        val r_neg = r.neg
        assert(r_neg.numer == -r.numer && r_neg.denom == r.denom)
    }

    test("Subtract rationals") {
        val r1 = new Rational(2, 3)
        val r2 = new Rational(1, 3)
        val result = r1.sub(r2)
        assert(result.numer == 3 && result.denom == 9)
    }
    test("Random test case") {
        val x = new Rational(1, 3)
        val y = new Rational(5, 7)
        val z = new Rational(3, 2)
        val result = x.sub(y).sub(z)
        assert(result.numer == -79 && result.denom == 42)
    }

    test("toString") {
        val string = new Rational(1, 3).toString()
        val expectedString = "1/3"
        assert(string == expectedString)
    }
}
