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

import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.PartialRowResponse;
import com.google.bigtable.v2.TypedCell;
import com.google.bigtable.v2.TypedColumn;
import com.google.bigtable.v2.TypedFamily;
import com.google.bigtable.v2.TypedReadRowsResponse;
import com.google.bigtable.v2.TypedRow;
import com.google.bigtable.v2.TypedRows;
import com.google.bigtable.v2.TypedRowsBatch;
import com.google.bigtable.v2.Value;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CbtTestProxyTypedReadRowsTest {

  private static final String CLIENT_ID = "test-client";
  private static final String TABLE_NAME = "projects/p/instances/i/tables/t";

  private Server inProcessServer;
  private ManagedChannel inProcessChannel;
  private CbtTestProxy testProxy;
  private MockBigtableService mockBigtableService;

  @Before
  public void setUp() throws IOException {
    String serverName = InProcessServerBuilder.generateName();
    mockBigtableService = new MockBigtableService();
    inProcessServer =
        InProcessServerBuilder.forName(serverName)
            .directExecutor()
            .addService(mockBigtableService)
            .build()
            .start();

    inProcessChannel =
        InProcessChannelBuilder.forName(serverName).directExecutor().build();

    testProxy = CbtTestProxy.create();

    CbtTestProxy.CbtClient client =
        CbtTestProxy.CbtClient.create(
            null,
            null,
            inProcessChannel,
            BigtableGrpc.newStub(inProcessChannel),
            null);
    testProxy.registerClientForTest(CLIENT_ID, client);
  }

  @After
  public void tearDown() throws InterruptedException {
    testProxy.close();
    inProcessChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    inProcessServer.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
  }

  private static TypedRow createRow(String rowKey, String family, String col, String val) {
    return TypedRow.newBuilder()
        .setRowKey(Value.newBuilder().setStringValue(rowKey).build())
        .addFamilies(
            TypedFamily.newBuilder()
                .setFamilyName(family)
                .addColumns(
                    TypedColumn.newBuilder()
                        .setQualifier(Value.newBuilder().setStringValue(col).build())
                        .addCells(
                            TypedCell.newBuilder()
                                .setValue(Value.newBuilder().setStringValue(val).build())
                                .setTimestamp(Timestamp.newBuilder().setSeconds(12345).build())
                                .build())
                        .build())
                .build())
        .build();
  }

  @Test
  public void testTypedReadRows_successfulStream() throws Exception {
    TypedRow row1 = createRow("rk-1", "cf1", "cq1", "val1");
    TypedRow row2 = createRow("rk-2", "cf1", "cq2", "val2");
    TypedRows batch = TypedRows.newBuilder().addRows(row1).addRows(row2).build();
    ByteString batchBytes = batch.toByteString();
    int checksum = Hashing.crc32c().hashBytes(batchBytes.toByteArray()).asInt();

    TypedReadRowsResponse response =
        TypedReadRowsResponse.newBuilder()
            .setResponse(
                PartialRowResponse.newBuilder()
                    .setTypedRowsBatch(TypedRowsBatch.newBuilder().setBatchData(batchBytes).build())
                    .setFlush(
                        PartialRowResponse.Flush.newBuilder()
                            .setChecksum(checksum)
                            .setResumeToken(ByteString.copyFromUtf8("token-1"))
                            .build())
                    .build())
            .build();

    mockBigtableService.responses.add(response);

    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.TypedReadRowsRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .build())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK_VALUE);
    assertThat(result.getRowsCount()).isEqualTo(2);
    assertThat(result.getRows(0).getRowKey().getStringValue()).isEqualTo("rk-1");
    assertThat(result.getRows(1).getRowKey().getStringValue()).isEqualTo("rk-2");
  }

  @Test
  public void testTypedReadRows_fragmentedBatchReassembly() throws Exception {
    TypedRow row = createRow("rk-frag", "cf", "col", "value");
    TypedRows batch = TypedRows.newBuilder().addRows(row).build();
    ByteString batchBytes = batch.toByteString();
    int checksum = Hashing.crc32c().hashBytes(batchBytes.toByteArray()).asInt();

    int mid = batchBytes.size() / 2;
    ByteString part1 = batchBytes.substring(0, mid);
    ByteString part2 = batchBytes.substring(mid);

    TypedReadRowsResponse resp1 =
        TypedReadRowsResponse.newBuilder()
            .setResponse(
                PartialRowResponse.newBuilder()
                    .setTypedRowsBatch(TypedRowsBatch.newBuilder().setBatchData(part1).build())
                    .build())
            .build();

    TypedReadRowsResponse resp2 =
        TypedReadRowsResponse.newBuilder()
            .setResponse(
                PartialRowResponse.newBuilder()
                    .setTypedRowsBatch(TypedRowsBatch.newBuilder().setBatchData(part2).build())
                    .setFlush(PartialRowResponse.Flush.newBuilder().setChecksum(checksum).build())
                    .build())
            .build();

    mockBigtableService.responses.add(resp1);
    mockBigtableService.responses.add(resp2);

    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.TypedReadRowsRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .build())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK_VALUE);
    assertThat(result.getRowsCount()).isEqualTo(1);
    assertThat(result.getRows(0).getRowKey().getStringValue()).isEqualTo("rk-frag");
  }

  @Test
  public void testTypedReadRows_resetDiscardsBufferedData() throws Exception {
    TypedRow row = createRow("rk-valid", "cf", "col", "val");
    TypedRows batch = TypedRows.newBuilder().addRows(row).build();
    ByteString batchBytes = batch.toByteString();
    int checksum = Hashing.crc32c().hashBytes(batchBytes.toByteArray()).asInt();

    // 1. Partial response with junk bytes
    TypedReadRowsResponse junkResp =
        TypedReadRowsResponse.newBuilder()
            .setResponse(
                PartialRowResponse.newBuilder()
                    .setTypedRowsBatch(
                        TypedRowsBatch.newBuilder()
                            .setBatchData(ByteString.copyFromUtf8("invalid_bytes"))
                            .build())
                    .build())
            .build();

    // 2. Response with reset=true followed by valid batch and flush
    TypedReadRowsResponse validResp =
        TypedReadRowsResponse.newBuilder()
            .setResponse(
                PartialRowResponse.newBuilder()
                    .setReset(true)
                    .setTypedRowsBatch(TypedRowsBatch.newBuilder().setBatchData(batchBytes).build())
                    .setFlush(PartialRowResponse.Flush.newBuilder().setChecksum(checksum).build())
                    .build())
            .build();

    mockBigtableService.responses.add(junkResp);
    mockBigtableService.responses.add(validResp);

    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.TypedReadRowsRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .build())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK_VALUE);
    assertThat(result.getRowsCount()).isEqualTo(1);
    assertThat(result.getRows(0).getRowKey().getStringValue()).isEqualTo("rk-valid");
  }

  @Test
  public void testTypedReadRows_checksumMismatchReturnsDataLoss() throws Exception {
    ByteString data = ByteString.copyFromUtf8("some_data");
    int badChecksum = 999999;

    TypedReadRowsResponse response =
        TypedReadRowsResponse.newBuilder()
            .setResponse(
                PartialRowResponse.newBuilder()
                    .setTypedRowsBatch(TypedRowsBatch.newBuilder().setBatchData(data).build())
                    .setFlush(
                        PartialRowResponse.Flush.newBuilder().setChecksum(badChecksum).build())
                    .build())
            .build();

    mockBigtableService.responses.add(response);

    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.TypedReadRowsRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .build())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.DATA_LOSS_VALUE);
    assertThat(result.getStatus().getMessage()).contains("Checksum mismatch");
  }

  @Test
  public void testTypedReadRows_cancelAfterRowsStopsStream() throws Exception {
    for (int i = 1; i <= 5; i++) {
      TypedRow row = createRow("rk-" + i, "cf", "col", "val");
      TypedRows batch = TypedRows.newBuilder().addRows(row).build();
      ByteString batchBytes = batch.toByteString();
      int checksum = Hashing.crc32c().hashBytes(batchBytes.toByteArray()).asInt();

      mockBigtableService.responses.add(
          TypedReadRowsResponse.newBuilder()
              .setResponse(
                  PartialRowResponse.newBuilder()
                      .setTypedRowsBatch(
                          TypedRowsBatch.newBuilder().setBatchData(batchBytes).build())
                      .setFlush(
                          PartialRowResponse.Flush.newBuilder().setChecksum(checksum).build())
                      .build())
              .build());
    }

    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setCancelAfterRows(2)
            .setRequest(
                com.google.bigtable.v2.TypedReadRowsRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .build())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.OK_VALUE);
    assertThat(result.getRowsCount()).isEqualTo(2);
    assertThat(result.getRows(0).getRowKey().getStringValue()).isEqualTo("rk-1");
    assertThat(result.getRows(1).getRowKey().getStringValue()).isEqualTo("rk-2");
  }

  @Test
  public void testTypedReadRows_serverErrorPropagatedInStatus() throws Exception {
    mockBigtableService.errorToThrow =
        Status.NOT_FOUND.withDescription("Table does not exist").asRuntimeException();

    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(
                com.google.bigtable.v2.TypedReadRowsRequest.newBuilder()
                    .setTableName(TABLE_NAME)
                    .build())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.NOT_FOUND_VALUE);
    assertThat(result.getStatus().getMessage()).contains("Table does not exist");
  }

  @Test
  public void testTypedReadRows_missingTargetReturnsInvalidArgument() throws Exception {
    TypedReadRowsRequest request =
        TypedReadRowsRequest.newBuilder()
            .setClientId(CLIENT_ID)
            .setRequest(com.google.bigtable.v2.TypedReadRowsRequest.getDefaultInstance())
            .build();

    CountDownLatch latch = new CountDownLatch(1);
    List<TypedRowsResult> results = new ArrayList<>();
    testProxy.typedReadRows(
        request,
        new StreamObserver<TypedRowsResult>() {
          @Override
          public void onNext(TypedRowsResult value) {
            results.add(value);
          }

          @Override
          public void onError(Throwable t) {
            latch.countDown();
          }

          @Override
          public void onCompleted() {
            latch.countDown();
          }
        });

    assertThat(latch.await(5, TimeUnit.SECONDS)).isTrue();
    assertThat(results).hasSize(1);
    TypedRowsResult result = results.get(0);
    assertThat(result.getStatus().getCode()).isEqualTo(Code.INVALID_ARGUMENT_VALUE);
  }

  private static class MockBigtableService extends BigtableGrpc.BigtableImplBase {
    final List<TypedReadRowsResponse> responses = new ArrayList<>();
    RuntimeException errorToThrow = null;
    final AtomicBoolean wasCancelled = new AtomicBoolean(false);

    @Override
    public void typedReadRows(
        com.google.bigtable.v2.TypedReadRowsRequest request,
        StreamObserver<TypedReadRowsResponse> responseObserver) {
      if (errorToThrow != null) {
        responseObserver.onError(errorToThrow);
        return;
      }
      for (TypedReadRowsResponse resp : responses) {
        responseObserver.onNext(resp);
      }
      responseObserver.onCompleted();
    }
  }
}
