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
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.GenericData;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class GdchCredentials extends GoogleCredentials {
  static final String SUPPORTED_FORMAT_VERSION = "1";
  private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
  private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;

  private final PrivateKey privateKey;
  private final String privateKeyId;
  private final String projectId;
  private final String serviceIdentityName;
  private final URI tokenServerUri;
  private final URI apiAudience;
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
    String privateKeyPkcs8 = validateField((String) json.get("private_key"), "private_key");
    String serviceIdentityName = validateField((String) json.get("name"), "name");
    String tokenServerUriStringFromCreds =
        validateField((String) json.get("token_uri"), "token_uri");
    String caCertPath = (String) json.get("ca_cert_path");

    if (!SUPPORTED_FORMAT_VERSION.equals(formatVersion)) {
      throw new IOException(
          String.format("Only format version %s is supported.", SUPPORTED_FORMAT_VERSION));
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

    return fromPkcs8(privateKeyPkcs8, builder);
  }

  /**
   * Internal constructor.
   *
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param builder A builder for GdchCredentials.
   * @return an instance of GdchCredentials.
   */
  static GdchCredentials fromPkcs8(String privateKeyPkcs8, GdchCredentials.Builder builder)
      throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(privateKeyPkcs8);
    builder.setPrivateKey(privateKey);

    return new GdchCredentials(builder);
  }

  /**
   * Create a copy of GDCH credentials with the specified audience.
   *
   * @param apiAudience The intended audience for GDCH credentials.
   */
  public GdchCredentials createWithGdchAudience(URI apiAudience) throws IOException {
    Preconditions.checkNotNull(
        apiAudience, "Audience are not configured for GDCH service account credentials.");
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
        "Audience are not configured for GDCH service account. Specify the "
            + "audience by calling createWithGDCHAudience.");

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTime = clock.currentTimeMillis();
    String assertion = createAssertion(jsonFactory, currentTime, getApiAudience());

    GenericData tokenRequest = new GenericData();
    tokenRequest.set("grant_type", OAuth2Utils.TOKEN_TYPE_TOKEN_EXCHANGE);
    tokenRequest.set("assertion", assertion);
    UrlEncodedContent content = new UrlEncodedContent(tokenRequest);

    HttpRequestFactory requestFactory = transportFactory.create().createRequestFactory();
    HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(tokenServerUri), content);

    request.setParser(new JsonObjectParser(jsonFactory));

    HttpResponse response;
    String errorTemplate = "Error getting access token for GDCH service account: %s, iss: %s";

    try {
      response = request.execute();
    } catch (HttpResponseException re) {
      String message = String.format(errorTemplate, re.getMessage(), getServiceIdentityName());
      throw GoogleAuthException.createWithTokenEndpointResponseException(re, message);
    } catch (IOException e) {
      throw GoogleAuthException.createWithTokenEndpointIOException(
          e, String.format(errorTemplate, e.getMessage(), getServiceIdentityName()));
    }

    GenericData responseData = response.parseAs(GenericData.class);
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
  String createAssertion(JsonFactory jsonFactory, long currentTime, URI apiAudience)
      throws IOException {
    JsonWebSignature.Header header = new JsonWebSignature.Header();
    header.setAlgorithm("RS256");
    header.setType("JWT");
    header.setKeyId(privateKeyId);

    JsonWebToken.Payload payload = new JsonWebToken.Payload();
    payload.setIssuer(getIssuerSubjectValue(projectId, serviceIdentityName));
    payload.setSubject(getIssuerSubjectValue(projectId, serviceIdentityName));
    payload.setIssuedAtTimeSeconds(currentTime / 1000);
    payload.setExpirationTimeSeconds(currentTime / 1000 + this.lifetime);
    payload.setAudience(getTokenServerUri().toString());

    String assertion;
    try {
      payload.set("api_audience", apiAudience.toString());
      assertion = JsonWebSignature.signUsingRsaSha256(privateKey, jsonFactory, header, payload);
    } catch (GeneralSecurityException e) {
      throw new IOException(
          "Error signing service account access token request with private key.", e);
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

  public final URI getApiAudience() {
    return apiAudience;
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
    private URI apiAudience;
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

    @CanIgnoreReturnValue
    public Builder setGdchAudience(URI apiAudience) {
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
   * <p> GDCH authentication server could use a self-signed certificate, thus the client could
   * provide the CA certificate path through the `ca_cert_path` in GDCH JSON file.
   *
   * <p> The TransportFactoryForGdch subclass would read the certificate and create a trust store,
   * then use the trust store to create a transport.
   *
   * <p> If the GDCH authentication server uses well known CA certificate, then a regular transport
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
}
