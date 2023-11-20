import exception.WrongLoginException;
import exception.WrongPasswordException;

public class ConfirmData {
    public static boolean confirm(String login, String password, String confirmPassword) {
        if (login.length() >= 20) {
            try {
                throw new WrongLoginException("Логин меньше 20 символов");
            } catch (WrongLoginException e) {
                return false;
            }
        }
        if (password.length() >= 20) {
            try {
                throw new WrongPasswordException("Пароль меньше 20 символов");
            } catch (WrongPasswordException e) {
                return false;
            }
        }
        if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Пароль не совпадает с подтвержением пароля");
            } catch (WrongPasswordException e) {
                return false;
            }
        }
        return true;
    }
}
