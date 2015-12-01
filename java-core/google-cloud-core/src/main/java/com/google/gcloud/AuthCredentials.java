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

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.util.Collection;
import java.util.Objects;

/**
 * Credentials for accessing Google Cloud services.
 */
public abstract class AuthCredentials implements Restorable<AuthCredentials> {

  private static class AppEngineAuthCredentials extends AuthCredentials {

    private static final AuthCredentials INSTANCE = new AppEngineAuthCredentials();
    private static final AppEngineAuthCredentialsState STATE = new AppEngineAuthCredentialsState();

    private static class AppEngineCredentials extends GoogleCredentials {

      private final Object appIdentityService;
      private final Collection<String> scopes;
      private final boolean scopesRequired;

      AppEngineCredentials() {
        try {
          Class<?> factoryClass =
              Class.forName("com.google.appengine.api.appidentity.AppIdentityServiceFactory");
          Method method = factoryClass.getMethod("getAppIdentityService");
          this.appIdentityService = method.invoke(null);
          this.scopes = null;
          this.scopesRequired = true;
        } catch (Exception e) {
          throw new RuntimeException("Could not create AppEngineCredentials using reflection.");
        }
      }

      AppEngineCredentials(Collection<String> scopes, Object appIdentityService) {
          this.appIdentityService = appIdentityService;
          this.scopes = scopes;
          this.scopesRequired = (scopes == null || scopes.isEmpty());
      }

      /**
       * Refresh the access token by getting it from the App Identity service
       */
      @Override
      public AccessToken refreshAccessToken() throws IOException {
        if (createScopedRequired()) {
          throw new IOException("AppEngineCredentials requires createScoped call before use.");
        }
        try {
          Class<?> serviceClass =
              Class.forName("com.google.appengine.api.appidentity.AppIdentityService");
          Class<?> tokenResultClass = Class.forName(
              "com.google.appengine.api.appidentity.AppIdentityService$GetAccessTokenResult");
          Method getAccessTokenResult = serviceClass.getMethod("getAccessToken", Iterable.class);
          Object accessTokenResult = getAccessTokenResult.invoke(appIdentityService, scopes);
          Method getAccessToken = tokenResultClass.getMethod("getAccessToken");
          String accessToken = (String) getAccessToken.invoke(accessTokenResult);
          return new AccessToken(accessToken, null);
        } catch (Exception e) {
          throw new RuntimeException("Could not get the access token using reflection.");
        }
      }

      @Override
      public boolean createScopedRequired() {
        return scopesRequired;
      }

      @Override
      public GoogleCredentials createScoped(Collection<String> scopes) {
        return new AppEngineCredentials(scopes, appIdentityService);
      }
    }

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
    protected GoogleCredentials credentials() {
      return new AppEngineCredentials();
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
    protected GoogleCredentials credentials() {
      return (privateKey == null)
          ? new GoogleCredentials(null)
          : new ServiceAccountCredentials(null, account, privateKey, null, null);
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
    protected GoogleCredentials credentials() {
      return googleCredentials;
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

  protected abstract GoogleCredentials credentials();

  public static AuthCredentials createForAppEngine() {
    return AppEngineAuthCredentials.INSTANCE;
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
    GoogleCredentials tempCredentials = GoogleCredentials.fromStream(jsonCredentialStream);
    if (tempCredentials instanceof ServiceAccountCredentials) {
      ServiceAccountCredentials tempServiceAccountCredentials =
          (ServiceAccountCredentials) tempCredentials;
      return new ServiceAccountAuthCredentials(
          tempServiceAccountCredentials.getClientEmail(),
          tempServiceAccountCredentials.getPrivateKey());
    } else {
      throw new IOException(
          "The given JSON Credentials Stream is not a service account credential.");
    }
  }

  public static AuthCredentials noCredentials() {
    return ServiceAccountAuthCredentials.NO_CREDENTIALS;
  }
}
