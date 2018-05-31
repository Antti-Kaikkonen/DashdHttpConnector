package com.dashradar.dashdhttpconnector.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.URL;

public class DashConnector {

    private static final String REQUEST_METHOD_POST = "POST";

    private String url;

    public DashConnector(String url, String rpcuser, String rpcpassword) {

        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(rpcuser, rpcpassword.toCharArray());
            }
        });

        this.url = url;
        System.out.println("dashconnector url:" + this.url);
    }

    public DashConnector(int port, String rpcuser, String rpcpassword) {
        this("http://localhost:" + port, rpcuser, rpcpassword);
    }

    public DashConnector(String rpcuser, String rpcpassword) {
        this(9998, rpcuser, rpcpassword);
    }

    private HttpURLConnection createConnection() throws MalformedURLException, IOException {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
        return conn;
    }

    private void errorheck(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK && conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
            throw new RuntimeException("Response wasn't ok. " + conn.getResponseMessage());
        }
    }

    private HttpURLConnection post(DashJsonRpcRequest data) throws ProtocolException, IOException {
        HttpURLConnection conn = createConnection();
        conn.setRequestMethod(REQUEST_METHOD_POST);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        conn.setDoOutput(true);
        conn.getOutputStream().write(objectMapper.writeValueAsBytes(data));
        errorheck(conn);
        return conn;
    }

    protected <T> T post(DashJsonRpcRequest request, TypeReference typeRef) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpURLConnection post = post(request);
        return objectMapper.readValue(post.getInputStream(), typeRef);
    }
    
    protected <T> T post(DashJsonRpcRequest request, JavaType type) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        HttpURLConnection post = post(request);
        return objectMapper.readValue(post.getInputStream(), type);
    }

}
