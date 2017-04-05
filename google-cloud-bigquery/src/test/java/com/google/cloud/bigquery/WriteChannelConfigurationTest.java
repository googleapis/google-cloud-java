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

package com.google.cloud.bigquery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.bigquery.JobInfo.CreateDisposition;
import com.google.cloud.bigquery.JobInfo.WriteDisposition;
import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class WriteChannelConfigurationTest {

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
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA);
  private static final Boolean AUTODETECT = true;
  private static final List<JobInfo.SchemaUpdateOption> SCHEMA_UPDATE_OPTIONS =
      ImmutableList.of(JobInfo.SchemaUpdateOption.ALLOW_FIELD_ADDITION);
  private static final WriteChannelConfiguration LOAD_CONFIGURATION_CSV =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
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
  private static final WriteChannelConfiguration LOAD_CONFIGURATION_BACKUP =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
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
    compareLoadConfiguration(LOAD_CONFIGURATION_CSV, LOAD_CONFIGURATION_CSV.toBuilder().build());
    WriteChannelConfiguration configuration = LOAD_CONFIGURATION_CSV.toBuilder()
        .setDestinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", configuration.getDestinationTable().getTable());
    configuration = configuration.toBuilder().setDestinationTable(TABLE_ID).build();
    compareLoadConfiguration(LOAD_CONFIGURATION_CSV, configuration);
  }

  @Test
  public void testOf() {
    WriteChannelConfiguration configuration = WriteChannelConfiguration.of(TABLE_ID);
    assertEquals(TABLE_ID, configuration.getDestinationTable());
    configuration = WriteChannelConfiguration.of(TABLE_ID, CSV_OPTIONS);
    assertEquals(TABLE_ID, configuration.getDestinationTable());
    assertEquals(FORMAT, configuration.getFormat());
    assertEquals(CSV_OPTIONS, configuration.getCsvOptions());
  }

  @Test
  public void testToBuilderIncomplete() {
    WriteChannelConfiguration configuration = WriteChannelConfiguration.of(TABLE_ID);
    compareLoadConfiguration(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, LOAD_CONFIGURATION_CSV.getDestinationTable());
    assertEquals(CREATE_DISPOSITION, LOAD_CONFIGURATION_CSV.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, LOAD_CONFIGURATION_CSV.getWriteDisposition());
    assertEquals(CSV_OPTIONS, LOAD_CONFIGURATION_CSV.getCsvOptions());
    assertEquals(FORMAT, LOAD_CONFIGURATION_CSV.getFormat());
    assertEquals(IGNORE_UNKNOWN_VALUES, LOAD_CONFIGURATION_CSV.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, LOAD_CONFIGURATION_CSV.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, LOAD_CONFIGURATION_CSV.getSchema());
    assertEquals(BACKUP_OPTIONS, LOAD_CONFIGURATION_BACKUP.getDatastoreBackupOptions());
    assertEquals(SCHEMA_UPDATE_OPTIONS, LOAD_CONFIGURATION_CSV.getSchemaUpdateOptions());
    assertEquals(SCHEMA_UPDATE_OPTIONS, LOAD_CONFIGURATION_BACKUP.getSchemaUpdateOptions());
    WriteChannelConfiguration.Builder builder =
        WriteChannelConfiguration.newBuilder(TABLE_ID, CSV_OPTIONS)
            .setCreateDisposition(CREATE_DISPOSITION)
            .setWriteDisposition(WRITE_DISPOSITION)
            .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
            .setMaxBadRecords(MAX_BAD_RECORDS)
            .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
            .setSchema(TABLE_SCHEMA)
            .setAutodetect(AUTODETECT);
    WriteChannelConfiguration loadConfigurationCSV = builder.build();
    assertEquals(TABLE_ID, loadConfigurationCSV.getDestinationTable());
    assertEquals(CREATE_DISPOSITION, loadConfigurationCSV.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, loadConfigurationCSV.getWriteDisposition());
    assertEquals(CSV_OPTIONS, loadConfigurationCSV.getCsvOptions());
    assertEquals(FORMAT, loadConfigurationCSV.getFormat());
    assertEquals(IGNORE_UNKNOWN_VALUES, loadConfigurationCSV.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, loadConfigurationCSV.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, loadConfigurationCSV.getSchema());
    assertEquals(SCHEMA_UPDATE_OPTIONS, loadConfigurationCSV.getSchemaUpdateOptions());
    assertEquals(AUTODETECT, loadConfigurationCSV.getAutodetect());
    builder.setFormatOptions(BACKUP_OPTIONS);
    WriteChannelConfiguration loadConfigurationBackup = builder.build();
    assertEquals(BACKUP_OPTIONS, loadConfigurationBackup.getDatastoreBackupOptions());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNull(LOAD_CONFIGURATION_CSV.toPb().getLoad().getSourceUris());
    compareLoadConfiguration(LOAD_CONFIGURATION_CSV,
        WriteChannelConfiguration.fromPb(LOAD_CONFIGURATION_CSV.toPb()));
    WriteChannelConfiguration configuration = WriteChannelConfiguration.of(TABLE_ID);
    compareLoadConfiguration(configuration, WriteChannelConfiguration.fromPb(configuration.toPb()));
  }

  private void compareLoadConfiguration(WriteChannelConfiguration expected,
      WriteChannelConfiguration value) {
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
    assertEquals(expected.getDatastoreBackupOptions(), value.getDatastoreBackupOptions());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getSchemaUpdateOptions(), value.getSchemaUpdateOptions());
    assertEquals(expected.getAutodetect(), value.getAutodetect());
  }
}
