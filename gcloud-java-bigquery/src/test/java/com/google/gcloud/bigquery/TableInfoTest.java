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

public class TableInfoTest {

  private static final String ETAG = "etag";
  private static final String GENERATED_ID = "project:dataset:table";
  private static final String SELF_LINK = "selfLink";
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final String FRIENDLY_NAME = "friendlyName";
  private static final String DESCRIPTION = "description";
  private static final Long CREATION_TIME = 10L;
  private static final Long EXPIRATION_TIME = 100L;
  private static final Long LAST_MODIFIED_TIME = 20L;

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
  private static final Long NUM_BYTES = 42L;
  private static final Long NUM_ROWS = 43L;
  private static final String LOCATION = "US";
  private static final StandardTableDefinition.StreamingBuffer STREAMING_BUFFER =
      new StandardTableDefinition.StreamingBuffer(1L, 2L, 3L);
  private static final StandardTableDefinition TABLE_DEFINITION = StandardTableDefinition.builder()
      .location(LOCATION)
      .numBytes(NUM_BYTES)
      .numRows(NUM_ROWS)
      .streamingBuffer(STREAMING_BUFFER)
      .schema(TABLE_SCHEMA)
      .build();

  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
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

  private static final String VIEW_QUERY = "VIEW QUERY";
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS =
      ImmutableList.of(UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final ViewDefinition VIEW_TYPE =
      ViewDefinition.builder(VIEW_QUERY, USER_DEFINED_FUNCTIONS).build();

  private static final TableInfo TABLE_INFO = TableInfo.builder(TABLE_ID, TABLE_DEFINITION)
      .creationTime(CREATION_TIME)
      .description(DESCRIPTION)
      .etag(ETAG)
      .expirationTime(EXPIRATION_TIME)
      .friendlyName(FRIENDLY_NAME)
      .generatedId(GENERATED_ID)
      .lastModifiedTime(LAST_MODIFIED_TIME)
      .selfLink(SELF_LINK)
      .build();
  private static final TableInfo VIEW_INFO = TableInfo.builder(TABLE_ID, VIEW_TYPE)
      .creationTime(CREATION_TIME)
      .description(DESCRIPTION)
      .etag(ETAG)
      .expirationTime(EXPIRATION_TIME)
      .friendlyName(FRIENDLY_NAME)
      .generatedId(GENERATED_ID)
      .lastModifiedTime(LAST_MODIFIED_TIME)
      .selfLink(SELF_LINK)
      .build();
  private static final TableInfo EXTERNAL_TABLE_INFO =
      TableInfo.builder(TABLE_ID, EXTERNAL_TABLE_DEFINITION)
          .creationTime(CREATION_TIME)
          .description(DESCRIPTION)
          .etag(ETAG)
          .expirationTime(EXPIRATION_TIME)
          .friendlyName(FRIENDLY_NAME)
          .generatedId(GENERATED_ID)
          .lastModifiedTime(LAST_MODIFIED_TIME)
          .selfLink(SELF_LINK)
          .build();

  @Test
  public void testToBuilder() {
    compareTableInfo(TABLE_INFO, TABLE_INFO.toBuilder().build());
    compareTableInfo(VIEW_INFO, VIEW_INFO.toBuilder().build());
    compareTableInfo(EXTERNAL_TABLE_INFO, EXTERNAL_TABLE_INFO.toBuilder().build());
    TableInfo tableInfo = TABLE_INFO.toBuilder()
        .description("newDescription")
        .build();
    assertEquals("newDescription", tableInfo.description());
    tableInfo = tableInfo.toBuilder()
        .description("description")
        .build();
    compareTableInfo(TABLE_INFO, tableInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    TableInfo tableInfo = TableInfo.of(TABLE_ID, TABLE_DEFINITION);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
    tableInfo = TableInfo.of(TABLE_ID, VIEW_TYPE);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
    tableInfo = TableInfo.of(TABLE_ID, EXTERNAL_TABLE_DEFINITION);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, TABLE_INFO.tableId());
    assertEquals(CREATION_TIME, TABLE_INFO.creationTime());
    assertEquals(DESCRIPTION, TABLE_INFO.description());
    assertEquals(ETAG, TABLE_INFO.etag());
    assertEquals(EXPIRATION_TIME, TABLE_INFO.expirationTime());
    assertEquals(FRIENDLY_NAME, TABLE_INFO.friendlyName());
    assertEquals(GENERATED_ID, TABLE_INFO.generatedId());
    assertEquals(LAST_MODIFIED_TIME, TABLE_INFO.lastModifiedTime());
    assertEquals(TABLE_DEFINITION, TABLE_INFO.definition());
    assertEquals(SELF_LINK, TABLE_INFO.selfLink());
    assertEquals(TABLE_ID, VIEW_INFO.tableId());
    assertEquals(VIEW_TYPE, VIEW_INFO.definition());
    assertEquals(CREATION_TIME, VIEW_INFO.creationTime());
    assertEquals(DESCRIPTION, VIEW_INFO.description());
    assertEquals(ETAG, VIEW_INFO.etag());
    assertEquals(EXPIRATION_TIME, VIEW_INFO.expirationTime());
    assertEquals(FRIENDLY_NAME, VIEW_INFO.friendlyName());
    assertEquals(GENERATED_ID, VIEW_INFO.generatedId());
    assertEquals(LAST_MODIFIED_TIME, VIEW_INFO.lastModifiedTime());
    assertEquals(VIEW_TYPE, VIEW_INFO.definition());
    assertEquals(SELF_LINK, VIEW_INFO.selfLink());
    assertEquals(TABLE_ID, EXTERNAL_TABLE_INFO.tableId());
    assertEquals(CREATION_TIME, EXTERNAL_TABLE_INFO.creationTime());
    assertEquals(DESCRIPTION, EXTERNAL_TABLE_INFO.description());
    assertEquals(ETAG, EXTERNAL_TABLE_INFO.etag());
    assertEquals(EXPIRATION_TIME, EXTERNAL_TABLE_INFO.expirationTime());
    assertEquals(FRIENDLY_NAME, EXTERNAL_TABLE_INFO.friendlyName());
    assertEquals(GENERATED_ID, EXTERNAL_TABLE_INFO.generatedId());
    assertEquals(LAST_MODIFIED_TIME, EXTERNAL_TABLE_INFO.lastModifiedTime());
    assertEquals(EXTERNAL_TABLE_DEFINITION, EXTERNAL_TABLE_INFO.definition());
    assertEquals(SELF_LINK, EXTERNAL_TABLE_INFO.selfLink());
  }

  @Test
  public void testToAndFromPb() {
    compareTableInfo(TABLE_INFO, TableInfo.fromPb(TABLE_INFO.toPb()));
    compareTableInfo(VIEW_INFO, TableInfo.fromPb(VIEW_INFO.toPb()));
    compareTableInfo(EXTERNAL_TABLE_INFO, TableInfo.fromPb(EXTERNAL_TABLE_INFO.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals("project", TABLE_INFO.setProjectId("project").tableId().project());
    assertEquals("project", EXTERNAL_TABLE_INFO.setProjectId("project").tableId().project());
    assertEquals("project", VIEW_INFO.setProjectId("project").tableId().project());
  }

  private void compareTableInfo(TableInfo expected, TableInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.tableId(), value.tableId());
    assertEquals(expected.definition(), value.definition());
    assertEquals(expected.creationTime(), value.creationTime());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.expirationTime(), value.expirationTime());
    assertEquals(expected.friendlyName(), value.friendlyName());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.lastModifiedTime(), value.lastModifiedTime());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.definition(), value.definition());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
