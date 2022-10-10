package service;

import org.json.JSONArray;

/**
 * CheckoutService gives definition to Check Out Impl. This interface is used for mocking
 * @author Vigneshkumar
 */

public interface CheckoutService {
    public String proceedToCheckout(JSONArray orderDetail);
}
