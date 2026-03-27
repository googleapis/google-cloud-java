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
import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.BaseEncoding;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Internal utility that signs AWS API requests based on the AWS Signature Version 4 signing
 * process.
 *
 * @see <a href="https://docs.aws.amazon.com/general/latest/gr/signature-version-4.html">AWS
 *     Signature V4</a>
 */
class AwsRequestSigner {

  // AWS Signature Version 4 signing algorithm identifier.
  private static final String HASHING_ALGORITHM = "AWS4-HMAC-SHA256";

  // The termination string for the AWS credential scope value as defined in
  // https://docs.aws.amazon.com/general/latest/gr/sigv4-create-string-to-sign.html
  private static final String AWS_REQUEST_TYPE = "aws4_request";

  private final AwsSecurityCredentials awsSecurityCredentials;
  private final Map<String, String> additionalHeaders;
  private final String httpMethod;
  private final String region;
  private final String requestPayload;
  private final URI uri;
  private final AwsDates dates;

  /**
   * Internal constructor.
   *
   * @param awsSecurityCredentials AWS security credentials
   * @param httpMethod the HTTP request method
   * @param url the request URL
   * @param region the targeted region
   * @param requestPayload the request payload
   * @param additionalHeaders a map of additional HTTP headers to be included with the signed
   *     request
   */
  private AwsRequestSigner(
      AwsSecurityCredentials awsSecurityCredentials,
      String httpMethod,
      String url,
      String region,
      @Nullable String requestPayload,
      @Nullable Map<String, String> additionalHeaders,
      @Nullable AwsDates awsDates) {
    this.awsSecurityCredentials = checkNotNull(awsSecurityCredentials);
    this.httpMethod = checkNotNull(httpMethod);
    this.uri = URI.create(url).normalize();
    this.region = checkNotNull(region);
    this.requestPayload = requestPayload == null ? "" : requestPayload;
    this.additionalHeaders =
        (additionalHeaders != null)
            ? new HashMap<>(additionalHeaders)
            : new HashMap<String, String>();
    this.dates = awsDates == null ? AwsDates.generateXAmzDate() : awsDates;
  }

  /**
   * Signs the specified AWS API request.
   *
   * @return the {@link AwsRequestSignature}
   */
  AwsRequestSignature sign() {
    // Retrieve the service name. For example: iam.amazonaws.com host => iam service.
    String serviceName = Splitter.on(".").split(uri.getHost()).iterator().next();

    Map<String, String> canonicalHeaders = getCanonicalHeaders(dates.getOriginalDate());
    // Headers must be sorted.
    List<String> sortedHeaderNames = new ArrayList<>();
    for (String headerName : canonicalHeaders.keySet()) {
      sortedHeaderNames.add(headerName.toLowerCase(Locale.US));
    }
    Collections.sort(sortedHeaderNames);

    String canonicalRequestHash = createCanonicalRequestHash(canonicalHeaders, sortedHeaderNames);
    String credentialScope =
        dates.getFormattedDate() + "/" + region + "/" + serviceName + "/" + AWS_REQUEST_TYPE;
    String stringToSign =
        createStringToSign(canonicalRequestHash, dates.getXAmzDate(), credentialScope);
    String signature =
        calculateAwsV4Signature(
            serviceName,
            awsSecurityCredentials.getSecretAccessKey(),
            dates.getFormattedDate(),
            region,
            stringToSign);

    String authorizationHeader =
        generateAuthorizationHeader(
            sortedHeaderNames, awsSecurityCredentials.getAccessKeyId(), credentialScope, signature);

    return new AwsRequestSignature.Builder()
        .setSignature(signature)
        .setCanonicalHeaders(canonicalHeaders)
        .setHttpMethod(httpMethod)
        .setSecurityCredentials(awsSecurityCredentials)
        .setCredentialScope(credentialScope)
        .setUrl(uri.toString())
        .setDate(dates.getOriginalDate())
        .setRegion(region)
        .setAuthorizationHeader(authorizationHeader)
        .build();
  }

  /** Task 1: Create a canonical request for Signature Version 4. */
  private String createCanonicalRequestHash(
      Map<String, String> headers, List<String> sortedHeaderNames) {
    // Append the HTTP request method.
    StringBuilder canonicalRequest = new StringBuilder(httpMethod).append("\n");

    // Append the path.
    String urlPath = uri.getRawPath().isEmpty() ? "/" : uri.getRawPath();
    canonicalRequest.append(urlPath).append("\n");

    // Append the canonical query string.
    String actionQueryString = uri.getRawQuery() != null ? uri.getRawQuery() : "";
    canonicalRequest.append(actionQueryString).append("\n");

    // Append the canonical headers.
    StringBuilder canonicalHeaders = new StringBuilder();
    for (String headerName : sortedHeaderNames) {
      canonicalHeaders.append(headerName).append(":").append(headers.get(headerName)).append("\n");
    }
    canonicalRequest.append(canonicalHeaders).append("\n");

    // Append the signed headers.
    canonicalRequest.append(Joiner.on(';').join(sortedHeaderNames)).append("\n");

    // Append the hashed request payload.
    canonicalRequest.append(getHexEncodedSha256Hash(requestPayload.getBytes(UTF_8)));

    // Return the hashed canonical request.
    return getHexEncodedSha256Hash(canonicalRequest.toString().getBytes(UTF_8));
  }

  /** Task 2: Create a string to sign for Signature Version 4. */
  private String createStringToSign(
      String canonicalRequestHash, String xAmzDate, String credentialScope) {
    return HASHING_ALGORITHM
        + "\n"
        + xAmzDate
        + "\n"
        + credentialScope
        + "\n"
        + canonicalRequestHash;
  }

  /**
   * Task 3: Calculate the signature for AWS Signature Version 4.
   *
   * @param date the date used in the hashing process in YYYYMMDD format
   */
  private String calculateAwsV4Signature(
      String serviceName, String secret, String date, String region, String stringToSign) {
    byte[] kDate = sign(("AWS4" + secret).getBytes(UTF_8), date.getBytes(UTF_8));
    byte[] kRegion = sign(kDate, region.getBytes(UTF_8));
    byte[] kService = sign(kRegion, serviceName.getBytes(UTF_8));
    byte[] kSigning = sign(kService, AWS_REQUEST_TYPE.getBytes(UTF_8));
    return BaseEncoding.base16().lowerCase().encode(sign(kSigning, stringToSign.getBytes(UTF_8)));
  }

  /** Task 4: Format the signature to be added to the HTTP request. */
  private String generateAuthorizationHeader(
      List<String> sortedHeaderNames,
      String accessKeyId,
      String credentialScope,
      String signature) {
    return String.format(
        "%s Credential=%s/%s, SignedHeaders=%s, Signature=%s",
        HASHING_ALGORITHM,
        accessKeyId,
        credentialScope,
        Joiner.on(';').join(sortedHeaderNames),
        signature);
  }

  private Map<String, String> getCanonicalHeaders(String defaultDate) {
    Map<String, String> headers = new HashMap<>();
    headers.put("host", uri.getHost());

    // Only add the date if it hasn't been specified through the "date" header.
    if (!additionalHeaders.containsKey("date")) {
      headers.put("x-amz-date", defaultDate);
    }

    if (awsSecurityCredentials.getSessionToken() != null
        && !awsSecurityCredentials.getSessionToken().isEmpty()) {
      headers.put("x-amz-security-token", awsSecurityCredentials.getSessionToken());
    }

    // Add all additional headers.
    for (String key : additionalHeaders.keySet()) {
      // Header keys need to be lowercase.
      headers.put(key.toLowerCase(Locale.US), additionalHeaders.get(key));
    }
    return headers;
  }

  private static byte[] sign(byte[] key, byte[] value) {
    try {
      String algorithm = "HmacSHA256";
      Mac mac = Mac.getInstance(algorithm);
      mac.init(new SecretKeySpec(key, algorithm));
      return mac.doFinal(value);
    } catch (NoSuchAlgorithmException e) {
      // Will not occur as HmacSHA256 is supported. We may allow other algorithms in the future.
      throw new RuntimeException("HmacSHA256 must be supported by the JVM.", e);
    } catch (InvalidKeyException e) {
      throw new SigningException("Invalid key used when calculating the AWS V4 Signature", e);
    }
  }

  private static String getHexEncodedSha256Hash(byte[] bytes) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      return BaseEncoding.base16().lowerCase().encode(digest.digest(bytes));
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Failed to compute SHA-256 hash.", e);
    }
  }

  static Builder newBuilder(
      AwsSecurityCredentials awsSecurityCredentials, String httpMethod, String url, String region) {
    return new Builder(awsSecurityCredentials, httpMethod, url, region);
  }

  static class Builder {

    private final AwsSecurityCredentials awsSecurityCredentials;
    private final String httpMethod;
    private final String url;
    private final String region;

    @Nullable private String requestPayload;
    @Nullable private Map<String, String> additionalHeaders;
    @Nullable private AwsDates dates;

    private Builder(
        AwsSecurityCredentials awsSecurityCredentials,
        String httpMethod,
        String url,
        String region) {
      this.awsSecurityCredentials = awsSecurityCredentials;
      this.httpMethod = httpMethod;
      this.url = url;
      this.region = region;
    }

    @CanIgnoreReturnValue
    Builder setRequestPayload(String requestPayload) {
      this.requestPayload = requestPayload;
      return this;
    }

    @CanIgnoreReturnValue
    Builder setAdditionalHeaders(Map<String, String> additionalHeaders) {
      if (additionalHeaders.containsKey("date") && additionalHeaders.containsKey("x-amz-date")) {
        throw new IllegalArgumentException("One of {date, x-amz-date} can be specified, not both.");
      }
      try {
        if (additionalHeaders.containsKey("date")) {
          this.dates = AwsDates.fromDateHeader(additionalHeaders.get("date"));
        }
        if (additionalHeaders.containsKey("x-amz-date")) {
          this.dates = AwsDates.fromXAmzDate(additionalHeaders.get("x-amz-date"));
        }
      } catch (ParseException e) {
        throw new IllegalArgumentException("The provided date header value is invalid.", e);
      }

      this.additionalHeaders = additionalHeaders;
      return this;
    }

    AwsRequestSigner build() {
      return new AwsRequestSigner(
          awsSecurityCredentials,
          httpMethod,
          url,
          region,
          requestPayload,
          additionalHeaders,
          dates);
    }
  }
}
