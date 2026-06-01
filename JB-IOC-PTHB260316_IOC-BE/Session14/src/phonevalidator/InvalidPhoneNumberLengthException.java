package phonevalidator;

public class InvalidPhoneNumberLengthException extends Exception {

    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validatePhoneNumber(String phone) throws InvalidPhoneNumberLengthException {
        if (phone.matches(".*\\s+.*")) {
            throw new InvalidPhoneNumberLengthException("Must not contain whitespace");
        }
        if (!phone.matches("[0-9]+")) {
            throw new InvalidPhoneNumberLengthException("Contains invalid characters");
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Incorrect length");
        }
    }
}

