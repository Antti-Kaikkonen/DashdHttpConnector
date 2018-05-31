package com.dashradar.dashdhttpconnector.dto;

import java.util.List;

public class MempoolTransactionDTO {
    
    long size;
    double fee;
    double modifiedfee;
    long time;
    long height;
    double startingpriority;
    double currentpriority;
    long descendantcount;
    long descendantsize;
    long descendantfees;//fee in satoshis
    List<String> depends;//list of txids

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getModifiedfee() {
        return modifiedfee;
    }

    public void setModifiedfee(double modifiedfee) {
        this.modifiedfee = modifiedfee;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public double getStartingpriority() {
        return startingpriority;
    }

    public void setStartingpriority(double startingpriority) {
        this.startingpriority = startingpriority;
    }

    public double getCurrentpriority() {
        return currentpriority;
    }

    public void setCurrentpriority(double currentpriority) {
        this.currentpriority = currentpriority;
    }

    public long getDescendantcount() {
        return descendantcount;
    }

    public void setDescendantcount(long descendantcount) {
        this.descendantcount = descendantcount;
    }

    public long getDescendantsize() {
        return descendantsize;
    }

    public void setDescendantsize(long descendantsize) {
        this.descendantsize = descendantsize;
    }

    public long getDescendantfees() {
        return descendantfees;
    }

    public void setDescendantfees(long descendantfees) {
        this.descendantfees = descendantfees;
    }

    public List<String> getDepends() {
        return depends;
    }

    public void setDepends(List<String> depends) {
        this.depends = depends;
    }
    
    
}
