import java.util.*

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object: Comparator<Int> {
        override fun compare(e1: Int, e2: Int) =
                if (e1 < e2) 1
        else if (e1 == e2) 0
        else -1
    })
    return arrayList
}

// better:
// override fun compare(e1: Int, e2: Int) = e2 - e1