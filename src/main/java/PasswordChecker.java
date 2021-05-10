import java.util.regex.Matcher;
import java.util.regex.Pattern;

class passwordException extends RuntimeException {
    public passwordException(String text){
        super(text);
    }
}

public class PasswordChecker {


    public boolean passwordIsValid(String password){

       if (password.length() == 0 || password.equals(null)) {

            throw new passwordException("password should exist");
        }

       if (password.length() < 8){

            throw new passwordException("password should be longer than than 8 characters");

       }

        if (hasLower(password)){

            throw new passwordException("password should have at least one lowercase letter");
        }

       if (hasCap(password)){

           throw new passwordException("password should have at least one uppercase letter");
       }

       if (hasDigit(password)) {

           throw new passwordException("password should at least have one digit");
       }

       if (hasSpecialChar(password)) {

           throw new passwordException("password should have at least one special character");
       }

       if (containsWhitespace(password)) {

           throw new passwordException("password should have at least one whitespace character");
       }

        return true;
    }

    public static String passwordStrength(String password) {

        int count = 0;
        if(!(password.equals(""))){ count ++; }
        if(password.length() > 8 ){ count ++; }
        if(hasLower(password)){ count ++; }
        if(hasCap(password)){ count ++; }
        if(hasDigit(password)){ count ++; }
        if(hasSpecialChar(password)){ count ++; }
        if(containsWhitespace(password)){ count ++; }

        if(count >= 6){
            return "Strong";
        }
        if(count >= 4){
            return "Medium";
        }
        if(count == 3){
            return "Weak";
        }
        return "Invalid";
    }

    public static boolean hasCap (String text){
        char c;
        for (int i = 0; i < text.length(); i++){
            c = text.charAt(i);
            if (Character.isUpperCase(c)) {

                return true;
            }
        }
        return false;
    }

    public static boolean hasLower (String text){
        char c;
        for (int i = 0; i < text.length(); i++){
            c = text.charAt(i);
            if (Character.isLowerCase(c)) {

                return true;
            }
        }
        return false;
    }

    public static boolean hasDigit (String text){
        char c;
        for (int i = 0; i < text.length(); i++){
            c = text.charAt(i);
            if (Character.isDigit(c)) {

                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar (String text){
        Pattern my_pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher my_match = my_pattern.matcher(text);
        boolean check = my_match.find();

        if (check) {

            return true;
        } else {
            return  false;
        }

    }

    public static boolean hasLength(String str) {
        return (str != null && str.length() > 0);
    }

    public static boolean containsWhitespace(String str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }

}







