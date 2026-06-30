/*
 * Copyright 2015, Google Inc. All rights reserved.
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

package com.google.auth.appengine;

import com.google.appengine.api.appidentity.AppIdentityService;
import com.google.appengine.api.appidentity.AppIdentityService.GetAccessTokenResult;
import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * OAuth2 credentials representing the built-in service account for Google App Engine. You should
 * only use this class if you are running on AppEngine and are using urlfetch.
 *
 * <p>Fetches access tokens from the App Identity service.
 */
public class AppEngineCredentials extends GoogleCredentials implements ServiceAccountSigner {

  private static final long serialVersionUID = -2627708355455064660L;

  private final String appIdentityServiceClassName;
  private final Collection<String> scopes;
  private final boolean scopesRequired;

  private transient AppIdentityService appIdentityService;

  private AppEngineCredentials(Collection<String> scopes, AppIdentityService appIdentityService) {
    this.scopes = scopes == null ? ImmutableSet.<String>of() : ImmutableList.copyOf(scopes);
    this.appIdentityService =
        appIdentityService != null
            ? appIdentityService
            : AppIdentityServiceFactory.getAppIdentityService();
    this.appIdentityServiceClassName = this.appIdentityService.getClass().getName();
    scopesRequired = this.scopes.isEmpty();
  }

  /** Refresh the access token by getting it from the App Identity service */
  @Override
  public AccessToken refreshAccessToken() throws IOException {
    if (createScopedRequired()) {
      throw new IOException("AppEngineCredentials requires createScoped call before use.");
    }
    GetAccessTokenResult accessTokenResponse = appIdentityService.getAccessToken(scopes);
    String accessToken = accessTokenResponse.getAccessToken();
    Date expirationTime = accessTokenResponse.getExpirationTime();
    return new AccessToken(accessToken, expirationTime);
  }

  @Override
  public boolean createScopedRequired() {
    return scopesRequired;
  }

  @Override
  public GoogleCredentials createScoped(Collection<String> scopes) {
    return new AppEngineCredentials(scopes, appIdentityService);
  }

  @Override
  public String getAccount() {
    return appIdentityService.getServiceAccountName();
  }

  @Override
  public byte[] sign(byte[] toSign) {
    return appIdentityService.signForApp(toSign).getSignature();
  }

  @Override
  public int hashCode() {
    return Objects.hash(scopes, scopesRequired, appIdentityServiceClassName);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("scopes", scopes)
        .add("scopesRequired", scopesRequired)
        .add("appIdentityServiceClassName", appIdentityServiceClassName)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AppEngineCredentials)) {
      return false;
    }
    AppEngineCredentials other = (AppEngineCredentials) obj;
    return this.scopesRequired == other.scopesRequired
        && Objects.equals(this.scopes, other.scopes)
        && Objects.equals(this.appIdentityServiceClassName, other.appIdentityServiceClassName);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    try {
      // Load the class without initializing it (second argument: false) to prevent
      // static initializers from running (preventing gadget chain attacks). Use the class loader
      // of HttpTransportFactory to ensure the class is loaded from the same context as the library
      // to try to prevent any class loading manipulation.
      Class<?> clazz =
          Class.forName(
              appIdentityServiceClassName, false, AppIdentityService.class.getClassLoader());

      // Check that the class is an instance of `AppIdentityService` to prevent loading of
      // arbitrary classes.
      if (!AppIdentityService.class.isAssignableFrom(clazz)) {
        throw new IOException(
            String.format(
                "The class, %s, is not assignable from %s.",
                appIdentityServiceClassName, AppIdentityService.class.getName()));
      }
      Constructor<?> constructor = clazz.getConstructor();
      appIdentityService = (AppIdentityService) constructor.newInstance();
    } catch (InstantiationException
        | IllegalAccessException
        | NoSuchMethodException
        | InvocationTargetException e) {
      throw new IOException(e);
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder extends GoogleCredentials.Builder {

    private Collection<String> scopes;
    private AppIdentityService appIdentityService;

    protected Builder() {}

    protected Builder(AppEngineCredentials credentials) {
      this.scopes = credentials.scopes;
      this.appIdentityService = credentials.appIdentityService;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      this.scopes = scopes;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setAppIdentityService(AppIdentityService appIdentityService) {
      this.appIdentityService = appIdentityService;
      return this;
    }

    public Collection<String> getScopes() {
      return scopes;
    }

    public AppIdentityService getAppIdentityService() {
      return appIdentityService;
    }

    @Override
    public AppEngineCredentials build() {
      return new AppEngineCredentials(scopes, appIdentityService);
    }
  }
}
