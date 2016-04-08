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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Collection;
import java.util.Objects;

/**
 * Credentials for accessing Google Cloud services.
 */
public abstract class AuthCredentials implements Restorable<AuthCredentials> {

  /**
   * Represents built-in credentials when running in Google App Engine.
   */
  public static class AppEngineAuthCredentials extends AuthCredentials
      implements ServiceAccountSigner {

    private static final AuthCredentials INSTANCE = new AppEngineAuthCredentials();
    private static final AppEngineAuthCredentialsState STATE = new AppEngineAuthCredentialsState();

    private AppEngineCredentials credentials;

    private static class AppEngineCredentials extends GoogleCredentials
        implements ServiceAccountSigner {

      private final Object appIdentityService;
      private final String account;
      private final Method getAccessToken;
      private final Method getAccessTokenResult;
      private final Method signForApp;
      private final Method getSignature;
      private final Collection<String> scopes;

      AppEngineCredentials() {
        try {
          Class<?> factoryClass =
              Class.forName("com.google.appengine.api.appidentity.AppIdentityServiceFactory");
          Method method = factoryClass.getMethod("getAppIdentityService");
          this.appIdentityService = method.invoke(null);
          Class<?> serviceClass =
              Class.forName("com.google.appengine.api.appidentity.AppIdentityService");
          Class<?> tokenResultClass = Class.forName(
              "com.google.appengine.api.appidentity.AppIdentityService$GetAccessTokenResult");
          this.getAccessTokenResult = serviceClass.getMethod("getAccessToken", Iterable.class);
          this.getAccessToken = tokenResultClass.getMethod("getAccessToken");
          this.account = (String) serviceClass.getMethod("getServiceAccountName")
              .invoke(appIdentityService);
          this.signForApp = serviceClass.getMethod("signForApp", byte[].class);
          Class<?> signingResultClass = Class.forName(
              "com.google.appengine.api.appidentity.AppIdentityService$SigningResult");
          this.getSignature = signingResultClass.getMethod("getSignature");
          this.scopes = null;
        } catch (Exception e) {
          throw new RuntimeException("Could not create AppEngineCredentials.", e);
        }
      }

      AppEngineCredentials(Collection<String> scopes, AppEngineCredentials unscoped) {
        this.appIdentityService = unscoped.appIdentityService;
        this.getAccessToken = unscoped.getAccessToken;
        this.getAccessTokenResult = unscoped.getAccessTokenResult;
        this.account = unscoped.account;
        this.signForApp = unscoped.signForApp;
        this.getSignature = unscoped.getSignature;
        this.scopes = scopes;
      }

      /**
       * Refresh the access token by getting it from the App Identity service.
       */
      @Override
      public AccessToken refreshAccessToken() throws IOException {
        if (createScopedRequired()) {
          throw new IOException("AppEngineCredentials requires createScoped call before use.");
        }
        try {
          Object accessTokenResult = getAccessTokenResult.invoke(appIdentityService, scopes);
          String accessToken = (String) getAccessToken.invoke(accessTokenResult);
          return new AccessToken(accessToken, null);
        } catch (Exception e) {
          throw new IOException("Could not get the access token.", e);
        }
      }

      @Override
      public boolean createScopedRequired() {
        return scopes == null || scopes.isEmpty();
      }

      @Override
      public GoogleCredentials createScoped(Collection<String> scopes) {
        return new AppEngineCredentials(scopes, this);
      }

      @Override
      public String account() {
        return account;
      }

      @Override
      public byte[] sign(byte[] toSign) {
        try {
          Object signingResult = signForApp.invoke(appIdentityService, (Object) toSign);
          return (byte[]) getSignature.invoke(signingResult);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
          throw new SigningException("Failed to sign the provided bytes", ex);
        }
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
    public AppEngineCredentials credentials() {
      if (credentials == null) {
        credentials = new AppEngineCredentials();
      }
      return credentials;
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return STATE;
    }

    @Override
    public String account() {
      return credentials().account();
    }

    @Override
    public byte[] sign(byte[] toSign) {
      return credentials().sign(toSign);
    }
  }

  /**
   * Represents service account credentials.
   *
   * @see <a href="https://cloud.google.com/docs/authentication#user_accounts_and_service_accounts">
   *     User accounts and service accounts</a>
   */
  public static class ServiceAccountAuthCredentials extends AuthCredentials
      implements ServiceAccountSigner {

    private final ServiceAccountCredentials credentials;
    private final String account;
    private final PrivateKey privateKey;

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
      this(new ServiceAccountCredentials(null, account, privateKey, null, null));
    }

    ServiceAccountAuthCredentials(ServiceAccountCredentials credentials) {
      this.credentials = checkNotNull(credentials);
      this.account = checkNotNull(credentials.getClientEmail());
      this.privateKey = checkNotNull(credentials.getPrivateKey());
    }

    @Override
    public ServiceAccountCredentials credentials() {
      return credentials;
    }

    @Override
    public String account() {
      return account;
    }

    /**
     * Returns the private key associated with the service account credentials.
     */
    public PrivateKey privateKey() {
      return privateKey;
    }

    @Override
    public byte[] sign(byte[] toSign) {
      try {
        Signature signer = Signature.getInstance("SHA256withRSA");
        signer.initSign(privateKey());
        signer.update(toSign);
        return signer.sign();
      } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException ex) {
        throw new SigningException("Failed to sign the provided bytes", ex);
      }
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return new ServiceAccountAuthCredentialsState(account, privateKey);
    }
  }

  /**
   * Represents Application Default Credentials, which are credentials that are inferred from the
   * runtime environment.
   *
   * @see <a
   *     href="https://developers.google.com/identity/protocols/application-default-credentials">
   *     Google Application Default Credentials</a>
   */
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

    ApplicationDefaultAuthCredentials(GoogleCredentials credentials) {
      googleCredentials = credentials;
    }

    ApplicationDefaultAuthCredentials() throws IOException {
      googleCredentials = GoogleCredentials.getApplicationDefault();
    }

    @Override
    public GoogleCredentials credentials() {
      return googleCredentials;
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return STATE;
    }
  }

  /**
   * A placeholder for credentials to signify that requests sent to the server should not be
   * authenticated. This is typically useful when using the local service emulators, such as
   * {@code LocalDatastoreHelper} and {@code LocalResourceManagerHelper}.
   */
  public static class NoAuthCredentials extends AuthCredentials {

    private static final AuthCredentials INSTANCE = new NoAuthCredentials();
    private static final NoAuthCredentialsState STATE = new NoAuthCredentialsState();

    private static class NoAuthCredentialsState
        implements RestorableState<AuthCredentials>, Serializable {

      private static final long serialVersionUID = -4022100563954640465L;

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
        return obj instanceof NoAuthCredentialsState;
      }
    }

    private NoAuthCredentials() {}

    @Override
    public GoogleCredentials credentials() {
      return null;
    }

    @Override
    public RestorableState<AuthCredentials> capture() {
      return STATE;
    }
  }

  public abstract GoogleCredentials credentials();

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
   * @return the credentials instance
   * @throws IOException if the credentials cannot be created in the current environment
   */
  public static AuthCredentials createApplicationDefaults() throws IOException {
    GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
    if (credentials instanceof ServiceAccountCredentials) {
      ServiceAccountCredentials serviceAccountCredentials = (ServiceAccountCredentials) credentials;
      return new ServiceAccountAuthCredentials(serviceAccountCredentials);
    }
    return new ApplicationDefaultAuthCredentials(credentials);
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
   * @return the credentials instance
   */
  public static ServiceAccountAuthCredentials createFor(String account, PrivateKey privateKey) {
    return new ServiceAccountAuthCredentials(account, privateKey);
  }

  /**
   * Creates a placeholder denoting that no credentials should be used. This is typically useful
   * when using the local service emulators, such as {@code LocalDatastoreHelper} and
   * {@code LocalResourceManagerHelper}.
   */
  public static AuthCredentials noAuth() {
    return NoAuthCredentials.INSTANCE;
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
   * @return the credentials instance
   * @throws IOException if the credentials cannot be created from the stream
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
    }
    throw new IOException(
        "The given JSON Credentials Stream is not for a service account credential.");
  }
}
