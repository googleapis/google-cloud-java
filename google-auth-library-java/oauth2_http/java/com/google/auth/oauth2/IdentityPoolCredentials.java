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
import com.google.auth.mtls.X509Provider;
import com.google.auth.oauth2.IdentityPoolCredentialSource.IdentityPoolCredentialSourceType;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Url-sourced, file-sourced, or user provided supplier method-sourced external account credentials.
 *
 * <p>By default, attempts to exchange the external credential for a GCP access token.
 */
public class IdentityPoolCredentials extends ExternalAccountCredentials {

  static final String FILE_METRICS_HEADER_VALUE = "file";
  static final String URL_METRICS_HEADER_VALUE = "url";
  static final String CERTIFICATE_METRICS_HEADER_VALUE = "certificate";

  private static final long serialVersionUID = 2471046175477275881L;
  private final IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
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
          "IdentityPoolCredentials cannot have both a subjectTokenSupplier and a credentialSource.");
    }
    if (builder.subjectTokenSupplier == null && credentialSource == null) {
      throw new IllegalArgumentException(
          "A subjectTokenSupplier or a credentialSource must be provided.");
    }

    // Initialize based on the source type
    if (builder.subjectTokenSupplier != null) {
      this.subjectTokenSupplier = builder.subjectTokenSupplier;
      this.metricsHeaderValue = PROGRAMMATIC_METRICS_HEADER_VALUE;
    } else if (credentialSource.credentialSourceType == IdentityPoolCredentialSourceType.FILE) {
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
            "Failed to initialize IdentityPoolCredentials from certificate source due to an I/O error.",
            e);
      }
      this.metricsHeaderValue = CERTIFICATE_METRICS_HEADER_VALUE;
    } else {
      throw new IllegalArgumentException("Source type not supported.");
    }
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    String credential = retrieveSubjectToken();
    StsTokenExchangeRequest.Builder stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder(credential, getSubjectTokenType())
            .setAudience(getAudience());

    Collection<String> scopes = getScopes();
    if (scopes != null && !scopes.isEmpty()) {
      stsTokenExchangeRequest.setScopes(new ArrayList<>(scopes));
    }

    return exchangeExternalCredentialForAccessToken(stsTokenExchangeRequest.build());
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
    // Configure the mTLS transport with the x509 keystore.
    X509Provider x509Provider = getX509Provider(builder, credentialSource);
    KeyStore mtlsKeyStore = x509Provider.getKeyStore();
    this.transportFactory = new MtlsHttpTransportFactory(mtlsKeyStore);

    // Initialize the subject token supplier with the certificate path.
    credentialSource.setCredentialLocation(x509Provider.getCertificatePath());
    return new CertificateIdentityPoolSubjectTokenSupplier(credentialSource);
  }

  private X509Provider getX509Provider(
      Builder builder, IdentityPoolCredentialSource credentialSource) {
    final IdentityPoolCredentialSource.CertificateConfig certConfig =
        credentialSource.getCertificateConfig();

    // Use the provided X509Provider if available, otherwise initialize a default one.
    X509Provider x509Provider = builder.x509Provider;
    if (x509Provider == null) {
      // Determine the certificate path based on the configuration.
      String explicitCertConfigPath =
          certConfig.useDefaultCertificateConfig()
              ? null
              : certConfig.getCertificateConfigLocation();
      x509Provider = new X509Provider(explicitCertConfigPath);
    }
    return x509Provider;
  }

  public static class Builder extends ExternalAccountCredentials.Builder {

    private IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
    private X509Provider x509Provider;

    Builder() {}

    Builder(IdentityPoolCredentials credentials) {
      super(credentials);
      if (this.credentialSource == null) {
        this.subjectTokenSupplier = credentials.subjectTokenSupplier;
      }
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
