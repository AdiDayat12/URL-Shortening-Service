package com.roadmap.sh.urlshortener.repo;

import com.roadmap.sh.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepo extends JpaRepository<Url, Long> {
    Optional<Url> findByShortCode(String shortCode);
}
