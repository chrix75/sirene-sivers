import siren.luhn.SiretCheck

boolean first = true
new File('/Users/batman/IdeaProjects/insee-divers/src/main/resources/vsearch.48').eachLine { line ->

    if (!first) {
        def fields = line.split(/\|/)
        def siren =fields[0]
        def nic = String.format("%05d", fields[1] as long)
        def siret = siren + nic

        def isValid = new SiretCheck(siret).correct

        if (!isValid) {
            println "$siret validity is $isValid"
        }

    } else {
        first = false;
    }
}
