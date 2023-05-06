package com.myprojects.demo.rest;

public class StudentErrorResponse {
    private int status;
    private String messange;

    private long timeStamp;
    public StudentErrorResponse(){}

    public StudentErrorResponse(int status, String messange, long timeStamp) {
        this.status = status;
        this.messange = messange;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessange() {
        return messange;
    }

    public void setMessange(String messange) {
        this.messange = messange;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
