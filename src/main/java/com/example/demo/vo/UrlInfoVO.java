package com.example.demo.vo;

public class UrlInfoVO {

    private String reqUrl;

    private String resUrl;

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

    @Override
    public String toString() {
        return "UrlInfoVO{" +
                "reqUrl='" + reqUrl + '\'' +
                ", resUrl='" + resUrl + '\'' +
                '}';
    }
}
