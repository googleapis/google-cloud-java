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

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores the AWS API request signature based on the AWS Signature Version 4 signing process, and
 * the parameters used in the signing process.
 */
class AwsRequestSignature {

  private AwsSecurityCredentials awsSecurityCredentials;
  private Map<String, String> canonicalHeaders;

  private String signature;
  private String credentialScope;
  private String url;
  private String httpMethod;
  private String date;
  private String region;
  private String authorizationHeader;

  private AwsRequestSignature(
      AwsSecurityCredentials awsSecurityCredentials,
      Map<String, String> canonicalHeaders,
      String signature,
      String credentialScope,
      String url,
      String httpMethod,
      String date,
      String region,
      String authorizationHeader) {
    this.awsSecurityCredentials = awsSecurityCredentials;
    this.canonicalHeaders = canonicalHeaders;
    this.signature = signature;
    this.credentialScope = credentialScope;
    this.url = url;
    this.httpMethod = httpMethod;
    this.date = date;
    this.region = region;
    this.authorizationHeader = authorizationHeader;
  }

  /** Returns the request signature based on the AWS Signature Version 4 signing process. */
  String getSignature() {
    return signature;
  }

  /** Returns the credential scope. e.g. 20150830/us-east-1/iam/aws4_request */
  String getCredentialScope() {
    return credentialScope;
  }

  /** Returns the AWS security credentials. */
  AwsSecurityCredentials getSecurityCredentials() {
    return awsSecurityCredentials;
  }

  /** Returns the request URL. */
  String getUrl() {
    return url;
  }

  /** Returns the HTTP request method. */
  String getHttpMethod() {
    return httpMethod;
  }

  /** Returns the HTTP request canonical headers. */
  Map<String, String> getCanonicalHeaders() {
    return new HashMap<>(canonicalHeaders);
  }

  /** Returns the request date. */
  String getDate() {
    return date;
  }

  /** Returns the targeted region. */
  String getRegion() {
    return region;
  }

  /** Returns the authorization header. */
  String getAuthorizationHeader() {
    return authorizationHeader;
  }

  static class Builder {

    private AwsSecurityCredentials awsSecurityCredentials;
    private Map<String, String> canonicalHeaders;

    private String signature;
    private String credentialScope;
    private String url;
    private String httpMethod;
    private String date;
    private String region;
    private String authorizationHeader;

    @CanIgnoreReturnValue
    Builder setSignature(String signature) {
      this.signature = signature;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setCredentialScope(String credentialScope) {
      this.credentialScope = credentialScope;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setSecurityCredentials(AwsSecurityCredentials awsSecurityCredentials) {
      this.awsSecurityCredentials = awsSecurityCredentials;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setHttpMethod(String httpMethod) {
      this.httpMethod = httpMethod;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setCanonicalHeaders(Map<String, String> canonicalHeaders) {
      this.canonicalHeaders = new HashMap<>(canonicalHeaders);
      return this;
    }

    @CanIgnoreReturnValue
    Builder setDate(String date) {
      this.date = date;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setAuthorizationHeader(String authorizationHeader) {
      this.authorizationHeader = authorizationHeader;
      return this;
    }

    AwsRequestSignature build() {
      return new AwsRequestSignature(
          awsSecurityCredentials,
          canonicalHeaders,
          signature,
          credentialScope,
          url,
          httpMethod,
          date,
          region,
          authorizationHeader);
    }
  }
}
