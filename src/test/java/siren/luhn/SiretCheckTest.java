package siren.luhn;

import org.junit.Test;

import static org.junit.Assert.*;

public class SiretCheckTest {
    @Test
    public void validPosteSiret() {
        SiretCheck check = new SiretCheck("35600000015370");
        assertTrue(check.isCorrect());
    }

    @Test
    public void invalidPosteSiret() {
        SiretCheck check = new SiretCheck("35600000015332");
        assertFalse(check.isCorrect());
    }

    @Test
    public void emptySiret() {
        SiretCheck check = new SiretCheck("");
        assertFalse(check.isCorrect());
    }

    @Test
    public void incorrectSiret() {
        SiretCheck check = new SiretCheck("QERETTRFR");
        assertFalse(check.isCorrect());
    }

    @Test
    public void validSiret() {
        SiretCheck check = new SiretCheck("42330099500028");
        assertTrue(check.isCorrect());
    }

    @Test
    public void invalidSiret() {
        SiretCheck check = new SiretCheck("42330099500027");
        assertFalse(check.isCorrect());
    }

    @Test
    public void tooLongSiret() {
        SiretCheck check = new SiretCheck("4233009950002700027");
        assertFalse(check.isCorrect());
    }

}