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

import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * For internal use only.
 */
class SpannerMetadataProvider {
  private final Map<Metadata.Key<String>, String> headers;
  private final Key<String> resourceHeaderKey;

  private static final Pattern[] RESOURCE_TOKEN_PATTERNS = {
    Pattern.compile("^(?<headerValue>projects/[^/]*/instances/[^/]*/databases/[^/]*)(.*)?"),
    Pattern.compile("^(?<headerValue>projects/[^/]*/instances/[^/]*)(.*)?")
  };

  private SpannerMetadataProvider(Map<String, String> headers, String resourceHeaderKey) {
    this.resourceHeaderKey = Key.of(resourceHeaderKey, Metadata.ASCII_STRING_MARSHALLER);
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
        resourceHeaderKey, getResourceHeaderValue(resourceTokenTemplate, defaultResourceToken));

    return metadata;
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
    if (resourceTokenTemplate != null) {
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
