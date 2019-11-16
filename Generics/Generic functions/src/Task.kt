import java.util.*

fun <C: MutableCollection<E>, E> Collection<E>.partitionTo(first: C, second: C, predicate: (E) -> Boolean): Pair<C, C> {
    for (item in this) {
        if (predicate(item)) {
            first.add(item)
        } else {
            second.add(item)
        }
    }
    return Pair(first, second)
}

/*
 * 1) partitionTo jest wołane na listOf. To znaczy, że jest to extension function na List.
 * 2) Jest też wołane na setOf. Więc jest to ogólnie extension na Collection.
 * 3) Mamy mieć trzy argumenty: dwie kolekcje i predykat.
 * fun <T, C> Collection<T>.partitionTo(first: T, second: T, predicate: (C) -> Boolean)
 * 
 * 4) Zwracamy destructured (words, lines), więc zwracamy Parę
 * fun <T, C> Collection<T>.partitionTo(first: T, second: T, predicate: (C) -> Boolean): Pair<T, T>
 *
 * 5) Musimy powiedzieć, że jeden z typów generycznych jest kolekcją elementów E. W dodatku mutowalną, bo argumentami są kolekcje, do których będziemy zapisywać elementy po ewaluacji predykatu.
 * fun <C: MutableCollection<E>, E> Collection<E>.partitionTo(first: C, second: C, predicate: (E) -> Boolean): Pair<C, C>
 *
 * 6) Iterujemy po elementach kolekcji, którą rozszerzamy poprzez extension function, więc this'em są elementy tej kolekcji
 *
 * 7) Jeśli item spełnia predykat, dodajemy do first (dlatego jest Mutable), jeśli nie, to do second. Zwracamy Pair(first, second)
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
