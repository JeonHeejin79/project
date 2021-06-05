package com.example.demo.vo;

public class UrlInfoVO {

    private String reqUrl;  // shortening req url

    private String resUrl; // shortening res url

    private String reqRedirectUrl; // page req url

    private String resRedirectUrl; // page res url

    private int equalsReqUrlCnt;

    public UrlInfoVO() {
        this.equalsReqUrlCnt = 1;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public int getEqualsReqUrlCnt() {
        return equalsReqUrlCnt;
    }

    public void setEqualsReqUrlCnt(int equalsReqUrlCnt) {
        this.equalsReqUrlCnt = equalsReqUrlCnt;
    }

    public String getReqRedirectUrl() {
        return reqRedirectUrl;
    }

    public void setReqRedirectUrl(String reqRedirectUrl) {
        this.reqRedirectUrl = reqRedirectUrl;
    }

    public String getResRedirectUrl() {
        return resRedirectUrl;
    }

    public void setResRedirectUrl(String resRedirectUrl) {
        this.resRedirectUrl = resRedirectUrl;
    }

    @Override
    public String toString() {
        return "UrlInfoVO{" +
                "reqUrl='" + reqUrl + '\'' +
                ", resUrl='" + resUrl + '\'' +
                ", reqRedirectUrl='" + reqRedirectUrl + '\'' +
                ", resRedirectUrl='" + resRedirectUrl + '\'' +
                ", equalsReqUrlCnt=" + equalsReqUrlCnt +
                '}';
    }
}
