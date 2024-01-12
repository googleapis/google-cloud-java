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

import com.google.common.collect.ImmutableList;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

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
  private static final Boolean REQUIRE_PARTITION_FILTER = true;
  private static final EncryptionConfiguration ENCRYPTION_CONFIGURATION =
      EncryptionConfiguration.newBuilder().setKmsKeyName("KMS_KEY_1").build();

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
  private static final Long NUM_BYTES = 42L;
  private static final Long NUM_LONG_TERM_BYTES = 21L;
  private static final Long NUM_TIME_TRAVEL_PHYSICAL_BYTES = 21L;
  private static final Long NUM_TOTAL_LOGICAL_BYTES = 22L;
  private static final Long NUM_ACTIVE_LOGICAL_BYTES = 23L;
  private static final Long NUM_LONG_TERM_LOGICAL_BYTES = 24L;
  private static final Long NUM_TOTAL_PHYSICAL_BYTES = 25L;
  private static final Long NUM_ACTIVE_PHYSICAL_BYTES = 26L;
  private static final Long NUM_LONG_TERM_PHYSICAL_BYTES = 27L;
  private static final Long NUM_ROWS = 43L;
  private static final String LOCATION = "US";
  private static final StandardTableDefinition.StreamingBuffer STREAMING_BUFFER =
      new StandardTableDefinition.StreamingBuffer(1L, 2L, 3L);
  private static final StandardTableDefinition TABLE_DEFINITION =
      StandardTableDefinition.newBuilder()
          .setLocation(LOCATION)
          .setNumBytes(NUM_BYTES)
          .setNumLongTermBytes(NUM_LONG_TERM_BYTES)
          .setNumTimeTravelPhysicalBytes(NUM_TIME_TRAVEL_PHYSICAL_BYTES)
          .setNumTotalLogicalBytes(NUM_TOTAL_LOGICAL_BYTES)
          .setNumActiveLogicalBytes(NUM_ACTIVE_LOGICAL_BYTES)
          .setNumLongTermLogicalBytes(NUM_LONG_TERM_LOGICAL_BYTES)
          .setNumTotalPhysicalBytes(NUM_TOTAL_PHYSICAL_BYTES)
          .setNumActivePhysicalBytes(NUM_ACTIVE_PHYSICAL_BYTES)
          .setNumLongTermPhysicalBytes(NUM_LONG_TERM_PHYSICAL_BYTES)
          .setNumRows(NUM_ROWS)
          .setStreamingBuffer(STREAMING_BUFFER)
          .setSchema(TABLE_SCHEMA)
          .build();

  private static final List<String> SOURCE_URIS = ImmutableList.of("uri1", "uri2");
  private static final Integer MAX_BAD_RECORDS = 42;
  private static final Boolean IGNORE_UNKNOWN_VALUES = true;
  private static final String COMPRESSION = "GZIP";
  private static final CsvOptions CSV_OPTIONS = CsvOptions.newBuilder().build();
  private static final ExternalTableDefinition EXTERNAL_TABLE_DEFINITION =
      ExternalTableDefinition.newBuilder(SOURCE_URIS, TABLE_SCHEMA, CSV_OPTIONS)
          .setCompression(COMPRESSION)
          .setIgnoreUnknownValues(IGNORE_UNKNOWN_VALUES)
          .setMaxBadRecords(MAX_BAD_RECORDS)
          .build();

  private static final String VIEW_QUERY = "VIEW QUERY";
  private static final List<UserDefinedFunction> USER_DEFINED_FUNCTIONS =
      ImmutableList.of(UserDefinedFunction.inline("Function"), UserDefinedFunction.fromUri("URI"));
  private static final ViewDefinition VIEW_DEFINITION =
      ViewDefinition.newBuilder(VIEW_QUERY, USER_DEFINED_FUNCTIONS).build();

  private static final TableInfo TABLE_INFO =
      TableInfo.newBuilder(TABLE_ID, TABLE_DEFINITION)
          .setCreationTime(CREATION_TIME)
          .setDescription(DESCRIPTION)
          .setEncryptionConfiguration(ENCRYPTION_CONFIGURATION)
          .setEtag(ETAG)
          .setExpirationTime(EXPIRATION_TIME)
          .setFriendlyName(FRIENDLY_NAME)
          .setGeneratedId(GENERATED_ID)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setNumBytes(NUM_BYTES)
          .setNumLongTermBytes(NUM_LONG_TERM_BYTES)
          .setNumTimeTravelPhysicalBytes(NUM_TIME_TRAVEL_PHYSICAL_BYTES)
          .setNumTotalLogicalBytes(NUM_TOTAL_LOGICAL_BYTES)
          .setNumActiveLogicalBytes(NUM_ACTIVE_LOGICAL_BYTES)
          .setNumLongTermLogicalBytes(NUM_LONG_TERM_LOGICAL_BYTES)
          .setNumTotalPhysicalBytes(NUM_TOTAL_PHYSICAL_BYTES)
          .setNumActivePhysicalBytes(NUM_ACTIVE_PHYSICAL_BYTES)
          .setNumLongTermPhysicalBytes(NUM_LONG_TERM_PHYSICAL_BYTES)
          .setNumRows(BigInteger.valueOf(NUM_ROWS))
          .setSelfLink(SELF_LINK)
          .setLabels(Collections.singletonMap("a", "b"))
          .setResourceTags(Collections.singletonMap("resourceTagA", "resourceTagB"))
          .setRequirePartitionFilter(REQUIRE_PARTITION_FILTER)
          .build();
  private static final TableInfo VIEW_INFO =
      TableInfo.newBuilder(TABLE_ID, VIEW_DEFINITION)
          .setCreationTime(CREATION_TIME)
          .setDescription(DESCRIPTION)
          .setEtag(ETAG)
          .setExpirationTime(EXPIRATION_TIME)
          .setFriendlyName(FRIENDLY_NAME)
          .setGeneratedId(GENERATED_ID)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setSelfLink(SELF_LINK)
          .build();
  private static final TableInfo EXTERNAL_TABLE_INFO =
      TableInfo.newBuilder(TABLE_ID, EXTERNAL_TABLE_DEFINITION)
          .setCreationTime(CREATION_TIME)
          .setDescription(DESCRIPTION)
          .setEtag(ETAG)
          .setExpirationTime(EXPIRATION_TIME)
          .setFriendlyName(FRIENDLY_NAME)
          .setGeneratedId(GENERATED_ID)
          .setLastModifiedTime(LAST_MODIFIED_TIME)
          .setSelfLink(SELF_LINK)
          .build();

  @Test
  public void testToBuilder() {
    compareTableInfo(TABLE_INFO, TABLE_INFO.toBuilder().build());
    compareTableInfo(VIEW_INFO, VIEW_INFO.toBuilder().build());
    compareTableInfo(EXTERNAL_TABLE_INFO, EXTERNAL_TABLE_INFO.toBuilder().build());
    TableInfo tableInfo = TABLE_INFO.toBuilder().setDescription("newDescription").build();
    assertEquals("newDescription", tableInfo.getDescription());
    tableInfo = tableInfo.toBuilder().setDescription("description").build();
    compareTableInfo(TABLE_INFO, tableInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    TableInfo tableInfo = TableInfo.of(TABLE_ID, TABLE_DEFINITION);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
    tableInfo = TableInfo.of(TABLE_ID, VIEW_DEFINITION);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
    tableInfo = TableInfo.of(TABLE_ID, EXTERNAL_TABLE_DEFINITION);
    assertEquals(tableInfo, tableInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals(TABLE_ID, TABLE_INFO.getTableId());
    assertEquals(CREATION_TIME, TABLE_INFO.getCreationTime());
    assertEquals(DESCRIPTION, TABLE_INFO.getDescription());
    assertEquals(ENCRYPTION_CONFIGURATION, TABLE_INFO.getEncryptionConfiguration());
    assertEquals(ETAG, TABLE_INFO.getEtag());
    assertEquals(EXPIRATION_TIME, TABLE_INFO.getExpirationTime());
    assertEquals(FRIENDLY_NAME, TABLE_INFO.getFriendlyName());
    assertEquals(GENERATED_ID, TABLE_INFO.getGeneratedId());
    assertEquals(LAST_MODIFIED_TIME, TABLE_INFO.getLastModifiedTime());
    assertEquals(TABLE_DEFINITION, TABLE_INFO.getDefinition());
    assertEquals(SELF_LINK, TABLE_INFO.getSelfLink());
    assertEquals(NUM_BYTES, TABLE_INFO.getNumBytes());
    assertEquals(NUM_LONG_TERM_BYTES, TABLE_INFO.getNumLongTermBytes());
    assertEquals(NUM_TIME_TRAVEL_PHYSICAL_BYTES, TABLE_INFO.getNumTimeTravelPhysicalBytes());
    assertEquals(NUM_TOTAL_LOGICAL_BYTES, TABLE_INFO.getNumTotalLogicalBytes());
    assertEquals(NUM_ACTIVE_LOGICAL_BYTES, TABLE_INFO.getNumActiveLogicalBytes());
    assertEquals(NUM_LONG_TERM_LOGICAL_BYTES, TABLE_INFO.getNumLongTermLogicalBytes());
    assertEquals(NUM_TOTAL_PHYSICAL_BYTES, TABLE_INFO.getNumTotalPhysicalBytes());
    assertEquals(NUM_ACTIVE_PHYSICAL_BYTES, TABLE_INFO.getNumActivePhysicalBytes());
    assertEquals(NUM_LONG_TERM_PHYSICAL_BYTES, TABLE_INFO.getNumLongTermPhysicalBytes());
    assertEquals(BigInteger.valueOf(NUM_ROWS), TABLE_INFO.getNumRows());
    assertEquals(REQUIRE_PARTITION_FILTER, TABLE_INFO.getRequirePartitionFilter());

    assertEquals(TABLE_ID, VIEW_INFO.getTableId());
    assertEquals(VIEW_DEFINITION, VIEW_INFO.getDefinition());
    assertEquals(CREATION_TIME, VIEW_INFO.getCreationTime());
    assertEquals(DESCRIPTION, VIEW_INFO.getDescription());
    assertEquals(ETAG, VIEW_INFO.getEtag());
    assertEquals(EXPIRATION_TIME, VIEW_INFO.getExpirationTime());
    assertEquals(FRIENDLY_NAME, VIEW_INFO.getFriendlyName());
    assertEquals(GENERATED_ID, VIEW_INFO.getGeneratedId());
    assertEquals(LAST_MODIFIED_TIME, VIEW_INFO.getLastModifiedTime());
    assertEquals(VIEW_DEFINITION, VIEW_INFO.getDefinition());
    assertEquals(SELF_LINK, VIEW_INFO.getSelfLink());

    assertEquals(TABLE_ID, EXTERNAL_TABLE_INFO.getTableId());
    assertEquals(CREATION_TIME, EXTERNAL_TABLE_INFO.getCreationTime());
    assertEquals(DESCRIPTION, EXTERNAL_TABLE_INFO.getDescription());
    assertEquals(ETAG, EXTERNAL_TABLE_INFO.getEtag());
    assertEquals(EXPIRATION_TIME, EXTERNAL_TABLE_INFO.getExpirationTime());
    assertEquals(FRIENDLY_NAME, EXTERNAL_TABLE_INFO.getFriendlyName());
    assertEquals(GENERATED_ID, EXTERNAL_TABLE_INFO.getGeneratedId());
    assertEquals(LAST_MODIFIED_TIME, EXTERNAL_TABLE_INFO.getLastModifiedTime());
    assertEquals(EXTERNAL_TABLE_DEFINITION, EXTERNAL_TABLE_INFO.getDefinition());
    assertEquals(SELF_LINK, EXTERNAL_TABLE_INFO.getSelfLink());
  }

  @Test
  public void testOf() {
    TableInfo tableInfo = TableInfo.of(TABLE_ID, TABLE_DEFINITION);
    assertEquals(TABLE_ID, tableInfo.getTableId());
    assertNull(tableInfo.getCreationTime());
    assertNull(tableInfo.getDescription());
    assertNull(tableInfo.getEncryptionConfiguration());
    assertNull(tableInfo.getEtag());
    assertNull(tableInfo.getExpirationTime());
    assertNull(tableInfo.getFriendlyName());
    assertNull(tableInfo.getGeneratedId());
    assertNull(tableInfo.getLastModifiedTime());
    assertNull(tableInfo.getRequirePartitionFilter());
    assertEquals(TABLE_DEFINITION, tableInfo.getDefinition());
    assertNull(tableInfo.getSelfLink());
    tableInfo = TableInfo.of(TABLE_ID, VIEW_DEFINITION);
    assertEquals(TABLE_ID, tableInfo.getTableId());
    assertNull(tableInfo.getCreationTime());
    assertNull(tableInfo.getDescription());
    assertNull(tableInfo.getEncryptionConfiguration());
    assertNull(tableInfo.getEtag());
    assertNull(tableInfo.getExpirationTime());
    assertNull(tableInfo.getFriendlyName());
    assertNull(tableInfo.getGeneratedId());
    assertNull(tableInfo.getLastModifiedTime());
    assertNull(tableInfo.getRequirePartitionFilter());
    assertEquals(VIEW_DEFINITION, tableInfo.getDefinition());
    assertNull(tableInfo.getSelfLink());
    tableInfo = TableInfo.of(TABLE_ID, EXTERNAL_TABLE_DEFINITION);
    assertEquals(TABLE_ID, tableInfo.getTableId());
    assertNull(tableInfo.getCreationTime());
    assertNull(tableInfo.getDescription());
    assertNull(tableInfo.getEncryptionConfiguration());
    assertNull(tableInfo.getEtag());
    assertNull(tableInfo.getExpirationTime());
    assertNull(tableInfo.getFriendlyName());
    assertNull(tableInfo.getGeneratedId());
    assertNull(tableInfo.getLastModifiedTime());
    assertNull(tableInfo.getRequirePartitionFilter());
    assertEquals(EXTERNAL_TABLE_DEFINITION, tableInfo.getDefinition());
    assertNull(tableInfo.getSelfLink());
  }

  @Test
  public void testToAndFromPb() {
    compareTableInfo(TABLE_INFO, TableInfo.fromPb(TABLE_INFO.toPb()));
    compareTableInfo(VIEW_INFO, TableInfo.fromPb(VIEW_INFO.toPb()));
    compareTableInfo(EXTERNAL_TABLE_INFO, TableInfo.fromPb(EXTERNAL_TABLE_INFO.toPb()));
  }

  @Test
  public void testSetProjectId() {
    assertEquals("project", TABLE_INFO.setProjectId("project").getTableId().getProject());
    assertEquals("project", EXTERNAL_TABLE_INFO.setProjectId("project").getTableId().getProject());
    assertEquals("project", VIEW_INFO.setProjectId("project").getTableId().getProject());
  }

  @Test
  public void testSetProjectIdDoNotOverride() {
    TableInfo tableInfo = TableInfo.of(TABLE_ID, TABLE_DEFINITION).setProjectId("project");
    tableInfo.setProjectId("not-override-project").toBuilder();
    assertEquals("project", tableInfo.getTableId().getProject());
  }

  private void compareTableInfo(TableInfo expected, TableInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getTableId(), value.getTableId());
    assertEquals(expected.getDefinition(), value.getDefinition());
    assertEquals(expected.getCreationTime(), value.getCreationTime());
    assertEquals(expected.getDescription(), value.getDescription());
    assertEquals(expected.getEncryptionConfiguration(), value.getEncryptionConfiguration());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getExpirationTime(), value.getExpirationTime());
    assertEquals(expected.getFriendlyName(), value.getFriendlyName());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getLastModifiedTime(), value.getLastModifiedTime());
    assertEquals(expected.getNumBytes(), value.getNumBytes());
    assertEquals(expected.getNumLongTermBytes(), value.getNumLongTermBytes());
    assertEquals(expected.getNumTimeTravelPhysicalBytes(), value.getNumTimeTravelPhysicalBytes());
    assertEquals(expected.getNumTotalLogicalBytes(), value.getNumTotalLogicalBytes());
    assertEquals(expected.getNumActiveLogicalBytes(), value.getNumActiveLogicalBytes());
    assertEquals(expected.getNumLongTermLogicalBytes(), value.getNumLongTermLogicalBytes());
    assertEquals(expected.getNumTotalPhysicalBytes(), value.getNumTotalPhysicalBytes());
    assertEquals(expected.getNumActivePhysicalBytes(), value.getNumActivePhysicalBytes());
    assertEquals(expected.getNumLongTermPhysicalBytes(), value.getNumLongTermPhysicalBytes());
    assertEquals(expected.getNumRows(), value.getNumRows());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getLabels(), value.getLabels());
    assertEquals(expected.getResourceTags(), value.getResourceTags());
    assertEquals(expected.getRequirePartitionFilter(), value.getRequirePartitionFilter());
    assertEquals(expected.toString(), value.toString());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
