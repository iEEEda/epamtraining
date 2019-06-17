package kz.eduard.matrix.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidateText {

    private static final Logger LOGGER = LogManager.getLogger(ValidateText.class);

    public boolean isValidNumber(String text){
        boolean valid = true;
        try{
            Double.parseDouble(text);
        } catch (NullPointerException ex){
            valid = false;
            LOGGER.error(ex);
        } catch (NumberFormatException ex){
            valid = false;
            LOGGER.error(ex);
        } finally{
            return valid;
        }
    }
}
