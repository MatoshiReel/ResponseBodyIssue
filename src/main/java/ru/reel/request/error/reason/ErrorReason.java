package ru.reel.request.error.reason;

/**
 * The {@code ErrorReason} is an enum, that points on one of the reason of error for 4xx response status.
 */
public enum ErrorReason {
    EMPTY,
    JSON_FORMAT,
    PATTERN,
    BAD_UUID,
    BAD_DATA_TYPE,
    NOT_SUIT,
    NOT_EQUAL,
    NOT_EXIST,
    EXIST,
    NOT_FOUND,
    NOT_MATCH,
    SCOPE,
    OWNER_ACCESS,
    LESS_SIZE,
    GREATER_SIZE,
    NOT_ALLOW,
    ENCRYPTION
}
