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

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Value class representing the set of fields used as the payload of a JWT token.
 *
 * <p>To create and customize claims, use the builder:
 *
 * <pre><code>
 * Claims claims = Claims.newBuilder()
 *     .setAudience("https://example.com/some-audience")
 *     .setIssuer("some-issuer@example.com")
 *     .setSubject("some-subject@example.com")
 *     .build();
 * </code></pre>
 */
@AutoValue
public abstract class JwtClaims implements Serializable {
  private static final long serialVersionUID = 4974444151019426702L;

  @Nullable
  abstract String getAudience();

  @Nullable
  abstract String getIssuer();

  @Nullable
  abstract String getSubject();

  /**
   * Returns additional claims for this object. The returned map is not guaranteed to be mutable.
   *
   * @return additional claims
   */
  abstract Map<String, String> getAdditionalClaims();

  public static Builder newBuilder() {
    return new AutoValue_JwtClaims.Builder().setAdditionalClaims(ImmutableMap.<String, String>of());
  }

  /**
   * Returns a new Claims instance with overridden fields.
   *
   * <p>Any non-null field will overwrite the value from the original claims instance.
   *
   * @param other claims to override
   * @return new claims
   */
  public JwtClaims merge(JwtClaims other) {
    ImmutableMap.Builder<String, String> newClaimsBuilder = ImmutableMap.builder();
    newClaimsBuilder.putAll(getAdditionalClaims());
    newClaimsBuilder.putAll(other.getAdditionalClaims());

    return newBuilder()
        .setAudience(other.getAudience() == null ? getAudience() : other.getAudience())
        .setIssuer(other.getIssuer() == null ? getIssuer() : other.getIssuer())
        .setSubject(other.getSubject() == null ? getSubject() : other.getSubject())
        .setAdditionalClaims(newClaimsBuilder.build())
        .build();
  }

  /**
   * Returns whether or not this set of claims is complete.
   *
   * <p>Audience, issuer, and subject are required to be set in order to use the claim set for a JWT
   * token. An incomplete Claims instance is useful for overriding claims when using {@link
   * ServiceAccountJwtAccessCredentials#jwtWithClaims(JwtClaims)} or {@link
   * JwtCredentials#jwtWithClaims(JwtClaims)}.
   *
   * @return true if all required fields have been set; false otherwise
   */
  public boolean isComplete() {
    boolean hasScopes =
        getAdditionalClaims().containsKey("scope") && !getAdditionalClaims().get("scope").isEmpty();
    return (getAudience() != null || hasScopes) && getIssuer() != null && getSubject() != null;
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setAudience(String audience);

    public abstract Builder setIssuer(String issuer);

    public abstract Builder setSubject(String subject);

    public abstract Builder setAdditionalClaims(Map<String, String> additionalClaims);

    public abstract JwtClaims build();
  }
}
