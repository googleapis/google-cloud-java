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

import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/** Represents a temporary OAuth2 access token and its expiration information. */
public class AccessToken implements Serializable {

  private static final long serialVersionUID = -8514239465808977353L;

  private final String tokenValue;
  private final Long expirationTimeMillis;
  private final List<String> scopes;

  /**
   * @param tokenValue String representation of the access token.
   * @param expirationTime Time when access token will expire.
   */
  public AccessToken(String tokenValue, Date expirationTime) {
    this.tokenValue = tokenValue;
    this.expirationTimeMillis = (expirationTime == null) ? null : expirationTime.getTime();
    this.scopes = new ArrayList<>();
  }

  private AccessToken(Builder builder) {
    this.tokenValue = builder.getTokenValue();
    Date expirationTime = builder.getExpirationTime();
    this.expirationTimeMillis = (expirationTime == null) ? null : expirationTime.getTime();
    this.scopes = builder.getScopes();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Scopes from the access token response. Not all credentials provide scopes in response and as
   * per https://datatracker.ietf.org/doc/html/rfc6749#section-5.1 it is optional in the response.
   *
   * @return List of scopes
   */
  public List<String> getScopes() {
    return scopes;
  }

  /**
   * String representation of the access token.
   *
   * @return The raw access token string value.
   */
  public String getTokenValue() {
    return tokenValue;
  }

  /**
   * Time when access token will expire.
   *
   * @return The expiration time as a {@link Date}.
   */
  public Date getExpirationTime() {
    if (expirationTimeMillis == null) {
      return null;
    }
    return new Date(expirationTimeMillis);
  }

  Long getExpirationTimeMillis() {
    return expirationTimeMillis;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenValue, expirationTimeMillis, scopes);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tokenValue", tokenValue)
        .add("expirationTimeMillis", expirationTimeMillis)
        .add("scopes", scopes)
        .toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AccessToken)) {
      return false;
    }
    AccessToken other = (AccessToken) obj;
    return Objects.equals(this.tokenValue, other.tokenValue)
        && Objects.equals(this.expirationTimeMillis, other.expirationTimeMillis)
        && Objects.equals(this.scopes, other.scopes);
  }

  public static class Builder {
    private String tokenValue;
    private Date expirationTime;
    private List<String> scopes = new ArrayList<>();

    protected Builder() {}

    protected Builder(AccessToken accessToken) {
      this.tokenValue = accessToken.getTokenValue();
      this.expirationTime = accessToken.getExpirationTime();
      this.scopes = accessToken.getScopes();
    }

    public String getTokenValue() {
      return this.tokenValue;
    }

    public List<String> getScopes() {
      return this.scopes;
    }

    public Date getExpirationTime() {
      return this.expirationTime;
    }

    @CanIgnoreReturnValue
    public Builder setTokenValue(String tokenValue) {
      this.tokenValue = tokenValue;
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(String scopes) {
      if (scopes != null && scopes.trim().length() > 0) {
        this.scopes = Arrays.asList(scopes.split(" "));
      }
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setScopes(List<String> scopes) {
      if (scopes == null) {
        this.scopes = new ArrayList<>();
      } else {
        this.scopes = scopes;
      }

      return this;
    }

    @CanIgnoreReturnValue
    public Builder setExpirationTime(Date expirationTime) {
      this.expirationTime = expirationTime;
      return this;
    }

    public AccessToken build() {
      return new AccessToken(this);
    }
  }
}
