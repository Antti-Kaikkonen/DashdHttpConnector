package com.dashradar.dashdhttpconnector.client;

import java.util.Arrays;
import java.util.List;

public class DashJsonRpcRequest {

    private final String method;

    private final List<Object> params;

    public DashJsonRpcRequest(String method, Object... params) {
        this.method = method;
        this.params = Arrays.asList(params);
    }

    public String getMethod() {
        return method;
    }

    public List<Object> getParams() {
        return params;
    }

}
