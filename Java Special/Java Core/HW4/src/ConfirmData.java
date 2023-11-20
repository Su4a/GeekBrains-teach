import exception.WrongLoginException;
import exception.WrongPasswordException;

public class ConfirmData {
    public static boolean confirm(String login, String password, String confirmPassword) {
        if (login.length() >= 20) {
            try {
                throw new WrongLoginException("����� ������ 20 ��������");
            } catch (WrongLoginException e) {
                return false;
            }
        }
        if (password.length() >= 20) {
            try {
                throw new WrongPasswordException("������ ������ 20 ��������");
            } catch (WrongPasswordException e) {
                return false;
            }
        }
        if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("������ �� ��������� � ������������� ������");
            } catch (WrongPasswordException e) {
                return false;
            }
        }
        return true;
    }
}
