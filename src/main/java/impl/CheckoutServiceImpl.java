package impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;
import shared.Constant;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.DBManager;
import service.CheckoutService;
import service.DiscountService;

import java.math.RoundingMode;

/**
 * Implementation class that handles checkout functionality
 * @author Vigneshkumar
 */
public class CheckoutServiceImpl extends DiscountService {

    private static Logger LOG = LoggerFactory.getLogger(CheckoutServiceImpl.class);

    private CheckoutService checkoutService;

    /**
     * Constructor for mocking
     */
    public CheckoutServiceImpl(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    /**
     * Method to handle proceed to checkout. It gives final total cost of the order
     */
    public String proceedToCheckout(JSONArray orderDetail) {
        String result = "";
        try {
            double totalOrderCost = 0;

            if (orderDetail != null && orderDetail.length() > 0) {
                Book bookObj;
                for (int i = 0; i < orderDetail.length(); i++) {
                    bookObj = new ObjectMapper().readValue(orderDetail.getString(i), Book.class);
                    bookObj.setPrice(DBManager.getBookRepo().getJSONObject(bookObj.getName()).getDouble(Constant.BOOK_KEY_PRICE));
                    bookObj.setYear(DBManager.getBookRepo().getJSONObject(bookObj.getName()).getInt(Constant.BOOK_KEY_YEAR));
                    totalOrderCost += calculateBookDiscount(bookObj);
                }
            }
            Constant.dblFormat.setRoundingMode(RoundingMode.DOWN);
            result =  new StringBuffer().append(Constant.POUND_CURRENCY_SYMBOL)
                    .append(Constant.dblFormat.format(calculateTotalCostDiscount(totalOrderCost)))
                    .toString();
        } catch (Exception e) {
            LOG.error("Exception occurred in proceedToCheckout {}",e.getStackTrace());
        }
        return result;
    }
}
