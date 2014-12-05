package com.google.gcloud;


import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.Set;

public abstract class ServiceOptions {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";

  private final String host;
  private final HttpTransport httpTransport;
  private final AuthConfig authConfig;

  protected ServiceOptions(Builder<?> builder) {
    host = firstNonNull(builder.host, DEFAULT_HOST);
    httpTransport = firstNonNull(builder.httpTransport, defaultHttpTransport());
    authConfig = firstNonNull(builder.authConfig, defaultAuthConfig());
  }

  private static HttpTransport defaultHttpTransport() {
    // Consider App Engine
    if (appEngineAppId() != null) {
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

  private static AuthConfig defaultAuthConfig() {
    // Consider App Engine
    if (appEngineAppId() != null) {
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

  protected static String appEngineAppId() {
    return System.getProperty("com.google.appengine.application.id");
  }

  protected abstract static class Builder<B extends Builder<B>> {

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

    @SuppressWarnings("unchecked")
    public B host(String host) {
      this.host = host;
      return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B httpTransport(HttpTransport httpTransport) {
      this.httpTransport = httpTransport;
      return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B authConfig(AuthConfig authConfig) {
      this.authConfig = authConfig;
      return (B) this;
    }
  }

  protected abstract Set<String> scopes();

  public String host() {
    return host;
  }

  public HttpTransport httpTransport() {
    return httpTransport;
  }

  public AuthConfig authConfig() {
    return authConfig;
  }

  protected HttpRequestInitializer httpRequestInitializer() {
    return authConfig().httpRequestInitializer(httpTransport, scopes());
  }
}
