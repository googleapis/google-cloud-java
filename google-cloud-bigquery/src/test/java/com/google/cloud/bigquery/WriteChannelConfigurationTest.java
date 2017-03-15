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
  private static final WriteChannelConfiguration LOAD_CONFIGURATION =
      WriteChannelConfiguration.newBuilder(TABLE_ID)
          .setCreateDisposition(CREATE_DISPOSITION)
          .setWriteDisposition(WRITE_DISPOSITION)
          .setFormatOptions(CSV_OPTIONS)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setSchema(TABLE_SCHEMA)
          .build();

  @Test
  public void testToBuilder() {
    compareLoadConfiguration(LOAD_CONFIGURATION, LOAD_CONFIGURATION.toBuilder().build());
    WriteChannelConfiguration configuration = LOAD_CONFIGURATION.toBuilder()
        .setDestinationTable(TableId.of("dataset", "newTable"))
        .build();
    assertEquals("newTable", configuration.getDestinationTable().getTable());
    configuration = configuration.toBuilder().setDestinationTable(TABLE_ID).build();
    compareLoadConfiguration(LOAD_CONFIGURATION, configuration);
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
    assertEquals(TABLE_ID, LOAD_CONFIGURATION.getDestinationTable());
    assertEquals(CREATE_DISPOSITION, LOAD_CONFIGURATION.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, LOAD_CONFIGURATION.getWriteDisposition());
    assertEquals(CSV_OPTIONS, LOAD_CONFIGURATION.getCsvOptions());
    assertEquals(FORMAT, LOAD_CONFIGURATION.getFormat());
    assertEquals(IGNORE_UNKNOWN_VALUES, LOAD_CONFIGURATION.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, LOAD_CONFIGURATION.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, LOAD_CONFIGURATION.getSchema());
    WriteChannelConfiguration loadConfiguration =
        WriteChannelConfiguration.newBuilder(TABLE_ID, CSV_OPTIONS)
            .setCreateDisposition(CREATE_DISPOSITION)
            .setWriteDisposition(WRITE_DISPOSITION)
            .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
            .setMaxBadRecords(MAX_BAD_RECORDS)
            .setSchema(TABLE_SCHEMA)
            .build();
    assertEquals(TABLE_ID, loadConfiguration.getDestinationTable());
    assertEquals(CREATE_DISPOSITION, loadConfiguration.getCreateDisposition());
    assertEquals(WRITE_DISPOSITION, loadConfiguration.getWriteDisposition());
    assertEquals(CSV_OPTIONS, loadConfiguration.getCsvOptions());
    assertEquals(FORMAT, loadConfiguration.getFormat());
    assertEquals(IGNORE_UNKNOWN_VALUES, loadConfiguration.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, loadConfiguration.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, loadConfiguration.getSchema());
  }


  @Test
  public void testToPbAndFromPb() {
    assertNull(LOAD_CONFIGURATION.toPb().getLoad().getSourceUris());
    compareLoadConfiguration(LOAD_CONFIGURATION,
        WriteChannelConfiguration.fromPb(LOAD_CONFIGURATION.toPb()));
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
  }
}
