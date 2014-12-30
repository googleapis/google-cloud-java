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
  private final RetryParams retryParams;

  protected ServiceOptions(Builder<?> builder) {
    host = firstNonNull(builder.host, DEFAULT_HOST);
    httpTransport = firstNonNull(builder.httpTransport, defaultHttpTransport());
    authConfig = firstNonNull(builder.authConfig, defaultAuthConfig());
    retryParams = builder.retryParams;
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
    return AuthConfig.noCredentials();
  }

  protected static String appEngineAppId() {
    try {
      Class<?> apiProxy = Class.forName("com.google.apphosting.api.ApiProxy");
      Object currentEnv = apiProxy.getMethod("getCurrentEnvironment").invoke(null);
      return (String) currentEnv.getClass().getMethod("getAppId").invoke(currentEnv);
    } catch (Exception ex) {
      return System.getProperty("com.google.appengine.application.id");
    }
  }

  protected abstract static class Builder<B extends Builder<B>> {

    private String host;
    private HttpTransport httpTransport;
    private AuthConfig authConfig;
    private RetryParams retryParams;

    protected Builder() {}

    protected Builder(ServiceOptions options) {
      host = options.host;
      httpTransport = options.httpTransport;
      authConfig = options.authConfig;
      retryParams = options.retryParams;
    }

    protected abstract ServiceOptions build();

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public B host(String host) {
      this.host = host;
      return self();
    }

    public B httpTransport(HttpTransport httpTransport) {
      this.httpTransport = httpTransport;
      return self();
    }

    public B authConfig(AuthConfig authConfig) {
      this.authConfig = authConfig;
      return self();
    }

    public B retryParams(RetryParams retryParams) {
      this.retryParams = retryParams;
      return self();
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

  public RetryParams retryParams() {
    return retryParams;
  }

  protected HttpRequestInitializer httpRequestInitializer() {
    return authConfig().httpRequestInitializer(httpTransport, scopes());
  }

  public abstract Builder<?> toBuilder();
}
