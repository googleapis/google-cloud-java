package com.google.gcloud;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.compute.ComputeCredential;
import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Set;

public abstract class AuthConfig {

  private static class AppEngineAuthConfig extends AuthConfig {

    @Override
    protected HttpRequestInitializer httpRequestInitializer(
        HttpTransport transport, Set<String> scopes) {
      return new AppIdentityCredential(scopes);
    }
  }

  private static class ServiceAccountAuthConfig extends AuthConfig {

    private final String account;
    private final PrivateKey privateKey;

    ServiceAccountAuthConfig(String account, PrivateKey privateKey) {
      this.account = checkNotNull(account);
      this.privateKey = checkNotNull(privateKey);
    }

    ServiceAccountAuthConfig() {
      account = null;
      privateKey = null;
    }

    @Override
    protected HttpRequestInitializer httpRequestInitializer(
        HttpTransport transport, Set<String> scopes) {
      GoogleCredential.Builder builder = new GoogleCredential.Builder()
          .setTransport(transport)
          .setJsonFactory(new JacksonFactory());
      if (privateKey != null) {
        builder.setServiceAccountPrivateKey(privateKey);
        builder.setServiceAccountId(account);
        builder.setServiceAccountScopes(scopes);
      }
      return builder.build();
    }
  }

  protected abstract HttpRequestInitializer httpRequestInitializer(
      HttpTransport transport, Set<String> scopes);


  public static AuthConfig createForAppEngine() {
    return new AppEngineAuthConfig();
  }

  public static AuthConfig createForComputeEngine() throws IOException, GeneralSecurityException {
    final ComputeCredential cred = getComputeCredential();
    return new AuthConfig() {
      @Override
      protected HttpRequestInitializer httpRequestInitializer(HttpTransport ts, Set<String> sc) {
        return cred;
      }
    };
  }

  public static AuthConfig createFor(String account, PrivateKey privateKey) {
    return new ServiceAccountAuthConfig(account, privateKey);
  }

  public static AuthConfig noCredentials() {
    return new ServiceAccountAuthConfig();
  }

  static ComputeCredential getComputeCredential() throws IOException, GeneralSecurityException {
    NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
    // Try to connect using Google Compute Engine service account credentials.
    ComputeCredential credential = new ComputeCredential(transport, new JacksonFactory());
    // Force token refresh to detect if we are running on Google Compute Engine.
    credential.refreshToken();
    return credential;
  }
}
