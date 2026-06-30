/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import com.google.auth.ServiceAccountSigner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * OAuth2 credentials representing the built-in service account for Google App Engine.
 *
 * <p>Instances of this class use reflection to access AppIdentityService in AppEngine SDK.
 */
class AppEngineCredentials extends GoogleCredentials implements ServiceAccountSigner {

  private static final long serialVersionUID = -493219027336622194L;

  static final String APP_IDENTITY_SERVICE_FACTORY_CLASS =
      "com.google.appengine.api.appidentity.AppIdentityServiceFactory";
  static final String APP_IDENTITY_SERVICE_CLASS =
      "com.google.appengine.api.appidentity.AppIdentityService";
  static final String GET_ACCESS_TOKEN_RESULT_CLASS =
      "com.google.appengine.api.appidentity.AppIdentityService$GetAccessTokenResult";
  static final String SIGNING_RESULT_CLASS =
      "com.google.appengine.api.appidentity.AppIdentityService$SigningResult";
  private static final String GET_APP_IDENTITY_SERVICE_METHOD = "getAppIdentityService";
  private static final String GET_ACCESS_TOKEN_RESULT_METHOD = "getAccessToken";
  private static final String GET_ACCESS_TOKEN_METHOD = "getAccessToken";
  private static final String GET_EXPIRATION_TIME_METHOD = "getExpirationTime";
  private static final String GET_SERVICE_ACCOUNT_NAME_METHOD = "getServiceAccountName";
  private static final String SIGN_FOR_APP_METHOD = "signForApp";
  private static final String GET_SIGNATURE_METHOD = "getSignature";

  private final Collection<String> scopes;
  private final boolean scopesRequired;

  private transient Object appIdentityService;
  private transient Method getAccessToken;
  private transient Method getAccessTokenResult;
  private transient Method getExpirationTime;
  private transient Method signForApp;
  private transient Method getSignature;
  private transient String account;

  AppEngineCredentials(Collection<String> scopes, Collection<String> defaultScopes)
      throws IOException {
    // Use defaultScopes only when scopes don't exist.
    if (scopes == null || scopes.isEmpty()) {
      this.scopes =
          defaultScopes == null ? ImmutableList.<String>of() : ImmutableList.copyOf(defaultScopes);
    } else {
      this.scopes = ImmutableList.copyOf(scopes);
    }
    this.scopesRequired = this.scopes.isEmpty();
    init();
  }

  AppEngineCredentials(
      Collection<String> scopes, Collection<String> defaultScopes, AppEngineCredentials unscoped) {
    this.appIdentityService = unscoped.appIdentityService;
    this.getAccessToken = unscoped.getAccessToken;
    this.getAccessTokenResult = unscoped.getAccessTokenResult;
    this.getExpirationTime = unscoped.getExpirationTime;
    // Use defaultScopes only when scopes don't exist.
    if (scopes == null || scopes.isEmpty()) {
      this.scopes =
          defaultScopes == null ? ImmutableSet.<String>of() : ImmutableList.copyOf(defaultScopes);
    } else {
      this.scopes = ImmutableList.copyOf(scopes);
    }
    this.scopesRequired = this.scopes.isEmpty();
  }

  private void init() throws IOException {
    try {
      Class<?> factoryClass = forName(APP_IDENTITY_SERVICE_FACTORY_CLASS);
      Method method = factoryClass.getMethod(GET_APP_IDENTITY_SERVICE_METHOD);
      this.appIdentityService = method.invoke(null);
      Class<?> serviceClass = forName(APP_IDENTITY_SERVICE_CLASS);
      Class<?> tokenResultClass = forName(GET_ACCESS_TOKEN_RESULT_CLASS);
      this.getAccessTokenResult =
          serviceClass.getMethod(GET_ACCESS_TOKEN_RESULT_METHOD, Iterable.class);
      this.getAccessToken = tokenResultClass.getMethod(GET_ACCESS_TOKEN_METHOD);
      this.getExpirationTime = tokenResultClass.getMethod(GET_EXPIRATION_TIME_METHOD);
      this.account =
          (String)
              serviceClass.getMethod(GET_SERVICE_ACCOUNT_NAME_METHOD).invoke(appIdentityService);
      this.signForApp = serviceClass.getMethod(SIGN_FOR_APP_METHOD, byte[].class);
      Class<?> signingResultClass = forName(SIGNING_RESULT_CLASS);
      this.getSignature = signingResultClass.getMethod(GET_SIGNATURE_METHOD);
      this.name = GoogleCredentialsInfo.APP_ENGINE_CREDENTIALS.getCredentialName();
    } catch (ClassNotFoundException
        | NoSuchMethodException
        | IllegalAccessException
        | InvocationTargetException ex) {
      throw new IOException(
          "Application Default Credentials failed to create the Google App Engine service account"
              + " credentials. Check that the App Engine SDK is deployed.",
          ex);
    }
  }

  /** Refresh the access token by getting it from the App Identity service. */
  @Override
  public AccessToken refreshAccessToken() throws IOException {
    if (createScopedRequired()) {
      throw new IOException("AppEngineCredentials requires createScoped call before use.");
    }
    try {
      Object accessTokenResult = getAccessTokenResult.invoke(appIdentityService, scopes);
      String accessToken = (String) getAccessToken.invoke(accessTokenResult);
      Date expirationTime = (Date) getExpirationTime.invoke(accessTokenResult);
      return new AccessToken(accessToken, expirationTime);
    } catch (Exception e) {
      throw new IOException("Could not get the access token.", e);
    }
  }

  @Override
  public boolean createScopedRequired() {
    return scopesRequired;
  }

  @Override
  public GoogleCredentials createScoped(Collection<String> scopes) {
    return new AppEngineCredentials(scopes, null, this);
  }

  @Override
  public GoogleCredentials createScoped(
      Collection<String> scopes, Collection<String> defaultScopes) {
    return new AppEngineCredentials(scopes, defaultScopes, this);
  }

  @Override
  public String getAccount() {
    return account;
  }

  @Override
  public byte[] sign(byte[] toSign) {
    try {
      Object signingResult = signForApp.invoke(appIdentityService, toSign);
      return (byte[]) getSignature.invoke(signingResult);
    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
      throw new SigningException("Failed to sign the provided bytes", ex);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(scopes, scopesRequired);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("scopes", scopes)
        .add("scopesRequired", scopesRequired)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AppEngineCredentials)) {
      return false;
    }
    AppEngineCredentials other = (AppEngineCredentials) obj;
    return this.scopesRequired == other.scopesRequired && Objects.equals(this.scopes, other.scopes);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    init();
  }

  /*
   * Start of methods to allow overriding in the test code to isolate from the environment.
   */

  Class<?> forName(String className) throws ClassNotFoundException {
    return Class.forName(className);
  }

  /*
   * End of methods to allow overriding in the test code to isolate from the environment.
   */
}
