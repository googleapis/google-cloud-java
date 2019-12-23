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

import static com.google.cloud.storage.SignedUrlEncodingHelper.Rfc3986UriEncode;
import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.hash.Hashing;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

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
  private static final List<String> RESERVED_PARAMS_LOWER =
      ImmutableList.<String>of(
          // V2:
          "expires",
          "googleaccessid",
          // V4:
          "x-goog-algorithm",
          "x-goog-credential",
          "x-goog-date",
          "x-goog-expires",
          "x-goog-signedheaders");

  private final HttpMethod httpVerb;
  private final String contentMd5;
  private final String contentType;
  private final long expiration;
  private final Map<String, String> canonicalizedExtensionHeaders;
  private final Map<String, String> queryParams;
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

    ImmutableMap.Builder<String, String> headerBuilder =
        new ImmutableMap.Builder<String, String>().putAll(builder.canonicalizedExtensionHeaders);
    // The "host" header only needs to be present and signed if using V4.
    if (Storage.SignUrlOption.SignatureVersion.V4.equals(signatureVersion)
        && (!builder.canonicalizedExtensionHeaders.containsKey("host"))) {
      headerBuilder.put("host", "storage.googleapis.com");
    }
    canonicalizedExtensionHeaders = headerBuilder.build();

    queryParams = ImmutableMap.<String, String>copyOf(builder.queryParams);

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

    if (canonicalizedExtensionHeaders.size() > 0) {
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

  /**
   * Returns a TreeMap containing the user-supplied query parameters that do not have reserved keys.
   */
  private TreeMap<String, String> getNonReservedUserQueryParams() {
    TreeMap<String, String> sortedParamMap = new TreeMap<String, String>();

    // Skip any instances of well-known required headers that might have been supplied by the
    // caller.
    for (Map.Entry<String, String> entry : queryParams.entrySet()) {
      // Convert to (and check for the existence of) lowercase keys to prevent cases like a user
      // supplying "x-goog-algorithm", in order to prevent the resulting query string from
      // containing "x-goog-algorithm" and "X-Goog-Algorithm".
      if (!RESERVED_PARAMS_LOWER.contains(entry.getKey().toLowerCase())) {
        // URI encode user-supplied parameter, both the name and the value.
        sortedParamMap.put(
            Rfc3986UriEncode(entry.getKey(), true), Rfc3986UriEncode(entry.getValue(), true));
      }
    }

    return sortedParamMap;
  }

  private String queryStringFromParamMap(Map<String, String> map) {
    StringBuilder queryStringBuilder = new StringBuilder();

    String sep = "";
    for (Map.Entry<String, String> entry : map.entrySet()) {
      queryStringBuilder.append(sep);
      sep = "&";
      queryStringBuilder.append(entry.getKey()).append('=').append(entry.getValue());
    }

    return queryStringBuilder.toString();
  }

  /**
   * Returns a query string constructed from this object's stored query parameters, sorted in code
   * point order. Note that these query parameters are not used when constructing the URL's
   * signature. The returned value does not include the leading ? character, as this is not part of
   * a query string.
   *
   * @return A URI query string. Returns an empty string if the user supplied no query parameters.
   */
  public String constructV2QueryString() {
    TreeMap<String, String> sortedParamMap = getNonReservedUserQueryParams();
    // The "GoogleAccessId", "Expires", and "Signature" params are not included here.
    return queryStringFromParamMap(sortedParamMap);
  }

  /**
   * Returns a query string constructed from this object's stored query parameters, sorted in code
   * point order so that the query string can be used in a V4 canonical request string. The returned
   * value does not include the leading ? character, as this is not part of a query string.
   *
   * @see <a href= "https://cloud.google.com/storage/docs/authentication/canonical-requests">
   *     Canonical Requests</a>
   */
  public String constructV4QueryString() {
    TreeMap<String, String> sortedParamMap = getNonReservedUserQueryParams();

    // Add in the reserved auth-specific query params.
    sortedParamMap.put("X-Goog-Algorithm", Rfc3986UriEncode(GOOG4_RSA_SHA256, true));
    sortedParamMap.put(
        "X-Goog-Credential", Rfc3986UriEncode(accountEmail + "/" + yearMonthDay + SCOPE, true));
    sortedParamMap.put("X-Goog-Date", Rfc3986UriEncode(exactDate, true));
    sortedParamMap.put("X-Goog-Expires", Rfc3986UriEncode(Long.toString(expiration), true));
    StringBuilder signedHeadersBuilder =
        new CanonicalExtensionHeadersSerializer(Storage.SignUrlOption.SignatureVersion.V4)
            .serializeHeaderNames(canonicalizedExtensionHeaders);
    sortedParamMap.put(
        "X-Goog-SignedHeaders", Rfc3986UriEncode(signedHeadersBuilder.toString(), true));

    // The "X-Goog-Signature" param is not included here.
    return queryStringFromParamMap(sortedParamMap);
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

  public Map<String, String> getQueryParams() {
    return queryParams;
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
    private Map<String, String> queryParams;
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
      this.queryParams = signatureInfo.queryParams;
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

    public Builder setCanonicalizedQueryParams(Map<String, String> queryParams) {
      this.queryParams = queryParams;

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

      if (queryParams == null) {
        queryParams = new HashMap<>();
      }

      return new SignatureInfo(this);
    }
  }
}
