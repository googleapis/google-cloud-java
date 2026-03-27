/*
 * Copyright 2021 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.core.InternalApi;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * Base external account credentials class.
 *
 * <p>Handles initializing external credentials, calls to the Security Token Service, and service
 * account impersonation.
 */
public abstract class ExternalAccountCredentials extends GoogleCredentials {

  private static final long serialVersionUID = 8049126194174465023L;

  static final String EXECUTABLE_SOURCE_KEY = "executable";

  static final String DEFAULT_TOKEN_URL = "https://sts.{UNIVERSE_DOMAIN}/v1/token";
  static final String PROGRAMMATIC_METRICS_HEADER_VALUE = "programmatic";

  private final String transportFactoryClassName;
  private final String audience;
  private final String subjectTokenType;
  private final String tokenUrl;
  private final CredentialSource credentialSource;
  private final Collection<String> scopes;
  private final ServiceAccountImpersonationOptions serviceAccountImpersonationOptions;
  private ExternalAccountMetricsHandler metricsHandler;

  @Nullable private final String tokenInfoUrl;
  @Nullable private final String serviceAccountImpersonationUrl;
  @Nullable private final String clientId;
  @Nullable private final String clientSecret;

  // This is used for Workforce Pools. It is passed to the Security Token Service during token
  // exchange in the `options` param and will be embedded in the token by the Security Token
  // Service.
  @Nullable private final String workforcePoolUserProject;

  protected transient HttpTransportFactory transportFactory;

  @Nullable protected ImpersonatedCredentials impersonatedCredentials;

  private EnvironmentProvider environmentProvider;

  private int connectTimeout;
  private int readTimeout;

  /**
   * Constructor with minimum identifying information and custom HTTP transport. Does not support
   * workforce credentials.
   *
   * @param transportFactory HTTP transport factory, creates the transport used to get access tokens
   * @param audience the Security Token Service audience, which is usually the fully specified
   *     resource name of the workload/workforce pool provider
   * @param subjectTokenType the Security Token Service subject token type based on the OAuth 2.0
   *     token exchange spec. Indicates the type of the security token in the credential file
   * @param tokenUrl the Security Token Service token exchange endpoint
   * @param tokenInfoUrl the endpoint used to retrieve account related information. Required for
   *     gCloud session account identification.
   * @param credentialSource the external credential source
   * @param serviceAccountImpersonationUrl the URL for the service account impersonation request.
   *     This URL is required for some APIs. If this URL is not available, the access token from the
   *     Security Token Service is used directly. May be null.
   * @param quotaProjectId the project used for quota and billing purposes. May be null.
   * @param clientId client ID of the service account from the console. May be null.
   * @param clientSecret client secret of the service account from the console. May be null.
   * @param scopes the scopes to request during the authorization grant. May be null.
   */
  protected ExternalAccountCredentials(
      HttpTransportFactory transportFactory,
      String audience,
      String subjectTokenType,
      String tokenUrl,
      CredentialSource credentialSource,
      @Nullable String tokenInfoUrl,
      @Nullable String serviceAccountImpersonationUrl,
      @Nullable String quotaProjectId,
      @Nullable String clientId,
      @Nullable String clientSecret,
      @Nullable Collection<String> scopes) {
    this(
        transportFactory,
        audience,
        subjectTokenType,
        tokenUrl,
        credentialSource,
        tokenInfoUrl,
        serviceAccountImpersonationUrl,
        quotaProjectId,
        clientId,
        clientSecret,
        scopes,
        /* environmentProvider= */ null);
  }

  /**
   * Constructor with minimum identifying information and custom HTTP transport. Does not support
   * workforce credentials.
   *
   * @param transportFactory HTTP transport factory, creates the transport used to get access tokens
   * @param audience the Security Token Service audience, which is usually the fully specified
   *     resource name of the workload/workforce pool provider
   * @param subjectTokenType the Security Token Service subject token type based on the OAuth 2.0
   *     token exchange spec. Indicates the type of the security token in the credential file
   * @param tokenUrl the Security Token Service token exchange endpoint
   * @param tokenInfoUrl the endpoint used to retrieve account related information. Required for
   *     gCloud session account identification.
   * @param credentialSource the external credential source
   * @param serviceAccountImpersonationUrl the URL for the service account impersonation request.
   *     This URL is required for some APIs. If this URL is not available, the access token from the
   *     Security Token Service is used directly. May be null.
   * @param quotaProjectId the project used for quota and billing purposes. May be null.
   * @param clientId client ID of the service account from the console. May be null.
   * @param clientSecret client secret of the service account from the console. May be null.
   * @param scopes the scopes to request during the authorization grant. May be null.
   * @param environmentProvider the environment provider. May be null. Defaults to {@link
   *     SystemEnvironmentProvider}.
   */
  protected ExternalAccountCredentials(
      HttpTransportFactory transportFactory,
      String audience,
      String subjectTokenType,
      String tokenUrl,
      CredentialSource credentialSource,
      @Nullable String tokenInfoUrl,
      @Nullable String serviceAccountImpersonationUrl,
      @Nullable String quotaProjectId,
      @Nullable String clientId,
      @Nullable String clientSecret,
      @Nullable Collection<String> scopes,
      @Nullable EnvironmentProvider environmentProvider) {
    super(/* accessToken= */ null, quotaProjectId);
    this.transportFactory =
        MoreObjects.firstNonNull(
            transportFactory,
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    this.transportFactoryClassName = checkNotNull(this.transportFactory.getClass().getName());
    this.audience = checkNotNull(audience);
    this.subjectTokenType = checkNotNull(subjectTokenType);
    this.tokenUrl = checkNotNull(tokenUrl);
    this.credentialSource = checkNotNull(credentialSource);
    this.tokenInfoUrl = tokenInfoUrl;
    this.serviceAccountImpersonationUrl = serviceAccountImpersonationUrl;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.scopes =
        (scopes == null || scopes.isEmpty())
            ? Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE)
            : scopes;
    this.environmentProvider =
        environmentProvider == null ? SystemEnvironmentProvider.getInstance() : environmentProvider;
    this.workforcePoolUserProject = null;
    this.serviceAccountImpersonationOptions =
        new ServiceAccountImpersonationOptions(new HashMap<String, Object>());

    validateTokenUrl(tokenUrl);
    if (serviceAccountImpersonationUrl != null) {
      validateServiceAccountImpersonationInfoUrl(serviceAccountImpersonationUrl);
    }

    this.metricsHandler = new ExternalAccountMetricsHandler(this);
    this.name = GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getCredentialName();
  }

  /**
   * Internal constructor with minimum identifying information and custom HTTP transport. See {@link
   * ExternalAccountCredentials.Builder}.
   *
   * @param builder the {@code Builder} object used to construct the credentials.
   */
  protected ExternalAccountCredentials(ExternalAccountCredentials.Builder builder) {
    super(builder);
    this.transportFactory =
        MoreObjects.firstNonNull(
            builder.transportFactory,
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    this.transportFactoryClassName = checkNotNull(this.transportFactory.getClass().getName());
    this.audience = checkNotNull(builder.audience);
    this.subjectTokenType = checkNotNull(builder.subjectTokenType);
    this.credentialSource = builder.credentialSource;
    this.tokenInfoUrl = builder.tokenInfoUrl;
    this.serviceAccountImpersonationUrl = builder.serviceAccountImpersonationUrl;
    this.clientId = builder.clientId;
    this.clientSecret = builder.clientSecret;

    if (builder.tokenUrl == null) {
      this.tokenUrl = DEFAULT_TOKEN_URL.replace("{UNIVERSE_DOMAIN}", this.getUniverseDomain());
    } else {
      this.tokenUrl = builder.tokenUrl;
    }

    this.scopes =
        (builder.scopes == null || builder.scopes.isEmpty())
            ? Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE)
            : builder.scopes;
    this.environmentProvider =
        builder.environmentProvider == null
            ? SystemEnvironmentProvider.getInstance()
            : builder.environmentProvider;
    this.serviceAccountImpersonationOptions =
        builder.serviceAccountImpersonationOptions == null
            ? new ServiceAccountImpersonationOptions(new HashMap<String, Object>())
            : builder.serviceAccountImpersonationOptions;

    this.workforcePoolUserProject = builder.workforcePoolUserProject;
    if (workforcePoolUserProject != null && !isWorkforcePoolConfiguration()) {
      throw new IllegalArgumentException(
          "The workforce_pool_user_project parameter should only be provided for a Workforce Pool configuration.");
    }

    validateTokenUrl(tokenUrl);
    if (serviceAccountImpersonationUrl != null) {
      validateServiceAccountImpersonationInfoUrl(serviceAccountImpersonationUrl);
    }

    this.metricsHandler =
        builder.metricsHandler == null
            ? new ExternalAccountMetricsHandler(this)
            : builder.metricsHandler;

    this.name = GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getCredentialName();
    this.connectTimeout = builder.connectTimeout;
    this.readTimeout = builder.readTimeout;
  }

  ImpersonatedCredentials buildImpersonatedCredentials() {
    if (serviceAccountImpersonationUrl == null) {
      return null;
    }
    // Create a copy of this instance without service account impersonation.
    ExternalAccountCredentials sourceCredentials;
    if (this instanceof AwsCredentials) {
      sourceCredentials =
          AwsCredentials.newBuilder((AwsCredentials) this)
              .setServiceAccountImpersonationUrl(null)
              .build();
    } else if (this instanceof PluggableAuthCredentials) {
      sourceCredentials =
          PluggableAuthCredentials.newBuilder((PluggableAuthCredentials) this)
              .setServiceAccountImpersonationUrl(null)
              .build();
    } else {
      sourceCredentials =
          IdentityPoolCredentials.newBuilder((IdentityPoolCredentials) this)
              .setServiceAccountImpersonationUrl(null)
              .build();
    }

    String targetPrincipal =
        ImpersonatedCredentials.extractTargetPrincipal(serviceAccountImpersonationUrl);
    return ImpersonatedCredentials.newBuilder()
        .setSourceCredentials(sourceCredentials)
        .setHttpTransportFactory(transportFactory)
        .setTargetPrincipal(targetPrincipal)
        .setScopes(new ArrayList<>(scopes))
        .setLifetime(this.serviceAccountImpersonationOptions.lifetime)
        .setIamEndpointOverride(serviceAccountImpersonationUrl)
        .setConnectTimeout(connectTimeout)
        .setReadTimeout(readTimeout)
        .build();
  }

  @Override
  public void getRequestMetadata(
      URI uri, Executor executor, final RequestMetadataCallback callback) {
    super.getRequestMetadata(
        uri,
        executor,
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            metadata = addQuotaProjectIdToRequestMetadata(quotaProjectId, metadata);
            callback.onSuccess(metadata);
          }

          @Override
          public void onFailure(Throwable exception) {
            callback.onFailure(exception);
          }
        });
  }

  @Override
  public String getUniverseDomain() {
    try {
      return super.getUniverseDomain();
    } catch (IOException e) {
      // Throwing an IOException would be a breaking change, so wrap it here.
      // This should not happen for this credential type.
      throw new IllegalStateException(e);
    }
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    Map<String, List<String>> requestMetadata = super.getRequestMetadata(uri);
    return addQuotaProjectIdToRequestMetadata(quotaProjectId, requestMetadata);
  }

  /**
   * Returns credentials defined by a JSON file stream.
   *
   * <p>Returns {@link IdentityPoolCredentials} or {@link AwsCredentials}.
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
  public static ExternalAccountCredentials fromStream(InputStream credentialsStream)
      throws IOException {
    return fromStream(credentialsStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Returns credentials defined by a JSON file stream.
   *
   * <p>Returns a {@link IdentityPoolCredentials} or {@link AwsCredentials}.
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
  public static ExternalAccountCredentials fromStream(
      InputStream credentialsStream, HttpTransportFactory transportFactory) throws IOException {
    Preconditions.checkNotNull(transportFactory);
    GenericJson fileContents = parseJsonInputStream(credentialsStream);
    String fileType = extractFromJson(fileContents, "type");
    if (fileType.equals(GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getFileType())) {
      try {
        return fromJson(fileContents, transportFactory);
      } catch (ClassCastException | IllegalArgumentException e) {
        throw new CredentialFormatException("An invalid input stream was provided.", e);
      }
    }

    throw new IOException(
        String.format(
            "Error reading credentials from stream, 'type' value '%s' not recognized."
                + " Expecting '%s'.",
            fileType, GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getFileType()));
  }

  /**
   * Returns external account credentials defined by JSON using the format generated by gCloud.
   *
   * <p>Important: If you accept a credential configuration (credential JSON/File/Stream) from an
   * external source for authentication to Google Cloud Platform, you must validate it before
   * providing it to any Google API or library. Providing an unvalidated credential configuration to
   * Google APIs can compromise the security of your systems and data. For more information, refer
   * to {@link <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}.
   *
   * @param json a map from the JSON representing the credentials
   * @param transportFactory HTTP transport factory, creates the transport used to get access tokens
   * @return the credentials defined by the JSON
   */
  @SuppressWarnings("unchecked")
  static ExternalAccountCredentials fromJson(
      Map<String, Object> json, HttpTransportFactory transportFactory) {
    String audience = (String) json.get("audience");
    String subjectTokenType = (String) json.get("subject_token_type");
    String tokenUrl = (String) json.get("token_url");

    Map<String, Object> credentialSourceMap = (Map<String, Object>) json.get("credential_source");

    // Optional params.
    String serviceAccountImpersonationUrl =
        getOptional(json, "service_account_impersonation_url", String.class);
    String tokenInfoUrl = getOptional(json, "token_info_url", String.class);
    String clientId = getOptional(json, "client_id", String.class);
    String clientSecret = getOptional(json, "client_secret", String.class);
    String quotaProjectId = getOptional(json, "quota_project_id", String.class);
    String userProject = getOptional(json, "workforce_pool_user_project", String.class);
    String universeDomain = getOptional(json, "universe_domain", String.class);
    Map<String, Object> impersonationOptionsMap =
        getOptional(json, "service_account_impersonation", Map.class);

    if (impersonationOptionsMap == null) {
      impersonationOptionsMap = new HashMap<String, Object>();
    }

    if (isAwsCredential(credentialSourceMap)) {
      return AwsCredentials.newBuilder()
          .setHttpTransportFactory(transportFactory)
          .setAudience(audience)
          .setSubjectTokenType(subjectTokenType)
          .setTokenUrl(tokenUrl)
          .setTokenInfoUrl(tokenInfoUrl)
          .setCredentialSource(new AwsCredentialSource(credentialSourceMap))
          .setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl)
          .setQuotaProjectId(quotaProjectId)
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .setServiceAccountImpersonationOptions(impersonationOptionsMap)
          .setUniverseDomain(universeDomain)
          .build();
    } else if (isPluggableAuthCredential(credentialSourceMap)) {
      return PluggableAuthCredentials.newBuilder()
          .setHttpTransportFactory(transportFactory)
          .setAudience(audience)
          .setSubjectTokenType(subjectTokenType)
          .setTokenUrl(tokenUrl)
          .setTokenInfoUrl(tokenInfoUrl)
          .setCredentialSource(new PluggableAuthCredentialSource(credentialSourceMap))
          .setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl)
          .setQuotaProjectId(quotaProjectId)
          .setClientId(clientId)
          .setClientSecret(clientSecret)
          .setWorkforcePoolUserProject(userProject)
          .setServiceAccountImpersonationOptions(impersonationOptionsMap)
          .setUniverseDomain(universeDomain)
          .build();
    }
    return IdentityPoolCredentials.newBuilder()
        .setHttpTransportFactory(transportFactory)
        .setAudience(audience)
        .setSubjectTokenType(subjectTokenType)
        .setTokenUrl(tokenUrl)
        .setTokenInfoUrl(tokenInfoUrl)
        .setCredentialSource(new IdentityPoolCredentialSource(credentialSourceMap))
        .setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl)
        .setQuotaProjectId(quotaProjectId)
        .setClientId(clientId)
        .setClientSecret(clientSecret)
        .setWorkforcePoolUserProject(userProject)
        .setServiceAccountImpersonationOptions(impersonationOptionsMap)
        .setUniverseDomain(universeDomain)
        .build();
  }

  private static <T> T getOptional(Map<String, Object> json, String fieldName, Class<T> clazz) {
    Object value = json.get(fieldName);
    if (value == null || Data.isNull(value)) {
      return null;
    }
    return clazz.cast(value);
  }

  private static boolean isPluggableAuthCredential(Map<String, Object> credentialSource) {
    // Pluggable Auth is enabled via a nested executable field in the credential source.
    return credentialSource.containsKey(EXECUTABLE_SOURCE_KEY);
  }

  private static boolean isAwsCredential(Map<String, Object> credentialSource) {
    return credentialSource.containsKey("environment_id")
        && ((String) credentialSource.get("environment_id")).startsWith("aws");
  }

  private boolean shouldBuildImpersonatedCredential() {
    return this.serviceAccountImpersonationUrl != null && this.impersonatedCredentials == null;
  }

  /**
   * Exchanges the external credential for a Google Cloud access token.
   *
   * @param stsTokenExchangeRequest the Security Token Service token exchange request
   * @return the access token returned by the Security Token Service
   * @throws OAuthException if the call to the Security Token Service fails
   */
  protected AccessToken exchangeExternalCredentialForAccessToken(
      StsTokenExchangeRequest stsTokenExchangeRequest) throws IOException {
    // Handle service account impersonation if necessary.
    if (this.shouldBuildImpersonatedCredential()) {
      this.impersonatedCredentials = this.buildImpersonatedCredentials();
    }
    if (this.impersonatedCredentials != null) {
      return this.impersonatedCredentials.refreshAccessToken();
    }

    StsRequestHandler.Builder requestHandler =
        StsRequestHandler.newBuilder(
                tokenUrl, stsTokenExchangeRequest, transportFactory.create().createRequestFactory())
            .setConnectTimeout(connectTimeout)
            .setReadTimeout(readTimeout);

    // If this credential was initialized with a Workforce configuration then the
    // workforcePoolUserProject must be passed to the Security Token Service via the internal
    // options param.
    if (isWorkforcePoolConfiguration()) {
      GenericJson options = new GenericJson();
      options.setFactory(OAuth2Utils.JSON_FACTORY);
      options.put("userProject", workforcePoolUserProject);
      requestHandler.setInternalOptions(options.toString());
    }

    // Set BYOID Metrics header.
    HttpHeaders additionalHeaders = new HttpHeaders();
    additionalHeaders.set(
        MetricsUtils.API_CLIENT_HEADER, this.metricsHandler.getExternalAccountMetricsHeader());
    requestHandler.setHeaders(additionalHeaders);

    if (stsTokenExchangeRequest.getInternalOptions() != null) {
      // Overwrite internal options. Let subclass handle setting options.
      requestHandler.setInternalOptions(stsTokenExchangeRequest.getInternalOptions());
    }

    StsTokenExchangeResponse response = requestHandler.build().exchangeToken();
    return response.getAccessToken();
  }

  /**
   * Retrieves the external subject token to be exchanged for a Google Cloud access token.
   *
   * <p>Must be implemented by subclasses as the retrieval method is dependent on the credential
   * source.
   *
   * @return the external subject token
   * @throws IOException if the subject token cannot be retrieved
   */
  public abstract String retrieveSubjectToken() throws IOException;

  public String getAudience() {
    return audience;
  }

  public String getSubjectTokenType() {
    return subjectTokenType;
  }

  public String getTokenUrl() {
    return tokenUrl;
  }

  public String getTokenInfoUrl() {
    return tokenInfoUrl;
  }

  public CredentialSource getCredentialSource() {
    return credentialSource;
  }

  @SuppressWarnings("unused")
  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    // Properly deserialize the transient transportFactory.
    input.defaultReadObject();
    transportFactory = newInstance(transportFactoryClassName);
  }

  @Nullable
  public String getServiceAccountImpersonationUrl() {
    return serviceAccountImpersonationUrl;
  }

  /**
   * @return The service account email to be impersonated, if available
   */
  @Nullable
  public String getServiceAccountEmail() {
    if (serviceAccountImpersonationUrl == null || serviceAccountImpersonationUrl.isEmpty()) {
      return null;
    }
    return ImpersonatedCredentials.extractTargetPrincipal(serviceAccountImpersonationUrl);
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
  public Collection<String> getScopes() {
    return scopes;
  }

  @Nullable
  public String getWorkforcePoolUserProject() {
    return workforcePoolUserProject;
  }

  @Nullable
  public ServiceAccountImpersonationOptions getServiceAccountImpersonationOptions() {
    return serviceAccountImpersonationOptions;
  }

  String getCredentialSourceType() {
    return "unknown";
  }

  EnvironmentProvider getEnvironmentProvider() {
    return environmentProvider;
  }

  /**
   * @return whether the current configuration is for Workforce Pools (which enable 3p user
   *     identities, rather than workloads)
   */
  public boolean isWorkforcePoolConfiguration() {
    Pattern workforceAudiencePattern =
        Pattern.compile("^//iam.googleapis.com/locations/.+/workforcePools/.+/providers/.+$");
    return workforcePoolUserProject != null
        && workforceAudiencePattern.matcher(getAudience()).matches();
  }

  static void validateTokenUrl(String tokenUrl) {
    if (!isValidUrl(tokenUrl)) {
      throw new IllegalArgumentException("The provided token URL is invalid.");
    }
  }

  static void validateServiceAccountImpersonationInfoUrl(String serviceAccountImpersonationUrl) {
    if (!isValidUrl(serviceAccountImpersonationUrl)) {
      throw new IllegalArgumentException(
          "The provided service account impersonation URL is invalid.");
    }
  }

  /** Returns true if the provided URL's scheme is valid and is HTTPS. */
  private static boolean isValidUrl(String url) {
    URI uri;

    try {
      uri = URI.create(url);
    } catch (Exception e) {
      return false;
    }

    // Scheme must be https and host must not be null.
    if (uri.getScheme() == null
        || uri.getHost() == null
        || !"https".equals(uri.getScheme().toLowerCase(Locale.US))) {
      return false;
    }

    return true;
  }

  /**
   * Encapsulates the service account impersonation options portion of the configuration for
   * ExternalAccountCredentials.
   *
   * <p>If token_lifetime_seconds is not specified, the library will default to a 1-hour lifetime.
   *
   * <pre>
   * Sample configuration:
   * {
   *   ...
   *   "service_account_impersonation": {
   *     "token_lifetime_seconds": 2800
   *    }
   * }
   * </pre>
   */
  static final class ServiceAccountImpersonationOptions implements java.io.Serializable {

    private static final long serialVersionUID = 4250771921886280953L;
    private static final int DEFAULT_TOKEN_LIFETIME_SECONDS = 3600;
    private static final int MAXIMUM_TOKEN_LIFETIME_SECONDS = 43200;
    private static final int MINIMUM_TOKEN_LIFETIME_SECONDS = 600;
    private static final String TOKEN_LIFETIME_SECONDS_KEY = "token_lifetime_seconds";

    private final int lifetime;

    final boolean customTokenLifetimeRequested;

    ServiceAccountImpersonationOptions(Map<String, Object> optionsMap) {
      customTokenLifetimeRequested = optionsMap.containsKey(TOKEN_LIFETIME_SECONDS_KEY);
      if (!customTokenLifetimeRequested) {
        lifetime = DEFAULT_TOKEN_LIFETIME_SECONDS;
        return;
      }

      try {
        Object lifetimeValue = optionsMap.get(TOKEN_LIFETIME_SECONDS_KEY);
        if (lifetimeValue instanceof BigDecimal) {
          lifetime = ((BigDecimal) lifetimeValue).intValue();
        } else if (optionsMap.get(TOKEN_LIFETIME_SECONDS_KEY) instanceof Integer) {
          lifetime = (int) lifetimeValue;
        } else {
          lifetime = Integer.parseInt((String) lifetimeValue);
        }
      } catch (NumberFormatException | ArithmeticException e) {
        throw new IllegalArgumentException(
            "Value of \"token_lifetime_seconds\" field could not be parsed into an integer.", e);
      }

      if (lifetime < MINIMUM_TOKEN_LIFETIME_SECONDS || lifetime > MAXIMUM_TOKEN_LIFETIME_SECONDS) {
        throw new IllegalArgumentException(
            String.format(
                "The \"token_lifetime_seconds\" field must be between %s and %s seconds.",
                MINIMUM_TOKEN_LIFETIME_SECONDS, MAXIMUM_TOKEN_LIFETIME_SECONDS));
      }
    }

    int getLifetime() {
      return lifetime;
    }
  }

  /** Base builder for external account credentials. */
  public abstract static class Builder extends GoogleCredentials.Builder {

    protected String audience;
    protected String subjectTokenType;
    protected String tokenUrl;
    protected String tokenInfoUrl;
    protected CredentialSource credentialSource;
    protected EnvironmentProvider environmentProvider;
    protected HttpTransportFactory transportFactory;

    @Nullable protected String serviceAccountImpersonationUrl;
    @Nullable protected String clientId;
    @Nullable protected String clientSecret;
    @Nullable protected Collection<String> scopes;
    @Nullable protected String workforcePoolUserProject;
    @Nullable protected ServiceAccountImpersonationOptions serviceAccountImpersonationOptions;

    protected int connectTimeout = 20000; // Default to 20000ms = 20s
    protected int readTimeout = 20000; // Default to 20000ms = 20s

    /* The field is not being used and value not set. Superseded by the same field in the
    {@link GoogleCredentials.Builder}.
    */
    @Nullable @Deprecated protected String universeDomain;

    @Nullable protected ExternalAccountMetricsHandler metricsHandler;

    protected Builder() {}

    protected Builder(ExternalAccountCredentials credentials) {
      super(credentials);
      this.transportFactory = credentials.transportFactory;
      this.audience = credentials.audience;
      this.subjectTokenType = credentials.subjectTokenType;
      this.tokenUrl = credentials.tokenUrl;
      this.tokenInfoUrl = credentials.tokenInfoUrl;
      this.serviceAccountImpersonationUrl = credentials.serviceAccountImpersonationUrl;
      this.credentialSource = credentials.credentialSource;
      this.clientId = credentials.clientId;
      this.clientSecret = credentials.clientSecret;
      this.scopes = credentials.scopes;
      this.environmentProvider = credentials.environmentProvider;
      this.workforcePoolUserProject = credentials.workforcePoolUserProject;
      this.serviceAccountImpersonationOptions = credentials.serviceAccountImpersonationOptions;
      this.metricsHandler = credentials.metricsHandler;
      this.connectTimeout = credentials.connectTimeout;
      this.readTimeout = credentials.readTimeout;
    }

    /**
     * Sets the HTTP transport factory, creates the transport used to get access tokens.
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
     * Sets the Security Token Service audience, which is usually the fully specified resource name
     * of the workload/workforce pool provider.
     *
     * @param audience the Security Token Service audience to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setAudience(String audience) {
      this.audience = audience;
      return this;
    }

    /**
     * Sets the Security Token Service subject token type based on the OAuth 2.0 token exchange
     * spec. Indicates the type of the security token in the credential file.
     *
     * @param subjectTokenType the Security Token Service subject token type to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(String subjectTokenType) {
      this.subjectTokenType = subjectTokenType;
      return this;
    }

    /**
     * Sets the Security Token Service subject token type based on the OAuth 2.0 token exchange
     * spec. Indicates the type of the security token in the credential file.
     *
     * @param subjectTokenType the {@code SubjectTokenType} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(SubjectTokenTypes subjectTokenType) {
      this.subjectTokenType = subjectTokenType.value;
      return this;
    }

    /**
     * Sets the Security Token Service token exchange endpoint.
     *
     * @param tokenUrl the Security Token Service token exchange url to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setTokenUrl(String tokenUrl) {
      this.tokenUrl = tokenUrl;
      return this;
    }

    /**
     * Sets the external credential source.
     *
     * @param credentialSource the {@code CredentialSource} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setCredentialSource(CredentialSource credentialSource) {
      this.credentialSource = credentialSource;
      return this;
    }

    /**
     * Sets the optional URL used for service account impersonation, which is required for some
     * APIs. If this URL is not available, the access token from the Security Token Service is used
     * directly.
     *
     * @param serviceAccountImpersonationUrl the service account impersonation url to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationUrl(String serviceAccountImpersonationUrl) {
      this.serviceAccountImpersonationUrl = serviceAccountImpersonationUrl;
      return this;
    }

    /**
     * Sets the optional endpoint used to retrieve account related information. Required for gCloud
     * session account identification.
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
     * Sets the optional client ID of the service account from the console.
     *
     * @param clientId the service account client id to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /**
     * Sets the optional client secret of the service account from the console.
     *
     * @param clientSecret the service account client secret to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /**
     * Sets the optional scopes to request during the authorization grant.
     *
     * @param scopes the request scopes to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      this.scopes = scopes;
      return this;
    }

    /**
     * Sets the optional workforce pool user project number when the credential corresponds to a
     * workforce pool and not a workload identity pool. The underlying principal must still have
     * serviceusage.services.use IAM permission to use the project for billing/quota.
     *
     * @param workforcePoolUserProject the workforce pool user project number to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setWorkforcePoolUserProject(String workforcePoolUserProject) {
      this.workforcePoolUserProject = workforcePoolUserProject;
      return this;
    }

    /**
     * Sets the optional service account impersonation options.
     *
     * @param optionsMap the service account impersonation options to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationOptions(Map<String, Object> optionsMap) {
      this.serviceAccountImpersonationOptions = new ServiceAccountImpersonationOptions(optionsMap);
      return this;
    }

    /**
     * Sets the optional universe domain.
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

    /** Warning: Not for public use and can be removed at any time. */
    @InternalApi
    public Builder setConnectTimeout(int connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    /** Warning: Not for public use and can be removed at any time. */
    @InternalApi
    public Builder setReadTimeout(int readTimeout) {
      this.readTimeout = readTimeout;
      return this;
    }

    /**
     * Sets the optional Environment Provider.
     *
     * @param environmentProvider the {@code EnvironmentProvider} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    Builder setEnvironmentProvider(EnvironmentProvider environmentProvider) {
      this.environmentProvider = environmentProvider;
      return this;
    }

    @Override
    public abstract ExternalAccountCredentials build();
  }

  /**
   * Enum specifying values for the subjectTokenType field in {@code ExternalAccountCredentials}.
   */
  public enum SubjectTokenTypes {
    AWS4("urn:ietf:params:aws:token-type:aws4_request"),
    JWT("urn:ietf:params:oauth:token-type:jwt"),
    SAML2("urn:ietf:params:oauth:token-type:saml2"),
    ID_TOKEN("urn:ietf:params:oauth:token-type:id_token");

    public final String value;

    private SubjectTokenTypes(String value) {
      this.value = value;
    }
  }

  /** Base credential source class. Dictates the retrieval method of the external credential. */
  abstract static class CredentialSource implements java.io.Serializable {

    private static final long serialVersionUID = 8204657811562399944L;

    CredentialSource(Map<String, Object> credentialSourceMap) {
      checkNotNull(credentialSourceMap);
    }
  }
}
