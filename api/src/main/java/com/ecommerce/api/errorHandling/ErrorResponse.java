package com.ecommerce.api.errorHandling;

import java.util.List;

public class ErrorResponse {
    private String message;
    private String statusCode;
    private List<String> details;

    public ErrorResponse(String message, String statusCode, List<String> details) {
        this.message = message;
        this.statusCode = statusCode;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
