trait List[T] {

    def isEmpty: Boolean

    def head: T

    def tail: List[T]
}

class EmptyNode[T] extends List[T] {
    def isEmpty = true

    def head = throw new NoSuchElementException("EmptyNode.head")

    def tail = throw new NoSuchElementException("EmptyNode.tail")
}

class Node[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
}


def singleton[T](value: T): List[T] = new Node[T](value, new EmptyNode[T])

def nth[T](n: Int, list: List[T]): T = {
    if (n == 0) list.head
    else if (list.isEmpty) throw new IndexOutOfBoundsException("nth")
    else nth(n - 1, list.tail)
}

val list = new Node(1, new Node(2, new Node(3, new EmptyNode)))
list.head

//nth(0, list)
//nth(1, list)
//nth(2, list)
//nth(3, list)
