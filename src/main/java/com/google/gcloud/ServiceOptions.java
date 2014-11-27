package com.google.gcloud;


import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.Set;

public abstract class ServiceOptions {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";

  private final String host;
  private final HttpTransport httpTransport;
  private final AuthConfig authConfig;

  protected ServiceOptions(Builder builder) {
    host = firstNonNull(builder.host, DEFAULT_HOST);
    httpTransport = firstNonNull(builder.httpTransport, getDefaultHttpTransport());
    authConfig = firstNonNull(builder.authConfig, getDefaultAuthConfig());
  }

  private static HttpTransport getDefaultHttpTransport() {
    // Consider App Engine
    if (getAppEngineAppId() != null) {
      try {
        return new UrlFetchTransport();
      } catch (Exception ignore) {
        // Maybe not on App Engine
      }
    }
    // Consider Compute
    try {
      return AuthConfig.getComputeCredential().getTransport();
    } catch (Exception e) {
      // Maybe not on GCE
    }
    return new NetHttpTransport();
  }

  private static AuthConfig getDefaultAuthConfig() {
    // Consider App Engine
    if (getAppEngineAppId() != null) {
      try {
        return AuthConfig.createForAppEngine();
      } catch (Exception ignore) {
        // Maybe not on App Engine
      }
    }
    // Consider Compute
    try {
      return AuthConfig.createForComputeEngine();
    } catch (Exception ignore) {
      // Maybe not on GCE
    }
    return AuthConfig.createForAccount(null, null);
  }

  protected static String getAppEngineAppId() {
    return System.getProperty("com.google.appengine.application.id");
  }

  protected abstract static class Builder {

    private String host;
    private HttpTransport httpTransport;
    private AuthConfig authConfig;

    public Builder() {}

    protected Builder(ServiceOptions options) {
      host = options.host;
      httpTransport = options.httpTransport;
      authConfig = options.authConfig;
    }

    protected abstract ServiceOptions build();

    public Builder host(String host) {
      this.host = host;
      return this;
    }

    public Builder httpTransport(HttpTransport httpTransport) {
      this.httpTransport = httpTransport;
      return this;
    }

    public Builder authConfig(AuthConfig authConfig) {
      this.authConfig = authConfig;
      return this;
    }
  }

  protected abstract Set<String> getScopes();

  public String getHost() {
    return host;
  }

  public HttpTransport getHttpTransport() {
    return httpTransport;
  }

  public AuthConfig getAuthConfig() {
    return authConfig;
  }
}
