package com.roadmap.sh.urlshortener.controller;

import com.roadmap.sh.urlshortener.dto.UrlRequest;
import com.roadmap.sh.urlshortener.entity.Url;
import com.roadmap.sh.urlshortener.service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class UrlFormController {

    private final UrlService urlService;

    public UrlFormController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/form")
    public String handleSubmitForm (@RequestParam("url") String url, Model model){
        UrlRequest urlRequest = new UrlRequest(url);
        Url savedUrl = urlService.save(urlRequest);
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String shortenedUrl = baseUrl + "/shorten/" + savedUrl.getShortCode();

//        String shortenedUrl = "http://localhost:8080/shorten/" + savedUrl.getShortCode();
        model.addAttribute("shortenedUrl", shortenedUrl);
        return "form";
    }
}
