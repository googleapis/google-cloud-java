package com.google.gcloud;


import com.google.api.client.googleapis.compute.ComputeCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Set;

public abstract class ServiceOptions {

  private static final String DEFAULT_HOST = "https://www.googleapis.com";

  private final String host;
  private final HttpTransport httpTransport;
  private final HttpRequestInitializer httpRequestInitializer;

  protected ServiceOptions(Builder builder) {
    host = MoreObjects.firstNonNull(builder.host, DEFAULT_HOST);
    httpTransport = MoreObjects.firstNonNull(builder.httpTransport, getDefaultHttpTransport());
    httpRequestInitializer = builder.httpRequestInitializer;
  }

  private static HttpTransport getDefaultHttpTransport() {
    try {
      NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
      // Try to connect using Google Compute Engine service account credentials.
      ComputeCredential credential = new ComputeCredential(transport, new JacksonFactory());
      // Force token refresh to detect if we are running on Google Compute Engine.
      credential.refreshToken();
      return credential.getTransport();
    } catch (IOException | GeneralSecurityException e) {
      return new NetHttpTransport();
    }
  }

  protected abstract static class Builder {

    private String host;
    private HttpTransport httpTransport;
    private HttpRequestInitializer httpRequestInitializer;
    private PrivateKey privateKey;

    public Builder() {}

    protected Builder(ServiceOptions options) {
      host = options.host;
      httpTransport = options.httpTransport;
      httpRequestInitializer = options.httpRequestInitializer;
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

    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      // TODO: replace HttpRequestInitializer with CrendentialProvider - 2 subclasses
      // one that is set with HttpRequestInitializer (and another that is set
      // with both private key and service account)
      // Also, consider instead of HttpRequestIntializer option to have "AppEngine" option
      // which will use reflection to create HttpRequestInitializer
      Preconditions.checkArgument(
          privateKey == null, "Can't set both PrivateKey and HttpRequestInitializer");
      this.httpRequestInitializer = httpRequestInitializer;
      return this;
    }

    public Builder setPrivateKey(PrivateKey privateKey) {
      Preconditions.checkArgument(
          httpRequestInitializer == null, "Can't set both PrivateKey and HttpRequestInitializer");
      this.privateKey = privateKey;
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

  public HttpRequestInitializer getHttpRequestInitializer() {
    return httpRequestInitializer;
  }
}
