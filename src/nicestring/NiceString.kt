package nicestring

fun Boolean.toInt(): Int {
    return if(this) 1 else 0
}

fun String.isNice(): Boolean {
    val notContainsUglySubstring = listOf("bu", "ba", "be").none { contains(it)}
    val containsThreeVowels = containsAtLeastThreeVowels(this)
    val containsDoubleLetter = containsDoubleLetter(this)

    return (notContainsUglySubstring.toInt() + containsDoubleLetter.toInt() + containsThreeVowels.toInt()) >= 2
}

private fun containsAtLeastThreeVowels(s: String): Boolean {
    var count = 0
    s.forEach { c ->
        when (c) {
            'a', 'e', 'i', 'o', 'u' -> ++count
        }
    }
    return count >= 3
}

private fun containsDoubleLetter(s: String): Boolean {
    var value = false
    s.forEachIndexed { index, c ->
        if (index != 0) {
            if (s[index - 1] == c) {
                value = true
            }
        }
    }
    return value;
}
