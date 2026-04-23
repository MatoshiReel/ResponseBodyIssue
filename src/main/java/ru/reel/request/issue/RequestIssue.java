package ru.reel.request.issue;


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

        protected abstract B self();
        public abstract C build();
    }
}
