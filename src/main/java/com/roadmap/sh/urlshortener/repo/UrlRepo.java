package com.roadmap.sh.urlshortener.repo;

import com.roadmap.sh.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<Url, Long> {
}
