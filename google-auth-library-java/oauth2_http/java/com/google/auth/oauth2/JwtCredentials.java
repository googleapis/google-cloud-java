/*
 * Copyright 2019, Google LLC
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

import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.http.AuthHttpConstants;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Credentials class for calling Google APIs using a JWT with custom claims.
 *
 * <p>Uses a JSON Web Token (JWT) directly in the request metadata to provide authorization.
 *
 * <pre><code>
 * JwtClaims claims = JwtClaims.newBuilder()
 *     .setAudience("https://example.com/some-audience")
 *     .setIssuer("some-issuer@example.com")
 *     .setSubject("some-subject@example.com")
 *     .build();
 * Credentials = JwtCredentials.newBuilder()
 *     .setPrivateKey(privateKey)
 *     .setPrivateKeyId("private-key-id")
 *     .setJwtClaims(claims)
 *     .build();
 * </code></pre>
 */
public class JwtCredentials extends Credentials implements JwtProvider {
  private static final String JWT_ACCESS_PREFIX = OAuth2Utils.BEARER_PREFIX;
  private static final String JWT_INCOMPLETE_ERROR_MESSAGE =
      "JWT claims must contain audience, " + "issuer, and subject.";
  private static final long CLOCK_SKEW = TimeUnit.MINUTES.toSeconds(5);

  // byte[] is serializable, so the lock variable can be final
  private final Object lock = new byte[0];
  private final PrivateKey privateKey;
  private final String privateKeyId;
  private final JwtClaims jwtClaims;
  private final Long lifeSpanSeconds;
  @VisibleForTesting transient Clock clock;

  private transient String jwt;
  // The date (represented as seconds since the epoch) that the generated JWT expires
  private transient Long expiryInSeconds;

  private JwtCredentials(Builder builder) {
    this.privateKey = Preconditions.checkNotNull(builder.getPrivateKey());
    this.privateKeyId = builder.getPrivateKeyId();
    this.jwtClaims = Preconditions.checkNotNull(builder.getJwtClaims());
    Preconditions.checkState(jwtClaims.isComplete(), JWT_INCOMPLETE_ERROR_MESSAGE);
    this.lifeSpanSeconds = Preconditions.checkNotNull(builder.getLifeSpanSeconds());
    this.clock = Preconditions.checkNotNull(builder.getClock());
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** Refresh the token by discarding the cached token and metadata and rebuilding a new one. */
  @Override
  public void refresh() throws IOException {
    JsonWebSignature.Header header = new JsonWebSignature.Header();
    header.setAlgorithm("RS256");
    header.setType("JWT");
    header.setKeyId(privateKeyId);

    JsonWebToken.Payload payload = new JsonWebToken.Payload();
    payload.setAudience(jwtClaims.getAudience());
    payload.setIssuer(jwtClaims.getIssuer());
    payload.setSubject(jwtClaims.getSubject());

    long currentTime = clock.currentTimeMillis();
    payload.setIssuedAtTimeSeconds(currentTime / 1000);
    payload.setExpirationTimeSeconds(currentTime / 1000 + lifeSpanSeconds);

    // Add all additional claims
    payload.putAll(jwtClaims.getAdditionalClaims());

    synchronized (lock) {
      this.expiryInSeconds = payload.getExpirationTimeSeconds();

      try {
        this.jwt =
            JsonWebSignature.signUsingRsaSha256(
                privateKey, OAuth2Utils.JSON_FACTORY, header, payload);
      } catch (GeneralSecurityException e) {
        throw new IOException(
            "Error signing service account JWT access header with private key.", e);
      }
    }
  }

  private boolean shouldRefresh() {
    return expiryInSeconds == null
        || getClock().currentTimeMillis() / 1000 > expiryInSeconds - CLOCK_SKEW;
  }

  /**
   * Returns a copy of these credentials with modified claims.
   *
   * @param newClaims new claims. Any unspecified claim fields default to the current values.
   * @return new credentials
   */
  @Override
  public JwtCredentials jwtWithClaims(JwtClaims newClaims) {
    return JwtCredentials.newBuilder()
        .setPrivateKey(privateKey)
        .setPrivateKeyId(privateKeyId)
        .setJwtClaims(jwtClaims.merge(newClaims))
        .build();
  }

  @Override
  public String getAuthenticationType() {
    return "JWT";
  }

  @Override
  public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
    synchronized (lock) {
      if (shouldRefresh()) {
        refresh();
      }
      List<String> newAuthorizationHeaders = Collections.singletonList(JWT_ACCESS_PREFIX + jwt);
      return Collections.singletonMap(AuthHttpConstants.AUTHORIZATION, newAuthorizationHeaders);
    }
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
  public boolean equals(Object obj) {
    if (!(obj instanceof JwtCredentials)) {
      return false;
    }
    JwtCredentials other = (JwtCredentials) obj;
    return Objects.equals(this.privateKey, other.privateKey)
        && Objects.equals(this.privateKeyId, other.privateKeyId)
        && Objects.equals(this.jwtClaims, other.jwtClaims)
        && Objects.equals(this.lifeSpanSeconds, other.lifeSpanSeconds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.privateKey, this.privateKeyId, this.jwtClaims, this.lifeSpanSeconds);
  }

  Clock getClock() {
    if (clock == null) {
      clock = Clock.SYSTEM;
    }
    return clock;
  }

  public static class Builder {
    private PrivateKey privateKey;
    private String privateKeyId;
    private JwtClaims jwtClaims;
    private Clock clock = Clock.SYSTEM;
    private Long lifeSpanSeconds = TimeUnit.HOURS.toSeconds(1);

    protected Builder() {}

    @CanIgnoreReturnValue
    public Builder setPrivateKey(PrivateKey privateKey) {
      this.privateKey = Preconditions.checkNotNull(privateKey);
      return this;
    }

    public PrivateKey getPrivateKey() {
      return privateKey;
    }

    @CanIgnoreReturnValue
    public Builder setPrivateKeyId(String privateKeyId) {
      this.privateKeyId = privateKeyId;
      return this;
    }

    public String getPrivateKeyId() {
      return privateKeyId;
    }

    @CanIgnoreReturnValue
    public Builder setJwtClaims(JwtClaims claims) {
      this.jwtClaims = Preconditions.checkNotNull(claims);
      return this;
    }

    public JwtClaims getJwtClaims() {
      return jwtClaims;
    }

    @CanIgnoreReturnValue
    public Builder setLifeSpanSeconds(Long lifeSpanSeconds) {
      this.lifeSpanSeconds = Preconditions.checkNotNull(lifeSpanSeconds);
      return this;
    }

    public Long getLifeSpanSeconds() {
      return lifeSpanSeconds;
    }

    @CanIgnoreReturnValue
    Builder setClock(Clock clock) {
      this.clock = Preconditions.checkNotNull(clock);
      return this;
    }

    Clock getClock() {
      return clock;
    }

    public JwtCredentials build() {
      return new JwtCredentials(this);
    }
  }
}
