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
package com.google.cloud.bigquery.storage.v1beta1.stub.readrows;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigquery.storage.v1beta1.AvroProto.AvroRows;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageClient;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageGrpc.BigQueryStorageImplBase;
import com.google.cloud.bigquery.storage.v1beta1.BigQueryStorageSettings;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.Stream;
import com.google.cloud.bigquery.storage.v1beta1.Storage.StreamPosition;
import com.google.common.collect.Queues;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReadRowsRetryTest {

  private static final Stream DEFAULT_STREAM = Stream.newBuilder().setName("defaultStream").build();

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();

  private TestBigQueryStorageService service;
  private BigQueryStorageClient client;

  @Before
  public void setUp() throws IOException {
    service = new TestBigQueryStorageService();
    serverRule.getServiceRegistry().addService(service);

    BigQueryStorageSettings settings =
        BigQueryStorageSettings.newBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                FixedTransportChannelProvider.create(
                    GrpcTransportChannel.create(serverRule.getChannel())))
            .build();

    client = BigQueryStorageClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void happyPathTest() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 0);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7));

    Assert.assertEquals(17, getRowCount(request));
  }

  @Test
  public void immediateRetryTest() {
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

    Assert.assertEquals(17, getRowCount(request));
  }

  @Test
  public void multipleRetryTestWithZeroInitialOffset() {
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

    Assert.assertEquals(28, getRowCount(request));
  }

  @Test
  public void multipleRetryTestWithNonZeroInitialOffset() {
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

    Assert.assertEquals(25, getRowCount(request));
  }

  @Test
  public void errorAtTheVeryEndTest() {
    ReadRowsRequest request = RpcExpectation.createRequest("fake-stream", 0);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("fake-stream", 0)
            .respondWithNumberOfRows(10)
            .respondWithNumberOfRows(7)
            .respondWithStatus(Code.UNAVAILABLE));

    service.expectations.add(
        RpcExpectation.create().expectRequest("fake-stream", 17).respondWithNumberOfRows(0));

    Assert.assertEquals(17, getRowCount(request));
  }

  private int getRowCount(ReadRowsRequest request) {
    ServerStream<ReadRowsResponse> serverStream = client.readRowsCallable().call(request);
    int rowCount = 0;
    for (ReadRowsResponse readRowsResponse : serverStream) {
      rowCount += readRowsResponse.getAvroRows().getRowCount();
    }
    return rowCount;
  }

  private static class TestBigQueryStorageService extends BigQueryStorageImplBase {

    Queue<RpcExpectation> expectations = Queues.newArrayDeque();
    int currentRequestIndex = -1;

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {

      RpcExpectation expectedRpc = expectations.poll();
      currentRequestIndex++;

      Assert.assertNotNull(
          "Unexpected request #" + currentRequestIndex + ": " + request.toString(), expectedRpc);

      Assert.assertEquals(
          "Expected request #"
              + currentRequestIndex
              + " does not match actual request: "
              + request.toString(),
          expectedRpc.expectedRequest,
          request);

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
      return ReadRowsRequest.newBuilder()
          .setReadPosition(
              StreamPosition.newBuilder()
                  .setStream(Stream.newBuilder().setName(streamName))
                  .setOffset(offset))
          .build();
    }

    static ReadRowsResponse createResponse(int numberOfRows) {
      return ReadRowsResponse.newBuilder()
          .setAvroRows(AvroRows.newBuilder().setRowCount(numberOfRows))
          .build();
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
