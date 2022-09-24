package com.example.course.Infrastructure.exception;


import java.util.Date;


public class ExceptionDetail {
    private Date timestamp;
    private String message;
    private String detal;

    public ExceptionDetail(Date timestamp, String message, String detal) {
        this.timestamp = timestamp;
        this.message = message;
        this.detal = detal;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetal() {
        return detal;
    }

    public void setDetal(String detal) {
        this.detal = detal;
    }
}
