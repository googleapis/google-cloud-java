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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.InternalException;
import com.google.api.gax.rpc.ServerStream;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.bigtable.v2.RowRange;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Range;
import com.google.common.truth.Truth;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.util.List;
import java.util.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadRowsRetryTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();
  private TestBigtableService service;
  private BigtableDataClient client;

  @Before
  public void setUp() throws IOException {
    service = new TestBigtableService();
    serverRule.getServiceRegistry().addService(service);

    BigtableDataSettings.Builder settings =
        BigtableDataSettings.newBuilder()
            .setProjectId(PROJECT_ID)
            .setInstanceId(INSTANCE_ID)
            .setCredentialsProvider(NoCredentialsProvider.create());

    settings
        .stubSettings()
        .setTransportChannelProvider(
            FixedTransportChannelProvider.create(
                GrpcTransportChannel.create(serverRule.getChannel())))
        .build();

    client = BigtableDataClient.create(settings.build());
  }

  @After
  public void tearDown() {
    if (client != null) {
      client.close();
    }
  }

  @Test
  public void happyPathTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("k1")
            .expectRequest(Range.closedOpen("r1", "r3"))
            .respondWith("k1", "r1", "r2"));

    List<String> actualResults = getResults(Query.create(TABLE_ID).rowKey("k1").range("r1", "r3"));
    Truth.assertThat(actualResults).containsExactly("k1", "r1", "r2").inOrder();
  }

  @Test
  public void immediateRetryTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("k1")
            .expectRequest(Range.closedOpen("r1", "r3"))
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("k1")
            .expectRequest(Range.closedOpen("r1", "r3"))
            .respondWith("k1", "r1", "r2"));

    List<String> actualResults = getResults(Query.create(TABLE_ID).rowKey("k1").range("r1", "r3"));
    Truth.assertThat(actualResults).containsExactly("k1", "r1", "r2").inOrder();
  }

  @Test
  public void multipleRetryTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.closedOpen("r1", "r9"))
            .respondWith("r1", "r2", "r3", "r4")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.open("r4", "r9"))
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.open("r4", "r9"))
            .respondWith("r5", "r6", "r7")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create().expectRequest(Range.open("r7", "r9")).respondWith("r8"));

    List<String> actualResults = getResults(Query.create(TABLE_ID).range("r1", "r9"));
    Truth.assertThat(actualResults)
        .containsExactly("r1", "r2", "r3", "r4", "r5", "r6", "r7", "r8")
        .inOrder();
  }

  @Test
  public void rowLimitTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.closedOpen("r1", "r3"))
            .expectRowLimit(2)
            .respondWith("r1")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.open("r1", "r3"))
            .expectRowLimit(1)
            .respondWith("r2"));

    List<String> actualResults = getResults(Query.create(TABLE_ID).range("r1", "r3").limit(2));
    Truth.assertThat(actualResults).containsExactly("r1", "r2").inOrder();
  }

  @Test
  public void errorAfterRowLimitMetTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.closedOpen("r1", "r3"))
            .expectRowLimit(2)
            .respondWith("r1", "r2")
            .respondWithStatus(Code.UNAVAILABLE));

    // Second retry request is handled locally in ReadRowsRetryCompletedCallable

    List<String> actualResults = getResults(Query.create(TABLE_ID).range("r1", "r3").limit(2));

    Truth.assertThat(actualResults).containsExactly("r1", "r2");
  }

  @Test
  public void errorAfterRequestCompleteTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.closedOpen("r1", "r3"))
            .expectRequest("r4")
            .respondWith("r2", "r4")
            .respondWithStatus(Code.UNAVAILABLE));

    // Second retry request is handled locally in ReadRowsRetryCompletedCallable

    List<String> actualResults = getResults(Query.create(TABLE_ID).range("r1", "r3").rowKey("r4"));

    Truth.assertThat(actualResults).containsExactly("r2", "r4");
  }

  @Test
  public void pointTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("r1", "r2")
            .respondWith("r1")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(RpcExpectation.create().expectRequest("r2").respondWith("r2"));

    List<String> actualResults = getResults(Query.create(TABLE_ID).rowKey("r1").rowKey("r2"));
    Truth.assertThat(actualResults).containsExactly("r1", "r2").inOrder();
  }

  @Test
  public void fullTableScanTest() {
    service.expectations.add(
        RpcExpectation.create().respondWith("r1").respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create().expectRequest(Range.greaterThan("r1")).respondWith("r2"));
    List<String> actualResults = getResults(Query.create(TABLE_ID));
    Truth.assertThat(actualResults).containsExactly("r1", "r2").inOrder();
  }

  @Test
  public void retryUnboundedStartTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.lessThan("r9"))
            .respondWith("r1")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create().expectRequest(Range.open("r1", "r9")).respondWith("r2"));

    List<String> actualResults =
        getResults(Query.create(TABLE_ID).range(ByteStringRange.unbounded().endOpen("r9")));
    Truth.assertThat(actualResults).containsExactly("r1", "r2").inOrder();
  }

  @Test
  public void retryUnboundedEndTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.atLeast("r1"))
            .respondWith("r1")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create().expectRequest(Range.greaterThan("r1")).respondWith("r2"));

    List<String> actualResults =
        getResults(Query.create(TABLE_ID).range(ByteStringRange.unbounded().startClosed("r1")));
    Truth.assertThat(actualResults).containsExactly("r1", "r2").inOrder();
  }

  @Test
  public void retryWithLastScannedKeyTest() {
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest(Range.closedOpen("r1", "r9"))
            .respondWithLastScannedKey("r5")
            .respondWithStatus(Code.UNAVAILABLE));
    service.expectations.add(
        RpcExpectation.create().expectRequest(Range.open("r5", "r9")).respondWith("r7"));
    List<String> actualResults =
        getResults(Query.create(TABLE_ID).range(ByteStringRange.create("r1", "r9")));
    Truth.assertThat(actualResults).containsExactly("r7").inOrder();
  }

  @Test
  public void retryRstStreamExceptionTest() {
    ApiException exception =
        new InternalException(
            new StatusRuntimeException(
                Status.INTERNAL.withDescription(
                    "INTERNAL: HTTP/2 error code: INTERNAL_ERROR\nReceived Rst Stream")),
            GrpcStatusCode.of(Code.INTERNAL),
            false);
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("k1")
            .expectRequest(Range.closedOpen("r1", "r3"))
            .respondWithException(Code.INTERNAL, exception));
    service.expectations.add(
        RpcExpectation.create()
            .expectRequest("k1")
            .expectRequest(Range.closedOpen("r1", "r3"))
            .respondWith("k1", "r1", "r2"));

    List<String> actualResults = getResults(Query.create(TABLE_ID).rowKey("k1").range("r1", "r3"));
    Truth.assertThat(actualResults).containsExactly("k1", "r1", "r2").inOrder();
  }

  private List<String> getResults(Query query) {
    ServerStream<Row> actualRows = client.readRows(query);
    List<String> actualValues = Lists.newArrayList();
    for (Row row : actualRows) {
      actualValues.add(row.getKey().toStringUtf8());
    }
    return actualValues;
  }

  private static class TestBigtableService extends BigtableGrpc.BigtableImplBase {
    Queue<RpcExpectation> expectations = Queues.newArrayDeque();
    int i = -1;

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {

      RpcExpectation expectedRpc = expectations.poll();
      i++;

      Truth.assertWithMessage("Unexpected request#" + i + ":" + request.toString())
          .that(expectedRpc)
          .isNotNull();
      Truth.assertWithMessage("Unexpected request#" + i)
          .that(request)
          .isEqualTo(expectedRpc.getExpectedRequest());

      for (ReadRowsResponse response : expectedRpc.responses) {
        responseObserver.onNext(response);
      }
      if (expectedRpc.statusCode.toStatus().isOk()) {
        responseObserver.onCompleted();
      } else if (expectedRpc.exception != null) {
        responseObserver.onError(expectedRpc.exception);
      } else {
        responseObserver.onError(expectedRpc.statusCode.toStatus().asRuntimeException());
      }
    }
  }

  private static class RpcExpectation {
    ReadRowsRequest.Builder requestBuilder;
    Status.Code statusCode;
    ApiException exception;
    List<ReadRowsResponse> responses;

    private RpcExpectation() {
      this.requestBuilder =
          ReadRowsRequest.newBuilder()
              .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID));
      this.statusCode = Status.Code.OK;
      this.responses = Lists.newArrayList();
    }

    static RpcExpectation create() {
      return new RpcExpectation();
    }

    RpcExpectation expectRequest(String... keys) {
      for (String key : keys) {
        requestBuilder.getRowsBuilder().addRowKeys(ByteString.copyFromUtf8(key));
      }
      return this;
    }

    RpcExpectation expectRequest(Range<String> range) {
      RowRange.Builder rowRange = requestBuilder.getRowsBuilder().addRowRangesBuilder();

      if (range.hasLowerBound()) {
        switch (range.lowerBoundType()) {
          case CLOSED:
            rowRange.setStartKeyClosed(ByteString.copyFromUtf8(range.lowerEndpoint()));
            break;
          case OPEN:
            rowRange.setStartKeyOpen(ByteString.copyFromUtf8(range.lowerEndpoint()));
            break;
          default:
            throw new IllegalArgumentException(
                "Unexpected lowerBoundType: " + range.lowerBoundType());
        }
      } else {
        rowRange.clearStartKey();
      }

      if (range.hasUpperBound()) {
        switch (range.upperBoundType()) {
          case CLOSED:
            rowRange.setEndKeyClosed(ByteString.copyFromUtf8(range.upperEndpoint()));
            break;
          case OPEN:
            rowRange.setEndKeyOpen(ByteString.copyFromUtf8(range.upperEndpoint()));
            break;
          default:
            throw new IllegalArgumentException(
                "Unexpected upperBoundType: " + range.upperBoundType());
        }
      } else {
        rowRange.clearEndKey();
      }

      return this;
    }

    RpcExpectation expectRowLimit(int limit) {
      requestBuilder.setRowsLimit(limit);
      return this;
    }

    RpcExpectation respondWithStatus(Status.Code code) {
      this.statusCode = code;
      return this;
    }

    RpcExpectation respondWithException(Status.Code code, ApiException exception) {
      this.statusCode = code;
      this.exception = exception;
      return this;
    }

    RpcExpectation respondWith(String... responses) {
      for (String response : responses) {
        this.responses.add(
            ReadRowsResponse.newBuilder()
                .addChunks(
                    CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8(response))
                        .setFamilyName(StringValue.newBuilder().setValue("family").build())
                        .setQualifier(BytesValue.newBuilder().setValue(ByteString.EMPTY).build())
                        .setTimestampMicros(10_000)
                        .setValue(ByteString.copyFromUtf8("value"))
                        .setCommitRow(true))
                .build());
      }
      return this;
    }

    RpcExpectation respondWithLastScannedKey(String key) {
      this.responses.add(
          ReadRowsResponse.newBuilder().setLastScannedRowKey(ByteString.copyFromUtf8(key)).build());
      return this;
    }

    ReadRowsRequest getExpectedRequest() {
      return requestBuilder.build();
    }
  }
}
