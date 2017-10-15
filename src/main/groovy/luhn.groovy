import siren.luhn.SiretCheck

boolean first = true
new File('/Users/batman/IdeaProjects/insee-divers/src/main/resources/vsearch.48').eachLine { line ->

    if (!first) {
        def fields = line.split(/\|/)
        def siren =fields[0]
        def nic = String.format("%05d", fields[1] as long)
        def siret = siren + nic

        def check = new SiretCheck(siret)
        if (!check.correct) {
            println "$siret validity is ${check.correct}"
        }

    } else {
        first = false;
    }
}
