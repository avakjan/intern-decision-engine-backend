package ee.taltech.inbankbackend.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds all necessary constants for the decision engine.
 */
public class DecisionEngineConstants {
    public static final Integer MINIMUM_LOAN_AMOUNT = 2000;
    public static final Integer MAXIMUM_LOAN_AMOUNT = 10000;
    public static final Integer MAXIMUM_LOAN_PERIOD = 48;
    public static final Integer MINIMUM_LOAN_PERIOD = 12;
    public static final Integer SEGMENT_1_CREDIT_MODIFIER = 100;
    public static final Integer SEGMENT_2_CREDIT_MODIFIER = 300;
    public static final Integer SEGMENT_3_CREDIT_MODIFIER = 1000;
    public static final Integer DEFAULT_EXPECTED_LIFETIME = 80;
    public static final Map<String, Integer> COUNTRY_EXPECTED_LIFETIMES = new HashMap<>();
    static {
        COUNTRY_EXPECTED_LIFETIMES.put("EE", 80);
        COUNTRY_EXPECTED_LIFETIMES.put("LV", 79);
        COUNTRY_EXPECTED_LIFETIMES.put("LT", 78);
    }
}