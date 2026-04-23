package ru.reel.request.error;

public class RequestParamError extends RequestError {
    protected String param;

    public String getParam() {
        return param;
    }

    public RequestParamError(RequestParamErrorBuilder<?, ?> builder) {
        super(builder);
        this.param = builder.param;
    }

    public static RequestParamErrorBuilder<?, ?> builder() {
        return new RequestParamErrorBuilderImpl();
    }

    public abstract static class RequestParamErrorBuilder<C extends RequestParamError, B extends RequestParamErrorBuilder<C, B>> extends RequestErrorBuilder<C, B> {
        protected String param;

        public B param(String param) {
            this.param = param;
            return self();
        }

        @Override
        public abstract C build();
    }

    private static class RequestParamErrorBuilderImpl extends RequestParamErrorBuilder<RequestParamError, RequestParamErrorBuilderImpl> {

        @Override
        protected RequestParamErrorBuilderImpl self() {
            return this;
        }

        @Override
        public RequestParamError build() {
            return new RequestParamError(this);
        }
    }
}
