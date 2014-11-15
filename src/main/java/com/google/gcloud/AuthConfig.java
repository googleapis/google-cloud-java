package com.google.gcloud;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import java.security.PrivateKey;
import java.util.Set;

public abstract class AuthConfig {

  protected abstract HttpRequestInitializer getHttpRequestInitializer(
      HttpTransport transport, Set<String> scopes);


  public static AuthConfig createForAppEngine() {
    return new AppEngineAuthConfig();
  }

  public static AuthConfig createForAccount(String account, PrivateKey privateKey) {
    return new ServiceAccountAuthConfig(account, privateKey);
  }

  private static class AppEngineAuthConfig extends AuthConfig {

    @Override
    protected HttpRequestInitializer getHttpRequestInitializer(
        HttpTransport transport, Set<String> scopes) {
      return new AppIdentityCredential(scopes);
    }
  }

  private static class ServiceAccountAuthConfig extends AuthConfig {

    private final String account;
    private final PrivateKey privateKey;

    public ServiceAccountAuthConfig(String account, PrivateKey privateKey) {
      this.account = account;
      this.privateKey = privateKey;
    }

    @Override
    protected HttpRequestInitializer getHttpRequestInitializer(
        HttpTransport transport, Set<String> scopes) {
      return new GoogleCredential.Builder()
        .setTransport(transport)
        .setJsonFactory(new JacksonFactory())
        .setServiceAccountId(account)
        .setServiceAccountScopes(scopes)
        .setServiceAccountPrivateKey(privateKey)
        .build();
    }
  }
}
