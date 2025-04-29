/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.datastore.v1;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationResultBatch;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.ExplainMetrics;
import com.google.datastore.v1.ExplainOptions;
import com.google.datastore.v1.Key;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.Mutation;
import com.google.datastore.v1.MutationResult;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyMask;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.QueryResultBatch;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DatastoreClientTest {
  private static MockDatastore mockDatastore;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DatastoreClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDatastore = new MockDatastore();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockDatastore));
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
    DatastoreSettings settings =
        DatastoreSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DatastoreClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void lookupTest() throws Exception {
    LookupResponse expectedResponse =
        LookupResponse.newBuilder()
            .addAllFound(new ArrayList<EntityResult>())
            .addAllMissing(new ArrayList<EntityResult>())
            .addAllDeferred(new ArrayList<Key>())
            .setTransaction(ByteString.EMPTY)
            .setReadTime(Timestamp.newBuilder().build())
            .build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    ReadOptions readOptions = ReadOptions.newBuilder().build();
    List<Key> keys = new ArrayList<>();

    LookupResponse actualResponse = client.lookup(projectId, readOptions, keys);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    LookupRequest actualRequest = ((LookupRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(readOptions, actualRequest.getReadOptions());
    Assert.assertEquals(keys, actualRequest.getKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void lookupExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      ReadOptions readOptions = ReadOptions.newBuilder().build();
      List<Key> keys = new ArrayList<>();
      client.lookup(projectId, readOptions, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runQueryTest() throws Exception {
    RunQueryResponse expectedResponse =
        RunQueryResponse.newBuilder()
            .setBatch(QueryResultBatch.newBuilder().build())
            .setQuery(Query.newBuilder().build())
            .setTransaction(ByteString.EMPTY)
            .setExplainMetrics(ExplainMetrics.newBuilder().build())
            .build();
    mockDatastore.addResponse(expectedResponse);

    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setDatabaseId("databaseId1688905718")
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setPropertyMask(PropertyMask.newBuilder().build())
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    RunQueryResponse actualResponse = client.runQuery(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunQueryRequest actualRequest = ((RunQueryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getDatabaseId(), actualRequest.getDatabaseId());
    Assert.assertEquals(request.getPartitionId(), actualRequest.getPartitionId());
    Assert.assertEquals(request.getReadOptions(), actualRequest.getReadOptions());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getGqlQuery(), actualRequest.getGqlQuery());
    Assert.assertEquals(request.getPropertyMask(), actualRequest.getPropertyMask());
    Assert.assertEquals(request.getExplainOptions(), actualRequest.getExplainOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      RunQueryRequest request =
          RunQueryRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setDatabaseId("databaseId1688905718")
              .setPartitionId(PartitionId.newBuilder().build())
              .setReadOptions(ReadOptions.newBuilder().build())
              .setPropertyMask(PropertyMask.newBuilder().build())
              .setExplainOptions(ExplainOptions.newBuilder().build())
              .build();
      client.runQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void runAggregationQueryTest() throws Exception {
    RunAggregationQueryResponse expectedResponse =
        RunAggregationQueryResponse.newBuilder()
            .setBatch(AggregationResultBatch.newBuilder().build())
            .setQuery(AggregationQuery.newBuilder().build())
            .setTransaction(ByteString.EMPTY)
            .setExplainMetrics(ExplainMetrics.newBuilder().build())
            .build();
    mockDatastore.addResponse(expectedResponse);

    RunAggregationQueryRequest request =
        RunAggregationQueryRequest.newBuilder()
            .setProjectId("projectId-894832108")
            .setDatabaseId("databaseId1688905718")
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setExplainOptions(ExplainOptions.newBuilder().build())
            .build();

    RunAggregationQueryResponse actualResponse = client.runAggregationQuery(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RunAggregationQueryRequest actualRequest = ((RunAggregationQueryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProjectId(), actualRequest.getProjectId());
    Assert.assertEquals(request.getDatabaseId(), actualRequest.getDatabaseId());
    Assert.assertEquals(request.getPartitionId(), actualRequest.getPartitionId());
    Assert.assertEquals(request.getReadOptions(), actualRequest.getReadOptions());
    Assert.assertEquals(request.getAggregationQuery(), actualRequest.getAggregationQuery());
    Assert.assertEquals(request.getGqlQuery(), actualRequest.getGqlQuery());
    Assert.assertEquals(request.getExplainOptions(), actualRequest.getExplainOptions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void runAggregationQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      RunAggregationQueryRequest request =
          RunAggregationQueryRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .setDatabaseId("databaseId1688905718")
              .setPartitionId(PartitionId.newBuilder().build())
              .setReadOptions(ReadOptions.newBuilder().build())
              .setExplainOptions(ExplainOptions.newBuilder().build())
              .build();
      client.runAggregationQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void beginTransactionTest() throws Exception {
    BeginTransactionResponse expectedResponse =
        BeginTransactionResponse.newBuilder().setTransaction(ByteString.EMPTY).build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";

    BeginTransactionResponse actualResponse = client.beginTransaction(projectId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BeginTransactionRequest actualRequest = ((BeginTransactionRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void beginTransactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      client.beginTransaction(projectId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .addAllMutationResults(new ArrayList<MutationResult>())
            .setIndexUpdates(-1425228195)
            .setCommitTime(Timestamp.newBuilder().build())
            .build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(projectId, mode, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(mode, actualRequest.getMode());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
      List<Mutation> mutations = new ArrayList<>();
      client.commit(projectId, mode, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void commitTest2() throws Exception {
    CommitResponse expectedResponse =
        CommitResponse.newBuilder()
            .addAllMutationResults(new ArrayList<MutationResult>())
            .setIndexUpdates(-1425228195)
            .setCommitTime(Timestamp.newBuilder().build())
            .build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
    ByteString transaction = ByteString.EMPTY;
    List<Mutation> mutations = new ArrayList<>();

    CommitResponse actualResponse = client.commit(projectId, mode, transaction, mutations);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CommitRequest actualRequest = ((CommitRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(mode, actualRequest.getMode());
    Assert.assertEquals(transaction, actualRequest.getTransaction());
    Assert.assertEquals(mutations, actualRequest.getMutationsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void commitExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      CommitRequest.Mode mode = CommitRequest.Mode.forNumber(0);
      ByteString transaction = ByteString.EMPTY;
      List<Mutation> mutations = new ArrayList<>();
      client.commit(projectId, mode, transaction, mutations);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void rollbackTest() throws Exception {
    RollbackResponse expectedResponse = RollbackResponse.newBuilder().build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    ByteString transaction = ByteString.EMPTY;

    RollbackResponse actualResponse = client.rollback(projectId, transaction);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RollbackRequest actualRequest = ((RollbackRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(transaction, actualRequest.getTransaction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void rollbackExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      ByteString transaction = ByteString.EMPTY;
      client.rollback(projectId, transaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void allocateIdsTest() throws Exception {
    AllocateIdsResponse expectedResponse =
        AllocateIdsResponse.newBuilder().addAllKeys(new ArrayList<Key>()).build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    List<Key> keys = new ArrayList<>();

    AllocateIdsResponse actualResponse = client.allocateIds(projectId, keys);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AllocateIdsRequest actualRequest = ((AllocateIdsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(keys, actualRequest.getKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void allocateIdsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      List<Key> keys = new ArrayList<>();
      client.allocateIds(projectId, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reserveIdsTest() throws Exception {
    ReserveIdsResponse expectedResponse = ReserveIdsResponse.newBuilder().build();
    mockDatastore.addResponse(expectedResponse);

    String projectId = "projectId-894832108";
    List<Key> keys = new ArrayList<>();

    ReserveIdsResponse actualResponse = client.reserveIds(projectId, keys);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDatastore.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReserveIdsRequest actualRequest = ((ReserveIdsRequest) actualRequests.get(0));

    Assert.assertEquals(projectId, actualRequest.getProjectId());
    Assert.assertEquals(keys, actualRequest.getKeysList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reserveIdsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDatastore.addException(exception);

    try {
      String projectId = "projectId-894832108";
      List<Key> keys = new ArrayList<>();
      client.reserveIds(projectId, keys);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
