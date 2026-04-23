package ru.reel.request.error;

public class RequestFieldError extends RequestError {
    protected String field;

    public String getField() {
        return field;
    }

    public RequestFieldError(RequestFieldErrorBuilder<?, ?> builder) {
        super(builder);
        this.field = builder.field;
    }

    public static RequestFieldErrorBuilder<?, ?> builder() {
        return new RequestFieldErrorBuilderImpl();
    }

    public abstract static class RequestFieldErrorBuilder<C extends RequestFieldError, B extends RequestFieldErrorBuilder<C, B>> extends RequestErrorBuilder<C, B> {
        protected String field;

        public B field(String field) {
            this.field = field;
            return self();
        }

        @Override
        public abstract C build();
    }

    private static class RequestFieldErrorBuilderImpl extends RequestFieldErrorBuilder<RequestFieldError, RequestFieldErrorBuilderImpl> {

        @Override
        protected RequestFieldErrorBuilderImpl self() {
            return this;
        }

        @Override
        public RequestFieldError build() {
            return new RequestFieldError(this);
        }
    }
}
