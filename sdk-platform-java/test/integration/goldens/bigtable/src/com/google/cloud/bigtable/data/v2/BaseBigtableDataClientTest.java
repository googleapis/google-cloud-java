/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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
import com.google.bigtable.v2.InstanceName;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadModifyWriteRule;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.RequestStats;
import com.google.bigtable.v2.Row;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.RowSet;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.bigtable.v2.TableName;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class BaseBigtableDataClientTest {
  private static MockBigtable mockBigtable;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BaseBigtableDataClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBigtable = new MockBigtable();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockBigtable));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
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
  public void readRowsTest() throws Exception {
    ReadRowsResponse expectedResponse =
        ReadRowsResponse.newBuilder()
            .addAllChunks(new ArrayList<ReadRowsResponse.CellChunk>())
            .setLastScannedRowKey(ByteString.EMPTY)
            .setRequestStats(RequestStats.newBuilder().build())
            .build();
    mockBigtable.addResponse(expectedResponse);
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder()
            .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
            .setAppProfileId("appProfileId704923523")
            .setRows(RowSet.newBuilder().build())
            .setFilter(RowFilter.newBuilder().build())
            .setRowsLimit(-944199211)
            .build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ReadRowsResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void readRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);
    ReadRowsRequest request =
        ReadRowsRequest.newBuilder()
            .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
            .setAppProfileId("appProfileId704923523")
            .setRows(RowSet.newBuilder().build())
            .setFilter(RowFilter.newBuilder().build())
            .setRowsLimit(-944199211)
            .build();

    MockStreamObserver<ReadRowsResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> callable = client.readRowsCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ReadRowsResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void sampleRowKeysTest() throws Exception {
    SampleRowKeysResponse expectedResponse =
        SampleRowKeysResponse.newBuilder()
            .setRowKey(ByteString.EMPTY)
            .setOffsetBytes(889884095)
            .build();
    mockBigtable.addResponse(expectedResponse);
    SampleRowKeysRequest request =
        SampleRowKeysRequest.newBuilder()
            .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
            .setAppProfileId("appProfileId704923523")
            .build();

    MockStreamObserver<SampleRowKeysResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse> callable =
        client.sampleRowKeysCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<SampleRowKeysResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void sampleRowKeysExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);
    SampleRowKeysRequest request =
        SampleRowKeysRequest.newBuilder()
            .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
            .setAppProfileId("appProfileId704923523")
            .build();

    MockStreamObserver<SampleRowKeysResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse> callable =
        client.sampleRowKeysCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<SampleRowKeysResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void mutateRowTest() throws Exception {
    MutateRowResponse expectedResponse = MutateRowResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    MutateRowResponse actualResponse = client.mutateRow(tableName, rowKey, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MutateRowRequest actualRequest = ((MutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName.toString(), actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mutateRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      client.mutateRow(tableName, rowKey, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mutateRowTest2() throws Exception {
    MutateRowResponse expectedResponse = MutateRowResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    String tableName = "tableName-1988717703";
    ByteString rowKey = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    MutateRowResponse actualResponse = client.mutateRow(tableName, rowKey, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MutateRowRequest actualRequest = ((MutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName, actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mutateRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String tableName = "tableName-1988717703";
      ByteString rowKey = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      client.mutateRow(tableName, rowKey, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mutateRowTest3() throws Exception {
    MutateRowResponse expectedResponse = MutateRowResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();
    String appProfileId = "appProfileId704923523";

    MutateRowResponse actualResponse = client.mutateRow(tableName, rowKey, mutations, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MutateRowRequest actualRequest = ((MutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName.toString(), actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mutateRowExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      String appProfileId = "appProfileId704923523";
      client.mutateRow(tableName, rowKey, mutations, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mutateRowTest4() throws Exception {
    MutateRowResponse expectedResponse = MutateRowResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    String tableName = "tableName-1988717703";
    ByteString rowKey = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();
    String appProfileId = "appProfileId704923523";

    MutateRowResponse actualResponse = client.mutateRow(tableName, rowKey, mutations, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    MutateRowRequest actualRequest = ((MutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName, actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void mutateRowExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String tableName = "tableName-1988717703";
      ByteString rowKey = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      String appProfileId = "appProfileId704923523";
      client.mutateRow(tableName, rowKey, mutations, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void mutateRowsTest() throws Exception {
    MutateRowsResponse expectedResponse =
        MutateRowsResponse.newBuilder()
            .addAllEntries(new ArrayList<MutateRowsResponse.Entry>())
            .build();
    mockBigtable.addResponse(expectedResponse);
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
            .setAppProfileId("appProfileId704923523")
            .addAllEntries(new ArrayList<MutateRowsRequest.Entry>())
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
  public void mutateRowsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);
    MutateRowsRequest request =
        MutateRowsRequest.newBuilder()
            .setTableName(TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]").toString())
            .setAppProfileId("appProfileId704923523")
            .addAllEntries(new ArrayList<MutateRowsRequest.Entry>())
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
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void checkAndMutateRowTest() throws Exception {
    CheckAndMutateRowResponse expectedResponse =
        CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.EMPTY;
    RowFilter predicateFilter = RowFilter.newBuilder().build();
    List<Mutation> trueMutations = new ArrayList<>();
    List<Mutation> falseMutations = new ArrayList<>();

    CheckAndMutateRowResponse actualResponse =
        client.checkAndMutateRow(tableName, rowKey, predicateFilter, trueMutations, falseMutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAndMutateRowRequest actualRequest = ((CheckAndMutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName.toString(), actualRequest.getTableName());
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
  public void checkAndMutateRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      RowFilter predicateFilter = RowFilter.newBuilder().build();
      List<Mutation> trueMutations = new ArrayList<>();
      List<Mutation> falseMutations = new ArrayList<>();
      client.checkAndMutateRow(tableName, rowKey, predicateFilter, trueMutations, falseMutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAndMutateRowTest2() throws Exception {
    CheckAndMutateRowResponse expectedResponse =
        CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build();
    mockBigtable.addResponse(expectedResponse);

    String tableName = "tableName-1988717703";
    ByteString rowKey = ByteString.EMPTY;
    RowFilter predicateFilter = RowFilter.newBuilder().build();
    List<Mutation> trueMutations = new ArrayList<>();
    List<Mutation> falseMutations = new ArrayList<>();

    CheckAndMutateRowResponse actualResponse =
        client.checkAndMutateRow(tableName, rowKey, predicateFilter, trueMutations, falseMutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAndMutateRowRequest actualRequest = ((CheckAndMutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName, actualRequest.getTableName());
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
  public void checkAndMutateRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String tableName = "tableName-1988717703";
      ByteString rowKey = ByteString.EMPTY;
      RowFilter predicateFilter = RowFilter.newBuilder().build();
      List<Mutation> trueMutations = new ArrayList<>();
      List<Mutation> falseMutations = new ArrayList<>();
      client.checkAndMutateRow(tableName, rowKey, predicateFilter, trueMutations, falseMutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAndMutateRowTest3() throws Exception {
    CheckAndMutateRowResponse expectedResponse =
        CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.EMPTY;
    RowFilter predicateFilter = RowFilter.newBuilder().build();
    List<Mutation> trueMutations = new ArrayList<>();
    List<Mutation> falseMutations = new ArrayList<>();
    String appProfileId = "appProfileId704923523";

    CheckAndMutateRowResponse actualResponse =
        client.checkAndMutateRow(
            tableName, rowKey, predicateFilter, trueMutations, falseMutations, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAndMutateRowRequest actualRequest = ((CheckAndMutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName.toString(), actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(predicateFilter, actualRequest.getPredicateFilter());
    Assert.assertEquals(trueMutations, actualRequest.getTrueMutationsList());
    Assert.assertEquals(falseMutations, actualRequest.getFalseMutationsList());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkAndMutateRowExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      RowFilter predicateFilter = RowFilter.newBuilder().build();
      List<Mutation> trueMutations = new ArrayList<>();
      List<Mutation> falseMutations = new ArrayList<>();
      String appProfileId = "appProfileId704923523";
      client.checkAndMutateRow(
          tableName, rowKey, predicateFilter, trueMutations, falseMutations, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void checkAndMutateRowTest4() throws Exception {
    CheckAndMutateRowResponse expectedResponse =
        CheckAndMutateRowResponse.newBuilder().setPredicateMatched(true).build();
    mockBigtable.addResponse(expectedResponse);

    String tableName = "tableName-1988717703";
    ByteString rowKey = ByteString.EMPTY;
    RowFilter predicateFilter = RowFilter.newBuilder().build();
    List<Mutation> trueMutations = new ArrayList<>();
    List<Mutation> falseMutations = new ArrayList<>();
    String appProfileId = "appProfileId704923523";

    CheckAndMutateRowResponse actualResponse =
        client.checkAndMutateRow(
            tableName, rowKey, predicateFilter, trueMutations, falseMutations, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CheckAndMutateRowRequest actualRequest = ((CheckAndMutateRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName, actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(predicateFilter, actualRequest.getPredicateFilter());
    Assert.assertEquals(trueMutations, actualRequest.getTrueMutationsList());
    Assert.assertEquals(falseMutations, actualRequest.getFalseMutationsList());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void checkAndMutateRowExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String tableName = "tableName-1988717703";
      ByteString rowKey = ByteString.EMPTY;
      RowFilter predicateFilter = RowFilter.newBuilder().build();
      List<Mutation> trueMutations = new ArrayList<>();
      List<Mutation> falseMutations = new ArrayList<>();
      String appProfileId = "appProfileId704923523";
      client.checkAndMutateRow(
          tableName, rowKey, predicateFilter, trueMutations, falseMutations, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pingAndWarmTest() throws Exception {
    PingAndWarmResponse expectedResponse = PingAndWarmResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");

    PingAndWarmResponse actualResponse = client.pingAndWarm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PingAndWarmRequest actualRequest = ((PingAndWarmRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pingAndWarmExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
      client.pingAndWarm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pingAndWarmTest2() throws Exception {
    PingAndWarmResponse expectedResponse = PingAndWarmResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    String name = "name3373707";

    PingAndWarmResponse actualResponse = client.pingAndWarm(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PingAndWarmRequest actualRequest = ((PingAndWarmRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pingAndWarmExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String name = "name3373707";
      client.pingAndWarm(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pingAndWarmTest3() throws Exception {
    PingAndWarmResponse expectedResponse = PingAndWarmResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
    String appProfileId = "appProfileId704923523";

    PingAndWarmResponse actualResponse = client.pingAndWarm(name, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PingAndWarmRequest actualRequest = ((PingAndWarmRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pingAndWarmExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      InstanceName name = InstanceName.of("[PROJECT]", "[INSTANCE]");
      String appProfileId = "appProfileId704923523";
      client.pingAndWarm(name, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pingAndWarmTest4() throws Exception {
    PingAndWarmResponse expectedResponse = PingAndWarmResponse.newBuilder().build();
    mockBigtable.addResponse(expectedResponse);

    String name = "name3373707";
    String appProfileId = "appProfileId704923523";

    PingAndWarmResponse actualResponse = client.pingAndWarm(name, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PingAndWarmRequest actualRequest = ((PingAndWarmRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void pingAndWarmExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String name = "name3373707";
      String appProfileId = "appProfileId704923523";
      client.pingAndWarm(name, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readModifyWriteRowTest() throws Exception {
    ReadModifyWriteRowResponse expectedResponse =
        ReadModifyWriteRowResponse.newBuilder().setRow(Row.newBuilder().build()).build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.EMPTY;
    List<ReadModifyWriteRule> rules = new ArrayList<>();

    ReadModifyWriteRowResponse actualResponse = client.readModifyWriteRow(tableName, rowKey, rules);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadModifyWriteRowRequest actualRequest = ((ReadModifyWriteRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName.toString(), actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(rules, actualRequest.getRulesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readModifyWriteRowExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      List<ReadModifyWriteRule> rules = new ArrayList<>();
      client.readModifyWriteRow(tableName, rowKey, rules);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readModifyWriteRowTest2() throws Exception {
    ReadModifyWriteRowResponse expectedResponse =
        ReadModifyWriteRowResponse.newBuilder().setRow(Row.newBuilder().build()).build();
    mockBigtable.addResponse(expectedResponse);

    String tableName = "tableName-1988717703";
    ByteString rowKey = ByteString.EMPTY;
    List<ReadModifyWriteRule> rules = new ArrayList<>();

    ReadModifyWriteRowResponse actualResponse = client.readModifyWriteRow(tableName, rowKey, rules);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadModifyWriteRowRequest actualRequest = ((ReadModifyWriteRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName, actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(rules, actualRequest.getRulesList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readModifyWriteRowExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String tableName = "tableName-1988717703";
      ByteString rowKey = ByteString.EMPTY;
      List<ReadModifyWriteRule> rules = new ArrayList<>();
      client.readModifyWriteRow(tableName, rowKey, rules);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readModifyWriteRowTest3() throws Exception {
    ReadModifyWriteRowResponse expectedResponse =
        ReadModifyWriteRowResponse.newBuilder().setRow(Row.newBuilder().build()).build();
    mockBigtable.addResponse(expectedResponse);

    TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
    ByteString rowKey = ByteString.EMPTY;
    List<ReadModifyWriteRule> rules = new ArrayList<>();
    String appProfileId = "appProfileId704923523";

    ReadModifyWriteRowResponse actualResponse =
        client.readModifyWriteRow(tableName, rowKey, rules, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadModifyWriteRowRequest actualRequest = ((ReadModifyWriteRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName.toString(), actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(rules, actualRequest.getRulesList());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readModifyWriteRowExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      TableName tableName = TableName.of("[PROJECT]", "[INSTANCE]", "[TABLE]");
      ByteString rowKey = ByteString.EMPTY;
      List<ReadModifyWriteRule> rules = new ArrayList<>();
      String appProfileId = "appProfileId704923523";
      client.readModifyWriteRow(tableName, rowKey, rules, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void readModifyWriteRowTest4() throws Exception {
    ReadModifyWriteRowResponse expectedResponse =
        ReadModifyWriteRowResponse.newBuilder().setRow(Row.newBuilder().build()).build();
    mockBigtable.addResponse(expectedResponse);

    String tableName = "tableName-1988717703";
    ByteString rowKey = ByteString.EMPTY;
    List<ReadModifyWriteRule> rules = new ArrayList<>();
    String appProfileId = "appProfileId704923523";

    ReadModifyWriteRowResponse actualResponse =
        client.readModifyWriteRow(tableName, rowKey, rules, appProfileId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBigtable.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReadModifyWriteRowRequest actualRequest = ((ReadModifyWriteRowRequest) actualRequests.get(0));

    Assert.assertEquals(tableName, actualRequest.getTableName());
    Assert.assertEquals(rowKey, actualRequest.getRowKey());
    Assert.assertEquals(rules, actualRequest.getRulesList());
    Assert.assertEquals(appProfileId, actualRequest.getAppProfileId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void readModifyWriteRowExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBigtable.addException(exception);

    try {
      String tableName = "tableName-1988717703";
      ByteString rowKey = ByteString.EMPTY;
      List<ReadModifyWriteRule> rules = new ArrayList<>();
      String appProfileId = "appProfileId704923523";
      client.readModifyWriteRow(tableName, rowKey, rules, appProfileId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
