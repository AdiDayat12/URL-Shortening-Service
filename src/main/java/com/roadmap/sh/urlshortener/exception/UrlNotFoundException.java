package com.roadmap.sh.urlshortener.exception;

public class UrlNotFoundException extends RuntimeException {
    public UrlNotFoundException (String shortCode){
        super("Url with short code: " + shortCode + " is not found");
    }
}
