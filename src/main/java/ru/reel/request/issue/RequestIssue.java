package ru.reel.request.issue;


import ru.reel.request.error.message.ErrorMessageFactory;

public abstract class RequestIssue {
    protected String message;

    public String getMessage() {
        return this.message;
    }

    public RequestIssue(RequestIssueBuilder<?, ?> builder) {
        this.message = builder.message;
    }

    public abstract static class RequestIssueBuilder<C, B extends RequestIssueBuilder<C, B>> {
        protected String message;

        public B customMessage(String message) {
            this.message = message;
            return self();
        }

        protected abstract B self();
        public abstract C build();
    }
}
