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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class ExternalTableDefinitionTest {

  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final List<String> DECIMAL_TARGET_TYPES =
      ImmutableList.of("NUMERIC", "BIGNUMERIC", "STRING");
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", LegacySQLTypeName.STRING)
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", LegacySQLTypeName.INTEGER)
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", LegacySQLTypeName.RECORD, FIELD_SCHEMA1, FIELD_SCHEMA2)
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final String CONNECTION_ID = "123456789";
  private static final Boolean AUTODETECT = true;
  private static final AvroOptions AVRO_OPTIONS = AvroOptions.newBuilder().build();
  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder().build();
  private static final ParquetOptions PARQUET_OPTIONS = ParquetOptions.newBuilder().build();
  private static final HivePartitioningOptions HIVE_PARTITIONING_OPTIONS =
      HivePartitioningOptions.newBuilder()
          .setMode("AUTO")
          .setSourceUriPrefix(SOURCE_URIS.get(0))
          .build();
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .setDecimalTargetTypes(DECIMAL_TARGET_TYPES)
          .setCompression(COMPRESSION)
          .setConnectionId(CONNECTION_ID)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setAutodetect(AUTODETECT)
          .setHivePartitioningOptions(HIVE_PARTITIONING_OPTIONS)
          .build();

  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION_AVRO =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, AVRO_OPTIONS).build();

  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION_PARQUET =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, PARQUET_OPTIONS).build();

  @Test
  public void testToBuilder() {
    compareExternalTableDefinition(
        EXTERNAL_TABLE_DEFINITION, EXTERNAL_TABLE_DEFINITION.toBuilder().build());
    ExternalTableDefinition externalTableDefinition =
        EXTERNAL_TABLE_DEFINITION
            .toBuilder()
            .setCompression("NONE")
            .setConnectionId("00000")
            .build();
    assertEquals("NONE", externalTableDefinition.getCompression());
    assertEquals("00000", externalTableDefinition.getConnectionId());
    externalTableDefinition =
        externalTableDefinition
            .toBuilder()
            .setCompression(COMPRESSION)
            .setConnectionId(CONNECTION_ID)
            .build();
    compareExternalTableDefinition(EXTERNAL_TABLE_DEFINITION, externalTableDefinition);
  }

  @Test
  public void testToBuilderIncomplete() {
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.of(SOURCE_URIS, TABLE_SCHEMA, FormatOptions.json());
    assertEquals(externalTableDefinition, externalTableDefinition.toBuilder().build());
  }

  @Test
  public void testTypeNullPointerException() {
    try {
      EXTERNAL_TABLE_DEFINITION.toBuilder().setType(null).build();
    } catch (NullPointerException ex) {
      assertNotNull(ex.getMessage());
    }
  }

  @Test
  public void testBuilder() {
    assertEquals(TableDefinition.Type.EXTERNAL, EXTERNAL_TABLE_DEFINITION.getType());
    assertEquals(COMPRESSION, EXTERNAL_TABLE_DEFINITION.getCompression());
    assertEquals(CONNECTION_ID, EXTERNAL_TABLE_DEFINITION.getConnectionId());
    assertEquals(AVRO_OPTIONS, EXTERNAL_TABLE_DEFINITION_AVRO.getFormatOptions());
    assertEquals(CSV_OPTIONS, EXTERNAL_TABLE_DEFINITION.getFormatOptions());
    assertEquals(IGNORE_UNKNOWN_VALUES, EXTERNAL_TABLE_DEFINITION.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, EXTERNAL_TABLE_DEFINITION.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, EXTERNAL_TABLE_DEFINITION.getSchema());
    assertEquals(SOURCE_URIS, EXTERNAL_TABLE_DEFINITION.getSourceUris());
    assertEquals(DECIMAL_TARGET_TYPES, EXTERNAL_TABLE_DEFINITION.getDecimalTargetTypes());
    assertEquals(AUTODETECT, EXTERNAL_TABLE_DEFINITION.getAutodetect());
    assertEquals(HIVE_PARTITIONING_OPTIONS, EXTERNAL_TABLE_DEFINITION.getHivePartitioningOptions());
    assertNotEquals(EXTERNAL_TABLE_DEFINITION, TableDefinition.Type.EXTERNAL);
  }

  @Test
  public void testToAndFromPb() {
    compareExternalTableDefinition(
        EXTERNAL_TABLE_DEFINITION,
        ExternalTableDefinition.fromPb(EXTERNAL_TABLE_DEFINITION.toPb()));
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS).build();
    compareExternalTableDefinition(
        externalTableDefinition, ExternalTableDefinition.fromPb(externalTableDefinition.toPb()));
  }

  @Test
  public void testToAndFromPbParquet() {
    compareExternalTableDefinition(
        EXTERNAL_TABLE_DEFINITION_PARQUET,
        ExternalTableDefinition.fromPb(EXTERNAL_TABLE_DEFINITION_PARQUET.toPb()));
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, PARQUET_OPTIONS).build();
    compareExternalTableDefinition(
        externalTableDefinition, ExternalTableDefinition.fromPb(externalTableDefinition.toPb()));
  }

  private void compareExternalTableDefinition(
      ExternalTableDefinition expected, ExternalTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.getDecimalTargetTypes(), value.getDecimalTargetTypes());
    assertEquals(expected.getCompression(), value.getCompression());
    assertEquals(expected.getConnectionId(), value.getConnectionId());
    assertEquals(expected.getFormatOptions(), value.getFormatOptions());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.getMaxBadRecords(), value.getMaxBadRecords());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getSourceUris(), value.getSourceUris());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.getAutodetect(), value.getAutodetect());
    assertEquals(expected.getHivePartitioningOptions(), value.getHivePartitioningOptions());
  }
}
