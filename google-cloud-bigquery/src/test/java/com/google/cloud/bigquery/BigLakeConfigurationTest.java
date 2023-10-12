/*
 * Copyright 2023 Google LLC
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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BigLakeConfigurationTest {

  private static final String STORAGE_URI = "gs://storage-uri";
  private static final String FILE_FORMAT = "PARQUET";
  private static final String TABLE_FORMAT = "ICEBERG";
  private static final String CONNECTION_ID = "us.test-connection";

  private static final BigLakeConfiguration BIG_LAKE_CONFIGURATION =
      BigLakeConfiguration.newBuilder()
          .setStorageUri(STORAGE_URI)
          .setFileFormat(FILE_FORMAT)
          .setTableFormat(TABLE_FORMAT)
          .setConnectionId(CONNECTION_ID)
          .build();
  private static final com.google.api.services.bigquery.model.BigLakeConfiguration
      BIG_LAKE_CONFIGURATION_PB =
          new com.google.api.services.bigquery.model.BigLakeConfiguration()
              .setStorageUri(STORAGE_URI)
              .setFileFormat(FILE_FORMAT)
              .setTableFormat(TABLE_FORMAT)
              .setConnectionId(CONNECTION_ID);

  @Test
  public void testToBuilder() {
    assertEquals(STORAGE_URI, BIG_LAKE_CONFIGURATION.getStorageUri());
    assertEquals(FILE_FORMAT, BIG_LAKE_CONFIGURATION.getFileFormat());
    assertEquals(TABLE_FORMAT, BIG_LAKE_CONFIGURATION.getTableFormat());
    assertEquals(CONNECTION_ID, BIG_LAKE_CONFIGURATION.getConnectionId());
  }

  @Test
  public void testToPb() {
    assertBigLakeConfiguration(BIG_LAKE_CONFIGURATION_PB, BIG_LAKE_CONFIGURATION.toPb());
  }

  @Test
  public void testFromPb() {
    assertBigLakeConfiguration(
        BIG_LAKE_CONFIGURATION, BigLakeConfiguration.fromPb(BIG_LAKE_CONFIGURATION_PB));
  }

  private static void assertBigLakeConfiguration(
      BigLakeConfiguration expected, BigLakeConfiguration actual) {
    assertEquals(expected.getConnectionId(), actual.getConnectionId());
    assertEquals(expected.getTableFormat(), actual.getTableFormat());
    assertEquals(expected.getStorageUri(), actual.getStorageUri());
    assertEquals(expected.getFileFormat(), actual.getFileFormat());
  }

  private static void assertBigLakeConfiguration(
      com.google.api.services.bigquery.model.BigLakeConfiguration expected,
      com.google.api.services.bigquery.model.BigLakeConfiguration actual) {
    assertEquals(expected.getConnectionId(), actual.getConnectionId());
    assertEquals(expected.getTableFormat(), actual.getTableFormat());
    assertEquals(expected.getStorageUri(), actual.getStorageUri());
    assertEquals(expected.getFileFormat(), actual.getFileFormat());
  }
}
