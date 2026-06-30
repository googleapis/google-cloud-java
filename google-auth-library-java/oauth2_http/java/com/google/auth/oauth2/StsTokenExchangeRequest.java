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

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Represents an OAuth 2.0 token exchange request, as defined in <a
 * href="https://tools.ietf.org/html/rfc8693#section-2.1">RFC 8693, Section 2.1</a>.
 *
 * <p>This class encapsulates the parameters necessary for making a token exchange request to Google
 * Security Token Service (STS). It includes the subject token, subject token type, optional
 * parameters like acting party, scopes, resource, audience, requested token type, and internal
 * options.
 *
 * <p>Instances of this class are immutable. Use the {@link #newBuilder(String, String)} method to
 * create a new builder.
 */
public final class StsTokenExchangeRequest {
  private static final String GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange";

  private final String subjectToken;
  private final String subjectTokenType;

  @Nullable private final ActingParty actingParty;
  @Nullable private final List<String> scopes;
  @Nullable private final String resource;
  @Nullable private final String audience;
  @Nullable private final String requestedTokenType;
  @Nullable private final String internalOptions;

  private StsTokenExchangeRequest(
      String subjectToken,
      String subjectTokenType,
      @Nullable ActingParty actingParty,
      @Nullable List<String> scopes,
      @Nullable String resource,
      @Nullable String audience,
      @Nullable String requestedTokenType,
      @Nullable String internalOptions) {
    this.subjectToken = checkNotNull(subjectToken);
    this.subjectTokenType = checkNotNull(subjectTokenType);
    this.actingParty = actingParty;
    this.scopes = scopes;
    this.resource = resource;
    this.audience = audience;
    this.requestedTokenType = requestedTokenType;
    this.internalOptions = internalOptions;
  }

  /**
   * Returns a new {@link StsTokenExchangeRequest.Builder} instance.
   *
   * @param subjectToken The token being exchanged. This represents the credentials being used to
   *     authorize the token exchange request.
   * @param subjectTokenType The type of the {@code subjectToken}. For example, {@link
   *     OAuth2Utils#TOKEN_TYPE_ACCESS_TOKEN}.
   * @return A new builder for creating {@code StsTokenExchangeRequest} instances.
   */
  public static Builder newBuilder(String subjectToken, String subjectTokenType) {
    return new Builder(subjectToken, subjectTokenType);
  }

  public String getGrantType() {
    return GRANT_TYPE;
  }

  public String getSubjectToken() {
    return subjectToken;
  }

  public String getSubjectTokenType() {
    return subjectTokenType;
  }

  @Nullable
  public String getResource() {
    return resource;
  }

  @Nullable
  public String getAudience() {
    return audience;
  }

  @Nullable
  public String getRequestedTokenType() {
    return requestedTokenType;
  }

  @Nullable
  public List<String> getScopes() {
    return scopes;
  }

  @Nullable
  public ActingParty getActingParty() {
    return actingParty;
  }

  @Nullable
  public String getInternalOptions() {
    return internalOptions;
  }

  public boolean hasResource() {
    return resource != null && !resource.isEmpty();
  }

  public boolean hasAudience() {
    return audience != null && !audience.isEmpty();
  }

  public boolean hasRequestedTokenType() {
    return requestedTokenType != null && !requestedTokenType.isEmpty();
  }

  public boolean hasScopes() {
    return scopes != null && !scopes.isEmpty();
  }

  public boolean hasActingParty() {
    return actingParty != null;
  }

  public static class Builder {
    private final String subjectToken;
    private final String subjectTokenType;

    @Nullable private String resource;
    @Nullable private String audience;
    @Nullable private String requestedTokenType;
    @Nullable private List<String> scopes;
    @Nullable private ActingParty actingParty;
    @Nullable private String internalOptions;

    private Builder(String subjectToken, String subjectTokenType) {
      this.subjectToken = subjectToken;
      this.subjectTokenType = subjectTokenType;
    }

    @CanIgnoreReturnValue
    public StsTokenExchangeRequest.Builder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    @CanIgnoreReturnValue
    public StsTokenExchangeRequest.Builder setAudience(String audience) {
      this.audience = audience;
      return this;
    }

    @CanIgnoreReturnValue
    public StsTokenExchangeRequest.Builder setRequestTokenType(String requestedTokenType) {
      this.requestedTokenType = requestedTokenType;
      return this;
    }

    @CanIgnoreReturnValue
    public StsTokenExchangeRequest.Builder setScopes(List<String> scopes) {
      this.scopes = scopes;
      return this;
    }

    @CanIgnoreReturnValue
    public StsTokenExchangeRequest.Builder setActingParty(ActingParty actingParty) {
      this.actingParty = actingParty;
      return this;
    }

    @CanIgnoreReturnValue
    public StsTokenExchangeRequest.Builder setInternalOptions(String internalOptions) {
      this.internalOptions = internalOptions;
      return this;
    }

    public StsTokenExchangeRequest build() {
      return new StsTokenExchangeRequest(
          subjectToken,
          subjectTokenType,
          actingParty,
          scopes,
          resource,
          audience,
          requestedTokenType,
          internalOptions);
    }
  }
}
