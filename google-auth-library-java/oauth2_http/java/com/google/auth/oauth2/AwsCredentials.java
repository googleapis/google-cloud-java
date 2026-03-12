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

import com.google.api.client.json.GenericJson;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Credentials representing an AWS third-party identity for calling Google APIs. AWS security
 * credentials are either sourced by calling EC2 metadata endpoints, environment variables, or a
 * user provided supplier method.
 *
 * <p>By default, attempts to exchange the external credential for a GCP access token.
 */
public class AwsCredentials extends ExternalAccountCredentials {

  static final String DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL =
      "https://sts.{region}.amazonaws.com?Action=GetCallerIdentity&Version=2011-06-15";

  static final String AWS_METRICS_HEADER_VALUE = "aws";

  private static final long serialVersionUID = -3670131891574618105L;

  private final AwsSecurityCredentialsSupplier awsSecurityCredentialsSupplier;
  private final ExternalAccountSupplierContext supplierContext;
  // Regional credential verification url override. This needs to be its own value so we can
  // correctly pass it to a builder.
  @Nullable private final String regionalCredentialVerificationUrlOverride;
  @Nullable private final String regionalCredentialVerificationUrl;
  private final String metricsHeaderValue;

  /** Internal constructor. See {@link AwsCredentials.Builder}. */
  AwsCredentials(Builder builder) {
    super(builder);
    this.supplierContext =
        ExternalAccountSupplierContext.newBuilder()
            .setAudience(this.getAudience())
            .setSubjectTokenType(this.getSubjectTokenType())
            .build();

    // Check that one and only one of supplier or credential source are provided.
    if (builder.awsSecurityCredentialsSupplier != null && builder.credentialSource != null) {
      throw new IllegalArgumentException(
          "AwsCredentials cannot have both an awsSecurityCredentialsSupplier and a credentialSource.");
    }
    if (builder.awsSecurityCredentialsSupplier == null && builder.credentialSource == null) {
      throw new IllegalArgumentException(
          "An awsSecurityCredentialsSupplier or a credentialSource must be provided.");
    }

    AwsCredentialSource credentialSource = (AwsCredentialSource) builder.credentialSource;
    // Set regional credential verification url override if provided.
    this.regionalCredentialVerificationUrlOverride =
        builder.regionalCredentialVerificationUrlOverride;

    // Set regional credential verification url depending on inputs.
    if (this.regionalCredentialVerificationUrlOverride != null) {
      this.regionalCredentialVerificationUrl = this.regionalCredentialVerificationUrlOverride;
    } else if (credentialSource != null) {
      this.regionalCredentialVerificationUrl = credentialSource.regionalCredentialVerificationUrl;
    } else {
      this.regionalCredentialVerificationUrl = DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL;
    }

    // If user has provided a security credential supplier, use that to retrieve the AWS security
    // credentials.
    if (builder.awsSecurityCredentialsSupplier != null) {
      this.awsSecurityCredentialsSupplier = builder.awsSecurityCredentialsSupplier;
      this.metricsHeaderValue = PROGRAMMATIC_METRICS_HEADER_VALUE;
    } else {
      this.awsSecurityCredentialsSupplier =
          new InternalAwsSecurityCredentialsSupplier(
              credentialSource, this.getEnvironmentProvider(), this.transportFactory);
      this.metricsHeaderValue = AWS_METRICS_HEADER_VALUE;
    }
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    StsTokenExchangeRequest.Builder stsTokenExchangeRequest =
        StsTokenExchangeRequest.newBuilder(retrieveSubjectToken(), getSubjectTokenType())
            .setAudience(getAudience());

    // Add scopes, if possible.
    Collection<String> scopes = getScopes();
    if (scopes != null && !scopes.isEmpty()) {
      stsTokenExchangeRequest.setScopes(new ArrayList<>(scopes));
    }

    return exchangeExternalCredentialForAccessToken(stsTokenExchangeRequest.build());
  }

  @Override
  public String retrieveSubjectToken() throws IOException {

    // The targeted region is required to generate the signed request. The regional
    // endpoint must also be used.
    String region = awsSecurityCredentialsSupplier.getRegion(supplierContext);

    AwsSecurityCredentials credentials =
        awsSecurityCredentialsSupplier.getCredentials(supplierContext);

    // Generate the signed request to the AWS STS GetCallerIdentity API.
    Map<String, String> headers = new HashMap<>();
    headers.put("x-goog-cloud-target-resource", getAudience());

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(
                credentials,
                "POST",
                this.regionalCredentialVerificationUrl.replace("{region}", region),
                region)
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature awsRequestSignature = signer.sign();
    return buildSubjectToken(awsRequestSignature);
  }

  /** Clones the AwsCredentials with the specified scopes. */
  @Override
  public GoogleCredentials createScoped(Collection<String> newScopes) {
    return new AwsCredentials((AwsCredentials.Builder) newBuilder(this).setScopes(newScopes));
  }

  @Override
  String getCredentialSourceType() {
    return this.metricsHeaderValue;
  }

  private String buildSubjectToken(AwsRequestSignature signature)
      throws UnsupportedEncodingException {
    Map<String, String> canonicalHeaders = signature.getCanonicalHeaders();
    List<GenericJson> headerList = new ArrayList<>();
    for (String headerName : canonicalHeaders.keySet()) {
      headerList.add(formatTokenHeaderForSts(headerName, canonicalHeaders.get(headerName)));
    }

    headerList.add(formatTokenHeaderForSts("Authorization", signature.getAuthorizationHeader()));

    // The canonical resource name of the workload identity pool provider.
    headerList.add(formatTokenHeaderForSts("x-goog-cloud-target-resource", getAudience()));

    GenericJson token = new GenericJson();
    token.setFactory(OAuth2Utils.JSON_FACTORY);

    token.put("headers", headerList);
    token.put("method", signature.getHttpMethod());
    token.put(
        "url", this.regionalCredentialVerificationUrl.replace("{region}", signature.getRegion()));
    return URLEncoder.encode(token.toString(), "UTF-8");
  }

  @VisibleForTesting
  String getRegionalCredentialVerificationUrl() {
    return this.regionalCredentialVerificationUrl;
  }

  @VisibleForTesting
  String getEnv(String name) {
    return System.getenv(name);
  }

  @VisibleForTesting
  AwsSecurityCredentialsSupplier getAwsSecurityCredentialsSupplier() {
    return this.awsSecurityCredentialsSupplier;
  }

  @Nullable
  public String getRegionalCredentialVerificationUrlOverride() {
    return this.regionalCredentialVerificationUrlOverride;
  }

  private static GenericJson formatTokenHeaderForSts(String key, String value) {
    // The GCP STS endpoint expects the headers to be formatted as:
    // [
    //  {key: 'x-amz-date', value: '...'},
    //  {key: 'Authorization', value: '...'},
    //  ...
    // ]
    GenericJson header = new GenericJson();
    header.setFactory(OAuth2Utils.JSON_FACTORY);
    header.put("key", key);
    header.put("value", value);
    return header;
  }

  public static AwsCredentials.Builder newBuilder() {
    return new AwsCredentials.Builder();
  }

  public static AwsCredentials.Builder newBuilder(AwsCredentials awsCredentials) {
    return new AwsCredentials.Builder(awsCredentials);
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder extends ExternalAccountCredentials.Builder {

    private AwsSecurityCredentialsSupplier awsSecurityCredentialsSupplier;

    private String regionalCredentialVerificationUrlOverride;

    Builder() {}

    Builder(AwsCredentials credentials) {
      super(credentials);
      if (this.credentialSource == null) {
        this.awsSecurityCredentialsSupplier = credentials.awsSecurityCredentialsSupplier;
      }
      this.regionalCredentialVerificationUrlOverride =
          credentials.regionalCredentialVerificationUrlOverride;
    }

    /**
     * Sets the AWS security credentials supplier. The supplier should return a valid {@code
     * AwsSecurityCredentials} object and a valid AWS region.
     *
     * @param awsSecurityCredentialsSupplier the supplier to use.
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setAwsSecurityCredentialsSupplier(
        AwsSecurityCredentialsSupplier awsSecurityCredentialsSupplier) {
      this.awsSecurityCredentialsSupplier = awsSecurityCredentialsSupplier;
      return this;
    }

    /**
     * Sets the AWS regional credential verification URL. If set, will override any credential
     * verification URL provided in the credential source. If not set, the credential verification
     * URL will default to
     * `https://sts.{region}.amazonaws.com?Action=GetCallerIdentity&amp;Version=2011-06-15`
     *
     * @param regionalCredentialVerificationUrlOverride the AWS credential verification url to set.
     * @return this {@code Builder} object
     */
    @CanIgnoreReturnValue
    public Builder setRegionalCredentialVerificationUrlOverride(
        String regionalCredentialVerificationUrlOverride) {
      this.regionalCredentialVerificationUrlOverride = regionalCredentialVerificationUrlOverride;
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
    public Builder setCredentialSource(AwsCredentialSource credentialSource) {
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
    public AwsCredentials build() {
      return new AwsCredentials(this);
    }
  }
}
