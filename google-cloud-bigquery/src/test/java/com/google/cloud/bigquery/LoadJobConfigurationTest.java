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

import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.cloud.bigquery.JobInfo.SchemaUpdateOption;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class LoadJobConfigurationTest {

  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder()
      .setAllowJaggedRows(true)
      .setAllowQuotedNewLines(false)
      .setEncoding(StandardCharsets.UTF_8)
      .build();
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final String FORMAT = "CSV";
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final Field FIELD_SCHEMA = Field.newBuilder("IntegerField", Field.Type.integer())
      .setMode(Field.Mode.REQUIRED)
      .setDescription("FieldDescription")
      .build();
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final List<SchemaUpdateOption> SCHEMA_UPDATE_OPTIONS =
          ImmutableList.of(SchemaUpdateOption.ALLOW_FIELD_ADDITION);
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA);
  private static final Boolean AUTODETECT = true;
  private static final LoadJobConfiguration LOAD_CONFIGURATION_CSV =
      LoadJobConfiguration.newBuilder(TABLE_ID, SOURCE_URIS)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setFormatOptions(CSV_OPTIONS)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setSchema(TABLE_SCHEMA)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .setAutodetect(AUTODETECT)
          .build();
  private static final DatastoreBackupOptions BACKUP_OPTIONS = DatastoreBackupOptions.newBuilder()
      .setProjectionFields(ImmutableList.of("field_1", "field_2"))
      .build();
  private static final LoadJobConfiguration LOAD_CONFIGURATION_BACKUP =
      LoadJobConfiguration.newBuilder(TABLE_ID, SOURCE_URIS)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setFormatOptions(BACKUP_OPTIONS)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setSchema(TABLE_SCHEMA)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .setAutodetect(AUTODETECT)
          .build();

  @Test
  public void testToBuilder() {
    compareLoadJobConfiguration(
        LOAD_CONFIGURATION_CSV, LOAD_CONFIGURATION_CSV.toBuilder().build());
    LoadJobConfiguration configurationCSV = LOAD_CONFIGURATION_CSV.toBuilder()
        .setDestinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", configurationCSV.getDestinationTable().getTable());
    configurationCSV = configurationCSV.toBuilder().setDestinationTable(TABLE_ID).build();
    compareLoadJobConfiguration(LOAD_CONFIGURATION_CSV, configurationCSV);

    compareLoadJobConfiguration(
        LOAD_CONFIGURATION_BACKUP, LOAD_CONFIGURATION_BACKUP.toBuilder().build());
    LoadJobConfiguration configurationBackup = LOAD_CONFIGURATION_BACKUP.toBuilder()
        .setDestinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", configurationBackup.getDestinationTable().getTable());
    configurationBackup = configurationBackup.toBuilder().setDestinationTable(TABLE_ID).build();
    compareLoadJobConfiguration(LOAD_CONFIGURATION_BACKUP, configurationBackup);
  }

  @Test
  public void testOf() {
    LoadJobConfiguration configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
    assertEquals(TABLE_ID, configuration.getDestinationTable());
    assertEquals(SOURCE_URIS, configuration.getSourceUris());
    configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS, CSV_OPTIONS);
    assertEquals(TABLE_ID, configuration.getDestinationTable());
    assertEquals(FORMAT, configuration.getFormat());
    assertEquals(CSV_OPTIONS, configuration.getCsvOptions());
    assertEquals(SOURCE_URIS, configuration.getSourceUris());
    configuration = LoadJobConfiguration.of(TABLE_ID, "uri1");
    assertEquals(TABLE_ID, configuration.getDestinationTable());
    assertEquals(ImmutableList.of("uri1"), configuration.getSourceUris());
    configuration = LoadJobConfiguration.of(TABLE_ID, "uri1", CSV_OPTIONS);
    assertEquals(TABLE_ID, configuration.getDestinationTable());
    assertEquals(FORMAT, configuration.getFormat());
    assertEquals(CSV_OPTIONS, configuration.getCsvOptions());
    assertEquals(ImmutableList.of("uri1"), configuration.getSourceUris());
  }

  @Test
  public void testToBuilderIncomplete() {
    LoadJobConfiguration configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
    compareLoadJobConfiguration(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testToPbAndFromPb() {
    compareLoadJobConfiguration(LOAD_CONFIGURATION_CSV,
        LoadJobConfiguration.fromPb(LOAD_CONFIGURATION_CSV.toPb()));
    LoadJobConfiguration configuration = LoadJobConfiguration.of(TABLE_ID, SOURCE_URIS);
    compareLoadJobConfiguration(configuration, LoadJobConfiguration.fromPb(configuration.toPb()));
  }

  @Test
  public void testSetProjectId() {
    LoadConfiguration configuration = LOAD_CONFIGURATION_CSV.setProjectId("p");
    assertEquals("p", configuration.getDestinationTable().getProject());
  }

  @Test
  public void testGetType() {
    assertEquals(JobConfiguration.Type.LOAD, LOAD_CONFIGURATION_CSV.getType());
  }

  private void compareLoadJobConfiguration(LoadJobConfiguration expected,
      LoadJobConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getDestinationTable(), value.getDestinationTable());
    assertEquals(expected.getCreateDisposition(), value.getCreateDisposition());
    assertEquals(expected.getWriteDisposition(), value.getWriteDisposition());
    assertEquals(expected.getCsvOptions(), value.getCsvOptions());
    assertEquals(expected.getFormat(), value.getFormat());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.getMaxBadRecords(), value.getMaxBadRecords());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getDatastoreBackupOptions(), value.getDatastoreBackupOptions());
    assertEquals(expected.getAutodetect(), value.getAutodetect());
    assertEquals(expected.getSchemaUpdateOptions(), value.getSchemaUpdateOptions());
  }
}
