/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.storage.v1beta2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.gax.core.NoCredentialsProvider;
import org.junit.jupiter.api.Test;

/** Unit tests for {@link StreamWriterV2} settings resolution. */
class StreamWriterV2Test {

  private static final String TEST_STREAM = "projects/p/datasets/d/tables/t/streams/s";

  @Test
  void testGetBigQueryWriteSettingsResolvesUniverseDomainEndpoint() throws Exception {
    StreamWriterV2.Builder builder =
        StreamWriterV2.newBuilder(TEST_STREAM)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setUniverseDomain("custom.example.com");

    BigQueryWriteSettings settings = StreamWriterV2.getBigQueryWriteSettings(builder, TEST_STREAM);

    assertEquals("custom.example.com", settings.getUniverseDomain());
    assertEquals("bigquerystorage.custom.example.com:443", settings.getEndpoint());
  }

  @Test
  void testGetBigQueryWriteSettingsRespectsExplicitEndpoint() throws Exception {
    StreamWriterV2.Builder builder =
        StreamWriterV2.newBuilder(TEST_STREAM)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setEndpoint("custom-endpoint.example.com:443");

    BigQueryWriteSettings settings = StreamWriterV2.getBigQueryWriteSettings(builder, TEST_STREAM);

    assertEquals("custom-endpoint.example.com:443", settings.getEndpoint());
  }

  @Test
  void testValidateUniverseDomainThrowsOnMismatchedClientUniverseDomain() throws Exception {
    BigQueryWriteSettings clientSettings =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setUniverseDomain("googleapis.com")
            .build();
    try (BigQueryWriteClient writeClient = BigQueryWriteClient.create(clientSettings)) {
      StreamWriterV2.Builder builder =
          StreamWriterV2.newBuilder(TEST_STREAM, writeClient)
              .setUniverseDomain("custom.example.com");

      IllegalArgumentException ex =
          assertThrows(
              IllegalArgumentException.class, () -> StreamWriterV2.validateUniverseDomain(builder));
      assertTrue(ex.getMessage().contains("custom.example.com"));
      assertTrue(ex.getMessage().contains("googleapis.com"));
    }
  }

  @Test
  void testValidateUniverseDomainAllowsMatchingClientUniverseDomain() throws Exception {
    BigQueryWriteSettings clientSettings =
        BigQueryWriteSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setUniverseDomain("custom.example.com")
            .build();
    try (BigQueryWriteClient writeClient = BigQueryWriteClient.create(clientSettings)) {
      StreamWriterV2.Builder builder =
          StreamWriterV2.newBuilder(TEST_STREAM, writeClient)
              .setUniverseDomain("custom.example.com");

      StreamWriterV2.validateUniverseDomain(builder);
    }
  }
}
