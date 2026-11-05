
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    @Test
    void letterGradeReturnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGradeReturnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void gpaCalculatesAverageCorrectly() {
        assertEquals(3.5, calculator.gpa(new double[]{95, 85}), 0.001);
    }

    @Test
    void scholarshipReturns100Percent() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipReturns70Percent() {
        assertEquals(70, calculator.scholarship(3.5, 12, false));
    }
}
