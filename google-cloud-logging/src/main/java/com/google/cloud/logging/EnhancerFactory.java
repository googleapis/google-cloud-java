package com.google.cloud.logging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnhancerFactory {

  public static List<Enhancer> getEnhancers(String resourceType) {
    List<Enhancer> enhancers;
    switch(resourceType) {
      case "gae_app_flex":
        enhancers = new ArrayList<>();
        enhancers.add(new TraceEnhancer());
        break;
      default:
        enhancers = Collections.emptyList();
    }
    return enhancers;
  }
}
