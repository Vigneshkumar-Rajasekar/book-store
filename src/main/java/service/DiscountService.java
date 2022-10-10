package service;

import model.Book;
import shared.Constant;

/**
 * Discount class that handles discounts and offers of the books and orders
 * @author Vigneshkumar
 */
public class DiscountService {

    /**
     * All books published after 2000 have 10% discount
     */
    public int bookDiscount(int year){
        return (year > Constant.DISCOUNT_BOOK_YEAR) ? Constant.BOOK_DISCOUNT_PERCENT : 0;
    }

    /**
     * Calculates the discount of a given book
     */
    public double calculateBookDiscount(Book book) {
        try{
            if(book != null){
                double bookTotalPrice = book.getPrice() * book.getQuantity();
                return ( bookTotalPrice - (getPercentage(bookTotalPrice * bookDiscount(book.getYear()))));
            } else {
                return 0;
            }
        } finally {
            book = null;
        }
    }

    /**
     * Buy books worth more than £30 in total, get a 5% discount on the total
     */
    public double calculateTotalCostDiscount(double totalCost) {
        return (totalCost > Constant.DISCOUNT_TOTAL_AMOUNT) ?
                ( totalCost - (totalCost * (getPercentage(Constant.ORDER_DISCOUNT_PERCENT))) ) : totalCost;
    }

    /**
     * To calculate the percentage
     */
    private double getPercentage(double sum){
        return (sum/100);
    }
}
