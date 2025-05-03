package com.roadmap.sh.urlshortener.controller;

import com.roadmap.sh.urlshortener.dto.ResponseAPI;
import com.roadmap.sh.urlshortener.dto.UrlRequest;
import com.roadmap.sh.urlshortener.entity.Url;
import com.roadmap.sh.urlshortener.service.UrlService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/shorten")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController (UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<ResponseAPI<Url>> save (@Valid @RequestBody UrlRequest request){
        Url savedUrl = urlService.save(request);
        return ResponseEntity.ok().body(ResponseAPI.<Url>builder()
                        .code(201)
                        .message("Created")
                        .data(savedUrl)
                .build());
    }

    @GetMapping("/info/{shortCode}")
    public ResponseEntity<ResponseAPI<Url>> find (@PathVariable String shortCode){
        Url url = urlService.getByShortCode(shortCode);
        return ResponseEntity.ok().body(
                ResponseAPI.<Url>builder()
                        .code(200)
                        .message("Url found successfully")
                        .data(url)
                        .build()
        );
    }

    @PutMapping("/{shortCode}")
    public ResponseEntity<ResponseAPI<Url>> update (@Valid @RequestBody UrlRequest request, @PathVariable String shortCode){
        Url url = urlService.update(request, shortCode);
        return ResponseEntity.ok().body(ResponseAPI.<Url>builder()
                        .code(200)
                        .message("Updated Successfully")
                        .data(url)
                .build());
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Void> delete (@PathVariable String shortCode){
        urlService.delete(shortCode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect (@PathVariable String shortCode){
        Url url = urlService.getByShortCodeAndIncrement(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url.getOriginalUrl()))
                .build();
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<ResponseAPI<Url>> getClickCount(@PathVariable String shortCode) {
        Url url = urlService.getByShortCode(shortCode);
        return ResponseEntity.ok().body(ResponseAPI.<Url>builder()
                        .code(200)
                        .message("Success")
                        .data(url)
                .build());
    }

}
