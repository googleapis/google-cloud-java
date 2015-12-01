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

import com.google.common.collect.ImmutableList;

import org.junit.Test;

import java.util.List;

public class ExternalDataConfigurationTest {

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
  private static final String SOURCE_FORMAT = "CSV";
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.builder().build();
  private static final ExternalDataConfiguration CONFIGURATION = ExternalDataConfiguration
      .builder(SOURCE_URIS, TABLE_SCHEMA, SOURCE_FORMAT)
      .compression(COMPRESSION)
      .csvOptions(CSV_OPTIONS)
      .ignoreUnknownValues(IGNORE_UNKNOWN_VALUES)
      .maxBadRecords(MAX_BAD_RECORDS)
      .build();

  @Test
  public void testToBuilder() {
    compareConfiguration(CONFIGURATION, CONFIGURATION.toBuilder().build());
    ExternalDataConfiguration configuration = CONFIGURATION.toBuilder().compression("NONE").build();
    assertEquals("NONE", configuration.compression());
    configuration = configuration.toBuilder()
        .compression(COMPRESSION)
        .build();
    compareConfiguration(CONFIGURATION, configuration);
  }

  @Test
  public void testToBuilderIncomplete() {
    ExternalDataConfiguration configuration =
        ExternalDataConfiguration.of(SOURCE_URIS, TABLE_SCHEMA, SOURCE_FORMAT);
    assertEquals(configuration, configuration.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(COMPRESSION, CONFIGURATION.compression());
    assertEquals(CSV_OPTIONS, CONFIGURATION.csvOptions());
    assertEquals(IGNORE_UNKNOWN_VALUES, CONFIGURATION.ignoreUnknownValues());
    assertEquals(MAX_BAD_RECORDS, CONFIGURATION.maxBadRecords());
    assertEquals(TABLE_SCHEMA, CONFIGURATION.schema());
    assertEquals(SOURCE_FORMAT, CONFIGURATION.sourceFormat());
    assertEquals(SOURCE_URIS, CONFIGURATION.sourceUris());
  }

  @Test
  public void testToAndFromPb() {
    compareConfiguration(CONFIGURATION, ExternalDataConfiguration.fromPb(CONFIGURATION.toPb()));
    ExternalDataConfiguration configuration =
        ExternalDataConfiguration.builder(SOURCE_URIS, TABLE_SCHEMA, SOURCE_FORMAT).build();
    compareConfiguration(configuration, ExternalDataConfiguration.fromPb(configuration.toPb()));
  }

  private void compareConfiguration(ExternalDataConfiguration expected,
      ExternalDataConfiguration value) {
    assertEquals(expected, value);
    assertEquals(expected.compression(), value.compression());
    assertEquals(expected.csvOptions(), value.csvOptions());
    assertEquals(expected.ignoreUnknownValues(), value.ignoreUnknownValues());
    assertEquals(expected.maxBadRecords(), value.maxBadRecords());
    assertEquals(expected.schema(), value.schema());
    assertEquals(expected.sourceFormat(), value.sourceFormat());
    assertEquals(expected.sourceUris(), value.sourceUris());
  }
}
