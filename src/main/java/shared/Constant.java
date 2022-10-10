package shared;

import java.text.DecimalFormat;

/**
 * Constants used internally by book-store
 * @author Vigneshkumar
 */

public class Constant {

    public static final String POUND_CURRENCY_SYMBOL = "£";
    public static final String BOOK_KEY_PRICE = "price";
    public static final String BOOK_KEY_YEAR = "year";
    public static final DecimalFormat dblFormat = new DecimalFormat("0.00");

    /**
     * BOOK_REPO will hold the bookrepo.json file path, which contains the entire book detaials
     */
    public static final String BOOK_REPO = "src/main/resources/bookrepo.json";

    /**
     * ORDER_DETAIL will hold the orderdetail.json file path. This is used in mail class for testing
     */
    public static final String ORDER_DETAIL = "src/main/resources/orderdetail.json";

    /**
     * Test cases are loaded from the json files
     */
    public static final String TEST_CASE1 = "src/test/resources/testcase1.json";
    public static final String TEST_CASE2 = "src/test/resources/testcase2.json";
    public static final String TEST_CASE3 = "src/test/resources/testcase3.json";
    public static final String TEST_CASE4 = "src/test/resources/testcase4.json";
    public static final String TEST_CASE5 = "src/test/resources/testcase5.json";
}
