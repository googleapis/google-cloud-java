/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics.StatementType;
import com.google.cloud.bigquery.JobStatistics.SessionInfo;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

class TableResultTest {
  private static final Page<FieldValueList> INNER_PAGE_0 =
      new PageImpl<>(
          new PageImpl.NextPageFetcher<FieldValueList>() {
            @Override
            public Page<FieldValueList> getNextPage() {
              return INNER_PAGE_1;
            }
          },
          "abc",
          ImmutableList.of(newFieldValueList("0"), newFieldValueList("1")));
  private static final Page<FieldValueList> INNER_PAGE_1 =
      new PageImpl<>(
          new PageImpl.NextPageFetcher<FieldValueList>() {
            @Override
            public Page<FieldValueList> getNextPage() {
              return null;
            }
          },
          null,
          ImmutableList.of(newFieldValueList("2")));
  private static final Schema SCHEMA = Schema.of(Field.of("field", LegacySQLTypeName.INTEGER));
  private static final String SESSION_ID = "session_123";
  private static final SessionInfo SESSION_INFO =
      SessionInfo.newBuilder().setSessionId(SESSION_ID).build();
  private static final String SESSION_ID_1 = "session_1";
  private static final SessionInfo SESSION_INFO_1 =
      SessionInfo.newBuilder().setSessionId(SESSION_ID_1).build();
  private static final String SESSION_ID_2 = "session_2";
  private static final SessionInfo SESSION_INFO_2 =
      SessionInfo.newBuilder().setSessionId(SESSION_ID_2).build();

  private static FieldValueList newFieldValueList(String s) {
    return FieldValueList.of(ImmutableList.of(FieldValue.of(PRIMITIVE, s)));
  }

  @Test
  void testNullSchema() {
    TableResult result =
        TableResult.newBuilder()
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .build();
    assertThat(result.getSchema()).isNull();
    assertThat(result.hasNextPage()).isTrue();
    assertThat(result.getNextPageToken()).isNotNull();
    assertThat(result.getRowsInPage()).isEqualTo(2L);
    assertThat(result.getValues())
        .containsExactly(newFieldValueList("0"), newFieldValueList("1"))
        .inOrder();

    TableResult next = result.getNextPage();
    assertThat(next.getSchema()).isNull();
    assertThat(next.hasNextPage()).isFalse();
    assertThat(next.getNextPageToken()).isNull();
    assertThat(next.getRowsInPage()).isEqualTo(1L);
    assertThat(next.getValues()).containsExactly(newFieldValueList("2"));
    assertThat(next.getNextPage()).isNull();

    assertThat(result.iterateAll())
        .containsExactly(newFieldValueList("0"), newFieldValueList("1"), newFieldValueList("2"))
        .inOrder();
  }

  @Test
  void testSchema() {
    TableResult result =
        TableResult.newBuilder()
            .setSchema(SCHEMA)
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .build();
    assertThat(result.getSchema()).isEqualTo(SCHEMA);
    assertThat(result.hasNextPage()).isTrue();
    assertThat(result.getNextPageToken()).isNotNull();
    assertThat(result.getRowsInPage()).isEqualTo(2L);
    assertThat(result.getValues())
        .containsExactly(
            newFieldValueList("0").withSchema(SCHEMA.getFields()),
            newFieldValueList("1").withSchema(SCHEMA.getFields()))
        .inOrder();

    TableResult next = result.getNextPage();
    assertThat(next.getSchema()).isEqualTo(SCHEMA);
    assertThat(next.hasNextPage()).isFalse();
    assertThat(next.getNextPageToken()).isNull();
    assertThat(next.getRowsInPage()).isEqualTo(1L);
    assertThat(next.getValues())
        .containsExactly(newFieldValueList("2").withSchema(SCHEMA.getFields()));
    assertThat(next.getNextPage()).isNull();

    assertThat(result.iterateAll())
        .containsExactly(
            newFieldValueList("0").withSchema(SCHEMA.getFields()),
            newFieldValueList("1").withSchema(SCHEMA.getFields()),
            newFieldValueList("2").withSchema(SCHEMA.getFields()))
        .inOrder();
  }

  @Test
  void testStatementTypeAndExecutionStats() {
    TableResult result =
        TableResult.newBuilder()
            .setSchema(SCHEMA)
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .setStatementType(StatementType.SELECT)
            .setTotalBytesBilled(1024L)
            .setTotalBytesProcessed(2048L)
            .setTotalSlotMs(500L)
            .setNumDmlAffectedRows(0L)
            .setSessionInfo(SESSION_INFO)
            .build();

    assertThat(result.getStatementType()).isEqualTo(StatementType.SELECT);
    assertThat(result.getTotalBytesBilled()).isEqualTo(1024L);
    assertThat(result.getTotalBytesProcessed()).isEqualTo(2048L);
    assertThat(result.getTotalSlotMs()).isEqualTo(500L);
    assertThat(result.getNumDmlAffectedRows()).isEqualTo(0L);
    assertThat(result.getSessionInfo()).isEqualTo(SESSION_INFO);
    assertThat(result.getSessionInfo().getSessionId()).isEqualTo(SESSION_ID);

    TableResult next = result.getNextPage();
    assertThat(next.getStatementType()).isEqualTo(StatementType.SELECT);
    assertThat(next.getTotalBytesBilled()).isEqualTo(1024L);
    assertThat(next.getTotalBytesProcessed()).isEqualTo(2048L);
    assertThat(next.getTotalSlotMs()).isEqualTo(500L);
    assertThat(next.getNumDmlAffectedRows()).isEqualTo(0L);
    assertThat(next.getSessionInfo()).isEqualTo(SESSION_INFO);
  }

  @Test
  void testToBuilder() {
    TableResult result =
        TableResult.newBuilder()
            .setSchema(SCHEMA)
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .setStatementType(StatementType.INSERT)
            .setTotalBytesBilled(500L)
            .setTotalBytesProcessed(1000L)
            .setTotalSlotMs(250L)
            .setNumDmlAffectedRows(5L)
            .setSessionInfo(SESSION_INFO)
            .build();

    TableResult modified =
        result.toBuilder()
            .setStatementType(StatementType.UPDATE)
            .setNumDmlAffectedRows(10L)
            .build();

    assertThat(modified.getStatementType()).isEqualTo(StatementType.UPDATE);
    assertThat(modified.getNumDmlAffectedRows()).isEqualTo(10L);
    assertThat(modified.getTotalBytesBilled()).isEqualTo(500L);
    assertThat(modified.getSessionInfo()).isEqualTo(SESSION_INFO);
  }

  @Test
  void testEqualsAndHashCode() {
    TableResult result1 =
        TableResult.newBuilder()
            .setSchema(SCHEMA)
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .setStatementType(StatementType.SELECT)
            .setTotalBytesBilled(100L)
            .setTotalBytesProcessed(200L)
            .setTotalSlotMs(50L)
            .setNumDmlAffectedRows(0L)
            .setSessionInfo(SESSION_INFO_1)
            .build();

    TableResult result2 =
        TableResult.newBuilder()
            .setSchema(SCHEMA)
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .setStatementType(StatementType.SELECT)
            .setTotalBytesBilled(100L)
            .setTotalBytesProcessed(200L)
            .setTotalSlotMs(50L)
            .setNumDmlAffectedRows(0L)
            .setSessionInfo(SESSION_INFO_1)
            .build();

    TableResult result3 =
        TableResult.newBuilder()
            .setSchema(SCHEMA)
            .setTotalRows(3L)
            .setPageNoSchema(INNER_PAGE_0)
            .setRowsInPage(2L)
            .setStatementType(StatementType.DELETE)
            .setTotalBytesBilled(100L)
            .setTotalBytesProcessed(200L)
            .setTotalSlotMs(50L)
            .setNumDmlAffectedRows(1L)
            .setSessionInfo(SESSION_INFO_2)
            .build();

    assertThat(result1).isEqualTo(result2);
    assertThat(result1.hashCode()).isEqualTo(result2.hashCode());
    assertThat(result1).isNotEqualTo(result3);
    assertThat(result1.toString()).contains("statementType=SELECT");
    assertThat(result1.toString()).contains("totalBytesBilled=100");
    assertThat(result1.toString()).contains("sessionId=" + SESSION_ID_1);
  }
}
