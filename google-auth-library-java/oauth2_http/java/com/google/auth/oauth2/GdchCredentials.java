/*
 * Copyright 2022, Google Inc. All rights reserved.
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Clock;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.PemReader;
import com.google.api.client.util.SecurityUtils;
import com.google.api.client.util.StringUtils;
import com.google.api.core.ObsoleteApi;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class GdchCredentials extends GoogleCredentials {
  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(GdchCredentials.class);
  private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";

  /**
   * The expected format version for GDCH credential profiles. Version "1" indicates the initial and
   * currently supported JSON format for these credentials. See go/gdch-python-auth-lib for more
   * info.
   */
  @VisibleForTesting static final String SUPPORTED_JSON_FORMAT_VERSION = "1";

  // Custom URN used by GDCH to identify service account tokens in token exchange requests.
  // See go/gdch-python-auth-lib for more information.
  private static final String SERVICE_ACCOUNT_TOKEN_TYPE =
      "urn:k8s:params:oauth:token-type:serviceaccount";

  private static final String PRIVATE_KEY_PEM_TITLE = "PRIVATE KEY";
  private static final String EC_PRIVATE_KEY_PEM_TITLE = "EC PRIVATE KEY";

  private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;

  private final PrivateKey privateKey;
  private final String privateKeyId;
  private final String projectId;
  private final String serviceIdentityName;
  private final URI tokenServerUri;
  private final String apiAudience;
  private final int lifetime;
  private final String transportFactoryClassName;
  private final String caCertPath;
  private transient HttpTransportFactory transportFactory;

  /**
   * Internal constructor.
   *
   * @param builder A builder for {@link GdchCredentials} See {@link GdchCredentials.Builder}.
   */
  @VisibleForTesting
  GdchCredentials(GdchCredentials.Builder builder) {
    this.projectId = Preconditions.checkNotNull(builder.projectId);
    this.privateKeyId = Preconditions.checkNotNull(builder.privateKeyId);
    this.privateKey = Preconditions.checkNotNull(builder.privateKey);
    this.serviceIdentityName = Preconditions.checkNotNull(builder.serviceIdentityName);
    this.tokenServerUri = Preconditions.checkNotNull(builder.tokenServerUri);
    this.transportFactory = Preconditions.checkNotNull(builder.transportFactory);
    this.transportFactoryClassName = this.transportFactory.getClass().getName();
    this.caCertPath = builder.caCertPath;
    this.apiAudience = builder.apiAudience;
    this.lifetime = builder.lifetime;
    this.name = GoogleCredentialsInfo.GDCH_CREDENTIALS.getCredentialName();
  }

  /**
   * Returns credentials defined by a GdchCredentials key file in JSON format from the Google
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
  public static GdchCredentials fromStream(InputStream credentialsStream) throws IOException {
    return fromStream(credentialsStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Returns credentials defined by a GdchCredentials key file in JSON format from the Google
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
  public static GdchCredentials fromStream(
      InputStream credentialsStream, HttpTransportFactory transportFactory) throws IOException {
    Preconditions.checkNotNull(transportFactory);
    GenericJson fileContents = parseJsonInputStream(credentialsStream);
    String fileType = extractFromJson(fileContents, "type");
    if (fileType.equals(GoogleCredentialsInfo.GDCH_CREDENTIALS.getFileType())) {
      return fromJson(fileContents, transportFactory);
    }

    throw new IOException(
        String.format(
            "Error reading credentials from stream, 'type' value '%s' not recognized."
                + " Expecting '%s'.",
            fileType, GoogleCredentialsInfo.GDCH_CREDENTIALS.getFileType()));
  }

  /**
   * Create GDCH service account credentials defined by JSON.
   *
   * @param json a map from the JSON representing the credentials.
   * @return the GDCH service account credentials defined by the JSON.
   * @throws IOException if the credential cannot be created from the JSON.
   */
  static GdchCredentials fromJson(Map<String, Object> json) throws IOException {
    String caCertPath = (String) json.get("ca_cert_path");
    return fromJson(json, new TransportFactoryForGdch(caCertPath));
  }

  /**
   * Create GDCH service account credentials defined by JSON.
   *
   * @param json a map from the JSON representing the credentials.
   * @param transportFactory HTTP transport factory, creates the transport used to get access
   *     tokens.
   * @return the GDCH service account credentials defined by the JSON.
   * @throws IOException if the credential cannot be created from the JSON.
   */
  @VisibleForTesting
  static GdchCredentials fromJson(Map<String, Object> json, HttpTransportFactory transportFactory)
      throws IOException {
    String formatVersion = validateField((String) json.get("format_version"), "format_version");
    String projectId = validateField((String) json.get("project"), "project");
    String privateKeyId = validateField((String) json.get("private_key_id"), "private_key_id");
    String privateKeyPem = validateField((String) json.get("private_key"), "private_key");
    String serviceIdentityName = validateField((String) json.get("name"), "name");
    String tokenServerUriStringFromCreds =
        validateField((String) json.get("token_uri"), "token_uri");
    String caCertPath = (String) json.get("ca_cert_path");

    if (!SUPPORTED_JSON_FORMAT_VERSION.equals(formatVersion)) {
      throw new IOException(
          String.format("Only format version %s is supported.", SUPPORTED_JSON_FORMAT_VERSION));
    }

    URI tokenServerUriFromCreds = null;
    try {
      tokenServerUriFromCreds = new URI(tokenServerUriStringFromCreds);
    } catch (URISyntaxException e) {
      throw new IOException("Token server URI specified in 'token_uri' could not be parsed.");
    }

    GdchCredentials.Builder builder =
        GdchCredentials.newBuilder()
            .setProjectId(projectId)
            .setPrivateKeyId(privateKeyId)
            .setTokenServerUri(tokenServerUriFromCreds)
            .setServiceIdentityName(serviceIdentityName)
            .setCaCertPath(caCertPath)
            .setHttpTransportFactory(transportFactory);

    return fromPem(privateKeyPem, builder);
  }

  /**
   * Reads a private key from a PEM encoded string, supporting both PKCS#8 and SEC1 formats.
   *
   * <p>If the key is labeled with "PRIVATE KEY", it is parsed as PKCS#8 as per RFC 7468 Section 10.
   * If it is labeled with "EC PRIVATE KEY", it is parsed as SEC1 as per RFC 5915 Section 3.
   *
   * @see <a href="https://datatracker.ietf.org/doc/html/rfc7468#section-10">RFC 7468 Section 10</a>
   * @see <a href="https://datatracker.ietf.org/doc/html/rfc5915#section-3">RFC 5915 Section 3</a>
   * @param privateKeyPem EC private key object for the service account in PEM format (PKCS#8 or
   *     SEC1).
   * @param builder A builder for GdchCredentials.
   * @return an instance of GdchCredentials.
   */
  static GdchCredentials fromPem(String privateKeyPem, GdchCredentials.Builder builder)
      throws IOException {
    Reader reader = new StringReader(privateKeyPem);
    // Read the first section regardless of title
    PemReader.Section section = PemReader.readFirstSectionAndClose(reader);

    if (section == null) {
      throw new GoogleAuthException(false, 0, "Invalid key data: no PEM section found.", null);
    }

    String title = section.getTitle();
    PrivateKey privateKey;

    if (PRIVATE_KEY_PEM_TITLE.equals(title)) {
      privateKey = OAuth2Utils.privateKeyFromPkcs8(privateKeyPem, OAuth2Utils.Pkcs8Algorithm.EC);
    } else if (EC_PRIVATE_KEY_PEM_TITLE.equals(title)) {
      privateKey = privateKeyFromSec1(section.getBase64DecodedBytes());
    } else {
      throw new GoogleAuthException(false, 0, "Unsupported key type: " + title, null);
    }

    builder.setPrivateKey(privateKey);

    return new GdchCredentials(builder);
  }

  /**
   * This method is obsolete. Please use {@link #createWithGdchAudience(String)}} instead. Create a
   * copy of GDCH credentials with the specified audience.
   *
   * @param apiAudience The intended audience for GDCH credentials.
   */
  @ObsoleteApi("Use createWithGdchAudience(String) instead.")
  public GdchCredentials createWithGdchAudience(URI apiAudience) {
    Preconditions.checkNotNull(
        apiAudience, "Audience are not configured for GDCH service account credentials.");
    return this.toBuilder().setGdchAudience(apiAudience.toString()).build();
  }

  /**
   * Create a copy of GDCH credentials with the specified audience.
   *
   * @param apiAudience The intended audience for GDCH credentials.
   */
  public GdchCredentials createWithGdchAudience(String apiAudience) {
    if (Strings.isNullOrEmpty(apiAudience)) {
      throw new IllegalArgumentException(
          "Audience cannot be null or empty for GDCH service account credentials.");
    }
    return this.toBuilder().setGdchAudience(apiAudience).build();
  }

  /**
   * Refresh the OAuth2 access token by getting a new access token using a JSON Web Token (JWT).
   *
   * <p>For GDCH credentials, this class creates a self-signed JWT, and sends to the GDCH
   * authentication endpoint (tokenServerUri) to exchange an access token for the intended api
   * audience (apiAudience).
   */
  @Override
  public AccessToken refreshAccessToken() throws IOException {
    Preconditions.checkNotNull(
        this.apiAudience,
        "Audience cannot be null or empty for GDCH service account credentials. "
            + "Specify the audience by calling createWithGdchAudience.");

    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

    long currentTime = Clock.SYSTEM.currentTimeMillis();
    String assertion = createAssertion(jsonFactory, currentTime);

    GenericData tokenRequest = new GenericData();
    tokenRequest.set("audience", apiAudience);
    tokenRequest.set("grant_type", OAuth2Utils.TOKEN_TYPE_TOKEN_EXCHANGE);
    tokenRequest.set("requested_token_type", OAuth2Utils.TOKEN_TYPE_ACCESS_TOKEN);
    tokenRequest.set("subject_token", assertion);
    tokenRequest.set("subject_token_type", SERVICE_ACCOUNT_TOKEN_TYPE);

    JsonHttpContent content = new JsonHttpContent(jsonFactory, tokenRequest);

    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(tokenServerUri), content);
    // Disable automatic logging by google-http-java-client to prevent leakage of sensitive tokens.
    // Client Library Debug Logging via LoggingUtils is used instead.
    request.setLoggingEnabled(false);

    request.setParser(new JsonObjectParser(jsonFactory));

    HttpResponse response;
    String errorTemplate = "Error getting access token for GDCH service account: %s, iss: %s";

    try {
      LoggingUtils.logRequest(request, LOGGER_PROVIDER, "Sending request to get GDCH access token");
      response = request.execute();
      LoggingUtils.logResponse(
          response, LOGGER_PROVIDER, "Received response for GDCH access token");
    } catch (HttpResponseException re) {
      String message = String.format(errorTemplate, re.getMessage(), getServiceIdentityName());
      throw GoogleAuthException.createWithTokenEndpointResponseException(re, message);
    } catch (IOException e) {
      String message = String.format(errorTemplate, e.getMessage(), getServiceIdentityName());
      throw GoogleAuthException.createWithTokenEndpointIOException(e, message);
    }

    GenericData responseData = response.parseAs(GenericData.class);
    LoggingUtils.logResponsePayload(
        responseData, LOGGER_PROVIDER, "Response payload for GDCH access token");
    String accessToken =
        OAuth2Utils.validateString(responseData, "access_token", PARSE_ERROR_PREFIX);
    int expiresInSeconds =
        OAuth2Utils.validateInt32(responseData, "expires_in", PARSE_ERROR_PREFIX);
    long expiresAtMilliseconds = clock.currentTimeMillis() + expiresInSeconds * 1000L;
    return new AccessToken(accessToken, new Date(expiresAtMilliseconds));
  }

  /**
   * Create a self-signed JWT for GDCH authentication flow.
   *
   * <p>The self-signed JWT is used to exchange access token from GDCH authentication
   * (tokenServerUri), not for API call. It uses the serviceIdentityName as the `iss` and `sub`
   * claim, and the tokenServerUri as the `aud` claim. The JWT is signed with the privateKey.
   */
  String createAssertion(JsonFactory jsonFactory, long currentTime) throws IOException {
    JsonWebSignature.Header header = new JsonWebSignature.Header();
    header.setAlgorithm("ES256");
    header.setType("JWT");
    header.setKeyId(privateKeyId);

    JsonWebToken.Payload payload = new JsonWebToken.Payload();
    payload.setIssuer(getIssuerSubjectValue(projectId, serviceIdentityName));
    payload.setSubject(getIssuerSubjectValue(projectId, serviceIdentityName));
    payload.setIssuedAtTimeSeconds(currentTime / 1000);
    payload.setExpirationTimeSeconds(currentTime / 1000 + this.lifetime);
    payload.setAudience(tokenServerUri.toString());

    String assertion;
    try {
      assertion = signUsingEsSha256(privateKey, jsonFactory, header, payload);
    } catch (GeneralSecurityException e) {
      throw new GoogleAuthException(
          false, 0, "Error signing service account access token request with private key.", e);
    }

    return assertion;
  }

  /**
   * Get the issuer and subject value in the format GDCH token server required.
   *
   * <p>This value is specific to GDCH and combined parameter used for both `iss` and `sub` fields
   * in JWT claim.
   */
  @VisibleForTesting
  static String getIssuerSubjectValue(String projectId, String serviceIdentityName) {
    return String.format("system:serviceaccount:%s:%s", projectId, serviceIdentityName);
  }

  /**
   * @return the projectId set in the GDCH SA Key file or the user set projectId
   */
  @Override
  public final String getProjectId() {
    return projectId;
  }

  public final String getPrivateKeyId() {
    return privateKeyId;
  }

  public final PrivateKey getPrivateKey() {
    return privateKey;
  }

  public final String getServiceIdentityName() {
    return serviceIdentityName;
  }

  public final URI getTokenServerUri() {
    return tokenServerUri;
  }

  /**
   * Returns the underlying audience string set for this credentials object.
   *
   * @return the audience string, or null if no audience has been set.
   */
  public final String getGdchAudience() {
    return apiAudience;
  }

  /**
   * NOTE: This method is obsolete, please use {@link #getGdchAudience()} instead. Returns a URI
   * representation of the underlying audience string set for this credentials object. This method
   * may fail if the underlying audience string does not conform to a URI format.
   *
   * @return a URI object representing the audience of the credentials, or null if no audience has
   *     been set or if the audience string is not a valid URI.
   */
  @ObsoleteApi("Use getGdchAudience() instead.")
  public final URI getApiAudience() {
    if (Strings.isNullOrEmpty(apiAudience)) {
      return null;
    }
    try {
      return new URI(apiAudience);
    } catch (URISyntaxException e) {
      return null;
    }
  }

  public final HttpTransportFactory getTransportFactory() {
    return transportFactory;
  }

  public final String getCaCertPath() {
    return caCertPath;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @SuppressWarnings("unused")
  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    // properly deserialize the transient transportFactory.
    input.defaultReadObject();
    transportFactory = newInstance(transportFactoryClassName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        projectId,
        privateKeyId,
        privateKey,
        serviceIdentityName,
        tokenServerUri,
        transportFactoryClassName,
        apiAudience,
        caCertPath,
        lifetime);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("projectId", projectId)
        .add("privateKeyId", privateKeyId)
        .add("serviceIdentityName", serviceIdentityName)
        .add("tokenServerUri", tokenServerUri)
        .add("transportFactoryClassName", transportFactoryClassName)
        .add("caCertPath", caCertPath)
        .add("apiAudience", apiAudience)
        .add("lifetime", lifetime)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof GdchCredentials)) {
      return false;
    }
    GdchCredentials other = (GdchCredentials) obj;
    return Objects.equals(this.projectId, other.projectId)
        && Objects.equals(this.privateKeyId, other.privateKeyId)
        && Objects.equals(this.privateKey, other.privateKey)
        && Objects.equals(this.serviceIdentityName, other.serviceIdentityName)
        && Objects.equals(this.tokenServerUri, other.tokenServerUri)
        && Objects.equals(this.transportFactoryClassName, other.transportFactoryClassName)
        && Objects.equals(this.apiAudience, other.apiAudience)
        && Objects.equals(this.caCertPath, other.caCertPath)
        && Objects.equals(this.lifetime, other.lifetime);
  }

  static InputStream readStream(File file) throws FileNotFoundException {
    return new FileInputStream(file);
  }

  public static class Builder extends GoogleCredentials.Builder {
    private String projectId;
    private String privateKeyId;
    private PrivateKey privateKey;
    private String serviceIdentityName;
    private URI tokenServerUri;
    private String apiAudience;
    private HttpTransportFactory transportFactory;
    private String caCertPath;
    private int lifetime = DEFAULT_LIFETIME_IN_SECONDS;

    protected Builder() {}

    protected Builder(GdchCredentials credentials) {
      this.projectId = credentials.projectId;
      this.privateKeyId = credentials.privateKeyId;
      this.privateKey = credentials.privateKey;
      this.serviceIdentityName = credentials.serviceIdentityName;
      this.tokenServerUri = credentials.tokenServerUri;
      this.transportFactory = credentials.transportFactory;
      this.caCertPath = credentials.caCertPath;
      this.lifetime = credentials.lifetime;
    }

    @CanIgnoreReturnValue
    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setPrivateKeyId(String privateKeyId) {
      this.privateKeyId = privateKeyId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setPrivateKey(PrivateKey privateKey) {
      this.privateKey = privateKey;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setServiceIdentityName(String name) {
      this.serviceIdentityName = name;
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

    @CanIgnoreReturnValue
    public Builder setCaCertPath(String caCertPath) {
      this.caCertPath = caCertPath;
      return this;
    }

    /**
     * Sets the intended audience for GDCH credentials.
     *
     * @param apiAudience The audience string. Cannot be null or empty.
     * @return this builder.
     * @throws IllegalArgumentException if the audience is null or empty.
     */
    @CanIgnoreReturnValue
    public Builder setGdchAudience(String apiAudience) {
      if (Strings.isNullOrEmpty(apiAudience)) {
        throw new IllegalArgumentException(
            "Audience cannot be null or empty for GDCH service account credentials.");
      }
      this.apiAudience = apiAudience;
      return this;
    }

    public String getProjectId() {
      return projectId;
    }

    public String getPrivateKeyId() {
      return privateKeyId;
    }

    public PrivateKey getPrivateKey() {
      return privateKey;
    }

    public String getServiceIdentityName() {
      return serviceIdentityName;
    }

    public URI getTokenServerUri() {
      return tokenServerUri;
    }

    public HttpTransportFactory getHttpTransportFactory() {
      return transportFactory;
    }

    public String getCaCertPath() {
      return caCertPath;
    }

    public int getLifetime() {
      return lifetime;
    }

    @Override
    public GdchCredentials build() {
      return new GdchCredentials(this);
    }
  }

  private static String validateField(String field, String fieldName) throws IOException {
    if (field == null || field.isEmpty()) {
      throw new IOException(
          String.format(
              "Error reading GDCH service account credential from JSON, %s is misconfigured.",
              fieldName));
    }
    return field;
  }

  /*
   * Internal HttpTransportFactory for GDCH credentials.
   *
   * <p> GDCH authentication server could use a self-signed certificate, thus the
   * client could
   * provide the CA certificate path through the `ca_cert_path` in GDCH JSON file.
   *
   * <p> The TransportFactoryForGdch subclass would read the certificate and
   * create a trust store,
   * then use the trust store to create a transport.
   *
   * <p> If the GDCH authentication server uses well known CA certificate, then a
   * regular transport
   * would be set.
   */
  static class TransportFactoryForGdch implements HttpTransportFactory {
    HttpTransport transport;

    public TransportFactoryForGdch(String caCertPath) throws IOException {
      setTransport(caCertPath);
    }

    @Override
    public HttpTransport create() {
      return transport;
    }

    private void setTransport(String caCertPath) throws IOException {
      if (caCertPath == null || caCertPath.isEmpty()) {
        this.transport = new NetHttpTransport();
        return;
      }
      try {
        InputStream certificateStream = readStream(new File(caCertPath));
        this.transport =
            new NetHttpTransport.Builder().trustCertificatesFromStream(certificateStream).build();
      } catch (IOException e) {
        throw new IOException(
            String.format(
                "Error reading certificate file from CA cert path, value '%s': %s",
                caCertPath, e.getMessage()),
            e);
      } catch (GeneralSecurityException e) {
        throw new IOException("Error initiating transport with certificate stream.", e);
      }
    }
  }

  /**
   * Signs the JWS header and payload using the ES256 algorithm (ECDSA with SHA-256).
   *
   * <p>The ES256 algorithm is defined in <a
   * href="https://tools.ietf.org/html/rfc7518#section-3.4">RFC 7518 Section 3.4</a>. This method
   * follows the JWS Compact Serialization format described in <a
   * href="https://tools.ietf.org/html/rfc7515#section-3.1">RFC 7515 Section 3.1</a>.
   *
   * <p>Unlike RSA signatures, ECDSA signatures produced by the Java Cryptography Architecture (JCA)
   * are DER-encoded. This method transcodes the DER-encoded signature into the concatenated R|S
   * format required by the JWS standard, as specified in <a
   * href="https://tools.ietf.org/html/rfc7515#appendix-A.3">RFC 7515 Appendix A.3</a>.
   *
   * @param privateKey The Elliptic Curve private key used for signing.
   * @param jsonFactory The JSON factory to serialize header and payload.
   * @param header The JWS header (e.g., containing "alg": "ES256").
   * @param payload The JWS payload containing claims like "iss", "sub", and "aud".
   * @return A complete, signed JWS string in the format {@code [header].[payload].[signature]}.
   * @throws GeneralSecurityException If signing fails due to cryptographic errors.
   * @throws IOException If serialization or transcoding fails.
   */
  @VisibleForTesting
  static String signUsingEsSha256(
      PrivateKey privateKey,
      JsonFactory jsonFactory,
      JsonWebSignature.Header header,
      JsonWebToken.Payload payload)
      throws GeneralSecurityException, GoogleAuthException {

    try {
      // 1. Construct the JWS Signing Input: Base64URL(UTF8(Header)) + '.' +
      // Base64URL(UTF8(Payload))
      String content =
          Base64.getUrlEncoder().withoutPadding().encodeToString(jsonFactory.toByteArray(header))
              + "."
              + Base64.getUrlEncoder()
                  .withoutPadding()
                  .encodeToString(jsonFactory.toByteArray(payload));
      byte[] contentBytes = StringUtils.getBytesUtf8(content);

      // 2. Create the digital signature using SHA256withECDSA.
      byte[] signature =
          SecurityUtils.sign(SecurityUtils.getEs256SignatureAlgorithm(), privateKey, contentBytes);

      // 3. Transcode the signature from DER to Concatenated R|S.
      byte[] jwsSignature = transcodeDerToConcat(signature, 64);

      // 4. Return final JWS: [Signing Input] + '.' + Base64URL(Signature)
      return content + "." + Base64.getUrlEncoder().withoutPadding().encodeToString(jwsSignature);
    } catch (IOException e) {
      throw new GoogleAuthException(false, 0, "Error serializing or transcoding JWT.", e);
    }
  }

  /**
   * Transcodes a DER-encoded ECDSA signature into the concatenated R|S format.
   *
   * <p>DER format (ASN.1): {@code SEQUENCE { r INTEGER, s INTEGER }}
   *
   * <p>Concatenated format: {@code r | s} (where {@code |} is concatenation).
   *
   * @param derSignature The raw bytes of the DER-encoded signature.
   * @param outputLength The total expected length of the concatenated signature (64 bytes for
   *     ES256).
   * @return The signature in concatenated R|S format.
   * @throws IOException If the DER format is invalid.
   */
  @VisibleForTesting
  static byte[] transcodeDerToConcat(byte[] derSignature, int outputLength)
      throws GoogleAuthException {
    // Validate basic ASN.1 DER structure (0x30 = SEQUENCE)
    if (derSignature.length < 8 || derSignature[0] != 0x30) {
      throw new GoogleAuthException(false, 0, "Invalid DER signature format.", null);
    }

    int offset = 2;
    int seqLength = derSignature[1] & 0xFF;
    // Handle long-form length encoding for the sequence
    if (seqLength == 0x81) {
      offset = 3;
      seqLength = derSignature[2] & 0xFF;
    }

    if (derSignature.length - offset != seqLength) {
      throw new GoogleAuthException(false, 0, "Invalid DER signature length.", null);
    }

    // Parse Integer R (0x02 = INTEGER)
    if (derSignature[offset++] != 0x02) {
      throw new GoogleAuthException(false, 0, "Expected INTEGER for R.", null);
    }
    int rLength = derSignature[offset++];
    // Skip leading zero byte if it exists (DER integers are signed; zero is added to stay positive)
    if (derSignature[offset] == 0x00 && rLength > 1 && (derSignature[offset + 1] & 0x80) != 0) {
      offset++;
      rLength--;
    }
    byte[] r = new byte[rLength];
    System.arraycopy(derSignature, offset, r, 0, rLength);
    offset += rLength;

    // Parse Integer S
    if (derSignature[offset++] != 0x02) {
      throw new GoogleAuthException(false, 0, "Expected INTEGER for S.", null);
    }
    int sLength = derSignature[offset++];
    if (derSignature[offset] == 0x00 && sLength > 1 && (derSignature[offset + 1] & 0x80) != 0) {
      offset++;
      sLength--;
    }
    byte[] s = new byte[sLength];
    System.arraycopy(derSignature, offset, s, 0, sLength);

    // Concatenate r and s into fixed-length segments (32 bytes each for ES256)
    int keySizeBytes = outputLength / 2;
    if (r.length > keySizeBytes || s.length > keySizeBytes) {
      throw new GoogleAuthException(
          false,
          0,
          String.format(
              "Invalid R or S length. R: %d, S: %d, Expected: %d",
              r.length, s.length, keySizeBytes),
          null);
    }

    byte[] result = new byte[outputLength];
    System.arraycopy(r, 0, result, keySizeBytes - r.length, r.length);
    System.arraycopy(s, 0, result, outputLength - s.length, s.length);

    return result;
  }

  /**
   * Parses an EC private key in SEC1 format using fixed prefix verification.
   *
   * <p>This function assumes that standard SEC1 keys for P-256 generated by OpenSSL have a known,
   * stable structure of bytes at the beginning. This "fingerprint" allows us to verify the format
   * without complete ASN.1 parsing. If the fingerprint matches, we can safely extract the private
   * key value using fixed offsets.
   *
   * @param bytes The raw bytes of the SEC1 key.
   * @return The PrivateKey object.
   * @throws GoogleAuthException If parsing fails or the key format is unsupported.
   */
  private static PrivateKey privateKeyFromSec1(byte[] bytes) throws IOException {
    if (!hasStandardSec1P256Prefix(bytes)) {
      throw new GoogleAuthException(
          false, 0, "Unsupported SEC1 key format: standard prefix not found.", null);
    }
    BigInteger s = extractPrivateKeyValue(bytes);
    return createEcPrivateKey(s);
  }

  /**
   * Verifies if the bytes start with the standard SEC1 P-256 prefix.
   *
   * <p>The prefix is derived from the standard DER encoding of the ECPrivateKey structure defined
   * in RFC 5915 Section 3. For P-256 with named curve parameters and public key included, the
   * prefix is stable: <code>[0x30, 0x77, 0x02, 0x01, 0x01, 0x04, 0x20]</code>
   *
   * @see <a href="https://datatracker.ietf.org/doc/html/rfc5915#section-3">RFC 5915 Section 3</a>
   * @param bytes The raw bytes of the key.
   * @return true if the prefix matches.
   */
  private static boolean hasStandardSec1P256Prefix(byte[] bytes) {
    if (bytes.length < 7) return false;
    return bytes[0] == 0x30 // Sequence
        && bytes[1] == 0x77 // Length
        && bytes[2] == 0x02 // Integer
        && bytes[3] == 0x01 // Length
        && bytes[4] == 0x01 // Version
        && bytes[5] == 0x04 // Octet String
        && bytes[6] == 0x20; // Length 32
  }

  /**
   * Extracts the private key value 's' from the SEC1 bytes using fixed offset.
   *
   * <p>Assumes the prefix has already been verified by {@link #hasStandardSec1P256Prefix(byte[])}.
   *
   * @param bytes The raw bytes of the key.
   * @return The BigInteger value of 's'.
   */
  private static BigInteger extractPrivateKeyValue(byte[] bytes) {
    // P-256 private key size is 32 bytes as per RFC 5915 Section 3.
    byte[] sBytes = new byte[32];
    // Copy 32 bytes starting at offset 7 (after the 7-byte metadata prefix verified by
    // hasStandardSec1P256Prefix).
    System.arraycopy(bytes, 7, sBytes, 0, 32);
    // Use signum 1 to ensure the byte array is interpreted as a positive integer.
    return new BigInteger(1, sBytes);
  }

  /**
   * Creates an EC PrivateKey from the private key value 's' using P-256 parameters.
   *
   * <p>Algorithm steps: 1. Get an instance of AlgorithmParameters for "EC". 2. Initialize it with
   * secp256r1 curve spec (requirement as per GDCH supported curve). 3. Extract ECParameterSpec from
   * parameters. 4. Create ECPrivateKeySpec with the extracted private key value and parameters. 5.
   * Generate PrivateKey using KeyFactory.
   *
   * @param s The private key value.
   * @return The PrivateKey object.
   * @throws GoogleAuthException If key creation fails.
   */
  private static PrivateKey createEcPrivateKey(BigInteger s) throws IOException {
    try {
      AlgorithmParameters params = AlgorithmParameters.getInstance("EC");

      params.init(new ECGenParameterSpec("secp256r1"));

      ECParameterSpec ecParams = params.getParameterSpec(ECParameterSpec.class);

      ECPrivateKeySpec keySpec = new ECPrivateKeySpec(s, ecParams);

      KeyFactory keyFactory = KeyFactory.getInstance("EC");

      return keyFactory.generatePrivate(keySpec);
    } catch (GeneralSecurityException e) {
      throw new GoogleAuthException(
          false,
          0,
          "Failed to create EC Private Key for GDCH. Please ensure the private key data is valid and represents a P-256 private key.",
          e);
    }
  }
}
