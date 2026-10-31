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

import com.google.api.client.http.HttpResponseException;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.CertificateSourceUnavailableException;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.mtls.MtlsUtils;
import com.google.auth.mtls.X509Provider;
import com.google.auth.oauth2.IdentityPoolCredentialSource.IdentityPoolCredentialSourceType;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Url-sourced, file-sourced, or user provided supplier method-sourced external account credentials.
 *
 * <p>By default, attempts to exchange the external credential for a GCP access token.
 *
 * <p>Note: Actor token extraction from credential configuration files is currently restricted to
 * file-based JSON credential sources. When configuring certificate-bound OAuth 2.0 tokens, ensure
 * your transport layer and endpoints are configured for mTLS in tandem.
 */
@NullMarked
public class IdentityPoolCredentials extends ExternalAccountCredentials {

  static final String FILE_METRICS_HEADER_VALUE = "file";
  static final String URL_METRICS_HEADER_VALUE = "url";
  static final String CERTIFICATE_METRICS_HEADER_VALUE = "certificate";

  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(IdentityPoolCredentials.class);
  private static final long serialVersionUID = 2471046175477275881L;
  private final IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
  private final @Nullable IdentityPoolActorTokenSupplier actorTokenSupplier;
  private final @Nullable String actorTokenType;
  // Transient: not serialized directly. Reconstructed in readObject() from the credentialSource
  // certificate config so deserialized credentials remain usable for mTLS and refresh.
  private transient volatile @Nullable X509Provider x509Provider;
  private final boolean useMtlsTransportFactory;
  private final ExternalAccountSupplierContext supplierContext;
  private final String metricsHeaderValue;

  /** Internal constructor. See {@link Builder}. */
  IdentityPoolCredentials(Builder builder) {
    super(builder);
    IdentityPoolCredentialSource credentialSource =
        (IdentityPoolCredentialSource) builder.credentialSource;
    this.supplierContext =
        ExternalAccountSupplierContext.newBuilder()
            .setAudience(this.getAudience())
            .setSubjectTokenType(this.getSubjectTokenType())
            .build();

    // Check that one and only one of supplier or credential source are provided.
    if (builder.subjectTokenSupplier != null && credentialSource != null) {
      throw new IllegalArgumentException(
          "IdentityPoolCredentials cannot have both a subjectTokenSupplier and a"
              + " credentialSource.");
    }
    if (builder.subjectTokenSupplier == null && credentialSource == null) {
      throw new IllegalArgumentException(
          "A subjectTokenSupplier or a credentialSource must be provided.");
    }

    // Store the x509Provider and useMtlsTransportFactory flag for per-cycle cert pinning and
    // deserialization recovery.
    this.x509Provider = builder.x509Provider;
    this.useMtlsTransportFactory = builder.useMtlsTransportFactory;

    // Initialize based on the source type
    if (builder.subjectTokenSupplier != null) {
      this.subjectTokenSupplier = builder.subjectTokenSupplier;
      this.metricsHeaderValue = PROGRAMMATIC_METRICS_HEADER_VALUE;
    } else if (credentialSource.credentialSourceType == IdentityPoolCredentialSourceType.FILE) {
      if (credentialSource.getCertificateConfig() != null) {
        try {
          initializeMtlsTransport(builder, credentialSource);
        } catch (Exception e) {
          throw new RuntimeException(
              "Failed to initialize mTLS transport for file credential source due to certificate"
                  + " error.",
              e);
        }
      }
      this.subjectTokenSupplier = new FileIdentityPoolSubjectTokenSupplier(credentialSource);
      this.metricsHeaderValue = FILE_METRICS_HEADER_VALUE;
    } else if (credentialSource.credentialSourceType == IdentityPoolCredentialSourceType.URL) {
      this.subjectTokenSupplier =
          new UrlIdentityPoolSubjectTokenSupplier(credentialSource, this.transportFactory);
      this.metricsHeaderValue = URL_METRICS_HEADER_VALUE;
    } else if (credentialSource.credentialSourceType
        == IdentityPoolCredentialSourceType.CERTIFICATE) {
      try {
        this.subjectTokenSupplier =
            createCertificateSubjectTokenSupplier(builder, credentialSource);
      } catch (IOException e) {
        throw new RuntimeException(
            // Wrap IOException in RuntimeException because constructors cannot throw checked
            // exceptions.
            "Failed to initialize IdentityPoolCredentials from certificate source due to an I/O"
                + " error.",
            e);
      }
      this.metricsHeaderValue = CERTIFICATE_METRICS_HEADER_VALUE;
    } else {
      throw new IllegalArgumentException("Source type not supported.");
    }

    this.actorTokenType = builder.actorTokenType;
    if (builder.actorTokenSupplier != null) {
      this.actorTokenSupplier = builder.actorTokenSupplier;
    } else if (credentialSource != null && credentialSource.actorTokenFieldName != null) {
      if (this.subjectTokenSupplier instanceof FileIdentityPoolSubjectTokenSupplier) {
        this.actorTokenSupplier = (FileIdentityPoolSubjectTokenSupplier) this.subjectTokenSupplier;
      } else {
        throw new IllegalArgumentException(
            "Actor tokens are currently only supported for file-based credential sources.");
      }
    } else {
      this.actorTokenSupplier = null;
    }

    if (this.actorTokenSupplier != null
        && (this.actorTokenType == null || this.actorTokenType.trim().isEmpty())) {
      throw new IllegalArgumentException(
          "An actorTokenType must be specified when an actorTokenSupplier is configured.");
    }
    if (this.actorTokenSupplier == null && this.actorTokenType != null) {
      throw new IllegalArgumentException(
          "An actorTokenSupplier must be specified when an actorTokenType is configured.");
    }
  }

  /**
   * Checks whether mTLS is properly configured by verifying that an X509Provider is set or the
   * transport factory is an MtlsHttpTransportFactory with a non-null KeyStore. This avoids false
   * positives from a no-arg-constructed MtlsHttpTransportFactory (e.g. after deserialization) that
   * has no actual certificates.
   */
  boolean isMtlsConfigured() {
    return this.x509Provider != null || OAuth2Utils.hasMtlsKeyStore(this.transportFactory);
  }

  @VisibleForTesting
  boolean shouldUseMtlsTransportFactory() {
    // Also check OAuth2Utils.isDefaultOrMtlsTransportFactory(this.transportFactory) because a
    // custom MtlsHttpTransportFactory subclass constructed with a KeyStore has
    // useMtlsTransportFactory == false at build time, but deserialization in
    // ExternalAccountCredentials.readObject() re-instantiates it via its no-arg constructor
    // without a KeyStore.
    return this.useMtlsTransportFactory
        || OAuth2Utils.isDefaultOrMtlsTransportFactory(this.transportFactory);
  }

  boolean hasMtlsProviderForImpersonation() {
    return this.x509Provider != null && shouldUseMtlsTransportFactory();
  }

  /**
   * Returns whether a clone of this credential can skip reading the KeyStore because the transport
   * factory is already initialized (an mTLS factory with a KeyStore, or a custom non-mTLS factory).
   */
  private boolean hasInitializedMtlsTransport() {
    return this.x509Provider != null
        && (!shouldUseMtlsTransportFactory() || OAuth2Utils.hasMtlsKeyStore(this.transportFactory));
  }

  AccessToken refreshImpersonatedAccessTokenWithRetry(ImpersonatedCredentials impersonated)
      throws IOException {
    return refreshWithRetry(impersonated);
  }

  private static boolean isMtlsRetryableException(@Nullable Throwable throwable) {
    return OAuth2Utils.isUnauthorizedException(throwable)
        || OAuth2Utils.isInvalidGrantException(throwable)
        || isRetryableTransportException(throwable);
  }

  private static boolean isRetryableTransportException(@Nullable Throwable throwable) {
    if (!(throwable instanceof IOException)
        || throwable instanceof CertificateSourceUnavailableException) {
      return false;
    }
    Throwable current = throwable;
    while (current != null) {
      if (current instanceof OAuthException || current instanceof HttpResponseException) {
        return false;
      }
      current = current.getCause();
    }
    return true;
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    if (this.x509Provider != null && shouldUseMtlsTransportFactory()) {
      // Per-cycle cert pinning: snapshot the KeyStore at the start of each refresh cycle inside
      // refreshWithRetry so transient mid-rotation KeyStore read errors and TLS handshake errors
      // can be retried once.
      return refreshWithRetry(/* targetImpersonated= */ null);
    }
    return executeRefresh(
        this.transportFactory, /* pinnedKeyStore= */ null, /* targetImpersonated= */ null);
  }

  AccessToken refreshAccessToken(@Nullable HttpTransportFactory cycleTransportFactory)
      throws IOException {
    KeyStore pinnedKeyStore =
        cycleTransportFactory instanceof MtlsHttpTransportFactory
            ? ((MtlsHttpTransportFactory) cycleTransportFactory).getKeyStore()
            : null;
    if (cycleTransportFactory == null
        && pinnedKeyStore == null
        && this.x509Provider != null
        && shouldUseMtlsTransportFactory()) {
      pinnedKeyStore = this.x509Provider.getKeyStore();
    }
    // Retry is intentionally disabled when an explicit cycleTransportFactory is supplied to
    // ensure transport synchronization across multi-step token exchanges (e.g. STS and IAM)
    // and prevent nested retry amplification. Outer callers manage retry coordination.
    HttpTransportFactory effectiveTransportFactory =
        resolveCycleTransportFactory(cycleTransportFactory, pinnedKeyStore);
    return executeRefresh(
        effectiveTransportFactory, pinnedKeyStore, /* targetImpersonated= */ null);
  }

  AccessToken refreshAccessToken(
      @Nullable HttpTransportFactory cycleTransportFactory, @Nullable KeyStore pinnedKeyStore)
      throws IOException {
    if (pinnedKeyStore == null) {
      return refreshAccessToken(cycleTransportFactory);
    }
    HttpTransportFactory effectiveTransportFactory =
        resolveCycleTransportFactory(cycleTransportFactory, pinnedKeyStore);
    return executeRefresh(
        effectiveTransportFactory, pinnedKeyStore, /* targetImpersonated= */ null);
  }

  private AccessToken refreshWithRetry(@Nullable ImpersonatedCredentials targetImpersonated)
      throws IOException {
    ImpersonatedCredentials effectiveImpersonated =
        targetImpersonated != null ? targetImpersonated : getImpersonatedCredentials();
    KeyStore pinnedKeyStore = null;
    try {
      pinnedKeyStore = this.x509Provider.getKeyStore();
      HttpTransportFactory cycleTransportFactory =
          resolveCycleTransportFactory(/* explicitTransportFactory= */ null, pinnedKeyStore);
      return executeRefresh(cycleTransportFactory, pinnedKeyStore, effectiveImpersonated);
    } catch (IOException | RuntimeException e) {
      if (!isMtlsRetryableException(e)) {
        throw e;
      }
      boolean isInitialKeyStoreLoadFailure =
          pinnedKeyStore == null && isRetryableTransportException(e);
      boolean reusedCachedStsTokenOn401 =
          e instanceof ImpersonatedCredentials.CachedStsTokenRejectedException;
      KeyStore freshKeyStore;
      try {
        // On 401, STS invalid_grant (e.g. trust_chain_path rotated ahead of cert_path), TLS
        // handshake/transport failure, or transient initial KeyStore load failure, re-read from
        // X509Provider for fresh certs.
        freshKeyStore = this.x509Provider.getKeyStore();
      } catch (IOException reloadException) {
        if (reloadException != e) {
          reloadException.addSuppressed(e);
        }
        throw reloadException;
      } catch (Exception reloadException) {
        IOException ioException =
            new IOException("Failed to reload certificate on retry", reloadException);
        ioException.addSuppressed(e);
        throw ioException;
      }

      if (!isInitialKeyStoreLoadFailure
          && !reusedCachedStsTokenOn401
          && !OAuth2Utils.hasCertificateChanged(pinnedKeyStore, freshKeyStore)) {
        throw e;
      }

      try {
        HttpTransportFactory retryTransportFactory = createMtlsTransportFactory(freshKeyStore);
        if (!hasInitializedMtlsTransport()) {
          this.transportFactory = retryTransportFactory;
        }
        return executeRefresh(retryTransportFactory, freshKeyStore, effectiveImpersonated);
      } catch (IOException | RuntimeException retryException) {
        if (retryException != e) {
          retryException.addSuppressed(e);
        }
        throw retryException;
      }
    }
  }

  private AccessToken executeRefresh(
      HttpTransportFactory cycleTransportFactory,
      @Nullable KeyStore pinnedKeyStore,
      @Nullable ImpersonatedCredentials targetImpersonated)
      throws IOException {
    ImpersonatedCredentials effectiveImpersonated =
        targetImpersonated != null ? targetImpersonated : getImpersonatedCredentials();
    if (effectiveImpersonated != null) {
      return effectiveImpersonated.refreshAccessToken(
          pinnedKeyStore != null ? cycleTransportFactory : null, pinnedKeyStore);
    }
    FileIdentityPoolSubjectTokenSupplier.TokenPair tokens =
        retrieveSubjectAndActorTokens(pinnedKeyStore);
    return buildAndExchangeStsRequest(tokens.subject, tokens.actor, cycleTransportFactory);
  }

  private HttpTransportFactory resolveCycleTransportFactory(
      @Nullable HttpTransportFactory explicitTransportFactory, @Nullable KeyStore pinnedKeyStore) {
    if (explicitTransportFactory != null) {
      return explicitTransportFactory;
    }
    if (pinnedKeyStore != null && this.x509Provider != null && shouldUseMtlsTransportFactory()) {
      HttpTransportFactory cycleTransportFactory = createMtlsTransportFactory(pinnedKeyStore);
      if (!hasInitializedMtlsTransport()) {
        this.transportFactory = cycleTransportFactory;
      }
      return cycleTransportFactory;
    }
    return this.transportFactory;
  }

  private FileIdentityPoolSubjectTokenSupplier.TokenPair retrieveSubjectAndActorTokens(
      @Nullable KeyStore pinnedKeyStore) throws IOException {
    // Read subject and actor tokens, atomically if from the same file supplier.
    if (this.subjectTokenSupplier instanceof FileIdentityPoolSubjectTokenSupplier
        && this.actorTokenSupplier == this.subjectTokenSupplier) {
      return ((FileIdentityPoolSubjectTokenSupplier) this.subjectTokenSupplier)
          .readTokens(supplierContext);
    }
    String subjectToken;
    if (this.subjectTokenSupplier instanceof CertificateIdentityPoolSubjectTokenSupplier
        && pinnedKeyStore != null) {
      subjectToken =
          ((CertificateIdentityPoolSubjectTokenSupplier) this.subjectTokenSupplier)
              .getSubjectToken(supplierContext, pinnedKeyStore);
    } else {
      subjectToken = retrieveSubjectToken();
    }
    String actorToken =
        this.actorTokenSupplier != null
            ? this.actorTokenSupplier.getActorToken(supplierContext)
            : null;
    return new FileIdentityPoolSubjectTokenSupplier.TokenPair(subjectToken, actorToken);
  }

  private AccessToken buildAndExchangeStsRequest(
      String subjectToken, @Nullable String actorToken, HttpTransportFactory cycleTransportFactory)
      throws IOException {
    StsTokenExchangeRequest.Builder stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder(subjectToken, getSubjectTokenType())
            .setAudience(getAudience());

    if (this.actorTokenSupplier != null) {
      if (actorToken == null || actorToken.trim().isEmpty()) {
        throw new IOException("The provided actor token cannot be null or empty.");
      }
      stsTokenExchangeRequest.setActingParty(
          new ActingParty(actorToken, Objects.requireNonNull(this.actorTokenType)));
    }

    Collection<String> scopes = getScopes();
    if (scopes != null && !scopes.isEmpty()) {
      stsTokenExchangeRequest.setScopes(new ArrayList<>(scopes));
    }

    return exchangeExternalCredentialForAccessToken(
        stsTokenExchangeRequest.build(), cycleTransportFactory);
  }

  @Override
  public String retrieveSubjectToken() throws IOException {
    if (this.subjectTokenSupplier instanceof CertificateIdentityPoolSubjectTokenSupplier
        && this.x509Provider != null
        && shouldUseMtlsTransportFactory()) {
      return ((CertificateIdentityPoolSubjectTokenSupplier) this.subjectTokenSupplier)
          .getSubjectToken(supplierContext, this.x509Provider.getKeyStore());
    }
    return this.subjectTokenSupplier.getSubjectToken(supplierContext);
  }

  @Override
  String getCredentialSourceType() {
    return this.metricsHeaderValue;
  }

  @VisibleForTesting
  IdentityPoolSubjectTokenSupplier getIdentityPoolSubjectTokenSupplier() {
    return this.subjectTokenSupplier;
  }

  @VisibleForTesting
  @Nullable IdentityPoolActorTokenSupplier getIdentityPoolActorTokenSupplier() {
    return this.actorTokenSupplier;
  }

  @VisibleForTesting
  @Nullable String getActorTokenType() {
    return this.actorTokenType;
  }

  @VisibleForTesting
  HttpTransportFactory getTransportFactory() {
    return this.transportFactory;
  }

  @VisibleForTesting
  @Nullable X509Provider getX509Provider() {
    return this.x509Provider;
  }

  @VisibleForTesting
  HttpTransportFactory createMtlsTransportFactory(KeyStore keyStore) {
    return new MtlsHttpTransportFactory(keyStore);
  }

  /** Clones the IdentityPoolCredentials with the specified scopes. */
  @Override
  public IdentityPoolCredentials createScoped(Collection<String> newScopes) {
    return new IdentityPoolCredentials(newBuilder(this).setScopes(newScopes));
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newBuilder(IdentityPoolCredentials identityPoolCredentials) {
    return new Builder(identityPoolCredentials);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  private void initializeMtlsTransport(
      Builder builder, IdentityPoolCredentialSource credentialSource) throws IOException {
    X509Provider x509Provider = getX509Provider(builder, credentialSource);
    this.x509Provider = x509Provider;
    if (builder.isClonedTransportInitialized) {
      return;
    }
    KeyStore mtlsKeyStore = x509Provider.getKeyStore();
    if (shouldUseMtlsTransportFactory()) {
      this.transportFactory = createMtlsTransportFactory(mtlsKeyStore);
    } else if (!(builder.transportFactory instanceof MtlsHttpTransportFactory)) {
      LOGGER_PROVIDER
          .getLogger()
          .debug(
              "Custom HttpTransportFactory provided with certificate configuration; skipping"
                  + " automatic MtlsHttpTransportFactory upgrade. Ensure the custom transport"
                  + " factory is configured for mTLS if required by the token endpoint.");
    }
  }

  private IdentityPoolSubjectTokenSupplier createCertificateSubjectTokenSupplier(
      Builder builder, IdentityPoolCredentialSource credentialSource) throws IOException {
    // Configure the mTLS transport with the x509 keystore if custom transport was not provided.
    initializeMtlsTransport(builder, credentialSource);

    // Initialize the subject token supplier with the certificate path if not already set.
    if (credentialSource.getCredentialLocation() == null) {
      String explicitCertConfigPath = getExplicitCertConfigPath(credentialSource);
      credentialSource.setCredentialLocation(
          MtlsUtils.getCertificatePath(
              getEnvironmentProvider(), getPropertyProvider(), explicitCertConfigPath));
    }
    return new CertificateIdentityPoolSubjectTokenSupplier(credentialSource);
  }

  /**
   * Reconstitutes the {@link IdentityPoolCredentials} instance from a stream.
   *
   * <p>For credential-source based credentials (file or certificate), this method reconstructs the
   * transient {@link X509Provider} and mTLS {@link HttpTransportFactory} if a certificate
   * configuration is present. For programmatic suppliers (where {@code subjectTokenSupplier !=
   * null} and {@code credentialSource == null}), the suppliers and standard transport are restored
   * directly from the serialized stream, while in-memory {@link X509Provider} instances are
   * non-persistent.
   */
  @SuppressWarnings("unused")
  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    IdentityPoolCredentialSource credentialSource =
        (IdentityPoolCredentialSource) getCredentialSource();
    if (credentialSource != null
        && (credentialSource.getCertificateConfig() != null
            || credentialSource.credentialSourceType
                == IdentityPoolCredentialSourceType.CERTIFICATE)) {
      String explicitCertConfigPath = getExplicitCertConfigPath(credentialSource);
      this.x509Provider =
          new X509Provider(getEnvironmentProvider(), getPropertyProvider(), explicitCertConfigPath);
      if (shouldUseMtlsTransportFactory()) {
        try {
          KeyStore mtlsKeyStore = this.x509Provider.getKeyStore();
          this.transportFactory = createMtlsTransportFactory(mtlsKeyStore);
        } catch (Exception e) {
          // Cert loading failure will be handled on refreshAccessToken()
        }
      }
    }
  }

  private X509Provider getX509Provider(
      Builder builder, IdentityPoolCredentialSource credentialSource) {
    // Use the provided X509Provider if available, otherwise initialize a default one.
    X509Provider x509Provider = builder.x509Provider;
    if (x509Provider == null) {
      // Determine the certificate path based on the configuration.
      String explicitCertConfigPath = getExplicitCertConfigPath(credentialSource);
      x509Provider =
          new X509Provider(getEnvironmentProvider(), getPropertyProvider(), explicitCertConfigPath);
    }
    return x509Provider;
  }

  private static @Nullable String getExplicitCertConfigPath(
      IdentityPoolCredentialSource credentialSource) {
    IdentityPoolCredentialSource.CertificateConfig certConfig =
        credentialSource.getCertificateConfig();
    if (certConfig == null) {
      return null;
    }
    return certConfig.useDefaultCertificateConfig()
        ? null
        : certConfig.getCertificateConfigLocation();
  }

  public static class Builder extends ExternalAccountCredentials.Builder {

    private @Nullable IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
    private @Nullable IdentityPoolActorTokenSupplier actorTokenSupplier;
    private @Nullable String actorTokenType;
    private @Nullable X509Provider x509Provider;
    private boolean useMtlsTransportFactory = true;
    private boolean isClonedTransportInitialized;

    Builder() {}

    Builder(IdentityPoolCredentials credentials) {
      super(credentials);
      if (this.credentialSource == null) {
        this.subjectTokenSupplier = credentials.subjectTokenSupplier;
        this.actorTokenSupplier = credentials.actorTokenSupplier;
      } else if (credentials.actorTokenSupplier != credentials.subjectTokenSupplier) {
        this.actorTokenSupplier = credentials.actorTokenSupplier;
      }
      // Note: when credentialSource is present and actorTokenSupplier was reconstructed from the
      // same FileIdentityPoolSubjectTokenSupplier instance as subjectTokenSupplier, neither is
      // copied here so they can be reconstructed together during build() for atomic token reads.
      // When a distinct actorTokenSupplier was explicitly provided alongside credentialSource, it
      // is preserved above so createScoped() / toBuilder() do not drop it.
      this.actorTokenType = credentials.actorTokenType;
      this.x509Provider = credentials.x509Provider;
      // Preserve the original mTLS flag across clones because super(credentials) copies
      // credentials.transportFactory, which may already be resolved via ServiceLoader or
      // createMtlsTransportFactory rather than null.
      this.useMtlsTransportFactory = credentials.useMtlsTransportFactory;
      this.isClonedTransportInitialized = credentials.hasInitializedMtlsTransport();
    }

    /**
     * Sets a custom {@link X509Provider} to manage the client certificate and private key for mTLS.
     * If set, this provider will be used instead of the default behavior which initializes an
     * {@code X509Provider} based on the {@code certificateConfigLocation} or default paths found in
     * the {@code credentialSource}. This is primarily used for testing.
     *
     * @param x509Provider the custom X509 provider to use.
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    @VisibleForTesting
    Builder setX509Provider(X509Provider x509Provider) {
      this.x509Provider = x509Provider;
      this.isClonedTransportInitialized = false;
      return this;
    }

    /**
     * Sets the subject token supplier. The supplier should return a valid subject token string.
     *
     * @param subjectTokenSupplier the supplier to use.
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setSubjectTokenSupplier(IdentityPoolSubjectTokenSupplier subjectTokenSupplier) {
      this.subjectTokenSupplier = subjectTokenSupplier;
      return this;
    }

    /**
     * Sets the actor token supplier used for OAuth 2.0 token exchanges. The supplier provides an
     * actor token representing the acting party that acts on behalf of the subject.
     *
     * <p>An actor token supplier must be paired with an {@link #setActorTokenType actor token
     * type}.
     *
     * @param actorTokenSupplier the supplier to use for retrieving actor tokens
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    Builder setActorTokenSupplier(IdentityPoolActorTokenSupplier actorTokenSupplier) {
      this.actorTokenSupplier = actorTokenSupplier;
      return this;
    }

    /**
     * Sets the actor token type for the STS token exchange request. This specifies the type of the
     * actor token provided by the {@link #setActorTokenSupplier actor token supplier}, such as
     * {@code "urn:ietf:params:oauth:token-type:jwt"}.
     *
     * <p>An actor token type must be paired with an {@link #setActorTokenSupplier actor token
     * supplier}.
     *
     * @param actorTokenType the token type URI for the actor token
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    Builder setActorTokenType(String actorTokenType) {
      this.actorTokenType = actorTokenType;
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      super.setHttpTransportFactory(transportFactory);
      this.useMtlsTransportFactory = OAuth2Utils.isDefaultOrMtlsTransportFactory(transportFactory);
      this.isClonedTransportInitialized = false;
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setAudience(String audience) {
      super.setAudience(audience);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(String subjectTokenType) {
      super.setSubjectTokenType(subjectTokenType);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(SubjectTokenTypes subjectTokenType) {
      super.setSubjectTokenType(subjectTokenType);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setTokenUrl(String tokenUrl) {
      super.setTokenUrl(tokenUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setCredentialSource(IdentityPoolCredentialSource credentialSource) {
      if (this.credentialSource != null && this.credentialSource != credentialSource) {
        this.x509Provider = null;
        if (this.useMtlsTransportFactory) {
          this.transportFactory = null;
        }
      }
      super.setCredentialSource(credentialSource);
      this.isClonedTransportInitialized = false;
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationUrl(
        @Nullable String serviceAccountImpersonationUrl) {
      super.setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setTokenInfoUrl(String tokenInfoUrl) {
      super.setTokenInfoUrl(tokenInfoUrl);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(@Nullable String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      super.setClientId(clientId);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setClientSecret(String clientSecret) {
      super.setClientSecret(clientSecret);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setScopes(Collection<String> scopes) {
      super.setScopes(scopes);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setWorkforcePoolUserProject(String workforcePoolUserProject) {
      super.setWorkforcePoolUserProject(workforcePoolUserProject);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationOptions(Map<String, Object> optionsMap) {
      super.setServiceAccountImpersonationOptions(optionsMap);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    public Builder setUniverseDomain(String universeDomain) {
      super.setUniverseDomain(universeDomain);
      return this;
    }

    @Override
    @CanIgnoreReturnValue
    Builder setEnvironmentProvider(EnvironmentProvider environmentProvider) {
      super.setEnvironmentProvider(environmentProvider);
      return this;
    }

    @Override
    public IdentityPoolCredentials build() {
      return new IdentityPoolCredentials(this);
    }
  }
}
