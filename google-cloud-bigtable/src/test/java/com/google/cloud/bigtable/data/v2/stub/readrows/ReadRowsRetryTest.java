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

import com.google.api.client.util.Lists;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.ServerStream;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.bigtable.v2.BigtableGrpc;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.ReadRowsResponse.CellChunk;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.common.collect.Queues;
import com.google.common.collect.Range;
import com.google.common.truth.Truth;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.StringValue;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcServerRule;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ReadRowsRetryTest {
  private static final InstanceName instanceName = InstanceName.of("fake-project", "fake-instance");

  private static final TableName tableName =
      TableName.of(instanceName.getProject(), instanceName.getInstance(), "fake-table");

  @Rule public GrpcServerRule serverRule = new GrpcServerRule();
  private TestBigtableService service;
  private BigtableDataClient client;

  @Before
  public void setUp() throws IOException {
    service = new TestBigtableService();
    serverRule.getServiceRegistry().addService(service);

    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder()
            .setInstanceName(instanceName)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                FixedTransportChannelProvider.create(
                    GrpcTransportChannel.create(serverRule.getChannel())))
            .build();

    client = BigtableDataClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
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

    List<String> actualResults =
        getResults(Query.create(tableName.getTable()).rowKey("k1").range("r1", "r3"));
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

    List<String> actualResults =
        getResults(Query.create(tableName.getTable()).rowKey("k1").range("r1", "r3"));
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

    List<String> actualResults = getResults(Query.create(tableName.getTable()).range("r1", "r9"));
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

    List<String> actualResults =
        getResults(Query.create(tableName.getTable()).range("r1", "r3").limit(2));
    Truth.assertThat(actualResults).containsExactly("r1", "r2").inOrder();
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

    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {

      RpcExpectation expectedRpc = expectations.poll();

      Truth.assertWithMessage("Unexpected request: " + request.toString())
          .that(expectedRpc)
          .isNotNull();
      Truth.assertThat(request).isEqualTo(expectedRpc.getExpectedRequest());

      for (String key : expectedRpc.responses) {
        ReadRowsResponse response =
            ReadRowsResponse.newBuilder()
                .addChunks(
                    CellChunk.newBuilder()
                        .setRowKey(ByteString.copyFromUtf8(key))
                        .setFamilyName(StringValue.newBuilder().setValue("family"))
                        .setQualifier(BytesValue.newBuilder().setValue(ByteString.EMPTY))
                        .setTimestampMicros(1_000)
                        .setValue(ByteString.copyFromUtf8("value"))
                        .setCommitRow(true))
                .build();

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
    ReadRowsRequest.Builder requestBuilder;
    Status.Code statusCode;
    List<String> responses;

    private RpcExpectation() {
      this.requestBuilder = ReadRowsRequest.newBuilder().setTableName(tableName.toString());
      this.statusCode = Status.Code.OK;
      this.responses = Lists.newArrayList();
    }

    static RpcExpectation create() {
      return new RpcExpectation();
    }

    RpcExpectation expectRequest(String key) {
      requestBuilder.getRowsBuilder().addRowKeys(ByteString.copyFromUtf8(key));
      return this;
    }

    RpcExpectation expectRequest(Range<String> range) {
      RowRange.Builder rowRange = requestBuilder.getRowsBuilder().addRowRangesBuilder();

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

    RpcExpectation respondWith(String... responses) {
      this.responses.addAll(Arrays.asList(responses));
      return this;
    }

    ReadRowsRequest getExpectedRequest() {
      return requestBuilder.build();
    }
  }
}
