
package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // ==========================================
    // PART A - Happy Path Tests
    // ==========================================

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

    // ==========================================
    // PART B - Letter Grade Branch Tests
    // ==========================================

    @Test
    void letterGradeReturnsB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void letterGradeReturnsD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void letterGradeReturnsF() {
        assertEquals("F", calculator.letterGrade(50));
    }

    @Test
    void negativeScoreThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
    }

    @Test
    void scoreAbove100ThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    // ==========================================
    // PART B - GPA Tests
    // ==========================================

    @Test
    void gpaHandlesAllGradeCategories() {
        double result = calculator.gpa(
                new double[]{95, 85, 75, 65, 50}
        );

        assertEquals(2.0, result, 0.001);
    }

    @Test
    void gpaWithNullThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    @Test
    void gpaWithEmptyArrayThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    // ==========================================
    // PART B - Scholarship Branch Tests
    // ==========================================

    @Test
    void negativeGpaThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 16, false));
    }

    @Test
    void gpaAboveFourThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 16, false));
    }

    @Test
    void negativeCreditsThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.9, -1, false));
    }

    @Test
    void scholarshipReturnsZeroForViolation() {
        assertEquals(0, calculator.scholarship(3.9, 16, true));
    }

    @Test
    void scholarshipReturns70WhenCreditsBelow15() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    @Test
    void scholarshipReturns50WhenCreditsBelow12() {
        assertEquals(50, calculator.scholarship(3.5, 11, false));
    }

    @Test
    void scholarshipReturns50Percent() {
        assertEquals(50, calculator.scholarship(3.2, 12, false));
    }

    @Test
    void scholarshipReturnsZeroBelowThree() {
        assertEquals(0, calculator.scholarship(2.9, 16, false));
    }


    // ==========================================
    // PART C - Loop Boundary Tests
    // ==========================================

    @Test
    void gpaWithOneScoreReturnsFour() {
        assertEquals(4.0,
                calculator.gpa(new double[]{95}), 0.001);
    }

    @Test
    void gpaWithMultipleScoresReturnsCorrectAverage() {
        assertEquals(2.5,
                calculator.gpa(new double[]{95, 85, 75, 65}), 0.001);
    }

        // ==========================================
    // PART D - Boundary Value Tests
    // ==========================================

    @Test
    void letterGradeAt60ShouldReturnD() {
        assertEquals("D", calculator.letterGrade(60));
    }

    @Test
    void letterGradeAt59Point99ShouldReturnF() {
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    void letterGradeAt69Point99ShouldReturnD() {
        assertEquals("D", calculator.letterGrade(69.99));
    }

    @Test
    void letterGradeAt0ShouldReturnF() {
        assertEquals("F", calculator.letterGrade(0));
    }

    @Test
    void letterGradeAt100ShouldReturnA() {
        assertEquals("A", calculator.letterGrade(100));
    }

    @Test
    void letterGradeAt89Point99ShouldReturnB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void letterGradeAt90ShouldReturnA() {
        assertEquals("A", calculator.letterGrade(90));
    }
}
