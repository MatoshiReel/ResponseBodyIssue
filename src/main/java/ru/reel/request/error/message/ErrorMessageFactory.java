package ru.reel.request.error.message;

import ru.reel.request.error.reason.ErrorReason;
import ru.reel.request.error.RequestError;

/**
 * The {@code ErrorMessageFactory} is a factory class that provides standardized messages for     the {@code message} field of {@link RequestError}.<br>
 * Check out the {@link #get(ErrorReason)} method to see all supported message formats.
 * @see RequestError
 */
public class ErrorMessageFactory {
    /**
     * {@code EMPTY} -> "%s is empty or null.";<br>
     * {@code JSON_FORMAT} -> "Invalid JSON format.";<br>
     * {@code PATTERN} -> "%s can only contain the following characters: %s";<br>
     * {@code BAD_UUID} -> "Invalid UUID format.";<br>
     * {@code BAD_DATA_TYPE} -> "%s has an invalid data type.";<br>
     * {@code NOT_SUIT} -> "%s doesn't suit. Suitable values: %s.";<br>
     * {@code NOT_EQUAL} -> "%s is not equal to %s.";<br>
     * {@code NOT_EXIST} -> "%s doesn't exist.";<br>
     * {@code EXIST} -> "%s already exists.";<br>
     * {@code NOT_FOUND} -> "%s was not found.";<br>
     * {@code NOT_MATCH} -> "%s doesn't match.";<br>
     * {@code SCOPE} -> "This %s has %s scope, which does not allow this operation for you.";<br>
     * {@code OWNER_ACCESS} -> "You don't have access to this request, because you are not the owner of this %s.";<br>
     * {@code LESS_SIZE} -> "%s cannot be less than %s.";<br>
     * {@code GREATER_SIZE} -> "%s cannot be greater than %s.";<br>
     * {@code NOT_ALLOW} -> "%s is not allowed for this user.";<br>
     * {@code ENCRYPTION} -> "Encrypted data isn't valid."<br>
     * @param reason one of a {@link ErrorReason} enum value.
     * @return unformatted {@link String} message for {@link RequestError} or its subclasses.
     * @see ErrorReason
     * @see ru.reel.request.error.RequestError
     */
    public static String get(ErrorReason reason) {
        return switch(reason) {
            case EMPTY -> "%s is empty or null.";
            case JSON_FORMAT -> "Invalid JSON format.";
            case PATTERN -> "%s can only contain the following characters: %s";
            case BAD_UUID -> "Invalid UUID format.";
            case BAD_DATA_TYPE -> "%s has an invalid data type.";
            case NOT_SUIT -> "%s doesn't suit. Suitable values: %s.";
            case NOT_EQUAL -> "%s is not equal to %s.";
            case NOT_EXIST -> "%s doesn't exist.";
            case EXIST -> "%s already exists.";
            case NOT_FOUND -> "%s was not found.";
            case NOT_MATCH -> "%s is not match.";
            case SCOPE -> "This %s has %s scope, which does not allow this operation for you.";
            case OWNER_ACCESS -> "You don't have access to this request, because you are not the owner of this %s.";
            case LESS_SIZE -> "%s cannot be less than %s.";
            case GREATER_SIZE -> "%s cannot be greater than %s.";
            case NOT_ALLOW -> "%s is not allowed for this user.";
            case ENCRYPTION -> "Encrypted data isn't valid.";
        };
    }

    public static String get(ErrorReason reason, String... params) {
        return String.format(get(reason), params);
    }
}
