/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.testproxy;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.PrepareQueryResponse;
import com.google.bigtable.v2.ProtoSchema;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ResultSetMetadata;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.bigtable.v2.Type;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.testproxy.CbtTestProxy.CbtClient;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Durations;
import com.google.rpc.Code;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.time.Instant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;

@RunWith(JUnit4.class)
public class CbtTestProxyTest {

  private static final String CLIENT_ID = "test-client";
  private static final String TABLE_NAME =
      "projects/my-project/instances/my-instance/tables/my-table";
  private static final String TABLE_ID = "my-table";

  private BigtableDataClient mockDataClient;
  private CbtTestProxy proxy;

  @Before
  public void setUp() {
    mockDataClient = mock(BigtableDataClient.class);
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilderForEmulator(8080)
            .setProjectId("my-project")
            .setInstanceId("my-instance")
            .build();
    proxy = CbtTestProxy.create();
    proxy.idClientMap.put(CLIENT_ID, CbtClient.create(settings, mockDataClient));
  }

  @Test
  public void testReadRowNotFoundEmitsEmptyRowResultWithOkStatus() {
    when(mockDataClient.readRow(eq(TABLE_ID), eq("missing-row"), any(Filter.class)))
        .thenReturn(null);

    @SuppressWarnings("unchecked")
    StreamObserver<RowResult> responseObserver = mock(StreamObserver.class);
    ReadRowRequest request =
        ReadRowRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setTableName(TABLE_NAME)
            .setRowKey("missing-row")
            .build();

    proxy.readRow(request, responseObserver);

    ArgumentCaptor<RowResult> resultCaptor = ArgumentCaptor.forClass(RowResult.class);
    verify(responseObserver).onNext(resultCaptor.capture());
    verify(responseObserver).onCompleted();

    RowResult result = resultCaptor.getValue();
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    assertThat(result.hasRow()).isFalse();
  }

  @Test
  public void testReadRowFoundEmitsPopulatedRowResultWithOkStatus() {
    Row row =
        Row.create(
            ByteString.copyFromUtf8("row-1"),
            ImmutableList.of(
                RowCell.create(
                    "cf",
                    ByteString.copyFromUtf8("col"),
                    1000L,
                    ImmutableList.of(),
                    ByteString.copyFromUtf8("val"))));
    when(mockDataClient.readRow(eq(TABLE_ID), eq("row-1"), any(Filter.class))).thenReturn(row);

    @SuppressWarnings("unchecked")
    StreamObserver<RowResult> responseObserver = mock(StreamObserver.class);
    ReadRowRequest request =
        ReadRowRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setTableName(TABLE_NAME)
            .setRowKey("row-1")
            .build();

    proxy.readRow(request, responseObserver);

    ArgumentCaptor<RowResult> resultCaptor = ArgumentCaptor.forClass(RowResult.class);
    verify(responseObserver).onNext(resultCaptor.capture());
    verify(responseObserver).onCompleted();

    RowResult result = resultCaptor.getValue();
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    assertThat(result.hasRow()).isTrue();
    assertThat(result.getRow().getKey()).isEqualTo(ByteString.copyFromUtf8("row-1"));
  }

  @Test
  public void testReadModifyWriteRowNullEmitsEmptyRowResultWithOkStatus() {
    when(mockDataClient.readModifyWriteRow(any(ReadModifyWriteRow.class))).thenReturn(null);

    @SuppressWarnings("unchecked")
    StreamObserver<RowResult> responseObserver = mock(StreamObserver.class);
    ReadModifyWriteRowRequest request =
        ReadModifyWriteRowRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.ReadModifyWriteRowRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .setRowKey(ByteString.copyFromUtf8("rmw-row"))
                    .addRules(
                        ReadModifyWriteRule.newBuilder()
                            .setFamilyName("cf")
                            .setColumnQualifier(ByteString.copyFromUtf8("col"))
                            .setAppendValue(ByteString.copyFromUtf8("v"))))
            .build();

    proxy.readModifyWriteRow(request, responseObserver);

    ArgumentCaptor<RowResult> resultCaptor = ArgumentCaptor.forClass(RowResult.class);
    verify(responseObserver).onNext(resultCaptor.capture());
    verify(responseObserver).onCompleted();

    RowResult result = resultCaptor.getValue();
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    assertThat(result.hasRow()).isFalse();
  }

  @After
  public void tearDown() {
    if (proxy != null) {
      proxy.close();
    }
  }

  private static class SlowBigtableService extends BigtableGrpc.BigtableImplBase {
    private final long delayMillis;

    SlowBigtableService(long delayMillis) {
      this.delayMillis = delayMillis;
    }

    private boolean sleepDelay() {
      try {
        Thread.sleep(delayMillis);
        return true;
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return false;
      }
    }

    @Override
    public void readRows(
        com.google.bigtable.v2.ReadRowsRequest request,
        StreamObserver<ReadRowsResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      responseObserver.onNext(ReadRowsResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRow(
        com.google.bigtable.v2.MutateRowRequest request,
        StreamObserver<MutateRowResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      responseObserver.onNext(MutateRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void mutateRows(
        com.google.bigtable.v2.MutateRowsRequest request,
        StreamObserver<MutateRowsResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      MutateRowsResponse.Builder builder = MutateRowsResponse.newBuilder();
      for (int i = 0; i < request.getEntriesCount(); i++) {
        builder
            .addEntriesBuilder()
            .setIndex(i)
            .setStatus(com.google.rpc.Status.newBuilder().setCode(Code.OK.getNumber()));
      }
      responseObserver.onNext(builder.build());
      responseObserver.onCompleted();
    }

    @Override
    public void sampleRowKeys(
        com.google.bigtable.v2.SampleRowKeysRequest request,
        StreamObserver<SampleRowKeysResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      responseObserver.onNext(SampleRowKeysResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void checkAndMutateRow(
        com.google.bigtable.v2.CheckAndMutateRowRequest request,
        StreamObserver<CheckAndMutateRowResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      responseObserver.onNext(
          CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build());
      responseObserver.onCompleted();
    }

    @Override
    public void readModifyWriteRow(
        com.google.bigtable.v2.ReadModifyWriteRowRequest request,
        StreamObserver<ReadModifyWriteRowResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      responseObserver.onNext(ReadModifyWriteRowResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void prepareQuery(
        com.google.bigtable.v2.PrepareQueryRequest request,
        StreamObserver<PrepareQueryResponse> responseObserver) {
      responseObserver.onNext(
          PrepareQueryResponse.newBuilder()
              .setPreparedQuery(ByteString.copyFromUtf8("plan"))
              .setValidUntil(
                  Timestamp.newBuilder()
                      .setSeconds(Instant.now().plusSeconds(3600).getEpochSecond())
                      .build())
              .setMetadata(
                  ResultSetMetadata.newBuilder()
                      .setProtoSchema(
                          ProtoSchema.newBuilder()
                              .addColumns(
                                  ColumnMetadata.newBuilder()
                                      .setName("col")
                                      .setType(
                                          Type.newBuilder()
                                              .setStringType(Type.String.getDefaultInstance())))))
              .build());
      responseObserver.onCompleted();
    }

    @Override
    public void executeQuery(
        com.google.bigtable.v2.ExecuteQueryRequest request,
        StreamObserver<ExecuteQueryResponse> responseObserver) {
      if (!sleepDelay()) {
        return;
      }
      responseObserver.onCompleted();
    }
  }

  @Test
  public void testPerOperationTimeoutSupersedesShorterClientTimeout() throws Exception {
    Server server =
        ServerBuilder.forPort(0).addService(new SlowBigtableService(200)).build().start();
    try {
      String clientId = "short-timeout-client";
      @SuppressWarnings("unchecked")
      StreamObserver<CreateClientResponse> createObserver = mock(StreamObserver.class);
      proxy.createClient(
          CreateClientRequest.newBuilder()
              .setClientId(clientId)
              .setDataTarget("localhost:" + server.getPort())
              .setProjectId("my-project")
              .setInstanceId("my-instance")
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          createObserver);
      verify(createObserver).onCompleted();

      // Without a per-request override, the 50ms client timeout expires during the 200ms delay.
      @SuppressWarnings("unchecked")
      StreamObserver<RowResult> defaultReadObserver = mock(StreamObserver.class);
      proxy.readRow(
          ReadRowRequest.newBuilder()
              .setClientId(clientId)
              .setTableName(TABLE_NAME)
              .setRowKey("row-1")
              .build(),
          defaultReadObserver);
      ArgumentCaptor<RowResult> defaultReadCaptor = ArgumentCaptor.forClass(RowResult.class);
      verify(defaultReadObserver).onNext(defaultReadCaptor.capture());
      assertThat(defaultReadCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A longer 2s per-operation timeout on ReadRowRequest supersedes the 50ms client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<RowResult> overrideReadObserver = mock(StreamObserver.class);
      proxy.readRow(
          ReadRowRequest.newBuilder()
              .setClientId(clientId)
              .setTableName(TABLE_NAME)
              .setRowKey("row-1")
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          overrideReadObserver);
      ArgumentCaptor<RowResult> overrideReadCaptor = ArgumentCaptor.forClass(RowResult.class);
      verify(overrideReadObserver).onNext(overrideReadCaptor.capture());
      assertThat(overrideReadCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on MutateRowRequest supersedes the 50ms client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<MutateRowResult> mutateObserver = mock(StreamObserver.class);
      proxy.mutateRow(
          MutateRowRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.MutateRowRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .setRowKey(ByteString.copyFromUtf8("row-1"))
                      .addMutations(
                          Mutation.newBuilder()
                              .setSetCell(
                                  Mutation.SetCell.newBuilder()
                                      .setFamilyName("cf")
                                      .setColumnQualifier(ByteString.copyFromUtf8("q"))
                                      .setTimestampMicros(1000L)
                                      .setValue(ByteString.copyFromUtf8("v")))))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          mutateObserver);
      ArgumentCaptor<MutateRowResult> mutateCaptor = ArgumentCaptor.forClass(MutateRowResult.class);
      verify(mutateObserver).onNext(mutateCaptor.capture());
      assertThat(mutateCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on MutateRowsRequest supersedes the 50ms client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<MutateRowsResult> bulkObserver = mock(StreamObserver.class);
      proxy.bulkMutateRows(
          MutateRowsRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.MutateRowsRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .addEntries(
                          com.google.bigtable.v2.MutateRowsRequest.Entry.newBuilder()
                              .setRowKey(ByteString.copyFromUtf8("row-1"))
                              .addMutations(
                                  Mutation.newBuilder()
                                      .setSetCell(
                                          Mutation.SetCell.newBuilder()
                                              .setFamilyName("cf")
                                              .setColumnQualifier(ByteString.copyFromUtf8("q"))
                                              .setTimestampMicros(1000L)
                                              .setValue(ByteString.copyFromUtf8("v"))))))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          bulkObserver);
      ArgumentCaptor<MutateRowsResult> bulkCaptor = ArgumentCaptor.forClass(MutateRowsResult.class);
      verify(bulkObserver).onNext(bulkCaptor.capture());
      assertThat(bulkCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on ReadRowsRequest supersedes the 50ms client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<RowsResult> readRowsObserver = mock(StreamObserver.class);
      proxy.readRows(
          ReadRowsRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ReadRowsRequest.newBuilder().setTableName(TABLE_NAME))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          readRowsObserver);
      ArgumentCaptor<RowsResult> readRowsCaptor = ArgumentCaptor.forClass(RowsResult.class);
      verify(readRowsObserver).onNext(readRowsCaptor.capture());
      assertThat(readRowsCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on SampleRowKeysRequest supersedes the 50ms client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<SampleRowKeysResult> sampleObserver = mock(StreamObserver.class);
      proxy.sampleRowKeys(
          SampleRowKeysRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.SampleRowKeysRequest.newBuilder().setTableName(TABLE_NAME))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          sampleObserver);
      ArgumentCaptor<SampleRowKeysResult> sampleCaptor =
          ArgumentCaptor.forClass(SampleRowKeysResult.class);
      verify(sampleObserver).onNext(sampleCaptor.capture());
      assertThat(sampleCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on CheckAndMutateRowRequest supersedes the 50ms client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<CheckAndMutateRowResult> camObserver = mock(StreamObserver.class);
      proxy.checkAndMutateRow(
          CheckAndMutateRowRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.CheckAndMutateRowRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .setRowKey(ByteString.copyFromUtf8("row-1"))
                      .addTrueMutations(
                          Mutation.newBuilder()
                              .setSetCell(
                                  Mutation.SetCell.newBuilder()
                                      .setFamilyName("cf")
                                      .setColumnQualifier(ByteString.copyFromUtf8("q"))
                                      .setTimestampMicros(1000L)
                                      .setValue(ByteString.copyFromUtf8("v")))))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          camObserver);
      ArgumentCaptor<CheckAndMutateRowResult> camCaptor =
          ArgumentCaptor.forClass(CheckAndMutateRowResult.class);
      verify(camObserver).onNext(camCaptor.capture());
      assertThat(camCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on ReadModifyWriteRowRequest supersedes the 50ms client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<RowResult> rmwObserver = mock(StreamObserver.class);
      proxy.readModifyWriteRow(
          ReadModifyWriteRowRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ReadModifyWriteRowRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .setRowKey(ByteString.copyFromUtf8("row-1"))
                      .addRules(
                          ReadModifyWriteRule.newBuilder()
                              .setFamilyName("cf")
                              .setColumnQualifier(ByteString.copyFromUtf8("q"))
                              .setAppendValue(ByteString.copyFromUtf8("v"))))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          rmwObserver);
      ArgumentCaptor<RowResult> rmwCaptor = ArgumentCaptor.forClass(RowResult.class);
      verify(rmwObserver).onNext(rmwCaptor.capture());
      assertThat(rmwCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());

      // A longer 2s per-operation timeout on ExecuteQueryRequest supersedes the 50ms client
      // timeout, whereas without a per-request override the 50ms client timeout expires.
      @SuppressWarnings("unchecked")
      StreamObserver<ExecuteQueryResult> defaultQueryObserver = mock(StreamObserver.class);
      proxy.executeQuery(
          ExecuteQueryRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ExecuteQueryRequest.newBuilder()
                      .setInstanceName("projects/my-project/instances/my-instance")
                      .setQuery("SELECT * FROM my-table"))
              .build(),
          defaultQueryObserver);
      ArgumentCaptor<ExecuteQueryResult> defaultQueryCaptor =
          ArgumentCaptor.forClass(ExecuteQueryResult.class);
      verify(defaultQueryObserver).onNext(defaultQueryCaptor.capture());
      assertThat(defaultQueryCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      @SuppressWarnings("unchecked")
      StreamObserver<ExecuteQueryResult> queryObserver = mock(StreamObserver.class);
      proxy.executeQuery(
          ExecuteQueryRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ExecuteQueryRequest.newBuilder()
                      .setInstanceName("projects/my-project/instances/my-instance")
                      .setQuery("SELECT * FROM my-table"))
              .setPerOperationTimeout(Durations.fromSeconds(2))
              .build(),
          queryObserver);
      ArgumentCaptor<ExecuteQueryResult> queryCaptor =
          ArgumentCaptor.forClass(ExecuteQueryResult.class);
      verify(queryObserver).onNext(queryCaptor.capture());
      assertThat(queryCaptor.getValue().getStatus().getCode()).isEqualTo(Code.OK.getNumber());
    } finally {
      server.shutdownNow();
    }
  }

  @Test
  public void testPerOperationTimeoutSupersedesLongerClientTimeout() throws Exception {
    Server server =
        ServerBuilder.forPort(0).addService(new SlowBigtableService(200)).build().start();
    try {
      String clientId = "long-timeout-client";
      @SuppressWarnings("unchecked")
      StreamObserver<CreateClientResponse> createObserver = mock(StreamObserver.class);
      proxy.createClient(
          CreateClientRequest.newBuilder()
              .setClientId(clientId)
              .setDataTarget("localhost:" + server.getPort())
              .setProjectId("my-project")
              .setInstanceId("my-instance")
              .setPerOperationTimeout(Durations.fromSeconds(5))
              .build(),
          createObserver);
      verify(createObserver).onCompleted();

      // A shorter 50ms per-operation timeout on ReadRowRequest supersedes the 5s client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<RowResult> readObserver = mock(StreamObserver.class);
      proxy.readRow(
          ReadRowRequest.newBuilder()
              .setClientId(clientId)
              .setTableName(TABLE_NAME)
              .setRowKey("row-1")
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          readObserver);
      ArgumentCaptor<RowResult> readCaptor = ArgumentCaptor.forClass(RowResult.class);
      verify(readObserver).onNext(readCaptor.capture());
      assertThat(readCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on MutateRowRequest supersedes the 5s client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<MutateRowResult> mutateObserver = mock(StreamObserver.class);
      proxy.mutateRow(
          MutateRowRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.MutateRowRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .setRowKey(ByteString.copyFromUtf8("row-1"))
                      .addMutations(
                          Mutation.newBuilder()
                              .setSetCell(
                                  Mutation.SetCell.newBuilder()
                                      .setFamilyName("cf")
                                      .setColumnQualifier(ByteString.copyFromUtf8("q"))
                                      .setTimestampMicros(1000L)
                                      .setValue(ByteString.copyFromUtf8("v")))))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          mutateObserver);
      ArgumentCaptor<MutateRowResult> mutateCaptor = ArgumentCaptor.forClass(MutateRowResult.class);
      verify(mutateObserver).onNext(mutateCaptor.capture());
      assertThat(mutateCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on MutateRowsRequest supersedes the 5s client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<MutateRowsResult> bulkObserver = mock(StreamObserver.class);
      proxy.bulkMutateRows(
          MutateRowsRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.MutateRowsRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .addEntries(
                          com.google.bigtable.v2.MutateRowsRequest.Entry.newBuilder()
                              .setRowKey(ByteString.copyFromUtf8("row-1"))
                              .addMutations(
                                  Mutation.newBuilder()
                                      .setSetCell(
                                          Mutation.SetCell.newBuilder()
                                              .setFamilyName("cf")
                                              .setColumnQualifier(ByteString.copyFromUtf8("q"))
                                              .setTimestampMicros(1000L)
                                              .setValue(ByteString.copyFromUtf8("v"))))))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          bulkObserver);
      ArgumentCaptor<MutateRowsResult> bulkCaptor = ArgumentCaptor.forClass(MutateRowsResult.class);
      verify(bulkObserver).onNext(bulkCaptor.capture());
      assertThat(bulkCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on ReadRowsRequest supersedes the 5s client timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<RowsResult> readRowsObserver = mock(StreamObserver.class);
      proxy.readRows(
          ReadRowsRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ReadRowsRequest.newBuilder().setTableName(TABLE_NAME))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          readRowsObserver);
      ArgumentCaptor<RowsResult> readRowsCaptor = ArgumentCaptor.forClass(RowsResult.class);
      verify(readRowsObserver).onNext(readRowsCaptor.capture());
      assertThat(readRowsCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on SampleRowKeysRequest supersedes the 5s client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<SampleRowKeysResult> sampleObserver = mock(StreamObserver.class);
      proxy.sampleRowKeys(
          SampleRowKeysRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.SampleRowKeysRequest.newBuilder().setTableName(TABLE_NAME))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          sampleObserver);
      ArgumentCaptor<SampleRowKeysResult> sampleCaptor =
          ArgumentCaptor.forClass(SampleRowKeysResult.class);
      verify(sampleObserver).onNext(sampleCaptor.capture());
      assertThat(sampleCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on CheckAndMutateRowRequest supersedes the 5s client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<CheckAndMutateRowResult> camObserver = mock(StreamObserver.class);
      proxy.checkAndMutateRow(
          CheckAndMutateRowRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.CheckAndMutateRowRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .setRowKey(ByteString.copyFromUtf8("row-1"))
                      .addTrueMutations(
                          Mutation.newBuilder()
                              .setSetCell(
                                  Mutation.SetCell.newBuilder()
                                      .setFamilyName("cf")
                                      .setColumnQualifier(ByteString.copyFromUtf8("q"))
                                      .setTimestampMicros(1000L)
                                      .setValue(ByteString.copyFromUtf8("v")))))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          camObserver);
      ArgumentCaptor<CheckAndMutateRowResult> camCaptor =
          ArgumentCaptor.forClass(CheckAndMutateRowResult.class);
      verify(camObserver).onNext(camCaptor.capture());
      assertThat(camCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on ReadModifyWriteRowRequest supersedes the 5s client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<RowResult> rmwObserver = mock(StreamObserver.class);
      proxy.readModifyWriteRow(
          ReadModifyWriteRowRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ReadModifyWriteRowRequest.newBuilder()
                      .setTableName(TABLE_NAME)
                      .setRowKey(ByteString.copyFromUtf8("row-1"))
                      .addRules(
                          ReadModifyWriteRule.newBuilder()
                              .setFamilyName("cf")
                              .setColumnQualifier(ByteString.copyFromUtf8("q"))
                              .setAppendValue(ByteString.copyFromUtf8("v"))))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          rmwObserver);
      ArgumentCaptor<RowResult> rmwCaptor = ArgumentCaptor.forClass(RowResult.class);
      verify(rmwObserver).onNext(rmwCaptor.capture());
      assertThat(rmwCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());

      // A shorter 50ms per-operation timeout on ExecuteQueryRequest supersedes the 5s client
      // timeout.
      @SuppressWarnings("unchecked")
      StreamObserver<ExecuteQueryResult> queryObserver = mock(StreamObserver.class);
      proxy.executeQuery(
          ExecuteQueryRequest.newBuilder()
              .setClientId(clientId)
              .setRequest(
                  com.google.bigtable.v2.ExecuteQueryRequest.newBuilder()
                      .setInstanceName("projects/my-project/instances/my-instance")
                      .setQuery("SELECT * FROM my-table"))
              .setPerOperationTimeout(Durations.fromMillis(50))
              .build(),
          queryObserver);
      ArgumentCaptor<ExecuteQueryResult> queryCaptor =
          ArgumentCaptor.forClass(ExecuteQueryResult.class);
      verify(queryObserver).onNext(queryCaptor.capture());
      assertThat(queryCaptor.getValue().getStatus().getCode())
          .isEqualTo(Code.DEADLINE_EXCEEDED.getNumber());
    } finally {
      server.shutdownNow();
    }
  }
}
