package com.example.americanairline;

public class ApiService {
    private static final String API_BASE_PATH = "https://sandbox.api.mastercard.com/openapis";
    //Below properties will be required for authentication of API calls.
    private static final String CONSUMER_KEY = "jmzgR814rW9OyfpMOLEIcC1TKoqT5hcmodT3JX-Hd79d27d6!d7e5a9ba298143aa8b7e3e4dcad243640000000000000000"; // This refers to your consumer key. Copy it from "Keys" section on your project page in [Mastercard Developers](https://developer.mastercard.com/dashboard)
    private static final String SIGNING_KEY_ALIAS = "keyalias"; // This is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).
    private static final String SIGNING_KEY_FILE_PATH = "C:\\Users\\ufiom\\AndroidStudioProjects\\AmericanAirline\\app\\src\\main\\res\\AA_Rewards-sandbox.p12"; // This refers to .p12 file found in the signing key. Please place .p12 file at ./src/main/resources in the project folder and add classpath for .p12 file.
    private static final String SIGNING_KEY_PASSWORD = "keystorepassword"; // This is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).
}
