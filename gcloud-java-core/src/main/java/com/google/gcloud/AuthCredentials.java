/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Objects;
import java.util.Set;

/**
 * Credentials for accessing Google Cloud services.
 */
public abstract class AuthCredentials implements Restorable<AuthCredentials> {

  private static class AppEngineAuthCredentials extends AuthCredentials {

    private static final AuthCredentials INSTANCE = new AppEngineAuthCredentials();
    private static final AppEngineAuthCredentialsState STATE =
        new AppEngineAuthCredentialsState();

    private static class AppEngineAuthCredentialsState
        implements RestorableState<AuthCredentials>, Serializable {

      private static final long serialVersionUID = 3558563960848658928L;

      @Override
      public AuthCredentials restore() {
        return INSTANCE;
      }

      @Override
      public int hashCode() {
        return getClass().getName().hashCode();
      }

      @Override
      public boolean equals(Object obj) {
        return obj instanceof AppEngineAuthCredentialsState;
      }
    }

    @Override
    protected HttpRequestInitializer httpRequestInitializer(HttpTransport transport,
        Set<String> scopes) {
      return new AppIdentityCredential(scopes);
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return STATE;
    }
  }

  public static class ServiceAccountAuthCredentials extends AuthCredentials {

    private final String account;
    private final PrivateKey privateKey;

    private static final AuthCredentials NO_CREDENTIALS = new ServiceAccountAuthCredentials();

    private static class ServiceAccountAuthCredentialsState
        implements RestorableState<AuthCredentials>, Serializable {

      private static final long serialVersionUID = -7302180782414633639L;

      private final String account;
      private final PrivateKey privateKey;

      private ServiceAccountAuthCredentialsState(String account, PrivateKey privateKey) {
        this.account = account;
        this.privateKey = privateKey;
      }

      @Override
      public AuthCredentials restore() {
        if (account == null && privateKey == null) {
          return NO_CREDENTIALS;
        }
        return new ServiceAccountAuthCredentials(account, privateKey);
      }

      @Override
      public int hashCode() {
        return Objects.hash(account, privateKey);
      }

      @Override
      public boolean equals(Object obj) {
        if (!(obj instanceof ServiceAccountAuthCredentialsState)) {
          return false;
        }
        ServiceAccountAuthCredentialsState other = (ServiceAccountAuthCredentialsState) obj;
        return Objects.equals(account, other.account)
            && Objects.equals(privateKey, other.privateKey);
      }
    }

    ServiceAccountAuthCredentials(String account, PrivateKey privateKey) {
      this.account = checkNotNull(account);
      this.privateKey = checkNotNull(privateKey);
    }

    ServiceAccountAuthCredentials() {
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

    public String account() {
      return account;
    }

    public PrivateKey privateKey() {
      return privateKey;
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return new ServiceAccountAuthCredentialsState(account, privateKey);
    }
  }

  private static class ComputeEngineAuthCredentials extends AuthCredentials {

    private ComputeCredential computeCredential;

    private static final ComputeEngineAuthCredentialsState STATE =
        new ComputeEngineAuthCredentialsState();

    private static class ComputeEngineAuthCredentialsState
        implements RestorableState<AuthCredentials>, Serializable {

      private static final long serialVersionUID = -6168594072854417404L;

      @Override
      public AuthCredentials restore() {
        try {
          return new ComputeEngineAuthCredentials();
        } catch (IOException | GeneralSecurityException e) {
          throw new IllegalStateException(
              "Could not restore " + ComputeEngineAuthCredentials.class.getSimpleName(), e);
        }
      }

      @Override
      public int hashCode() {
        return getClass().getName().hashCode();
      }

      @Override
      public boolean equals(Object obj) {
        return obj instanceof ComputeEngineAuthCredentialsState;
      }
    }

    ComputeEngineAuthCredentials() throws IOException, GeneralSecurityException {
      computeCredential = getComputeCredential();
    }

    @Override
    protected HttpRequestInitializer httpRequestInitializer(HttpTransport transport,
        Set<String> scopes) {
      return computeCredential;
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return STATE;
    }
  }

  public static class ApplicationDefaultAuthCredentials extends AuthCredentials {

    private GoogleCredentials googleCredentials;

    private static final ApplicationDefaultAuthCredentialsState STATE =
        new ApplicationDefaultAuthCredentialsState();

    private static class ApplicationDefaultAuthCredentialsState
        implements RestorableState<AuthCredentials>, Serializable {

      private static final long serialVersionUID = -8839085552021212257L;

      @Override
      public AuthCredentials restore() {
        try {
          return new ApplicationDefaultAuthCredentials();
        } catch (IOException e) {
          throw new IllegalStateException(
              "Could not restore " + ApplicationDefaultAuthCredentials.class.getSimpleName(), e);
        }
      }

      @Override
      public int hashCode() {
        return getClass().getName().hashCode();
      }

      @Override
      public boolean equals(Object obj) {
        return obj instanceof ApplicationDefaultAuthCredentialsState;
      }
    }

    ApplicationDefaultAuthCredentials() throws IOException {
      googleCredentials = GoogleCredentials.getApplicationDefault();
    }

    @Override
    protected HttpRequestInitializer httpRequestInitializer(HttpTransport transport,
        Set<String> scopes) {
      return new HttpCredentialsAdapter(googleCredentials.createScoped(scopes));
    }

    public ServiceAccountAuthCredentials toServiceAccountCredentials() {
      if (googleCredentials instanceof ServiceAccountCredentials) {
        ServiceAccountCredentials credentials = (ServiceAccountCredentials) googleCredentials;
        return new ServiceAccountAuthCredentials(credentials.getClientEmail(),
            credentials.getPrivateKey());
      }
      return null;
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return STATE;
    }
  }

  protected abstract HttpRequestInitializer httpRequestInitializer(HttpTransport transport,
      Set<String> scopes);

  public static AuthCredentials createForAppEngine() {
    return AppEngineAuthCredentials.INSTANCE;
  }

  public static AuthCredentials createForComputeEngine()
      throws IOException, GeneralSecurityException {
    return new ComputeEngineAuthCredentials();
  }

  /**
   * Returns the Application Default Credentials.
   *
   * <p>Returns the Application Default Credentials which are credentials that identify and
   * authorize the whole application. This is the built-in service account if running on
   * Google Compute Engine or the credentials file can be read from the path in the environment
   * variable GOOGLE_APPLICATION_CREDENTIALS.
   * </p>
   *
   * @return the credentials instance.
   * @throws IOException if the credentials cannot be created in the current environment.
   */
  public static AuthCredentials createApplicationDefaults() throws IOException {
    return new ApplicationDefaultAuthCredentials();
  }

  /**
   * Creates Service Account Credentials given an account id and a private key.
   *
   * <p>For details on how to obtain Service Account Credentials see
   * <a href="https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts">Service
   * Account Authentication</a>.
   * </p>
   *
   * @param account id of the Service Account
   * @param privateKey private key associated to the account
   * @return the credentials instance.
   */
  public static ServiceAccountAuthCredentials createFor(String account, PrivateKey privateKey) {
    return new ServiceAccountAuthCredentials(account, privateKey);
  }

  /**
   * Creates Service Account Credentials given a stream for credentials in JSON format.
   *
   * <p>For details on how to obtain Service Account Credentials in JSON format see
   * <a href="https://cloud.google.com/storage/docs/authentication?hl=en#service_accounts">Service
   * Account Authentication</a>.
   * </p>
   *
   * @param jsonCredentialStream stream for Service Account Credentials in JSON format
   * @return the credentials instance.
   * @throws IOException if the credentials cannot be created from the stream.
   */
  public static ServiceAccountAuthCredentials createForJson(InputStream jsonCredentialStream)
      throws IOException {
    GoogleCredential tempCredentials = GoogleCredential.fromStream(jsonCredentialStream);
    return new ServiceAccountAuthCredentials(tempCredentials.getServiceAccountId(),
        tempCredentials.getServiceAccountPrivateKey());
  }

  public static AuthCredentials noCredentials() {
    return ServiceAccountAuthCredentials.NO_CREDENTIALS;
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
