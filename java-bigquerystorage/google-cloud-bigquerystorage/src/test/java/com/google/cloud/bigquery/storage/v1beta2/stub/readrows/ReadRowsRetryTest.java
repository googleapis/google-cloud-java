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
package com.google.cloud.bigquery.storage.v1beta2.stub.readrows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.InProcessServer;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadGrpc.BigQueryReadImplBase;
import com.google.cloud.bigquery.storage.v1beta2.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.ReadRowsResponse;
import com.google.common.collect.Queues;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadRowsRetryTest {

  private TestBigQueryStorageService service;
  private BigQueryReadClient client;
  private InProcessServer<?> server;
  private LocalChannelProvider channelProvider;

  @BeforeEach
  void setUp() throws Exception {
    service = new TestBigQueryStorageService();
    String serverName = UUID.randomUUID().toString();
    server = new InProcessServer<>(service, serverName);
    server.start();
    channelProvider = LocalChannelProvider.create(serverName);

    BigQueryReadSettings settings =
        BigQueryReadSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(channelProvider)
            .build();

    client = BigQueryReadClient.create(settings);
  }

  @AfterEach
  void tearDown() throws Exception {
    client.close();
    server.stop();
    server.blockUntilShutdown();
  }

  @Test
  void happyPathTest() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 0);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7));

    assertEquals(17, getRowCount(request));
  }

  @Test
  void immediateRetryTest() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 0);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7));

    assertEquals(17, getRowCount(request));
  }

  @Test
  void multipleRetryTestWithZeroInitialOffset() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 0);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithNumberOfRows(5)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 5)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create().expectRequest("fake-stream", 22).respondWithNumberOfRows(6));

    assertEquals(28, getRowCount(request));
  }

  @Test
  void multipleRetryTestWithNonZeroInitialOffset() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 17);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 17)
            .respondWithNumberOfRows(5)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 22)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create().expectRequest("fake-stream", 39).respondWithNumberOfRows(3));

    assertEquals(25, getRowCount(request));
  }

  @Test
  void errorAtTheVeryEndTest() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 0);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create().expectRequest("fake-stream", 17).respondWithNumberOfRows(0));

    assertEquals(17, getRowCount(request));
  }

  private int getRowCount(ReadRowsRequest request) {
    ServerStream<ReadRowsResponse> serverStream = client.readRowsCallable().call(request);
    int rowCount = 0;
    for (ReadRowsResponse readRowsResponse : serverStream) {
      rowCount += readRowsResponse.getRowCount();
    }
    return rowCount;
  }

  private static class TestBigQueryStorageService extends BigQueryReadImplBase {

    Queue<RpcExpectation> expectations = Queues.newArrayDeque();
    int currentRequestIndex = -1;

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {

      RpcExpectation expectedRpc = expectations.poll();
      currentRequestIndex++;

      assertNotNull(
          expectedRpc, "Unexpected request #" + currentRequestIndex + ": " + request.toString());
      assertEquals(
          expectedRpc.expectedRequest,
          request,
          "Expected request #"
              + currentRequestIndex
              + " does not match actual request: "
              + request.toString());
      for (ReadRowsResponse response : expectedRpc.responses) {
        responseObserver.onNext(response);
      }

      if (expectedRpc.statusCode.toStatus().isOk()) {
        responseObserver.onCompleted();
      } else {
        responseObserver.onError(expectedRpc.statusCode.toStatus().asRuntimeException());
      }
    }
  }

  private static class RpcExpectation {

    ReadRowsRequest expectedRequest;
    Code statusCode;
    List<ReadRowsResponse> responses;

    private RpcExpectation() {
      statusCode = Code.OK;
      responses = new ArrayList<>();
    }

    static RpcExpectation create() {
      return new RpcExpectation();
    }

    static ReadRowsRequest createRequest(String streamName, long offset) {
      return ReadRowsRequest.newBuilder().setReadStream(streamName).setOffset(offset).build();
    }

    static ReadRowsResponse createResponse(int numberOfRows) {
      return ReadRowsResponse.newBuilder().setRowCount(numberOfRows).build();
    }

    RpcExpectation expectRequest(String streamName, long offset) {
      expectedRequest = createRequest(streamName, offset);
      return this;
    }

    RpcExpectation respondWithNumberOfRows(int numberOfRows) {
      responses.add(createResponse(numberOfRows));
      return this;
    }

    RpcExpectation respondWithStatus(Code code) {
      this.statusCode = code;
      return this;
    }
  }
}
