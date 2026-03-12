/*
 * Copyright 2020, Google LLC
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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler.BackOffRequired;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.util.Base64;
import com.google.api.client.util.Clock;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Key;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Handle verification of Google-signed JWT tokens.
 *
 * @author Jeff Ching
 * @since 0.21.0
 */
public class TokenVerifier {
  private static final String IAP_CERT_URL = "https://www.gstatic.com/iap/verify/public_key-jwk";
  private static final String FEDERATED_SIGNON_CERT_URL =
      "https://www.googleapis.com/oauth2/v3/certs";
  private static final Set<String> SUPPORTED_ALGORITHMS = ImmutableSet.of("RS256", "ES256");

  private final String audience;
  private final String certificatesLocation;
  private final String issuer;
  private final PublicKey publicKey;
  private final Clock clock;
  private final LoadingCache<String, Map<String, PublicKey>> publicKeyCache;

  private TokenVerifier(Builder builder) {
    this.audience = builder.audience;
    this.certificatesLocation = builder.certificatesLocation;
    this.issuer = builder.issuer;
    this.publicKey = builder.publicKey;
    this.clock = builder.clock;
    this.publicKeyCache =
        CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.HOURS)
            .build(new PublicKeyLoader(builder.httpTransportFactory));
  }

  public static Builder newBuilder() {
    return new Builder()
        .setClock(Clock.SYSTEM)
        .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY);
  }

  /**
   * Verify an encoded JWT token.
   *
   * @param token encoded JWT token
   * @return the parsed JsonWebSignature instance for additional validation if necessary
   * @throws VerificationException thrown if any verification fails
   */
  public JsonWebSignature verify(String token) throws VerificationException {
    JsonWebSignature jsonWebSignature;
    try {
      jsonWebSignature = JsonWebSignature.parse(OAuth2Utils.JSON_FACTORY, token);
    } catch (IOException e) {
      throw new VerificationException("Error parsing JsonWebSignature token", e);
    }

    // Verify the expected audience if an audience is provided in the verifyOptions
    if (audience != null && !audience.equals(jsonWebSignature.getPayload().getAudience())) {
      throw new VerificationException("Expected audience does not match");
    }

    // Verify the expected issuer if an issuer is provided in the verifyOptions
    if (issuer != null && !issuer.equals(jsonWebSignature.getPayload().getIssuer())) {
      throw new VerificationException("Expected issuer does not match");
    }

    Long expiresAt = jsonWebSignature.getPayload().getExpirationTimeSeconds();
    if (expiresAt != null && expiresAt <= clock.currentTimeMillis() / 1000) {
      throw new VerificationException("Token is expired");
    }

    // Short-circuit signature types
    if (!SUPPORTED_ALGORITHMS.contains(jsonWebSignature.getHeader().getAlgorithm())) {
      throw new VerificationException(
          "Unexpected signing algorithm: expected either RS256 or ES256");
    }

    PublicKey publicKeyToUse = publicKey;
    if (publicKeyToUse == null) {
      try {
        String certificateLocation = getCertificateLocation(jsonWebSignature);
        publicKeyToUse =
            publicKeyCache.get(certificateLocation).get(jsonWebSignature.getHeader().getKeyId());
      } catch (ExecutionException | UncheckedExecutionException e) {
        throw new VerificationException("Error fetching PublicKey from certificate location", e);
      }
    }

    if (publicKeyToUse == null) {
      throw new VerificationException(
          "Could not find PublicKey for provided keyId: "
              + jsonWebSignature.getHeader().getKeyId());
    }

    try {
      if (jsonWebSignature.verifySignature(publicKeyToUse)) {
        return jsonWebSignature;
      }
      throw new VerificationException("Invalid signature");
    } catch (GeneralSecurityException e) {
      throw new VerificationException("Error validating token", e);
    }
  }

  private String getCertificateLocation(JsonWebSignature jsonWebSignature)
      throws VerificationException {
    if (certificatesLocation != null) return certificatesLocation;

    switch (jsonWebSignature.getHeader().getAlgorithm()) {
      case "RS256":
        return FEDERATED_SIGNON_CERT_URL;
      case "ES256":
        return IAP_CERT_URL;
    }

    throw new VerificationException("Unknown algorithm");
  }

  public static class Builder {
    private String audience;
    private String certificatesLocation;
    private String issuer;
    private PublicKey publicKey;
    private Clock clock;
    private HttpTransportFactory httpTransportFactory;

    /**
     * Set a target audience to verify.
     *
     * @param audience the audience claim to verify
     * @return the builder
     */
    public Builder setAudience(String audience) {
      this.audience = audience;
      return this;
    }

    /**
     * Override the location URL that contains published public keys. Defaults to well-known Google
     * locations.
     *
     * @param certificatesLocation URL to published public keys
     * @return the builder
     */
    public Builder setCertificatesLocation(String certificatesLocation) {
      this.certificatesLocation = certificatesLocation;
      return this;
    }

    /**
     * Set the issuer to verify.
     *
     * @param issuer the issuer claim to verify
     * @return the builder
     */
    public Builder setIssuer(String issuer) {
      this.issuer = issuer;
      return this;
    }

    /**
     * Set the PublicKey for verifying the signature. This will ignore the key id from the JWT token
     * header.
     *
     * @param publicKey the public key to validate the signature
     * @return the builder
     */
    public Builder setPublicKey(PublicKey publicKey) {
      this.publicKey = publicKey;
      return this;
    }

    /**
     * Set the clock for checking token expiry. Used for testing.
     *
     * @param clock the clock to use. Defaults to the system clock
     * @return the builder
     */
    public Builder setClock(Clock clock) {
      this.clock = clock;
      return this;
    }

    /**
     * Set the HttpTransportFactory used for requesting public keys from the certificate URL. Used
     * mostly for testing.
     *
     * @param httpTransportFactory the HttpTransportFactory used to build certificate URL requests
     * @return the builder
     */
    public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
      this.httpTransportFactory = httpTransportFactory;
      return this;
    }

    /**
     * Build the custom TokenVerifier for verifying tokens.
     *
     * @return the customized TokenVerifier
     */
    public TokenVerifier build() {
      return new TokenVerifier(this);
    }
  }

  /** Custom CacheLoader for mapping certificate urls to the contained public keys. */
  static class PublicKeyLoader extends CacheLoader<String, Map<String, PublicKey>> {
    private static final int DEFAULT_NUMBER_OF_RETRIES = 2;
    private final HttpTransportFactory httpTransportFactory;

    /**
     * Data class used for deserializing a JSON Web Key Set (JWKS) from an external HTTP request.
     */
    public static class JsonWebKeySet extends GenericJson {
      @Key public List<JsonWebKey> keys;
    }

    /** Data class used for deserializing a single JSON Web Key. */
    public static class JsonWebKey {
      @Key public String alg;

      @Key public String crv;

      @Key public String kid;

      @Key public String kty;

      @Key public String use;

      @Key public String x;

      @Key public String y;

      @Key public String e;

      @Key public String n;
    }

    PublicKeyLoader(HttpTransportFactory httpTransportFactory) {
      super();
      this.httpTransportFactory = httpTransportFactory;
    }

    @Override
    public Map<String, PublicKey> load(String certificateUrl) throws Exception {
      HttpTransport httpTransport = httpTransportFactory.create();
      JsonWebKeySet jwks;
      HttpRequest request =
          httpTransport
              .createRequestFactory()
              .buildGetRequest(new GenericUrl(certificateUrl))
              .setParser(OAuth2Utils.JSON_FACTORY.createJsonObjectParser());
      request.setNumberOfRetries(DEFAULT_NUMBER_OF_RETRIES);

      ExponentialBackOff backoff =
          new ExponentialBackOff.Builder()
              .setInitialIntervalMillis(OAuth2Utils.INITIAL_RETRY_INTERVAL_MILLIS)
              .setRandomizationFactor(OAuth2Utils.RETRY_RANDOMIZATION_FACTOR)
              .setMultiplier(OAuth2Utils.RETRY_MULTIPLIER)
              .build();

      request.setUnsuccessfulResponseHandler(
          new HttpBackOffUnsuccessfulResponseHandler(backoff)
              .setBackOffRequired(BackOffRequired.ALWAYS));

      HttpResponse response = request.execute();
      jwks = response.parseAs(JsonWebKeySet.class);

      ImmutableMap.Builder<String, PublicKey> keyCacheBuilder = new ImmutableMap.Builder<>();
      if (jwks.keys == null) {
        // Fall back to x509 formatted specification
        for (String keyId : jwks.keySet()) {
          String publicKeyPem = (String) jwks.get(keyId);
          keyCacheBuilder.put(keyId, buildPublicKey(publicKeyPem));
        }
      } else {
        for (JsonWebKey key : jwks.keys) {
          try {
            keyCacheBuilder.put(key.kid, buildPublicKey(key));
          } catch (NoSuchAlgorithmException
              | InvalidKeySpecException
              | InvalidParameterSpecException ignored) {
            ignored.printStackTrace();
          }
        }
      }

      ImmutableMap<String, PublicKey> keyCache = keyCacheBuilder.build();

      if (keyCache.isEmpty()) {
        throw new VerificationException(
            "No valid public key returned by the keystore: " + certificateUrl);
      }

      return keyCache;
    }

    private PublicKey buildPublicKey(JsonWebKey key)
        throws NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeySpecException {
      if ("ES256".equals(key.alg)) {
        return buildEs256PublicKey(key);
      } else if ("RS256".equals((key.alg))) {
        return buildRs256PublicKey(key);
      } else {
        return null;
      }
    }

    private PublicKey buildPublicKey(String publicPem)
        throws CertificateException, UnsupportedEncodingException {
      return CertificateFactory.getInstance("X.509")
          .generateCertificate(new ByteArrayInputStream(publicPem.getBytes("UTF-8")))
          .getPublicKey();
    }

    private PublicKey buildRs256PublicKey(JsonWebKey key)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
      Preconditions.checkArgument("RSA".equals(key.kty));
      Preconditions.checkNotNull(key.e);
      Preconditions.checkNotNull(key.n);

      BigInteger modulus = new BigInteger(1, Base64.decodeBase64(key.n));
      BigInteger exponent = new BigInteger(1, Base64.decodeBase64(key.e));

      RSAPublicKeySpec spec = new RSAPublicKeySpec(modulus, exponent);
      KeyFactory factory = KeyFactory.getInstance("RSA");
      return factory.generatePublic(spec);
    }

    private PublicKey buildEs256PublicKey(JsonWebKey key)
        throws NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeySpecException {
      Preconditions.checkArgument("EC".equals(key.kty));
      Preconditions.checkArgument("P-256".equals(key.crv));

      BigInteger x = new BigInteger(1, Base64.decodeBase64(key.x));
      BigInteger y = new BigInteger(1, Base64.decodeBase64(key.y));
      ECPoint pubPoint = new ECPoint(x, y);
      AlgorithmParameters parameters = AlgorithmParameters.getInstance("EC");
      parameters.init(new ECGenParameterSpec("secp256r1"));
      ECParameterSpec ecParameters = parameters.getParameterSpec(ECParameterSpec.class);
      ECPublicKeySpec pubSpec = new ECPublicKeySpec(pubPoint, ecParameters);
      KeyFactory kf = KeyFactory.getInstance("EC");
      return kf.generatePublic(pubSpec);
    }
  }

  /** Custom exception for wrapping all verification errors. */
  public static class VerificationException extends Exception {
    public VerificationException(String message) {
      super(message);
    }

    public VerificationException(String message, Throwable cause) {
      super(message, cause);
    }
  }
}
