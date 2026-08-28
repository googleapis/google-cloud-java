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

import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.auth.mtls.MtlsUtils;
import com.google.auth.mtls.X509Provider;
import com.google.auth.oauth2.IdentityPoolCredentialSource.IdentityPoolCredentialSourceType;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Url-sourced, file-sourced, or user provided supplier method-sourced external account credentials.
 *
 * <p>By default, attempts to exchange the external credential for a GCP access token.
 *
 * <p>Note: Actor token extraction is currently restricted to file-based JSON credential sources
 * over mTLS endpoints. When configuring certificate-bound OAuth 2.0 tokens, ensure your transport
 * layer is configured for mTLS in tandem.
 */
@NullMarked
public class IdentityPoolCredentials extends ExternalAccountCredentials {

  static final String FILE_METRICS_HEADER_VALUE = "file";
  static final String URL_METRICS_HEADER_VALUE = "url";
  static final String CERTIFICATE_METRICS_HEADER_VALUE = "certificate";

  private static final long serialVersionUID = 2471046175477275881L;
  private final IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
  @Nullable private final IdentityPoolActorTokenSupplier actorTokenSupplier;
  @Nullable private final String actorTokenType;
  // Transient: not serialized directly. Reconstructed in readObject() from the credentialSource
  // certificate config so deserialized credentials remain usable for mTLS and refresh.
  @Nullable private transient X509Provider x509Provider;
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

    // Store the x509Provider for per-cycle cert pinning.
    this.x509Provider = builder.x509Provider;

    // Initialize based on the source type
    if (builder.subjectTokenSupplier != null) {
      this.subjectTokenSupplier = builder.subjectTokenSupplier;
      this.metricsHeaderValue = PROGRAMMATIC_METRICS_HEADER_VALUE;
    } else if (credentialSource.credentialSourceType == IdentityPoolCredentialSourceType.FILE) {
      if (credentialSource.getCertificateConfig() != null) {
        try {
          X509Provider x509Provider = getX509Provider(builder, credentialSource);
          this.x509Provider = x509Provider;
          KeyStore mtlsKeyStore = x509Provider.getKeyStore();
          if (builder.transportFactory == null
              || builder.transportFactory == OAuth2Utils.HTTP_TRANSPORT_FACTORY
              || builder.transportFactory instanceof OAuth2Utils.DefaultHttpTransportFactory) {
            this.transportFactory = new MtlsHttpTransportFactory(mtlsKeyStore);
          }
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

    if (this.actorTokenSupplier != null && !isMtlsConfigured()) {
      throw new IllegalArgumentException(
          "Actor tokens are only supported for mTLS token exchanges. Please configure a certificate"
              + " source or MtlsHttpTransportFactory.");
    }

    if (this.actorTokenSupplier != null) {
      validateMtlsEndpoint(getTokenUrl(), "tokenUrl");
      if (getServiceAccountImpersonationUrl() != null) {
        validateMtlsEndpoint(getServiceAccountImpersonationUrl(), "serviceAccountImpersonationUrl");
      }
    }
  }

  private static void validateMtlsEndpoint(@Nullable String url, String fieldName) {
    if (url == null) {
      return;
    }
    try {
      URI uri = URI.create(url);
      String host = uri.getHost();
      if (host != null && host.endsWith("googleapis.com") && !host.contains(".mtls.")) {
        throw new IllegalArgumentException(
            "The "
                + fieldName
                + " endpoint ("
                + url
                + ") must be an mTLS endpoint (e.g. contain '.mtls.') when an actor token is"
                + " configured.");
      }
    } catch (IllegalArgumentException e) {
      throw e;
    } catch (Exception e) {
      if (url.contains("googleapis.com") && !url.contains(".mtls.")) {
        throw new IllegalArgumentException(
            "The "
                + fieldName
                + " endpoint ("
                + url
                + ") must be an mTLS endpoint (e.g. contain '.mtls.') when an actor token is"
                + " configured.");
      }
    }
  }

  /**
   * Checks whether mTLS is properly configured by verifying that an X509Provider is set or the
   * transport factory is an MtlsHttpTransportFactory with a non-null KeyStore. This avoids false
   * positives from a no-arg-constructed MtlsHttpTransportFactory (e.g. after deserialization) that
   * has no actual certificates.
   */
  private boolean isMtlsConfigured() {
    return this.x509Provider != null
        || (this.transportFactory instanceof MtlsHttpTransportFactory
            && ((MtlsHttpTransportFactory) this.transportFactory).hasKeyStore());
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    // Per-cycle cert pinning: snapshot the KeyStore at the start of each refresh cycle.
    HttpTransportFactory cycleTransportFactory = this.transportFactory;
    if (this.x509Provider != null) {
      KeyStore pinnedKeyStore = this.x509Provider.getKeyStore();
      cycleTransportFactory = new MtlsHttpTransportFactory(pinnedKeyStore);
    }

    // Read subject and actor tokens, atomically if from the same file supplier.
    String subjectToken;
    String actorToken = null;
    if (this.subjectTokenSupplier instanceof FileIdentityPoolSubjectTokenSupplier
        && this.actorTokenSupplier == this.subjectTokenSupplier) {
      FileIdentityPoolSubjectTokenSupplier.TokenPair tokens =
          ((FileIdentityPoolSubjectTokenSupplier) this.subjectTokenSupplier)
              .readTokens(supplierContext);
      subjectToken = tokens.subject;
      actorToken = tokens.actor;
    } else {
      subjectToken = retrieveSubjectToken();
      if (this.actorTokenSupplier != null) {
        actorToken = this.actorTokenSupplier.getActorToken(supplierContext);
      }
    }

    StsTokenExchangeRequest.Builder stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder(subjectToken, getSubjectTokenType())
            .setAudience(getAudience());

    if (actorToken != null && this.actorTokenType != null) {
      stsTokenExchangeRequest.setActingParty(new ActingParty(actorToken, this.actorTokenType));
    }

    Collection<String> scopes = getScopes();
    if (scopes != null && !scopes.isEmpty()) {
      stsTokenExchangeRequest.setScopes(new ArrayList<>(scopes));
    }

    try {
      return exchangeExternalCredentialForAccessToken(
          stsTokenExchangeRequest.build(), cycleTransportFactory);
    } catch (OAuthException e) {
      if (e.getHttpStatusCode() == 401 && this.x509Provider != null) {
        try {
          // On 401, re-read from X509Provider for fresh certs and retry once.
          KeyStore freshKeyStore = this.x509Provider.getKeyStore();
          HttpTransportFactory retryTransportFactory = new MtlsHttpTransportFactory(freshKeyStore);
          return exchangeExternalCredentialForAccessToken(
              stsTokenExchangeRequest.build(), retryTransportFactory);
        } catch (IOException retryException) {
          retryException.addSuppressed(e);
          throw retryException;
        }
      }
      throw e;
    }
  }

  @Override
  public String retrieveSubjectToken() throws IOException {
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
  String getActorTokenType() {
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

  private IdentityPoolSubjectTokenSupplier createCertificateSubjectTokenSupplier(
      Builder builder, IdentityPoolCredentialSource credentialSource) throws IOException {
    // Configure the mTLS transport with the x509 keystore if custom transport was not provided.
    X509Provider x509Provider = getX509Provider(builder, credentialSource);
    this.x509Provider = x509Provider;
    KeyStore mtlsKeyStore = x509Provider.getKeyStore();
    if (builder.transportFactory == null
        || builder.transportFactory == OAuth2Utils.HTTP_TRANSPORT_FACTORY
        || builder.transportFactory instanceof OAuth2Utils.DefaultHttpTransportFactory) {
      this.transportFactory = new MtlsHttpTransportFactory(mtlsKeyStore);
    }

    // Initialize the subject token supplier with the certificate path.
    String explicitCertConfigPath = getExplicitCertConfigPath(credentialSource);
    credentialSource.setCredentialLocation(
        MtlsUtils.getCertificatePath(
            getEnvironmentProvider(), getPropertyProvider(), explicitCertConfigPath));
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
      try {
        KeyStore mtlsKeyStore = this.x509Provider.getKeyStore();
        this.transportFactory = new MtlsHttpTransportFactory(mtlsKeyStore);
      } catch (Exception e) {
        // Cert loading failure will be handled on refreshAccessToken()
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

    private IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
    private IdentityPoolActorTokenSupplier actorTokenSupplier;
    private String actorTokenType;
    private X509Provider x509Provider;

    Builder() {}

    Builder(IdentityPoolCredentials credentials) {
      super(credentials);
      if (this.credentialSource == null) {
        this.subjectTokenSupplier = credentials.subjectTokenSupplier;
        this.actorTokenSupplier = credentials.actorTokenSupplier;
      }
      // Note: when credentialSource is present, subjectTokenSupplier and actorTokenSupplier
      // are intentionally NOT copied here. They will be reconstructed from credentialSource
      // during build(), which ensures they share the same FileIdentityPoolSubjectTokenSupplier
      // instance for atomic token reads.
      this.actorTokenType = credentials.actorTokenType;
      this.x509Provider = credentials.x509Provider;
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
     * Sets the actor token supplier used for certificate-bound OAuth 2.0 token exchanges. The
     * supplier provides an actor token representing the entity on whose behalf the subject is
     * acting.
     *
     * <p>An actor token supplier must be paired with an {@link #setActorTokenType actor token type}
     * and requires an mTLS-configured transport.
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

    @CanIgnoreReturnValue
    public Builder setHttpTransportFactory(HttpTransportFactory transportFactory) {
      super.setHttpTransportFactory(transportFactory);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setAudience(String audience) {
      super.setAudience(audience);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(String subjectTokenType) {
      super.setSubjectTokenType(subjectTokenType);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setSubjectTokenType(SubjectTokenTypes subjectTokenType) {
      super.setSubjectTokenType(subjectTokenType);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setTokenUrl(String tokenUrl) {
      super.setTokenUrl(tokenUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setCredentialSource(IdentityPoolCredentialSource credentialSource) {
      super.setCredentialSource(credentialSource);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationUrl(String serviceAccountImpersonationUrl) {
      super.setServiceAccountImpersonationUrl(serviceAccountImpersonationUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setTokenInfoUrl(String tokenInfoUrl) {
      super.setTokenInfoUrl(tokenInfoUrl);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setQuotaProjectId(String quotaProjectId) {
      super.setQuotaProjectId(quotaProjectId);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setClientId(String clientId) {
      super.setClientId(clientId);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setClientSecret(String clientSecret) {
      super.setClientSecret(clientSecret);
      return this;
    }

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

    @CanIgnoreReturnValue
    public Builder setServiceAccountImpersonationOptions(Map<String, Object> optionsMap) {
      super.setServiceAccountImpersonationOptions(optionsMap);
      return this;
    }

    @CanIgnoreReturnValue
    public Builder setUniverseDomain(String universeDomain) {
      super.setUniverseDomain(universeDomain);
      return this;
    }

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
