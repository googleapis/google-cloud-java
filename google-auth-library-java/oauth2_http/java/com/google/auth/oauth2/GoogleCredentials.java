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

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.core.ObsoleteApi;
import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/** Base type for credentials for authorizing calls to Google APIs using OAuth2. */
public class GoogleCredentials extends OAuth2Credentials implements QuotaProjectIdProvider {

  private static final long serialVersionUID = -1522852442442473691L;

  static final String QUOTA_PROJECT_ID_HEADER_KEY = "x-goog-user-project";

  /** Internal Enum info mapping for GoogleCredential subclasses */
  enum GoogleCredentialsInfo {
    USER_CREDENTIALS("User Credentials", "authorized_user"),
    SERVICE_ACCOUNT_CREDENTIALS("Service Account Credentials", "service_account"),
    GDCH_CREDENTIALS("GDCH Credentials", "gdch_service_account"),
    EXTERNAL_ACCOUNT_CREDENTIALS("External Account Credentials", "external_account"),
    EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS(
        "External Account Authorized User Credentials", "external_account_authorized_user"),
    IMPERSONATED_CREDENTIALS("Impersonated Credentials", "impersonated_service_account"),
    APP_ENGINE_CREDENTIALS("App Engine Credentials", null),
    CLOUD_SHELL_CREDENTIALS("Cloud Shell Credentials", null),
    COMPUTE_ENGINE_CREDENTIALS("Compute Engine Credentials", null);

    private final String credentialName;
    @Nullable private final String fileType;

    GoogleCredentialsInfo(String credentialName, String fileType) {
      this.credentialName = credentialName;
      this.fileType = fileType;
    }

    String getCredentialName() {
      return credentialName;
    }

    @Nullable
    String getFileType() {
      return fileType;
    }
  }

  // The following package-private fields to provide additional info for errors message
  // Source of the credential (e.g. env var value or well know file location)
  String source;
  // User-friendly name of the Credential class
  String name;
  // Identity of the credential
  // Note: This field may contain data such as serviceAccountEmail which should not be serialized
  transient String principal;

  private final String universeDomain;
  private final boolean isExplicitUniverseDomain;

  protected final String quotaProjectId;

  private static final DefaultCredentialsProvider defaultCredentialsProvider =
      new DefaultCredentialsProvider();

  /**
   * Returns the credentials instance from the given access token.
   *
   * @param accessToken the access token
   * @return the credentials instance
   */
  public static GoogleCredentials create(AccessToken accessToken) {
    return GoogleCredentials.newBuilder().setAccessToken(accessToken).build();
  }

  /**
   * Returns the credentials instance from the given access token and universe domain.
   *
   * @param universeDomain the universe domain
   * @param accessToken the access token
   * @return the credentials instance
   */
  public static GoogleCredentials create(String universeDomain, AccessToken accessToken) {
    return GoogleCredentials.newBuilder()
        .setAccessToken(accessToken)
        .setUniverseDomain(universeDomain)
        .build();
  }

  /**
   * Returns the Application Default Credentials.
   *
   * <p>Returns the Application Default Credentials which are used to identify and authorize the
   * whole application. The following are searched (in order) to find the Application Default
   * Credentials:
   *
   * <ol>
   *   <li>Credentials file pointed to by the {@code GOOGLE_APPLICATION_CREDENTIALS} environment
   *       variable
   *   <li>Credentials provided by the Google Cloud SDK.
   *       <ol>
   *         <li>{@code gcloud auth application-default login} for user account credentials.
   *         <li>{@code gcloud auth application-default login --impersonate-service-account} for
   *             impersonated service account credentials.
   *       </ol>
   *   <li>Google App Engine built-in credentials
   *   <li>Google Cloud Shell built-in credentials
   *   <li>Google Compute Engine built-in credentials
   * </ol>
   *
   * @return the credentials instance.
   * @throws IOException if the credentials cannot be created in the current environment.
   */
  public static GoogleCredentials getApplicationDefault() throws IOException {
    return getApplicationDefault(OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Returns the Application Default Credentials.
   *
   * <p>Returns the Application Default Credentials which are used to identify and authorize the
   * whole application. The following are searched (in order) to find the Application Default
   * Credentials:
   *
   * <ol>
   *   <li>Credentials file pointed to by the {@code GOOGLE_APPLICATION_CREDENTIALS} environment
   *       variable
   *   <li>Credentials provided by the Google Cloud SDK {@code gcloud auth application-default
   *       login} command
   *   <li>Google App Engine built-in credentials
   *   <li>Google Cloud Shell built-in credentials
   *   <li>Google Compute Engine built-in credentials
   * </ol>
   *
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @return the credentials instance.
   * @throws IOException if the credentials cannot be created in the current environment.
   */
  public static GoogleCredentials getApplicationDefault(HttpTransportFactory transportFactory)
      throws IOException {
    Preconditions.checkNotNull(transportFactory);
    return defaultCredentialsProvider.getDefaultCredentials(transportFactory);
  }

  /**
   * This method is obsolete because of a potential security risk. Use the credential specific load
   * method instead
   *
   * <p>Important: This method does not validate the credential configuration. A security risk holds
   * when a credential configuration is accepted from a source that is not under your control and
   * used without validation on your side.
   *
   * <p>If you know that you will be loading credential configurations of a specific type, it is
   * recommended to use a credential-type-specific `fromStream()` method. This will ensure that an
   * unexpected credential type with potential for malicious intent is not loaded unintentionally.
   * You might still have to do validation for certain credential types. Please follow the
   * recommendation for that method. For example, if you want to load only service accounts, you can
   * use: <code>
   *  GoogleCredentials credentials = ServiceAccountCredentials.fromStream(json);
   * </code>. See {@link ServiceAccountCredentials#fromStream(InputStream, HttpTransportFactory)}.
   *
   * <p>If you are loading your credential configuration from an untrusted source and have not
   * mitigated the risks (e.g. by validating the configuration yourself), make these changes as soon
   * as possible to prevent security risks to your environment.
   *
   * <p>Regardless of the method used, it is always your responsibility to validate configurations
   * received from external sources.
   *
   * <p>See the {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}
   * for more details.
   *
   * <p>Returns credentials defined by a JSON file stream.
   *
   * <p>The stream can contain a Service Account key file in JSON format from the Google Developers
   * Console or a stored user credential using the format supported by the Cloud SDK.
   *
   * @param credentialsStream the stream with the credential definition.
   * @return the credential defined by the credentialsStream.
   * @throws IOException if the credential cannot be created from the stream.
   */
  @ObsoleteApi(
      "This method is obsolete because of a potential security risk. Use the credential specific load method instead")
  public static GoogleCredentials fromStream(InputStream credentialsStream) throws IOException {
    return fromStream(credentialsStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Parses the Credential InputStream into JSON for each credential subclass to consume. The
   * Credential InputStream must be non-null and valid.
   */
  static GenericJson parseJsonInputStream(InputStream credentialsStream) throws IOException {
    Preconditions.checkNotNull(credentialsStream);
    JsonObjectParser parser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
    return parser.parseAndClose(credentialsStream, StandardCharsets.UTF_8, GenericJson.class);
  }

  /**
   * Internal helper method to try and extract a field from the json stream and throw an exception
   * if it doesn't exist.
   */
  static String extractFromJson(Map<String, Object> json, String field) throws IOException {
    String fileType = (String) json.get(field);
    if (fileType == null) {
      throw new IOException(
          "Error reading credentials from stream, '" + field + "' field not specified.");
    }
    return fileType;
  }

  /**
   * This method is obsolete because of a potential security risk. Use the credential specific load
   * method instead
   *
   * <p>Important: This method does not validate the credential configuration. A security risk holds
   * when a credential configuration is accepted from a source that is not under your control and
   * used without validation on your side.
   *
   * <p>If you know that you will be loading credential configurations of a specific type, it is
   * recommended to use a credential-type-specific `fromStream()` method. This will ensure that an
   * unexpected credential type with potential for malicious intent is not loaded unintentionally.
   * You might still have to do validation for certain credential types. Please follow the
   * recommendation for that method. For example, if you want to load only service accounts, you can
   * use: <code>
   *  GoogleCredentials credentials = ServiceAccountCredentials.fromStream(json);
   * </code>. See {@link ServiceAccountCredentials#fromStream(InputStream, HttpTransportFactory)}.
   *
   * <p>If you are loading your credential configuration from an untrusted source and have not
   * mitigated the risks (e.g. by validating the configuration yourself), make these changes as soon
   * as possible to prevent security risks to your environment.
   *
   * <p>Regardless of the method used, it is always your responsibility to validate configurations
   * received from external sources.
   *
   * <p>See the {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}
   * for more details.
   *
   * <p>Returns credentials defined by a JSON file stream.
   *
   * <p>The stream can contain a Service Account key file in JSON format from the Google Developers
   * Console or a stored user credential using the format supported by the Cloud SDK.
   *
   * @param credentialsStream the stream with the credential definition.
   * @return the credential defined by the credentialsStream.
   * @throws IOException if the credential cannot be created from the stream.
   */
  @ObsoleteApi(
      "This method is obsolete because of a potential security risk. Use the credential specific load method instead")
  public static GoogleCredentials fromStream(
      InputStream credentialsStream, HttpTransportFactory transportFactory) throws IOException {
    Preconditions.checkNotNull(transportFactory);
    GenericJson fileContents = parseJsonInputStream(credentialsStream);
    String fileType = (String) fileContents.get("type");
    if (fileType == null) {
      throw new IOException("Error reading credentials from stream, 'type' field not specified.");
    }

    if (fileType.equals(GoogleCredentialsInfo.USER_CREDENTIALS.getFileType())) {
      return UserCredentials.fromJson(fileContents, transportFactory);
    }
    if (fileType.equals(GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType())) {
      return ServiceAccountCredentials.fromJson(fileContents, transportFactory);
    }
    if (fileType.equals(GoogleCredentialsInfo.GDCH_CREDENTIALS.getFileType())) {
      return GdchCredentials.fromJson(fileContents);
    }
    if (fileType.equals(GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getFileType())) {
      return ExternalAccountCredentials.fromJson(fileContents, transportFactory);
    }
    if (fileType.equals(
        GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType())) {
      return ExternalAccountAuthorizedUserCredentials.fromJson(fileContents, transportFactory);
    }
    if (fileType.equals(GoogleCredentialsInfo.IMPERSONATED_CREDENTIALS.getFileType())) {
      return ImpersonatedCredentials.fromJson(fileContents, transportFactory);
    }
    throw new IOException(
        String.format(
            "Error reading credentials from stream, 'type' value '%s' not recognized."
                + " Valid values are '%s', '%s', '%s', '%s', '%s', '%s'.",
            fileType,
            GoogleCredentialsInfo.USER_CREDENTIALS.getFileType(),
            GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType(),
            GoogleCredentialsInfo.GDCH_CREDENTIALS.getFileType(),
            GoogleCredentialsInfo.EXTERNAL_ACCOUNT_CREDENTIALS.getFileType(),
            GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType(),
            GoogleCredentialsInfo.IMPERSONATED_CREDENTIALS.getFileType()));
  }

  /**
   * Creates a credential with the provided quota project.
   *
   * @param quotaProject the quota project to set on the credential
   * @return credential with the provided quota project
   */
  public GoogleCredentials createWithQuotaProject(String quotaProject) {
    return this.toBuilder().setQuotaProjectId(quotaProject).build();
  }

  /**
   * Gets the universe domain for the credential.
   *
   * @return An explicit universe domain if it was explicitly provided, invokes the super
   *     implementation otherwise
   */
  @Override
  public String getUniverseDomain() throws IOException {
    return this.universeDomain;
  }

  /**
   * Gets the flag indicating whether universeDomain was explicitly set by the developer.
   *
   * <p>If subclass has a requirement to give priority to developer-set universeDomain, this
   * property must be used to check if the universeDomain value was provided by the user. It could
   * be a default otherwise.
   *
   * @return true if universeDomain value was provided by the developer, false otherwise
   */
  @VisibleForTesting
  protected boolean isExplicitUniverseDomain() {
    return this.isExplicitUniverseDomain;
  }

  /**
   * Checks if universe domain equals to {@link Credentials#GOOGLE_DEFAULT_UNIVERSE}.
   *
   * @return true if universe domain equals to {@link Credentials#GOOGLE_DEFAULT_UNIVERSE}, false
   *     otherwise
   */
  boolean isDefaultUniverseDomain() throws IOException {
    return getUniverseDomain().equals(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  /**
   * Adds quota project ID to requestMetadata if present.
   *
   * @return a new map with quotaProjectId added if needed
   */
  static Map<String, List<String>> addQuotaProjectIdToRequestMetadata(
      String quotaProjectId, Map<String, List<String>> requestMetadata) {
    Preconditions.checkNotNull(requestMetadata);
    Map<String, List<String>> newRequestMetadata = new HashMap<>(requestMetadata);
    if (quotaProjectId != null && !requestMetadata.containsKey(QUOTA_PROJECT_ID_HEADER_KEY)) {
      newRequestMetadata.put(
          QUOTA_PROJECT_ID_HEADER_KEY, Collections.singletonList(quotaProjectId));
    }
    return Collections.unmodifiableMap(newRequestMetadata);
  }

  @Override
  protected Map<String, List<String>> getAdditionalHeaders() {
    Map<String, List<String>> headers = super.getAdditionalHeaders();
    String quotaProjectId = this.getQuotaProjectId();
    if (quotaProjectId != null) {
      return addQuotaProjectIdToRequestMetadata(quotaProjectId, headers);
    }
    return headers;
  }

  /** Default constructor. */
  protected GoogleCredentials() {
    this(new Builder());
  }

  /**
   * Constructor with an explicit access token and quotaProjectId.
   *
   * <p>Deprecated, please use the {@link GoogleCredentials#GoogleCredentials(Builder)} constructor
   * whenever possible.
   *
   * @param accessToken initial or temporary access token
   * @param quotaProjectId a quotaProjectId, a project id to be used for billing purposes
   */
  @Deprecated
  protected GoogleCredentials(AccessToken accessToken, String quotaProjectId) {
    this(
        GoogleCredentials.newBuilder()
            .setAccessToken(accessToken)
            .setQuotaProjectId(quotaProjectId));
  }

  /**
   * Constructor with explicit access token.
   *
   * @param accessToken initial or temporary access token
   */
  @Deprecated
  public GoogleCredentials(AccessToken accessToken) {
    this(accessToken, null);
  }

  /**
   * Constructor that relies on a {@link Builder} to provide all the necessary field values for
   * initialization.
   *
   * @param builder an instance of a builder
   */
  protected GoogleCredentials(Builder builder) {
    super(builder.getAccessToken(), builder.getRefreshMargin(), builder.getExpirationMargin());
    this.quotaProjectId = builder.getQuotaProjectId();

    if (builder.universeDomain == null || builder.universeDomain.trim().isEmpty()) {
      this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
      this.isExplicitUniverseDomain = false;
    } else {
      this.universeDomain = builder.getUniverseDomain();
      this.isExplicitUniverseDomain = true;
    }

    this.source = builder.source;
  }

  /**
   * Constructor with explicit access token and refresh margins.
   *
   * <p>Deprecated, please use the {@link GoogleCredentials#GoogleCredentials(Builder)} constructor
   * whenever possible.
   *
   * @param accessToken initial or temporary access token
   */
  @Deprecated
  protected GoogleCredentials(
      AccessToken accessToken, Duration refreshMargin, Duration expirationMargin) {
    this(
        (Builder)
            GoogleCredentials.newBuilder()
                .setAccessToken(accessToken)
                .setRefreshMargin(refreshMargin)
                .setExpirationMargin(expirationMargin));
  }

  /**
   * A helper for overriding the toString() method. This allows inheritance of super class fields.
   * Extending classes can override this implementation and call super implementation and add more
   * fields. Same cannot be done with overriding the toString() directly.
   *
   * @return an instance of the ToStringHelper that has public fields added
   */
  protected ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .omitNullValues()
        .add("quotaProjectId", this.quotaProjectId)
        .add("universeDomain", this.universeDomain)
        .add("isExplicitUniverseDomain", this.isExplicitUniverseDomain);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof GoogleCredentials)) {
      return false;
    }
    GoogleCredentials other = (GoogleCredentials) obj;
    return Objects.equals(this.quotaProjectId, other.quotaProjectId)
        && Objects.equals(this.universeDomain, other.universeDomain)
        && Objects.equals(this.isExplicitUniverseDomain, other.isExplicitUniverseDomain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.quotaProjectId, this.universeDomain, this.isExplicitUniverseDomain);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  /**
   * The projectId value for a Credential type. Since not all GoogleCredentials subclass have a
   * projectId associated, the projectId may be null. A subset of GoogleCredentials subclasses will
   * override to return their projectId.
   *
   * @return the project id for a Credential type
   */
  public String getProjectId() {
    return null;
  }

  /**
   * Indicates whether the credentials require scopes to be specified via a call to {@link
   * GoogleCredentials#createScoped} before use.
   *
   * @return Whether the credentials require scopes to be specified.
   */
  public boolean createScopedRequired() {
    return false;
  }

  /**
   * If the credentials support scopes, creates a copy of the identity with the specified scopes,
   * invalidates the existing scoped access token; otherwise, return the same instance.
   *
   * @param scopes Collection of scopes to request.
   * @return GoogleCredentials with requested scopes.
   */
  public GoogleCredentials createScoped(Collection<String> scopes) {
    return this;
  }

  /**
   * If the credentials support scopes, creates a copy of the identity with the specified scopes and
   * default scopes; otherwise, returns the same instance. This is mainly used by client libraries.
   *
   * @param scopes Collection of scopes to request.
   * @param defaultScopes Collection of default scopes to request.
   * @return GoogleCredentials with requested scopes.
   */
  public GoogleCredentials createScoped(
      Collection<String> scopes, Collection<String> defaultScopes) {
    return this;
  }

  /**
   * If the credentials support scopes, creates a copy of the identity with the specified scopes;
   * otherwise, returns the same instance.
   *
   * @param scopes Collection of scopes to request.
   * @return GoogleCredentials with requested scopes.
   */
  public GoogleCredentials createScoped(String... scopes) {
    return createScoped(ImmutableList.copyOf(scopes));
  }

  /**
   * If the credentials support automatic retries, creates a copy of the identity with the provided
   * retry strategy
   *
   * @param defaultRetriesEnabled a flag enabling or disabling default retries
   * @return GoogleCredentials with the new default retries configuration.
   */
  public GoogleCredentials createWithCustomRetryStrategy(boolean defaultRetriesEnabled) {
    return this;
  }

  /**
   * If the credentials support domain-wide delegation, creates a copy of the identity so that it
   * impersonates the specified user; otherwise, returns the same instance.
   *
   * @param user User to impersonate.
   * @return GoogleCredentials with a delegated user.
   */
  public GoogleCredentials createDelegated(String user) {
    return this;
  }

  /**
   * Internal method meant to help provide information for how certain Credential objects were
   * initialized by ADC (e.g. The well-known file location or env var)
   */
  GoogleCredentials withSource(String source) {
    return toBuilder().setSource(source).build();
  }

  /**
   * Provides additional information regarding credential initialization source
   *
   * <ul>
   *   <li>credential source - Initialized via the GOOGLE_APPLICATION_CREDENTIALS env var or well
   *       known file type
   *   <li>credential name - The user-friendly name of the credential created
   *   <li>principal - Identity used for the credential
   * </ul>
   *
   * Unknown field values (i.e. null) are not included in the mapping (e.g. ComputeCredentials may
   * not know the principal value until after a call to MDS is made and the field will be excluded
   * if `getCredentialInfo` is called prior to retrieving that value). A new map of the fields is
   * created on every time this method is called as fields may be updated throughout the Credential
   * lifecycle. This mapping is intended to provide information about the Credential that is created
   * via ADC. Some fields may not be known if a Credential is directly created (e.g.
   * `ServiceAccountCredential.fromStream(InputStream)` may not know the source of the file stream).
   * These fields are populated on a best effort basis.
   *
   * @return ImmutableMap of information regarding how the Credential was initialized
   */
  public Map<String, String> getCredentialInfo() {
    Map<String, String> infoMap = new HashMap<>();
    if (!Strings.isNullOrEmpty(source)) {
      infoMap.put("Credential Source", source);
    }
    if (!Strings.isNullOrEmpty(name)) {
      infoMap.put("Credential Name", name);
    }
    if (!Strings.isNullOrEmpty(principal)) {
      infoMap.put("Principal", principal);
    }
    return ImmutableMap.copyOf(infoMap);
  }

  public static class Builder extends OAuth2Credentials.Builder {
    @Nullable protected String quotaProjectId;
    @Nullable protected String universeDomain;
    @Nullable String source;

    protected Builder() {}

    protected Builder(GoogleCredentials credentials) {
      super(credentials);
      this.quotaProjectId = credentials.quotaProjectId;
      if (credentials.isExplicitUniverseDomain) {
        this.universeDomain = credentials.universeDomain;
      }
    }

    protected Builder(GoogleCredentials.Builder builder) {
      setAccessToken(builder.getAccessToken());
      this.quotaProjectId = builder.quotaProjectId;
      this.universeDomain = builder.universeDomain;
    }

    @Override
    public GoogleCredentials build() {
      return new GoogleCredentials(this);
    }

    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      this.quotaProjectId = quotaProjectId;
      return this;
    }

    public Builder setUniverseDomain(String universeDomain) {
      this.universeDomain = universeDomain;
      return this;
    }

    public String getQuotaProjectId() {
      return this.quotaProjectId;
    }

    public String getUniverseDomain() {
      return this.universeDomain;
    }

    Builder setSource(String source) {
      this.source = source;
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setAccessToken(AccessToken token) {
      super.setAccessToken(token);
      return this;
    }
  }
}
