/*
 * Copyright 2019 Google LLC
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

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.bigtable.v2.TableName;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class BaseBigtableDataClientTest {
  private static MockBigtable mockBigtable;
  private static MockServiceHelper serviceHelper;
  private BaseBigtableDataClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockBigtable = new MockBigtable();
    serviceHelper =
        new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockBigtable));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
    BaseBigtableDataSettings settings =
        BaseBigtableDataSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BaseBigtableDataClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsTest() throws Exception {
    ByteString lastScannedRowKey = ByteString.copyFromUtf8("-126");
    ReadRowsResponse expectedResponse =
        ReadRowsResponse.newBuilder().setLastScannedRowKey(lastScannedRowKey).build();
    mockBigtable.addResponse(expectedResponse);
    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder().setTableName(tableName.toString()).build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);
    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder().setTableName(tableName.toString()).build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void sampleRowKeysTest() throws Exception {
    ByteString rowKey = ByteString.copyFromUtf8("122");
    long offsetBytes = 889884095L;
    SampleRowKeysResponse expectedResponse =
        SampleRowKeysResponse.newBuilder().setRowKey(rowKey).setOffsetBytes(offsetBytes).build();
    mockBigtable.addResponse(expectedResponse);
    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    SampleRowKeysRequest request =
        SampleRowKeysRequest.newBuilder().setTableName(tableName.toString()).build();

    MockStreamObserver<SampleRowKeysResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse> callable =
        client.sampleRowKeysCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<SampleRowKeysResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void sampleRowKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);
    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    SampleRowKeysRequest request =
        SampleRowKeysRequest.newBuilder().setTableName(tableName.toString()).build();

    MockStreamObserver<SampleRowKeysResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse> callable =
        client.sampleRowKeysCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<SampleRowKeysResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void mutateRowTest() {
    MutateRowResponse expectedResponse = MutateRowResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.copyFromUtf8("122");
    List<Mutation> mutations = new ArrayList<>();

    MutateRowResponse actualResponse = client.mutateRow(tableName, rowKey, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MutateRowRequest actualRequest = (MutateRowRequest) actualRequests.get(0);

    Assert.assertEquals(tableName, TableName.parse(actualRequest.getTableName()));
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void mutateRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.copyFromUtf8("122");
      List<Mutation> mutations = new ArrayList<>();

      client.mutateRow(tableName, rowKey, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void mutateRowsTest() throws Exception {
    MutateRowsResponse expectedResponse = MutateRowsResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);
    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    List<MutateRowsRequest.Entry> entries = new ArrayList<>();
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .setTableName(tableName.toString())
            .addAllEntries(entries)
            .build();

    MockStreamObserver<MutateRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> callable =
        client.mutateRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<MutateRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void mutateRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);
    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    List<MutateRowsRequest.Entry> entries = new ArrayList<>();
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .setTableName(tableName.toString())
            .addAllEntries(entries)
            .build();

    MockStreamObserver<MutateRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> callable =
        client.mutateRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<MutateRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void checkAndMutateRowTest() {
    boolean predicateMatched = true;
    CheckAndMutateRowResponse expectedResponse =
        CheckAndMutateRowResponse.newBuilder().setPredicateMatched(predicateMatched).build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.copyFromUtf8("122");
    RowFilter predicateFilter = RowFilter.newBuilder().build();
    List<Mutation> trueMutations = new ArrayList<>();
    List<Mutation> falseMutations = new ArrayList<>();

    CheckAndMutateRowResponse actualResponse =
        client.checkAndMutateRow(tableName, rowKey, predicateFilter, trueMutations, falseMutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAndMutateRowRequest actualRequest = (CheckAndMutateRowRequest) actualRequests.get(0);

    Assert.assertEquals(tableName, TableName.parse(actualRequest.getTableName()));
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(predicateFilter, actualRequest.getPredicateFilter());
    Assert.assertEquals(trueMutations, actualRequest.getTrueMutationsList());
    Assert.assertEquals(falseMutations, actualRequest.getFalseMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void checkAndMutateRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.copyFromUtf8("122");
      RowFilter predicateFilter = RowFilter.newBuilder().build();
      List<Mutation> trueMutations = new ArrayList<>();
      List<Mutation> falseMutations = new ArrayList<>();

      client.checkAndMutateRow(tableName, rowKey, predicateFilter, trueMutations, falseMutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void readModifyWriteRowTest() {
    ReadModifyWriteRowResponse expectedResponse = ReadModifyWriteRowResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.copyFromUtf8("122");
    List<ReadModifyWriteRule> rules = new ArrayList<>();

    ReadModifyWriteRowResponse actualResponse = client.readModifyWriteRow(tableName, rowKey, rules);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadModifyWriteRowRequest actualRequest = (ReadModifyWriteRowRequest) actualRequests.get(0);

    Assert.assertEquals(tableName, TableName.parse(actualRequest.getTableName()));
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(rules, actualRequest.getRulesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void readModifyWriteRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.copyFromUtf8("122");
      List<ReadModifyWriteRule> rules = new ArrayList<>();

      client.readModifyWriteRow(tableName, rowKey, rules);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
