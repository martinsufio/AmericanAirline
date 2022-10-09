package com.example.americanairline;

import java.util.List;

public class  Responsepayload {
    private String message;
    private List<ReturnedMerchant> returnedMerchants;

    public String getMessage() {
        return message;
    }

    public List<ReturnedMerchant> getReturnedMerchants() {
        return returnedMerchants;
    }

    public void setReturnedMerchants(List<ReturnedMerchant> returnedMerchants) {
        this.returnedMerchants = returnedMerchants;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
