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
import com.google.gcloud.bigquery.TableInfo.StreamingBuffer;

import org.junit.Test;

import java.util.List;

public class TableInfoTest {

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
  private static final String VIEW_QUERY = "VIEW QUERY";
  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
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
  private static final String ETAG = "etag";
  private static final String ID = "project:dataset:table";
  private static final String SELF_LINK = "selfLink";
  private static final TableId TABLE_ID = TableId.of("dataset", "table");
  private static final String FRIENDLY_NAME = "friendlyName";
  private static final String DESCRIPTION = "description";
  private static final Long NUM_BYTES = 42L;
  private static final Long NUM_ROWS = 43L;
  private static final Long CREATION_TIME = 10L;
  private static final Long EXPIRATION_TIME = 100L;
  private static final Long LAST_MODIFIED_TIME = 20L;
  private static final String LOCATION = "US";
  private static final StreamingBuffer STREAMING_BUFFER = new StreamingBuffer(1L, 2L, 3L);
  private static final TableInfo TABLE_INFO = TableInfo.builder(TABLE_ID, TABLE_SCHEMA)
      .creationTime(CREATION_TIME)
      .description(DESCRIPTION)
      .etag(ETAG)
      .expirationTime(EXPIRATION_TIME)
      .friendlyName(FRIENDLY_NAME)
      .id(ID)
      .lastModifiedTime(LAST_MODIFIED_TIME)
      .location(LOCATION)
      .numBytes(NUM_BYTES)
      .numRows(NUM_ROWS)
      .selfLink(SELF_LINK)
      .streamingBuffer(STREAMING_BUFFER)
      .type(TableInfo.Type.TABLE)
      .build();
  private static final TableInfo EXTERNAL_TABLE_INFO = TableInfo.builder(TABLE_ID, CONFIGURATION)
      .creationTime(CREATION_TIME)
      .description(DESCRIPTION)
      .etag(ETAG)
      .expirationTime(EXPIRATION_TIME)
      .friendlyName(FRIENDLY_NAME)
      .id(ID)
      .lastModifiedTime(LAST_MODIFIED_TIME)
      .location(LOCATION)
      .numBytes(NUM_BYTES)
      .numRows(NUM_ROWS)
      .selfLink(SELF_LINK)
      .streamingBuffer(STREAMING_BUFFER)
      .type(TableInfo.Type.TABLE)
      .build();
  private static List<UserDefinedFunction> USER_DEFINED_FUNCTIONS = ImmutableList.of(
      UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final TableInfo VIEW_INFO =
      TableInfo.builder(TABLE_ID, VIEW_QUERY, USER_DEFINED_FUNCTIONS)
          .creationTime(CREATION_TIME)
          .description(DESCRIPTION)
          .etag(ETAG)
          .expirationTime(EXPIRATION_TIME)
          .friendlyName(FRIENDLY_NAME)
          .id(ID)
          .lastModifiedTime(LAST_MODIFIED_TIME)
          .location(LOCATION)
          .numBytes(NUM_BYTES)
          .numRows(NUM_ROWS)
          .selfLink(SELF_LINK)
          .streamingBuffer(STREAMING_BUFFER)
          .type(TableInfo.Type.VIEW)
          .build();

  @Test
  public void testToBuilder() {
    compareTableInfo(TABLE_INFO, TABLE_INFO.toBuilder().build());
    compareTableInfo(VIEW_INFO, VIEW_INFO.toBuilder().build());
    compareTableInfo(EXTERNAL_TABLE_INFO, EXTERNAL_TABLE_INFO.toBuilder().build());
    TableInfo tableInfo = TABLE_INFO.toBuilder()
        .type(TableInfo.Type.VIEW)
        .description("newDescription")
        .build();
    assertEquals(TableInfo.Type.VIEW, tableInfo.type());
    assertEquals("newDescription", tableInfo.description());
    tableInfo = tableInfo.toBuilder()
        .type(TableInfo.Type.TABLE)
        .description("description")
        .build();
    compareTableInfo(TABLE_INFO, tableInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    TableInfo tableInfo = TableInfo.of(TABLE_ID, VIEW_QUERY);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
  }
  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, TABLE_INFO.tableId());
    assertEquals(TABLE_SCHEMA, TABLE_INFO.schema());
    assertEquals(null, TABLE_INFO.viewQuery());
    assertEquals(null, TABLE_INFO.externalConfiguration());
    assertEquals(CREATION_TIME, TABLE_INFO.creationTime());
    assertEquals(DESCRIPTION, TABLE_INFO.description());
    assertEquals(ETAG, TABLE_INFO.etag());
    assertEquals(EXPIRATION_TIME, TABLE_INFO.expirationTime());
    assertEquals(FRIENDLY_NAME, TABLE_INFO.friendlyName());
    assertEquals(ID, TABLE_INFO.id());
    assertEquals(LAST_MODIFIED_TIME, TABLE_INFO.lastModifiedTime());
    assertEquals(LOCATION, TABLE_INFO.location());
    assertEquals(NUM_BYTES, TABLE_INFO.numBytes());
    assertEquals(NUM_ROWS, TABLE_INFO.numRows());
    assertEquals(SELF_LINK, TABLE_INFO.selfLink());
    assertEquals(STREAMING_BUFFER, TABLE_INFO.streamingBuffer());
    assertEquals(TableInfo.Type.TABLE, TABLE_INFO.type());
    assertEquals(TABLE_ID, VIEW_INFO.tableId());
    assertEquals(null, VIEW_INFO.schema());
    assertEquals(VIEW_QUERY, VIEW_INFO.viewQuery());
    assertEquals(null, VIEW_INFO.externalConfiguration());
    assertEquals(CREATION_TIME, VIEW_INFO.creationTime());
    assertEquals(DESCRIPTION, VIEW_INFO.description());
    assertEquals(ETAG, VIEW_INFO.etag());
    assertEquals(EXPIRATION_TIME, VIEW_INFO.expirationTime());
    assertEquals(FRIENDLY_NAME, VIEW_INFO.friendlyName());
    assertEquals(ID, VIEW_INFO.id());
    assertEquals(LAST_MODIFIED_TIME, VIEW_INFO.lastModifiedTime());
    assertEquals(LOCATION, VIEW_INFO.location());
    assertEquals(NUM_BYTES, VIEW_INFO.numBytes());
    assertEquals(NUM_ROWS, VIEW_INFO.numRows());
    assertEquals(SELF_LINK, VIEW_INFO.selfLink());
    assertEquals(STREAMING_BUFFER, VIEW_INFO.streamingBuffer());
    assertEquals(TableInfo.Type.VIEW, VIEW_INFO.type());
    assertEquals(TABLE_ID, EXTERNAL_TABLE_INFO.tableId());
    assertEquals(null, EXTERNAL_TABLE_INFO.schema());
    assertEquals(null, EXTERNAL_TABLE_INFO.viewQuery());
    assertEquals(CONFIGURATION, EXTERNAL_TABLE_INFO.externalConfiguration());
    assertEquals(CREATION_TIME, EXTERNAL_TABLE_INFO.creationTime());
    assertEquals(DESCRIPTION, EXTERNAL_TABLE_INFO.description());
    assertEquals(ETAG, EXTERNAL_TABLE_INFO.etag());
    assertEquals(EXPIRATION_TIME, EXTERNAL_TABLE_INFO.expirationTime());
    assertEquals(FRIENDLY_NAME, EXTERNAL_TABLE_INFO.friendlyName());
    assertEquals(ID, EXTERNAL_TABLE_INFO.id());
    assertEquals(LAST_MODIFIED_TIME, EXTERNAL_TABLE_INFO.lastModifiedTime());
    assertEquals(LOCATION, EXTERNAL_TABLE_INFO.location());
    assertEquals(NUM_BYTES, EXTERNAL_TABLE_INFO.numBytes());
    assertEquals(NUM_ROWS, EXTERNAL_TABLE_INFO.numRows());
    assertEquals(SELF_LINK, EXTERNAL_TABLE_INFO.selfLink());
    assertEquals(STREAMING_BUFFER, EXTERNAL_TABLE_INFO.streamingBuffer());
    assertEquals(TableInfo.Type.TABLE, EXTERNAL_TABLE_INFO.type());
  }

  @Test
  public void testToAndFromPb() {
    compareTableInfo(TABLE_INFO, TableInfo.fromPb(TABLE_INFO.toPb()));
    compareTableInfo(VIEW_INFO, TableInfo.fromPb(VIEW_INFO.toPb()));
    compareTableInfo(EXTERNAL_TABLE_INFO, TableInfo.fromPb(EXTERNAL_TABLE_INFO.toPb()));
  }

  private void compareTableInfo(TableInfo expected, TableInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.tableId(), value.tableId());
    assertEquals(expected.schema(), value.schema());
    assertEquals(expected.viewQuery(), value.viewQuery());
    assertEquals(expected.externalConfiguration(), value.externalConfiguration());
    assertEquals(expected.creationTime(), value.creationTime());
    assertEquals(expected.description(), value.description());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.expirationTime(), value.expirationTime());
    assertEquals(expected.friendlyName(), value.friendlyName());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.lastModifiedTime(), value.lastModifiedTime());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.numBytes(), value.numBytes());
    assertEquals(expected.numRows(), value.numRows());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.streamingBuffer(), value.streamingBuffer());
    assertEquals(expected.type(), value.type());
  }
}
