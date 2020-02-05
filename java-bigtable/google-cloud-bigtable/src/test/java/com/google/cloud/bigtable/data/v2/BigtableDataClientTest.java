/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.batching.Batcher;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class BigtableDataClientTest {
  @Mock private EnhancedBigtableStub mockStub;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private ServerStreamingCallable<Query, Row> mockReadRowsCallable;

  @Mock private UnaryCallable<Query, Row> mockReadRowCallable;
  @Mock private UnaryCallable<String, List<KeyOffset>> mockSampleRowKeysCallable;
  @Mock private UnaryCallable<RowMutation, Void> mockMutateRowCallable;
  @Mock private UnaryCallable<ConditionalRowMutation, Boolean> mockCheckAndMutateRowCallable;
  @Mock private UnaryCallable<ReadModifyWriteRow, Row> mockReadModifyWriteRowCallable;
  @Mock private UnaryCallable<BulkMutation, Void> mockBulkMutateRowsCallable;
  @Mock private Batcher<RowMutationEntry, Void> mockBulkMutationBatcher;
  @Mock private Batcher<ByteString, Row> mockBulkReadRowsBatcher;

  private BigtableDataClient bigtableDataClient;

  @Before
  public void setUp() {
    bigtableDataClient = new BigtableDataClient(mockStub);
    Mockito.when(mockStub.readRowsCallable()).thenReturn(mockReadRowsCallable);
    Mockito.when(mockStub.readRowCallable()).thenReturn(mockReadRowCallable);
    Mockito.when(mockStub.sampleRowKeysCallable()).thenReturn(mockSampleRowKeysCallable);
    Mockito.when(mockStub.mutateRowCallable()).thenReturn(mockMutateRowCallable);
    Mockito.when(mockStub.bulkMutateRowsCallable()).thenReturn(mockBulkMutateRowsCallable);
    Mockito.when(mockStub.checkAndMutateRowCallable()).thenReturn(mockCheckAndMutateRowCallable);
    Mockito.when(mockStub.readModifyWriteRowCallable()).thenReturn(mockReadModifyWriteRowCallable);
    Mockito.when(mockStub.newMutateRowsBatcher(Mockito.any(String.class)))
        .thenReturn(mockBulkMutationBatcher);
    Mockito.when(mockStub.newBulkReadRowsBatcher(Mockito.any(Query.class)))
        .thenReturn(mockBulkReadRowsBatcher);
  }

  @Test
  public void proxyCloseTest() throws Exception {
    bigtableDataClient.close();
    Mockito.verify(mockStub).close();
  }

  @Test
  public void existsTest() {
    Query expectedQuery =
        Query.create("fake-table")
            .rowKey("fake-row-key")
            .filter(
                FILTERS
                    .chain()
                    .filter(FILTERS.limit().cellsPerRow(1))
                    .filter(FILTERS.value().strip()));
    Row row = Row.create(ByteString.copyFromUtf8("fake-row-key"), ImmutableList.<RowCell>of());
    Mockito.when(mockReadRowCallable.futureCall(expectedQuery))
        .thenReturn(ApiFutures.immediateFuture(row))
        .thenReturn(ApiFutures.<Row>immediateFuture(null));

    boolean result = bigtableDataClient.exists("fake-table", "fake-row-key");
    boolean anotherResult =
        bigtableDataClient.exists("fake-table", ByteString.copyFromUtf8("fake-row-key"));

    assertThat(result).isTrue();
    assertThat(anotherResult).isFalse();

    Mockito.verify(mockReadRowCallable, Mockito.times(2)).futureCall(expectedQuery);
  }

  @Test
  public void existsAsyncTest() throws Exception {
    Query expectedQuery =
        Query.create("fake-table")
            .rowKey("fake-row-key")
            .filter(
                FILTERS
                    .chain()
                    .filter(FILTERS.limit().cellsPerRow(1))
                    .filter(FILTERS.value().strip()));
    Row row = Row.create(ByteString.copyFromUtf8("fake-row-key"), ImmutableList.<RowCell>of());

    Mockito.when(mockReadRowCallable.futureCall(expectedQuery))
        .thenReturn(ApiFutures.immediateFuture(row))
        .thenReturn(ApiFutures.<Row>immediateFuture(null));

    ApiFuture<Boolean> result =
        bigtableDataClient.existsAsync("fake-table", ByteString.copyFromUtf8("fake-row-key"));
    assertThat(result.get()).isTrue();

    ApiFuture<Boolean> anotherResult = bigtableDataClient.existsAsync("fake-table", "fake-row-key");
    assertThat(anotherResult.get()).isFalse();

    Mockito.verify(mockReadRowCallable, Mockito.times(2)).futureCall(expectedQuery);
  }

  @Test
  public void proxyReadRowsCallableTest() {
    assertThat(bigtableDataClient.readRowsCallable()).isSameInstanceAs(mockReadRowsCallable);
  }

  @Test
  public void proxyReadRowAsyncTest() {
    bigtableDataClient.readRowAsync("fake-table", ByteString.copyFromUtf8("fake-row-key"));
    Mockito.verify(mockReadRowCallable)
        .futureCall(Query.create("fake-table").rowKey("fake-row-key"));
  }

  @Test
  public void proxyReadRowStrAsyncTest() {
    bigtableDataClient.readRowAsync("fake-table", "fake-row-key");
    Mockito.verify(mockReadRowCallable)
        .futureCall(Query.create("fake-table").rowKey("fake-row-key"));
  }

  @Test
  public void readRowFilterAsyncTest() {
    // Build the filter expression
    Filter filter =
        FILTERS
            .chain()
            .filter(FILTERS.qualifier().regex("prefix.*"))
            .filter(FILTERS.limit().cellsPerRow(10));
    bigtableDataClient.readRowAsync("fake-table", ByteString.copyFromUtf8("fake-row-key"), filter);

    Mockito.verify(mockReadRowCallable)
        .futureCall(Query.create("fake-table").rowKey("fake-row-key").filter(filter));
  }

  @Test
  public void readRowFilterStrAsyncTest() {
    // Build the filter expression
    Filter filter =
        FILTERS
            .chain()
            .filter(FILTERS.qualifier().regex("prefix.*"))
            .filter(FILTERS.limit().cellsPerRow(10));
    bigtableDataClient.readRowAsync("fake-table", "fake-row-key", filter);

    Mockito.verify(mockReadRowCallable)
        .futureCall(Query.create("fake-table").rowKey("fake-row-key").filter(filter));
  }

  @Test
  public void readRowTest() {
    Row expectedRow =
        Row.create(ByteString.copyFromUtf8("fake-row-key"), ImmutableList.<RowCell>of());
    Mockito.when(mockReadRowCallable.futureCall(Query.create("fake-table").rowKey("fake-row-key")))
        .thenReturn(ApiFutures.immediateFuture(expectedRow));

    Row actualRow =
        bigtableDataClient.readRow("fake-table", ByteString.copyFromUtf8("fake-row-key"));

    assertThat(actualRow).isEqualTo(expectedRow);
  }

  @Test
  public void readRowStrTest() {
    Row expectedRow =
        Row.create(ByteString.copyFromUtf8("fake-row-key"), ImmutableList.<RowCell>of());
    Mockito.when(mockReadRowCallable.futureCall(Query.create("fake-table").rowKey("fake-row-key")))
        .thenReturn(ApiFutures.immediateFuture(expectedRow));

    Row actualRow = bigtableDataClient.readRow("fake-table", "fake-row-key");

    assertThat(actualRow).isEqualTo(expectedRow);
  }

  @Test
  public void readRowFilterTest() {
    // Build the filter expression
    Filter filter =
        FILTERS
            .chain()
            .filter(FILTERS.qualifier().regex("prefix.*"))
            .filter(FILTERS.limit().cellsPerRow(10));

    Row expectedRow =
        Row.create(ByteString.copyFromUtf8("fake-row-key"), ImmutableList.<RowCell>of());
    Mockito.when(
            mockReadRowCallable.futureCall(
                Query.create("fake-table").rowKey("fake-row-key").filter(filter)))
        .thenReturn(ApiFutures.immediateFuture(expectedRow));

    Row actualRow =
        bigtableDataClient.readRow("fake-table", ByteString.copyFromUtf8("fake-row-key"), filter);

    assertThat(actualRow).isEqualTo(expectedRow);
  }

  @Test
  public void readRowStrFilterTest() {
    // Build the filter expression
    Filter filter =
        FILTERS
            .chain()
            .filter(FILTERS.qualifier().regex("prefix.*"))
            .filter(FILTERS.limit().cellsPerRow(10));
    Row expectedRow =
        Row.create(ByteString.copyFromUtf8("fake-row-key"), ImmutableList.<RowCell>of());
    Mockito.when(
            mockReadRowCallable.futureCall(
                Query.create("fake-table").rowKey("fake-row-key").filter(filter)))
        .thenReturn(ApiFutures.immediateFuture(expectedRow));

    Row actualRow = bigtableDataClient.readRow("fake-table", "fake-row-key", filter);

    assertThat(actualRow).isEqualTo(expectedRow);
  }

  @Test
  public void proxyReadRowsSyncTest() {
    Query query = Query.create("fake-table");
    bigtableDataClient.readRows(query);

    Mockito.verify(mockReadRowsCallable).call(query);
  }

  @Test
  public void proxyReadRowsAsyncTest() {
    Query query = Query.create("fake-table");
    @SuppressWarnings("unchecked")
    ResponseObserver<Row> mockObserver = Mockito.mock(ResponseObserver.class);
    bigtableDataClient.readRowsAsync(query, mockObserver);

    Mockito.verify(mockReadRowsCallable).call(query, mockObserver);
  }

  @Test
  public void proxySampleRowKeysCallableTest() {
    assertThat(bigtableDataClient.sampleRowKeysCallable())
        .isSameInstanceAs(mockSampleRowKeysCallable);
  }

  @Test
  public void proxySampleRowKeysTest() {
    bigtableDataClient.sampleRowKeysAsync("fake-table");
    Mockito.verify(mockSampleRowKeysCallable).futureCall("fake-table");
  }

  @Test
  public void sampleRowKeysTest() {
    Mockito.when(mockSampleRowKeysCallable.futureCall(any(String.class)))
        .thenReturn(ApiFutures.immediateFuture(Collections.<KeyOffset>emptyList()));
    bigtableDataClient.sampleRowKeys("fake-table");
    Mockito.verify(mockSampleRowKeysCallable).futureCall("fake-table");
  }

  @Test
  public void proxyMutateRowCallableTest() {
    assertThat(bigtableDataClient.mutateRowCallable()).isSameInstanceAs(mockMutateRowCallable);
  }

  @Test
  public void proxyMutateRowTest() {
    RowMutation request =
        RowMutation.create("fake-table", "some-key")
            .setCell("some-family", "fake-qualifier", "fake-value");

    bigtableDataClient.mutateRowAsync(request);
    Mockito.verify(mockMutateRowCallable).futureCall(request);
  }

  @Test
  public void mutateRowTest() {
    Mockito.when(mockMutateRowCallable.futureCall(any(RowMutation.class)))
        .thenAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return ApiFutures.immediateFuture(Empty.getDefaultInstance());
              }
            });

    RowMutation request =
        RowMutation.create("fake-table", "some-key")
            .setCell("some-family", "fake-qualifier", "fake-value");

    bigtableDataClient.mutateRow(request);
    Mockito.verify(mockMutateRowCallable).futureCall(request);
  }

  @Test
  public void proxyBulkMutatesRowTest() {
    BulkMutation request =
        BulkMutation.create("fake-table")
            .add(
                "fake-key",
                Mutation.create().setCell("fake-family", "fake-qualifier", "fake-value"));

    bigtableDataClient.bulkMutateRowsAsync(request);
    Mockito.verify(mockBulkMutateRowsCallable).futureCall(request);
  }

  @Test
  public void bulkMutatesRowTest() {
    Mockito.when(mockBulkMutateRowsCallable.futureCall(any(BulkMutation.class)))
        .thenAnswer(
            new Answer() {
              @Override
              public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                return ApiFutures.immediateFuture(Empty.getDefaultInstance());
              }
            });

    BulkMutation request =
        BulkMutation.create("fake-table")
            .add(
                "fake-key",
                Mutation.create().setCell("fake-family", "fake-qualifier", "fake-value"));

    bigtableDataClient.bulkMutateRows(request);
    Mockito.verify(mockBulkMutateRowsCallable).futureCall(request);
  }

  @Test
  public void proxyNewBulkMutationBatcherTest() {
    ApiFuture<Void> expectedResponse = ApiFutures.immediateFuture(null);
    Batcher<RowMutationEntry, Void> batcher =
        bigtableDataClient.newBulkMutationBatcher("fake-table");
    RowMutationEntry request =
        RowMutationEntry.create("some-key").setCell("some-family", "fake-qualifier", "fake-value");
    Mockito.when(mockBulkMutationBatcher.add(request)).thenReturn(expectedResponse);

    ApiFuture<Void> actualRes = batcher.add(request);
    assertThat(actualRes).isSameInstanceAs(expectedResponse);

    Mockito.verify(mockStub).newMutateRowsBatcher(Mockito.any(String.class));
  }

  @Test
  public void proxyNewBulkReadRowsTest() {
    ApiFuture<Row> expectedResponse =
        ApiFutures.immediateFuture(
            Row.create(ByteString.copyFromUtf8("fake-row-key"), Collections.<RowCell>emptyList()));
    ByteString request = ByteString.copyFromUtf8("fake-row-key");

    Batcher<ByteString, Row> batcher = bigtableDataClient.newBulkReadRowsBatcher("fake-table");
    Mockito.when(mockBulkReadRowsBatcher.add(request)).thenReturn(expectedResponse);

    ApiFuture<Row> actualResponse = batcher.add(request);
    assertThat(actualResponse).isSameInstanceAs(expectedResponse);

    Mockito.verify(mockStub).newBulkReadRowsBatcher(Mockito.any(Query.class));
  }

  @Test
  public void proxyNewBulkReadRowsWithFilterTest() {
    ApiFuture<Row> expectedResponse =
        ApiFutures.immediateFuture(
            Row.create(ByteString.copyFromUtf8("fake-row-key"), Collections.<RowCell>emptyList()));
    ByteString request = ByteString.copyFromUtf8("fake-row-key");

    Batcher<ByteString, Row> batcher =
        bigtableDataClient.newBulkReadRowsBatcher("fake-table", FILTERS.key().regex("fake-row"));
    Mockito.when(mockBulkReadRowsBatcher.add(request)).thenReturn(expectedResponse);

    ApiFuture<Row> actualResponse = batcher.add(request);
    assertThat(actualResponse).isSameInstanceAs(expectedResponse);

    Mockito.verify(mockStub).newBulkReadRowsBatcher(Mockito.any(Query.class));
  }

  @Test
  public void proxyCheckAndMutateRowCallableTest() {
    assertThat(bigtableDataClient.checkAndMutateRowCallable())
        .isSameInstanceAs(mockStub.checkAndMutateRowCallable());
  }

  @Test
  public void proxyCheckAndMutateRowTest() {
    ConditionalRowMutation mutation =
        ConditionalRowMutation.create("fake-table", "fake-key")
            .then(Mutation.create().setCell("fake-family", "fake-qualifier", "fake-value"));
    bigtableDataClient.checkAndMutateRowAsync(mutation);

    Mockito.verify(mockCheckAndMutateRowCallable).futureCall(mutation);
  }

  @Test
  public void checkAndMutateRowTest() {
    Mockito.when(mockCheckAndMutateRowCallable.futureCall(any(ConditionalRowMutation.class)))
        .thenReturn(ApiFutures.immediateFuture(Boolean.TRUE));
    ConditionalRowMutation mutation =
        ConditionalRowMutation.create("fake-table", "fake-key")
            .then(Mutation.create().setCell("fake-family", "fake-qualifier", "fake-value"));
    bigtableDataClient.checkAndMutateRow(mutation);

    Mockito.verify(mockCheckAndMutateRowCallable).futureCall(mutation);
  }

  @Test
  public void proxyReadModifyWriteRowTest() {
    ReadModifyWriteRow request =
        ReadModifyWriteRow.create("fake-table", "some-key")
            .append("fake-family", "fake-qualifier", "suffix");
    bigtableDataClient.readModifyWriteRowAsync(request);
    Mockito.verify(mockReadModifyWriteRowCallable).futureCall(request);
  }

  @Test
  public void readModifyWriteRowTest() {
    Mockito.when(mockReadModifyWriteRowCallable.futureCall(any(ReadModifyWriteRow.class)))
        .thenReturn(
            ApiFutures.immediateFuture(
                Row.create(
                    ByteString.copyFromUtf8("fake-row-key"), Collections.<RowCell>emptyList())));
    ReadModifyWriteRow request =
        ReadModifyWriteRow.create("fake-table", "some-key")
            .append("fake-family", "fake-qualifier", "suffix");
    bigtableDataClient.readModifyWriteRow(request);
    Mockito.verify(mockReadModifyWriteRowCallable).futureCall(request);
  }

  @Test
  public void proxyReadModifyWriterRowCallableTest() {
    assertThat(bigtableDataClient.readModifyWriteRowCallable())
        .isSameInstanceAs(mockReadModifyWriteRowCallable);
  }
}
