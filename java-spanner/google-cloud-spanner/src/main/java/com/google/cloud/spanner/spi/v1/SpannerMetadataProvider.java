/*
 * Copyright 2017 Google LLC
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
package com.google.cloud.spanner.spi.v1;

import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** For internal use only. */
class SpannerMetadataProvider {
  private final Cache<String, Map<String, List<String>>> extraHeadersCache =
      CacheBuilder.newBuilder().maximumSize(100).build();
  private final Map<Metadata.Key<String>, String> headers;
  private final String resourceHeaderKey;
  private static final String ROUTE_TO_LEADER_HEADER_KEY = "x-goog-spanner-route-to-leader";
  private static final String END_TO_END_TRACING_HEADER_KEY = "x-goog-spanner-end-to-end-tracing";
  private static final String AFE_SERVER_TIMING_HEADER_KEY =
      "x-goog-spanner-enable-afe-server-timing";
  private static final Pattern[] RESOURCE_TOKEN_PATTERNS = {
    Pattern.compile("^(?<headerValue>projects/[^/]*/instances/[^/]*/databases/[^/]*)(.*)?"),
    Pattern.compile("^(?<headerValue>projects/[^/]*/instances/[^/]*)(.*)?")
  };

  private static final Map<String, List<String>> ROUTE_TO_LEADER_HEADER_MAP =
      ImmutableMap.of(ROUTE_TO_LEADER_HEADER_KEY, Collections.singletonList("true"));
  private static final Map<String, List<String>> END_TO_END_TRACING_HEADER_MAP =
      ImmutableMap.of(END_TO_END_TRACING_HEADER_KEY, Collections.singletonList("true"));
  private static final Map<String, List<String>> AFE_SERVER_TIMING_HEADER_MAP =
      ImmutableMap.of(AFE_SERVER_TIMING_HEADER_KEY, Collections.singletonList("true"));

  private SpannerMetadataProvider(Map<String, String> headers, String resourceHeaderKey) {
    this.resourceHeaderKey = resourceHeaderKey;
    this.headers = constructHeadersAsMetadata(headers);
  }

  static SpannerMetadataProvider create(Map<String, String> headers, String resourceHeaderKey) {
    return new SpannerMetadataProvider(headers, resourceHeaderKey);
  }

  Metadata newMetadata(String resourceTokenTemplate, String defaultResourceToken) {
    Metadata metadata = new Metadata();
    for (Map.Entry<Metadata.Key<String>, String> header : headers.entrySet()) {
      metadata.put(header.getKey(), header.getValue());
    }

    metadata.put(
        Key.of(resourceHeaderKey, Metadata.ASCII_STRING_MARSHALLER),
        getResourceHeaderValue(resourceTokenTemplate, defaultResourceToken));

    return metadata;
  }

  Map<String, List<String>> newExtraHeaders(
      String resourceTokenTemplate, String defaultResourceToken) {
    try {
      return extraHeadersCache.get(
          MoreObjects.firstNonNull(resourceTokenTemplate, ""),
          () ->
              ImmutableMap.<String, List<String>>builder()
                  .put(
                      resourceHeaderKey,
                      Collections.singletonList(
                          getResourceHeaderValue(resourceTokenTemplate, defaultResourceToken)))
                  .build());
    } catch (ExecutionException executionException) {
      // This should never happen.
      throw SpannerExceptionFactory.asSpannerException(executionException.getCause());
    }
  }

  Map<String, List<String>> newRouteToLeaderHeader() {
    return ROUTE_TO_LEADER_HEADER_MAP;
  }

  Map<String, List<String>> newEndToEndTracingHeader() {
    return END_TO_END_TRACING_HEADER_MAP;
  }

  Map<String, List<String>> newAfeServerTimingHeader() {
    return AFE_SERVER_TIMING_HEADER_MAP;
  }

  private Map<Metadata.Key<String>, String> constructHeadersAsMetadata(
      Map<String, String> headers) {
    ImmutableMap.Builder<Metadata.Key<String>, String> headersAsMetadataBuilder =
        ImmutableMap.builder();
    for (Map.Entry<String, String> entry : headers.entrySet()) {
      headersAsMetadataBuilder.put(
          Metadata.Key.of(entry.getKey(), Metadata.ASCII_STRING_MARSHALLER), entry.getValue());
    }
    return headersAsMetadataBuilder.build();
  }

  private String getResourceHeaderValue(String resourceTokenTemplate, String defaultResourceToken) {
    String resourceToken = defaultResourceToken;
    if (!Strings.isNullOrEmpty(resourceTokenTemplate)) {
      for (Pattern pattern : RESOURCE_TOKEN_PATTERNS) {
        Matcher m = pattern.matcher(resourceTokenTemplate);
        if (m.matches()) {
          resourceToken = m.group("headerValue");
          break;
        }
      }
    }

    return resourceToken;
  }
}
