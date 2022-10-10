package repository;

import shared.Constant;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * DBManager loads book data on load and manages it.
 * @author Vigneshkumar
 */
public class DBManager {

    public static JSONObject bookRepo;

    /**
     * Loads book data from json file
     */
    public static void loadBookDetails() {
        try{
            bookRepo = new JSONObject(new String(Files.readAllBytes(Paths.get(Constant.BOOK_REPO))));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Returns the bookRepo object which has book details
     */
    public static JSONObject getBookRepo(){
        return bookRepo;
    }
}
