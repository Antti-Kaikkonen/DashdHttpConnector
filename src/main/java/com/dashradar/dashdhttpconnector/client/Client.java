package com.dashradar.dashdhttpconnector.client;

import com.dashradar.dashdhttpconnector.dto.BlockDTO;
import com.dashradar.dashdhttpconnector.dto.MempoolInfoDTO;
import com.dashradar.dashdhttpconnector.dto.MempoolTransactionDTO;
import com.dashradar.dashdhttpconnector.dto.TransactionDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    
    public List<String> getRawMempool() throws IOException {
        String method = "getrawmempool";
        TypeReference<StandardResponse<List<String>>> tr = new TypeReference<StandardResponse<List<String>>>() {
        };
        StandardResponse<List<String>> response = dashConnector.post(new DashJsonRpcRequest(method, false), tr);
        return response.getResult();
    }
    
    public Map<String, MempoolTransactionDTO> getRawMempoolDetailed() throws IOException {
        String method = "getrawmempool";
        TypeReference<StandardResponse<Map<String, MempoolTransactionDTO>>> tr = new TypeReference<StandardResponse<Map<String, MempoolTransactionDTO>>>() {
        };
        StandardResponse<Map<String, MempoolTransactionDTO>> response = dashConnector.post(new DashJsonRpcRequest(method, true), tr);
        return response.getResult();
    }
    
    public MempoolInfoDTO getMempoolInfo() throws IOException {
        String method = "getmempoolinfo";
        TypeReference<StandardResponse<MempoolInfoDTO>> tr = new TypeReference<StandardResponse<MempoolInfoDTO>>() {
        };
        StandardResponse<MempoolInfoDTO> response = dashConnector.post(new DashJsonRpcRequest(method), tr);
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
