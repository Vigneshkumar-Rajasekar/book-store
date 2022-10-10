package model;

/**
 * Added Book pojo class to hold the book details
 * @author Vigneshkumar
 */
public class Book {

    String name;
    int year;
    double price;
    int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "name:"+name + "year:"+year + "quantity:"+quantity + "price:"+price;
    }
}
