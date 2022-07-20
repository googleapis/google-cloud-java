/*
 * Copyright 2015 Google LLC
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
import com.google.cloud.bigquery.TimePartitioning.Type;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class WriteChannelConfigurationTest {

  private static final CsvOptions CSV_OPTIONS =
      CsvOptions.newBuilder()
          .setAllowJaggedRows(true)
          .setAllowQuotedNewLines(false)
          .setEncoding(StandardCharsets.UTF_8)
          .build();
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final CreateDisposition CREATE_DISPOSITION = CreateDisposition.CREATE_IF_NEEDED;
  private static final WriteDisposition WRITE_DISPOSITION = WriteDisposition.WRITE_APPEND;
  private static final String NULL_MARKER = "\\N";
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final String FORMAT = "CSV";
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final Field FIELD_SCHEMA =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA);
  private static final Boolean AUTODETECT = true;
  private static final Boolean USERAVROLOGICALTYPES = true;
  private static final List<JobInfo.SchemaUpdateOption> SCHEMA_UPDATE_OPTIONS =
      ImmutableList.of(JobInfo.SchemaUpdateOption.ALLOW_FIELD_ADDITION);
  private static final TimePartitioning TIME_PARTITIONING = TimePartitioning.of(Type.DAY);
  private static final Clustering CLUSTERING =
      Clustering.newBuilder().setFields(ImmutableList.of("Foo", "Bar")).build();
  private static final Map<String, String> LABELS =
      ImmutableMap.of("test-job-name", "test-write-channel");
  private static final List<String> DECIMAL_TARGET_TYPES =
      ImmutableList.of("NUMERIC", "BIGNUMERIC");
  private static final WriteChannelConfiguration LOAD_CONFIGURATION_CSV =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setNullMarker(NULL_MARKER)
          .setFormatOptions(CSV_OPTIONS)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setSchema(TABLE_SCHEMA)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .setAutodetect(AUTODETECT)
          .setTimePartitioning(TIME_PARTITIONING)
          .setClustering(CLUSTERING)
          .setLabels(LABELS)
          .setDecimalTargetTypes(DECIMAL_TARGET_TYPES)
          .build();

  private static final DatastoreBackupOptions BACKUP_OPTIONS =
      DatastoreBackupOptions.newBuilder()
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
  private static final WriteChannelConfiguration LOAD_CONFIGURATION_AVRO =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setNullMarker(NULL_MARKER)
          .setFormatOptions(FormatOptions.avro())
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setSchema(TABLE_SCHEMA)
          .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
          .setAutodetect(AUTODETECT)
          .setTimePartitioning(TIME_PARTITIONING)
          .setClustering(CLUSTERING)
          .setUseAvroLogicalTypes(USERAVROLOGICALTYPES)
          .setDecimalTargetTypes(DECIMAL_TARGET_TYPES)
          .build();

  @Test
  public void testToBuilder() {
    compareLoadConfiguration(LOAD_CONFIGURATION_CSV, LOAD_CONFIGURATION_CSV.toBuilder().build());
    WriteChannelConfiguration configuration =
        LOAD_CONFIGURATION_CSV
            .toBuilder()
            .setDestinationTable(TableId.of("dataset", "newTable"))
            .build();
    assertEquals("newTable", configuration.getDestinationTable().getTable());
    configuration = configuration.toBuilder().setDestinationTable(TABLE_ID).build();
    compareLoadConfiguration(LOAD_CONFIGURATION_CSV, configuration);

    compareLoadConfiguration(LOAD_CONFIGURATION_AVRO, LOAD_CONFIGURATION_AVRO.toBuilder().build());
    WriteChannelConfiguration configurationAvro =
        LOAD_CONFIGURATION_AVRO
            .toBuilder()
            .setDestinationTable(TableId.of("dataset", "newTable"))
            .build();
    assertEquals("newTable", configurationAvro.getDestinationTable().getTable());
    configurationAvro = configurationAvro.toBuilder().setDestinationTable(TABLE_ID).build();
    compareLoadConfiguration(LOAD_CONFIGURATION_AVRO, configurationAvro);
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
    assertEquals(NULL_MARKER, LOAD_CONFIGURATION_CSV.getNullMarker());
    assertEquals(CSV_OPTIONS, LOAD_CONFIGURATION_CSV.getCsvOptions());
    assertEquals(FORMAT, LOAD_CONFIGURATION_CSV.getFormat());
    assertEquals(IGNORE_UNKNOWN_VALUES, LOAD_CONFIGURATION_CSV.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, LOAD_CONFIGURATION_CSV.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, LOAD_CONFIGURATION_CSV.getSchema());
    assertEquals(LABELS, LOAD_CONFIGURATION_CSV.getLabels());
    assertEquals(BACKUP_OPTIONS, LOAD_CONFIGURATION_BACKUP.getDatastoreBackupOptions());
    assertEquals(SCHEMA_UPDATE_OPTIONS, LOAD_CONFIGURATION_CSV.getSchemaUpdateOptions());
    assertEquals(SCHEMA_UPDATE_OPTIONS, LOAD_CONFIGURATION_BACKUP.getSchemaUpdateOptions());
    WriteChannelConfiguration.Builder builder =
        WriteChannelConfiguration.newBuilder(TABLE_ID, CSV_OPTIONS)
            .setCreateDisposition(CREATE_DISPOSITION)
            .setWriteDisposition(WRITE_DISPOSITION)
            .setNullMarker(NULL_MARKER)
            .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
            .setMaxBadRecords(MAX_BAD_RECORDS)
            .setSchemaUpdateOptions(SCHEMA_UPDATE_OPTIONS)
            .setSchema(TABLE_SCHEMA)
            .setAutodetect(AUTODETECT)
            .setDecimalTargetTypes(DECIMAL_TARGET_TYPES);
    WriteChannelConfiguration loadConfigurationCSV = builder.build();
    assertEquals(TABLE_ID, loadConfigurationCSV.getDestinationTable());
    assertEquals(CREATE_DISPOSITION, loadConfigurationCSV.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, loadConfigurationCSV.getWriteDisposition());
    assertEquals(NULL_MARKER, loadConfigurationCSV.getNullMarker());
    assertEquals(CSV_OPTIONS, loadConfigurationCSV.getCsvOptions());
    assertEquals(FORMAT, loadConfigurationCSV.getFormat());
    assertEquals(IGNORE_UNKNOWN_VALUES, loadConfigurationCSV.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, loadConfigurationCSV.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, loadConfigurationCSV.getSchema());
    assertEquals(SCHEMA_UPDATE_OPTIONS, loadConfigurationCSV.getSchemaUpdateOptions());
    assertEquals(AUTODETECT, loadConfigurationCSV.getAutodetect());
    assertEquals(DECIMAL_TARGET_TYPES, loadConfigurationCSV.getDecimalTargetTypes());
    builder.setFormatOptions(BACKUP_OPTIONS);
    WriteChannelConfiguration loadConfigurationBackup = builder.build();
    assertEquals(BACKUP_OPTIONS, loadConfigurationBackup.getDatastoreBackupOptions());
  }

  @Test
  public void testToPbAndFromPb() {
    assertNull(LOAD_CONFIGURATION_CSV.toPb().getLoad().getSourceUris());
    compareLoadConfiguration(
        LOAD_CONFIGURATION_CSV, WriteChannelConfiguration.fromPb(LOAD_CONFIGURATION_CSV.toPb()));
    WriteChannelConfiguration configuration = WriteChannelConfiguration.of(TABLE_ID);
    compareLoadConfiguration(configuration, WriteChannelConfiguration.fromPb(configuration.toPb()));
  }

  @Test
  public void testSetProjectIdDoNotOverride() {
    WriteChannelConfiguration configuration =
        WriteChannelConfiguration.of(TABLE_ID).setProjectId("project");
    configuration.setProjectId("different-project").toBuilder();
    assertEquals("project", configuration.getDestinationTable().getProject());
  }

  private void compareLoadConfiguration(
      WriteChannelConfiguration expected, WriteChannelConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.getDestinationTable(), value.getDestinationTable());
    assertEquals(expected.getCreateDisposition(), value.getCreateDisposition());
    assertEquals(expected.getWriteDisposition(), value.getWriteDisposition());
    assertEquals(expected.getNullMarker(), value.getNullMarker());
    assertEquals(expected.getCsvOptions(), value.getCsvOptions());
    assertEquals(expected.getFormat(), value.getFormat());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.getMaxBadRecords(), value.getMaxBadRecords());
    assertEquals(expected.getDatastoreBackupOptions(), value.getDatastoreBackupOptions());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getSchemaUpdateOptions(), value.getSchemaUpdateOptions());
    assertEquals(expected.getAutodetect(), value.getAutodetect());
    assertEquals(expected.getTimePartitioning(), value.getTimePartitioning());
    assertEquals(expected.getClustering(), value.getClustering());
    assertEquals(expected.getUseAvroLogicalTypes(), value.getUseAvroLogicalTypes());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.getDecimalTargetTypes(), value.getDecimalTargetTypes());
  }
}
