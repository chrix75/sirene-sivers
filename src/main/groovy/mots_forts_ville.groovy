/**
 * Calcule la fréquence des mots forts par ville.
 */

CODPOS_FIELD = 24
L4_ADR = 38

int count = 0
def wordsCounter = [:]

new File('/Users/batman/IdeaProjects/insee-divers/src/main/resources/vsearch.48')
        .eachLine { line ->
    ++count

    def fields = line.split(/\|/)
    def address = fields[L4_ADR].trim()

    if (count > 1) {
        def word = extractLastWord(address)
        def city = fields[CODPOS_FIELD]

        def key = "$city|$word"
        if (wordsCounter[key]) {
            wordsCounter[key] = wordsCounter[key] + 1
        } else {
            wordsCounter[key] = 1
        }

    }
}

wordsCounter.each { k, v ->
    println "$k: $v"
}
//println wordsCounter
//println "Nombre de lignes: $count"

String extractLastWord(String address) {
    if (address) {
        address.split()[-1]
    } else {
        ''
    }
}