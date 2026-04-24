package ru.reel.request.error;

import ru.reel.request.error.message.ErrorMessageFactory;
import ru.reel.request.error.reason.ErrorReason;
import ru.reel.request.issue.RequestIssue;

/**
 * The {@code RequestError} is a DTO class, that describes a reason of error for 4xx response status.
 * @see ErrorReason
 * @see ErrorMessageFactory
 */
public class RequestError extends RequestIssue {
    protected ErrorReason errorReason;

    public ErrorReason getErrorReason() {
        return errorReason;
    }

    public RequestError(RequestErrorBuilder<?, ?> builder) {
        super(builder);
        this.errorReason = builder.errorReason;
    }

    public static RequestErrorBuilder<?, ?> builder() {
        return new RequestErrorBuilderImpl();
    }

    public abstract static class RequestErrorBuilder<C extends RequestError, B extends RequestErrorBuilder<C, B>> extends RequestIssueBuilder<C, B> {
        protected ErrorReason errorReason;

        public B errorReason(ErrorReason errorReason) {
            this.errorReason = errorReason;
            return self();
        }

        /**
         * @see ErrorMessageFactory
         */
        public B message(ErrorReason reason) {
            this.message = ErrorMessageFactory.get(reason);
            return self();
        }

        /**
         * @see ErrorMessageFactory
         */
        public B message(ErrorReason reason, String... params) {
            this.message = ErrorMessageFactory.get(reason, params);
            return self();
        }

        /**
         * @see ErrorMessageFactory
         */
        public B message() {
            this.message = ErrorMessageFactory.get(this.errorReason);
            return self();
        }

        /**
         * @see ErrorMessageFactory
         */
        public B message(String... params) {
            this.message = ErrorMessageFactory.get(this.errorReason, params);
            return self();
        }

        @Override
        public abstract C build();
    }

    private static class RequestErrorBuilderImpl extends RequestErrorBuilder<RequestError, RequestErrorBuilderImpl> {

        @Override
        protected RequestErrorBuilderImpl self() {
            return this;
        }

        @Override
        public RequestError build() {
            return new RequestError(this);
        }
    }
}
