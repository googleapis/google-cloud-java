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

import org.junit.Test;

import java.util.List;

public class ExternalTableDefinitionTest {

  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Field FIELD_SCHEMA1 =
      Field.newBuilder("StringField", Field.Type.string())
          .setMode(Field.Mode.NULLABLE)
          .setDescription("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.newBuilder("IntegerField", Field.Type.integer())
          .setMode(Field.Mode.REPEATED)
          .setDescription("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.newBuilder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .setMode(Field.Mode.REQUIRED)
          .setDescription("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final Boolean AUTODETECT = true;
  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder().build();
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .setCompression(COMPRESSION)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .setAutodetect(AUTODETECT)
          .build();

  @Test
  public void testToBuilder() {
    compareExternalTableDefinition(EXTERNAL_TABLE_DEFINITION,
        EXTERNAL_TABLE_DEFINITION.toBuilder().build());
    ExternalTableDefinition externalTableDefinition =
        EXTERNAL_TABLE_DEFINITION.toBuilder().setCompression("NONE").build();
    assertEquals("NONE", externalTableDefinition.getCompression());
    externalTableDefinition = externalTableDefinition.toBuilder()
        .setCompression(COMPRESSION)
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
  public void testBuilder() {
    assertEquals(TableDefinition.Type.EXTERNAL, EXTERNAL_TABLE_DEFINITION.getType());
    assertEquals(COMPRESSION, EXTERNAL_TABLE_DEFINITION.getCompression());
    assertEquals(CSV_OPTIONS, EXTERNAL_TABLE_DEFINITION.getFormatOptions());
    assertEquals(IGNORE_UNKNOWN_VALUES, EXTERNAL_TABLE_DEFINITION.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, EXTERNAL_TABLE_DEFINITION.getMaxBadRecords());
    assertEquals(TABLE_SCHEMA, EXTERNAL_TABLE_DEFINITION.getSchema());
    assertEquals(SOURCE_URIS, EXTERNAL_TABLE_DEFINITION.getSourceUris());
    assertEquals(AUTODETECT, EXTERNAL_TABLE_DEFINITION.getAutodetect());
  }


  @Test
  public void testToAndFromPb() {
    compareExternalTableDefinition(EXTERNAL_TABLE_DEFINITION,
        ExternalTableDefinition.fromPb(EXTERNAL_TABLE_DEFINITION.toPb()));
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS).build();
    compareExternalTableDefinition(externalTableDefinition,
        ExternalTableDefinition.fromPb(externalTableDefinition.toPb()));
  }

  private void compareExternalTableDefinition(ExternalTableDefinition expected,
      ExternalTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.getCompression(), value.getCompression());
    assertEquals(expected.getFormatOptions(), value.getFormatOptions());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.getMaxBadRecords(), value.getMaxBadRecords());
    assertEquals(expected.getSchema(), value.getSchema());
    assertEquals(expected.getSourceUris(), value.getSourceUris());
    assertEquals(expected.hashCode(), value.hashCode());
    assertEquals(expected.getAutodetect(), value.getAutodetect());
  }
}
