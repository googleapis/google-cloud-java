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

public class SpannerMetadataProviderTest {
  @Test
  public void testGetHeadersAsMetadata() {
    Map<String, String> headers = ImmutableMap.of("header1", "value1", "header2", "value2");
    SpannerMetadataProvider metadataProvider = SpannerMetadataProvider.create(headers, "header3");

    Metadata metadata = metadataProvider.newMetadata(null, "stuff");
    assertEquals(headers.size() + 1, metadata.keys().size());
    assertEquals(
        headers.get("header1"), metadata.get(Key.of("header1", Metadata.ASCII_STRING_MARSHALLER)));
    assertEquals(
        headers.get("header2"), metadata.get(Key.of("header2", Metadata.ASCII_STRING_MARSHALLER)));
    assertEquals("stuff", metadata.get(Key.of("header3", Metadata.ASCII_STRING_MARSHALLER)));
  }

  @Test
  public void testGetResourceHeaderValue() {
    SpannerMetadataProvider metadataProvider =
        SpannerMetadataProvider.create(ImmutableMap.<String, String>of(), "header3");

    assertEquals("projects/p", getResourceHeaderValue(metadataProvider, "garbage"));
    assertEquals("projects/p", getResourceHeaderValue(metadataProvider, "projects/p"));
    assertEquals(
        "projects/p/instances/i", getResourceHeaderValue(metadataProvider, "projects/p/instances/i"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeaderValue(metadataProvider, "projects/p/instances/i/databases/d"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeaderValue(metadataProvider, "projects/p/instances/i/databases/d/sessions/s"));
    assertEquals(
        "projects/p/instances/i",
        getResourceHeaderValue(metadataProvider, "projects/p/instances/i/operations/op"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeaderValue(metadataProvider, "projects/p/instances/i/databases/d/operations/op"));
    assertEquals(
        "projects/p/instances/i",
        getResourceHeaderValue(metadataProvider, "projects/p/instances/i/operations"));
    assertEquals(
        "projects/p/instances/i/databases/d",
        getResourceHeaderValue(metadataProvider, "projects/p/instances/i/databases/d/operations"));
  }

  private String getResourceHeaderValue(
      SpannerMetadataProvider headerProvider, String resourceTokenTemplate) {
    Metadata metadata = headerProvider.newMetadata(resourceTokenTemplate, "projects/p");
    assertEquals(1, metadata.keys().size());
    return metadata.get(Key.of("header3", Metadata.ASCII_STRING_MARSHALLER));
  }
}
