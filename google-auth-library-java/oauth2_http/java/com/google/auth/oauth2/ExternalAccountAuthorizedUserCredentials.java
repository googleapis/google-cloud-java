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

import static com.google.auth.oauth2.OAuth2Utils.JSON_FACTORY;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.io.BaseEncoding;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * OAuth2 credentials sourced using external identities through Workforce Identity Federation.
 *
 * <p>Obtaining the initial access and refresh token can be done through the Google Cloud CLI.
 *
 * <pre>
 * Example credentials file:
 * {
 *   "type": "external_account_authorized_user",
 *   "audience": "//iam.googleapis.com/locations/global/workforcePools/$WORKFORCE_POOL_ID/providers/$PROVIDER_ID",
 *   "refresh_token": "refreshToken",
 *   "token_url": "https://sts.googleapis.com/v1/oauthtoken",
 *   "token_info_url": "https://sts.googleapis.com/v1/introspect",
 *   "client_id": "clientId",
 *   "client_secret": "clientSecret"
 * }
 * </pre>
 */
public class ExternalAccountAuthorizedUserCredentials extends GoogleCredentials {

  private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";

  private static final long serialVersionUID = -2181779590486283287L;

  private final String transportFactoryClassName;
  private final String audience;
  private final String tokenUrl;
  private final String tokenInfoUrl;
  private final String revokeUrl;
  private final String clientId;
  private final String clientSecret;

  private String refreshToken;

  private transient HttpTransportFactory transportFactory;

  /**
   * Internal constructor.
   *
   * @param builder A builder for {@link ExternalAccountAuthorizedUserCredentials}. See {@link
   *     ExternalAccountAuthorizedUserCredentials.Builder}
   */
  private ExternalAccountAuthorizedUserCredentials(Builder builder) {
    super(builder);
    this.transportFactory =
        MoreObjects.firstNonNull(
            builder.transportFactory,
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    this.transportFactoryClassName = this.transportFactory.getClass().getName();
    this.audience = builder.audience;
    this.refreshToken = builder.refreshToken;
    this.tokenUrl = builder.tokenUrl;
    this.tokenInfoUrl = builder.tokenInfoUrl;
    this.revokeUrl = builder.revokeUrl;
    this.clientId = builder.clientId;
    this.clientSecret = builder.clientSecret;

    this.name =
        GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getCredentialName();

    Preconditions.checkState(
        getAccessToken() != null || canRefresh(),
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').");
  }

  /**
   * Returns external account authorized user credentials defined by a JSON file stream.
   *
   * <p>Important: If you accept a credential configuration (credential JSON/File/Stream) from an
   * external source for authentication to Google Cloud Platform, you must validate it before
   * providing it to any Google API or library. Providing an unvalidated credential configuration to
   * Google APIs can compromise the security of your systems and data. For more information, refer
   * to {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}.
   *
   * @param credentialsStream the stream with the credential definition
   * @return the credential defined by the credentialsStream
   * @throws IOException if the credential cannot be created from the stream
   */
  public static ExternalAccountAuthorizedUserCredentials fromStream(InputStream credentialsStream)
      throws IOException {
    return fromStream(credentialsStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Returns external account authorized user credentials defined by a JSON file stream.
   *
   * <p>Important: If you accept a credential configuration (credential JSON/File/Stream) from an
   * external source for authentication to Google Cloud Platform, you must validate it before
   * providing it to any Google API or library. Providing an unvalidated credential configuration to
   * Google APIs can compromise the security of your systems and data. For more information, refer
   * to {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}.
   *
   * @param credentialsStream the stream with the credential definition
   * @param transportFactory the HTTP transport factory used to create the transport to get access
   *     tokens
   * @return the credential defined by the credentialsStream
   * @throws IOException if the credential cannot be created from the stream
   */
  public static ExternalAccountAuthorizedUserCredentials fromStream(
      InputStream credentialsStream, HttpTransportFactory transportFactory) throws IOException {
    Preconditions.checkNotNull(transportFactory);
    GenericJson fileContents = parseJsonInputStream(credentialsStream);
    String fileType = extractFromJson(fileContents, "type");
    if (fileType.equals(
        GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType())) {
      try {
        return fromJson(fileContents, transportFactory);
      } catch (ClassCastException | IllegalArgumentException e) {
        throw new CredentialFormatException("Invalid input stream provided.", e);
      }
    }

    throw new IOException(
        String.format(
            "Error reading credentials from stream, 'type' value '%s' not recognized."
                + " Expecting '%s'.",
            fileType,
            GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType()));
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    if (!canRefresh()) {
      throw new IllegalStateException(
          "Unable to refresh ExternalAccountAuthorizedUserCredentials. All of 'refresh_token',"
              + "'token_url', 'client_id', 'client_secret' are required to refresh.");
    }

    HttpResponse response;
    try {
      HttpRequest httpRequest = buildRefreshRequest();
      response = httpRequest.execute();
    } catch (HttpResponseException e) {
      throw OAuthException.createFromHttpResponseException(e);
    }

    // Parse response.
    GenericData responseData = response.parseAs(GenericData.class);
    response.disconnect();

    // Required fields.
    String accessToken =
        OAuth2Utils.validateString(responseData, /* key= */ "access_token", PARSE_ERROR_PREFIX);
    int expiresInSeconds =
        OAuth2Utils.validateInt32(responseData, /* key= */ "expires_in", PARSE_ERROR_PREFIX);
    Date expiresAtMilliseconds = new Date(clock.currentTimeMillis() + expiresInSeconds * 1000L);

    // Set the new refresh token if returned.
    String refreshToken =
        OAuth2Utils.validateOptionalString(
            responseData, /* key= */ "refresh_token", PARSE_ERROR_PREFIX);
    if (refreshToken != null && refreshToken.trim().length() > 0) {
      this.refreshToken = refreshToken;
    }

    return AccessToken.newBuilder()
        .setExpirationTime(expiresAtMilliseconds)
        .setTokenValue(accessToken)
        .build();
  }

  @Nullable
  public String getAudience() {
    return audience;
  }

  @Nullable
  public String getClientId() {
    return clientId;
  }

  @Nullable
  public String getClientSecret() {
    return clientSecret;
  }

  @Nullable
  public String getRevokeUrl() {
    return revokeUrl;
  }

  @Nullable
  public String getTokenUrl() {
    return tokenUrl;
  }

  @Nullable
  public String getTokenInfoUrl() {
    return tokenInfoUrl;
  }

  @Nullable
  public String getRefreshToken() {
    return refreshToken;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        getAccessToken(),
        clientId,
        clientSecret,
        refreshToken,
        tokenUrl,
        tokenInfoUrl,
        revokeUrl,
        audience,
        transportFactoryClassName,
        quotaProjectId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("requestMetadata", getRequestMetadataInternal())
        .add("temporaryAccess", getAccessToken())
        .add("clientId", clientId)
        .add("clientSecret", clientSecret)
        .add("refreshToken", refreshToken)
        .add("tokenUrl", tokenUrl)
        .add("tokenInfoUrl", tokenInfoUrl)
        .add("revokeUrl", revokeUrl)
        .add("audience", audience)
        .add("transportFactoryClassName", transportFactoryClassName)
        .add("quotaProjectId", quotaProjectId)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ExternalAccountAuthorizedUserCredentials)) {
      return false;
    }
    ExternalAccountAuthorizedUserCredentials credentials =
        (ExternalAccountAuthorizedUserCredentials) obj;
    return super.equals(credentials)
        && Objects.equals(this.getAccessToken(), credentials.getAccessToken())
        && Objects.equals(this.clientId, credentials.clientId)
        && Objects.equals(this.clientSecret, credentials.clientSecret)
        && Objects.equals(this.refreshToken, credentials.refreshToken)
        && Objects.equals(this.tokenUrl, credentials.tokenUrl)
        && Objects.equals(this.tokenInfoUrl, credentials.tokenInfoUrl)
        && Objects.equals(this.revokeUrl, credentials.revokeUrl)
        && Objects.equals(this.audience, credentials.audience)
        && Objects.equals(this.transportFactoryClassName, credentials.transportFactoryClassName)
        && Objects.equals(this.quotaProjectId, credentials.quotaProjectId);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Returns external account authorized user credentials defined by JSON contents using the format
   * supported by the Cloud SDK.
   *
   * @param json a map from the JSON representing the credentials
   * @param transportFactory HTTP transport factory, creates the transport used to get access tokens
   * @return the external account authorized user credentials defined by the JSON
   */
  static ExternalAccountAuthorizedUserCredentials fromJson(
      Map<String, Object> json, HttpTransportFactory transportFactory) throws IOException {
    String audience = (String) json.get("audience");
    String refreshToken = (String) json.get("refresh_token");
    String tokenUrl = (String) json.get("token_url");
    String tokenInfoUrl = (String) json.get("token_info_url");
    String revokeUrl = (String) json.get("revoke_url");
    String clientId = (String) json.get("client_id");
    String clientSecret = (String) json.get("client_secret");
    String quotaProjectId = (String) json.get("quota_project_id");
    String universeDomain = (String) json.get("universe_domain");

    return ExternalAccountAuthorizedUserCredentials.newBuilder()
        .setAudience(audience)
        .setRefreshToken(refreshToken)
        .setTokenUrl(tokenUrl)
        .setTokenInfoUrl(tokenInfoUrl)
        .setRevokeUrl(revokeUrl)
        .setClientId(clientId)
        .setClientSecret(clientSecret)
        .setRefreshToken(refreshToken)
        .setHttpTransportFactory(transportFactory)
        .setQuotaProjectId(quotaProjectId)
        .setUniverseDomain(universeDomain)
        .build();
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    transportFactory = newInstance(transportFactoryClassName);
  }

  private boolean canRefresh() {
    return refreshToken != null
        && refreshToken.trim().length() > 0
        && tokenUrl != null
        && tokenUrl.trim().length() > 0
        && clientId != null
        && clientId.trim().length() > 0
        && clientSecret != null
        && clientSecret.trim().length() > 0;
  }

  private HttpRequest buildRefreshRequest() throws IOException {
    GenericData tokenRequest = new GenericData();
    tokenRequest.set("grant_type", "refresh_token");
    tokenRequest.set("refresh_token", refreshToken);

    HttpRequest request =
        transportFactory
            .create()
            .createRequestFactory()
            .buildPostRequest(new GenericUrl(tokenUrl), new UrlEncodedContent(tokenRequest));

    request.setParser(new JsonObjectParser(JSON_FACTORY));

    HttpHeaders requestHeaders = request.getHeaders();
    requestHeaders.setAuthorization(
        String.format(
            "Basic %s",
            BaseEncoding.base64()
                .encode(
                    String.format("%s:%s", clientId, clientSecret)
                        .getBytes(StandardCharsets.UTF_8))));

    return request;
  }

  /** Builder for {@link ExternalAccountAuthorizedUserCredentials}. */
  public static class Builder extends GoogleCredentials.Builder {

    private HttpTransportFactory transportFactory;
    private String audience;
    private String refreshToken;
    private String tokenUrl;
    private String tokenInfoUrl;
    private String revokeUrl;
    private String clientId;
    private String clientSecret;

    protected Builder() {}

    protected Builder(ExternalAccountAuthorizedUserCredentials credentials) {
      super(credentials);
      this.transportFactory = credentials.transportFactory;
      this.audience = credentials.audience;
      this.refreshToken = credentials.refreshToken;
      this.tokenUrl = credentials.tokenUrl;
      this.tokenInfoUrl = credentials.tokenInfoUrl;
      this.revokeUrl = credentials.revokeUrl;
      this.clientId = credentials.clientId;
      this.clientSecret = credentials.clientSecret;
    }

    /**
     * Sets the HTTP transport factory.
     *
     * @param transportFactory the {@code HttpTransportFactory} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    /**
     * Sets the optional audience, which is usually the fully specified resource name of the
     * workforce pool provider.
     *
     * @param audience the audience to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setAudience(String audience) {
      this.audience = audience;
      return this;
    }

    /**
     * Sets the token exchange endpoint.
     *
     * @param tokenUrl the token exchange url to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setTokenUrl(String tokenUrl) {
      this.tokenUrl = tokenUrl;
      return this;
    }

    /**
     * Sets the token introspection endpoint used to retrieve account related information.
     *
     * @param tokenInfoUrl the token info url to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setTokenInfoUrl(String tokenInfoUrl) {
      this.tokenInfoUrl = tokenInfoUrl;
      return this;
    }

    /**
     * Sets the token revocation endpoint.
     *
     * @param revokeUrl the revoke url to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setRevokeUrl(String revokeUrl) {
      this.revokeUrl = revokeUrl;
      return this;
    }

    /**
     * Sets the OAuth 2.0 refresh token.
     *
     * @param refreshToken the refresh token
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setRefreshToken(String refreshToken) {
      this.refreshToken = refreshToken;
      return this;
    }

    /**
     * Sets the OAuth 2.0 client ID.
     *
     * @param clientId the client ID
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Sets the OAuth 2.0 client secret.
     *
     * @param clientSecret the client secret
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /**
     * Sets the optional project used for quota and billing purposes.
     *
     * @param quotaProjectId the quota and billing project id to set
     * @return this {@code Builder} object
     */
    @Override
    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    /**
     * Sets the optional access token.
     *
     * @param accessToken the access token
     * @return this {@code Builder} object
     */
    @Override
    @CanIgnoreReturnValue
    public Builder setAccessToken(AccessToken accessToken) {
      super.setAccessToken(accessToken);
      return this;
    }

    /**
     * Sets the optional universe domain. The Google Default Universe is used when not provided.
     *
     * @param universeDomain the universe domain to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    @Override
    public Builder setUniverseDomain(String universeDomain) {
      super.setUniverseDomain(universeDomain);
      return this;
    }

    @Override
    public ExternalAccountAuthorizedUserCredentials build() {
      return new ExternalAccountAuthorizedUserCredentials(this);
    }
  }
}
