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

package com.google.auth.oauth2;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.MetricsUtils.RequestType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * OAuth2 credentials representing a Service Account for calling Google APIs.
 *
 * <p>By default uses a JSON Web Token (JWT) to fetch access tokens.
 */
public class ServiceAccountCredentials extends GoogleCredentials
    implements ServiceAccountSigner, IdTokenProvider, JwtProvider {

  private static final long serialVersionUID = 7807543542681217978L;
  private static final String GRANT_TYPE = "urn:ietf:params:oauth:grant-type:jwt-bearer";
  private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
  private static final int TWELVE_HOURS_IN_SECONDS = 43200;
  private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;
  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(ServiceAccountCredentials.class);

  private final String clientId;
  private final String clientEmail;
  private final PrivateKey privateKey;
  private final String privateKeyId;
  private final String serviceAccountUser;
  private final String projectId;
  private final String transportFactoryClassName;
  private final URI tokenServerUri;
  private final Collection<String> scopes;
  private final Collection<String> defaultScopes;
  private final int lifetime;
  private final boolean useJwtAccessWithScope;
  private final boolean defaultRetriesEnabled;

  private transient HttpTransportFactory transportFactory;

  private transient JwtCredentials selfSignedJwtCredentialsWithScope = null;

  /**
   * Internal constructor
   *
   * @param builder A builder for {@link ServiceAccountCredentials} See {@link
   *     ServiceAccountCredentials.Builder}
   */
  ServiceAccountCredentials(ServiceAccountCredentials.Builder builder) {
    super(builder);
    this.clientId = builder.clientId;
    this.clientEmail = Preconditions.checkNotNull(builder.clientEmail);
    this.privateKey = Preconditions.checkNotNull(builder.privateKey);
    this.privateKeyId = builder.privateKeyId;
    this.scopes =
        (builder.scopes == null) ? ImmutableSet.<String>of() : ImmutableSet.copyOf(builder.scopes);
    this.defaultScopes =
        (builder.defaultScopes == null)
            ? ImmutableSet.<String>of()
            : ImmutableSet.copyOf(builder.defaultScopes);
    this.transportFactory =
        firstNonNull(
            builder.transportFactory,
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    this.transportFactoryClassName = this.transportFactory.getClass().getName();
    this.tokenServerUri =
        (builder.tokenServerUri == null) ? OAuth2Utils.TOKEN_SERVER_URI : builder.tokenServerUri;
    this.serviceAccountUser = builder.serviceAccountUser;
    this.projectId = builder.projectId;
    if (builder.lifetime > TWELVE_HOURS_IN_SECONDS) {
      throw new IllegalStateException("lifetime must be less than or equal to 43200");
    }
    this.lifetime = builder.lifetime;
    this.useJwtAccessWithScope = builder.useJwtAccessWithScope;
    this.defaultRetriesEnabled = builder.defaultRetriesEnabled;
    this.name = GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getCredentialName();
    this.principal = builder.clientEmail;
  }

  /**
   * Returns service account credentials defined by JSON using the format supported by the Google
   * Developers Console.
   *
   * @param json a map from the JSON representing the credentials.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @return the credentials defined by the JSON.
   * @throws IOException if the credential cannot be created from the JSON.
   */
  static ServiceAccountCredentials fromJson(
      Map<String, Object> json, HttpTransportFactory transportFactory) throws IOException {
    String clientId = (String) json.get("client_id");
    String clientEmail = (String) json.get("client_email");
    String privateKeyPkcs8 = (String) json.get("private_key");
    String privateKeyId = (String) json.get("private_key_id");
    String projectId = (String) json.get("project_id");
    String tokenServerUriStringFromCreds = (String) json.get("token_uri");
    String quotaProjectId = (String) json.get("quota_project_id");
    String universeDomain = (String) json.get("universe_domain");
    URI tokenServerUriFromCreds = null;
    try {
      if (tokenServerUriStringFromCreds != null) {
        tokenServerUriFromCreds = new URI(tokenServerUriStringFromCreds);
      }
    } catch (URISyntaxException e) {
      throw new IOException("Token server URI specified in 'token_uri' could not be parsed.");
    }

    if (clientId == null
        || clientEmail == null
        || privateKeyPkcs8 == null
        || privateKeyId == null) {
      throw new IOException(
          "Error reading service account credential from JSON, "
              + "expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'.");
    }

    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServerUriFromCreds)
            .setProjectId(projectId)
            .setQuotaProjectId(quotaProjectId)
            .setUniverseDomain(universeDomain);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Factory with minimum identifying information using PKCS#8 for the private key.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId Private key identifier for the service account. May be null.
   * @param scopes Scope strings for the APIs to be called. May be null or an empty collection,
   *     which results in a credential that must have createScoped called before use.
   * @return New ServiceAccountCredentials created from a private key.
   * @throws IOException if the credential cannot be created from the private key.
   */
  public static ServiceAccountCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      Collection<String> scopes)
      throws IOException {
    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setScopes(scopes);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Factory with minimum identifying information using PKCS#8 for the private key.
   *
   * @param clientId client ID of the service account from the console. May be null.
   * @param clientEmail client email address of the service account from the console
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId private key identifier for the service account. May be null.
   * @param scopes scope strings for the APIs to be called. May be null or an empty collection.
   * @param defaultScopes default scope strings for the APIs to be called. May be null or an empty.
   * @return new ServiceAccountCredentials created from a private key
   * @throws IOException if the credential cannot be created from the private key
   */
  public static ServiceAccountCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      Collection<String> scopes,
      Collection<String> defaultScopes)
      throws IOException {
    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setScopes(scopes, defaultScopes);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Factory with minimum identifying information and custom transport using PKCS#8 for the private
   * key.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId Private key identifier for the service account. May be null.
   * @param scopes Scope strings for the APIs to be called. May be null or an empty collection,
   *     which results in a credential that must have createScoped called before use.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @param tokenServerUri URI of the end point that provides tokens.
   * @return New ServiceAccountCredentials created from a private key.
   * @throws IOException if the credential cannot be created from the private key.
   */
  public static ServiceAccountCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      Collection<String> scopes,
      HttpTransportFactory transportFactory,
      URI tokenServerUri)
      throws IOException {

    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setScopes(scopes)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServerUri);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Factory with minimum identifying information and custom transport using PKCS#8 for the private
   * key.
   *
   * @param clientId client ID of the service account from the console. May be null.
   * @param clientEmail client email address of the service account from the console
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId private key identifier for the service account. May be null.
   * @param scopes scope strings for the APIs to be called. May be null or an empty collection,
   *     which results in a credential that must have createScoped called before use.
   * @param defaultScopes default scope strings for the APIs to be called. May be null or an empty
   *     collection, which results in a credential that must have createScoped called before use.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @param tokenServerUri URI of the end point that provides tokens
   * @return new ServiceAccountCredentials created from a private key
   * @throws IOException if the credential cannot be created from the private key
   */
  public static ServiceAccountCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      Collection<String> scopes,
      Collection<String> defaultScopes,
      HttpTransportFactory transportFactory,
      URI tokenServerUri)
      throws IOException {

    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setScopes(scopes, defaultScopes)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServerUri);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Factory with minimum identifying information and custom transport using PKCS#8 for the private
   * key.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId Private key identifier for the service account. May be null.
   * @param scopes Scope strings for the APIs to be called. May be null or an empty collection,
   *     which results in a credential that must have createScoped called before use.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @param tokenServerUri URI of the end point that provides tokens.
   * @param serviceAccountUser The email of the user account to impersonate, if delegating
   *     domain-wide authority to the service account.
   * @return New ServiceAccountCredentials created from a private key.
   * @throws IOException if the credential cannot be created from the private key.
   */
  public static ServiceAccountCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      Collection<String> scopes,
      HttpTransportFactory transportFactory,
      URI tokenServerUri,
      String serviceAccountUser)
      throws IOException {

    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setScopes(scopes)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServerUri)
            .setServiceAccountUser(serviceAccountUser);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Factory with minimum identifying information and custom transport using PKCS#8 for the private
   * key.
   *
   * @param clientId client ID of the service account from the console. May be null.
   * @param clientEmail client email address of the service account from the console
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId private key identifier for the service account. May be null.
   * @param scopes scope strings for the APIs to be called. May be null or an empty collection,
   *     which results in a credential that must have createScoped called before use.
   * @param defaultScopes default scope strings for the APIs to be called. May be null or an empty
   *     collection, which results in a credential that must have createScoped called before use.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @param tokenServerUri URI of the end point that provides tokens
   * @param serviceAccountUser the email of the user account to impersonate, if delegating
   *     domain-wide authority to the service account.
   * @return new ServiceAccountCredentials created from a private key
   * @throws IOException if the credential cannot be created from the private key
   */
  public static ServiceAccountCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      Collection<String> scopes,
      Collection<String> defaultScopes,
      HttpTransportFactory transportFactory,
      URI tokenServerUri,
      String serviceAccountUser)
      throws IOException {
    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(clientId)
            .setClientEmail(clientEmail)
            .setPrivateKeyId(privateKeyId)
            .setScopes(scopes, defaultScopes)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServerUri)
            .setServiceAccountUser(serviceAccountUser);

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Internal constructor
   *
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param builder A builder for {@link ServiceAccountCredentials} See {@link
   *     ServiceAccountCredentials.Builder}
   * @return an instance of {@link ServiceAccountCredentials}
   */
  static ServiceAccountCredentials fromPkcs8(
      String privateKeyPkcs8, ServiceAccountCredentials.Builder builder) throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(privateKeyPkcs8);
    builder.setPrivateKey(privateKey);

    return new ServiceAccountCredentials(builder);
  }

  /**
   * Returns credentials defined by a Service Account key file in JSON format from the Google
   * Developers Console.
   *
   * <p>Important: If you accept a credential configuration (credential JSON/File/Stream) from an
   * external source for authentication to Google Cloud Platform, you must validate it before
   * providing it to any Google API or library. Providing an unvalidated credential configuration to
   * Google APIs can compromise the security of your systems and data. For more information, refer
   * to {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}.
   *
   * @param credentialsStream the stream with the credential definition.
   * @return the credential defined by the credentialsStream.
   * @throws IOException if the credential cannot be created from the stream.
   */
  public static ServiceAccountCredentials fromStream(InputStream credentialsStream)
      throws IOException {
    return fromStream(credentialsStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Returns credentials defined by a Service Account key file in JSON format from the Google
   * Developers Console.
   *
   * <p>Important: If you accept a credential configuration (credential JSON/File/Stream) from an
   * external source for authentication to Google Cloud Platform, you must validate it before
   * providing it to any Google API or library. Providing an unvalidated credential configuration to
   * Google APIs can compromise the security of your systems and data. For more information, refer
   * to {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}.
   *
   * @param credentialsStream the stream with the credential definition.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @return the credential defined by the credentialsStream.
   * @throws IOException if the credential cannot be created from the stream.
   */
  public static ServiceAccountCredentials fromStream(
      InputStream credentialsStream, HttpTransportFactory transportFactory) throws IOException {
    Preconditions.checkNotNull(transportFactory);
    GenericJson fileContents = parseJsonInputStream(credentialsStream);
    String fileType = extractFromJson(fileContents, "type");
    if (fileType.equals(GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType())) {
      return fromJson(fileContents, transportFactory);
    }

    throw new IOException(
        String.format(
            "Error reading credentials from stream, 'type' value '%s' not recognized."
                + " Expecting '%s'.",
            fileType, GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType()));
  }

  /** Returns whether the scopes are empty, meaning createScoped must be called before use. */
  @Override
  public boolean createScopedRequired() {
    return scopes.isEmpty() && defaultScopes.isEmpty();
  }

  /** Returns true if credential is configured domain wide delegation */
  @VisibleForTesting
  boolean isConfiguredForDomainWideDelegation() {
    return serviceAccountUser != null && serviceAccountUser.length() > 0;
  }

  private GenericData parseResponseAs(HttpResponse response) throws IOException {
    GenericData genericData = response.parseAs(GenericData.class);
    LoggingUtils.logResponsePayload(genericData, LOGGER_PROVIDER, "Response payload");
    return genericData;
  }

  /**
   * Refreshes the OAuth2 access token by getting a new access token using a JSON Web Token (JWT).
   */
  @Override
  public AccessToken refreshAccessToken() throws IOException {
    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTime = clock.currentTimeMillis();
    String assertion = createAssertion(jsonFactory, currentTime);

    GenericData tokenRequest = new GenericData();
    tokenRequest.set("grant_type", GRANT_TYPE);
    tokenRequest.set("assertion", assertion);
    UrlEncodedContent content = new UrlEncodedContent(tokenRequest);

    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(tokenServerUri), content);

    MetricsUtils.setMetricsHeader(
        request,
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.ACCESS_TOKEN_REQUEST, getMetricsCredentialType()));
    if (this.defaultRetriesEnabled) {
      request.setNumberOfRetries(OAuth2Utils.DEFAULT_NUMBER_OF_RETRIES);
    } else {
      request.setNumberOfRetries(0);
    }
    request.setParser(new JsonObjectParser(jsonFactory));

    LoggingUtils.logRequest(request, LOGGER_PROVIDER, "Sending request to refresh access token");
    ExponentialBackOff backoff =
        new ExponentialBackOff.Builder()
            .setInitialIntervalMillis(OAuth2Utils.INITIAL_RETRY_INTERVAL_MILLIS)
            .setRandomizationFactor(OAuth2Utils.RETRY_RANDOMIZATION_FACTOR)
            .setMultiplier(OAuth2Utils.RETRY_MULTIPLIER)
            .build();

    request.setUnsuccessfulResponseHandler(
        new HttpBackOffUnsuccessfulResponseHandler(backoff)
            .setBackOffRequired(
                response -> {
                  int code = response.getStatusCode();
                  return OAuth2Utils.TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES.contains(code);
                }));

    request.setIOExceptionHandler(new HttpBackOffIOExceptionHandler(backoff));
    HttpResponse response;

    String errorTemplate = "Error getting access token for service account: %s, iss: %s";

    try {
      response = request.execute();
      LoggingUtils.logResponse(
          response, LOGGER_PROVIDER, "Received response for refresh access token");
    } catch (HttpResponseException re) {
      String message = String.format(errorTemplate, re.getMessage(), getIssuer());
      throw GoogleAuthException.createWithTokenEndpointResponseException(re, message);
    } catch (IOException e) {
      throw GoogleAuthException.createWithTokenEndpointIOException(
          e, String.format(errorTemplate, e.getMessage(), getIssuer()));
    }

    GenericData responseData = parseResponseAs(response);
    String accessToken =
        OAuth2Utils.validateString(responseData, "access_token", PARSE_ERROR_PREFIX);
    int expiresInSeconds =
        OAuth2Utils.validateInt32(responseData, "expires_in", PARSE_ERROR_PREFIX);
    long expiresAtMilliseconds = clock.currentTimeMillis() + expiresInSeconds * 1000L;
    return new AccessToken(accessToken, new Date(expiresAtMilliseconds));
  }

  /**
   * Returns a Google ID Token from either the OAuth or IAM Endpoint. For Credentials that are in
   * the Google Default Universe (googleapis.com), the ID Token will be retrieved from the Oauth
   * Endpoint. Otherwise, it will be retrieved from the IAM Endpoint.
   *
   * @param targetAudience the aud: field the IdToken should include.
   * @param options list of Credential specific options for the token. Currently, unused for
   *     ServiceAccountCredentials.
   * @throws IOException if the attempt to get an IdToken failed
   * @return IdToken object which includes the raw id_token, expiration and audience
   */
  @Override
  public IdToken idTokenWithAudience(String targetAudience, List<Option> options)
      throws IOException {
    return isDefaultUniverseDomain()
        ? getIdTokenOauthEndpoint(targetAudience)
        : getIdTokenIamEndpoint(targetAudience);
  }

  /**
   * Uses the OAuth Endpoint to generate an ID token. Assertions and grant_type are sent in the
   * request body.
   */
  private IdToken getIdTokenOauthEndpoint(String targetAudience) throws IOException {
    long currentTime = clock.currentTimeMillis();
    String assertion =
        createAssertionForIdToken(currentTime, tokenServerUri.toString(), targetAudience);

    Map<String, Object> requestParams =
        ImmutableMap.of("grant_type", GRANT_TYPE, "assertion", assertion);
    GenericData tokenRequest = new GenericData();
    requestParams.forEach(tokenRequest::set);
    UrlEncodedContent content = new UrlEncodedContent(tokenRequest);

    HttpRequest request = buildIdTokenRequest(tokenServerUri, transportFactory, content);
    // add metric header
    MetricsUtils.setMetricsHeader(
        request,
        MetricsUtils.getGoogleCredentialsMetricsHeader(
            RequestType.ID_TOKEN_REQUEST, getMetricsCredentialType()));

    LoggingUtils.logRequest(request, LOGGER_PROVIDER, "Sending request to get ID token");
    HttpResponse httpResponse = executeRequest(request);

    LoggingUtils.logResponse(
        httpResponse, LOGGER_PROVIDER, "Received response for ID token request");
    GenericData responseData = parseResponseAs(httpResponse);
    String rawToken = OAuth2Utils.validateString(responseData, "id_token", PARSE_ERROR_PREFIX);
    return IdToken.create(rawToken);
  }

  /**
   * Use IAM generateIdToken endpoint to obtain an ID token.
   *
   * <p>This flow works as follows:
   *
   * <ol>
   *   <li>Create a self-signed jwt with `https://www.googleapis.com/auth/iam` as the scope.
   *   <li>Use the self-signed jwt as the access token, and make a POST request to IAM
   *       generateIdToken endpoint.
   *   <li>If the request is successfully, it will return {"token":"the ID token"}. Extract the ID
   *       token.
   * </ol>
   */
  private IdToken getIdTokenIamEndpoint(String targetAudience) throws IOException {
    JwtCredentials selfSignedJwtCredentials =
        createSelfSignedJwtCredentials(
            null, ImmutableList.of("https://www.googleapis.com/auth/iam"));
    Map<String, List<String>> responseMetadata = selfSignedJwtCredentials.getRequestMetadata(null);
    // JwtCredentials will return a map with one entry ("Authorization" -> List with size 1)
    String accessToken = responseMetadata.get(AuthHttpConstants.AUTHORIZATION).get(0);

    // Do not check user options. These params are always set regardless of options configured
    Map<String, Object> requestParams =
        ImmutableMap.of("audience", targetAudience, "includeEmail", "true", "useEmailAzp", "true");
    GenericData tokenRequest = new GenericData();
    requestParams.forEach(tokenRequest::set);
    UrlEncodedContent content = new UrlEncodedContent(tokenRequest);

    // Create IAM Token URI in this method instead of in the constructor because
    // `getUniverseDomain()` throws an IOException that would need to be caught
    URI iamIdTokenUri =
        URI.create(
            String.format(IamUtils.IAM_ID_TOKEN_ENDPOINT_FORMAT, getUniverseDomain(), clientEmail));
    HttpRequest request = buildIdTokenRequest(iamIdTokenUri, transportFactory, content);
    // Use the Access Token from the SSJWT to request the ID Token from IAM Endpoint
    request.setHeaders(new HttpHeaders().set(AuthHttpConstants.AUTHORIZATION, accessToken));

    LoggingUtils.logRequest(request, LOGGER_PROVIDER, "Sending request to get ID token");
    HttpResponse httpResponse = executeRequest(request);
    LoggingUtils.logResponse(
        httpResponse, LOGGER_PROVIDER, "Received response for ID token request");

    GenericData responseData = parseResponseAs(httpResponse);
    // IAM Endpoint returns `token` instead of `id_token`
    String rawToken = OAuth2Utils.validateString(responseData, "token", PARSE_ERROR_PREFIX);
    return IdToken.create(rawToken);
  }

  // Build a default POST HttpRequest to be used for both Oauth and IAM endpoints
  private HttpRequest buildIdTokenRequest(
      URI uri, HttpTransportFactory transportFactory, HttpContent content) throws IOException {
    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(uri), content);
    request.setParser(new JsonObjectParser(jsonFactory));
    return request;
  }

  private HttpResponse executeRequest(HttpRequest request) throws IOException {
    HttpResponse response;
    try {
      response = request.execute();
    } catch (IOException e) {
      throw new IOException(
          String.format(
              "Error getting id token for service account: %s, iss: %s",
              e.getMessage(), getIssuer()),
          e);
    }
    return response;
  }

  /**
   * Clones the service account with the specified default retries.
   *
   * @param defaultRetriesEnabled a flag enabling or disabling default retries
   * @return GoogleCredentials with the specified retry configuration.
   */
  @Override
  public ServiceAccountCredentials createWithCustomRetryStrategy(boolean defaultRetriesEnabled) {
    return this.toBuilder().setDefaultRetriesEnabled(defaultRetriesEnabled).build();
  }

  /**
   * Clones the service account with the specified scopes.
   *
   * <p>Should be called before use for instances with empty scopes.
   */
  @Override
  public GoogleCredentials createScoped(Collection<String> newScopes) {
    return createScoped(newScopes, null);
  }

  /**
   * Clones the service account with the specified scopes. The Access Token is invalidated even if
   * the same scopes are provided. Access Tokens contain information of the internal values (i.e.
   * scope). If an internal value (scope) is modified, then the existing Access Token is no longer
   * valid and should not be re-used.
   *
   * <p>Should be called before use for instances with empty scopes.
   */
  @Override
  public GoogleCredentials createScoped(
      Collection<String> newScopes, Collection<String> newDefaultScopes) {
    return this.toBuilder().setScopes(newScopes, newDefaultScopes).setAccessToken(null).build();
  }

  /**
   * Clones the service account with a new lifetime value.
   *
   * @param lifetime life time value in seconds. The value should be at most 43200 (12 hours). If
   *     the token is used for calling a Google API, then the value should be at most 3600 (1 hour).
   *     If the given value is 0, then the default value 3600 will be used when creating the
   *     credentials.
   * @return the cloned service account credentials with the given custom life time
   */
  public ServiceAccountCredentials createWithCustomLifetime(int lifetime) {
    return this.toBuilder().setLifetime(lifetime).build();
  }

  /**
   * Clones the service account with a new useJwtAccessWithScope value. This flag will be ignored if
   * universeDomain field is different from {@link Credentials#GOOGLE_DEFAULT_UNIVERSE}.
   *
   * @param useJwtAccessWithScope whether self-signed JWT with scopes should be used
   * @return the cloned service account credentials with the given useJwtAccessWithScope
   */
  public ServiceAccountCredentials createWithUseJwtAccessWithScope(boolean useJwtAccessWithScope) {
    return this.toBuilder().setUseJwtAccessWithScope(useJwtAccessWithScope).build();
  }

  @Override
  public GoogleCredentials createDelegated(String user) {
    return this.toBuilder().setServiceAccountUser(user).build();
  }

  public final String getClientId() {
    return clientId;
  }

  public final String getClientEmail() {
    return clientEmail;
  }

  public final PrivateKey getPrivateKey() {
    return privateKey;
  }

  public final String getPrivateKeyId() {
    return privateKeyId;
  }

  public final Collection<String> getScopes() {
    return scopes;
  }

  public final Collection<String> getDefaultScopes() {
    return defaultScopes;
  }

  public final String getServiceAccountUser() {
    return serviceAccountUser;
  }

  /**
   * @return the projectId set in the SA Key file or the user set projectId
   */
  @Override
  public final String getProjectId() {
    return projectId;
  }

  public final URI getTokenServerUri() {
    return tokenServerUri;
  }

  private String getIssuer() {
    return this.clientEmail;
  }

  @VisibleForTesting
  int getLifetime() {
    return lifetime;
  }

  public boolean getUseJwtAccessWithScope() {
    return useJwtAccessWithScope;
  }

  @VisibleForTesting
  JwtCredentials getSelfSignedJwtCredentialsWithScope() {
    return selfSignedJwtCredentialsWithScope;
  }

  @Override
  public String getAccount() {
    return getClientEmail();
  }

  @Override
  public byte[] sign(byte[] toSign) {
    try {
      Signature signer = Signature.getInstance(OAuth2Utils.SIGNATURE_ALGORITHM);
      signer.initSign(getPrivateKey());
      signer.update(toSign);
      return signer.sign();
    } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException ex) {
      throw new SigningException("Failed to sign the provided bytes", ex);
    }
  }

  /**
   * Returns a new JwtCredentials instance with modified claims.
   *
   * @param newClaims new claims. Any unspecified claim fields will default to the current values.
   * @return new credentials
   */
  @Override
  public JwtCredentials jwtWithClaims(JwtClaims newClaims) {
    JwtClaims.Builder claimsBuilder =
        JwtClaims.newBuilder().setIssuer(getIssuer()).setSubject(clientEmail);
    return JwtCredentials.newBuilder()
        .setPrivateKey(privateKey)
        .setPrivateKeyId(privateKeyId)
        .setJwtClaims(claimsBuilder.build().merge(newClaims))
        .setClock(clock)
        .build();
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        clientId,
        clientEmail,
        privateKey,
        privateKeyId,
        transportFactoryClassName,
        tokenServerUri,
        scopes,
        defaultScopes,
        lifetime,
        useJwtAccessWithScope,
        defaultRetriesEnabled,
        super.hashCode());
  }

  @Override
  protected ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("clientId", clientId)
        .add("clientEmail", clientEmail)
        .add("privateKeyId", privateKeyId)
        .add("transportFactoryClassName", transportFactoryClassName)
        .add("tokenServerUri", tokenServerUri)
        .add("scopes", scopes)
        .add("defaultScopes", defaultScopes)
        .add("serviceAccountUser", serviceAccountUser)
        .add("lifetime", lifetime)
        .add("useJwtAccessWithScope", useJwtAccessWithScope)
        .add("defaultRetriesEnabled", defaultRetriesEnabled);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ServiceAccountCredentials)) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }

    ServiceAccountCredentials other = (ServiceAccountCredentials) obj;
    return Objects.equals(this.clientId, other.clientId)
        && Objects.equals(this.clientEmail, other.clientEmail)
        && Objects.equals(this.privateKey, other.privateKey)
        && Objects.equals(this.privateKeyId, other.privateKeyId)
        && Objects.equals(this.transportFactoryClassName, other.transportFactoryClassName)
        && Objects.equals(this.tokenServerUri, other.tokenServerUri)
        && Objects.equals(this.scopes, other.scopes)
        && Objects.equals(this.defaultScopes, other.defaultScopes)
        && Objects.equals(this.lifetime, other.lifetime)
        && Objects.equals(this.useJwtAccessWithScope, other.useJwtAccessWithScope)
        && Objects.equals(this.defaultRetriesEnabled, other.defaultRetriesEnabled);
  }

  String createAssertion(JsonFactory jsonFactory, long currentTime) throws IOException {
    JsonWebSignature.Header header = new JsonWebSignature.Header();
    header.setAlgorithm("RS256");
    header.setType("JWT");
    header.setKeyId(privateKeyId);

    JsonWebToken.Payload payload = new JsonWebToken.Payload();
    payload.setIssuer(getIssuer());
    payload.setIssuedAtTimeSeconds(currentTime / 1000);
    payload.setExpirationTimeSeconds(currentTime / 1000 + this.lifetime);
    payload.setSubject(serviceAccountUser);
    if (scopes.isEmpty()) {
      payload.put("scope", Joiner.on(' ').join(defaultScopes));
    } else {
      payload.put("scope", Joiner.on(' ').join(scopes));
    }

    payload.setAudience(OAuth2Utils.TOKEN_SERVER_URI.toString());
    String assertion;

    try {
      assertion = JsonWebSignature.signUsingRsaSha256(privateKey, jsonFactory, header, payload);
    } catch (GeneralSecurityException e) {
      throw new IOException(
          "Error signing service account access token request with private key.", e);
    }
    return assertion;
  }

  @VisibleForTesting
  String createAssertionForIdToken(long currentTime, String audience, String targetAudience)
      throws IOException {
    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    JsonWebSignature.Header header = new JsonWebSignature.Header();
    header.setAlgorithm("RS256");
    header.setType("JWT");
    header.setKeyId(privateKeyId);

    JsonWebToken.Payload payload = new JsonWebToken.Payload();
    payload.setIssuer(getIssuer());
    payload.setIssuedAtTimeSeconds(currentTime / 1000);
    payload.setExpirationTimeSeconds(currentTime / 1000 + this.lifetime);
    payload.setSubject(serviceAccountUser);

    if (audience == null) {
      payload.setAudience(OAuth2Utils.TOKEN_SERVER_URI.toString());
    } else {
      payload.setAudience(audience);
    }

    try {
      payload.set("target_audience", targetAudience);

      return JsonWebSignature.signUsingRsaSha256(privateKey, jsonFactory, header, payload);
    } catch (GeneralSecurityException e) {
      throw new IOException(
          "Error signing service account access token request with private key.", e);
    }
  }

  /**
   * Self-signed JWT uses uri as audience, which should have the "https://{host}/" format. For
   * instance, if the uri is "https://compute.googleapis.com/compute/v1/projects/", then this
   * function returns "https://compute.googleapis.com/".
   */
  @VisibleForTesting
  static URI getUriForSelfSignedJWT(URI uri) {
    if (uri == null || uri.getScheme() == null || uri.getHost() == null) {
      return uri;
    }
    try {
      return new URI(uri.getScheme(), uri.getHost(), "/", null);
    } catch (URISyntaxException unused) {
      return uri;
    }
  }

  @VisibleForTesting
  JwtCredentials createSelfSignedJwtCredentials(final URI uri) {
    return createSelfSignedJwtCredentials(uri, scopes.isEmpty() ? defaultScopes : scopes);
  }

  @VisibleForTesting
  JwtCredentials createSelfSignedJwtCredentials(final URI uri, Collection<String> scopes) {
    // Create a JwtCredentials for self-signed JWT. See https://google.aip.dev/auth/4111.
    JwtClaims.Builder claimsBuilder =
        JwtClaims.newBuilder().setIssuer(clientEmail).setSubject(clientEmail);

    if (uri == null) {
      // If uri is null, use scopes.
      String scopeClaim = Joiner.on(' ').join(scopes);
      claimsBuilder.setAdditionalClaims(Collections.singletonMap("scope", scopeClaim));
    } else {
      // otherwise, use audience with the uri.
      claimsBuilder.setAudience(getUriForSelfSignedJWT(uri).toString());
    }
    return JwtCredentials.newBuilder()
        .setPrivateKey(privateKey)
        .setPrivateKeyId(privateKeyId)
        .setJwtClaims(claimsBuilder.build())
        .setClock(clock)
        .build();
  }

  @Override
  public void getRequestMetadata(
      final URI uri, Executor executor, final RequestMetadataCallback callback) {
    // For default universe Self-signed JWT could be explicitly disabled with
    // {@code ServiceAccountCredentials.useJwtAccessWithScope} flag.
    // If universe is non-default, it only supports self-signed JWT, and it is always allowed.
    try {
      if (this.useJwtAccessWithScope || !isDefaultUniverseDomain()) {
        // This will call getRequestMetadata(URI uri), which handles self-signed JWT logic.
        // Self-signed JWT doesn't use network, so here we do a blocking call to improve
        // efficiency. executor will be ignored since it is intended for async operation.
        blockingGetToCallback(uri, callback);
      } else {
        super.getRequestMetadata(uri, executor, callback);
      }
    } catch (IOException e) {
      // Wrap here because throwing exception would be breaking change.
      // This should not happen for this credential type.
      throw new IllegalStateException(e);
    }
  }

  /** Provide the request metadata by putting an access JWT directly in the metadata. */
  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    if (createScopedRequired() && uri == null) {
      throw new IOException(
          "Scopes and uri are not configured for service account. Specify the scopes"
              + " by calling createScoped or passing scopes to constructor or"
              + " providing uri to getRequestMetadata.");
    }

    if (isDefaultUniverseDomain()) {
      return getRequestMetadataForGdu(uri);
    } else {
      return getRequestMetadataForNonGdu(uri);
    }
  }

  @Override
  public CredentialTypeForMetrics getMetricsCredentialType() {
    return shouldUseAssertionFlowForGdu()
        ? CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT
        : CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_JWT;
  }

  boolean shouldUseAssertionFlowForGdu() {
    // If scopes are provided, but we cannot use self-signed JWT or domain-wide delegation is
    // configured then use scopes to get access token.
    return ((!createScopedRequired() && !useJwtAccessWithScope)
        || isConfiguredForDomainWideDelegation());
  }

  private Map<String, List<String>> getRequestMetadataForGdu(URI uri) throws IOException {
    return shouldUseAssertionFlowForGdu()
        ? super.getRequestMetadata(uri)
        : getRequestMetadataWithSelfSignedJwt(uri);
  }

  private Map<String, List<String>> getRequestMetadataForNonGdu(URI uri) throws IOException {
    // Self Signed JWT is not supported for domain-wide delegation for non-GDU universes
    if (isConfiguredForDomainWideDelegation()) {
      throw new IOException(
          String.format(
              "Service Account user is configured for the credential. "
                  + "Domain-wide delegation is not supported in universes different than %s.",
              Credentials.GOOGLE_DEFAULT_UNIVERSE));
    }

    return getRequestMetadataWithSelfSignedJwt(uri);
  }

  /** Provide the access JWT for scopes if provided, for uri as aud otherwise */
  @VisibleForTesting
  private Map<String, List<String>> getRequestMetadataWithSelfSignedJwt(URI uri)
      throws IOException {
    // If scopes are provided and self-signed JWT can be used, use self-signed JWT with scopes.
    // Otherwise, use self-signed JWT with uri as the audience.
    JwtCredentials jwtCredentials;
    if (!createScopedRequired()) {
      // Create selfSignedJwtCredentialsWithScope when needed and reuse it for better performance.
      if (selfSignedJwtCredentialsWithScope == null) {
        selfSignedJwtCredentialsWithScope = createSelfSignedJwtCredentials(null);
      }
      jwtCredentials = selfSignedJwtCredentialsWithScope;
    } else {
      // Create JWT credentials with the uri as audience.
      jwtCredentials = createSelfSignedJwtCredentials(uri);
    }

    Map<String, List<String>> requestMetadata = jwtCredentials.getRequestMetadata(null);
    return addQuotaProjectIdToRequestMetadata(quotaProjectId, requestMetadata);
  }

  @SuppressWarnings("unused")
  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    // properly deserialize the transient transportFactory
    input.defaultReadObject();
    transportFactory = newInstance(transportFactoryClassName);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder extends GoogleCredentials.Builder {

    private String clientId;
    private String clientEmail;
    private PrivateKey privateKey;
    private String privateKeyId;
    private String serviceAccountUser;
    private String projectId;
    private URI tokenServerUri;
    private Collection<String> scopes;
    private Collection<String> defaultScopes;
    private HttpTransportFactory transportFactory;
    private int lifetime = DEFAULT_LIFETIME_IN_SECONDS;
    private boolean useJwtAccessWithScope = false;
    private boolean defaultRetriesEnabled = true;

    protected Builder() {}

    protected Builder(ServiceAccountCredentials credentials) {
      super(credentials);
      this.clientId = credentials.clientId;
      this.clientEmail = credentials.clientEmail;
      this.privateKey = credentials.privateKey;
      this.privateKeyId = credentials.privateKeyId;
      this.scopes = credentials.scopes;
      this.defaultScopes = credentials.defaultScopes;
      this.transportFactory = credentials.transportFactory;
      this.tokenServerUri = credentials.tokenServerUri;
      this.serviceAccountUser = credentials.serviceAccountUser;
      this.projectId = credentials.projectId;
      this.lifetime = credentials.lifetime;
      this.useJwtAccessWithScope = credentials.useJwtAccessWithScope;
      this.defaultRetriesEnabled = credentials.defaultRetriesEnabled;
    }

    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setClientEmail(String clientEmail) {
      this.clientEmail = clientEmail;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setPrivateKey(PrivateKey privateKey) {
      this.privateKey = privateKey;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setPrivateKeyString(String privateKeyPkcs8) throws IOException {
      this.privateKey = OAuth2Utils.privateKeyFromPkcs8(privateKeyPkcs8);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setPrivateKeyId(String privateKeyId) {
      this.privateKeyId = privateKeyId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      this.scopes = scopes;
      this.defaultScopes = ImmutableSet.<String>of();
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes, Collection<String> defaultScopes) {
      this.scopes = scopes;
      this.defaultScopes = defaultScopes;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setServiceAccountUser(String serviceAccountUser) {
      this.serviceAccountUser = serviceAccountUser;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setTokenServerUri(URI tokenServerUri) {
      this.tokenServerUri = tokenServerUri;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setLifetime(int lifetime) {
      this.lifetime = lifetime == 0 ? DEFAULT_LIFETIME_IN_SECONDS : lifetime;
      return this;
    }

    /**
     * Sets the useJwtAccessWithScope flag. This flag will be ignored if universeDomain field is
     * different from {@link Credentials#GOOGLE_DEFAULT_UNIVERSE}.
     */
    @CanIgnoreReturnValue
    public Builder setUseJwtAccessWithScope(boolean useJwtAccessWithScope) {
      this.useJwtAccessWithScope = useJwtAccessWithScope;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setDefaultRetriesEnabled(boolean defaultRetriesEnabled) {
      this.defaultRetriesEnabled = defaultRetriesEnabled;
      return this;
    }

    public Builder setUniverseDomain(String universeDomain) {
      super.universeDomain = universeDomain;
      return this;
    }

    public String getClientId() {
      return clientId;
    }

    public String getClientEmail() {
      return clientEmail;
    }

    public PrivateKey getPrivateKey() {
      return privateKey;
    }

    public String getPrivateKeyId() {
      return privateKeyId;
    }

    public Collection<String> getScopes() {
      return scopes;
    }

    public Collection<String> getDefaultScopes() {
      return defaultScopes;
    }

    public String getServiceAccountUser() {
      return serviceAccountUser;
    }

    public String getProjectId() {
      return projectId;
    }

    public URI getTokenServerUri() {
      return tokenServerUri;
    }

    public HttpTransportFactory getHttpTransportFactory() {
      return transportFactory;
    }

    public int getLifetime() {
      return lifetime;
    }

    public boolean getUseJwtAccessWithScope() {
      return useJwtAccessWithScope;
    }

    public boolean isDefaultRetriesEnabled() {
      return defaultRetriesEnabled;
    }

    @Override
    public ServiceAccountCredentials build() {
      return new ServiceAccountCredentials(this);
    }
  }
}
