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

}
