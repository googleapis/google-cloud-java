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

package com.google.gcloud.bigquery;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class ExternalTableDefinitionTest {

  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Field FIELD_SCHEMA1 =
      Field.builder("StringField", Field.Type.string())
          .mode(Field.Mode.NULLABLE)
          .description("FieldDescription1")
          .build();
  private static final Field FIELD_SCHEMA2 =
      Field.builder("IntegerField", Field.Type.integer())
          .mode(Field.Mode.REPEATED)
          .description("FieldDescription2")
          .build();
  private static final Field FIELD_SCHEMA3 =
      Field.builder("RecordField", Field.Type.record(FIELD_SCHEMA1, FIELD_SCHEMA2))
          .mode(Field.Mode.REQUIRED)
          .description("FieldDescription3")
          .build();
  private static final Schema TABLE_SCHEMA = Schema.of(FIELD_SCHEMA1, FIELD_SCHEMA2, FIELD_SCHEMA3);
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder().build();
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .compression(COMPRESSION)
          .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .maxBadRecords(MAX_BAD_RECORDS)
          .build();

  @Test
  public void testToBuilder() {
    compareExternalTableDefinition(EXTERNAL_TABLE_DEFINITION,
        EXTERNAL_TABLE_DEFINITION.toBuilder().build());
    ExternalTableDefinition externalTableDefinition =
        EXTERNAL_TABLE_DEFINITION.toBuilder().compression("NONE").build();
    assertEquals("NONE", externalTableDefinition.compression());
    externalTableDefinition = externalTableDefinition.toBuilder()
        .compression(COMPRESSION)
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
    assertEquals(BaseTableDefinition.Type.EXTERNAL, EXTERNAL_TABLE_DEFINITION.type());
    assertEquals(COMPRESSION, EXTERNAL_TABLE_DEFINITION.compression());
    assertEquals(CSV_OPTIONS, EXTERNAL_TABLE_DEFINITION.formatOptions());
    assertEquals(IGNORE_UNKNOWN_VALUES, EXTERNAL_TABLE_DEFINITION.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, EXTERNAL_TABLE_DEFINITION.maxBadRecords());
    assertEquals(TABLE_SCHEMA, EXTERNAL_TABLE_DEFINITION.schema());
    assertEquals(SOURCE_URIS, EXTERNAL_TABLE_DEFINITION.sourceUris());
  }

  @Test
  public void testToAndFromPb() {
    compareExternalTableDefinition(EXTERNAL_TABLE_DEFINITION,
        ExternalTableDefinition.fromPb(EXTERNAL_TABLE_DEFINITION.toPb()));
    ExternalTableDefinition externalTableDefinition =
        ExternalTableDefinition.builder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS).build();
    compareExternalTableDefinition(externalTableDefinition,
        ExternalTableDefinition.fromPb(externalTableDefinition.toPb()));
  }

  private void compareExternalTableDefinition(ExternalTableDefinition expected,
      ExternalTableDefinition value) {
    assertEquals(expected, value);
    assertEquals(expected.compression(), value.compression());
    assertEquals(expected.formatOptions(), value.formatOptions());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.maxBadRecords(), value.maxBadRecords());
    assertEquals(expected.schema(), value.schema());
    assertEquals(expected.sourceUris(), value.sourceUris());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
