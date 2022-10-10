package repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shared.Constant;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * DBManager loads book data on load and manages it.
 * @author Vigneshkumar
 */
public class DBManager {

    private static Logger LOG = LoggerFactory.getLogger(DBManager.class);
    public static JSONObject bookRepo;

    /**
     * Loads book data from json file
     */
    public static void loadBookDetails() {
        try{
            bookRepo = new JSONObject(new String(Files.readAllBytes(Paths.get(Constant.BOOK_REPO))));
        } catch (IOException e){
            LOG.error("File Exception in loading book details {} ",e.getStackTrace());
        }
        catch (Exception e){
            LOG.error("Exception in loading book details {} ",e.getStackTrace());
        }
    }

    /**
     * Returns the bookRepo object which has book details
     */
    public static JSONObject getBookRepo(){
        return bookRepo;
    }
}
