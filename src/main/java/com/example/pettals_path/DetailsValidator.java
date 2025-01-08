package com.example.pettals_path;

public class DetailsValidator {

    public static final String EMAIL_PATTERN="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    public static final String PHONE_PATTERN="^\\d{10}$";

    public static boolean isEmailValid(String email){
        return email.matches(EMAIL_PATTERN);
    }
    public static boolean isPhoneValid(String phone){
        return phone.matches(PHONE_PATTERN);
    }

}
