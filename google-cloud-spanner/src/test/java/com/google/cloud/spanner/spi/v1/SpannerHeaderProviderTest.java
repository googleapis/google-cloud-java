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

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import java.util.Map;
import org.junit.Test;

public class SpannerHeaderProviderTest {
  @Test
  public void getHeadersAsMetadata() {
    Map<String, String> headers = ImmutableMap.of("header1", "value1", "header2", "value2");
    SpannerHeaderProvider headerProvider =
        SpannerHeaderProvider.create(headers, "header3");

    assertEquals(headers, headerProvider.getHeaders());

    Map<Key<String>, String> headersAsMetadata = headerProvider.getHeadersAsMetadata();
    assertEquals(headers.size(), headersAsMetadata.size());
    assertEquals(
        headers.get("header1"),
        headersAsMetadata.get(Key.of("header1", Metadata.ASCII_STRING_MARSHALLER)));
    assertEquals(
        headers.get("header2"),
        headersAsMetadata.get(Key.of("header2", Metadata.ASCII_STRING_MARSHALLER)));
  }

  @Test
  public void getResourceHeadersAsMetadata() {
    SpannerHeaderProvider headerProvider =
        SpannerHeaderProvider.create(ImmutableMap.<String, String>of(), "header3");

    assertEquals(ImmutableMap.<String, String>of(), headerProvider.getHeaders());
    Map<Key<String>, String> headersAsMetadata = headerProvider.getHeadersAsMetadata();
    assertEquals(0, headersAsMetadata.size());

    assertEquals("projects/p", getResourceHeadersAsMetadata(headerProvider, "garbage"));
    assertEquals("projects/p", getResourceHeadersAsMetadata(headerProvider, "projects/p"));
    assertEquals(
        "projects/p/instances/i",
        getResourceHeadersAsMetadata(headerProvider, "projects/p/instances/i"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeadersAsMetadata(headerProvider, "projects/p/instances/i/databases/d"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeadersAsMetadata(
            headerProvider, "projects/p/instances/i/databases/d/sessions/s"));
    assertEquals(
        "projects/p/instances/i",
        getResourceHeadersAsMetadata(headerProvider, "projects/p/instances/i/operations/op"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeadersAsMetadata(
            headerProvider, "projects/p/instances/i/databases/d/operations/op"));
    assertEquals(
        "projects/p/instances/i",
        getResourceHeadersAsMetadata(headerProvider, "projects/p/instances/i/operations"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeadersAsMetadata(
            headerProvider, "projects/p/instances/i/databases/d/operations"));
  }

  private String getResourceHeadersAsMetadata(
      SpannerHeaderProvider headerProvider, String resourceTokenTemplate) {
    Map<Key<String>, String> resourceHeaders =
        headerProvider.getResourceHeadersAsMetadata(resourceTokenTemplate, "projects/p");
    assertEquals(1, resourceHeaders.size());
    return resourceHeaders.get(Key.of("header3", Metadata.ASCII_STRING_MARSHALLER));
  }
}
