import impl.CheckoutServiceImpl;
import shared.Constant;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repository.DBManager;
import service.CheckoutService;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.Mockito.when;

/**
 * MockitoJUnitRunner gives automatic validation of framework usage, as well as an automatic initMocks()
 * @author Vigneshkumar
 */
@RunWith(MockitoJUnitRunner.class)

public class CheckoutServiceImplTest {

    /**
     * Injection allows you to, Enable shorthand mock and spy injections.
     */
    @InjectMocks
    CheckoutServiceImpl checkoutService;

    /**
     * The Mockito.mock() method allows us to create a mock object of a class or an interface
     */
    @Mock
    CheckoutService checkoutServiceMock;

    /**
     * Methods annotated with the @Before annotation are run before each test
     */
    @Before
    public void setUp() {
        DBManager.loadBookDetails();
        checkoutService = new CheckoutServiceImpl(checkoutServiceMock);
    }

    /**
     * Positive test case 1 :
     * "Buying The Terrible Privacy of Maxwell Sim, Three Men in a Boat will cost £24.69"
     * The Terrible Privacy of Maxwell Sim is published after the year 2000, so the discount of 10% will be
     * applied for this particular book
     */
    @Test
    public void testProceedToCheckoutCase1() throws Exception {
        JSONArray testCase1 = new JSONArray(new String(Files.readAllBytes(Paths.get(Constant.TEST_CASE1))));
        when(checkoutServiceMock.proceedToCheckout(testCase1)).thenReturn("£24.69");
        Assert.assertEquals("£24.69",checkoutService.proceedToCheckout(testCase1));
    }

    /**
     * Positive test case 2 :
     * "Buying Still Life With Woodpecker, Three Men in a Boat, Great Expectations will
     * cost £35.27"
     * All the 3 books are published before the year 2000 and sum of all 3 books costs over £30,
     * so a discount of 5% is applied from the total bill
     */
    @Test
    public void testProceedToCheckoutCase2() throws Exception {
        JSONArray testCase2 = new JSONArray(new String(Files.readAllBytes(Paths.get(Constant.TEST_CASE2))));
        when(checkoutServiceMock.proceedToCheckout(testCase2)).thenReturn("£35.27");
        Assert.assertEquals("£35.27",checkoutService.proceedToCheckout(testCase2));
    }

    /**
     * Positive test case 3 :
     * "Buying The Terrible Privacy of Maxwell Sim, Three Men in a Boat, Great
     * Expectations will cost £36.01"
     * The Terrible Privacy of Maxwell Sim is published after the year 2000, so the discount of 10% will be
     * applied for this particular book and sum of all 3 books costs over £30,
     * so a discount of 5% is applied from the total bill
     */
    @Test
    public void testProceedToCheckoutCase3() throws Exception {
        JSONArray testCase3 = new JSONArray(new String(Files.readAllBytes(Paths.get(Constant.TEST_CASE3))));
        when(checkoutServiceMock.proceedToCheckout(testCase3)).thenReturn("£36.01");
        Assert.assertEquals("£36.01",checkoutService.proceedToCheckout(testCase3));
    }


}
