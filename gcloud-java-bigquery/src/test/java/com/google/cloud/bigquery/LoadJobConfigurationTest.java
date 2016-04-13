/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.common.collect.ImmutableList;
import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class LoadJobConfigurationTest {

  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder()
      .allowJaggedRows(true)
      .allowQuotedNewLines(false)
      .encoding(StandardCharsets.UTF_8)
      .build();
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final String FORMAT = "CSV";
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final List<String> PROJECTION_FIELDS = ImmutableList.of("field1", "field2");
  private static final Field FIELD_SCHEMA = Field.builder("IntegerField", Field.Type.integer())
      .mode(Field.Mode.REQUIRED)
      .description("FieldDescription")
      .build();
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA);
  private static final LoadJobConfiguration LOAD_CONFIGURATION =
      LoadJobConfiguration.builder(TABLE_ID, SOURCE_URIS)
          .createDisposition(CREATE_DISPOSITION)
          .writeDisposition(WRITE_DISPOSITION)
          .formatOptions(CSV_OPTIONS)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .maxBadRecords(MAX_BAD_RECORDS)
          .projectionFields(PROJECTION_FIELDS)
          .schema(TABLE_SCHEMA)
          .build();

  @Test
  public void testToBuilder() {
    compareLoadJobConfiguration(LOAD_CONFIGURATION, LOAD_CONFIGURATION.toBuilder().build());
    LoadJobConfiguration configuration = LOAD_CONFIGURATION.toBuilder()
        .destinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", configuration.destinationTable().table());
    configuration = configuration.toBuilder().destinationTable(TABLE_ID).build();
    compareLoadJobConfiguration(LOAD_CONFIGURATION, configuration);
  }

  @Test
  public void testOf() {
    LoadJobConfiguration configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
    assertEquals(TABLE_ID, configuration.destinationTable());
    assertEquals(SOURCE_URIS, configuration.sourceUris());
    configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS, CSV_OPTIONS);
    assertEquals(TABLE_ID, configuration.destinationTable());
    assertEquals(FORMAT, configuration.format());
    assertEquals(CSV_OPTIONS, configuration.csvOptions());
    assertEquals(SOURCE_URIS, configuration.sourceUris());
    configuration = LoadJobConfiguration.of(TABLE_ID, "uri1");
    assertEquals(TABLE_ID, configuration.destinationTable());
    assertEquals(ImmutableList.of("uri1"), configuration.sourceUris());
    configuration = LoadJobConfiguration.of(TABLE_ID, "uri1", CSV_OPTIONS);
    assertEquals(TABLE_ID, configuration.destinationTable());
    assertEquals(FORMAT, configuration.format());
    assertEquals(CSV_OPTIONS, configuration.csvOptions());
    assertEquals(ImmutableList.of("uri1"), configuration.sourceUris());
  }

  @Test
  public void testToBuilderIncomplete() {
    LoadJobConfiguration configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
    compareLoadJobConfiguration(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, LOAD_CONFIGURATION.destinationTable());
    assertEquals(CREATE_DISPOSITION, LOAD_CONFIGURATION.createDisposition());
    assertEquals(WRITE_DISPOSITION, LOAD_CONFIGURATION.writeDisposition());
    assertEquals(CSV_OPTIONS, LOAD_CONFIGURATION.csvOptions());
    assertEquals(FORMAT, LOAD_CONFIGURATION.format());
    assertEquals(IGNORE_UNKNOWN_VALUES, LOAD_CONFIGURATION.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, LOAD_CONFIGURATION.maxBadRecords());
    assertEquals(PROJECTION_FIELDS, LOAD_CONFIGURATION.projectionFields());
    assertEquals(TABLE_SCHEMA, LOAD_CONFIGURATION.schema());
  }

  @Test
  public void testToPbAndFromPb() {
    compareLoadJobConfiguration(LOAD_CONFIGURATION,
        LoadJobConfiguration.fromPb(LOAD_CONFIGURATION.toPb()));
    LoadJobConfiguration configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
    compareLoadJobConfiguration(configuration, LoadJobConfiguration.fromPb(configuration.toPb()));
  }

  @Test
  public void testSetProjectId() {
    LoadConfiguration configuration = LOAD_CONFIGURATION.setProjectId("p");
    assertEquals("p", configuration.destinationTable().project());
  }

  private void compareLoadJobConfiguration(LoadJobConfiguration expected,
      LoadJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.destinationTable(), value.destinationTable());
    assertEquals(expected.createDisposition(), value.createDisposition());
    assertEquals(expected.writeDisposition(), value.writeDisposition());
    assertEquals(expected.csvOptions(), value.csvOptions());
    assertEquals(expected.format(), value.format());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.maxBadRecords(), value.maxBadRecords());
    assertEquals(expected.projectionFields(), value.projectionFields());
    assertEquals(expected.schema(), value.schema());
  }
}
