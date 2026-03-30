/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.tracing;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.rpc.ErrorInfo;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

final class ObservabilityUtils {

  private ObservabilityUtils() {}

  /** Constant for redacted values. */
  private static final String REDACTED_VALUE = "REDACTED";

  /**
   * A set of lowercase query parameter keys whose values should be redacted in URLs for
   * observability. These include direct credentials (access keys), cryptographic signatures (to
   * prevent replay attacks or leak of authorization), and session identifiers (like upload_id).
   */
  private static final ImmutableSet<String> SENSITIVE_QUERY_KEYS =
      ImmutableSet.of(
          "awsaccesskeyid", // AWS S3-compatible access keys
          "signature", // General cryptographic signature
          "sig", // General cryptographic signature (abbreviated)
          "x-goog-signature", // Google Cloud specific signature
          "upload_id", // Resumable upload session identifiers
          "access_token", // OAuth2 explicit tokens
          "key", // API Keys
          "api_key"); // API Keys

  /**
   * Sanitizes an HTTP URL by redacting sensitive query parameters and credentials in the user-info
   * component. If the provided URL cannot be parsed (e.g. invalid syntax), it returns the original
   * string.
   *
   * <p>This sanitization process conforms to the recommendations in footnote 3 of the OpenTelemetry
   * semantic conventions for HTTP URL attributes:
   * https://opentelemetry.io/docs/specs/semconv/registry/attributes/url/
   *
   * <ul>
   *   <li><i>"url.full MUST NOT contain credentials passed via URL in form of
   *       https://user:pass@example.com/. In such case username and password SHOULD be redacted and
   *       attribute's value SHOULD be https://REDACTED:REDACTED@example.com/."</i> - Handled by
   *       stripping the raw user info component.
   *   <li><i>"url.full SHOULD capture the absolute URL when it is available (or can be
   *       reconstructed)."</i> - Handled by parsing and rebuilding the generic URI.
   *   <li><i>"When a query string value is redacted, the query string key SHOULD still be
   *       preserved, e.g. https://www.example.com/path?color=blue&sig=REDACTED."</i> - Handled by
   *       the redactSensitiveQueryValues method.
   * </ul>
   *
   * @param url the raw URL string
   * @return the sanitized URL string, or the original if unparsable
   */
  static String sanitizeUrlFull(final String url) {
    try {
      java.net.URI uri = new java.net.URI(url);
      String sanitizedUserInfo =
          uri.getRawUserInfo() != null ? REDACTED_VALUE + ":" + REDACTED_VALUE : null;
      String sanitizedQuery = redactSensitiveQueryValues(uri.getRawQuery());
      java.net.URI sanitizedUri =
          new java.net.URI(
              uri.getScheme(),
              sanitizedUserInfo,
              uri.getHost(),
              uri.getPort(),
              uri.getRawPath(),
              sanitizedQuery,
              uri.getRawFragment());
      return sanitizedUri.toString();
    } catch (java.net.URISyntaxException | IllegalArgumentException ex) {
      return "";
    }
  }

  /**
   * Redacts the values of sensitive keys within a raw URI query string.
   *
   * <p>This logic splits the query string by the {@code &} delimiter without full URL decoding,
   * ensures only values belonging to predefined sensitive keys are replaced with {@code
   * REDACTED_VALUE}. The check is strictly case-insensitive.
   *
   * <p>Note regarding Footnote 3: The OpenTelemetry spec recommends case-sensitive matching for
   * query parameters. However, we intentionally utilize case-insensitive matching (by lowercasing
   * all query keys) to prevent credentials bypassing validation when sent with mixed casings (e.g.,
   * Sig=..., API_KEY=...).
   *
   * @param rawQuery the raw query string from a java.net.URI
   * @return a reconstructed query sequence with sensitive values redacted
   */
  private static String redactSensitiveQueryValues(final String rawQuery) {
    if (rawQuery == null || rawQuery.isEmpty()) {
      return rawQuery;
    }

    java.util.List<String> redactedParams =
        Splitter.on('&').splitToList(rawQuery).stream()
            .map(
                param -> {
                  int equalsIndex = param.indexOf('=');
                  if (equalsIndex < 0) {
                    return param;
                  }
                  String key = param.substring(0, equalsIndex);
                  // Case-insensitive match utilizing the fact that all
                  // predefined keys are in lowercase
                  if (SENSITIVE_QUERY_KEYS.contains(key.toLowerCase())) {
                    return key + "=" + REDACTED_VALUE;
                  }
                  return param;
                })
            .collect(java.util.stream.Collectors.toList());

    return Joiner.on('&').join(redactedParams);
  }

  /**
   * Function to extract the status of the error as a string.
   *
   * @param error the thrown throwable error
   * @return the extracted status string
   */
  static String extractStatus(@Nullable final Throwable error) {
    final String statusString;

    if (error == null) {
      return StatusCode.Code.OK.toString();
    } else if (error instanceof CancellationException) {
      statusString = StatusCode.Code.CANCELLED.toString();
    } else if (error instanceof ApiException) {
      statusString = ((ApiException) error).getStatusCode().getCode().toString();
    } else {
      statusString = StatusCode.Code.UNKNOWN.toString();
    }

    return statusString;
  }

  /** Function to extract the ErrorInfo payload from the error, if available */
  @Nullable
  static ErrorInfo extractErrorInfo(@Nullable Throwable error) {
    if (error instanceof ApiException) {
      ApiException apiException = (ApiException) error;
      if (apiException.getErrorDetails() != null) {
        return apiException.getErrorDetails().getErrorInfo();
      }
    }
    return null;
  }

  static Attributes toOtelAttributes(Map<String, Object> attributes) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    if (attributes == null) {
      return attributesBuilder.build();
    }
    attributes.forEach(
        (k, v) -> {
          if (v instanceof String) {
            attributesBuilder.put(k, (String) v);
          } else if (v instanceof Long) {
            attributesBuilder.put(k, (Long) v);
          } else if (v instanceof Integer) {
            attributesBuilder.put(k, (long) (Integer) v);
          }
        });
    return attributesBuilder.build();
  }
}
