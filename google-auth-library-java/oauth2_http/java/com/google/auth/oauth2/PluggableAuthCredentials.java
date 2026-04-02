/*
 * Copyright 2022 Google LLC
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
 *    * Neither the name of Google LLC nor the names of its
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

import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.ExecutableHandler.ExecutableOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * PluggableAuthCredentials enables the exchange of workload identity pool external credentials for
 * Google access tokens by retrieving 3rd party tokens through a user supplied executable. These
 * scripts/executables are completely independent of the Google Cloud Auth libraries. These
 * credentials plug into ADC and will call the specified executable to retrieve the 3rd party token
 * to be exchanged for a Google access token.
 *
 * <p>To use these credentials, the GOOGLE_EXTERNAL_ACCOUNT_ALLOW_EXECUTABLES environment variable
 * must be set to '1'. This is for security reasons.
 *
 * <p>Both OIDC and SAML are supported. The executable must adhere to a specific response format
 * defined below.
 *
 * <p>The executable must print out the 3rd party token to STDOUT in JSON format. When an
 * output_file is specified in the credential configuration, the executable must also handle writing
 * the JSON response to this file.
 *
 * <pre>
 * OIDC response sample:
 * {
 *   "version": 1,
 *   "success": true,
 *   "token_type": "urn:ietf:params:oauth:token-type:id_token",
 *   "id_token": "HEADER.PAYLOAD.SIGNATURE",
 *   "expiration_time": 1620433341
 * }
 *
 * SAML2 response sample:
 * {
 *   "version": 1,
 *   "success": true,
 *   "token_type": "urn:ietf:params:oauth:token-type:saml2",
 *   "saml_response": "...",
 *   "expiration_time": 1620433341
 * }
 *
 * Error response sample:
 * {
 *   "version": 1,
 *   "success": false,
 *   "code": "401",
 *   "message": "Error message."
 * }
 * </pre>
 *
 * <p>The `expiration_time` field in the JSON response is only required for successful responses
 * when an output file was specified in the credential configuration.
 *
 * <p>The auth libraries will populate certain environment variables that will be accessible by the
 * executable, such as: GOOGLE_EXTERNAL_ACCOUNT_AUDIENCE, GOOGLE_EXTERNAL_ACCOUNT_TOKEN_TYPE,
 * GOOGLE_EXTERNAL_ACCOUNT_INTERACTIVE, GOOGLE_EXTERNAL_ACCOUNT_IMPERSONATED_EMAIL, and
 * GOOGLE_EXTERNAL_ACCOUNT_OUTPUT_FILE.
 *
 * <p>Please see this repositories README for a complete executable request/response specification.
 */
public class PluggableAuthCredentials extends ExternalAccountCredentials {

  static final String PLUGGABLE_AUTH_METRICS_HEADER_VALUE = "executable";

  private final PluggableAuthCredentialSource config;

  private final ExecutableHandler handler;

  /** Internal constructor. See {@link Builder}. */
  PluggableAuthCredentials(Builder builder) {
    super(builder);
    this.config = (PluggableAuthCredentialSource) builder.credentialSource;

    if (builder.handler != null) {
      handler = builder.handler;
    } else {
      handler = new PluggableAuthHandler(getEnvironmentProvider());
    }
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    String credential = retrieveSubjectToken();
    StsTokenExchangeRequest.Builder stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder(credential, getSubjectTokenType())
            .setAudience(getAudience());

    Collection<String> scopes = getScopes();
    if (scopes != null && !scopes.isEmpty()) {
      stsTokenExchangeRequest.setScopes(new ArrayList<>(scopes));
    }
    return exchangeExternalCredentialForAccessToken(stsTokenExchangeRequest.build());
  }

  /**
   * Returns the 3rd party subject token by calling the executable specified in the credential
   * source.
   *
   * @throws IOException if an error occurs with the executable execution.
   */
  @Override
  public String retrieveSubjectToken() throws IOException {
    String executableCommand = config.getCommand();
    String outputFilePath = config.getOutputFilePath();
    int executableTimeoutMs = config.getTimeoutMs();

    Map<String, String> envMap = new HashMap<>();
    envMap.put("GOOGLE_EXTERNAL_ACCOUNT_AUDIENCE", getAudience());
    envMap.put("GOOGLE_EXTERNAL_ACCOUNT_TOKEN_TYPE", getSubjectTokenType());
    // Always set to 0 for Workload Identity Federation.
    envMap.put("GOOGLE_EXTERNAL_ACCOUNT_INTERACTIVE", "0");
    if (getServiceAccountEmail() != null) {
      envMap.put("GOOGLE_EXTERNAL_ACCOUNT_IMPERSONATED_EMAIL", getServiceAccountEmail());
    }
    if (outputFilePath != null && !outputFilePath.isEmpty()) {
      envMap.put("GOOGLE_EXTERNAL_ACCOUNT_OUTPUT_FILE", outputFilePath);
    }

    ExecutableOptions options =
        new ExecutableOptions() {
          @Override
          public String getExecutableCommand() {
            return executableCommand;
          }

          @Override
          public Map<String, String> getEnvironmentMap() {
            return envMap;
          }

          @Override
          public int getExecutableTimeoutMs() {
            return executableTimeoutMs;
          }

          @Nullable
          @Override
          public String getOutputFilePath() {
            return outputFilePath;
          }
        };

    // Delegate handling of the executable to the handler.
    return this.handler.retrieveTokenFromExecutable(options);
  }

  /** Clones the PluggableAuthCredentials with the specified scopes. */
  @Override
  public PluggableAuthCredentials createScoped(Collection<String> newScopes) {
    return new PluggableAuthCredentials(
        (PluggableAuthCredentials.Builder) newBuilder(this).setScopes(newScopes));
  }

  @Override
  String getCredentialSourceType() {
    return PLUGGABLE_AUTH_METRICS_HEADER_VALUE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(PluggableAuthCredentials pluggableAuthCredentials) {
    return new Builder(pluggableAuthCredentials);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @VisibleForTesting
  @Nullable
  ExecutableHandler getExecutableHandler() {
    return this.handler;
  }

  public static class Builder extends ExternalAccountCredentials.Builder {

    private ExecutableHandler handler;

    Builder() {}

    Builder(PluggableAuthCredentials credentials) {
      super(credentials);
      this.handler = credentials.handler;
    }

    @CanIgnoreReturnValue
    public Builder setExecutableHandler(ExecutableHandler handler) {
      this.handler = handler;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      super.setHttpTransportFactory(transportFactory);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setAudience(String audience) {
      super.setAudience(audience);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(String subjectTokenType) {
      super.setSubjectTokenType(subjectTokenType);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(SubjectTokenTypes subjectTokenType) {
      super.setSubjectTokenType(subjectTokenType);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setTokenUrl(String tokenUrl) {
      super.setTokenUrl(tokenUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setCredentialSource(PluggableAuthCredentialSource credentialSource) {
      super.setCredentialSource(credentialSource);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationUrl(String serviceAccountImpersonationUrl) {
      super.setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setTokenInfoUrl(String tokenInfoUrl) {
      super.setTokenInfoUrl(tokenInfoUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      super.setClientId(clientId);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setClientSecret(String clientSecret) {
      super.setClientSecret(clientSecret);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      super.setScopes(scopes);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setWorkforcePoolUserProject(String workforcePoolUserProject) {
      super.setWorkforcePoolUserProject(workforcePoolUserProject);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationOptions(Map<String, Object> optionsMap) {
      super.setServiceAccountImpersonationOptions(optionsMap);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setUniverseDomain(String universeDomain) {
      super.setUniverseDomain(universeDomain);
      return this;
    }

    @CanIgnoreReturnValue
    Builder setEnvironmentProvider(EnvironmentProvider environmentProvider) {
      super.setEnvironmentProvider(environmentProvider);
      return this;
    }

    @Override
    public PluggableAuthCredentials build() {
      return new PluggableAuthCredentials(this);
    }
  }
}
