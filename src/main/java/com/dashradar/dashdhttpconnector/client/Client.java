package com.dashradar.dashdhttpconnector.client;

import com.dashradar.dashdhttpconnector.dto.BlockDTO;
import com.dashradar.dashdhttpconnector.dto.TransactionDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

public class Client {

    private final DashConnector dashConnector;

    public Client(DashConnector dashConnector) {
        this.dashConnector = dashConnector;
    }

    public TransactionDTO decodeRawTransaction(String rawTx) throws IOException {
        String method = "decoderawtransaction";
        StandardResponse<TransactionDTO> response = dashConnector.post(new DashJsonRpcRequest(method, rawTx), new TypeReference<StandardResponse<TransactionDTO>>() {
        });
        return response.getResult();
    }

    public BlockDTO getBlock(String blockhash) throws IOException {
        String method = "getblock";
        StandardResponse<BlockDTO> response = dashConnector.post(new DashJsonRpcRequest(method, blockhash), new TypeReference<StandardResponse<BlockDTO>>() {
        });
        return response.getResult();
    }

    public BlockDTO getBlockByHeight(long blockHeight) throws IOException {
        return getBlock(getBlockHash(blockHeight));
    }

    public String getBlockHash(long blockHeight) throws IOException {
        String method = "getblockhash";
        StandardResponse<String> response = dashConnector.post(new DashJsonRpcRequest(method, blockHeight), new TypeReference<StandardResponse<String>>() {
        });
        return response.getResult();
    }

    public String getRawTransaction(String txId) throws IOException {
        String method = "getrawtransaction";
        StandardResponse<String> response = dashConnector.post(new DashJsonRpcRequest(method, txId), new TypeReference<StandardResponse<String>>() {
        });
        return response.getResult();
    }

    public TransactionDTO getTrasactionByTxId(String txId) throws IOException {
        return decodeRawTransaction(getRawTransaction(txId));
    }

}
