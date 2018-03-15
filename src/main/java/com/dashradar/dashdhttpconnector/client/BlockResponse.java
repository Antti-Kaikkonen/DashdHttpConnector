package com.dashradar.dashdhttpconnector.client;

import com.dashradar.dashdhttpconnector.dto.BlockDTO;

public class BlockResponse {

    private StandardError error;

    private String id;

    private BlockDTO result;

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

    public BlockDTO getResult() {
        return result;
    }

    public void setResult(BlockDTO result) {
        this.result = result;
    }

}
