package kz.eduard.exceptiontask.validator;

public class ValidateText {

    public boolean isValidNumber(String text){
        boolean valid = true;
        try{
            Double.parseDouble(text);
        } catch (NullPointerException ex){
            valid = false;
            ex.printStackTrace();
        } catch (NumberFormatException ex){
            valid = false;
            ex.printStackTrace();
        } finally{
            return valid;
        }
    }
}
