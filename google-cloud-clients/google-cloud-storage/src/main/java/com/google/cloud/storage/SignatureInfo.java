/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hashing;
import com.google.common.net.UrlEscapers;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Signature Info holds payload components of the string that requires signing.
 *
 * @see <a href=
 *     "https://cloud.google.com/storage/docs/access-control/signed-urls#string-components">
 *     Components</a>
 */
public class SignatureInfo {

  public static final char COMPONENT_SEPARATOR = '\n';
  public static final String GOOG4_RSA_SHA256 = "GOOG4-RSA-SHA256";
  public static final String SCOPE = "/auto/storage/goog4_request";

  private final HttpMethod httpVerb;
  private final String contentMd5;
  private final String contentType;
  private final long expiration;
  private final Map<String, String> canonicalizedExtensionHeaders;
  private final URI canonicalizedResource;
  private final Storage.SignUrlOption.SignatureVersion signatureVersion;
  private final String accountEmail;
  private final long timestamp;

  private final String yearMonthDay;
  private final String exactDate;

  private SignatureInfo(Builder builder) {
    this.httpVerb = builder.httpVerb;
    this.contentMd5 = builder.contentMd5;
    this.contentType = builder.contentType;
    this.expiration = builder.expiration;
    this.canonicalizedResource = builder.canonicalizedResource;
    this.signatureVersion = builder.signatureVersion;
    this.accountEmail = builder.accountEmail;
    this.timestamp = builder.timestamp;

    if (Storage.SignUrlOption.SignatureVersion.V4.equals(signatureVersion)
        && (!builder.canonicalizedExtensionHeaders.containsKey("host"))) {
      canonicalizedExtensionHeaders =
          new ImmutableMap.Builder<String, String>()
              .putAll(builder.canonicalizedExtensionHeaders)
              .put("host", "storage.googleapis.com")
              .build();
    } else {
      canonicalizedExtensionHeaders = builder.canonicalizedExtensionHeaders;
    }

    Date date = new Date(timestamp);

    SimpleDateFormat yearMonthDayFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat exactDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");

    yearMonthDayFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    exactDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    yearMonthDay = yearMonthDayFormat.format(date);
    exactDate = exactDateFormat.format(date);
  }

  /**
   * Constructs payload to be signed.
   *
   * @return payload to sign
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed URLs</a>
   */
  public String constructUnsignedPayload() {
    // TODO reverse order when V4 becomes default
    if (Storage.SignUrlOption.SignatureVersion.V4.equals(signatureVersion)) {
      return constructV4UnsignedPayload();
    }
    return constructV2UnsignedPayload();
  }

  private String constructV2UnsignedPayload() {
    StringBuilder payload = new StringBuilder();

    payload.append(httpVerb.name()).append(COMPONENT_SEPARATOR);
    if (contentMd5 != null) {
      payload.append(contentMd5);
    }
    payload.append(COMPONENT_SEPARATOR);

    if (contentType != null) {
      payload.append(contentType);
    }
    payload.append(COMPONENT_SEPARATOR);
    payload.append(expiration).append(COMPONENT_SEPARATOR);

    if (canonicalizedExtensionHeaders != null) {
      payload.append(
          new CanonicalExtensionHeadersSerializer(Storage.SignUrlOption.SignatureVersion.V2)
              .serialize(canonicalizedExtensionHeaders));
    }

    payload.append(canonicalizedResource);

    return payload.toString();
  }

  private String constructV4UnsignedPayload() {
    StringBuilder payload = new StringBuilder();

    payload.append(GOOG4_RSA_SHA256).append(COMPONENT_SEPARATOR);
    payload.append(exactDate).append(COMPONENT_SEPARATOR);
    payload.append(yearMonthDay).append(SCOPE).append(COMPONENT_SEPARATOR);
    payload.append(constructV4CanonicalRequestHash());

    return payload.toString();
  }

  private String constructV4CanonicalRequestHash() {
    StringBuilder canonicalRequest = new StringBuilder();

    CanonicalExtensionHeadersSerializer serializer =
        new CanonicalExtensionHeadersSerializer(Storage.SignUrlOption.SignatureVersion.V4);

    canonicalRequest.append(httpVerb.name()).append(COMPONENT_SEPARATOR);
    canonicalRequest.append(canonicalizedResource).append(COMPONENT_SEPARATOR);
    canonicalRequest.append(constructV4QueryString()).append(COMPONENT_SEPARATOR);
    canonicalRequest
        .append(serializer.serialize(canonicalizedExtensionHeaders))
        .append(COMPONENT_SEPARATOR);
    canonicalRequest
        .append(serializer.serializeHeaderNames(canonicalizedExtensionHeaders))
        .append(COMPONENT_SEPARATOR);
    canonicalRequest.append("UNSIGNED-PAYLOAD");

    return Hashing.sha256()
        .hashString(canonicalRequest.toString(), StandardCharsets.UTF_8)
        .toString();
  }

  public String constructV4QueryString() {
    StringBuilder signedHeaders =
        new CanonicalExtensionHeadersSerializer(Storage.SignUrlOption.SignatureVersion.V4)
            .serializeHeaderNames(canonicalizedExtensionHeaders);

    StringBuilder queryString = new StringBuilder();
    queryString.append("X-Goog-Algorithm=").append(GOOG4_RSA_SHA256).append("&");
    queryString.append(
        "X-Goog-Credential="
            + UrlEscapers.urlFormParameterEscaper()
                .escape(accountEmail + "/" + yearMonthDay + SCOPE)
            + "&");
    queryString.append("X-Goog-Date=" + exactDate + "&");
    queryString.append("X-Goog-Expires=" + expiration + "&");
    queryString.append(
        "X-Goog-SignedHeaders="
            + UrlEscapers.urlFormParameterEscaper().escape(signedHeaders.toString()));
    return queryString.toString();
  }

  public HttpMethod getHttpVerb() {
    return httpVerb;
  }

  public String getContentMd5() {
    return contentMd5;
  }

  public String getContentType() {
    return contentType;
  }

  public long getExpiration() {
    return expiration;
  }

  public Map<String, String> getCanonicalizedExtensionHeaders() {
    return canonicalizedExtensionHeaders;
  }

  public URI getCanonicalizedResource() {
    return canonicalizedResource;
  }

  public Storage.SignUrlOption.SignatureVersion getSignatureVersion() {
    return signatureVersion;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getAccountEmail() {
    return accountEmail;
  }

  public static final class Builder {

    private final HttpMethod httpVerb;
    private String contentMd5;
    private String contentType;
    private final long expiration;
    private Map<String, String> canonicalizedExtensionHeaders;
    private final URI canonicalizedResource;
    private Storage.SignUrlOption.SignatureVersion signatureVersion;
    private String accountEmail;
    private long timestamp;

    /**
     * Constructs builder.
     *
     * @param httpVerb the HTTP method
     * @param expiration the EPOX expiration date
     * @param canonicalizedResource the resource URI
     * @throws IllegalArgumentException if required field is not provided.
     */
    public Builder(HttpMethod httpVerb, long expiration, URI canonicalizedResource) {
      this.httpVerb = httpVerb;
      this.expiration = expiration;
      this.canonicalizedResource = canonicalizedResource;
    }

    public Builder(SignatureInfo signatureInfo) {
      this.httpVerb = signatureInfo.httpVerb;
      this.contentMd5 = signatureInfo.contentMd5;
      this.contentType = signatureInfo.contentType;
      this.expiration = signatureInfo.expiration;
      this.canonicalizedExtensionHeaders = signatureInfo.canonicalizedExtensionHeaders;
      this.canonicalizedResource = signatureInfo.canonicalizedResource;
      this.signatureVersion = signatureInfo.signatureVersion;
      this.accountEmail = signatureInfo.accountEmail;
      this.timestamp = signatureInfo.timestamp;
    }

    public Builder setContentMd5(String contentMd5) {
      this.contentMd5 = contentMd5;

      return this;
    }

    public Builder setContentType(String contentType) {
      this.contentType = contentType;

      return this;
    }

    public Builder setCanonicalizedExtensionHeaders(
        Map<String, String> canonicalizedExtensionHeaders) {
      this.canonicalizedExtensionHeaders = canonicalizedExtensionHeaders;

      return this;
    }

    public Builder setSignatureVersion(Storage.SignUrlOption.SignatureVersion signatureVersion) {
      this.signatureVersion = signatureVersion;

      return this;
    }

    public Builder setAccountEmail(String accountEmail) {
      this.accountEmail = accountEmail;

      return this;
    }

    public Builder setTimestamp(long timestamp) {
      this.timestamp = timestamp;

      return this;
    }

    /** Creates an {@code SignatureInfo} object from this builder. */
    public SignatureInfo build() {
      checkArgument(httpVerb != null, "Required HTTP method");
      checkArgument(canonicalizedResource != null, "Required canonicalized resource");
      checkArgument(expiration >= 0, "Expiration must be greater than or equal to zero");

      if (Storage.SignUrlOption.SignatureVersion.V4.equals(signatureVersion)) {
        checkArgument(accountEmail != null, "Account email required to use V4 signing");
        checkArgument(timestamp > 0, "Timestamp required to use V4 signing");
        checkArgument(
            expiration <= 604800, "Expiration can't be longer than 7 days to use V4 signing");
      }

      if (canonicalizedExtensionHeaders == null) {
        canonicalizedExtensionHeaders = new HashMap<>();
      }

      return new SignatureInfo(this);
    }
  }
}
