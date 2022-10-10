package controller;

import impl.CheckoutServiceImpl;
import repository.DBManager;
import shared.Constant;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Runnable class to check the total cost output with respect to an order input
 * @author Vigneshkumar
 */
public class OrderEntry {

    private static Logger LOG = LoggerFactory.getLogger(OrderEntry.class);

    /**
     * Method to call the CheckoutServiceImpl class to trigger the proceedToCheckout function
     * and returns the total order cost
     */
    public String doOrderProcess() throws Exception {
        return new CheckoutServiceImpl(null).proceedToCheckout(
                new JSONArray(new String(Files.readAllBytes(Paths.get(Constant.ORDER_DETAIL)))));
    }

    /**
     * Main method to initiate the process and calls doOrderProcess method
     */
    public static void main(String[] args) {
        try{
            DBManager.loadBookDetails();
            OrderEntry orderEntry = new OrderEntry();
            LOG.info("Final Price -> ({})",orderEntry.doOrderProcess());

        } catch (Exception e){
            LOG.info("Exception occurred in main {}",e.getMessage());
            e.printStackTrace();
        }
    }
}
