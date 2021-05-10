import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class passwordCheckerTest {

    @Test
    public void passwordShouldExistTest() {

        PasswordChecker pass = new PasswordChecker();
        String password = "";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should exist");

    }

    @Test
    public void password_length () {

        PasswordChecker pass = new PasswordChecker();
        String password = "khethu";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should be longer than than 8 characters");
    }

    @Test
    public void password_upperCase () {

        PasswordChecker pass = new PasswordChecker();
        String password = "Khethukuthula";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should have at least one uppercase letter");
    }

    @Test
    public void password_lowerCase () {

        PasswordChecker pass = new PasswordChecker();
        String password = "khethukuthula";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should have at least one lowercase letter");
    }

    @Test
    public void password_hasDigit () {
        PasswordChecker pass = new PasswordChecker();
        String password = "khethukuthula123";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should have at least one lowercase letter");
    }

    @Test
    public void password_hasSpecialChar() {
        PasswordChecker pass = new PasswordChecker();
        String password = "khethukuthula123@#$*";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should have at least one lowercase letter");
    }

    @Test
    public void password_hasWhitespaceChar() {
        PasswordChecker pass = new PasswordChecker();
        String password = "Khethukuthula 123@#$*";
        assertThrows(passwordException.class, () -> pass.passwordIsValid(password), "password should have at least one lowercase letter");
    }

    @Test
    public void invalid_password () {
        PasswordChecker pass = new PasswordChecker();
        assertEquals("Invalid",pass.passwordStrength("khe"));
    }

    @Test
    public void weak_password () {
        PasswordChecker pass = new PasswordChecker();
        assertEquals("Weak",pass.passwordStrength("khethukuthula"));
    }

    @Test
    public void medium_password () {
        PasswordChecker pass = new PasswordChecker();
        assertEquals("Medium",pass.passwordStrength("Khethukuthula"));
    }

    @Test
    public void Strong_password () {
        PasswordChecker pass = new PasswordChecker();
        assertEquals("Strong",pass.passwordStrength("Khethukuthula1010% %$%"));
    }


}
