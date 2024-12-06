package org.dilan.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CacheScheduler {

  private final RestTemplate restTemplate;

  @Value("${cache.service.url}")
  private String cacheServiceUrl;

  @Scheduled(cron = "0 0 2 * * ?")
  public void clearCacheScheduled() {
    try {
      restTemplate.delete(cacheServiceUrl);
      System.out.println("Cache cleared successfully: " + cacheServiceUrl);
    } catch (Exception e) {
      System.out.println("Error while clearing cache: " + e.getMessage());
    }
  }
}
