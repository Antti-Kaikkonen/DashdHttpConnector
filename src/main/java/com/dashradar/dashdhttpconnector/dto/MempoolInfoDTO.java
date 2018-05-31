package com.dashradar.dashdhttpconnector.dto;

public class MempoolInfoDTO {
    
    long size;//number of transactions in mempool
    long bytes;
    long usage;
    long maxmempool;
    double mempoolminfee;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getBytes() {
        return bytes;
    }

    public void setBytes(long bytes) {
        this.bytes = bytes;
    }

    public long getUsage() {
        return usage;
    }

    public void setUsage(long usage) {
        this.usage = usage;
    }

    public long getMaxmempool() {
        return maxmempool;
    }

    public void setMaxmempool(long maxmempool) {
        this.maxmempool = maxmempool;
    }

    public double getMempoolminfee() {
        return mempoolminfee;
    }

    public void setMempoolminfee(double mempoolminfee) {
        this.mempoolminfee = mempoolminfee;
    }
    
}
