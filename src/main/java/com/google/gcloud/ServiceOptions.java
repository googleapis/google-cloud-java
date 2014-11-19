package com.google.gcloud;


import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.googleapis.compute.ComputeCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
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
      return getComputeCredential().getTransport();
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
      final ComputeCredential cred = getComputeCredential();
      return new AuthConfig() {
        @Override protected HttpRequestInitializer getHttpRequestInitializer(
            HttpTransport transport, Set<String> scopes) {
          return cred;
        }
      };
    } catch (Exception ignore) {
      // Maybe not on GCE
    }
    return AuthConfig.createForAccount(null, null);
  }

  protected static String getAppEngineAppId() {
    return System.getProperty("com.google.appengine.application.id");
  }

  private static ComputeCredential getComputeCredential()
      throws IOException, GeneralSecurityException {
    NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    // Try to connect using Google Compute Engine service account credentials.
    ComputeCredential credential = new ComputeCredential(transport, new JacksonFactory());
    // Force token refresh to detect if we are running on Google Compute Engine.
    credential.refreshToken();
    return credential;
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

    public Builder setHost(String host) {
      this.host = host;
      return this;
    }

    public Builder setHttpTransport(HttpTransport httpTransport) {
      this.httpTransport = httpTransport;
      return this;
    }

    public Builder setAuthConfig(AuthConfig authConfig) {
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
