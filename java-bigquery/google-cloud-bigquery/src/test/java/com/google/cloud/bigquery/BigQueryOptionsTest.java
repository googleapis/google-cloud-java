/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.bigquery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.TransportOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BigQueryOptionsTest {

  @Test
  void testInvalidTransport() {
    IllegalArgumentException expected =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                BigQueryOptions.newBuilder()
                    .setTransportOptions(Mockito.mock(TransportOptions.class)));
    assertNotNull(expected.getMessage());
  }

  @Test
  void dataFormatOptions_createdByDefault() {
    BigQueryOptions options = BigQueryOptions.newBuilder().setProjectId("project-id").build();

    assertNotNull(options.getDataFormatOptions());
    assertFalse(options.getDataFormatOptions().useInt64Timestamp());
    assertEquals(
        DataFormatOptions.TimestampFormatOptions.TIMESTAMP_OUTPUT_FORMAT_UNSPECIFIED,
        options.getDataFormatOptions().timestampFormatOptions());
  }

  @Test
  void nonBuilderSetUseInt64Timestamp_capturedInDataFormatOptions() {
    BigQueryOptions options =
        BigQueryOptions.newBuilder()
            .setDataFormatOptions(DataFormatOptions.newBuilder().useInt64Timestamp(false).build())
            .setProjectId("project-id")
            .build();
    options.setUseInt64Timestamps(true);

    assertTrue(options.getDataFormatOptions().useInt64Timestamp());
  }

  @Test
  void nonBuilderSetUseInt64Timestamp_overridesEverything() {
    BigQueryOptions options = BigQueryOptions.newBuilder().setProjectId("project-id").build();
    options.setUseInt64Timestamps(true);

    assertTrue(options.getDataFormatOptions().useInt64Timestamp());
  }

  @Test
  void noDataFormatOptions_capturesUseInt64TimestampSetInBuilder() {
    BigQueryOptions options =
        BigQueryOptions.newBuilder().setUseInt64Timestamps(true).setProjectId("project-id").build();

    assertTrue(options.getDataFormatOptions().useInt64Timestamp());
  }

  @Test
  void dataFormatOptionsSetterHasPrecedence() {
    BigQueryOptions options =
        BigQueryOptions.newBuilder()
            .setProjectId("project-id")
            .setDataFormatOptions(DataFormatOptions.newBuilder().useInt64Timestamp(true).build())
            .setUseInt64Timestamps(false)
            .build();

    assertTrue(options.getDataFormatOptions().useInt64Timestamp());
  }
}
