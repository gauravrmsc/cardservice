package in.dreamplug.demp.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import in.dreamplug.demo.unittest.service.CreditLimitService;

/**
 * @author gauravkumar
 * @since 13/04/22
 */
public class CreditLimitServiceTest {
    CreditLimitService creditLimitService;

    @BeforeEach
    public void init() {
        creditLimitService = new CreditLimitService();
    }

    /**
     * Credit Limit should be 0 for users having salary < 25000
     */
    @Test
    public void testCreditLimitVeryLowSalary() {
        Long creditLimit = creditLimitService.getCreditLimit(24999l, 850);
        assertEquals(0, creditLimit, "Credit Limit should be 0 if salary is very low");
    }

    /**
     * 25,000 <= salary < 60,000
     * Credit Score                   Credit Limit
     * < 700                          0
     * 700 <= score < 800              0.4 * salary
     * score >= 800                   0.5 * salary
     */
    @Test
    public void testCreditLimitLowSalary() {
        Long creditLimit = creditLimitService.getCreditLimit(25000l, 850);
        /*
         * If test fails assertTrue will show expected and actual value as boolean values and makes difficult to debug if we are testing non boolean values
         * */
        assertTrue(creditLimit == 12500, "Credit Limit should be 50% of salary for low salary and score bucket of 8");
        creditLimit = creditLimitService.getCreditLimit(25000l, 720);
        assertEquals(10000, creditLimit, "Credit Limit should be 40% of salary for low salary and score bucket of 7");
        creditLimit = creditLimitService.getCreditLimit(25000l, 699);
        assertEquals(0, creditLimit, "Credit Limit should be 0 of salary for low salary and score bucket < 7");
        creditLimit = creditLimitService.getCreditLimit(59999l, 700);
        assertEquals((long) (59999 * 0.4), creditLimit, "Credit Limit should be 40% of salary for low salary and score bucket of 7");
        /*
         * Not Equals can be used for non equality
         * */
        assertNotEquals((long) (60000 * 0.4), creditLimit, "Credit Limit should be 40% of salary for low salary and score bucket of 7");
    }

    /**
     * 60,000 <= salary < 1,00,000
     * Credit Score                   Credit Limit
     * < 600                           0
     * 600 <= score < 700              0.4 * salary
     * 700 <= score < 800              0.5 * salary
     * score >= 800                   0.6 * salary
     */
    public void testCreditLimitAverageSalary() {
        //TODO add tests for 60,000 <= Salary < 1,00,000
    }

    /**
     * salary >= 1,00,000
     * Credit Score                   Credit Limit
     * < 500                           0
     * 500 <= score < 600              0.3 * salary
     * 600 <= score < 700              0.4 * salary
     * 700 <= score < 800              0.7 * salary
     * score >= 800                   0.9 * salary
     */
    public void testCreditLimitHighSalary() {
        //TODO add tests for Salary >= 1,00,000
    }
}


/*
 * JUnit tests are single threaded and test context context is not passed from one test method run to another.
 * BeforeEach is called before each test method run
 * BeforeAll is called before JUnit starts executing tests.
 * Private methods should not be unit tested.
 * we can use @AfterAll and @AfterEach for cleanup tasks
 * */