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

import com.google.auth.Credentials;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * A refreshable alternative to {@link OAuth2Credentials}.
 *
 * <p>Wraps an expiring {@link AccessToken} and automatically invokes the configured {@link
 * OAuth2RefreshHandler} to fetch a new token when the current token nears expiry (for example, from
 * a token broker issuing downscoped tokens).
 *
 * <p>Because {@link OAuth2RefreshHandler} returns {@link AccessToken} values without universe
 * domain metadata, credentials default to {@link Credentials#GOOGLE_DEFAULT_UNIVERSE}. Callers
 * refreshing tokens for a custom universe domain should configure it explicitly via {@link
 * Builder#setUniverseDomain(String)}.
 *
 * <p>Usage:
 *
 * <pre>{@code
 * OAuth2CredentialsWithRefresh credentials =
 *     OAuth2CredentialsWithRefresh.newBuilder()
 *         .setAccessToken(accessToken)
 *         .setUniverseDomain(universeDomain) // optional, defaults to googleapis.com
 *         .setRefreshHandler(this::fetchRefreshedAccessToken)
 *         .build();
 * }</pre>
 */
@NullMarked
public class OAuth2CredentialsWithRefresh extends OAuth2Credentials {

  // Matches the computed serialVersionUID prior to adding universeDomain.
  private static final long serialVersionUID = -5362111100740719676L;

  /** Interface for the refresh handler. */
  public interface OAuth2RefreshHandler {
    AccessToken refreshAccessToken() throws IOException;
  }

  private final OAuth2RefreshHandler refreshHandler;
  @VisibleForTesting String universeDomain;

  protected OAuth2CredentialsWithRefresh(Builder builder) {
    super(builder.getAccessToken(), builder.getRefreshMargin(), builder.getExpirationMargin());
    // If no expirationTime is provided, the token will never be refreshed.
    if (builder.getAccessToken() != null && builder.getAccessToken().getExpirationTime() == null) {
      throw new IllegalArgumentException(
          "The provided access token must contain the expiration time.");
    }
    this.refreshHandler = checkNotNull(builder.refreshHandler);
    if (builder.universeDomain == null || builder.universeDomain.trim().isEmpty()) {
      this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
    } else {
      this.universeDomain = builder.universeDomain;
    }
  }

  protected OAuth2CredentialsWithRefresh(
      AccessToken accessToken, OAuth2RefreshHandler refreshHandler) {
    this(newBuilder().setAccessToken(accessToken).setRefreshHandler(refreshHandler));
  }

  /** Refreshes the access token using the provided {@link OAuth2RefreshHandler}. */
  @Override
  public AccessToken refreshAccessToken() throws IOException {
    // Delegate refresh to the provided refresh handler.
    return refreshHandler.refreshAccessToken();
  }

  /** Returns the provided {@link OAuth2RefreshHandler}. */
  public OAuth2RefreshHandler getRefreshHandler() {
    return refreshHandler;
  }

  /**
   * Returns the universe domain for this credential.
   *
   * <p>Returns the fixed universe domain configured via {@link Builder#setUniverseDomain(String)},
   * or {@link Credentials#GOOGLE_DEFAULT_UNIVERSE} if none was configured. Subclasses may override
   * this method if lazy or delegated resolution is required.
   *
   * @return the configured universe domain, or {@link Credentials#GOOGLE_DEFAULT_UNIVERSE} if none
   *     was explicitly configured
   * @throws IOException if a subclass fails while resolving the universe domain
   */
  @Override
  public String getUniverseDomain() throws IOException {
    return this.universeDomain;
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    if (!(obj instanceof OAuth2CredentialsWithRefresh)) {
      return false;
    }
    OAuth2CredentialsWithRefresh other = (OAuth2CredentialsWithRefresh) obj;
    return super.equals(other)
        && Objects.equals(this.refreshHandler, other.refreshHandler)
        && Objects.equals(this.universeDomain, other.universeDomain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.refreshHandler, this.universeDomain);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    // Default absent or blank universeDomain from older serialized streams.
    if (this.universeDomain == null || this.universeDomain.trim().isEmpty()) {
      this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder extends OAuth2Credentials.Builder {

    private OAuth2RefreshHandler refreshHandler;
    private @Nullable String universeDomain;

    private Builder() {}

    /**
     * Sets the {@link AccessToken} to be consumed. It must contain an expiration time otherwise an
     * {@link IllegalArgumentException} will be thrown.
     */
    @Override
    @CanIgnoreReturnValue
    public Builder setAccessToken(AccessToken token) {
      super.setAccessToken(token);
      return this;
    }

    /** Sets the {@link OAuth2RefreshHandler} to be used for token refreshes. */
    @CanIgnoreReturnValue
    public Builder setRefreshHandler(OAuth2RefreshHandler handler) {
      this.refreshHandler = handler;
      return this;
    }

    /**
     * Sets the fixed universe domain for this credential. If null or blank, defaults to {@link
     * Credentials#GOOGLE_DEFAULT_UNIVERSE}.
     *
     * <p>Because {@link OAuth2RefreshHandler} returns {@link AccessToken} values without universe
     * domain metadata, callers refreshing tokens for a custom universe domain must set this
     * explicitly.
     *
     * @param universeDomain the universe domain (for example, {@code googleapis.com})
     * @return this builder
     */
    @CanIgnoreReturnValue
    public Builder setUniverseDomain(@Nullable String universeDomain) {
      this.universeDomain = universeDomain;
      return this;
    }

    /** Returns the configured universe domain, or {@code null} if not explicitly set. */
    public @Nullable String getUniverseDomain() {
      return universeDomain;
    }

    @Override
    public OAuth2CredentialsWithRefresh build() {
      return new OAuth2CredentialsWithRefresh(this);
    }
  }
}
