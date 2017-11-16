package com.akshaybahadur21.iCoin;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ICoin {

    private int index;
    private String timestamp;
    private String data;
    private String previousHash;
    private String hash;

    public ICoin() { }

    public ICoin(int index, String data, String previousHash, String timestamp) {
        super();
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.hash=CreateHash();
    }

    public int getIndex() {
        return index;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getData() {
        return data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public void setData(String data) {
        this.data = data;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String CreateHash() {
        String originalString=getTimestamp()+getData()+getPreviousHash();
        String hash = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();
        return hash;
    }
}
