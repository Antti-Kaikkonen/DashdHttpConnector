package com.dashradar.dashdhttpconnector.dto;

import java.math.BigDecimal;
import java.util.List;

public class TransactionDTO {

    private long locktime;

    private long size;

    private String txid;

    private int version;

    private List<VIn> vin;

    private List<VOut> vout;

    public long getLocktime() {
        return locktime;
    }

    public void setLocktime(long locktime) {
        this.locktime = locktime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<VIn> getVin() {
        return vin;
    }

    public void setVin(List<VIn> vin) {
        this.vin = vin;
    }

    public List<VOut> getVout() {
        return vout;
    }

    public void setVout(List<VOut> vout) {
        this.vout = vout;
    }

    public static class VIn {

        String coinbase;//Only for first transaction

        ScriptSig scriptSig;

        long sequence;

        String txid;

        int vout;

        public String getCoinbase() {
            return coinbase;
        }

        public void setCoinbase(String coinbase) {
            this.coinbase = coinbase;
        }

        public ScriptSig getScriptSig() {
            return scriptSig;
        }

        public void setScriptSig(ScriptSig scriptSig) {
            this.scriptSig = scriptSig;
        }

        public long getSequence() {
            return sequence;
        }

        public void setSequence(long sequence) {
            this.sequence = sequence;
        }

        public String getTxid() {
            return txid;
        }

        public void setTxid(String txid) {
            this.txid = txid;
        }

        public int getVout() {
            return vout;
        }

        public void setVout(int vout) {
            this.vout = vout;
        }

        public static class ScriptSig {

            String asm;

            String hex;

            public String getAsm() {
                return asm;
            }

            public void setAsm(String asm) {
                this.asm = asm;
            }

            public String getHex() {
                return hex;
            }

            public void setHex(String hex) {
                this.hex = hex;
            }

        }

    }

    public static class VOut {

        int n;

        ScriptPubKey scriptPubKey;

        BigDecimal value;

        long valueSat;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public ScriptPubKey getScriptPubKey() {
            return scriptPubKey;
        }

        public void setScriptPubKey(ScriptPubKey scriptPubKey) {
            this.scriptPubKey = scriptPubKey;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public long getValueSat() {
            return valueSat;
        }

        public void setValueSat(long valueSat) {
            this.valueSat = valueSat;
        }

        public static class ScriptPubKey {

            String[] addresses;

            String asm;

            String hex;

            int reqSigs;

            String type;

            public String[] getAddresses() {
                return addresses;
            }

            public void setAddresses(String[] addresses) {
                this.addresses = addresses;
            }

            public String getAsm() {
                return asm;
            }

            public void setAsm(String asm) {
                this.asm = asm;
            }

            public String getHex() {
                return hex;
            }

            public void setHex(String hex) {
                this.hex = hex;
            }

            public int getReqSigs() {
                return reqSigs;
            }

            public void setReqSigs(int reqSigs) {
                this.reqSigs = reqSigs;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

        }

    }

}
