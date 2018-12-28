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

import java.net.URI;
import java.util.Map;

/**
 * Signature Info holds payload components of the string that requires signing.
 *
 * @see <a href=
 *     "https://cloud.google.com/storage/docs/access-control/signed-urls#string-components">
 *     Components</a>
 */
public class SignatureInfo {

  public static final char COMPONENT_SEPARATOR = '\n';

  private final HttpMethod httpVerb;
  private final String contentMd5;
  private final String contentType;
  private final long expiration;
  private final Map<String, String> canonicalizedExtensionHeaders;
  private final URI canonicalizedResource;

  private SignatureInfo(Builder builder) {
    this.httpVerb = builder.httpVerb;
    this.contentMd5 = builder.contentMd5;
    this.contentType = builder.contentType;
    this.expiration = builder.expiration;
    this.canonicalizedExtensionHeaders = builder.canonicalizedExtensionHeaders;
    this.canonicalizedResource = builder.canonicalizedResource;
  }

  /**
   * Constructs payload to be signed.
   *
   * @return paylod to sign
   * @see <a href="https://cloud.google.com/storage/docs/access-control#Signed-URLs">Signed URLs</a>
   */
  public String constructUnsignedPayload() {
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
          new CanonicalExtensionHeadersSerializer().serialize(canonicalizedExtensionHeaders));
    }

    payload.append(canonicalizedResource);

    return payload.toString();
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

  public static final class Builder {

    private final HttpMethod httpVerb;
    private String contentMd5;
    private String contentType;
    private final long expiration;
    private Map<String, String> canonicalizedExtensionHeaders;
    private final URI canonicalizedResource;

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

    /** Creates an {@code SignatureInfo} object from this builder. */
    public SignatureInfo build() {
      checkArgument(httpVerb != null, "Required HTTP method");
      checkArgument(canonicalizedResource != null, "Required canonicalized resource");
      checkArgument(expiration >= 0, "Expiration must be greater than or equal to zero");

      return new SignatureInfo(this);
    }
  }
}
