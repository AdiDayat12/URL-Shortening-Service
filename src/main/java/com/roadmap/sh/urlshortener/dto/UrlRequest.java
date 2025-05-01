package com.roadmap.sh.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlRequest {
    @URL(message = "Invalid URL")
    private String og_url;
}
