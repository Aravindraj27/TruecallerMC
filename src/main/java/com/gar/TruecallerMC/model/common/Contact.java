package com.gar.TruecallerMC.model.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private String countryCode;
    private String mobileNumber;
    private String email;

    public Contact(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Contact(String mobileNumber, String email) {
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public Contact(String countryCode, String mobileNumber, String email) {
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
}
