package com.dashradar.dashdhttpconnector.client;

public class StandardResponse<T> {

    private StandardError error;

    private String id;

    private T result;

    public StandardError getError() {
        return error;
    }

    public void setError(StandardError error) {
        this.error = error;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
