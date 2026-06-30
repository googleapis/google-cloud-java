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

import static com.google.auth.oauth2.OAuth2Utils.TOKEN_EXCHANGE_URL_FORMAT;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

/**
 * DownscopedCredentials enables the ability to downscope, or restrict, the Identity and Access
 * Management (IAM) permissions that a short-lived credential can use for Cloud Storage.
 *
 * <p>This class provides a server-side approach for generating downscoped tokens, suitable for
 * situations where Credential Access Boundary rules change infrequently or a single downscoped
 * credential is reused many times. For scenarios where rules change frequently, or you need to
 * generate many unique downscoped tokens, the client-side approach using {@code
 * com.google.auth.credentialaccessboundary.ClientSideCredentialAccessBoundaryFactory} is more
 * efficient.
 *
 * <p>To downscope permissions you must define a {@link CredentialAccessBoundary} which specifies
 * the upper bound of permissions that the credential can access. You must also provide a source
 * credential which will be used to acquire the downscoped credential.
 *
 * <p>See <a href='https://cloud.google.com/iam/docs/downscoping-short-lived-credentials'>for more
 * information.</a>
 *
 * <p>Usage:
 *
 * <pre><code>
 * GoogleCredentials sourceCredentials = GoogleCredentials.getApplicationDefault()
 *    .createScoped("https://www.googleapis.com/auth/cloud-platform");
 *
 * CredentialAccessBoundary.AccessBoundaryRule rule =
 *     CredentialAccessBoundary.AccessBoundaryRule.newBuilder()
 *         .setAvailableResource(
 *             "//storage.googleapis.com/projects/_/buckets/bucket")
 *         .addAvailablePermission("inRole:roles/storage.objectViewer")
 *         .build();
 *
 * DownscopedCredentials downscopedCredentials =
 *     DownscopedCredentials.newBuilder()
 *         .setSourceCredential(sourceCredentials)
 *         .setCredentialAccessBoundary(
 *             CredentialAccessBoundary.newBuilder().addRule(rule).build())
 *         .build();
 *
 * AccessToken accessToken = downscopedCredentials.refreshAccessToken();
 *
 * OAuth2Credentials credentials = OAuth2Credentials.create(accessToken);
 *
 * Storage storage =
 * StorageOptions.newBuilder().setCredentials(credentials).build().getService();
 *
 * Blob blob = storage.get(BlobId.of("bucket", "object"));
 * System.out.printf("Blob %s retrieved.", blob.getBlobId());
 * </code></pre>
 *
 * Note that {@link OAuth2CredentialsWithRefresh} can instead be used to consume the downscoped
 * token, allowing for automatic token refreshes by providing a {@link
 * OAuth2CredentialsWithRefresh.OAuth2RefreshHandler}.
 */
public final class DownscopedCredentials extends OAuth2Credentials {

  private final GoogleCredentials sourceCredential;
  private final CredentialAccessBoundary credentialAccessBoundary;
  private final String universeDomain;

  private final transient HttpTransportFactory transportFactory;

  private final String tokenExchangeEndpoint;

  /** Internal constructor. See {@link Builder}. */
  private DownscopedCredentials(Builder builder) {
    this.transportFactory =
        firstNonNull(
            builder.transportFactory,
            getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    this.sourceCredential = checkNotNull(builder.sourceCredential);
    this.credentialAccessBoundary = checkNotNull(builder.credentialAccessBoundary);

    // Default to GDU when not supplied.
    if (builder.universeDomain == null || builder.universeDomain.trim().isEmpty()) {
      this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
    } else {
      this.universeDomain = builder.universeDomain;
    }

    // Ensure source credential's universe domain matches.
    try {
      if (!this.universeDomain.equals(sourceCredential.getUniverseDomain())) {
        throw new IllegalArgumentException(
            "The downscoped credential's universe domain must be the same as the source "
                + "credential.");
      }
    } catch (IOException e) {
      // Throwing an IOException would be a breaking change, so wrap it here.
      throw new IllegalStateException(
          "Error occurred when attempting to retrieve source credential universe domain.", e);
    }
    this.tokenExchangeEndpoint = String.format(TOKEN_EXCHANGE_URL_FORMAT, universeDomain);
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    try {
      this.sourceCredential.refreshIfExpired();
    } catch (IOException e) {
      throw new IOException("Unable to refresh the provided source credential.", e);
    }

    StsTokenExchangeRequest request =
        StsTokenExchangeRequest.newBuilder(
                sourceCredential.getAccessToken().getTokenValue(),
                OAuth2Utils.TOKEN_TYPE_ACCESS_TOKEN)
            .setRequestTokenType(OAuth2Utils.TOKEN_TYPE_ACCESS_TOKEN)
            .build();

    StsRequestHandler handler =
        StsRequestHandler.newBuilder(
                tokenExchangeEndpoint, request, transportFactory.create().createRequestFactory())
            .setInternalOptions(credentialAccessBoundary.toJson())
            .build();

    AccessToken downscopedAccessToken = handler.exchangeToken().getAccessToken();

    // The STS endpoint will only return the expiration time for the downscoped token if the
    // original access token represents a service account.
    // The downscoped token's expiration time will always match the source credential expiration.
    // When no expires_in is returned, we can copy the source credential's expiration time.
    if (downscopedAccessToken.getExpirationTime() == null) {
      AccessToken sourceAccessToken = this.sourceCredential.getAccessToken();
      if (sourceAccessToken.getExpirationTime() != null) {
        return new AccessToken(
            downscopedAccessToken.getTokenValue(), sourceAccessToken.getExpirationTime());
      }
    }
    return downscopedAccessToken;
  }

  public GoogleCredentials getSourceCredentials() {
    return sourceCredential;
  }

  public CredentialAccessBoundary getCredentialAccessBoundary() {
    return credentialAccessBoundary;
  }

  /**
   * Returns the universe domain for the credential.
   *
   * @return An explicit universe domain if it was explicitly provided, otherwise the default Google
   *     universe will be returned.
   */
  @Override
  public String getUniverseDomain() {
    return universeDomain;
  }

  @VisibleForTesting
  HttpTransportFactory getTransportFactory() {
    return transportFactory;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder extends OAuth2Credentials.Builder {

    private GoogleCredentials sourceCredential;
    private CredentialAccessBoundary credentialAccessBoundary;
    private HttpTransportFactory transportFactory;
    private String universeDomain;

    private Builder() {}

    /**
     * Sets the required source credential used to acquire the downscoped credential.
     *
     * @param sourceCredential the {@code GoogleCredentials} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setSourceCredential(GoogleCredentials sourceCredential) {
      this.sourceCredential = sourceCredential;
      return this;
    }

    /**
     * Sets the required credential access boundary which specifies the upper bound of permissions
     * that the credential can access. See {@link CredentialAccessBoundary} for more information.
     *
     * @param credentialAccessBoundary the {@code CredentialAccessBoundary} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setCredentialAccessBoundary(CredentialAccessBoundary credentialAccessBoundary) {
      this.credentialAccessBoundary = credentialAccessBoundary;
      return this;
    }

    /**
     * Sets the HTTP transport factory.
     *
     * @param transportFactory the {@code HttpTransportFactory} to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      this.transportFactory = transportFactory;
      return this;
    }

    /**
     * Sets the optional universe domain.
     *
     * @param universeDomain the universe domain to set
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setUniverseDomain(String universeDomain) {
      this.universeDomain = universeDomain;
      return this;
    }

    @Override
    public DownscopedCredentials build() {
      return new DownscopedCredentials(this);
    }
  }
}
