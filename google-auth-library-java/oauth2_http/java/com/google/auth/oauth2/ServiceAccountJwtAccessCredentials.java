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

import static com.google.auth.oauth2.GoogleCredentials.addQuotaProjectIdToRequestMetadata;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Preconditions;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Throwables;
import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Service Account credentials for calling Google APIs using a JWT directly for access.
 *
 * <p>Uses a JSON Web Token (JWT) directly in the request metadata to provide authorization.
 */
public class ServiceAccountJwtAccessCredentials extends Credentials
    implements JwtProvider, ServiceAccountSigner, QuotaProjectIdProvider {

  private static final long serialVersionUID = -7274955171379494197L;
  static final String JWT_ACCESS_PREFIX = OAuth2Utils.BEARER_PREFIX;

  @VisibleForTesting static final long LIFE_SPAN_SECS = TimeUnit.HOURS.toSeconds(1);
  private static final long CLOCK_SKEW = TimeUnit.MINUTES.toSeconds(5);

  private final String clientId;
  private final String clientEmail;
  private final PrivateKey privateKey;
  private final String privateKeyId;
  private final URI defaultAudience;
  private final String quotaProjectId;
  private final String universeDomain;

  private transient LoadingCache<JwtClaims, JwtCredentials> credentialsCache;

  // Until we expose this to the users it can remain transient and non-serializable
  @VisibleForTesting transient Clock clock = Clock.SYSTEM;

  /**
   * Constructor with minimum identifying information.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKey RSA private key object for the service account.
   * @param privateKeyId Private key identifier for the service account. May be null.
   */
  private ServiceAccountJwtAccessCredentials(
      String clientId, String clientEmail, PrivateKey privateKey, String privateKeyId) {
    this(
        clientId,
        clientEmail,
        privateKey,
        privateKeyId,
        null,
        null,
        Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  /**
   * Constructor with full information.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKey RSA private key object for the service account.
   * @param privateKeyId Private key identifier for the service account. May be null.
   * @param defaultAudience Audience to use if not provided by transport. May be null.
   * @param universeDomain universe domain in the format some-domain.xyz. By default, sets it to
   *     googleapis.com
   */
  private ServiceAccountJwtAccessCredentials(
      String clientId,
      String clientEmail,
      PrivateKey privateKey,
      String privateKeyId,
      URI defaultAudience,
      String quotaProjectId,
      String universeDomain) {
    this.clientId = clientId;
    this.clientEmail = Preconditions.checkNotNull(clientEmail);
    this.privateKey = Preconditions.checkNotNull(privateKey);
    this.privateKeyId = privateKeyId;
    this.defaultAudience = defaultAudience;
    this.credentialsCache = createCache();
    this.quotaProjectId = quotaProjectId;
    if (universeDomain == null || universeDomain.trim().isEmpty()) {
      this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
    } else {
      this.universeDomain = universeDomain;
    }
  }

  /**
   * Returns service account credentials defined by JSON using the format supported by the Google
   * Developers Console.
   *
   * @param json a map from the JSON representing the credentials.
   * @return the credentials defined by the JSON.
   * @throws IOException if the credential cannot be created from the JSON.
   */
  static ServiceAccountJwtAccessCredentials fromJson(Map<String, Object> json) throws IOException {
    return fromJson(json, null);
  }

  /**
   * Returns service account credentials defined by JSON using the format supported by the Google
   * Developers Console.
   *
   * @param json a map from the JSON representing the credentials.
   * @param defaultAudience Audience to use if not provided by transport. May be null.
   * @return the credentials defined by the JSON.
   * @throws IOException if the credential cannot be created from the JSON.
   */
  static ServiceAccountJwtAccessCredentials fromJson(Map<String, Object> json, URI defaultAudience)
      throws IOException {
    String clientId = (String) json.get("client_id");
    String clientEmail = (String) json.get("client_email");
    String privateKeyPkcs8 = (String) json.get("private_key");
    String privateKeyId = (String) json.get("private_key_id");
    String quoataProjectId = (String) json.get("quota_project_id");
    String rawUniverseDomain = (String) json.get("universe_domain");
    String resolvedUniverseDomain =
        (rawUniverseDomain == null) ? Credentials.GOOGLE_DEFAULT_UNIVERSE : rawUniverseDomain;

    if (clientId == null
        || clientEmail == null
        || privateKeyPkcs8 == null
        || privateKeyId == null) {
      throw new IOException(
          "Error reading service account credential from JSON, "
              + "expecting  'client_id', 'client_email', 'private_key' and 'private_key_id'.");
    }
    return ServiceAccountJwtAccessCredentials.fromPkcs8(
        clientId,
        clientEmail,
        privateKeyPkcs8,
        privateKeyId,
        defaultAudience,
        quoataProjectId,
        resolvedUniverseDomain);
  }

  /**
   * Factory using PKCS#8 for the private key.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId Private key identifier for the service account. May be null.
   * @return New ServiceAccountJwtAcceessCredentials created from a private key.
   * @throws IOException if the credential cannot be created from the private key.
   */
  public static ServiceAccountJwtAccessCredentials fromPkcs8(
      String clientId, String clientEmail, String privateKeyPkcs8, String privateKeyId)
      throws IOException {
    return fromPkcs8(clientId, clientEmail, privateKeyPkcs8, privateKeyId, null);
  }

  /**
   * Factory using PKCS#8 for the private key.
   *
   * @param clientId Client ID of the service account from the console. May be null.
   * @param clientEmail Client email address of the service account from the console.
   * @param privateKeyPkcs8 RSA private key object for the service account in PKCS#8 format.
   * @param privateKeyId Private key identifier for the service account. May be null.
   * @param defaultAudience Audience to use if not provided by transport. May be null.
   * @return New ServiceAccountJwtAcceessCredentials created from a private key.
   * @throws IOException if the credential cannot be created from the private key.
   */
  public static ServiceAccountJwtAccessCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      URI defaultAudience)
      throws IOException {
    return ServiceAccountJwtAccessCredentials.fromPkcs8(
        clientId,
        clientEmail,
        privateKeyPkcs8,
        privateKeyId,
        defaultAudience,
        null,
        Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  static ServiceAccountJwtAccessCredentials fromPkcs8(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      URI defaultAudience,
      String quotaProjectId,
      String universeDomain)
      throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(privateKeyPkcs8);
    return new ServiceAccountJwtAccessCredentials(
        clientId,
        clientEmail,
        privateKey,
        privateKeyId,
        defaultAudience,
        quotaProjectId,
        universeDomain);
  }

  /**
   * Returns credentials defined by a Service Account key file in JSON format from the Google
   * Developers Console.
   *
   * @param credentialsStream the stream with the credential definition.
   * @return the credential defined by the credentialsStream.
   * @throws IOException if the credential cannot be created from the stream.
   */
  public static ServiceAccountJwtAccessCredentials fromStream(InputStream credentialsStream)
      throws IOException {
    return fromStream(credentialsStream, null);
  }

  /**
   * Returns credentials defined by a Service Account key file in JSON format from the Google
   * Developers Console.
   *
   * @param credentialsStream the stream with the credential definition.
   * @param defaultAudience Audience to use if not provided by transport. May be null.
   * @return the credential defined by the credentialsStream.
   * @throws IOException if the credential cannot be created from the stream.
   */
  public static ServiceAccountJwtAccessCredentials fromStream(
      InputStream credentialsStream, URI defaultAudience) throws IOException {
    Preconditions.checkNotNull(credentialsStream);

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    JsonObjectParser parser = new JsonObjectParser(jsonFactory);
    GenericJson fileContents =
        parser.parseAndClose(credentialsStream, StandardCharsets.UTF_8, GenericJson.class);

    String fileType = (String) fileContents.get("type");
    if (fileType == null) {
      throw new IOException("Error reading credentials from stream, 'type' field not specified.");
    }
    if (GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType().equals(fileType)) {
      return fromJson(fileContents, defaultAudience);
    }
    throw new IOException(
        String.format(
            "Error reading credentials from stream, 'type' value '%s' not recognized."
                + " Expecting '%s'.",
            fileType, GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType()));
  }

  private LoadingCache<JwtClaims, JwtCredentials> createCache() {
    return CacheBuilder.newBuilder()
        .maximumSize(100)
        .expireAfterWrite(LIFE_SPAN_SECS - CLOCK_SKEW, TimeUnit.SECONDS)
        .ticker(
            new Ticker() {
              @Override
              public long read() {
                return TimeUnit.MILLISECONDS.toNanos(clock.currentTimeMillis());
              }
            })
        .build(
            new CacheLoader<JwtClaims, JwtCredentials>() {
              @Override
              public JwtCredentials load(JwtClaims claims) throws Exception {
                return JwtCredentials.newBuilder()
                    .setPrivateKey(privateKey)
                    .setPrivateKeyId(privateKeyId)
                    .setJwtClaims(claims)
                    .setLifeSpanSeconds(LIFE_SPAN_SECS)
                    .setClock(clock)
                    .build();
              }
            });
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
        JwtClaims.newBuilder().setIssuer(clientEmail).setSubject(clientEmail);
    if (defaultAudience != null) {
      claimsBuilder.setAudience(defaultAudience.toString());
    }
    return JwtCredentials.newBuilder()
        .setPrivateKey(privateKey)
        .setPrivateKeyId(privateKeyId)
        .setJwtClaims(claimsBuilder.build().merge(newClaims))
        .setLifeSpanSeconds(LIFE_SPAN_SECS)
        .setClock(clock)
        .build();
  }

  @Override
  public String getAuthenticationType() {
    return "JWTAccess";
  }

  @Override
  public boolean hasRequestMetadata() {
    return true;
  }

  @Override
  public boolean hasRequestMetadataOnly() {
    return true;
  }

  @Override
  public void getRequestMetadata(
      final URI uri, Executor executor, final RequestMetadataCallback callback) {
    // It doesn't use network. Only some CPU work on par with TLS handshake. So it's preferable
    // to do it in the current thread, which is likely to be the network thread.
    blockingGetToCallback(uri, callback);
  }

  /** Provide the request metadata by putting an access JWT directly in the metadata. */
  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    if (uri == null) {
      if (defaultAudience != null) {
        uri = defaultAudience;
      } else {
        throw new IOException(
            "JwtAccess requires Audience uri to be passed in or the "
                + "defaultAudience to be specified");
      }
    }
    try {
      JwtClaims defaultClaims =
          JwtClaims.newBuilder()
              .setAudience(uri.toString())
              .setIssuer(clientEmail)
              .setSubject(clientEmail)
              .build();
      JwtCredentials credentials = credentialsCache.get(defaultClaims);
      Map<String, List<String>> requestMetadata = credentials.getRequestMetadata(uri);
      return addQuotaProjectIdToRequestMetadata(quotaProjectId, requestMetadata);
    } catch (ExecutionException e) {
      Throwables.propagateIfPossible(e.getCause(), IOException.class);
      // Should never happen
      throw new IllegalStateException(
          "generateJwtAccess threw an unexpected checked exception", e.getCause());

    } catch (UncheckedExecutionException e) {
      Throwables.throwIfUnchecked(e);
      // Should never happen
      throw new IllegalStateException(
          "generateJwtAccess threw an unchecked exception that couldn't be rethrown", e);
    }
  }

  /** Discard any cached data */
  @Override
  public void refresh() {
    credentialsCache.invalidateAll();
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

  /** Returns the universe domain (example, googleapis.com) for the credentials instance. */
  @Override
  public final String getUniverseDomain() {
    return universeDomain;
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
      throw new ServiceAccountSigner.SigningException("Failed to sign the provided bytes", ex);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        clientId, clientEmail, privateKey, privateKeyId, defaultAudience, quotaProjectId);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("clientId", clientId)
        .add("clientEmail", clientEmail)
        .add("privateKeyId", privateKeyId)
        .add("defaultAudience", defaultAudience)
        .add("quotaProjectId", quotaProjectId)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ServiceAccountJwtAccessCredentials)) {
      return false;
    }
    ServiceAccountJwtAccessCredentials other = (ServiceAccountJwtAccessCredentials) obj;
    return Objects.equals(this.clientId, other.clientId)
        && Objects.equals(this.clientEmail, other.clientEmail)
        && Objects.equals(this.privateKey, other.privateKey)
        && Objects.equals(this.privateKeyId, other.privateKeyId)
        && Objects.equals(this.defaultAudience, other.defaultAudience)
        && Objects.equals(this.quotaProjectId, other.quotaProjectId);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    clock = Clock.SYSTEM;
    credentialsCache = createCache();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String getQuotaProjectId() {
    return quotaProjectId;
  }

  public static class Builder {

    private String clientId;
    private String clientEmail;
    private PrivateKey privateKey;
    private String privateKeyId;
    private URI defaultAudience;
    private String quotaProjectId;
    private String universeDomain;

    protected Builder() {}

    protected Builder(ServiceAccountJwtAccessCredentials credentials) {
      this.clientId = credentials.clientId;
      this.clientEmail = credentials.clientEmail;
      this.privateKey = credentials.privateKey;
      this.privateKeyId = credentials.privateKeyId;
      this.defaultAudience = credentials.defaultAudience;
      this.quotaProjectId = credentials.quotaProjectId;
      this.universeDomain = credentials.universeDomain;
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
    public Builder setPrivateKeyId(String privateKeyId) {
      this.privateKeyId = privateKeyId;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setDefaultAudience(URI defaultAudience) {
      this.defaultAudience = defaultAudience;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      this.quotaProjectId = quotaProjectId;
      return this;
    }

    @CanIgnoreReturnValue
    /** Sets the universe domain (example, googleapis.com). */
    public Builder setUniverseDomain(String universeDomain) {
      this.universeDomain = universeDomain;
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

    public URI getDefaultAudience() {
      return defaultAudience;
    }

    public String getQuotaProjectId() {
      return quotaProjectId;
    }

    /** Returns the universe domain (example, googleapis.com) for the credentials instance. */
    public String getUniverseDomain() {
      return universeDomain;
    }

    public ServiceAccountJwtAccessCredentials build() {
      return new ServiceAccountJwtAccessCredentials(
          clientId,
          clientEmail,
          privateKey,
          privateKeyId,
          defaultAudience,
          quotaProjectId,
          universeDomain);
    }
  }
}
