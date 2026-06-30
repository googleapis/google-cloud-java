/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.core;

import com.google.api.core.BetaApi;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;

/**
 * GoogleCredentialsProvider acquires credentials using Application Default Credentials.
 *
 * <p>For more information on Application Default Credentials, see <a
 * href="https://developers.google.com/identity/protocols/application-default-credentials">
 * https://developers.google.com/identity/protocols/application-default-credentials</a>.
 */
@AutoValue
public abstract class GoogleCredentialsProvider implements CredentialsProvider {

  public abstract List<String> getScopesToApply();

  @BetaApi
  public abstract List<String> getJwtEnabledScopes();

  @BetaApi
  public abstract boolean getUseJwtAccessWithScope();

  @VisibleForTesting
  @Nullable
  abstract GoogleCredentials getOAuth2Credentials();

  @Override
  public Credentials getCredentials() throws IOException {
    GoogleCredentials credentials = getOAuth2Credentials();
    if (credentials == null) {
      credentials = GoogleCredentials.getApplicationDefault();
    }

    // Check if the current scopes permit JWT token use
    boolean hasJwtEnabledScope = false;
    for (String scope : getJwtEnabledScopes()) {
      if (getScopesToApply().contains(scope)) {
        hasJwtEnabledScope = true;
        break;
      }
    }
    // Use JWT tokens when using a service account with an appropriate scope.
    if (credentials instanceof ServiceAccountCredentials && hasJwtEnabledScope) {
      ServiceAccountCredentials serviceAccount = (ServiceAccountCredentials) credentials;

      return ServiceAccountJwtAccessCredentials.newBuilder()
          .setClientEmail(serviceAccount.getClientEmail())
          .setClientId(serviceAccount.getClientId())
          .setPrivateKey(serviceAccount.getPrivateKey())
          .setPrivateKeyId(serviceAccount.getPrivateKeyId())
          .setQuotaProjectId(serviceAccount.getQuotaProjectId())
          .setUniverseDomain(serviceAccount.getUniverseDomain())
          .build();
    }

    if (credentials.createScopedRequired()) {
      credentials = credentials.createScoped(getScopesToApply());
    }

    if (getUseJwtAccessWithScope() && credentials instanceof ServiceAccountCredentials) {
      // See https://google.aip.dev/auth/4111 for self signed JWT.
      ServiceAccountCredentials serviceAccount = (ServiceAccountCredentials) credentials;
      return serviceAccount.createWithUseJwtAccessWithScope(true);
    }
    return credentials;
  }

  public static Builder newBuilder() {
    return new AutoValue_GoogleCredentialsProvider.Builder()
        .setJwtEnabledScopes(ImmutableList.<String>of())
        .setUseJwtAccessWithScope(false);
  }

  public abstract Builder toBuilder();

  @BetaApi
  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Sets the scopes to apply to the credentials that are acquired from Application Default
     * Credentials, before the credentials are sent to the service. These scopes only take effect if
     * the underlying credentials require them. See {@link GoogleCredentials#createScopedRequired()}
     * for more details on when scopes are necessary.
     */
    public abstract Builder setScopesToApply(List<String> val);

    /** The scopes previously provided. */
    public abstract List<String> getScopesToApply();

    @VisibleForTesting
    abstract Builder setOAuth2Credentials(GoogleCredentials oauth2Credentials);

    /**
     * Sets the scopes that are compatible with JWT tokens.
     *
     * <p>JWT Tokens don't support scopes, they only support audiences. Audiences allow access to
     * the entire service as opposed some subset (ie. access can't be restricted to use the scope
     * {@code https://www.googleapis.com/auth/bigtable.data.readonly}). A service client can opt-in
     * to using JWT tokens by specifying which scopes encompass the entire service. If any of those
     * scopes are present when the client is using {@link ServiceAccountCredentials}, then JWT
     * tokens will be used for authentication.
     */
    @BetaApi
    public abstract Builder setJwtEnabledScopes(List<String> val);

    /** The JWT enable scopes previously provided. */
    @BetaApi
    public abstract List<String> getJwtEnabledScopes();

    /** Whether self signed JWT with scopes should be used for service account credentials. */
    @BetaApi
    public abstract Builder setUseJwtAccessWithScope(boolean val);

    /** The UseJwtAccessWithScope value previously provided. */
    @BetaApi
    public abstract boolean getUseJwtAccessWithScope();

    public GoogleCredentialsProvider build() {
      setScopesToApply(ImmutableList.copyOf(getScopesToApply()));
      setJwtEnabledScopes(ImmutableList.copyOf(getJwtEnabledScopes()));
      setUseJwtAccessWithScope(getUseJwtAccessWithScope());
      return autoBuild();
    }

    abstract GoogleCredentialsProvider autoBuild();
  }
}
