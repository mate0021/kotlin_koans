import java.util.*

fun partitionTo() = TODO()

/*
 * 1) partitionTo jest wołane na listOf. To znaczy, że jest to extension function na List.
 * 2) Jest też wołane na setOf. Więc jest to ogólnie extension na Collection.
 * 3) Mamy mieć trzy argumenty: dwie kolekcje i predykat.
 * fun <T, C> Collection<T>.partitionTo(first: T, second: T, predicate: (C) -> Boolean)
 * 
 * 4) Zwracamy destructured (words, lines), więc zwracamy Parę
 * fun <T, C> Collection<T>.partitionTo(first: T, second: T, predicate: (C) -> Boolean): Pair<T, T>
 */

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
