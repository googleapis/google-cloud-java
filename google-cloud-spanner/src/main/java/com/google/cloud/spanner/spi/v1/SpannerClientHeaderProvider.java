/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import com.google.api.gax.rpc.HeaderProvider;
import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SpannerClientHeaderProvider implements HeaderProvider {
  private final Map<String, String> headers;
  private final Map<Metadata.Key<String>, String> headersAsMetadata;
  private final String resourceHeaderKey;

  private SpannerClientHeaderProvider(Map<String, String> headers, String resourceHeaderKey) {
    this.headers = ImmutableMap.copyOf(headers);
    this.resourceHeaderKey = resourceHeaderKey;
    this.headersAsMetadata = constructHeadersAsMetadata(this.headers);
  }

  static SpannerClientHeaderProvider create(Map<String, String> headers, String resourceHeaderKey) {
    return new SpannerClientHeaderProvider(headers, resourceHeaderKey);
  }

  @Override
  public Map<String, String> getHeaders() {
    return headers;
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

  Map<Key<String>, String> getHeadersAsMetadata() {
    return headersAsMetadata;
  }

  Map<Key<String>, String> getResourceHeadersAsMetadata(
      String resourceTokenTemplate, String defaultResourceToken, Pattern... resourceTokenPatterns) {

    String resourceToken = defaultResourceToken;
    for (Pattern pattern : resourceTokenPatterns) {
      Matcher m = pattern.matcher(resourceTokenTemplate);
      if (m.matches()) {
        resourceToken = m.group("headerValue");
        break;
      }
    }

    return ImmutableMap.of(
        Key.of(resourceHeaderKey, Metadata.ASCII_STRING_MARSHALLER), resourceToken);
  }
}
