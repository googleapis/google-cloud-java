/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class ExtractJobConfigurationTest {

  private static final List<String> DESTINATION_URIS = ImmutableList.of("uri1", "uri2");
  private static final String DESTINATION_URI = "uri1";
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final String FIELD_DELIMITER = ",";
  private static final String FORMAT = "CSV";
  private static final String JSON_FORMAT = "NEWLINE_DELIMITED_JSON";
  private static final Boolean PRINT_HEADER = true;
  private static final String COMPRESSION = "GZIP";
  private static final ExtractJobConfiguration EXTRACT_CONFIGURATION =
      ExtractJobConfiguration.builder(TABLE_ID, DESTINATION_URIS)
          .printHeader(PRINT_HEADER)
          .fieldDelimiter(FIELD_DELIMITER)
          .compression(COMPRESSION)
          .format(FORMAT)
          .build();
  private static final ExtractJobConfiguration EXTRACT_CONFIGURATION_ONE_URI =
      ExtractJobConfiguration.builder(TABLE_ID, DESTINATION_URI)
          .printHeader(PRINT_HEADER)
          .fieldDelimiter(FIELD_DELIMITER)
          .compression(COMPRESSION)
          .format(FORMAT)
          .build();

  @Test
  public void testToBuilder() {
    compareExtractJobConfiguration(
        EXTRACT_CONFIGURATION, EXTRACT_CONFIGURATION.toBuilder().build());
    ExtractJobConfiguration job = EXTRACT_CONFIGURATION.toBuilder()
        .sourceTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", job.sourceTable().table());
    job = job.toBuilder().sourceTable(TABLE_ID).build();
    compareExtractJobConfiguration(EXTRACT_CONFIGURATION, job);
  }

  @Test
  public void testOf() {
    ExtractJobConfiguration job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS);
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(DESTINATION_URIS, job.destinationUris());
    job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URI);
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI), job.destinationUris());
    job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS, JSON_FORMAT);
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(DESTINATION_URIS, job.destinationUris());
    assertEquals(JSON_FORMAT, job.format());
    job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URI, JSON_FORMAT);
    assertEquals(TABLE_ID, job.sourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI), job.destinationUris());
    assertEquals(JSON_FORMAT, job.format());
  }

  @Test
  public void testToBuilderIncomplete() {
    ExtractJobConfiguration job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS);
    compareExtractJobConfiguration(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, EXTRACT_CONFIGURATION.sourceTable());
    assertEquals(DESTINATION_URIS, EXTRACT_CONFIGURATION.destinationUris());
    assertEquals(FIELD_DELIMITER, EXTRACT_CONFIGURATION.fieldDelimiter());
    assertEquals(COMPRESSION, EXTRACT_CONFIGURATION.compression());
    assertEquals(PRINT_HEADER, EXTRACT_CONFIGURATION.printHeader());
    assertEquals(FORMAT, EXTRACT_CONFIGURATION.format());
    assertEquals(TABLE_ID, EXTRACT_CONFIGURATION_ONE_URI.sourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI),
        EXTRACT_CONFIGURATION_ONE_URI.destinationUris());
    assertEquals(FIELD_DELIMITER, EXTRACT_CONFIGURATION_ONE_URI.fieldDelimiter());
    assertEquals(COMPRESSION, EXTRACT_CONFIGURATION_ONE_URI.compression());
    assertEquals(PRINT_HEADER, EXTRACT_CONFIGURATION_ONE_URI.printHeader());
    assertEquals(FORMAT, EXTRACT_CONFIGURATION_ONE_URI.format());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(EXTRACT_CONFIGURATION.toPb().getExtract());
    assertNull(EXTRACT_CONFIGURATION.toPb().getCopy());
    assertNull(EXTRACT_CONFIGURATION.toPb().getLoad());
    assertNull(EXTRACT_CONFIGURATION.toPb().getQuery());
    compareExtractJobConfiguration(EXTRACT_CONFIGURATION,
        ExtractJobConfiguration.fromPb(EXTRACT_CONFIGURATION.toPb()));
    compareExtractJobConfiguration(EXTRACT_CONFIGURATION_ONE_URI,
        ExtractJobConfiguration.fromPb(EXTRACT_CONFIGURATION_ONE_URI.toPb()));
    ExtractJobConfiguration job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS);
    compareExtractJobConfiguration(job, ExtractJobConfiguration.fromPb(job.toPb()));
  }

  private void compareExtractJobConfiguration(ExtractJobConfiguration expected,
      ExtractJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.sourceTable(), value.sourceTable());
    assertEquals(expected.destinationUris(), value.destinationUris());
    assertEquals(expected.compression(), value.compression());
    assertEquals(expected.printHeader(), value.printHeader());
    assertEquals(expected.fieldDelimiter(), value.fieldDelimiter());
    assertEquals(expected.format(), value.format());
  }
}
