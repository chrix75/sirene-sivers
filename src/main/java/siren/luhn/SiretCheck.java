package siren.luhn;

public class SiretCheck {
    private final String siret;
    private final boolean acceptable;

    public SiretCheck(String siret) {
        String clean = siret.trim();
        if (clean.length() > 0) {
            this.siret = String.format("%14s", clean).replace(' ', '0');
            acceptable = isAcceptable(siret);
        } else {
            acceptable = false;
            this.siret = "";
        }
    }

    private boolean isAcceptable(String siret) {
        return siret.length() == 14 && siret.matches("^\\d{14}$");
    }

    public boolean isCorrect() {

        if (!acceptable) {
            return false;
        }

        if (siret.startsWith("356000000")) {
            return isPosteCorrect();
        } else {
            return isStandardCorrect();
        }
    }

    private boolean isStandardCorrect() {
        int sum = 0;
        for (int i = 0; i < 14; ++i) {
            int n = Character.digit(siret.charAt(i), 10);
            if (i % 2 == 0) {
                n = n * 2;
                if (n > 9) {
                    n-= 9;
                }
            }
            sum += n;
        }

        return sum % 10 == 0;
    }

    private boolean isPosteCorrect() {
        int sum = 0;
        for (int i = 0; i < siret.length(); ++i) {
            int n = Character.digit(siret.charAt(i), 10);
            sum += n;

        }

        return sum % 5 == 0;
    }
}
