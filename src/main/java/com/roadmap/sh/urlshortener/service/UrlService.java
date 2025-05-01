package com.roadmap.sh.urlshortener.service;

import com.roadmap.sh.urlshortener.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    @Autowired
    private UrlRepo urlRepo;

    public UrlService (UrlRepo urlRepo){
        this.urlRepo = urlRepo;
    }


}
