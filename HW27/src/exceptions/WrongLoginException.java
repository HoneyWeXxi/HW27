package exceptions;

public class WrongLoginException extends Exception {
    //todo реализовать свое исключение

    public WrongLoginException() {
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
