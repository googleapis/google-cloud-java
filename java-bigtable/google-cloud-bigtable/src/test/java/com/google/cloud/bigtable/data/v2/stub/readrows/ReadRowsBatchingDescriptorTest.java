/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub.readrows;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.BatchEntry;
import com.google.api.gax.batching.BatchingRequestBuilder;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadRowsBatchingDescriptorTest {

  private static final RowCell ROW_CELL =
      RowCell.create(
          "cf",
          ByteString.copyFromUtf8("qualifier"),
          10000,
          ImmutableList.of("label-1", "label-2"),
          ByteString.copyFromUtf8("qualifier"));
  private static final Row ROW_KEY_1_RESPONSE =
      Row.create(ByteString.copyFromUtf8("row-key-1"), ImmutableList.of(ROW_CELL));
  private static final Row ROW_KEY_2_RESPONSE =
      Row.create(ByteString.copyFromUtf8("row-key-2"), ImmutableList.of(ROW_CELL));

  private ReadRowsBatchingDescriptor underTest = new ReadRowsBatchingDescriptor();

  @Test
  public void splitResponseTest() throws Exception {
    List<BatchEntry<ByteString, Row>> batchEntries = createBatchEntries("row-key-1", "row-key-2");
    underTest.splitResponse(ImmutableList.of(ROW_KEY_1_RESPONSE, ROW_KEY_2_RESPONSE), batchEntries);

    assertThat(batchEntries.get(0).getResultFuture().get()).isEqualTo(ROW_KEY_1_RESPONSE);
    assertThat(batchEntries.get(1).getResultFuture().get()).isEqualTo(ROW_KEY_2_RESPONSE);
  }

  @Test
  public void splitResponseWithDuplicateKeysTest() throws Exception {
    List<BatchEntry<ByteString, Row>> batchEntries =
        createBatchEntries("row-key-1", "row-key-2", "row-key-1", "row-key-1");

    underTest.splitResponse(ImmutableList.of(ROW_KEY_1_RESPONSE, ROW_KEY_2_RESPONSE), batchEntries);

    assertThat(batchEntries.get(0).getResultFuture().get()).isEqualTo(ROW_KEY_1_RESPONSE);
    assertThat(batchEntries.get(1).getResultFuture().get()).isEqualTo(ROW_KEY_2_RESPONSE);
    assertThat(batchEntries.get(2).getResultFuture().get()).isEqualTo(ROW_KEY_1_RESPONSE);
    assertThat(batchEntries.get(3).getResultFuture().get()).isEqualTo(ROW_KEY_1_RESPONSE);
  }

  @Test
  public void splitResponseWithNonExistent() throws Exception {
    List<BatchEntry<ByteString, Row>> batchEntries =
        createBatchEntries("non-existent-1", "non-existent-2", "row-key-1");

    underTest.splitResponse(ImmutableList.of(ROW_KEY_1_RESPONSE), batchEntries);

    assertThat(batchEntries.size()).isEqualTo(3);
    assertThat(batchEntries.get(0).getResultFuture().get()).isNull();
    assertThat(batchEntries.get(1).getResultFuture().get()).isNull();
    assertThat(batchEntries.get(2).getResultFuture().get()).isEqualTo(ROW_KEY_1_RESPONSE);
  }

  @Test
  public void splitExceptionTest() {
    RuntimeException expectedException = new RuntimeException("cannot scan the table");
    List<BatchEntry<ByteString, Row>> batchEntries = createBatchEntries("row-key-1", "row-key-2");
    underTest.splitException(expectedException, batchEntries);
    for (BatchEntry<ByteString, Row> resultEntry : batchEntries) {
      try {
        resultEntry.getResultFuture().get();
      } catch (Exception actualEx) {
        assertThat(actualEx).hasCauseThat().isEqualTo(expectedException);
      }
    }
  }

  @Test
  public void countBytesTest() {
    ByteString rowKey = ByteString.copyFromUtf8("testRowKey");
    long len = underTest.countBytes(rowKey);
    assertThat(len).isEqualTo(rowKey.size());
  }

  @Test
  public void requestBuilderTest() {
    BatchingRequestBuilder<ByteString, Query> requestBuilder =
        underTest.newRequestBuilder(Query.create("table-Id"));
    requestBuilder.add(ByteString.copyFromUtf8("row-key-1"));
    requestBuilder.add(ByteString.copyFromUtf8("row-key-2"));

    Query request = requestBuilder.build();

    ReadRowsRequest readRowsRequest =
        request.toProto(RequestContext.create("project", "instance", "appProfile"));
    assertThat(readRowsRequest.getTableName()).contains("table-Id");
    assertThat(readRowsRequest.getRows().getRowKeysList())
        .isEqualTo(
            ImmutableList.of(
                ByteString.copyFromUtf8("row-key-1"), ByteString.copyFromUtf8("row-key-2")));
  }

  private List<BatchEntry<ByteString, Row>> createBatchEntries(String... rowKeys) {
    ImmutableList.Builder<BatchEntry<ByteString, Row>> builder = ImmutableList.builder();

    for (String rowKey : rowKeys) {
      builder.add(
          BatchEntry.create(ByteString.copyFromUtf8(rowKey), SettableApiFuture.<Row>create()));
    }
    return builder.build();
  }
}
