/*
 * Copyright 2016 Google LLC
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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

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
      ExtractJobConfiguration.newBuilder(TABLE_ID, DESTINATION_URIS)
          .setPrintHeader(PRINT_HEADER)
          .setFieldDelimiter(FIELD_DELIMITER)
          .setCompression(COMPRESSION)
          .setFormat(FORMAT)
          .build();
  private static final ExtractJobConfiguration EXTRACT_CONFIGURATION_ONE_URI =
      ExtractJobConfiguration.newBuilder(TABLE_ID, DESTINATION_URI)
          .setPrintHeader(PRINT_HEADER)
          .setFieldDelimiter(FIELD_DELIMITER)
          .setCompression(COMPRESSION)
          .setFormat(FORMAT)
          .build();

  @Test
  public void testToBuilder() {
    compareExtractJobConfiguration(
        EXTRACT_CONFIGURATION, EXTRACT_CONFIGURATION.toBuilder().build());
    ExtractJobConfiguration job =
        EXTRACT_CONFIGURATION.toBuilder().setSourceTable(TableId.of("dataset", "newTable")).build();
    assertEquals("newTable", job.getSourceTable().getTable());
    job = job.toBuilder().setSourceTable(TABLE_ID).build();
    compareExtractJobConfiguration(EXTRACT_CONFIGURATION, job);
  }

  @Test
  public void testOf() {
    ExtractJobConfiguration job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS);
    assertEquals(TABLE_ID, job.getSourceTable());
    assertEquals(DESTINATION_URIS, job.getDestinationUris());
    job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URI);
    assertEquals(TABLE_ID, job.getSourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI), job.getDestinationUris());
    job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS, JSON_FORMAT);
    assertEquals(TABLE_ID, job.getSourceTable());
    assertEquals(DESTINATION_URIS, job.getDestinationUris());
    assertEquals(JSON_FORMAT, job.getFormat());
    job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URI, JSON_FORMAT);
    assertEquals(TABLE_ID, job.getSourceTable());
    assertEquals(ImmutableList.of(DESTINATION_URI), job.getDestinationUris());
    assertEquals(JSON_FORMAT, job.getFormat());
  }

  @Test
  public void testToBuilderIncomplete() {
    ExtractJobConfiguration job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS);
    compareExtractJobConfiguration(job, job.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, EXTRACT_CONFIGURATION.getSourceTable());
    assertEquals(DESTINATION_URIS, EXTRACT_CONFIGURATION.getDestinationUris());
    assertEquals(FIELD_DELIMITER, EXTRACT_CONFIGURATION.getFieldDelimiter());
    assertEquals(COMPRESSION, EXTRACT_CONFIGURATION.getCompression());
    assertEquals(PRINT_HEADER, EXTRACT_CONFIGURATION.printHeader());
    assertEquals(FORMAT, EXTRACT_CONFIGURATION.getFormat());
    assertEquals(TABLE_ID, EXTRACT_CONFIGURATION_ONE_URI.getSourceTable());
    assertEquals(
        ImmutableList.of(DESTINATION_URI), EXTRACT_CONFIGURATION_ONE_URI.getDestinationUris());
    assertEquals(FIELD_DELIMITER, EXTRACT_CONFIGURATION_ONE_URI.getFieldDelimiter());
    assertEquals(COMPRESSION, EXTRACT_CONFIGURATION_ONE_URI.getCompression());
    assertEquals(PRINT_HEADER, EXTRACT_CONFIGURATION_ONE_URI.printHeader());
    assertEquals(FORMAT, EXTRACT_CONFIGURATION_ONE_URI.getFormat());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNotNull(EXTRACT_CONFIGURATION.toPb().getExtract());
    assertNull(EXTRACT_CONFIGURATION.toPb().getCopy());
    assertNull(EXTRACT_CONFIGURATION.toPb().getLoad());
    assertNull(EXTRACT_CONFIGURATION.toPb().getQuery());
    compareExtractJobConfiguration(
        EXTRACT_CONFIGURATION, ExtractJobConfiguration.fromPb(EXTRACT_CONFIGURATION.toPb()));
    compareExtractJobConfiguration(
        EXTRACT_CONFIGURATION_ONE_URI,
        ExtractJobConfiguration.fromPb(EXTRACT_CONFIGURATION_ONE_URI.toPb()));
    ExtractJobConfiguration job = ExtractJobConfiguration.of(TABLE_ID, DESTINATION_URIS);
    compareExtractJobConfiguration(job, ExtractJobConfiguration.fromPb(job.toPb()));
  }

  @Test
  public void testSetProjectId() {
    ExtractJobConfiguration configuration = EXTRACT_CONFIGURATION.setProjectId("p");
    assertEquals("p", configuration.getSourceTable().getProject());
  }

  @Test
  public void testGetType() {
    assertEquals(JobConfiguration.Type.EXTRACT, EXTRACT_CONFIGURATION.getType());
    assertEquals(JobConfiguration.Type.EXTRACT, EXTRACT_CONFIGURATION_ONE_URI.getType());
  }

  private void compareExtractJobConfiguration(
      ExtractJobConfiguration expected, ExtractJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getSourceTable(), value.getSourceTable());
    assertEquals(expected.getDestinationUris(), value.getDestinationUris());
    assertEquals(expected.getCompression(), value.getCompression());
    assertEquals(expected.printHeader(), value.printHeader());
    assertEquals(expected.getFieldDelimiter(), value.getFieldDelimiter());
    assertEquals(expected.getFormat(), value.getFormat());
  }
}
