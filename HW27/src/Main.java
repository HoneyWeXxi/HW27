import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //todo Тут протестить работу метода
        System.out.print("Введите логин: ");
        String login = new Scanner(System.in).nextLine();
        System.out.print("Введите пароль: ");
        String password = new Scanner(System.in).nextLine();
        System.out.print("Введите пароль еще раз: ");
        String confirmPassword = new Scanner(System.in).nextLine();
        try {
            confirmPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    //todo тут создать метод confirmPassword()
    public static boolean confirmPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (validLoginOrPassword(login)) {
            throw new WrongLoginException("Логин не соответствует");
        }
        if (!password.equals(confirmPassword) || validLoginOrPassword(password)) {
            throw new WrongPasswordException("Неверный пароль");
        }

        return true;
    }

    private static boolean validLoginOrPassword(String loginOrPassword) {
        return !loginOrPassword.matches("\\w+") || loginOrPassword.length() >= 20;
    }
}